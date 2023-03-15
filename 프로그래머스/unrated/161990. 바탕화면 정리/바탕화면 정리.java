import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        // 좌표는 (세로, 가로)
        // wallpaper를 돌면서 #의 좌표를 구해서 저장한다
            // #이 등장하면 내부 인덱스가 가로가 되고, 외부 인덱스가 세로가 된다
        // 저장한 #의 좌표 중 가로가 가장 작은 것은 시작점의 가로 좌표
        // 저장한 #의 좌표 중 세로가 가장 작은 것은 시작점의 세로 좌표
        // 저장한 #의 좌표 중 가로가 가장 큰 것+1은 마지막점의 가로 좌표
        // 저장한 #의 좌표 중 세로가 가장 큰 것+1은 마지막점의 세로 좌표
        // 세로는 저장 순서대로, 가로는 다 확인해야 함
        List<List<Integer>> filePosition = new ArrayList<List<Integer>>();
        int[] answer = new int[4];
        
        for(int i = 0; i<wallpaper.length; i++){
            String[] line = wallpaper[i].split("");
            for(int j = 0; j<line.length; j++){
                if(line[j].equals("#")){
                    List<Integer> f = new ArrayList<Integer>();
                    f.add(i);
                    f.add(j);
                    filePosition.add(f);
                }
            }
        }
        int minX = filePosition.get(0).get(1);
        int maxX = filePosition.get(0).get(1);
        for(int i = 0; i<filePosition.size(); i++){
            for(int j = 0; j<filePosition.get(i).size(); j++){
                if(filePosition.get(i).get(1) < minX){
                    minX = filePosition.get(i).get(1);
                }
                if(filePosition.get(i).get(1) > maxX){
                    maxX = filePosition.get(i).get(1);
                }
            }
        }
        answer[0] = filePosition.get(0).get(0);
        answer[1] = minX;
        answer[2] = filePosition.get(filePosition.size()-1).get(0)+1;
        answer[3] = maxX+1;
        
        
        return answer;
    }
}