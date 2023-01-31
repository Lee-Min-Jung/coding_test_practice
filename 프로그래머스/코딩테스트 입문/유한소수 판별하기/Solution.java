import java.util.*;

class Solution {
    public int solution(int a, int b) {
        // a와 b의 공약수로 a와 b를 나누어 기약분수로 만들기
        // a보다 작은수만큼 돌면서 a와 b를 각각 나눈 후 나머지 확인
        // 분모(b)의 소인수 구해서 2 5 제외한 수 있는지 확인
        // b보다 작은 수로 나누면서 나머지 0인 걸 담기(b까지 진행)
        int end = a < b ? a : b;
        for(int i = 2; i<=end; i++){
            if(a % i == 0 && b % i == 0){
                a = a / i;
                b = b / i;
            }
        }
        HashSet<Integer> soinsu = new HashSet<Integer>();
        int num = 2;
        while(b >= 2){
            if(b % num == 0){
                soinsu.add(num);
                b = b / num;
            }else{
                num++;
            }
        }

        if(soinsu.contains(2) && soinsu.contains(5) && soinsu.size() == 2){
            return 1;
        }else if(soinsu.contains(2) && soinsu.size() == 1){
            return 1;
        }else if(soinsu.contains(5) && soinsu.size() == 1){
            return 1;
        }else if(soinsu.size() == 0){
            return 1;
        }else{
            return 2;
        }

    }
}