$(() => {
  const obj = $('#movieList');
  obj.find('tr:odd').hide();
  obj.find('tr:even').on('mouseover', function () {
    obj.find('tr:odd').hide();
    $(this).next().show();
  });
});
