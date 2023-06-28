// phone_book을 글자길이 짧은순으로 정렬 함
// phone_book을 돌기
    // map이 비어있으면 map에 전화번호 저장
    // map이 안 비어 있으면 해당 전화번호 인덱싱하면서 map에 있는지 확인
    // map에 있으면 false리턴 다 돌고 없으면 true 리턴
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 정렬
        Arrays.sort(phone_book);
        // Arrays.sort(phone_book, new Comparator<String>(){
        //     public int compare(String str1, String str2){
        //         if(str1.length() == str2.length()){
        //             return 0;
        //         }
        //         return str1.length() - str2.length();
        //     }
        // });
        
    
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        // phone_book 돌기
        for(int i = 0; i<phone_book.length; i++){
            if(hm.isEmpty()){
                hm.put(phone_book[i], 1);
            }else{
                for(int j = 0; j<phone_book[i].length(); j++){
                    if(hm.getOrDefault(phone_book[i].substring(0, j), 0) == 1){
                        return false;
                    }
                }
                hm.put(phone_book[i], 1);
            }
        }
        
        return true;
    }    
}