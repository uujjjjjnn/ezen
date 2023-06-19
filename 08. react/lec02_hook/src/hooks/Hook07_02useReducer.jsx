import React, { useReducer, useState } from 'react';
import Member from '../components/Member';

const initialState = {
  count: 0,
  members: [
    // {id: Date.now(), name: '홍길동', isMember: true},
    // {id: Date.now(), name: '손흥민', isMember: false}
  ]
}
// const ACTION_TYPES = {
//   add : 'ADD',
//   del : 'DEL'
// }
const reducer = (state, action) => {
  switch(action.type) {
    case 'add': 
      const name = action.payload.name;
      const newMember = {id: Date.now(), name, isMember: true}; // 키와 값이 같으면 생략 가능 (name:name)
      return {
        count : state.count + 1,
        members : [newMember, ...state.members]
      };
    case 'del': 
      return {
        count : state.count - 1,
        members : state.members.filter(member => member.id !== action.payload.id)
      };
    case 'withdraw': 
      return {
        count : state.count,
        members : state.members.map(member => {
          if(member.id === action.payload.id) {
            return {...member, isMember:!member.isMember}
          }
          return member;
        })
      };
    default : return state;
  }
}

const Hook07_02useReducer = () => {

  const [name, setName] = useState('');
  const [memberList, dispatch] = useReducer(reducer, initialState);
  return (
    <div>
      <h3>회원관리</h3>
      <p>총 회원 수 : {memberList.count} 명</p>
      <input 
        type="text" 
        placeholder='회원 이름을 입력하세용'
        value={name}  
        onChange={e => setName(e.target.value)}
      />{' '}
      <button onClick={() => {
        dispatch({type: 'add', payload: {name}})
      }}>회원등록</button><br /><br />

      {memberList.members.map(member => {
        return (
          <Member 
            key={member.id}
            name={member.name}
            dispatch={dispatch}
            id={member.id}
            isMember={member.isMember}
          />
        )
      })}

    </div>
  );
};

export default Hook07_02useReducer;