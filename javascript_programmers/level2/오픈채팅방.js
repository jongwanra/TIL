// 오픈채팅방
// https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=javascript

// 문제 접근
// id: nickname을 key:value로 만들어두고 변경시 기록해둔다. 그리고, record를 [Enter, Id형식을 기록한다.]


const solution = (record) => {
    const loginIdToNickname = new Map();
    const answers = [];

    record.forEach((value) => {
        const [command, loginId, nickName] = value.split(" ");

        if(command.includes("Leave")){
            answers.push([command, loginId]);
            return;
        }

        if(command.includes("Change")){
            loginIdToNickname.set(loginId, nickName);
            return;
        }

        loginIdToNickname.set(loginId, nickName);
        answers.push([command, loginId]);
    });


    return answers.map(([command, loginId]) => {
        const nickname = loginIdToNickname.get(loginId);
        if(command.includes('Enter') ){
            return `${nickname}님이 들어왔습니다.`;
        }
        return `${nickname}님이 나갔습니다.`;
    });
}