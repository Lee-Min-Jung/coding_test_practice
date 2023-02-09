class Solution {
    public int[] solution(long n) {
        String[] n_arr = String.valueOf(n).split("");
        int[] answer = new int[n_arr.length];
        int index = 0;
        for(int i = n_arr.length-1; i>=0; i--){
            answer[index] = Integer.parseInt(n_arr[i]);
            index++;
        }

        return answer;

    }
}