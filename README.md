# 4-backend-Zoe-inBox

## 📹 개발자 포트폴리오 영상을 업로드하고 조회할 수 있는 사이트 📹

> 팀 프로젝트입니다. 팀 구성은 백엔드 1명, 프론트 1명으로 저는 백엔드 개발을 맡았습니다. <br>
> 스프링부트를 이용한 백엔드 개발, 자동화 배포 서버 구축, 로그 수집 및 시각화를 했습니다.

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
### 프로젝트 구조

![001](https://user-images.githubusercontent.com/98700133/192776047-1db386b0-c80f-4dfc-b4ff-c82a0eccd6f3.png)

<br>

#### 자동 배포 서버

> github에 푸시하면 jenkins에서 repo를 clone 받음 -> 프로젝트 빌드 & docker image로 빌드 -> docker private registry에 docker image push -> 운영 서버에서 docker image pull 내려받음 -> 백엔드 & 프론트 서버 docker conatiner 띄우기 -> 완료 시 슬랙에 알림

#### 운영 서버

> NGINX에 ssl 인증서 적용, 80포트로 접속하는 유저 443포트로 proxy pass

#### 로그 수집 및 시각화 서버

> docker container로 logstash 서버 띄움 -> logstash에서 AWS elastic search로 수집한 로그 보내도록 config 작성


<br>

### 프로젝트 DB 테이블
- db diagram 이용해서 테이블 설계

:clipboard: [테이블과 테이블 구성요소](https://closed-glade-095.notion.site/ERD-7c5b5591bc4049488209e1f8cf4c7439)


<br>

### 프로젝트 API 설계


:clipboard: [API 설계](https://closed-glade-095.notion.site/IN-BOX-API-def2c1b66a254d8c98d76067260c553d)


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

<br>

## 📌 주요 기능
 
 * 포트폴리오 업로드
    
    * .mp4/ .avi/ .webm/ .wmv/ .mov 확장자일 때만 유효성 검사를 통과
    * 파일 이름은 sha256로 해싱 된 정보 받기(64글자 고정)
    * 포트폴리오 range 문자열로 정보 받아도 db에는 숫자형으로 저장
    * 차후 포트폴리오 업로드 시 다양한 파일을 업로드할 가능성을 대비해서 portfolio와 file 테이블 따로 둠
    

* 이메일 인증번호 발송 및 인증번호 확인
    
    * 6자리의 랜덤 한 수 유저 이메일로 발송
    * 인증번호를 보낸 유저를 식별하기 위해서 유저 이메일 정보, ip, 유저 에이전트 정보 db에 저장
    * 유저 에이전트 정보는 유저 정보 수집을 최소화하기 위해서 sha256으로 해싱
    * db에 저장된 정보를 통해서 인증번호 확인
    

<br>

## 📌 문제사항과 해결 방안

### 1.

:clipboard: [문제/해결 방안1 링크](https://closed-glade-095.notion.site/in-box-1-81b92965a5d84ed1b2671ad33faf41c1)

### 2.

:clipboard: [문제/해결 방안2 링크](https://closed-glade-095.notion.site/in-box-2-ef41754e9ab34d3cab95832ad47c0f93)


### 3.

:clipboard: [문제/해결 방안3 링크](https://closed-glade-095.notion.site/in-box-3-17adbff4f324437c89c29f1c9c2c20f1)


<br>


## 📌 개선하고 싶은 점 

이메일 인증번호 확인 시 db에서 인증 요청한 유저의 ip와 유저 에이전트가 일치하는지도 검증합니다. 그런데 만약 해당 유저가 이동 중이라서 ip가 바뀌는 상황이라면 인증번호가 일치하더라도 인가되지 않는 문제가 있는데 이에 대한 보완이 필요할 것으로 보입니다.



<br>


## 📌 실제 사이트 사진


