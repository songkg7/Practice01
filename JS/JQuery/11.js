// FIXME: ajax unfinished
function checkLogin() {
  const uid = $('.uid').val();
  // replace
  // const uid = document.querySelector('.uid').value;
  // const uid = document.loginForm.uid.value;

  // id validity
  checkId(uid);
}

$.ajax({
  url: 'checkLogin.html',
  type: 'post',
  data: { uid, pwd },
  success(responseHTML) {
    const obj = $(responseHTML);
    const idCnt = obj.filter('.idCnt').text();
  },
});

$(() => {
  $('.login').on('click', function () {
    checkLogin();
  });
});
