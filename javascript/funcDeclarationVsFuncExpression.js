// Function Declaration vs Function Expression
// 함수 선언문 방식 vs 함수 표현식
// 어떤 차이가 있을까 ?

// 결론부터 말하면,
// 함수 선언문 방식: 자유로워서 함수 선언하기 전에 호출이 가능하다.
// 함수 표현식: 실행 흐름이 표현식에 다다랐을 때 만들어진다.

'use strict';
// 두 가지 방식으로 호출을 시도해보자.
// 결과 값은 어떻게 될까 ?
{
    showMsgDeclaration("hello! FunctionDeclaration");
    showMsgExpression("hello! FunctionExpression");

    //1. 함수 선언문 방식
    function showMsgDeclaration(text){
        console.log(`showMsgDeclaration: ${text}`);
    }

    // 2. 함수 표현식
    const showMsgExpression = function(text){
        console.log(`showMsgExpression: ${text}`);
    }
}

// Console창을 확인해 보면, 결과값이 아래와 같이 나온다.
// showMsgDeclaration: hello! FunctionDeclaration
// ReferenceError: Cannot access 'showMsgExpression' before initialization


// 왜 이런 결과 값이 나올까?
// 그 이유는 JS엔진의 동작 과정 때문이다. 조금만 자세히 들여다보면
// 코드를 실행했을 때, JS엔진은 내부적으로 두 단계를 거쳐서 실행을 한다.
// 첫 번째 단계인 Creation phase에서 JS엔진은 "함수 선언문"으로 작성된 함수를 메모리에 할당한다.
// 그리고 두 번째 단계인 Execution phase에서 한 줄씩 위에서 밑으로 코드를 읽어나가는데, 이미 Creation phase에서 함수 선언문으로 작성된 함수를 메모리에 할당했기 때문에,
// 함수선언문 방식으로 작성된 함수(ShowMsgDeclaration)를 호출을 하면 정상적으로 동작한다.
// 하지만, 함수 표현식 같은 경우는 다르다. 함수 표현식의 경우, Exectuion phase에서 한 줄씩 코드를 읽으면서 코드 줄에서 함수를 메모리에 할당한다. 
// 그렇기 때문에 ReferenceError가 발생한다. 

// Reference: https://ko.javascript.info/function-expressions
