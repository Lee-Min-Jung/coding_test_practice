class Solution {
    public String solution(String phone_number) {
        // 길이 - 4의 인덱스부터 끝까지를 바꾸면 됨
        
        int index = phone_number.length() - 4;
        String[] phone_number_arr = phone_number.split("");
        
        for(int i = 0; i<phone_number_arr.length; i++){
            if(i < index){
                phone_number_arr[i] = "*";
            }
        }
        
        return String.join("",phone_number_arr);
    }
}