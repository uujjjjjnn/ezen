import React from 'react';

const Member = ({name, dispatch, id, isMember}) => {

  
  return (
    <div>
      <span
        style={{
          textDecoration: isMember ? 'none' : 'line-through',
          color: isMember ? 'black' : 'lightgray'
        }}
        onClick={() => {
          dispatch({type: 'widthdraw', payload: {id}})
        }}
      >
        {name}
      </span>{' '}
      <button onClick={() => {
        dispatch({type: 'del', payload:{id}})
      }}>삭제</button>{' '}
      <button onClick={() => {
        dispatch({type: 'withdraw', payload:{id}})
      }}>탈퇴</button>
    </div>
  );
};

export default Member;