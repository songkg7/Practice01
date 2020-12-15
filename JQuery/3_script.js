$(() => {
  //   $('#staff tr:eq(0)').css({ 'background-color': 'gray', color: 'white' });
  //   $('table tr').eq(0).css({ 'background-color': 'gray', color: 'white' });
  //   $('#staff tr').eq(0).css({ 'background-color': 'gray', color: 'white' });
  $('#staff thead tr').css({ 'background-color': 'gray', color: 'white' });
  $('#staff tbody tr:odd').css({ 'background-color': '#AAAAAA' });
  $('#staff tbody tr:even').css({ 'background-color': '#FFFFFF' });

  // jQuery 에서 Arrow function을 사용하면 안될 수 있으니 주의할 것
  // .hover() 는 의도치 않은 문제를 야기할 수 있으므로 이벤트 처리는 되도록
  // .on() 을 사용하여 해결할 것
  $('#staff tbody tr').on('mouseover', function () {
    $(this).find('td').addClass('style1');
  });
  $('#staff tbody tr').on('mouseout', function () {
    $(this).find('td').removeClass('style1');
  });

  $('#staff thead tr th').on('mouseover', function () {
    const no = $(this).index() + 1;
    $(`#staff tbody td:nth-child(${no})`).addClass('style1');
  });
  $('#staff thead tr th').on('mouseout', function () {
    const no = $(this).index() + 1;
    $(`#staff tbody td:nth-child(${no})`).removeClass('style1');
  });
});
