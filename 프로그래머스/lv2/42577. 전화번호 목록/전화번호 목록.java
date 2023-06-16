// // phone_book 하나씩 돌면서 map으로 저장
// // phone_book 하나씩 돌면서 각 문자열 살피기
//     // 문자열을 하나씩 늘려가면서 해당 문자열이 map에 있는지 확인
//     // 이때 자기 자신인 경우는 제외해야 함
// import java.util.*;

// class Solution {
//     public boolean solution(String[] phone_book) {
    
//         // 저장할 맵
//         HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
//         // phone_book 을 map에 저장
//         for(int i = 0; i<phone_book.length; i++){
//             hm.put(phone_book[i], 0);
//         }
        
//         // phone_book 돌면서 문자열 살피기
//         for(int i = 0; i<phone_book.length; i++){
//             for(int j = 0; j<phone_book[i].split("").length; j++){
//                 String substr = phone_book[i].substring(0, j+1);
//                 // 문자열 돌리다 접두사 발견한 경우
//                 if(hm.getOrDefault(substr, -1) != -1){
//                     hm.put(substr, hm.get(substr)+1);
//                 }
//             }
//         }
        
//         // hm을 돌면서 개수가 2인게 있으면 false 리턴, 없으면 true 리턴
//         for(String str : hm.keySet()){
//             if(hm.get(str) == 2){
//                 return false;
//             }
//         }
        
//         return true;
    
//     }    
// }

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 저장할 맵
        HashMap<String, Boolean> hm = new HashMap<>();
        
        // phone_book을 map에 저장
        for (String phoneNumber : phone_book) {
            hm.put(phoneNumber, true);
        }
        
        // phone_book을 돌면서 문자열 살피기
        for (String phoneNumber : phone_book) {
            // phoneNumber의 접두사를 구함
            for (int i = 1; i < phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i);
                // 접두사가 맵에 존재하면 false를 반환
                if (hm.containsKey(prefix)) {
                    return false;
                }
            }
        }
        
        return true;
    }    
}
