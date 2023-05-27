// querySelectorAll : 배열로 리턴, onclick -> removeChild()
const li_lists = document.querySelectorAll('li'); // 모든 li태그 선택

for(let li of li_lists) {
  li.addEventListener('click', function() {
    this.parentNode.removeChild(this);
    // this.remove(this); 도 가능
  })
}