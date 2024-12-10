# '지하철 노선도 경로 조회' 기능명세서

### 지하철 노선도 초기 설정
- 지하철역
- 지하철 노선
- 노선과 역의 관계(거리, 시간)

### 경로 조회 기능
- 출발역과 도착역을 입력받아 경로 조회
- 경로 조회 시 총 거리, 총 소요 시간 출력
- 경로 조회 기준 두 가지
  1) 최단 거리
  2) 최소 시간

### [ERROR] 메시지 + 재입력
- 경로 조회 시 출발역과 도착역 동일할 때
- 경로 조회 시 출발역과 도착역이 연결되어 있지 않을 때
- 그 외 비정상 작동할 때

### 기능 작동 흐름
0) 지하철 정보 초기화
1) 메인 기능 선택
   - 종료 선택 시 종료
2) 경로 기준 선택
   - 돌아가기 선택 시 메인 기능 선택으로 돌아가기
3) 출발역 입력
4) 도착역 입력
5) 조회 결과 출력
6) 메인 기능 선택으로 회귀

### 구현할 것들
- 선택할 메인 기능 enum 클래스
- 경로 기준 enum 클래스
- 거리 edge enum 클래스
- 시간 edge enum 클래스
- 거친 경로 모델
  - 총 거리
  - 총 소요 시간
  - 거친 역
- 조회 결과 dto
  - 총 거리
  - 총 소요 시간
  - 거친 역
- 최단 거리에 따른 그래프 모델
- 최소 시간에 따른 그래프 모델

### 주의점🚨
- Application 클래스에 있는 Scanner를 사용하고 별도의 Scanner 객체를 만들지 않는다 [✅]
- 프로그래밍 요구사항 - Station, Line [✅]
  - Station, Line 클래스를 활용하여 지하철역과 노선을 구현해야 한다.
  - 제공하는 각 클래스의 기본 생성자를 추가할 수 없다.
  - 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
  - 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.
- 프로그래밍 요구사항 - StationRepository, LineRepository [✅]
  - 작성된 메서드 수정 불가, 메서드 추가 가능
- 서로 연결되지 않은 두 정점 사이의 최단경로를 계산하려는 경우, null이 반환
  - 이에 대한 예외를 적절히 처리해서 NPE가 발생하지 않도록🚨 [✅]
- 단위 상수화