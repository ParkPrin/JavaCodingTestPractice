# linkedlist 역순으로 출력하기
예) 1->2->3을 3->2->1로 표현하기

## 출력하는 두 가지 방법 

### 순차적으로 처리하는 방법
```
        LinkedNode current = this.head;
        LinkedNode prev = null;
        LinkedNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.tail = this.head;
        this.head = prev;
```

### 재귀함수를 사용하는 방법
```
    private void reverse() {
        LinkedNode head = this.head;
        this.head = reverseRecursive(head);
        this.tail = head;
    }


    private LinkedNode reverseRecursive(LinkedNode node){
        if (node == null || node.next == null) return node;

        LinkedNode newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
```

### 일반재귀와 꼬리재귀
