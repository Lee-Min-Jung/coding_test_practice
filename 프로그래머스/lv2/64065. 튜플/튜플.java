// 생각
    // 1개만 있는 게 맨 처음, 2개만 있는 것 중 1개 있는 거 뺀 게 두 번째... 이런 식으로 순서가 된다
// 구현
    // 문자열을 집합 단위로 쪼갠다
        // },{ 로 split 한다
        // 맨 앞 {{ 제거, 맨 뒤 }} 제거
    // 원소 개수 1개인 것부터 확인하면서 원소 추가
        // 집합에 원소가 없다
            // 집합에 원소를 넣고 list에 원소 추가
        // 집합에 원소가 있다
            // 패스
import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 문자열 집합 단위로 쪼개기
        String[] sArr = s.split("\\},\\{");
        
        sArr[0] = sArr[0].replaceAll("\\{\\{", "");
        sArr[sArr.length-1] = sArr[sArr.length-1].replaceAll("\\}\\}", "");
        
        // 원소 개수대로 정렬
        Arrays.sort(sArr, new Comparator<String>(){
            public int compare(String str1, String str2){
                if(str1.length() == str2.length()){
                    return 0;
                }
                return str1.length() - str2.length();
            }
        });
        
        
        // 원소 추출
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        for(String str : sArr){
            String[] setArr = str.split(",");
            for(String str2 : setArr){
                int target = Integer.parseInt(str2);
                if(!set.contains(target)){
                    set.add(target);
                    answerList.add(target);
                }
            }
        }
        
        // 정답
        int[] answer = new int[answerList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    } 
}