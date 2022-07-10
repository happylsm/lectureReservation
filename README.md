# 예약시스템 api   
   
## 사용기술
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/jpa-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> <img src="https://img.shields.io/badge/swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white"> <img src="https://img.shields.io/badge/Junit-25A162?style=for-the-badge&logo=JUnit5&logoColor=white"> <img src="https://img.shields.io/badge/H2DB-01B4E4?style=for-the-badge&logoColor=white">

## Comments
* H2 DB
  * 로컬 환경에서 테스트를 할 때 간편하고 가벼운 H2 db를 사용했습니다. 휘발성 데이터이기 때문에 따로 물리 데이터를 만들 필요가 없다는 장점이 있음. 데이터 추가는 swagger에서 간편하게 할 수 있음
* JPA
  * 유지보수와 생산성(반복적인 코드 지양)을 높이기 위해 jpa를 사용
* api 케이스가 단순하기 때문에 return type은 Map과 DTO 두 케이스를 사용
* id값 생성
  * 각 id 값은 데이터 생성시 자동으로 추가되도록 코드를 작성함. RandomStringUtils.randomNumeric() 을 사용해 랜덤으로 들어가도록 만듬

## Dependencies

|Dependence|Version|
|------|---|
|spring-boot|2.6.7|
|spring-boot-starter-data-jpa|2.6.7|
|com.h2database:h2||
|springfox-swagger-ui||
|org.projectlombok:lombok||

## erd
![image](https://user-images.githubusercontent.com/48234814/178152935-c583753d-9022-4037-81cb-418cbbefa7cf.png) 

## Swagger UI
아래와 같이 총 6개의 api를 확인할 수 있음   
http://localhost:8080/swagger-ui.html   
![image](https://user-images.githubusercontent.com/48234814/178153091-8b13fe00-d6e3-468b-a192-89b9ac944da8.png)   
