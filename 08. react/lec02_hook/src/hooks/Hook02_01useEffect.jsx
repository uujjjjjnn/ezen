import React from 'react';
import { useEffect } from "react";
import { useState } from "react";

const Hook02_01useEffect = () => {

  const [count, setCount] = useState(0);
  const [name, setName] = useState("");

  const onIncrease = () => {
    setCount(count + 1);
  }
  const changeName = (e) => {
    setName(e.target.value);
  }

  // useEffecr(함수, [의존성배열])
  useEffect(() => {
    // console.log(`엄청 무거운 작업`);
  })

  useEffect(() => {
    console.log(`==> 컴퍼넌트가 랜더링(마운트)될 때 한번만 실행`);
  }, [])

  useEffect(() => {
    console.log(`==> count(${count})의 상태가 변경될 때마다 실행`);
  }, [count])

  useEffect(() => {
    console.log(`==> count(${name})의 상태가 변경될 때마다 실행`);
  }, [name])

  useEffect(() => {
    console.log(`==> count(${count} or 이름(${name})의 상태가 변경될 때마다 실행`);
  }, [count, name])


  return (
    <div>
      <button onClick={onIncrease}>증가</button>{' '}
      <span>count : {count}</span>
      <hr />
      <input type="text" onClick={changeName} />{' '}
      <p>이름 : {name}</p>
    </div>
  );
};

export default Hook02_01useEffect;