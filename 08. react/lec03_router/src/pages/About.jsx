import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';

const About = () => {

  const location = useLocation();
  const [searchParams, setSearchParams] = useSearchParams();
  let detail = searchParams.get('detail'); // ?detail=xxx
  const mode = searchParams.get('mode');

  const onToggleDetail = () => {
    setSearchParams({mode, detail: detail='true' ? false : true});
  }

  const onIncreaseMode = () => {
    const nextMode = mode === null ? 1 : parseInt(mode) + 1;
    setSearchParams({mode: nextMode, detail})
  }
  return (
    <div>
      <h1>About</h1>
      <p>About Page입니다</p>
      <p>쿼리스트링 : {location.search}</p>
      <p>detail : {detail}</p>
      <p>mode : {mode}</p>
      <button onClick={onToggleDetail}>Toggle Detail</button>
      <button onClick={onIncreaseMode}>mode + 1</button>
    </div>
  );
};

export default About;