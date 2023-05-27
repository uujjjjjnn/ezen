const st_name = document.querySelector('#name');
const st_major = document.querySelector('#major');
const save = document.querySelector('#save');
const studentList = document.querySelector('#studentList');

save.addEventListener('click', (event) => {
  event.preventDefault();


  const saveStudent = document.createElement('li'); // li태그 생성
  //let studentList = document.createTextNode(saveStudent.innerText); // 학생list
  saveStudent.innerHTML = `${st_name.value}  -  ${st_major.value}   <button class ="delBtn">삭제</button>`;

  studentList.appendChild(saveStudent); // 학생list를 li태그에 추가

  st_name.value = "";
  st_major.value= "";
  
  // 학생list를 삭제
  const delBtns = document.querySelectorAll('.delBtn');

  for(let delBtn of delBtns) {
    delBtn.addEventListener('click', removeItem)
  }
})

function removeItem() {
  let list = this.parentNode;
  list.parentNode.removeChild(list);
}