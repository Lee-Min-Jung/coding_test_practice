// 생각
    // map
// 구현
    // fees 값 저장
    // records를 돈다
        // 각 원소는 split해서 시간, 번호, 입출차를 구한다
        // map에서 번호를 찾는데 값이 있다
            // map의 상태값이 IN이다
                // map의 누적 시간을 지금들어온 시간과 map에 있는 시간의 차이로 저장    
            // map의 시간을 지금 들어온 시간으로 저장
            // map의 상태를 지금 들어온 상태로 저장
        // map에서 번호를 찾는데 값이 없다
            // map에 해당 번호의 상태에 맞는 값들을 넣는다
    // map을 돈다
        // 상태가 in
            // 누적 시간에 23:59와 저장된 시간 차를 더함
        // 누적 시간에 따라 요금 계산
        // 차량번호와 요금을 같이 저장
import java.util.*;
import java.time.*;

class Solution {
    static int basicTime;
    static int basicFee;
    static int perTime;
    static int perFee;
    
    public int[] solution(int[] fees, String[] records) {
        // fees 에서 값 추출
        basicTime = fees[0];
        basicFee = fees[1];
        perTime = fees[2];
        perFee = fees[3];
        
        // records 돌기
        TreeMap<String, ArrayList<String>> tm = new TreeMap<String, ArrayList<String>>();
        for(int i = 0; i<records.length; i++){
            String[] str = records[i].split(" ");
            String time = str[0];
            String carNum = str[1];
            String status = str[2];
            if(!tm.getOrDefault(carNum, new ArrayList<String>()).isEmpty()){
                ArrayList<String> list = new ArrayList<String>();
                list.add(time);
                list.add(status);
                if(tm.get(carNum).get(1).equals("IN")){
                    LocalTime now = LocalTime.parse(time);
                    LocalTime before = LocalTime.parse(tm.get(carNum).get(0));
                    Duration duration = Duration.between(before, now);
                    int value = 0;
                    if(tm.get(carNum).get(2).equals("")){
                        value = (int)duration.toMinutes();
                    }else{
                        value = Integer.parseInt(tm.get(carNum).get(2))+(int)duration.toMinutes();
                    }
                    list.add(String.valueOf(value));
                }else{
                    list.add(tm.get(carNum).get(2));
                }
                tm.put(carNum, list);
                
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(time);
                list.add(status);
                list.add("");
                tm.put(carNum, list);
            }
        }
        // map 돌기
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        for(String key : tm.keySet()){
            String time = tm.get(key).get(0);
            String status = tm.get(key).get(1);
            String sumTime = tm.get(key).get(2);
            if(status.equals("IN")){
                LocalTime now = LocalTime.parse("23:59");
                LocalTime before = LocalTime.parse(time);
                Duration duration = Duration.between(before, now);
                if(sumTime.equals("")){
                    sumTime = String.valueOf(duration.toMinutes());
                }else{
                    sumTime = String.valueOf(Integer.parseInt(sumTime) + (int)duration.toMinutes());
                }
            }
            int totalFee = calFee(Integer.parseInt(sumTime));
            answerList.add(totalFee);
            
        }
        
        // 배열로 정답 출력
        int[] answer = new int[answerList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public int calFee(int sumTime){
        if(sumTime > basicTime){
            return basicFee + (int) Math.ceil((sumTime - basicTime) / (double)perTime) * perFee;
        }
        
        return basicFee;
    }
}