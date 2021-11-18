# DaangnMarket-android
[Github Convention](#github-convention)

[Code Convention](#code-convention)

[Foldering](#foldering)


# Github Convention

## **Git Branch Convention**

1. branch 이름은 snake_case 표기법
2. "feat/이름" 으로 통일
   ex) feat/branch_name

```
default branch는 main 
-> main에서 본인 브랜치 생성 
-> 본인 브랜치에서 main으로 merge 
-> merge 후 다시 main에서 새로운 브랜치 생성 (새로운 기능 구현할 때) 
-> 반복
```

<br>


## **Git Commit Message Convention**

### **Base Structure**

- **[feat]** : 새로운 기능 개발 (ex. kotlin 작업)
- **[fix]** : 버그 수정
- **[ui]** : 레이아웃 작업 (ex. xml 코드 변경)
- **[modify]** : kotlin 코드 수정
- **[chore]** : gradle 수정이나, 설정 세팅, 에셋 추가 등
- **[docs]** : 문서 작성 (ex. README.md)

```
#{issue_number} [TYPE] : subject

body(선택사항)

footer(선택사항)
```

(이슈를 생성하면 이슈 번호가 부여됨. 커밋할 때 이슈단으로 커밋하고 이슈번호를 커밋메시지에 #과 함께 적어주면 어떤 이슈를 처리하는 작업이었는지 조회하기 편함.)

**예시** 

=> 하나의 이슈 처리하고 커밋 할 때

```
#1 [feat] : 로그인 버튼 클릭 이벤트 처리
```

=> 여러개의 이슈를 처리하고 커밋 할 때

```
[refactor] : ReFactor Code From OtherPage
- OtherPage : 답변하지 않은 답변도 볼 수 있도록 수정
- OtherPage : 답변하지 않은 답변도 스크랩할 수 있도록 수정
- modified file : OtherPageAdapter, OtherPageActivity, OtherPageViewModel, item_other_page
issue track : #610, #612
```

### **Subject**

- Subject는 50글자를 넘기지 않기
- 마지막에 마침표(.)를 찍지 않기
- 작업한 내용을 명시
- 명령조를 사용한다(ex: Fix(o), Fixed(x), Modify(o), Modified(x))

### **Body**

- Subject(커밋제목) 이외에 부연 설명이 필요하거나, 여러 이슈를 한꺼번에 커밋할 때 적어주면 좋음
- 아래와 같이 Subject를 작성하고 엔터를 치면 다음 줄로 넘어가고 추가로 설명을 적을 수 있음
  git commit -m "[타입] : 제목 (엔터)
  Body(부연설명)"

### **Footer**

- 처리한 이슈 번호를 적을 때 사용
- 여러 이슈를 한꺼번에 커밋할 때 
  Subject에는 여러 이슈를 통틀어 말할 수 있는 작업 제목, 
  Body에는 작업 세부 내용==각각의 이슈 제목이 될 수 있겠죠?, 
  Footer에는 처리한 이슈 번호

```
subject

- body(이슈1)
- body(이슈2)
- body(이슈3)

issue track : #이슈1번호, #이슈2번호, #이슈3번호
```
<br><br>

# Code Convention

## **Android Naming Convention**

- 클래스명, 함수명, 변수명 등 모든 이름은 어떤 역할을 하는지 한눈에 알 수 있도록 하기
- id명은 겹치지 않게 하기 위해 어떤 액티비티(프래그먼트)에서 쓰고 있는지 명시
  <br>

### 1. Class file - UpperCamelCase 사용

- 클래스 파일 이름은 **UpperCamelCase(aka 파스칼 케이스(PascalCase))** 로 작성

- 전체 이름의 첫 문자를 포함한 각 단어의 첫 문자를 대문자로 표시한다.

  **ex) SignInActivity, SiginInFragment, ImageUploaderService, ChangePasswordDialog**

<br>

### 2. Resources file - snake_case

- 리소스 파일 이름은 **snake_case**로 작성
- 모든 단어는 소문자로, 각 단어의 사이를 **언더바 _** 로 구분해주는 표기법
- **ex) image_logo.png, ic_back.xml, menu_main.xml**
- **ex) image_logo.png, ic_back.xml, menu_main.xml**

<br>

### 3. Layout file - snake_case

- 레이아웃 파일 이름 또한 마찬가지로 **snake_case**로 작성
- [what]_ [where]
- **ex) activity_main.xml, fragment_login.xml, dialog_change_password.xml, item_**
- xml파일의 id명은 [what]_ [where]_ []  → home에서 쓰는 TextView라고 치면 text_home_user
- TextView : tv_ 
  <br> EditText : et_
  <br> ImageView : image_
  <br> Button : btn_
  <br> ConstraintLayout : layout_
  <br> Recyclerview : recycler_

<br>

### 4. Method - lowerCamelCase

- 메소드 이름은 **lowerCamelCase**로 작성

  - 각 단어의 첫 문자를 대문자로 표시하되, 이름의 첫 문자는 소문자로 적는다.

- "동사"로 시작하는 "동사구" 형태를 사용하되, 동사 원형만을 사용한다.

  **ex) showList, updateContacts**

- 한 단어 내에서는 대소문자 변경 없이 사용

  **ex) InVisible :arrow_forward: Invisible**

- 약어 사전에 있는 단어는 되도록 약어를 사용

  **ex) UserInterface :arrow_forward: UI 또는 Ui**

- 자주 사용하는 동사는 용법에 맞게 사용

  - **show: Invisible한 것을 Visible하게 바꾸는 동작**
  - **check: 어떤 것을 확인한 후 boolean 또는 값으로 반환하는 동작**
  - **is: 어떤 것인지 확인한 후 boolean으로 반환하는 동작**
  - **has: 어떤것을가지고 있는 확인 후 boolean으로 반환하는 동작**
<br>
### 5. 변수

- 변수 이름 또한 마찬가지로 **lowerCamelCase**로 작성

  **ex) isEnd, viewPagerAdapter**

<br>
# Foldering

```
 📂data
 📂api
 ┣ 📂request
 ┣ 📂response
  📂ui
 ┣ 📂adapter
 ┃ ┣ 📂home
 ┃ ┣ 📂write
 ┣ 📂home
 ┣ 📂write
 ┗📂utils
```

