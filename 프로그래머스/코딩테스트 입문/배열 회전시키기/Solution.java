class Solution {
    public int[] solution(int[] numbers, String direction) {
        // direction 보고 왼쪽인지 오른쪽인지 확인 - if문
        // 만약에 right이면
            // 주어진 배열 쭉 돌면서 첫번째를 두번째로, 두번째를 세번째로...
            // 마지막 것을 첫번째로 옮기기
        // 만약에 left 이면
            // 주어진 배열 쭉 돌면서 첫번째를 마지막으로, 두번째를 첫번째로 옮기기

        int[] answer = new int[numbers.length];

        if(direction.equals("right")){
            for(int i = 0; i<numbers.length; i++){
                if(i == (numbers.length-1)){
                    answer[0] = numbers[i];
                }else{
                    answer[i+1] = numbers[i];
                }
            }
        }else{
            for(int i = 0; i<numbers.length; i++){
                if(i == (numbers.length-1)){
                    answer[i] = numbers[0];
                }else{
                    answer[i] = numbers[i+1];
                }
            }
        }
        return answer;

    }
}