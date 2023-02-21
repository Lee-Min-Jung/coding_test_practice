class Solution {
    public String solution(int[] food) {
        StringBuilder foodOrder = new StringBuilder();
        
        for(int i = 1; i<food.length; i++){
            for(int j = 0; j<food[i]/2; j++){
                foodOrder.append(String.valueOf(i));
            }
        }
        
        return foodOrder.toString() + "0" + foodOrder.reverse().toString();
    }
}