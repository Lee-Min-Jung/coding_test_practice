class Solution {
    public long solution(long n) {
        if(Math.sqrt(n) % 1 == 0){
            long num = (long)Math.sqrt(n) + 1;
            return num * num;
        }else{
            return -1;
        }
    }
}