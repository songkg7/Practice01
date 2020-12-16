function insertComma(str) {
  return str.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}

$(() => {
  const moneyObj = $('.money');
  moneyObj.trigger('focus');
  moneyObj.on('keyup', function () {
    const money = $(this).val();
    let num = '';
    for (let i = 0; i < money.length; i++) {
      const iStr = money.charAt(i);
      if ('0123456789'.indexOf(iStr) >= 0) {
        num += iStr;
      }
    }

    if (num.length > 1 && num.charAt(0) === '0') {
      num = num.substring(1);
    }

    const result = insertComma(num);

    $(this).val(result);
    // moneyObj.prop('value', re$(this).val(result);

    $('.msg').text(result);
    // $('body').append(`<div>${re$(this).val(result}</div>`);
  });
});
