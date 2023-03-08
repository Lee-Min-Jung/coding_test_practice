import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        // 1: 빵, 2: 야채, 3: 고기, 1231
        // ingredient를 하나씩 살피면서 1인걸 찾는다
            // 1인걸 찾으면 2인걸 찾는다....
        // 1231 연속으로 찾으면 삭제 후 처음으로 되돌아 가서 반복
        // 끝까지 했는데 없으면 끝
        
        List<Integer> ingredientList = new ArrayList<Integer>();
        int answer = 0;
        for(int ingre : ingredient){
            ingredientList.add(ingre);
        }
        
        for(int i = 0; i<ingredientList.size() && ingredientList.size() > 3; i++){
            if(ingredientList.get(i) == 1){
                if(i>2){
                    if(ingredientList.get(i-1)==3 && ingredientList.get(i-2)==2 && ingredientList.get(i-3)==1){
                        ingredientList.remove(i);
                        ingredientList.remove(i-1);
                        ingredientList.remove(i-2);
                        ingredientList.remove(i-3);
                        answer++;
                        i -= 4;
                    }
                }
            }
        }
        
        return answer;
    }
}