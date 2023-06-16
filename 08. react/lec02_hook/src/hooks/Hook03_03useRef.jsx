import React, {useRef, useEffect, useState} from 'react';

const Hook03_03useRef = () => {

  const [count, setCount] = useState(1);
  // const [renderCount, setRenderCount] = useState(1); // 무한반복에러
  const renderCount = useRef(0);

  useEffect(() => {
    // console.log(`========================`);
    // setRenderCount(renderCount + 1); 
    renderCount.current = renderCount.current + 1;
    console.log(`랜더링횟수 = ${renderCount.current}`);
    
  })

  return (
    <div>
      <p>Count : {count}</p>
      <button onClick={() => setCount(count + 1)}>숫자올리기</button>
    </div>
  );
};

export default Hook03_03useRef;