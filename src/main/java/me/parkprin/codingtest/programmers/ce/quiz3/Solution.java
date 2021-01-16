package me.parkprin.codingtest.programmers.ce.quiz3;


import java.util.*;

class Solution {
    /**
     # 주석 넣는 곳
     "DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"

     실행한 결괏값 ["GP0000 A0","DM0106 B+","PL6677 B+"]이(가) 기댓값 ["GP0000 A0","PL6677 B+","DM0106 B+"]와(과) 다릅니다.

     */
    public static void main(String[] args) {
        String[] grades = {"DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"};

        String[] results = new Solution().solution(grades);
        for (String grade : results){
            System.out.println(grade);
        }
    }

    public String[] solution(String[] grades) {
        /*
        솔루션
        1) 각 성적마다 Integer 형태로 등급을 매긴다. => gradeTypeArray
        2) grades를 강의명과 성적으로 분리한다. => lectureAndGrade.split(" ");
        3) 분리한 내용을 gradeList에 넣는다. 이때 중복되는 내용
         */


        String[] gradeTypeArray = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};


        Map<String, Integer> gradeTypeMap = new HashMap<String, Integer>();
        Map<String, String> lectureMap = new HashMap<String, String>();
        List<String> gradeList = new ArrayList<String>();
        for (int i = 0; i < gradeTypeArray.length; i++){
            gradeTypeMap.put(gradeTypeArray[i], i+1);
        }
        for (int i = 0; i < grades.length; i++) {
            String lectureAndGrade = grades[i];
            String[] infoSplit = lectureAndGrade.split(" ");

            if (lectureMap.containsKey(infoSplit[0])){
                String beforeStoreGrade = lectureMap.get(infoSplit[0]);
                // afterStoreGrade = infoSplit[1]
                int beforeGradeScore = gradeTypeMap.get(beforeStoreGrade);
                int afterGradeScore = gradeTypeMap.get(infoSplit[1]);
                if (beforeGradeScore > afterGradeScore){
                    lectureMap.put(infoSplit[0], infoSplit[1]);
                    gradeList.remove(infoSplit[0]);
                    gradeList.add(infoSplit[0]);
                }
            } else {
                gradeList.add(infoSplit[0]);
                lectureMap.put(infoSplit[0], infoSplit[1]);
            }
        }
        //"DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"

        String[] answer = new String[gradeList.size()];
        int inCount = 0;
        for (int i = 0; i < gradeTypeArray.length; i++){
            String grade = gradeTypeArray[i];
            for (String lecture : gradeList){
                String getGrade = lectureMap.get(lecture);
                if (getGrade.equals(grade)){
                    answer[inCount] = lecture + " " + grade;
                    inCount++;
                }

            }
        }
        return answer;
    }
}
