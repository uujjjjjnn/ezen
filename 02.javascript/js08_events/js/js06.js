const title = document.querySelector('#title');
const author = document.querySelector('#author');
const save = document.querySelector('#save');
const booklist = document.querySelector('#bookList');

save.addEventListener('click', (event) => {
  event.preventDefault();

  const item = document.createElement('li')
  item.innerHTML = `${title.value} - ${author.value}    <span class="delBtn">삭제</span>`;

  booklist.appendChild(item);
  
  title.value = "";
  author.value = "";

  // booklist에서 삭제
  const delBtns = document.querySelectorAll('.delBtn');

  for(let delBtn of delBtns) {
    delBtn.addEventListener('click', removeItem)
  }
});

function removeItem() {
  let list = this.parentNode;
  list.parentNode.removeChild(list);
}