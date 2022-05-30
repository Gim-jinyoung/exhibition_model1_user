# exhibition_model1_user
전시 예약 사이트 사용자 홈페이지

# ClassDiagram
<img src="https://user-images.githubusercontent.com/102278035/170899362-3f2a44ac-38d6-4207-b436-a50bff7ab1a4.jpg"/>

# 데이터 구조
<img src="https://user-images.githubusercontent.com/102278035/170899462-92f44064-221e-4a64-8621-0833b4d2f68a.jpg"/>

# 기능 
* 로그인, 비밀번호 찾기, 아이디 찾기, 회원가입
* 전시 리스트 보여주기, 검색
* 예약, 예약 취소
* 예약 확인, 개인정보 수정
* 게시판(생성, 삭제, 수정), 댓글
 
# 결과물
-------------------
### index
<img src="https://user-images.githubusercontent.com/102278035/170899598-72a7bd0a-dc4e-45a6-9d88-f339fcf8fda3.jpg"/>

* view 수가 많은 전시는 홈페이지 상단에 게시
* 전시 이름으로 검색
* 지도 전시관 클릭시 해당 전시만 출력

-------------------
### login
<img src="https://user-images.githubusercontent.com/102278035/170899806-e80981ff-b789-40da-a32d-d8398ba9b1c2.jpg"/>

* 로그인, 회원가입, 아이디 찾기, 비밀번호 찾기

-------------------

### 회원 가입
<img src="https://user-images.githubusercontent.com/102278035/170900300-8d962d3e-ef56-47e0-b741-4d46553506e6.jpg"/>

* 약관 동의 후 회원 가입 진행
* 빈 칸 있을 경우 경고
* 아이디 중복 확인

-------------------

### 아이디, 비밀번호 찾기
<img src="https://user-images.githubusercontent.com/102278035/170900478-3b21fb4b-d6be-4c04-84c3-a8c1622f2940.jpg"/>
<img src="https://user-images.githubusercontent.com/102278035/170900709-faefb226-e188-4e63-a0d8-ac0735480453.jpg"/>

* 해당 정보가 일치하면 아이디 보여줌
* 해당 정보가 일치하면 비밀번호 새로 지정

-------------------

### 내 정보 변경
<img src="https://user-images.githubusercontent.com/102278035/170900864-a64104ac-4eae-4440-bd3c-b4308950d3a6.jpg"/>

* 비밀번호 일치 시 이동 가능
* 세션에서 아이디를 얻어와 내 정보를 보여줌
* 빈칸 있을 시 경고

-------------------

### 내 예약
<img src="https://user-images.githubusercontent.com/102278035/170900963-1839336a-2bd2-4a60-b51b-f70e6cde814c.jpg"/>

* 비밀번호 일치 시 이동 가능
* 내 예약 리스트를 불러옴
* 클릭 시 상세
* 취소 시 non-click, 색이 변한 후 맨 밑으로 정렬

-------------------

### 전시 리스트
<img src="https://user-images.githubusercontent.com/102278035/170900965-1943aefc-3e64-4bd9-9999-dc2b726bc753.jpg"/>

* 전시 포스터와 간략 설명 보여줌
* 클릭 시 전시 상세

-------------------

### 전시 상세
<img src="https://user-images.githubusercontent.com/102278035/170900966-933acbad-2997-4be2-aa92-595103ac6c20.jpg"/>

* 예약, 후기
* 후기 클릭 시 해당 전시의 후기 게시판으로 이동

-------------------

### 예약
<img src="https://user-images.githubusercontent.com/102278035/170900968-6560929c-705e-45e5-9a29-70fe5611f817.jpg"/>

* 지역 선택 시 해당 전시 출력
* 해당 전시 예약 가능 날짜 표시
* 간략 설명

-------------------

### 게시판
<img src="https://user-images.githubusercontent.com/102278035/170900969-ba9ca01e-bbc5-4f5b-a4b6-dbdb4ba83a6e.jpg"/>

* 페이징
* 아이디, 제목 검색 기능

-------------------

### 게시판 글 생성, 수정, 삭제
<img src="https://user-images.githubusercontent.com/102278035/170900970-f2245dff-6c3c-4b1c-9ea9-059767498229.jpg"/>

* 글쓴 아이디와 세션 아이디가 동일하면 수정, 삭제 가능
* 댓글 
