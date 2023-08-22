// 생각
    // map
// 구현
    // phone_book을 돈다
        // map에 각 key를 저장한다
    // phone_book을 돈다
        // phone_book의 각 원소 글자를 돈다
            // 각 원소 글자의 처음부터 살피면서 해당 부분이 map에 key로 존재한다
                // false 리턴
    // true 리턴

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // map 채우기
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        for(String str : phone_book){
            hm.put(str, 1);
        }
        
        // 접두어 확인
        for(String str : phone_book){
            for(int i = 1; i<str.length(); i++){
                if(hm.containsKey(str.substring(0, i))){
                    return false;
                }
            }
        }
        
        return true;
    }
}