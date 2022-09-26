# 4-backend-Zoe-inBox

## 📹 개발자 포트폴리오 영상을 업로드하고 조회할 수 있는 사이트 📹

> 팀 프로젝트입니다. 팀 구성은 백엔드 1명, 프론트 1명으로 저는 백엔드 개발을 맡았습니다.

<br>


## :pushpin: 사이트 실행 링크

:clipboard: [사이트실행링크](https://in-box.co.kr/)


<br>

## :pushpin: 프로젝트 설명


> 코로나 때문에 제한된 세계 여행 대신 랜선으로나마 각 나라 창문 밖 풍경을 볼 수 있는 사이트인 WindowSwap의 오마주로
> 자신의 개발자 포트폴리오 영상을 업로드하고 다른 개발자들의 포트폴리오 영상을 조회할 수 있는 사이트입니다.
> Setting 페이지에서 기본적인 설정을 한 뒤 영상 조회 페이지에서 영상 조회를 할 수 있습니다.


<br>


## 📌 프로젝트 설계
### 프로젝트 설계

![image](https://user-images.githubusercontent.com/98700133/192185739-e8f5a95c-b806-4b67-a3e7-63dcec05958d.png)


<br>

### 프로젝트 DB 테이블
- db diagram 이용해서 테이블 설계

:clipboard: [테이블과 테이블 구성요소](https://closed-glade-095.notion.site/ERD-7c5b5591bc4049488209e1f8cf4c7439)


<br>

### 프로젝트 API 문서


:clipboard: [API 문서](https://closed-glade-095.notion.site/IN-BOX-API-def2c1b66a254d8c98d76067260c553d)


<br>


## 📁 폴더 구조



<details>
    <summary> 🧷 프로젝트 구조 펼쳐보기</summary>

```bash
main
├── java
│   ├── inbox.inbox
│   │   ├──  config
│   │   │   ├──  ApplicationContextConfig
│   │   │   ├──  CorsConfig
│   │   │   └──  WebMvcConfig
│   │   ├──  cookie # SameSite가 아닐 때 요청에 대해 쿠키가 바로 받아와지지 않고 다음 요청에 받아와지는 문제 해결하기 위한 API 작성 
│   │   │   ├──  CookieController
│   │   │   └──  CookieResponseMessage
│   │   ├──  exception # 예외 관련 디렉토리
│   │   │   ├──  CustomizedExceptionHandler
│   │   │   ├──  DateValidated
│   │   │   ├──  DateValidator
│   │   │   ├──  ExceptionMessage
│   │   │   ├──  ValidationGroup
│   │   │   ├──  ValuesAllowed
│   │   │   └──  ValuesAllowedValidatior
│   │   ├──  filter # 영상 썸네일 디렉토리 (기획 상 공통명칭 filter 였다가 프로젝트 막바지에 Thumbnail로 바뀜)
│   │   │   └──  FilterController
│   │   ├──  logging
│   │   │   └──  LoggingInterceptor
│   │   ├──  portfolio # 포트폴리오 디렉토리
│   │   │   ├──  Portfolio
│   │   │   ├──  PortfolioConfirm
│   │   │   ├──  PortfolioConfirmDto
│   │   │   ├──  PortfolioConfirmNotFoundException
│   │   │   ├──  PortfolioConfirmRepository
│   │   │   ├──  PortfolioConfirmUnauthorizedException
│   │   │   ├──  PortfolioController
│   │   │   ├──  PortfolioDto
│   │   │   ├──  PortfolioFile
│   │   │   ├──  PortfolioFileRepository
│   │   │   ├──  PortfolioNotFoundException
│   │   │   ├──  PortfolioRangeConflictException
│   │   │   ├──  PortfolioRepository
│   │   │   ├──  PortfolioResponseMessage
│   │   │   └──  PortfolioService
│   │   ├──  utils
│   │   │   ├──  ConstantManager
│   │   │   ├──  CookieManager
│   │   │   └──  UserInfoManager
│   │   └─── app
├── resources
│   ├── static
│   │  └──  index.html
│   ├── templates
│   │  └──  mail.html
│   ├── application.yml
│   ├── log4jdbc.log4j2.properties
│   ├── logback-spring-local.xml
└   └── logback-spring-prod.xml
```


<!-- summary 아래 한칸 공백 두고 내용 삽입 -->

</details>

<br>


## 📌 개발 스택

**주요 기술**

`Java` `Spring` `MySQL`

**경험해본 기술**

`JPA` `AWS EC2 & RDS & ElasticSearch` `NGINX` `Docker` `Jenkins`
