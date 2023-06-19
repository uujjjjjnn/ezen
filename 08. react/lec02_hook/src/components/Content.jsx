import React, { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';
import { UserContext } from '../context/UserContext';

// 1. Context 적용전
// const Content = ({isDark})  => {
//   return (
//     <header
//       className='header'
//       style={{
//         backgroundColor: isDark ? 'black' : 'lighgray',
//         color: isDark ? 'white' : 'black'
//       }}
//     >
//       <p>환영합니다!! 좋은 하루 되세요!!!!</p>
//     </header>
//   );
// };

// 2. Context 적용후
const Content = () => {
const {isDark} = useContext(ThemeContext);
const userName = useContext(UserContext);

return (
  <header
    className='header'
    style={{
      backgroundColor : isDark ? 'black' : 'lightgray',
      color : isDark ? 'white' : 'black'
    }}
    >
    <p>{userName}님 환영합니다!! 좋은 하루 되세요!!!!</p>
  </header>
);
};
export default Content;