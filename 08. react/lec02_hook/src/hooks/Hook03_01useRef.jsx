import React, { useRef, useState } from 'react';

// useRef
// 1. 저장공간. 이 공간에 저장된 값은 랜더딩이 되어도 값이 유지가 된다.
// 2. DOM요소에 접근할 수 있도록 한다. ex) 로그인화면에 userId에 focus()로 자동접근
const Hook03_01useRef = () => {
  
  const [count, setCount] = useState(0);
  const countRef = useRef(0); // current속성에 0으로 초기화

  console.log(`${count} 상태가 변경될 때마다 랜더링 ~~~~~ `);
  console.log(countRef); // .current속성을 확인
  
  const increaseCount = () => {
    setCount(count + 1);
  }

  const increaseCountRef = () => {
    countRef.current = countRef.current + 1;
    console.log(`countRef.current 값 = `, countRef.current);
    
  }

  return (
    <div>
      <p>Count : {count}</p>
      <p>CountRef : {countRef.current}</p>
      <button onClick={increaseCount}>더하기</button>{'   '}
      <button onClick={increaseCountRef}>더하기(Ref)</button>{'   '}
    </div>
  );
};

export default Hook03_01useRef;