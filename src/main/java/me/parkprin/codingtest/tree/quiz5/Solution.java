package me.parkprin.codingtest.tree.quiz5;


import java.util.*;

class Solution {
    private Map<Integer, Integer> map = null;

    public Solution(){
        this.map = new HashMap<Integer, Integer>();
    }
    /**
     # 가장 가까운 공통 조상 찾기
     주어진 이진 트리에서 두 노드의 가장 가까운 공통 조상(Lowest Common Ancestor)을 찾는 코드를 작성하라.

     LCA(2, 3) = 1
     LCA(4, 5) = 2
     LCA(3, 4) = 1
     LCA(3, 6) = 3
     LCA(4, 6) = 1


     1
     2 3
     4 5 6
     */
    public static void main(String[] args) {
        Node node  = new Node(1)
                .setLeft(new Node(2)
                        .setLeft(new Node(4).setLeft(new Node(8)).setRight(new Node(9)))
                        .setRight(new Node(5).setLeft(new Node(10)).setRight(new Node(11))))
                .setRight(new Node(3)
                        .setLeft(new Node(6).setLeft(new Node(12)).setRight(new Node(13)))
                        .setRight(new Node(7).setLeft(new Node(14)).setRight(new Node(15))));
        System.out.println(new Solution().solution(node, 12, 15));

    }

    /*public int solution(Node node, int firstNum, int secondNum){
        int result = 0;
        int firstNumParant = 0;
        int secondNumParant = 0;
        if (node != null){
            result = node.getValue();
            inOrderList(node, result);
        }
        firstNumParant = map.get(firstNum);
        secondNumParant = map.get(secondNum);
        while(node != null){
            if (firstNumParant == secondNumParant){
                return firstNumParant;
            }

            while (secondNumParant != result){
                secondNumParant = map.get(secondNumParant);
                if (firstNumParant == secondNumParant){
                    return firstNumParant;

                } else if (secondNumParant == result) {
                    break;
                }
            }
            secondNumParant =secondNum;
            firstNumParant = map.get(firstNumParant);
        }

        return result;
    }*/

    /*
    솔루션 2.
    1) HashMap을 이용하여 족보를 만든다.
    2) Set에 첫번째 수의 바닥 레벨부터 위로 올라가면서 족보를 저장한다.
    3) 두번째 수의 아래부터 올라가면서 set 안에 값이 존재하는지 확인하다.

    시간복잡도 O(n)
    공간복잡도 O(n)
     */
    public int solution(Node node, int firstNum, int secondNum){
        int result = 0;

        int firstNumParant = 0;
        Set<Integer> set = new HashSet<Integer>();
        int secondNumParant = 0;
        if (node != null){
            result = node.getValue();
            inOrderList(node, result);
        }
        firstNumParant = map.get(firstNum);
        secondNumParant = map.get(secondNum);
        if (firstNum == secondNum) return firstNum;
        if (firstNumParant == secondNumParant) return firstNumParant;

        set.add(firstNumParant);
        while(firstNumParant != result){
            firstNumParant = map.get(firstNumParant);
            set.add(firstNumParant);
        }
        while(secondNumParant != result){
            secondNumParant = map.get(secondNumParant);
            if (set.contains(secondNumParant)) return secondNumParant;
        }

        return result;
    }

    public void inOrderList(Node node, int parantNum){
        if (node != null){
            int childNum = node.getValue();
            map.put(childNum, parantNum);
            inOrderList(node.getLeft(), childNum);
            inOrderList(node.getRight(), childNum);
        }

    }




}
