$(() => {
  const tipObj = $('.tip');
  tipObj.hide();

  // NOTE: Replace hover() with on()
  // - CSS로 처리하는 것이 더 좋은 방법임.
  $('a')
    .on('mouseover', function (event) {
      let word = $(this).text();
      word = $.trim(word);
      // word = word.trim();
      $(`.${word}`).show();
      const x = event.pageX;
      const y = event.pageY;
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
