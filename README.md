# 뷰티 추천 웹 서비스 (beauty-recommend-web)

스마트 뷰티 미러(https://github.com/P-Sho/smartmirror)의 Python 키오스크 앱에 있던 화장품 추천 데이터를
**Java / Spring Boot + MyBatis + MySQL 웹 서비스**로 옮기는 프로젝트입니다.

> 이 README는 진행하면서 직접 채웁니다. `TODO` 로 표시된 칸은 실제로 해 본 뒤에만 씁니다.

## 기술 스택
- Java 17 (JDK 20으로 빌드) · Spring Boot 4.1 · Spring MVC · Thymeleaf
- MyBatis 4.1 (직접 작성한 SQL) · MySQL 8.0
- JUnit 5 · Gradle

### 왜 JPA가 아니라 MyBatis인가
TODO: 공공기관 시스템에서 쓰는 전자정부표준프레임워크와의 관계, SQL을 직접 관리할 때의 장단점을 내 말로 정리

## 실행 방법
```bash
# 1) DB 만들기 + 데이터 넣기 (MySQL 8.0, 포트 3308 기준)
mysql -u root -p -P 3308 < db/schema.sql
mysql -u root -p -P 3308 --default-character-set=utf8mb4 < db/data.sql

# 2) 실행 (비밀번호는 환경변수로)
DB_PASSWORD=비밀번호 ./gradlew bootRun
# → http://localhost:8080/products
```
Windows PowerShell: `$env:DB_PASSWORD="비밀번호"; .\gradlew bootRun`

## 구조
```
요청 → ProductController → ProductService → ProductMapper(+ mapper/ProductMapper.xml) → MySQL
```
| 패키지 | 역할 |
|---|---|
| `controller` | 요청을 받고 화면(Thymeleaf)을 고른다 |
| `service` | 업무 규칙, 예외 판단 |
| `mapper` | SQL 실행 (XML에 SQL 작성) |
| `domain` | 테이블 한 행을 담는 객체 |

## ERD
TODO: product 테이블 (`db/schema.sql`) 그림

## 기능
- [x] 제품 목록 (280개)
- [ ] 제품 상세
- [ ] 검색: 피부타입 · 퍼스널컬러 · 종류 · 이름
- [ ] 페이징
- [ ] 관리자 등록 · 수정 · 삭제 + 입력값 검증
- [ ] 전역 예외 처리 · 에러 페이지 · 로그
- [ ] 서비스 계층 테스트
- [ ] 검색 컬럼 인덱스 + EXPLAIN 전후 비교

## 데이터 이관 (SQLite → MySQL)
원본: smartmirror `cosmetics.db`의 `products` 테이블 280건
- 가격(`price`)이 숫자가 아니라 `'21,000'` 같은 문자열로 저장된 행이 **70건** → 쉼표를 제거해 정수로 변환
- 빈 문자열(`''`)로 들어 있던 피부타입·퍼스널컬러·number 값 → `NULL`로 변환
- 베이스 제품(120개)은 피부타입만, 색조 제품(160개)은 퍼스널컬러만 값이 있음
- 원본 `number` 컬럼(베이스 제품만 20~23)은 `shade_no`로 옮김 — TODO: 원래 의미 확인

## 트러블슈팅
TODO: 진행하면서 실제로 겪은 문제 → 원인 → 해결을 기록 (지어내지 않기)

## 배운 점
TODO
