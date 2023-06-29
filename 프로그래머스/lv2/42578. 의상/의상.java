// clothes를 돌면서 map에 저장
    // 종류: 리스트에 옷 이름 추가
// 개수 구하기
    // 종류별 1개씩 입는다 했을 때 각 종류의 개수 ---- 1
    // 종류끼리 겹쳐 입는다 했을 때 각 종류 개수의 곱 --- 2
        // 각 종류에서 1개씩 고르는 경우의 수끼리 곱하면 됨
    // 1과 2의 합

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // map에 저장
        HashMap<String, ArrayList<String>> clothesMap = new HashMap<String, ArrayList<String>>(); 
        for(int i = 0; i<clothes.length; i++){
            String name = clothes[i][0];
            String type = clothes[i][1];
            if(clothesMap.getOrDefault(type, null) == null){
                ArrayList<String> clothesList = new ArrayList<String>();
                clothesList.add(name);
                clothesMap.put(type, clothesList);
            }else{
                ArrayList<String> clothesList = clothesMap.get(type);
                clothesList.add(name);
                clothesMap.put(type, clothesList);
                
            }
        }
        // 개수 구하기
        int answer = 0;
        for(String key : clothesMap.keySet()){
            if(answer != 0){
                answer = answer + answer * clothesMap.get(key).size();
            }
            answer += clothesMap.get(key).size();
            
        }
        
        
        return answer;
    }
}



// Iterator it = mClothers.keySet().iterator();
//         while (it.hasNext()) {
//             String sKey = (String) it.next();
//             int arrayClotherSize = ((ArrayList<String>) mClothers.get(sKey)).size();
//             arrayClotherSize++; //현재 옷종류 미착용상태 경우의 수 한개 추가
//             if(answer == 0) {
//                 answer = arrayClotherSize;
//             } else {
//                 answer *= arrayClotherSize;
//             }

//         }

//         answer--; //모든 복장 미착용인 경우 한개 제외