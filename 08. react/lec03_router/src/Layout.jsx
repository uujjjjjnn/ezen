import React from 'react';
import { Outlet, useNavigate } from 'react-router-dom';

const Layout = () => {

  const navigate = useNavigate();

  const goBack = () => {
    navigate(-1); // 이전페이지
  }

  const goArticles = () => {
    navigate('/articles');
  }

  return (
    <div>
      <header style={{backgroundColor:'mediumseagreen', padding: '16px', margin: '10px', color:'white', fontSize:'24px'}}>
        공통레이아웃
        <div>
          <button onClick={goBack}>뒤로가기</button>
          <button onClick={goArticles}>게시글목록</button>
        </div>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
};

export default Layout;