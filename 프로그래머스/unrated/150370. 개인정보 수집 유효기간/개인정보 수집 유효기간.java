// today: 오늘 날짜
// terms: 약관 별 유효기간
// privacies: 개인정보 수집 일자와 약관 종류

// terms를 돌면서 약관별 유효기간을 map으로 저장한다
// privacies를 돈다
    // 일자와 약정 유형을 뽑아 낸다
    // map에서 약정 유형에 따른 월 수를 구한다. 
    // 일자에 월을 더한 날짜가 오늘보다 나중이면 파기해야 한다
    
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // terms 돌면서 약관별 유효기간 저장
        HashMap<String, Integer> termMap = new HashMap<String, Integer>();
        for(String str : terms){
            String type = str.split(" ")[0];
            int month = Integer.parseInt(str.split(" ")[1]);
            termMap.put(type, month);
        }
        // 오늘 날짜
        int tYear = Integer.parseInt(today.split("\\.")[0]);
        int tMonth = Integer.parseInt(today.split("\\.")[1]);
        int tDay = Integer.parseInt(today.split("\\.")[2]);
        
        // 정답 답을 리스트
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // privacies를 돌기
        for(int i = 0; i<privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            int termPeriod = termMap.get(type);
            
            int plusYear = 0;
            int plusMonth = 0;
            // termPeriod가 12 넘는 경우
            if(termPeriod > 12){    
                plusYear = termPeriod / 12;
                plusMonth = termPeriod % 12;
            }else{
                plusYear = 0;
                plusMonth = termPeriod;
            }
            
            // privacies에 plus 월 더하기
            month = month + plusMonth;
            
            // 만약 month 12보다 큰 경우
            if(month > 12){
                year += month / 12;
                month = month % 12;
            }
            
            // privacies에 plus 연 더하기
            year = year + plusYear;
        
            // 오늘 날짜랑 비교하기
            if(tYear > year){
                result.add(i+1);
            }else if(tYear == year && tMonth > month){
                result.add(i+1);
            }else if(tYear == year && tMonth == month && tDay > day){
                result.add(i+1);
            }else if(tYear == year && tMonth == month && tDay == day){
                result.add(i+1);
            }
        }
        // 정답 배열
        int[] answer = new int[result.size()];
        
        // 정답 배열에 담기
        for(int i = 0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
        
    }
}