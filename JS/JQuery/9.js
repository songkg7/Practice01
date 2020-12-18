$(() => {
  const num = $('.dogList tr').length;
  $('.dogList tr').each(function (i) {
    if (i === 0) {
      $(this).prepend("<th bgcolor='grey'>번호</th>");
    } else {
      $(this).prepend(`<td>${num - i}</td>`);
    }
  });
});
