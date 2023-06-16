import React, {useState, useMemo} from 'react';

// 컴퍼넌트최적화 : useMemo, useCallback
// useMemo : 동일한 값(Memoization)을 리턴
// 함수형컴퍼넌트 : 랜더링 -> 함수 호출 -> 컴퍼넌트의 내부의 모든 변수가 초기화
// 대부분의 컴퍼넌트는 state, props가 변경이 되면 랜더링된다.

function calculate () { return "엄청나게 무거운 작업!!!!!!!!"}
const heavyCalculate = (number) => {
  console.log(`짱 시간 오래 걸리는 계산 작업`);
  for(let i=0;i<=999999;i++) {}
  return number + 10000;
}
const easyCalculate = (number) => {
  console.log(`엄청 쉬운 계산 작업`);
  return number + 1;
}
const Hook04_01useMemo = () => {
  
  const value = calculate(); // ajax, fetch, axios 비동기처리
  //console.log(`엄청나게 무거운 작업 결과 = ${value}`);
  
  const [heavyNumber, setHeavyNumner] = useState(1);
  const [easyNumber, setEasyNumner] = useState(1);

  // const heavySum = heavyCalculate(heavyNumber);
  const heavySum = useMemo(() => {
    return heavyCalculate(heavyNumber)
  }, [heavyNumber])
  
  const easySum = easyCalculate(easyNumber);
  return (
    <div>
      <h3>엄청 무거운 작업!</h3>
      <input 
        type="number" 
        value={heavyNumber}
        onChange={(e) => setHeavyNumner(parseInt(e.target.value))}
      />
      <span> + 10000 = {heavySum}</span>
      <hr />
      <h3>엄청 가벼운 계산</h3>
      <input 
        type="number" 
        value={easyNumber}
        onChange={(e) => setEasyNumner(parseInt(e.target.value))}
      />
      <span> + 1 = {easySum}</span>      
    </div>
  );
};

export default Hook04_01useMemo;