// 생각
    // 그냥 냅다 구현...
// 구현
    // n을 2진수로 변환했을 때 1의 개수를 구한다
    // while을 돈다
        // n을 1 증가시킨 후의 n을 2진수로 변환한 후 1의 개수를 구한다
        // 만약 위에서 구한 n의 1 개수와 1 개수가 같으면 break

class Solution {
    public int solution(int n) {
        // n을 2진수로 바꿔서 1 개수 구하기
        int oneCount = getOneCount(Integer.toBinaryString(n));
        
        // while 돌기
        while(true){
            n += 1;
            int count = getOneCount(Integer.toBinaryString(n));
            if(oneCount == count){
                break;
            }
        }
        
        return n;
    }
    
    public int getOneCount(String binaryStr){
        int count = 0;
        for(int i = 0; i<binaryStr.length(); i++){
            if(binaryStr.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}