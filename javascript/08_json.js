// JSON
// JavaScript Object Notation

// 1. Object to jSON
// stringfy(obj)

let json = JSON.stringify(['apple', 'banana']);
console.log(json);

const rabbit = {
    name: 'tori',
    color: 'white',
    size: null,
    birthDate: new Date(),    
    jump: () => {
        console.log(`${name} can jump!`);
    },
};

json = JSON.stringify(rabbit);
console.log(json);


// 이름만 json 형식으로 바꾸기.
json = JSON.stringify(rabbit, ["name"]);
console.log(json);

json = JSON.stringify(rabbit, (key, value) => {
    console.log(key, value);
    return key === 'name' ? 'ellie': value;
});
console.log(json);

// 2. JSON to Object
// parse(json)

console.clear();
json = JSON.stringify(rabbit);
const obj = JSON.parse(json, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'birthDate' ? new Date(value) : value;
});
console.log(obj);
rabbit.jump();
//obj.jump(); // TypeError! 

// JSON에 대해 조금더 공부를 하고 싶으시면: 
// MDN ➡️ https://developer.mozilla.org/en-US/d...
// JavaScript.info ➡️ https://javascript.info/json
// JavaScript.info 한국어 ➡️ https://ko.javascript.info/json 

// 유용한 사이트:
// JSON Diff checker: http://www.jsondiff.com/
// JSON Beautifier/editor: https://jsonbeautifier.org/
// JSON Parser: https://jsonparser.org/
// JSON Validator: https://tools.learningcontainer.com/j...