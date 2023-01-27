class Solution {
    public int solution(int M, int N) {
        // 가로를 1 될 때까지 자른다
        // 세로가 1 될 때까지 자른다 * 가로 변 길이
        // 위 두 개를 더한다
        int x = M - 1;
        int y = (N - 1) * M;
        return x+y;
    }
}