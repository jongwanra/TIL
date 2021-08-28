// Objects
// one of the JavaScript's data types
// a collection of related data and/or functionality.
// Nearly all objects in JavaScript are instances of Object
// object = {key: value}; -> 오브젝트는 키와 값의 집합체이다.


// 1. Literals and properties
const obj1 = {}; // 'object literal' syntax
const obj2 = new Object(); // 'object constructor' syntax

function print(person){
    console.log(person.name);
    console.log(person.age);
}

const ellie = { name: 'ellie', age : 4};
print(ellie);

// with JavaScript magin(dynamically typed language)
// can add properties later
ellie.hasJob = true;
console.log(ellie.hasJob);

// can delete properties later
delete ellie.hasJob;
console.log(ellie.hasJob);

//2. Computed properties
// key should be always string
console.log(ellie.name);
console.log(ellie['name']); // Computed properties

ellie['hasJob'] = true;
console.log(ellie.hasJob);

function printValue(obj, key){
    console.log(obj.key); // undefined
    console.log(obj[key]); // reason using Computed properties
}

printValue(ellie, 'name');
printValue(ellie, 'age');

// 3. Property value shorthand
const person1 = {name: 'bob', age: 2};
const person2 = {name : 'steve', age: 3};
const person3 = {name: 'dave', age: 4};
const person4 = new Person('ellie', 30);
console.log(person4);

// 4. Constructor function
function Person(name, age){
    // this = {};
    this.name = name;
    this.age = age;
    // return this;
}

// 5. in operator: property existance check (key in obj)
console.log('name' in ellie);
console.log('age' in ellie);
console.log('random' in ellie); // false
console.log(ellie.random); // undefined

// 6. for ..in vs for ..of
// for (key in obj)
for (key in ellie) {
    console.log(key);
}

// for (value of iterable)
const array =  [1, 2, 4, 5];
for (value of array){
    console.log(value);
}


// 7. Fun cloning
// Object.assign(dest, [obj1, obj2, obj3...])
const user = { name: 'ellie', age: '20'};
const user2 = user;

user2.name = 'coder';
console.log(user);

// old way
const user3 = {};
for (key in user){
    user3[key] = user[key];
}
console.clear();
console.log(user3);

// new way 1

// const user4 = {};
// Object.assign(user4, user);
// console.log(user4);

// new way 2
const user4 = Object.assign({}, user);
console.log(user4);

// another example
const fruit1 = { color: 'red'};
const fruit2 = { color: 'blue', size: 'big'};
const mixed = Object.assign({}, fruit1, fruit2); // 뒤에 앞에 속성이 곂치면 덮어 씌어지기 때문
console.clear();
console.log(mixed.color); // blue
console.log(mixed.size); // big
