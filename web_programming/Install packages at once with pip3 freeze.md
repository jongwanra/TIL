# Install packages at once with pip3 freeze

프로젝트 폴더 내부에서 package들이 무엇이 들어 있는지, 버전은 어떻게 되는지 한 번에 깔끔히 볼 수 있는 방법은 없을까 ?


$pip3 freeze > requirements.txt


그리고 나서, 해당 내용들을 다른 virtual environment에 한번에 깔아줄 수 있다.


$pip3 freeze > requirements.txt


위 명령어를 통해서  다운로드 받은 패키지들과 해당 버전들을 긁어서 파일에 저장이 가능하다.  정말 유용할거 같아서 정리해 둔다. ㅎㅎ
