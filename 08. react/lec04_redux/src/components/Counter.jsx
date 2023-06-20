import React from 'react';

// 리덕스를 작성할 때 가장 많이 사용하는 패턴은 Duck패턴
// duck패턴 프레젠테이션 컴퍼넌트와 컨테이너 컴퍼넌트를 분리해서 작성하는 패턴
// 1) 프레젠테이션 컴퍼넌트 - 상태관리를 하지 않고 props를 전달받아서 화면에 UI만 보여주는 컴퍼넌트
// 2) 컨테이너 컴퍼넌트 - 리덕스와 연동해서 리덕스로부터 상태를 전달받거나 redux store에 액션을 디스패치
const Counter = ({number, onIncrease, onDecrease}) => {
  return (
    <div>
      <h1>{number}</h1>
      <div>
        <button onClick={onIncrease}>+1</button>{' '}
        <button onClick={onDecrease}>-1</button>
      </div>
    </div>
  );
};

export default Counter;