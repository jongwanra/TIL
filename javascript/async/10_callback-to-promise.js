// Callback Hell example
class UserStorage {
    loginUser(id, password){
        return new Promise((resolve, reject) => {
            setTimeout(()=> {
                if(
                    (id === 'ellie' && password === 'dream') ||
                    (id === 'coder' && password === 'academy')
                ) {
                    onSuccess(id);
                }else{
                    onError(new Error('not found'));
                }
            }, 2000);    
        });
    }

    getRoles(user){
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                if(user === 'ellie'){
                    onSuccess({name: 'ellie', role: 'admin'});
                }else {
                    onError(new Error('no access'));
                }
            }, 1000);
        });
    }
}
const userStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');

userStorage
.loginUser(id, password)
.then(userStorage.getRoles)
.then(user => alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`))
.catch(console.log);