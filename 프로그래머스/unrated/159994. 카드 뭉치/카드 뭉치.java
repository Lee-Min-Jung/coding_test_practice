class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // goal 원소 하나가 cards1에 있는지 확인 한다
            // 만약 있으면 cards1의 다음을 확인한다
            // 만약 없으면 cards2로 넘어가서 확인한다
        int index1 = 0;
        int index2 = 0;
        boolean cards1Continue = true;
        boolean cards2Continue = true;
        for(int i = 0; i<goal.length; i++){
            if(cards1Continue && goal[i].equals(cards1[index1])){
                
                if(index1 == cards1.length-1){
                    cards1Continue = false;
                }
                index1++;
                continue;
            }else if(cards2Continue && goal[i].equals(cards2[index2])){
                
                if(index2 == cards2.length-1){
                    cards2Continue = false;
                }
                index2++;
                continue;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}