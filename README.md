**Spring Boot 기반 커뮤니티 사이트 구현 프로젝트**  

---

## 📋 프로젝트 개요  
이 프로젝트는 **Spring Boot**를 처음으로 사용하여 **커뮤니티 사이트**를 구현하는 연습을 목적으로 진행되었습니다.  
간단한 게시판 기능을 통해 백엔드의 흐름을 이해하고, CRUD 기능을 학습했습니다.

주요 기능들을 구현하려했지만 첫 스프링부트라 부족한 점이 많습니다.

---

## 🚀 주요 기능  
- **게시글 작성**: 사용자가 제목과 내용을 입력하여 게시글을 작성할 수 있습니다.  
- **게시글 목록 조회**: 게시글 리스트를 불러와 화면에 출력합니다.  
- **게시글 수정 및 삭제**: 작성된 게시글을 수정하거나 삭제할 수 있습니다.  
- **템플릿 엔진 연동**: HTML 템플릿을 사용하여 정적 페이지와 서버 데이터를 연동했습니다.  

---

## 🛠️ 기술 스택  
- **Backend**: Java, Spring Boot  
- **Build Tool**: Gradle  
- **Database**: H2 Database (In-memory)  
- **Frontend**: HTML, CSS, JavaScript  
- **Template Engine**: Thymeleaf  
- **Version Control**: Git & GitHub  

---

## 🧑‍💻 개발자 정보  
- **개발자**: 오승안 / OH SEUNG ANH 
- **이메일**: ahn980321@gmail.com , dhtmddks98@naver.com 
- **GitHub**: https://github.com/OurOh
- **개인블로그**: https://ouroh.tistory.com/  
---

## 🗂️ 프로젝트 구조  
```plaintext
kdtboot/
│
├── gradle/              # Gradle 설정 파일  
├── src/  
│   ├── main/  
│   │   ├── java/net/musecom/kdtboot/  
│   │   │   ├── controller/         # 컨트롤러 (HomeController)  
│   │   │   ├── dto/                # 데이터 전송 객체  
│   │   │   ├── entity/             # 엔티티 클래스  
│   │   │   ├── repository/         # 리포지토리 인터페이스  
│   │   │   ├── service/            # 서비스 클래스  
│   │   │   └── KdtbootApplication.java  # 메인 애플리케이션 실행 파일  
│   │   ├── resources/  
│   │   │   ├── templates/          # Thymeleaf 템플릿 (HTML)  
│   │   │   │   ├── index.html      # 메인 페이지  
│   │   │   │   ├── list.jsp        # 게시글 목록 페이지  
│   │   │   │   ├── view.html       # 게시글 상세 조회  
│   │   │   │   └── write.html      # 게시글 작성 페이지  
│   │   │   ├── static/             # 정적 리소스 (CSS, JS)  
│   │   │   │   ├── css/  
│   │   │   │   ├── js/  
│   │   │   │   ├── fonts/  
│   │   │   └── application.yml     # 프로젝트 설정 파일  
│   │
│   └── test/  
│       └── java/net/musecom/demo/  # 테스트 코드  
│
├── build.gradle          # Gradle 의존성 관리 파일  
├── gradlew               # Gradle Wrapper 실행 파일  
├── README.md             # 프로젝트 설명서  
└── settings.gradle       # Gradle 설정 파일
```
---


