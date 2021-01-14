package me.parkprin.codingtest.tree.quiz1;


class Solution {
    /**
     # 후위탐색

     주어진 이진 트리에서 후위탐색(왼쪽, 오른쪽, 루트 순서)시
     n번째에 해당하는 값을 출력하라.

     1
     2   3
     4 5 6 7
     => 4 5 2 6 7 3 1
     *
     * 시간복잡도 O(n)
     * 공간복잡도 최대 O(n) 평균적으로 O(logn)
     */
    public static void main(String[] args) {
        Node node  = new Node(9)
                .setLeft(new Node(2).setLeft(new Node(1)).setRight(new Node(5)))
                .setRight(new Node(3).setLeft(new Node(4)).setRight(new Node(9)));
        new Solution().solution(node, 4);
    }

    private int count = 0;

    public void solution(Node node, int index){
        if (node != null){
            solution(node.getLeft(), index);
            solution(node.getRight(), index);
            count++;
            if (count == index) System.out.println(node.getValue());
        }
    }


}
