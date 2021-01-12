# 스택 뒤집기
 
문제 재귀를 사용해서 스택을 뒤집는 코드를 작성하라

오직 하나의 스택만을 이용하여 구현할 것

## 데이터 삽입

```
        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            new Solution().solution(stack);
            while (!stack.empty()){
                System.out.println(stack.pop());
            }
    
        }
```

## 솔루션

```
    public void solution(Stack<Integer> stack) {
       reverseStack(stack);
    }

```


## 재귀1 - stack에서 데이터 빼내기

```
    public void reverseStack(Stack<Integer> stack){
        int temp = 0;
        if (!stack.empty()){
            temp = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, temp);
        }
    }
```


## 재귀2 - stack 삽입

```
    public void insertAtBottom(Stack<Integer> stack, int input){
        if (stack.empty()){
            stack.push(input);
        } else {
            int element = stack.pop();
            insertAtBottom(stack, input);
            stack.push(element);
        }
    }
```

## 시간복잡도, 공간복잡도
- 시간복잡도 O(n^2)
- 공간복잡도 O(n)

## 문제의 목적
효율성을 측정하는 문제라기 보다는 사고하는 능력, 재귀에 대한 숙련도를 평가하는 문제