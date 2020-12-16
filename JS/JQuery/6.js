$(() => {
  const obj1 = $('[name=hobbyAll]');
  const obj2 = $('[name=hobby]');

  obj1.on('change', function () {
    // if (obj1.is(':checked')) {
    //   obj2.prop('checked', true);
    // } else {
    //   obj2.prop('checked', false);
    // }
    obj2.prop('checked', obj1.is(':checked'));
  });

  obj2.on('change', function () {
    //   console.log();
    if (obj2.filter(':checked').length < obj2.length) {
      obj1.prop('checked', false);
    } else {
      obj1.prop('checked', true);
    }
  });
});
