# Flexbox

## How to use

1. 플렉스 박스 선언
   - 선언은 정렬하고자 하는 요소를 감싸는 부모에게 해준다.

```css
.flexbox {
  display: flex;
  /* flex | inline-flex */
}
```

2. 가로 정렬? 세로 정렬?

```css
.flexbox {
  display: flex;
  flex-direction: row;
  /* row | row-reverse | column | column-reverse */
}
```

- Axis: 축
- flex-direction을 뭘 선택하는지에 따라 축이 달라진다.(main axis, cross axis)

3. 무조건 한 줄 안에 다 정렬할지 안 할지?

```css
.flexbox {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  /* nowrap | wrap */
}
```

- flex-wrap: nowrap => 감싸지 않고 자식의 사이즈를 줄여서 라도 한 줄로 정렬해버린다.
- flex-wrap: wrap => 한 줄에 모두 정렬하기에 공간이 넉넉하지 않으면 여러 줄을 만들어 버린다.

4. 플렉스 박스 사용한다!

- justify-content : main axis를 기준으로 정렬을 할 때

  - center: 가운데 정렬
  - flex-start: main axis를 기준으로 처음 흐름을 시작하는 곳에 정렬
  - flex-end: main axis를 기준으로 흐름의 끝인 곳에 정렬
  - space-between: 요소들 사이에 있는 간격을 같게 해준다.
  - space-around: 양쪽의 간격을 같도록 정렬

- align-items: cross-axis를 기준으로 정렬을 할 때

  - center
  - flex-start
  - flex-end
  - space-between
  - space-around

- align-content: flex-wrap이 wrap으로 여러줄이 생기면서, flex-line이 여러 줄이 생긴 상황에서 전체를 한 개의 flex-line으로 생각하고 정렬하고 싶을 때 사용

- order: mark-up에서 정해진 자식 요소들의 순서를 원하는 대로 배치하고 싶을 때