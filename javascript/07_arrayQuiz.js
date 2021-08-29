// Q1. make a string out of an array
{
    const fruits = ['apple', 'banana', 'orange'];
    const strFruits = fruits.toString();
    console.log(`${strFruits}, type: ${typeof strFruits}`);

    // teacher
    const result = fruits.join(",");
    console.log(result);
}
// Q2. make an array out of a tring

{
    const fruits = '🍎, 🥝, 🍌, 🍒';
    const arrFruits = fruits.split(',');
    console.log(arrFruits);

    // the same answer with teacher
}

// Q3. make this array look like this: [5, 4, 3, 2, 1]
{
    const array = [1, 2, 3, 4, 5];
    console.log(array.reverse());

    // the same answer with teacher
}

//Q4. make new array without the first two elements
{
    const array = [1, 2, 3, 4, 5];
    const newArray = array.slice(2);
    console.clear();
    console.log(newArray);

    // the same answer with teacher
}

class Student {
    constructor(name, age, enrolled, score){
        this.name = name;
        this.age = age;
        this.enrolled = enrolled;
        this.score = score;
    }
}

const students = [
    new Student('A', 29, true, 45),
    new Student('B', 28, false, 80),
    new Student('C', 30, true, 90),
    new Student('D', 40, false, 66),
    new Student('E', 18, true, 88),
];

// Q5. find a student with the score 90
{
    for (let i = 0; i < students.length; i++){
        if(students[i].score === 90){
            console.log(`find it! ${students[i].name}`);
        }
    }

    // teacher
    
    const result = students.find((student) => student.score === 90);
    console.log(result);
}

// Q6. make an array of enrolled students
{
    const enrolledStudents = [];
    for(let i = 0; i < students.length; i++){
        if(students[i].enrolled === true){
            enrolledStudents.push(students[i]);
        }
    }

    // teacher
    const result = students.filter((student) => student.enrolled);
    console.clear();
    console.log(result);
}

// Q7. make an array containing only the student scores
// result should be: [45, 80, 90, 66, 88]
{
    const scoreArr = []
    for(let i = 0; i < students.length; i++){
        scoreArr.push(students[i].score);
    }
    console.log(scoreArr);

    // teacher
    console.clear();
    const result = students.map((student) => student.score);
    console.log(result);
    
}

// Q8. check if there is a student with the score lower than 50
{
    //teacher
    console.clear();
    const result = students.some((student) => student.score < 50);
    console.log(result);

    const result2 = students.every((student) => student.score < 50);
    console.log(result2);
}

// Q9. compute students average score
{
    let sum = 0;
    for(let i = 0; i < students.length; i++){
        sum += students[i].score;
    }
    console.log(sum / students.length);
    
    console.clear();
    const result = students.reduce((prev, cur) => prev + cur.score, 0);
    console.log(result / students.length);
}

// Q10. make a string containing all the scores
// result should be: '45, 80, 90, 66, 88'
{
    const scoreArr = []
    for(let i = 0; i < students.length; i++){
        scoreArr.push(students[i].score);
    }
    console.log(scoreArr.toString());
    
    // teacher
    console.clear();
    const result = students
    .map((student) => student.score)
    .filter((score) => score >= 50)
    .join();
    console.log(result);
}

// Bonus! do Q10 sorted in ascending order
// result should be: '45, 66, 80, 88, 90'
{
    const scoreArr = []
    for(let i = 0; i < students.length; i++){
        scoreArr.push(students[i].score);
    }
    scoreArr.sort();
    console.log(scoreArr);

    // teacher

    const result = students
    .map(student => student.score)
    .sort((a, b) => a - b)
    .join();
    console.log(result);
    
}