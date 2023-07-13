// // people를 오름차순 정렬
// // people를 돈다
//     // 현재 people 뒤를 돈다
//         // 그때까지의 합과 limit비교해서 합이 더 작다
//             // 다음 people로 이동
//         // 합이 더 크다
//             // 카운트 1 증가
//             // 뒤 돌 index를 멈춘 index+1 로 설정
            
// import java.util.*;


// class Solution {
//     public int solution(int[] people, int limit) {
//         int answer = 0;
        
//         // 정렬
//         Arrays.sort(people);
        
//         // people 돌기

//         for(int i = 0; i<people.length; i++){
//             int sum = people[i];
//             for(int j = i+1; j<people.length; j++){
//                 if(sum + people[j] <= limit){
//                     sum += people[j];
//                     continue;
//                 }else{
//                     i = j-1;
//                     answer += 1;
//                     break;
//                 }
//             }
//         }
//         //
//         int i = 0;
//         while(){
//             int sum = people[i];
            
//         }
        
//         return answer;
        
//     }
// }

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int i = 0; // 현재 처리할 사람의 인덱스
        int j = people.length - 1; // 현재 처리할 사람의 이전 인덱스
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++; // 다음 사람으로 이동
                j--; // 이전 사람으로 이동
            } else {
                j--; // 현재 사람만 태우고 이전 사람으로 이동
            }
            answer++;
        }
        
        return answer;
    }
}
