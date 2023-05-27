const container = document.querySelector('#container');
const pics = ['아이브.jpg','bts.jpg','뉴진스.jpg'];

container.style.backgroundImage = `url(./img/${pics[0]})`;

const arrows = document.querySelectorAll('.arrow');
let i = 0;
arrows.forEach( arrow => {
  arrow.addEventListener('click', e => {
    if(e.target.id==="left") {
      i--;
      if(i<0) i = pics.length - 1; // 마지막 이미지
    } else if(e.target.id==="right") {
      i++;
      if(i>=pics.length) i = 0; // 첫번째 이미지
    }
    container.style.backgroundImage = `url(./img/${pics[i]})`
  })
})