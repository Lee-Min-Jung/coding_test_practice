import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // report를 돌면서 누가 누구를 신고했는지 정리
            // map, 신고한 사람: 신고당한 사람 list
        // report를 돌면서 신고당한 아이디 별로 신고당한 횟수 정리
            // map, 신고당한 아이디 : 신고당한 횟수
        // id_list를 돌면서 reportMap에서 찾고 해당 map의 set을 돌면서 set원소를 reportedCount에서 찾아서 k보다 크거나 같으면 1 증가
        
        HashMap<String, HashSet<String>> reportMap = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> reportedCount = new HashMap<String, Integer>();
        HashSet<String> repotedIdSet = new HashSet<String>();
        int[] answer = new int[id_list.length];
        
        for(String rep : report){
            String repoter = rep.split(" ")[0];
            String repoted = rep.split(" ")[1];
            repotedIdSet = reportMap.getOrDefault(repoter, new HashSet<String>());
            repotedIdSet.add(repoted);
            reportMap.put(repoter, repotedIdSet);
        }
        
        for(String key : reportMap.keySet()){
            for(String repoted : reportMap.get(key)){
                reportedCount.put(repoted, reportedCount.getOrDefault(repoted, 0)+1);
            }
        }
        
        for(int i = 0; i<id_list.length; i++){
            int count = 0;
            for(String repoted : reportMap.getOrDefault(id_list[i], new HashSet<String>())){
                if(reportedCount.get(repoted) >= k){
                    count++;
                }
            }
            answer[i] = count;
        }
        
        
        return answer;
        
    }
}