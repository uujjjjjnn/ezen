
let submit = document.querySelector('#saveBtn');
  
submit.addEventListener('click', function() {
    alert(`문의가 등록되었습니다!
빠른 시일 안으로 답변 등록을 알려드리겠습니다.`)
  })
  
  let email = document.querySelector('#select_mail');
  
  email.addEventListener('change', function(e) {
    const result = document.querySelector('#email_text');
    
    result.value = `${e.target.value}`
    // result.innerHTML = `${e.target.value}`
  })