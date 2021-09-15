# How to use Selenium

### 셀레니움 설치

1. pip3 install selenium
2. chrome driver download(셀레니움이 크롬을 제어할 수 있도록 도와줌)
    1. 다운 받기전 버전확인 반드시 필수(버전마다 설치해야 할 드라이버가 다름.)

        → chrome://settings/help

    2. chrome driver download link 들어가기 

        → [https://chromedriver.storage.googleapis.com/index.html](https://chromedriver.storage.googleapis.com/index.html)

    3. 버전에 맞춰서 다운로드 받기
    4. 크롬드라이버를 사용할 .py와 같은 위치에 놓음.

### Example

```python
# 좋아요 갯수가 0개인 이유? request만으로는 가져올 수 없나? 이런 상황을 해결하기 위해서 셀레니움이 필요하다.
# 동적인 웹페이지를 스크래핑을할 때 반드시 필요하다.

from bs4 import BeautifulSoup
from selenium import webdriver
from time import sleep

driver = webdriver.Chrome('./chromedriver')  # 드라이버를 실행합니다.

url = "https://www.melon.com/chart/day/index.htm"
# headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}
# data = requests.get(url, headers=headers)

driver.get(url)  # 드라이버에 해당 url의 웹페이지를 띄웁니다.
sleep(5)  # 페이지가 로딩되는 동안 5초 간 기다립니다. 

req = driver.page_source  # html 정보를 가져옵니다.
driver.quit()  # 정보를 가져왔으므로 드라이버는 꺼줍니다.

# soup = BeautifulSoup(data.text, 'html.parser')
soup = BeautifulSoup(req, 'html.parser')  # 가져온 정보를 beautifulsoup으로 파싱해줍니다.

songs = soup.select("#frm > div > table > tbody > tr")
print(len(songs))

for song in songs:
    title = song.select_one("td > div > div.wrap_song_info > div.rank01 > span > a").text
    artist = song.select_one("td > div > div.wrap_song_info > div.rank02 > span > a").text
    likes_tag = song.select_one("td > div > button.like > span.cnt")
    
    likes_tag.span.decompose()  # span 태그 없애기
    likes = likes_tag.text.strip()  # 텍스트화한 후 앞뒤로 빈 칸 지우기
    print(title, artist, likes)    
    print(title, artist, likes)
```

### Example2

```python
# 이미지 src 긁어오기
from bs4 import BeautifulSoup
from selenium import webdriver
from time import sleep

driver = webdriver.Chrome('./chromedriver')

url = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query=%EC%95%84%EC%9D%B4%EC%9C%A0"
driver.get(url)
sleep(3)

req = driver.page_source
driver.quit()

soup = BeautifulSoup(req, 'html.parser')
images = soup.select(".tile_item._item ._image._listImage")
print(len(images))

for image in images:
    src = image["src"]
    print(src)
```

### Example3

```python
# 1000픽셀만큼 내리기
driver.execute_script("window.scrollTo(0, 1000)")  

# 맨 밑까지 내리기
sleep(1)
driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
sleep(10)
```
