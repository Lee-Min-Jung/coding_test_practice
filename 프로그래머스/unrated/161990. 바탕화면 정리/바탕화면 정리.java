import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 100;
        int minY = 100;
        int maxX = -100;
        int maxY = -100;
        int[] answer = new int[4];
        
        for(int i = 0; i<wallpaper.length; i++){
            for(int j = 0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX+1;
        answer[3] = maxY+1;
        
        return answer;
    }
}
