# 배열 퀴즈 5
1부터 100까지의 숫자 중에 50개의 랜덤한 숫자가 들어있는 배열이 있다. 이 배열을 O(n)의 시간 복잡도로 정렬하라

```
솔루션 1. 크기가 101인 Boolean 타입의 배열을 만들고, 존재하는 숫자의 위치에 true값으로 변경한다
        중복값에 대한 체크를 Map에 표시한다
        입력이 마치면, for문을 돌리면 true 인 값만 따로 추려서 크기가 50인 배열에 표시한다.
        시간복잡도O(n) <- 중복값 있을경우 O(n^2)
        공간복잡도O(n)

        boolean [] newNumbers = new boolean[101];
        Map<Integer, Integer> overLapCheckMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++){
            newNumbers[numbers[i]] = true;
            if (overLapCheckMap.containsKey(numbers[i])){
                overLapCheckMap.put(numbers[i],overLapCheckMap.get(numbers[i]) + 1);
            } else {
                overLapCheckMap.put(numbers[i],1);
            }
        }

        int[] resultNumbers = new int[50];
        int index = 0;
        for (int i = 0; i<newNumbers.length; i++){
            if (newNumbers[i]) {
                resultNumbers[index] = i;
                if (index < 50)index ++;
                if (overLapCheckMap.get(i) != 1){
                    for (int j = 0; j < overLapCheckMap.get(i) -1; j++){
                        resultNumbers[index] = i;
                        index ++;
                    }
                }
            }
        }
        return resultNumbers;
```