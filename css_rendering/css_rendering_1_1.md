# CSS Rendering 1회차 1/2

##  Rendering System은 2단계로 구성된다.
1. Geometry Calculate(Reflow)
    - 영역을 계산한다.
2. Fragment Fill(Repaint)
    - 색칠한다

## Normal Flow

- Position이란, 어떤 Geometry 영역의 추상적인 위치를 결정하게 하는 시스템을 말함(계산 공식).
- **Static** / **Relative** / Absolute / Fixed / Inherit
- 이 중, position static, relative 두 가지만 Normal Flow에 해당함.
- **Block Formatting Contenxts** / **Inline Formatting Contexts** 두 가지 계산 공식이 존재한다.(BFC, IFC)

- BFC: 부모의 가로 길이를 가득 채운 한 줄을 의미(부모 만큼 가로 길이 다 먹음)
  - 블록이 한 줄을 다 먹기 때문에 x는 언제나 0, width은 언제나 부모의 width
  - 안에 존재하는 Block요소의 height가 나의 height
- IFC: 나의 Contents 크기만큼 가로를 차지한다.
  - IFC는 inline 요소의 width의 합이 부모의 width를 넘는 다면 다음 줄로 넘어 간다.

### BFC + IFC

```html
  <div style="width: 500px">
    Hello
    <span>
      WORLD
        <div style="background:red">&nbsp;</div>
    </span>
    !!
  </div>
```

--- 
```html
  <div style="width: 500px">
    **
    <span>
        HELLO
        <span>WORLD
          <div style="background:red">&nbsp</div>
        </span>
        !!
        <div style="background:blue">&nbsp</div>
    </span>
    **
  </div>
```

### Position: Relative

```html
  <div style="width: 500px">
    **
    <span>
        HELLO
        <span style="position:relative; top:50px">WORLD
          <div style="background:red">&nbsp</div>
        </span>
        !!
        <div style="background:blue">&nbsp</div>
    </span>
    **
  </div>
```

- static으로 그리고 난 후, relative로 지시된 만큼만 이동시키면 됨
- static과 relative가 만나면 무조건 relative가 위로 뜬다.

### Reference
- [코드스피츠76 - CSS Rendering 1회차 1/2](https://www.youtube.com/watch?v=_o1zsrBkZyg&list=PLBNdLLaRx_rKXwi7MulM6v1UG9JLKWIYS)