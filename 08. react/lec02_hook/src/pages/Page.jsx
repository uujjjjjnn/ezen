import React, { useContext } from 'react';
import './page.css'
import Header from './../components/Header';
import Content from './../components/Content';
import Footer from './../components/Footer';
import { ThemeContext } from '../context/ThemeContext';

// 1. Context 적용 전
// const Page = ({isDark, setIsDark}) => {
//   return (
//     <div className='page'>
//       <Header isDark={isDark}/>
//       <Content isDark={isDark} />
//       <Footer isDark={isDark} setIsDark={setIsDark}/>      
//     </div>
//   );
// };


// 2. Context 적용 후
const Page = () => {

  const data = useContext(ThemeContext);
  console.log(`data : ${data}`);
  
  return (
    <div className='page'>
      <Header/>
      <Content/>
      <Footer/>   
    </div>
  );  
}

export default Page;