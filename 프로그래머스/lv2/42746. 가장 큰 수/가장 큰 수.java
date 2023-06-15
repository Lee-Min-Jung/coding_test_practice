// numbers를 돌면서 
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // string 배열로 변환
        String[] str = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        // 정답 리턴
        if(str[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length; i++){
            sb.append(str[i]);
        }
        
        return sb.toString();
        
        
        
        
        
        
        
        
    }
    
   
}