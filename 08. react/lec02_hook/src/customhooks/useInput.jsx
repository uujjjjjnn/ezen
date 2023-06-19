import React, { useState } from 'react';

// 1. handleSubmit 적용 전
// export function useInput(initialValue) {

//   const [inputlValue, setInputValue] = useState(initialValue);

//   const handleChange = (e) => {
//     setInputValue(e.target.value);
//   }
    
//   return [inputValue, handleChange] 
// };

// 2. handleSubmit 적용 후
export function useInput(initialValue, submitAction) {

  const [inputValue, setInputValue] = useState(initialValue);

  const handleChange = (e) => {
    setInputValue(e.target.value);
  }

  const handleSubmit = () => {
    submitAction(inputValue);
    setInputValue('');
  }    
  return [inputValue, handleChange, handleSubmit] 
};
// export function useInput(initialValue, submitAction) {
//   return 
// };