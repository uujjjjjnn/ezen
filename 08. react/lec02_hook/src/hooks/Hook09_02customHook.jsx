import React from 'react';
import { useEffect, useState } from 'react';
import { useFetch } from './../customhooks/useFetch';

const baseUrl = 'https://jsonplaceholder.typicode.com/';

const Hook09_02customHook = () => {
// 1. useFetch 커스텀훅 적용 전
  // const [data, setData] = useState('');

  // const fetchUrl = (type) => {
  //   fetch(baseUrl + type)
  //     .then(res => res.json())
  //     // .then(res => console.log(res));
  //     .then(res => setData(res));
  // }
  // useEffect(() => {
  //   fetchUrl('posts')
  // }, []);


// 2. useFetch 커스텀훅 적용 후
  const {data, fetchUrl} = useFetch(baseUrl, 'users');

  return (
    <div>
      <h1>useFetch( Custom Hook )</h1>
      <button onClick={() => fetchUrl('users')}>Users</button>{' '}
      <button onClick={() => fetchUrl('posts')}>posts</button>{' '}
      <button onClick={() => fetchUrl('todos')}>Todos</button>{' '}
      <pre>{JSON.stringify(data, null, 2)}</pre>
    </div>
  );
};

export default Hook09_02customHook;