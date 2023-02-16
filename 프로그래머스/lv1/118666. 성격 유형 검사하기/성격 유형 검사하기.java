import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // survey : 질문마다 판단하는 지표
            // survey 원소: "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
            // survey의 첫 번째 캐릭터는 i+1번 질문의 비동의
            // survey의 두 번째 캐릭터는 동의
        // choices : 검사자가 선택한 선택지
            //1: 매우 비동의....7:매우동의
        
        // survey와 choices를 돌면서 하나씩 확인
            // choices의 값을 보고 1~3 이면 survey 원소 왼쪽에 점수 할당
            // 5~7 이면 survey 원소 오른쪽에 점수 할당
                // 1과 7은 3점, 2와 6은 2점, 3과 5는 1점, 4는 0점
       
        HashMap<String, Integer> typeScore = new HashMap<String, Integer>();
        String[] typeArr = {"RT", "CF", "JM", "AN"};
        StringBuilder answer = new StringBuilder();
        
        for(String type : typeArr){
            typeScore.put(type.substring(0,1), 0);
            typeScore.put(type.substring(1,2), 0);
        }
        
        
        for(int i = 0; i<survey.length; i++){
            String left = survey[i].substring(0,1);
            String right = survey[i].substring(1,2);
            switch(choices[i]){
                case 1:
                    typeScore.put(left, typeScore.get(left)+3);
                    break;
                case 2:
                    typeScore.put(left, typeScore.get(left)+2);
                    break;
                case 3:
                    typeScore.put(left, typeScore.get(left)+1);
                    break;
                case 5:
                    typeScore.put(right, typeScore.get(right)+1);
                    break;
                case 6:
                    typeScore.put(right, typeScore.get(right)+2);
                    break;
                case 7:
                    typeScore.put(right, typeScore.get(right)+3);
                    break;
                default:
                    break;
            }
            
        }
        
        for(String type : typeArr){
            String left = type.substring(0,1);
            String right = type.substring(1,2);
            if(typeScore.get(left) >= typeScore.get(right)){
                answer.append(left);
            }else{
                answer.append(right);
            }
        }
        
        
        
        return answer.toString();
    }
    
    
}