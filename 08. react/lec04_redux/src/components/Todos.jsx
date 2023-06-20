import React from 'react';

const TodoItem = ({ todo, onToggle, onRemove }) => {
  return (
    <div>
      <input type="checkbox" 
        onClick={() => onToggle(todo.id)}
        checked={todo.done}
        readOnly={true}
      />
      <span style={{textDecoration: todo.done ? 'line-through' : 'none'}}>{todo.text}</span>
      <button onClick={() => onRemove(todo.id)}>삭제</button>
    </div>
  );
};

const Todos = ({
  input,  // 입력한 텍스트
  todos,  // TodoItem들이 저장된 객체
  onChangeInput,
  onInsert,
  onToggle,
  onRemove,
}) => {
  
  const onSubmit = (e) => {
    e.preventDefault();
    onInsert(input);
    onChangeInput('');
  }

  const onChange = e => onChangeInput(e.target.value);

  return (
    <div>
      <form onSubmit={onSubmit}>
        <input type="text" value={input} onChange={onChange}/>{'  '}
        <button type="submit">할일 등록</button>
        <br />
      </form>
      <div>
        {
          todos.map(todo => (
            <TodoItem 
              key={todo.id}
              todo={todo}
              onToggle={onToggle}
              onRemove={onRemove}
            />
          ))
        }
      </div>
    </div>
  );
}
export default Todos;