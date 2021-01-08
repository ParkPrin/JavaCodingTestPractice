# 배열 퀴즈 1
주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라

```
솔루션 1. 전체 데이터 순회를 하여 중복된 숫자가 나오면 true를 return 한다.
        시간복잡도 O(n^2)
        공간복잡도 O(1)

        for (int i =0; i < arrays.length; i++){
            for (int j = i+1; j < arrays.length; j++){
             if (arrays[i] == arrays[j]) return true;
            }
        }
        return false;
```

```
솔루션 2. 전체 데이터를 정렬하고 나서 중복데이터가 있는지 체크함
        Arrays.sort(arrays) 로직의 시간복잡도가 O(NlogN), 공간복잡도가 O(logN)
        시간복잡도 O(NlogN)
        공간복잡도 O(logN)
        Arrays.sort(arrays);
        for (int i  =0; i < arrays.length-1; i++){
            if (arrays[i] == arrays[i+1]) return true;
        }
        return false;
```

```
솔루션 3. 자료구조 Set을 사용하는 방법
    Set의 contains의 시간복잡도는 O(1)이다.
    시간복잡도 O(1)
    공간복잡도 O(N)

    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < arrays.length; i++){
        if (set.contains(arrays[i])) return true;
        else set.add(arrays[i]);
    }
    return false;
```