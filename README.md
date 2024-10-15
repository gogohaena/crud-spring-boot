# Spring Boot CRUD Application with MariaDB

이 프로젝트는 Spring Boot, MariaDB, JPA를 사용한 간단한 사용자 관리 CRUD (생성, 조회, 업데이트, 삭제) 웹 애플리케이션입니다.

## 주요 기능
- **생성(Create)**: 새로운 사용자를 시스템에 추가합니다.
- **조회(Read)**: 모든 사용자 목록을 조회하거나, 특정 사용자의 정보를 조회합니다.
- **업데이트(Update)**: 사용자 정보를 수정합니다 (이름 및 이메일).
- **삭제(Delete)**: 시스템에서 사용자를 삭제합니다.

## 사용 기술
- Java 17
- Spring Boot 3.3.4
- Spring Data JPA
- Gradle
- MariaDB 11.4.3
- IntelliJ IDEA
- Postman

## 시작하기

### 1. 저장소 클론
```
git clone https://github.com/gogohaena/crud-spring-boot.git
cd crud-spring-boot
```

### 2. MariaDB 설치 및 데이터베이스 설정
1. MariaDB를 설치합니다. MariaDB는 [MariaDB 공식 사이트](https://mariadb.org/download/?t=mariadb&p=mariadb&r=11.4.3&os=windows&cpu=x86_64&pkg=msi&mirror=blendbyte)에서 다운로드 가능합니다.
2. MariaDB 서버를 시작한 후, 아래 SQL 명령을 사용하여 MariaDB에서 데이터베이스와 유저를 생성합니다:
  ```
  CREATE DATABASE crud_db;
  CREATE USER 'cruduser'@'localhost' IDENTIFIED BY 'password';
  GRANT ALL PRIVILEGES ON crud_db.* TO 'cruduser'@'localhost';
  FLUSH PRIVILEGES;
  ```

### 3. 환경변수 설정
운영체제에 따라 터미널에서 아래 명령어를 입력해 환경변수를 설정합니다.
- Windows:
  ```
  set DB_USERNAME=cruduser
  set DB_PASSWORD=password
  set DB_HOST=localhost
  set DB_PORT=3306
  set DB_NAME=crud_db
  ```
- Linux/Mac:
  ```
  export DB_USERNAME=cruduser
  export DB_PASSWORD=password
  export DB_HOST=localhost
  export DB_PORT=3306
  export DB_NAME=crud_db
  ```

### 3. 애플리케이션 설정
`src/main/resources/application.yml` 파일에서 MariaDB 연결 설정을 아래와 같이 구성합니다:
```
spring:
  application:
    name: crud-spring-boot
  datasource:
    url: jdbc:mariadb://${DB_HOST:localhost}:${DB_PORT:3306}/${DB_NAME:crud_db}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 4. 애플리케이션 빌드 및 실행
Gradle을 사용해 애플리케이션을 빌드하고 실행합니다:
```
./gradlew bootRun
```

애플리케이션은 `http://localhost:8080`에서 실행됩니다.

## API Endpoints

### 1. 모든 사용자 조회
```
GET /api/users
```

### 2. 특정 사용자 ID로 조회
```
GET /api/users/{id}
```

### 3. 새로운 사용자 생성
```
POST /api/users
```
- 요청 바디 (JSON):
  ```
  {
    "name": "Gildong Hong",
    "email": "hong@example.com"
  }
  ```

### 4. 기존 사용자 정보 업데이트
```
PUT /api/users/{id}
```
- 요청 바디 (JSON):
  ```
  {
    "name": "Gildong Hong",
    "email": "gildong@example.com"
  }
  ```

### 5. 사용자 삭제
```
DELETE /api/users/{id}
```

## API 테스트
[Postman](https://www.postman.com/) 또는 [cURL](https://curl.se/)을 사용하여 API를 테스트할 수 있습니다. 새로운 사용자를 생성하는 cURL 명령어 예시는 아래와 같습니다:

```
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{"name": "Gildong Hong", "email": "hong@example.com"}'
```
