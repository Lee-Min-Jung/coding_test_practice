// 생각
    // phone_book을 사전순으로 정렬하면 다음 것이 본인으로 시작하는지만 for문 한 번에 확인하면 된다
// 구현
    // phone_book 사전 정렬(그냥 정렬하면 됨)
    // phone_book 돌기
        // 다음 것이 본인 것으로 시작하면 false 리턴
    // true 리턴

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 사전순 정렬
        Arrays.sort(phone_book);
        
        // for문 돌기
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        
        return true;
    }
}