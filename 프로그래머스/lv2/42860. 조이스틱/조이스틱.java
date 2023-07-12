// name에서 AAA를 만드는 걸로 하면 똑같은 횟수가 나오지 않을까?
// name을 돌기
    // 상하 이동
        // 현재 알파벳과 A와의 거리를 구해서 답에 더한다
    // 좌우 이동
        // name에서 발생할 수 있는 최대 이동 거리(name 길이 - 1)와
        // 


class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length - 1;  // 최소 이동 횟수 초기값: name 길이 - 1

        for (int i = 0; i < length; i++) {
            // 상하 이동 횟수 계산
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 다음 문자로 이동할 때의 최소 이동 거리 계산
            int nextIdx = i + 1;
            while (nextIdx < length && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }
            int move = i + length - nextIdx + Math.min(i, length - nextIdx);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;
        return answer;
        
    }
}