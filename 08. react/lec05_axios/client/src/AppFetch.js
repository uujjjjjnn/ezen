import React from 'react';
import { useState, useEffect } from 'react';

// cors(Cross Origin Resource Sharing)에러
// naver.com에서 google.com 서버에 있는 자료를 제한없이 접근할 수 있다면 많은 문제가 발생될 것이다.
// 따라서, 대부분의 사이트에서는 외부에서 Origin이 아닌 요청을 근본적으로 막아 외부접근을 막는다.
// 3000에서 4000에 접근한다는 것은 origin이 다르다는 것이다. 
// origin이 다를 경우에 서버에 접근이 가능하도록 cors에러를 허용해야 한다.
// (참고 : https://www.npmjs.com/package/cors) 
// 서버에 cors패키지를 설치해서 cors에러를 허용해야 한다.
const AppFetch = () => {

  const [todoList, setTodoList] = useState(null);

  const fetchData = () => {
    fetch('http://localhost:4000/api/todo')
      .then(res => res.json())
      .then(res => setTodoList(res)
    )
  }

  useEffect(() => {
    fetchData();
  }, [todoList])


  const onSubmitHandler = (e) => {
    e.preventDefault();
    const text = e.target.text.value;
    const done = e.target.done.checked;
    fetch('http://localhost:4000/api/todo', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({text, done})
    }).then(fetchData());
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

export default AppFetch;