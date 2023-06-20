import React from 'react';
import { useState, useEffect } from 'react';
import axios from 'axios';

const BASE_URL = 'http://localhost:4000/api/todo';
const AppAxios = () => {

  const [todoList, setTodoList] = useState(null);

  // 1. async, await 미사용 : 동기방식
  // const fetchData = () => {
  //   axios.get(BASE_URL).then(res => setTodoList(res))
  // }


  // 2. async, await 사용 : 비동기방식
  const fetchData = async() => {
    const res = await axios.get(BASE_URL);
    setTodoList(res.data);
  }

  useEffect(() => {
    fetchData();
  }, [todoList])

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const text = e.target.text.value;
    const done = e.target.done.checked;

    // axios는 headers에 Content-Type등의 정보를 자동으로 처리해 준다.
    axios.post(BASE_URL, {text, done})

    e.target.text.value = '';
    e.target.done.checked = false;
    e.target.text.focus();
  }

  return (
    <div>
      <h1>Todo List</h1>
      <form onSubmit={onSubmitHandler}>
        <input type="text" name="text" />
        <input type="checkbox" name="done" />
        <input type="submit" value="추가"/>
      </form>
      <hr />
      <table border={"1"}>
        <thead>
          <tr>
            <th>id</th>
            <th>text</th>
            <th>done</th>
          </tr>
        </thead>
        <tbody>
          {todoList?.map(todo => (
            <tr key={todo.id}>
              <td>{todo.id}</td>
              <td>{todo.text}</td>
              <td>{todo.done ? 'done!!' : 'not yet!!'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AppAxios;