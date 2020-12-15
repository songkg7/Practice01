$(() => {
  $('input[name="hobby"]').on('change', function () {
    console.log('is selected?');
  });
  //   $('[name="hobby"]').change(function () {
  //     console.log('is changed?');
  //   });
});
