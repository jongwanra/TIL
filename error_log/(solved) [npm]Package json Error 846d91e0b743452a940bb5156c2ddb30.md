# (solved) [npm]Package.json Error

## Occured Error

![Untitled]((solved)%20%5Bnpm%5DPackage%20json%20Error%20846d91e0b743452a940bb5156c2ddb30/Untitled.png)

## Solution

```json
{
  "name": "test",
  "version": "1.0.0",
  "description": "test project",
  "main": "app.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "node app", 
  }, 
  "keywords": [
    "test"
  ],
  "author": "Jongwan",
  "license": "ISC"
}
```

package.json에서 

"start": "node app",   ← 마지막을 ',' 로 하면서 에러가 발생했고, 지워서 해결했다.