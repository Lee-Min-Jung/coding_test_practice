// report를 돌면서 신고 내역 저장
    // hashMap에다가 신고자 : 신고 당한 사람 저장
        // hashMap<String, HashSet<String>>
// report 돌면서 신고 받은 사람 횟수 저장
    // HashMao<String, Integer>
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 내역 
        HashMap<String, HashSet<String>> reportStatus = new HashMap<String, HashSet<String>>();
        // 신고 횟수
        HashMap<String, Integer> reportCount = new HashMap<String, Integer>();
        // 정지자
        ArrayList<String> cancel = new ArrayList<String>();
        
        // report 돌면서 신고 내역 저장
        for(int i = 0; i<report.length; i++){
            String reporter = report[i].split(" ")[0];
            String reported = report[i].split(" ")[1];
            
            HashSet<String> hs = reportStatus.getOrDefault(reporter, new HashSet<String>());
            hs.add(reported);
            reportStatus.put(reporter, hs);
        }
        
        // reportStatus 돌면서 신고 횟수 저장
        for(String key : reportStatus.keySet()){
            for(String reported : reportStatus.get(key)){
                reportCount.put(reported, reportCount.getOrDefault(reported, 0)+1);
            }
        }
        
        // id_list돌면서 각 아이디별로 메일 받는 횟수 구하기
        int[] answer = new int[id_list.length];
        for(int i = 0; i<id_list.length; i++){
            int count = 0;
            for(String key : reportStatus.getOrDefault(id_list[i], new HashSet<String>())){
                if(reportCount.get(key) >= k){
                    count++;
                }
            }
            answer[i] = count;
        }
        
        return answer;
        
    }
}