$(() => {
  const tipObj = $('.tip');
  tipObj.hide();

  // NOTE: Replace hover() with on()
  // - CSS로 처리하는 것이 더 좋은 방법임.
  $('a')
    .on('mouseover', function () {
      let word = $(this).text();
      word = $.trim(word);
      // word = word.trim();
      $(`.${word}`).show();
      // FIXME: event 를 대체하기
      const x = event.clientX;
      const y = event.clientY;
      $(`.${word}`).css({ top: y, left: x });
    })
    .on('mouseout', function () {
      let word = $(this).text();
      word = $.trim(word);
      // word = word.trim();
      setTimeout(() => $(`.${word}`).hide(1000), 3000);
      //   $(`.${word}`).hide();
    });
});
