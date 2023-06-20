import {createAction, handleActions } from 'redux-actions';

// 1. 액션타입
const CHANGE_INPUT = 'todos/CHANGE_INPUT';
const INSERT = 'todos/INSERT';
const TOGGLE = 'todos/TOGGLE';
const REMOVE = 'todos/REMOVE';

// 2. 액션생성함수
// export const changeInput = input => ({
//   type: CHANGE_INPUT,
//   input
// });

// let id = 3;  // insert호출될 때 마다 1씩 더하기
// export const insert = (text) => ({
//   type: INSERT,
//   todo: {
//     id: id++,
//     text,
//     done: false
//   }
// });

// export const toggle = (id) => ({
//   type: TOGGLE,
//   id: id
// });

// export const remove = (id) => ({
//   type: REMOVE,
//   id
// });

// 3. 초기값
const initialState = {
  input: '',
  todos: [
    {id: 1, text:'리덕스기초 배우기', done:false},
    {id: 2, text:'리액트와 리덕스 사용하기', done:false},
  ]
}

// 4. 리듀서함수
// function todos(state = initialState, action) {
//   switch(action.type) {
//     case CHANGE_INPUT:
//       return {
//         ...state, 
//         input: action.input
//       }
//     case INSERT:
//       return {
//         ...state, 
//         todos: state.todos.concat(action.todo)
//       }
//     case TOGGLE:
//       return {
//         ...state, 
//         todos: state.todos.map(todo => 
//           todo.id === action.id ? {...todo, done: !todo.done} : todo)
//       }
//     case REMOVE:
//       return {
//         ...state,
//         todos: state.todos.filter(
//           todo => todo.id !== action.id
//         )
//       }
//     default:
//       return state;
//   }
// };

// 4.1 리튜서함수 대신에 createAction()함수를 적용
// createAction을 사용하기 위해서 redux-actions를 설치 : yarn add redux-actions
// redux-actions은 액션생성함수를 간결한 코드로 작성할 수 있게 지원한다.
// switch문 대신에 handleActions라는 함수를 사욯하여 각 액션마다 업데이트함수를 설정
export const changeInput = createAction(CHANGE_INPUT, input => input);

let id = 3;
export const insert = createAction(INSERT, text => ({
  id: id++,
  text,
  done: false
}));

export const toggle = createAction(TOGGLE, id => id);
export const remove = createAction(REMOVE, id => id);

// handlActions 리듀서함수 = action.payload 이름으로 새로 설정
const todos = handleActions({
  [CHANGE_INPUT]: (state, {payload: input}) => ({...state, input}),
  [INSERT]: (state, {payload: todo}) => ({
    ...state, 
    todos: state.todos.concat(todo
  )}),
  [TOGGLE]: (state, {payload: id}) => ({
    ...state,
    todos: state.todos.map(todo => 
      todo.id === id ? {...todo, done: !todo.done} : todo)    
  }),
  [REMOVE]: (state, {payload: id}) => ({
    ...state,
    todos: state.todos.filter(todo => todo.id !== id)        
  }),
}, initialState);

export default todos;