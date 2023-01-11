class Solution {
    public int solution(int[] box, int n) {
        //box의 가로를 보고 n이 최대 몇 개 올 수 있는지
        //box의 세로를 보고 n이 최대 몇 개 올 수 있는지
        //box의 높이를 보고 n이 최대 몇 개 올 수 있는지
        //위에서 구한 걸 다 곱해주면 된다
        int answer = 0;

        int maxWidth = box[0] / n;
        int maxLength = box[1] / n;
        int maxHeight = box[2] / n;

        answer = maxWidth * maxLength * maxHeight;

        return answer;
    }
}