'use strict';
// Object-oriented programming
// class: template
// object: instance of a class
// Javascript classes
// - introduced in ES6 (ES6에 추가됨)
// - syntactical sugar over prototype-based inheritance

// 1. Class declarations
class Person {
    // constructor
    constructor(name, age){
        // fileds
        this.name = name;
        this.age = age;
    } 
    
    // methods
    speak(){
        console.log(`${this.name}: hello!`);
    }
}

const ellie = new Person('ellie', 20);
console.log(ellie.name);
console.log(ellie.age);
ellie.speak()

// 2. Getter and setters(사용자가 클래스를 잘못 사용해도 방어적인 자세로 만들 수 있도록 해주는 것)
class User{
    constructor(firstName, lastName, age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getter(값을 가져올 때 getter를 바로 호출, 메모리 읽어오기 전)
    get age(){
        console.log(`called get age method!!`);
        return this._age;
    }

    // setter(값을 할당할 때, setter를 호출, 메모리 할당 전)
    set age(value){
        // if (value < 0){
        //     throw Error('age can not be negative');
        // }
        this._age = value < 0 ? 0 : value;
    }
}

const user1 = new User('Steve', 'job', -1);
console.log(user1.age); 
console.log(user1.age); 
console.log(user1.age); 
console.log(user1.age); 

// 3. Fields (public, private)
// Too soon!
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference

class Experiment{
    publicField = 2;
    #privateField = 0; // class 외부에서는 이 값을 변경할 수 없다.
}

const experiment = new Experiment();
console.log(experiment.publicField);
console.log(experiment.privateField);

// 4. Static properties and methods
// Too soon!
class Article {
    static publisher = 'Dream Coding';
    constructor(articleNumber){
        this.articleNumber = articleNumber;
        
    }

    static printPublisher(){
        console.log(Article.publisher);
    }
}

const article1 = new Article(1);
const article2 = new Article(2);
console.log(article1.publisher); // undefined
console.log(Article.publisher);
Article.printPublisher();

// 5. Inheritance
// a way for one clas to extend another class.

class Shape{
    constructor(width, height, color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    draw(){
        console.log(`drawing ${this.color} color!`);
        
    }

    getArea(){
        return width * this.height;
    }
}

class Rectangle extends Shape {}

class Triangle extends Shape{
    draw(){
        super.draw(); // 부모에게 접근
        console.log('asdasd');
    }
    getArea(){
        return (this.width * this.height) / 2;
    }
}

const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw();

const triangle = new Triangle(20, 20, 'red');
triangle.draw();

// 6. Class checking: instanceOf
// 왼쪽에 있는 객체가 오른쪽에 있는 클래스의 인스턴스 인지 아닌지 여부 
console.log(rectangle instanceof Rectangle); // true
console.log(triangle instanceof Rectangle); // false
console.log(triangle instanceof Triangle); // true
console.log(triangle instanceof Shape); // true
console.log(triangle instanceof Object); // true