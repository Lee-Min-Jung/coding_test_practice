class Solution {
    public int solution(int[] numbers, int k) {
        // 던진 인덱스에 2를 더한 후 배열 길이로 나눈 나머지가 다음 순번
        // k만큼 진행한 후의 인덱스를 구해서 해당 인덱스에 있는 값을 리턴
        int index = 0;

        for(int i = 0; i<k-1; i++){
            index = (index+2) % (numbers.length);
        }
        return numbers[index];
    }
}