// 생각
    // 문자열 처리
// 구현
    // str1과 str2 각각을 돈다
        // 돌면서 2개씩 잘라서 문자열을 추출한다
        // 추출한 문자열이 영문자로만 되어 있는지 확인
        // 영문자를 모두 소문자나 대문자로 바꿈
        // 완성된 문자열을 배열이나 리스트에 추가
    // 교집합 사이즈 구하기
        // str1과 str2에서 구한 리스트를 각각 돌면서 각각의 map으로 개수 저장
        // 두 맵에 같은 원소가 있으면 더 작은 값이 교집합 개수
    // 합집합 사이즈 구하기
        // 위에서 구한 map 활용
        // 두 맵에 같은 원소 있으면 더 큰 값이 합집합 개수
        // 같은 원소 아니면 개수만큼 개수에 더하기
    // 위에서 구한 교집합 사이즈 / 합집합 사이즈 * 65536 결과의 정수부가 답
import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String str1, String str2) {
        // str1 돌면서 문자열 추출
        ArrayList<String> str1List = new ArrayList<String>();
        
        for(int i = 0; i<str1.length()-1; i++){
            String str = str1.substring(i, i+2);
            if(Pattern.matches("^[a-zA-Z]*$", str)){
                str = str.toLowerCase();
                str1List.add(str);
            }
        }
        
        // str2 돌면서 문자열 추출
        ArrayList<String> str2List = new ArrayList<String>();
        
        for(int i = 0; i<str2.length()-1; i++){
            String str = str2.substring(i, i+2);
            if(Pattern.matches("^[a-zA-Z]*$", str)){
                str = str.toLowerCase();
                str2List.add(str);
            }
        }
        
        // map 구하기
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
        
        for(String s : str1List){
            hm1.put(s, hm1.getOrDefault(s, 0)+1);
        }
        
        for(String s : str2List){
            hm2.put(s, hm2.getOrDefault(s, 0)+1);
        }
        
        // test
        // for(String key : hm1.keySet()){
        //     System.out.println(key);
        //     System.out.println(hm1.get(key));
        // }
        
        // 교집합 개수
        int inter = 0;
        for(String key : hm1.keySet()){
            if(hm2.getOrDefault(key, Integer.MAX_VALUE) != Integer.MAX_VALUE){
                if(hm1.get(key) < hm2.get(key)){
                    inter += hm1.get(key);
                }else{
                    inter += hm2.get(key);
                }
            }
            
        }
        // 합집합 개수
        int union = 0;

        for(String key : hm1.keySet()){
            if(hm2.getOrDefault(key, Integer.MAX_VALUE) != Integer.MAX_VALUE){
                if(hm1.get(key) > hm2.get(key)){
                    union += hm1.get(key);
                }else{
                    union += hm2.get(key);
                }
                hm2.put(key, 0);
            }else{
                union += hm1.get(key);
            }
        }
        
        for(String key : hm2.keySet()){
            if(hm2.get(key) != 0){
                union += hm2.get(key);
            }
        }

        
        // 정답
        int answer = 0;
        
        if(union == 0){
            answer = 65536;
        }else{
            answer = (int)Math.floor((double)inter / union * 65536);
        }
        
        
        return answer;
    }
}