class Solution {
    public boolean solution(int x) {
        int sum = 0;
        String[] x_arr = String.valueOf(x).split("");

        for(String str : x_arr){
            sum += Integer.parseInt(str);
        }

        return x % sum == 0 ? true : false;
    }
}