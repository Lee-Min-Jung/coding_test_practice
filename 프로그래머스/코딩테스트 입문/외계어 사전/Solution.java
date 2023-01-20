import java.util.*;

// 나의 풀이
class Solution {
    public int solution(String[] spell, String[] dic) {
        // dic를 하나씩 살펴본다
        // dic 하나를 보면서 for문을 돌아 spell이 모두 있는지 없는지 확인
        boolean[] exist = new boolean[dic.length];
        Arrays.fill(exist, false);
        for(int i = 0; i<dic.length; i++){
            boolean check = true;
            for(int j = 0; j<spell.length; j++){
                if(!dic[i].contains(spell[j])){
                    check = false;
                }
            }
            if(!check){
                exist[i] = false;
            }else{
                exist[i] = true;
            }

        }

        for(int i = 0; i<exist.length; i++){
            if(exist[i]){
                return 1;
            }
        }
        return 2;
    }
}

// 다른 풀이 보고 나의 풀이 약간 정리
import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // dic를 하나씩 살펴본다
        // dic 하나를 보면서 for문을 돌아 spell이 모두 있는지 없는지 확인
        for(int i = 0; i<dic.length; i++){
            boolean check = true;
            for(int j = 0; j<spell.length; j++){
                if(!dic[i].contains(spell[j])){
                    check = false;
                    break;
                }
            }

            if(check){
                return 1;
            }
        }

        return 2;

    }
}