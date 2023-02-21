class Solution {
    public String solution(int a, int b) {
        int[] monthDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String answer = getDay(a, b, monthDay);
        return answer;
    }
    
    public String getDay(int a, int b, int[] monthDay){
        int sumDay = 0;
        int left = 0;
        if(a != 1){
            for(int i = 0; i<a-1; i++){
                sumDay += monthDay[i];
            }
        }
        sumDay += b-1;
        left = sumDay % 7;
        
        switch(left){
            case 1:
                return "SAT";
            case 2:
                return "SUN";
            case 3:
                return "MON";
            case 4:
                return "TUE";
            case 5:
                return "WED";
            case 6:
                return "THU";
            case 0:
                return "FRI";
            default:
                return "";
        }
        
    }
}