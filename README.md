# JavaCodingTestPractice

## 자료구조에 따른 복잡도 정리

<table>
    <thead>
        <tr>
            <td>순서</td>
            <td>자료구조명</td>
            <td>기능</td>
            <td>시간복잡도</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>배열(Array)</td>
            <td>배열 맨 앞 삽입/삭제</td>
            <td>O(n)</td>
        </tr>
        <tr>
            <td>2</td>
            <td>배열(Array)</td>
            <td>배열 맨 뒤 삽입/삭제</td>
            <td>O(1)</td>
        </tr>
        <tr>
            <td>3</td>
            <td>배열(Array)</td>
            <td>배열 중간 삽입/삭제</td>
            <td>O(n)</td>
        </tr>
        <tr>
            <td>4</td>
            <td>배열(Array)</td>
            <td>탐색</td>
            <td>O(1)</td>
        </tr>
        <tr>
            <td>5</td>
            <td>List</td>
            <td>맨 앞/뒤에 삽입, 삭제</td>
            <td>O(1)</td>
        </tr>
        <tr>
            <td>6</td>
            <td>List</td>
            <td>중간 삽입, 삭제</td>
            <td>O(n)</td>
        </tr>
        <tr>
            <td>7</td>
            <td>List</td>
            <td>인덱스 조회</td>
            <td>O(1)</td>
        </tr>
        <tr>
            <td>8</td>
            <td>List</td>
            <td>contains 조회</td>
            <td>O(n)</td>
        </tr>
    </tbody>
</table>

## 자료 구조별 특징, 장단점, 사용하는 경우 정리

### Array
#### 특징

- 같은 타입의 데이터를 나열한 선형구조
- 연속된 메모리 공간에 순차적 저장
- 배열의 크기는 고정, 선업시 배열의 크기를 결정하면 바꿀 수 없다

#### 장점

- 인덱스를 가지고 있어 바로 접근 가능
- 연속된 메모리 공간에 존재하기 때문에 관리가 편리함

#### 단점

- 삽입, 삭제가 오래걸림
- 배열 생성이후 크기 변경 불가
- 연속된 메모리 구조로 공간 낭비 발생가능
- 연속적인 메모리 할당이 필요

#### 사용하는 경우

- 데이터 개수가 정해져있을 시
- 데이터 삽입/삭제가 적을 때

---

### List

### Array
#### 특징

- 데이터를 순차적으로 저장하는 선형구조
- 불연속적 메모리 공간에 저장(공간 낭비 없음)
- 노드를 연결하여 만든 리스트
- 크기가 고정되어 있지 않고, 새로운 요소를 추가할 때 크기 제한에서 자유로

#### 장점

- 삽입과 삭제가 용이
- 크기가 정해져 있지 않고, 동적생성
- 사용한 메모리 재사용

#### 단점

- 검색 성능이 좋지 않다

#### 사용하는 경우

- 크기가 정해져 있지 않을 때
- 삽입과 삭제가 빈번할 때


## 코딩테스트 코드 정

## Java에서 자주 사용되는 클래스의 메소드 기능 정리

### String

- length(): 문자열의 길이
- substring(int 시작점): 시작점부터 끝까지 문자 자르기
- substring(int 시작점, int 끝점): 시작점부터 끝점사이에 있는 문자 자르기
- charAt(int 위치): 문자열 중 특정 위치 문자 가지고오기
- concat(String str): 기존 문자 뒤에 str 문자를 붙임
- contain(CharSequence s): s에 해당하는 문자가 존재하는지 true, false 값으로 표시함
- split(String regex) regex에 해당하는 문자를 기준으로 문자를 나눈다
- toLowerCase() / toUpperCase() : 소문자화 / 대문자화
- compateToIgnoreCase(String str): 대소문자를 무시하고 해당하는 문자와 str 문자가 일치하는지 여부 일치하면 0, 불일치 -1
- equals(String object): 문자열 비교
- startsWith(String prefix): prefix에 해당하는 문자로 시작여부, boolean 타입
- endsWith(String suffix): suffix에 해당하는 문자로 종료여부, boolean 타입
- replace(char 이전문자, char 바꿀문자): 문자 교체

### StringBuilder

- length() : 문자열의 길이
- capacity() : 문자열의 길이 + 16자리
- append(String 새로운 문자) : 기준 문자 뒤에 새로운 문자를 더한다.
- insert(int 들어갈 위치, String 들어갈 문자) : 들어갈 위치에 들어갈 문자를 넣는다.
- replace(int 시작점, int 끝점, String 대체할 문자): 시작점부터 끝점사이에 있는 문자를 대체할 문자로 교체한다
- delete(int 시작점, int 끝점): 시작점부터 끝점 사이에 있는 문자를 제거한다
- reverse(): 현재 문자를 역순으로 한다.
- toString(): 문자열화 시킨다
  