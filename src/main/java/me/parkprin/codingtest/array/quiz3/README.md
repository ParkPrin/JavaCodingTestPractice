# 배열 퀴즈 3
숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 두 수를 더해 target 숫자를 만들 수 있는 인덱스 두 개를 찾는 함수를 작성하라.

제약사항 1. numbers 배열에 중복되는 숫자 없음

제약사항 2. target 숫자를 만들 수 있는 조합은 하나 뿐
```
솔루션 1. for문 안에 for 문으로 접근
        단 상위 for문은 (전체 갯수 -1)만 반복하고
        하위 for문은 상위 for문 시작보다 +1로 시작하여 전체갯수만큼 반복한다.
        시간복잡도: O(n^2)
        공간복잡도: O(1)

        for (int i = 0; i < numbers.length-1; i++){
            for (int j = i+1; j < numbers.length; j++){
                if (target == numbers[i] + numbers[j]){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
```

```
솔루션 2. Map을 만들고 numbers안에 있는 값을 key로 넣은다음 for문을 돌면서
        target-index에 해당하는 키조회시 존재하는 경우 value값을 각각 추출하는 방법
        시간복잡도 O(n)
        공간복잡도 O(n)
         */

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();


        for (int j = 0; j < numbers.length; j++ ){
            map.put(numbers[j], j);
            if (map.containsKey(target - numbers[j]) && (map.get(target - numbers[j]) != j)){
                return new int[]{j, map.get(target-numbers[j])};
            }
        }

        return new int[]{};
```