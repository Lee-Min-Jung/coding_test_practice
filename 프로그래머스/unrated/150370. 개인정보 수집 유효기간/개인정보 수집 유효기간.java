import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // terms를 돌면서 각 약정 별 기간을 map에 저장
        // privacies를 돈다
            // 약정 종류와 기간을 map에서 찾는다
            // 날짜에 찾은 기간을 더한 후 올바른 날짜로 만든다
                // 
            // 날짜와 today를 비교해서 today를 지나지 않았으면 index+1을 답에 추가한다
        
        List<Integer> answerList = new ArrayList<Integer>();
        HashMap<String, Integer> termPeriod = new HashMap<String, Integer>();
        for(String term : terms){
            termPeriod.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        
        for(int i = 0; i<privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];
            int tYear = Integer.parseInt(today.split("\\.")[0]);
            int tMonth = Integer.parseInt(today.split("\\.")[1]);
            int tDay = Integer.parseInt(today.split("\\.")[2]);
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            int period = termPeriod.get(type);
            
            if(period % 12 == 0){
                year += period / 12;
            }else if((period + month) > 12){
                year += (period + month) / 12;
                month = (period + month) % 12;
            }else{
                month += period;
            }
            
            Date f = new Date(year, month, day);
            Date t = new Date(tYear, tMonth, tDay);
            if(t.after(f)){
                answerList.add(i+1);
            }else if(t.equals(f)){
                answerList.add(i+1);
            }
            
            
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}