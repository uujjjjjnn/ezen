import React from 'react';

// 1. Context 적용 전



const Header = ({isDark}) => {
  return (
    <header
      className='header'
      style={{
        backgroundColor : isDark ? 'black' : 'lightgray',
        color : isDark ? 'white' : 'black'
      }}
      >
      <h1>Welcome!~!</h1>
    </header>
  );
};

// 2. Context 적용 후


export default Header;