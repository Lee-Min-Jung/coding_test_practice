// 생각
    // 큰 수랑 작은 수랑 곱해야 그나마 작아지니까 한쪽은 오름차순 정렬 한쪽은 내림차순 정렬해서 곱하기..
    // 완전탐색까지는 아닌 것 같고... 저렇게 접근하면 풀릴 것 같은ㄷ
// 구현
    // A를 오름차순 정렬, B를 내림차순 정렬
    // 배열 길이만큼 돌면서 인덱스 같은 원소끼리 곱한 결과 합 누적

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 배열 길이만큼 돌기
        int answer = 0;
        for(int i = 0; i<A.length; i++){
            answer += A[i] * B[B.length-i-1];
        }
        
        return answer;
    }
}