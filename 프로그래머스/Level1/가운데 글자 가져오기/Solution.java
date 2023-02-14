class Solution {
    public String solution(String s) {
        int index = s.length() / 2;

        if(s.length() % 2 == 0){
            return s.substring(index-1, index+1);
        }else{
            return s.substring(index, index+1);
        }
    }
}