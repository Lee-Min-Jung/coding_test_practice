// 생각
    // tickets에서 가능한 모든 경로 살펴야 함 재귀 dfs
// 구현
    // 재귀
import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> routeList;
    public String[] solution(String[][] tickets) {
        // 변수
        visited = new boolean[tickets.length];
        routeList = new ArrayList<String>();
        // 재귀
        recur(tickets, "ICN", "", 0);
        // 하나의 경로 구하기
        Collections.sort(routeList);
        String[] answer = routeList.get(0).split(" ");
        return answer;
    }
    public void recur(String[][] tickets, String city, String route, int count){
        if(count == tickets.length){
            routeList.add(route+city);
        }
        for(int i = 0; i<tickets.length; i++){
            if(!visited[i]){
                if(city.equals(tickets[i][0])){
                    visited[i] = true;
                    recur(tickets, tickets[i][1], route+city+" ", count+1);
                    visited[i] = false;
                }
            }
        }
    }
}