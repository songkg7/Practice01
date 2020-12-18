function upTr(idV) {
  const tableObj = $(`#${idV}`);
  const firstTrObj = tableObj.find('tr').first();
  const lastTrObj = tableObj.find('tr').last();
  lastTrObj.after(firstTrObj.clone());
  firstTrObj.remove();
}

$(() => {
  setInterval(function () {
    upTr('table');
  }, 3000);
});
