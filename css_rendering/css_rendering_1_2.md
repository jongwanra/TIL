# CSS Rendering 1회차 2/2

- (공식)Float는 라인 박스로 그려진다.
- Float는 같은 Float만 신경쓰고 나머지는 무시한다.
- Float 라인 박스 중 가용한 영역만 신경 쓴다.

```html
  <div style="witdh:500px">
    <div class="left" style="width: 200px; height: 150px">1</div>
    <div class="right" style="width: 50px; height: 150px">2</div>
    <div class="right" style="width: 50px; height: 100px">3</div>
    <div class="left" style="width: 150px; height: 50px">4</div>
    <div class="right" style="width: 150px; height: 70px">5</div>
    <div class="left" style="width: 150px; height:50px">6</div>
    <div class="left" style="width: 150px; height: 50px">7</div>
    <div style="height: 30px; background:red">ABC1 ABC2 ABC3 ABC4 ABC5 ABC6 ABC7 ABC8</div>
  </div>
```
### Reference
- [코드스피츠76 - CSS Rendering 1회차 2/2](https://www.youtube.com/watch?v=ybNH1a14vQY&t=1180s)