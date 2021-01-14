package me.parkprin.codingtest.queue.quiz4;


class Solution {
    /**
     *
     # 큐를 사용해서 스택을 구현하라.

     큐 인스턴스를 사용해서 Stack 인터페이스를 구현하라.

     pop() 오퍼레이션은 가장 마지막으로 추가한 값을 꺼내야 한다.
     push() 오퍼레이션은 값을 추가한다.
     큐가 제공하는 offer(), poll(), isEmpty(), size()만 사용할 수 있다. Deque는 사용하지 못한다.
     (힌트) 큐 인스턴스를 여러개 사용할 수 있다.

     두 가지 솔루션
     솔루션 1. 데이터를 뺄 때 1개를 제외한 나머지 데이터는 다른 Queue에 옮겨놓는다. <- push가 O(1)이다.
     솔루션 2. 데이터를 집어 넣을 때 역순으로 집어넣는다. <- pop이 O(1)이다.

     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(10);
        System.out.println("데이터 사이즈: " +stack.size());
        System.out.println("현재 데이터는? " +stack.peek());
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("데이터 사이즈: " +stack.size());
    }





}
