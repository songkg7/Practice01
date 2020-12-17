$(() => {
  const obj = $('.grade');
  obj.find('thead tr').css('background-color', 'aqua');
  obj.find('tbody tr:odd').css('background-color', 'aquamarine');

  // click event
  $('.search').on('click', function () {
    let keyword1 = $('.keyword1').val();

    // NOTE: 특정한 공백 패턴 처리
    // - 1. 데이터가 없거나 공백으로만 이루어진 경우 : input 초기화 후 경고창 출력
    // - 2. 공백으로 시작하는 경우 : trim() 처리
    const regex1 = /^\s+$/;
    // const regex2 = /^\s+\w*\s*$/;
    if (regex1.test(keyword1) || keyword1 === '') {
      console.log('검색데이터가 없습니다.');
      $('.keyword1').val('');
      return;
    }

    $('.keyword1').val(keyword1.trim()); // 양 옆 공백 제거
    keyword1 = $.trim(keyword1).toUpperCase();

    const trsObj = obj.find('tbody tr');
    trsObj.hide();

    // obj.find('tbody tr:odd').css('background-color', '');

    // FIXME: cnt 로는 제대로 동작하지 않음
    // let cnt = 0;
    for (let i = 0; i < trsObj.length; i++) {
      const trObj = trsObj.eq(i);
      const td1Text = trObj.children('td').eq(0).text().toUpperCase();
      const td2Text = trObj.children('td').eq(1).text().toUpperCase();
      const td3Text = trObj.children('td').eq(2).text().toUpperCase();

      if (
        td1Text.indexOf(keyword1) >= 0 ||
        td2Text.indexOf(keyword1) >= 0 ||
        td3Text.indexOf(keyword1) >= 0
      ) {
        trObj.show();
        // if (cnt % 2 === 1) {
        //   trObj.css('background-color', 'aquamarine');
        // }
        // cnt++;
      }
      //   console.log(`${td1Text} ${td2Text} ${td3Text}`);
    }

    // const td1Text = trObj.find('td');
  });

  $('.allSearch').on('click', function () {
    obj.find('tbody tr').show();
  });
});
