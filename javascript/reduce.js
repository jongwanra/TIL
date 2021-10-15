const arr = [1, 2, 3];
let result = arr.map((v) => {
  console.log(v);
  return v + 1;
});
console.log(typeof arr === typeof result);
// console.log();

result = arr.reduce((acc, cur, i) => {
  console.log(acc, cur, i);
  return acc + cur;
}, 0);

console.log(result);
