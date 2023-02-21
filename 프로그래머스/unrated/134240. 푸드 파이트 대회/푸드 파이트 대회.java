class Solution {
    public String solution(int[] food) {
        StringBuilder foodOrder = new StringBuilder();
        
        for(int i = 1; i<food.length; i++){
            foodOrder.append(String.valueOf(i).repeat(food[i]/2));
        }
        
        return foodOrder.toString() + "0" + foodOrder.reverse().toString();
    }
}