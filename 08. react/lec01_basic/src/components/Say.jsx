import React, { useState } from 'react';

const Say = () => {

  
  const [message, setMessage] = useState('환영합니다!');

  const onClickEnter = () => {
    setMessage('안녕하세용? 어서오세용!~!');
  }
  const onClickLeave = () => {
    setMessage('수고하셨습니다! 안녕히가세용');
  }

  const [color, setColor] = useState('black');

  return (
    <div>
      <button onClick={onClickEnter}>입실</button>{ ' ' }
      <button onClick={onClickLeave}>퇴실</button>{ ' ' }
      <h1 style={{ color }}>{message}</h1>
      {/* <h1>안녕하세용? 어서오세용</h1>
      <h1>수고하셨습니다! 안녕히가세용</h1> */}
      <button style={{color:'red'}} onClick={() => setColor('red')}>빨강</button> { ' ' }
      <button style={{color:'blue'}} onClick={() => setColor('blue')} >파랑</button> { ' ' }
      <button style={{color:'green'}} onClick={() => setColor('green')} >초록</button> { ' ' }
      
    </div>
  );
};

export default Say;