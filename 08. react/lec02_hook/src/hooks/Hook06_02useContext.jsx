import React, { useContext, useState } from 'react';
import Page from '../pages/Page';
import { ThemeContext } from '../context/ThemeContext';
import { UserContext } from '../context/UserContext';

const Hook06_02useContext = () => {

  const [isDark, setIsDark] = useState(false);

  const data = useContext(ThemeContext);
  console.log(`data : ${data}`);
  
  return (
    <div>
      <UserContext.Provider value={"홍길동"}>
      <ThemeContext.Provider value={{isDark, setIsDark}}>
      <Page />
      </ThemeContext.Provider>
      </UserContext.Provider>
    </div>
  );
};

export default Hook06_02useContext;