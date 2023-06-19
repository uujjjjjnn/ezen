import React, { useState } from 'react';
import { useInput } from '../customhooks/useInput';

// input을 처리하는 Custom Hook을 만들어서 중복코딩을 방지
// useInput이라는 Custom Hook을 생성
function displayMessage(message) {
  alert(message);
}

const Hook09_01customHook = () => {

  // 1. useInput 적용 전
  // const [inputValue, setInputValue] = useState('');
  // const handleChange = (e) => {
  //   setInputValue(e.target.value);
  // }
  // const handleSubmit = () => {
  //   alert(inputValue);
  //   setInputValue('');
  // }
  // const [inputValue2, setInputValue2] = useState('');
  // const handleChange2 = (e) => {
  //   setInputValue2(e.target.value);
  // }
  // const handleSubmit2 = () => {
  //   alert(inputValue2);
  //   setInputValue2('');
  // }

  // 2. useInput 적용 후
  // const [inputValue, setInputValue] = useInput('안녕하세용?');
  // const [inputValue2, setInputValue2] = useInput('반갑습니당');
  
  const [inputValue, handleChange, handleSubmit] = useInput('', displayMessage);
  return (
    <div>
      <h1>useInput(Custom Hook)</h1>

      <input type="text" value={inputValue} onChange={handleChange} />{' '}
      <button onClick={handleSubmit}>확인</button><br />
      {/* <input type="text" value={inputValue2} onChange={handleChange2} />{' '}
      <button onClick={handleSubmit2}>확인</button> */}
    </div>
  );
};

export default Hook09_01customHook;