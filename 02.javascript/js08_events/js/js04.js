const orderList = document.querySelector('#orderlist'); 
const orderButton = document.querySelector('#order');
const product = document.querySelector('.container > h2'); // 상품리스트

orderButton.addEventListener('click', () => {
  let orderProduct = document.createElement('p'); // 새로운 p tag 생성
  let textProduct = document.createTextNode(product.innerText); // 상품명

  orderProduct.appendChild(textProduct); // 상품명 textNode를 p태그에 추가
  orderList.appendChild(orderProduct); // 주문상품을 주문목록에 추가
}, {once: true}); // once 옵션은 한번만 실행 (false이면 계속 실행)