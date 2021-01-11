# linkedlist의 중간 값 출력하기

## Map을 이용한 방법

```
        솔루션 1. HashMap을 이용하여 푸는 경우
        LinkedList를 for문으로 돌리면서 Map에 들어간 순서를
        key값으로 LinkedItem 숫자를 value로 넣는다.
        전체 값중 절반을 계산하여 중간값을 출력한다.
        
        시간복잡도: O(n)
        공간복잡도: O(n)
```

## 반복문 2번 사용하는 방법

```
        솔루션 2. 두 번의 반복을 통해서 LinkedList를 푸는 방법
        LinkedList의 사이즈를 먼저 얻은 후
        중간값을 계산하여 해당 LinkedItem의 number를 get하는 방식 
        
        시간복잡도: O(n)
        공간복잡도: O(1)
```

## StringBuilder를 이용하는 방법

```
        솔루션 3. StringBuilder를 통해서 푸는 경우, 솔루션 2와 2번 반복이 동일함
        for문을 통하여 반복할 때마다, LinkedItem에 있는 number를 StringBuilder 객체에
        append 한다. 구분점을 주기 위해서 ","를 추가하고 마지막에는 제외한다.
        for문이 마치고 나서 ","를 기준으로 split를 하면, String 배열이 생성이 된다.
        이 후 중간값을 계산하여 String 배열에서 추출한다
        
        시간복잡도: O(n)
        공간복잡도: O(n)
```



