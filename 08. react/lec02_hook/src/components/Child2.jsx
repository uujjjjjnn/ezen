import React, { memo } from 'react';

const Child2 = ({name}) => {
  console.log(`자녀 컴퍼넌트가 랜더링 되었습니다`);

  return (
    <div style={{border:'2px solid navy', padding:'10px'}}>
      <h3>자녀</h3>
      <p>성 : {name.lastname}</p>
      <p>이름 : {name.firstname}</p>
    </div>
  );
};

export default memo(Child2);