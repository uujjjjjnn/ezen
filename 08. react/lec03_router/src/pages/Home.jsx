import React from 'react';
import {Link} from 'react-router-dom';


const Home = () => {
  return (
    <div>
      <h1>Home</h1>
      <p>Home Page입니다!</p>
      <ul>
        <li><Link to='/about'>소개페이지</Link></li>
        <li><Link to='/profiles/sonny'>손흥민페이지</Link></li>
        <li><Link to='/profiles/kangin'>이강인페이지</Link></li>
        <li><Link to='/profiles/void'>존재하지 않는 페이지</Link></li>
        <li><Link to='/articles'>게시글목록</Link></li>
      </ul>
    </div>
  );
};

export default Home;