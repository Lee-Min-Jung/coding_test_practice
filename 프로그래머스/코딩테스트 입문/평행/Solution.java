import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        // 평행하면 기울기가 같다 : 기울기 = y변화량 / x변화량
        // dots에서 2개씩 짝 지은 후 기울기가 같은 게 있으면 평행, 아니면 없음
        // 01 23, 02 13, 03 12


        for(int i = 1; i<dots.length; i++){
            ArrayList<Integer> index = new ArrayList<Integer>();
            index.add(1);
            index.add(2);
            index.add(3);

            index.remove(Integer.valueOf(i));

            int y1 = dots[0][1] - dots[i][1];
            int x1 = dots[0][0] - dots[i][0];
            int y2 = dots[index.get(0)][1] - dots[index.get(1)][1];
            int x2 = dots[index.get(0)][0] - dots[index.get(1)][0];


            if(x1 != 0 && x2 != 0){
                if((double)y1 / x1 == (double)y2 / x2){
                    return 1;
                }
            }
        }
        return 0;

    }
}