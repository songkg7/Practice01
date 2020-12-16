$(() => {
  $('input[name="hobby"]').on('change', function () {
    const thisObj = $(this);
    const isChecked = thisObj.is(':checked');
    if (isChecked) {
      // NOTE: siblings() : 선택자의 형제 태그들을 리턴
      thisObj.siblings().prop('checked', false);
    }
  });
  //   $('[name="hobby"]').change(function () {
  //     console.log('is changed?');
  //   });
});
