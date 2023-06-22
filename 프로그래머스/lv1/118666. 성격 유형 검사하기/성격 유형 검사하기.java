// survey : 성격유형 
// choices: 각 성격유형에서 고른 답변
// 1: 3점, 2: 2점, 3: 1점 - 왼쪽 유형
// 4: 0점
// 5: 1점, 6: 2점, 7: 3점 - 오른쪽 유형

// 총 성격 유형별로 map을 만들어 점수를 담을 것을 초기화한다

// survey와 choices를 동시에 돈다
    // choices에서 숫자를 꺼낸 후 해당 숫자에 맞는 유형과 점수를 구한다
    // 해당 유형 map에 점수를 할당한다

// 다 돌고 난 이후 map을 돌면서 rt 중 큰 값, cf 중 큰 값, jm중 큰 값, an중 큰 값을 찾음
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 총 성격 유형 map 생성
        String[] typeList = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> typeMap = new HashMap<String, Integer>();
        for(int i = 0; i<typeList.length; i++){
            typeMap.put(typeList[i], 0);
        }
        
        // 선택항목 별 점수 map 생성
        HashMap<Integer, Integer> scoreMap = new HashMap<Integer, Integer>(); 
        scoreMap.put(1,3);
        scoreMap.put(2,2);
        scoreMap.put(3,1);
        scoreMap.put(4,0);
        scoreMap.put(5,1);
        scoreMap.put(6,2);
        scoreMap.put(7,3);
        
        // survey와 choices돌기
        for(int i = 0; i<survey.length; i++){
            String leftType = survey[i].split("")[0];
            String rightType = survey[i].split("")[1];
            int score = scoreMap.get(choices[i]);
            
            if(choices[i]<=3){
                typeMap.put(leftType, typeMap.getOrDefault(leftType, 0)+score);
            }else if(choices[i]>=4){
                typeMap.put(rightType, typeMap.getOrDefault(rightType, 0)+score);
            }
        }
        
        // 완성된 typeMap으로부터 정답 구하기
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<typeList.length; i+=2){
            if(typeMap.get(typeList[i]) > typeMap.get(typeList[i+1])){
                sb.append(typeList[i]);
            }else if(typeMap.get(typeList[i]) == typeMap.get(typeList[i+1])){
                sb.append(typeList[i]);
            }else{
                sb.append(typeList[i+1]);
            }
        }
        
        
        return sb.toString();
    }
}