import React, { useReducer, useState } from 'react';

// useReducer는 useState처럼 상태를 관리하는 Hook이다. 즉, 상태변화 시 랜더링하는데 
// 복잡한 state를 다뤄야 할 경우, useState나 useContext를 사용하는 것보다 효과적이다.
// useReducer는 Reducer, Dispatch, Action 3가지 속성으로 구성
// 예) 은행에 출금할 경우 최종적으로 은행이 거래내역을 대신에 수정
// 출금요청(dispatch) -> 이 dispatch안에는 action -> 실제 처리해주는 Reducer(은행)가 수행
// dispatch -> action -> reducer -> state
// Dispatch(Action) -> Reducer(State, Action)

const ACTION_TYPES = {
  deposit: 'DEPOSIT',
  withdraw: 'WITHDRAW'
}
// state = money
const reducer = (state, action) => {
  // 입금(deposit)과 출금(ACTION_TYPES.withdraw)처리
  console.log(`reduce가 실행됩니다`, state, action);

  switch(action.type) {
    case ACTION_TYPES.deposit :
      return state + action.payload;
    case ACTION_TYPES.withdraw :
      return state - action.payload;
    default :
      return state;
  }
}

const Hook07_01useReducer = () => {

  const [balance, setBalance] = useState(0);
  // money는 reducer의 state이다. 이 state(즉, money)는 reducer를 통해서만 수정이 가능
  const [money, dispatch] = useReducer(reducer, 0);
  return (
    <div>
      <h2>Reducer은행에 오신 것을 환영합니당</h2>
      <p>잔액 : {money}</p>
      <input 
        type="number"
        value={balance}
        onChange={e => setBalance(parseInt(e.target.value))}
        step="1000"
        />{'  '}
        <button onClick={() => {dispatch({type: ACTION_TYPES.deposit, payload: balance})}}>입금</button>{' '}
        <button onClick={() => {dispatch({type: ACTION_TYPES.withdraw, payload: balance})}}>출금</button>
    </div>
  );
};

export default Hook07_01useReducer;