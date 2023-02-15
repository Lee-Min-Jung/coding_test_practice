class Solution {
    boolean solution(String s) {
        String[] s_arr = s.split("");
        int p_count = 0;
        int y_count = 0;
        
        for(int i = 0; i<s_arr.length; i++){
            if(s_arr[i].equals("p") || s_arr[i].equals("P")){
                p_count += 1;
            }
            if(s_arr[i].equals("y") || s_arr[i].equals("Y")){
                y_count += 1;
            }
        }
        
        return p_count == y_count ? true : false;
        
    }
}