// 나의 풀이
class Solution {
    public int solution(int[] sides) {
        // 주어진 것 중에서 더 큰 수가 가장 긴 변이라고 가정했을 때
        // 큰 수 - 작은 수 + 1 ~ 큰수까지 가능
        // 새로 들어온 것이 가장 긴 변이라고 가정했을 때
        //  주어진 것 중 가장 큰 수 +1 ~ 두 수의 합 -1 될 때까지 가능

        int answer = 0;
        int bigger = 0;
        int smaller = 0;

        if(sides[0] > sides[1]){
            bigger = sides[0];
            smaller = sides[1];
        }else{
            bigger = sides[1];
            smaller = sides[0];
        }

        int start = bigger-smaller+1;

        for(int i = start; i<=bigger; i++){
            answer += 1;
        }

        int last = bigger + smaller -1;
        for(int i = bigger+1; i<=last; i++){
            answer += 1;
        }


        return answer;
    }
}

// 코드 좀 정리한 풀이
class Solution {
    public int solution(int[] sides) {
        // 주어진 것 중에서 더 큰 수가 가장 긴 변이라고 가정했을 때
        // 큰 수 - 작은 수 + 1 ~ 큰수까지 가능
        // 새로 들어온 것이 가장 긴 변이라고 가정했을 때
        //  주어진 것 중 가장 큰 수 +1 ~ 두 수의 합 -1 될 때까지 가능
        int answer = 0;

        if(sides[0]>sides[1]){
            for(int i = sides[0]-sides[1]+1; i<=sides[0]+sides[1]-1; i++){
                answer += 1;
            }
        }else{
            for(int i = sides[1]-sides[0]+1; i<=sides[0]+sides[1]-1; i++){
                answer += 1;
            }
        }

        return answer;
    }
}