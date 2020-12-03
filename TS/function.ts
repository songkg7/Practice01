function checkRegisterNum(num: string): boolean {
  const regExp = new RegExp(/^\d{6}-?\d{7}$/);
  return regExp.test(num);
}
