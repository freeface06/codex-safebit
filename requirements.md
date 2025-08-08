# 구비트 안전점검 관리자 페이지 요구사항

## 1. 프로젝트 개요
- **프로젝트명**: 구비트 안전점검 관리자 페이지
- **목표**: 관리자 전용 웹 시스템을 통해 안전점검 관련 서비스, 위탁업체, 점검자, 시설, 스케줄, 보고서 등을 통합 관리
- **개발 환경**:
  - **Backend**: Spring Boot 3.x (Java 21)
  - **Frontend**: Thymeleaf + jQuery (관리자 UI)
  - **DB**: MySQL 8.x
  - **JDK**: 21
  - **빌드도구**: Maven
  - **ORM**: Spring Data JPA
  - **보안**: Spring Security (JWT 인증)
  - **배포 환경**: Spring Boot 내장 Tomcat
  - **API 형식**: REST API + Thymeleaf View Controller 혼합
  - **패키지 구조 루트**: `com.goobit.safebit`

---

## 2. 개발 진행 지침
- **프론트엔드(View) 우선 개발**: 모든 메뉴/화면은 화면정의서(PPT)와 텍스트 화면기획서 기준으로 **UI(View)와 HTML/CSS/JS를 먼저 생성**한 뒤, 이후 백엔드 기능을 연결하는 순서로 개발.
- 관리자 페이지는 Thymeleaf 템플릿과 jQuery로 구현.
- 화면 개발 시 서버 연동 전 Mock 데이터로 테스트 가능하도록 구현.

---

## 3. 환경 세팅
1. **프로젝트 생성**
   - Spring Initializr로 Spring Boot 프로젝트 생성
   - Dependencies: Spring Web, Spring Data JPA, MySQL Driver, Spring Security, Thymeleaf, Validation, Lombok
2. **DB 연결**
   - `application.yml`에 MySQL 연결 설정 (`serverTimezone=Asia/Seoul`, `characterEncoding=UTF-8`)
   - `dev` / `prod` 프로파일 분리
3. **JWT 인증 구조 세팅**
   - `SecurityConfig`, `JwtUtil`, `JwtAuthenticationFilter`(OncePerRequestFilter 상속), `/auth/login`, `/auth/refresh` 엔드포인트
   - 비밀번호 암호화: BCryptPasswordEncoder
4. **전역 예외 처리**
   - `GlobalExceptionHandler` 구현
5. **로그 설정**
   - `logback-spring.xml` 구성
   - 운영/개발 환경별 로그 레벨 분리

---

## 4. 메뉴 구조 및 기능 정의
### 4.1 서비스 관리자
- 서비스 정보 관리 (등록/수정, CI 관리, 계약상태 계산)
- 공통코드 관리 (등록/수정/삭제)
- 코드그룹 관리 (등록/수정/삭제)
- 관리자 관리 (등록/수정, 비밀번호 초기화)
- **관리자 그룹 관리** (등록/수정/삭제, 권한셋 매핑)

### 4.2 위탁업체 관리
- 위탁업체 관리 (등록/수정/상세/점검내역, CI 관리, 계약상태 관리)
- 위탁업체 관리자 관리 (등록/수정, 비밀번호 초기화)
- 소속 관리 (등록/배정/배정취소)
- 점검자 관리 (승인/수정/상세/비밀번호 초기화/점검내역)

### 4.3 점검 관리
- 점검항목 관리 (등록/수정/삭제, 사용여부)
- 시설 관리 (등록/수정/삭제, 시설별 점검항목 관리, 동·구역 관리)
- 체크리스트 관리 (등록/수정/삭제, 이력보기, 버전관리, 그룹 관리)
- 스케줄 관리 (등록/삭제, 배정/배정취소, 상태관리, 위탁업체 기본값=자체점검)

### 4.4 보고서 관리
- 보고서 폼 관리 (**보류**)
- 보고서 (목록/상세/PDF 다운로드, 권한 제한)

---

## 5. 공통 개발 규칙
- 모든 API는 JWT 인증 기반
- CRUD 기능은 Controller → Service → Repository 구조로 구현
- Entity와 DTO는 분리
- DB 변경은 Liquibase 또는 Flyway 사용 권장
- 날짜·시간은 `LocalDateTime` 사용, 직렬화 포맷 `yyyy-MM-dd HH:mm:ss`
- Git 커밋 규칙: `feat:`, `fix:`, `refactor:`, `docs:` 등 Prefix 사용
