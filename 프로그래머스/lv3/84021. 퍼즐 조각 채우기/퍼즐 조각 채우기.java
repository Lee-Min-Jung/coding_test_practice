// 생각
    // table에서 퍼즐 조각을 찾는다 - 1
    // game_board에서 퍼즐 구멍을 찾는다 - 2
    // 1의 조각을 돌려가면서 2의 구멍에 맞는지 확인
import java.util.*;
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] game_board, int[][] table) {
        // 변수
        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();
        int answer = 0;
        
        // table에서 퍼즐 조각 찾고 game_board에서 퍼즐 구멍 찾기
        for(int i = 0; i<table.length; i++){
            for(int j = 0; j<table.length; j++){
                if(table[i][j] == 1 && !visitedTable[i][j]){
                    bfs(i, j, visitedTable, table, 1, tableList);
                }
                
                if(game_board[i][j] == 0 && !visitedBoard[i][j]){
                    bfs(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
        }
        
        // game_board 퍼즐 구멍에 table의 퍼즐 들어가는지 확인 후 개수 저장
        answer = findBlock(boardList, tableList);
        
        return answer;
        
        
    }
    
    // 좌표 돌면서 bfs해서 빈 공간 찾기 혹은 퍼즐 찾기
    public void bfs(int curX, int curY, boolean[][] visited, int[][] graph, int blockOrEmpty, List<List<int[]>> list){
        Queue<int[]> q = new LinkedList<>();
        
        visited[curX][curY] = true;
        q.add(new int[]{curX, curY});
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] pop = q.remove();
            int popX = pop[0];
            int popY = pop[1];
            
            for(int i = 0; i<4; i++){
                int nextX = popX + dx[i];
                int nextY = popY + dy[i];
                if(nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph.length){
                    continue;
                }
                if(!visited[nextX][nextY] && graph[nextX][nextY] == blockOrEmpty){
                    visited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY});
                    subList.add(new int[]{nextX-curX, nextY-curY});
                }
            }
        }
        list.add(subList);
    }
    
    // 퍼즐이 빈공간에 맞는지 확인 후 개수 리턴
    public int findBlock(List<List<int[]>> board, List<List<int[]>> table){
        int size = 0;
        int tableLen = table.size();
        int boardLen = board.size();
        boolean[] visitedBoard = new boolean[boardLen];
        
        for(int i = 0; i<tableLen; i++){
            List<int[]> tablePoints = table.get(i);
            for(int j = 0; j<boardLen; j++){
                List<int[]> boardPoints = board.get(j);
                
                if(tablePoints.size() == boardPoints.size() && !visitedBoard[j]){
                    if(isRotate(boardPoints, tablePoints)){
                        size += tablePoints.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }
        return size;
    }
    
    // 퍼즐 회전해서 빈공간에 맞는지 확인
    public boolean isRotate(List<int[]> board, List<int[]> table){
        boolean isCollect = false;

        board.sort((o1, o2) -> {
            return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < 4; i++){ //table퍼즐 0, 90, 180, 270도 회전

            table.sort((o1, o2) -> {
                return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
            });
            int nearZeroX = table.get(0)[0];
            int nearZeroY = table.get(0)[1];

            for (int j = 0; j < table.size(); j++){
                table.get(j)[0] -= nearZeroX;
                table.get(j)[1] -= nearZeroY;
            }


            boolean isCollectPoint = true;
            for (int j = 0; j < board.size(); j++){ //좌표 비교
                int[] boardPoint = board.get(j);
                int[] tablePoint = table.get(j);

                if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]){
                    isCollectPoint = false;
                    break;
                }
            }

            if (isCollectPoint){
                isCollect = true;
                break;
            } else{ //90도 회전 : x,y -> y, -x
                for(int j = 0; j < table.size(); j++){
                    int temp = table.get(j)[0];
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = -temp;
                }
            }
        }
        return isCollect;

    }
}