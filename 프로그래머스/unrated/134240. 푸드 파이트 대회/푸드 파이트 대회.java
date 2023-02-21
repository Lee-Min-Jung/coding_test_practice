class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder foodOrder = new StringBuilder();
        for(int i = 1; i<food.length; i++){
            for(int j = 0; j<food[i]/2; j++){
                foodOrder.append(String.valueOf(i));
            }
        }
        answer.append(foodOrder.toString());
        answer.append("0");
        answer.append(foodOrder.reverse().toString());
        
        return answer.toString();
    }
}