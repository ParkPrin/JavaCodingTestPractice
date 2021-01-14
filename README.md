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

#### Vector
배열기반으로 동적으로 늘어남
오직 한 순간에 한 스레드만 접근 가능함
시간복잡도

#### ArrayList
배열기반으로 동적으로 늘어남
여러 스레드만 접근 가능함

시간복잡도: 
- 추가/삭제의 경우 O(1)이지만 최악의 경우에는 O(n)
- 조회: 인덱스로 조회시 O(1) contains의 경우 O(n)

#### LinkedList
오직 한 순간에 여러 스레드만 접근 가능함
노드의 연결로 구현되어 있음

#### 시간복잡도
- 추가/삭제: O(1) -> 추가 삭제시 연결되어 있는 노드를 끊고 연결하면 되기 때문에
- 그러나 추가/삭제 시 객체 내용으로 접근시 안에 있는 내용을 순회해야 하기 때문에 O(n) 
- 조회: O(n) -> n만큼 따라가서 찾는 개념임

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

---

### Stack
데이터 삽입과 삭제가 한쪽 끝에서 이루어지는 순서가 있는 특별한 형태의 리스트
Last In First Out(LIFO)

### Java 구현체
Stack: 동기화 기능이 내장되어 있어서 Deque에 비해 성능이 떨어질 수 있음

#### 특징 & 시간복잡도

- Push: Stack에 집어넣는 행위: O(1)
- Pop: Stack에 빼는 행위: O(1) 
- Top: 맨 위에 있는 데이터를 조회한다: O(1)

#### 장점


#### 단점


#### 사용하는 경우


#### 구현하는 방법
1. 배열을 사용하는 방법
=> 엘리먼트의 양이 많아질 때 시간복잡도가 늘어날 가능성이 있다.

2. 연결 리스트를 사용하는 방법
엘리먼트 추가시(Push) head에 추가하면 된다.
엘리먼트 뺄 때(Pop) head에서 제가하면 된다.


---

### Queue
스택과 비슷한 데이터 구조이지만, 데이터 삽입과 삭제가 각기 다른 쪽에서 이루어지는 정렬된 리스트
FIFO(First In First Out)
Queue에서 데이터를 넣는 것을 EnQueue, Queue에서 데이터를 빼는 것은 DeQueue

#### 구현하는 방법
1) 배열을 이용해서 구현
2) LinkedList를 이용해서 구현

#### 오퍼레이션 별 시간 복잡도
- EnQueue: O(1)
- DnQueue: O(1)

#### Java 구현체: Deque
말 그대로 큐의 양쪽 끝에서 삽입과 삭제가 모두 발생할 수 있는 큐
=> 사용용도에 따라서 Queue와 Stack이 될 수 있음

- 추가하기
```
add: 마지막에 Element를 삽입
addFirst: 첫 번째에 Element를 삽입
addLast: 마지막에 Element를 삽입

put : add와 동일하게 작동
put(E e)
putFirst(E e)
putLast(E e)

- offer : add와 동일하게 작동
offer(E e)
offerFirst(E e)
offerLast(E e)

- push : Deque의 앞 부분에 Element를 삽입.
push(E e)

```

- 값 추출 및 제거하기
```
- poll : Deque의 제일 앞 Element를 return 받음. Element를 제거.
Queue에서 Element를 받아오는 과정이라고 생각하면 된다.

poll(): null일 때 Exception 발생이 없음 => 시간복잡도 O(1)
<-> remove() : null일 때 Exception 발생 => 시간복잡도 O(n)
 
pollFirst()
pollLast()

- pop : Deque의 제일 앞 Element를 return 받음. Element를 제거.
Stack에서 Element를 받아오는 과정이라고 생각하면 된다.

pop()

```

- 조회 & 체크

```
- peek : Deque의 제일 앞 Element를 return 받음. Element를 제거하지 않음.

peek(): null일 때 Exception 발생이 없음 => 시간복잡도 O(1)
<-> element() : null일 때 Exception 발생 => 시간복잡도 O(n)
peekFirst
peekLast

- get : First, Last에 있는 Element를 return 받음. Element를 제거하지 않음.

getFirst
getLast

```


## 코딩테스트 코드 정리

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

## 정렬동작 구조와 성능
### 선택 정렬
가장 앞자리부터 찾아서 정렬하는 방식
시간복잡도: O(n^2)
공간복잡도: O(1)

### 삽입 정렬
정렬 범위를 1칸씩 확장해나가면서 새롭게 정렬 범위에 들어온 값을 기존 값들과 비교하여 알맞은 자리에 꼽아주는 알고리즘

```
public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {10, 2, 6, 4, 3, 7, 5};
        
        for (int i = 1; i < arr.length; i++) {
            int standard = arr[i];  // 기준
            int aux = i - 1;   // 비교할 대상
            
            while (aux >= 0 && standard < arr[aux]) {
                arr[aux + 1] = arr[aux];   // 비교대상이 큰 경우 오른쪽으로 밀어냄
                aux--;
            }
            arr[aux + 1] = standard;  // 기준값 저장
        }
        printArr(arr);
    }
    
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

시간복잡도: O(n^2)
공간복잡도: O(1)

### 버블정렬
정렬 대상의 n번째 인덱스와 n+1번째 인덱스를 비교하여 큰값을 뒤로 보내는 방법
```
public static void main(String[] args) {
        int[] a = {254,3,213,64,75,56,4,324,65,78,9,5,76,3410,8,342,76};
        int b;
        for(int i = 0 ; i < a.length ; i ++) {
            for(int j = 0 ; j < a.length -i -1 ; j ++) {
                if(a[j]>a[j+1]) {
                    b = a[j];
                    a[j] = a[j+1];
                    a[j+1] = b;
                }
            }
        }

        for(int i = 0 ; i < a.length ; i ++) {
            System.out.print(a[i] + " ");
        }
    }
```
시간복잡도: O(n^2)
공간복잡도: O(1)


## 자료구조 응용

###LRU(Least Recently Used) cache - LinkedList
캐시는 데이터나 값을 미리 복사해 놓은 임시장소를 가리킨다.
사용이유는 두 가지인데, 
1) 타 데이터와 비교했을 때 접근시간이 오래걸리는 데이터
2) 재사용 빈도가 높은 데이터

#### LRU Cache 기본 개념
OS(운영체제)에서 페이지 교체 알고리즘의 하나로
최근에 가장 오랫동안 사용하지 않은 페이지를 교체하는 기법

캐시공간이 부족하면 가장 최근에 사용하는 않는 항목을 제거한다.

#### 두가지의 운영지침
자료구조는 LinkedList이며

1) 일정한 크기의 메모리에서 순차적으로 페이지가 삽입하다가 페이지가 tail에 도달한 경우
tail에 도달한 페이지를 삭제 한다.

2) 페이지 삽입이 진행되던 도중 삽입되어 있던 데이터가 재사용되면
 재사용된 데이터는 head로 이동함
 
 ###BFS(너비 우선 탐색)알고리즘