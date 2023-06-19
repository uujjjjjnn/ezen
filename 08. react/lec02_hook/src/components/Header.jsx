import React, { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';
import { UserContext } from '../context/UserContext';

// 1. Context 적용 전
// const Header = ({isDark}) => {
//   return (
//     <header
//       className='header'
//       style={{
//         backgroundColor : isDark ? 'black' : 'lightgray',
//         color : isDark ? 'white' : 'black'
//       }}
//       >
//       <h1>Welcome!~!</h1>
//     </header>
//   );
// };

// 2. Context 적용 후
const Header = () => {
  
  const {isDark} = useContext(ThemeContext);
  const userName = useContext(UserContext);
  console.log(`${isDark}, ${userName}`);
  
  return (
    <header
      className='header'
      style={{
        backgroundColor : isDark ? 'black' : 'lightgray',
        color : isDark ? 'white' : 'black'
      }}
      >
      <h1>Welcome {userName} ~! </h1>
    </header>
  );
};

export default Header;