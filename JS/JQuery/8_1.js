// TODO: 검색할 때 체크박스와 키워드가 서로를 참조하게 하기
const obj = $('.grade');
const trsObj = obj.find('tbody tr');

function searchTable(operator, word1, word2) {
  switch (operator) {
    case 'or':
      for (let i = 0; i < trsObj.length; i++) {
        const trObj = trsObj.eq(i);
        for (let j = 0; j < trObj.children('td').length; j++) {
          const tdText = trObj.children('td').eq(j).text().toUpperCase();
          if (tdText.indexOf(word1) >= 0 || tdText.indexOf(word2) >= 0) {
            trObj.show();
          }
        }
      }
      break;
    case 'and':
      for (let i = 0; i < trsObj.length; i++) {
        const trObj = trsObj.eq(i);
        const tdText = trObj.children('td').text().toUpperCase();
        if (tdText.indexOf(word1) >= 0 && tdText.indexOf(word2) >= 0) {
          trObj.show();
        }
      }
      break;
    default:
      break;
  }
}

function getRank(score) {
  if (score >= 90) {
    return 'A';
  }
  if (score >= 80) {
    return 'B';
  }
  if (score >= 70) {
    return 'C';
  }
  if (score >= 60) {
    return 'D';
  }
  return 'F';
}

// function checkboxFiller() {
//   const checkArr = [];
//   const rank = $('[name=rank]').filter(':checked');

//   // 모두 체크해제했을 경우 원래의 표를 화면에 출력
//   if (rank.length === 0) {
//     trsObj.show();
//     return;
//   }
//   trsObj.hide();
//   for (let i = 0; i < rank.length; i++) {
//     checkArr.push(rank.eq(i).val());
//   }

//   for (let i = 0; i < trsObj.length; i++) {
//     const score = Number(trsObj.eq(i).find('td').eq(2).text());
//     const trObj = trsObj.eq(i);

//     if (checkArr.includes(getRank(score))) {
//       trObj.show();
//     }
//   }
// }

$(() => {
  obj.find('thead tr').css('background-color', 'aqua');
  obj.find('tbody tr:odd').css('background-color', 'aquamarine');

  // click event
  $('.search').on('click', function () {
    let keyword1 = $('.keyword1').val();
    let keyword2 = $('.keyword2').val();

    // data validity
    const regex = /^\s+$/;
    if (regex.test(keyword1) || regex.test(keyword2)) {
      console.log('검색양식이 올바르지 않습니다.');
      $('.keyword1').val('');
      $('.keyword2').val('');
      return;
    }

    trsObj.hide();

    $('.keyword1').val(keyword1.trim()); // 양 옆 공백 제거
    $('.keyword2').val(keyword2.trim()); // 양 옆 공백 제거
    keyword1 = $.trim(keyword1).toUpperCase();
    keyword2 = $.trim(keyword2).toUpperCase();

    searchTable($('[name=operator').val(), keyword1, keyword2);
  });

  $('.allSearch').on('click', function () {
    $('.keyword1').val('');
    $('.keyword2').val('');
    obj.find('tbody tr').show();
  });

  // checkbox를 선택하면 그에 맞는 점수의 학생만 보이게 하기
  $('[name=rank]').on('click', function () {
    // checkboxFiller();
    const checkArr = [];
    const rank = $('[name=rank]').filter(':checked');

    // 모두 체크해제했을 경우 원래의 표를 화면에 출력
    if (rank.length === 0) {
      trsObj.show();
      return;
    }
    trsObj.hide();
    for (let i = 0; i < rank.length; i++) {
      checkArr.push(rank.eq(i).val());
    }

    for (let i = 0; i < trsObj.length; i++) {
      const score = Number(trsObj.eq(i).find('td').eq(2).text());
      const trObj = trsObj.eq(i);

      // FIXME: 필터와 검색이 연동되게끔 하는 과정
      if (
        checkArr.includes(getRank(score)) &&
        ($('.keyword1').val() !== '' || $('.keyword2').val() !== '')
      ) {
        trObj.show();
      }
    }
  });
});
