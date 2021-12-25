```css
.box {
}
```

## Box Type

### display: block

- block 타입의 키워드는 **길막**
- block type에 width을 따로 설정해주지 않으면, 부모 의 context-box의 100%로 설정된다.
- block type에 width값을 설정해주면, 남은 공간은 margin으로 자동으로 채움.(그렇기 때문에 0 auto는 가운데 정렬이 된다.)
- 부모의 height을 선언하지 않을 경우, 자식 요소의 height의 합 = 부모의 height

### display: inline

- inline 타입의 키워드는 **흐름**
- 옆으로 계속 붙는다.
- width, height, (padding, border, margin) x (top, bottom) 사용 불가.

### block vs inline

- 면(영역) vs 선(흐름)

### display: inline-block

- inline처럼 가로로 흐르는 성질
- block처럼 영역을 잡을 수 있음
