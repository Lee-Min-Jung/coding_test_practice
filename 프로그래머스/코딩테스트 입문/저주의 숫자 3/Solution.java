class Solution {
    public int solution(int n) {

        int x3 = 0;

        for(int i = 1; i<=n; i++){
            x3++;
            while(x3 % 3 == 0 || String.valueOf(x3).contains("3")){
                x3++;
            }
        }
        return x3;

    }
}