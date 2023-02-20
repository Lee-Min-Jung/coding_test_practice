import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // arr1과 arr2를 돌면서 각 수를 2진수로 바꾼다
            // 각 수를 2로 나눈 나머지들을 쭉 붙이면 그게 2진수
        // 2진수로 바꾸면서 1이면 벽으로 인식, 0이면 공백으로 인식
        String[] arr1TwoNum = getTwoNum(arr1);
        String[] arr2TwoNum = getTwoNum(arr2);
        String[] answer = new String[n];
        
        
        for(int i = 0; i<n; i++){
            StringBuilder result = new StringBuilder();
            String temp1 = arr1TwoNum[i];
            String temp2 = arr2TwoNum[i];
            for(int j = 0; j<temp1.length(); j++){
                if(temp1.charAt(j) == '1'){
                    result.append("#");
                }else if(temp2.charAt(j) == '1'){
                    result.append("#");
                }else{
                    result.append(" ");
                }
            }
            answer[i] = result.toString();
        }
        
        
        
        return answer;
        
    }
    public String[] getTwoNum(int[] arr){
        String[] twoNumArr = new String[arr.length];
        for(int i = 0; i<arr.length; i++){
            StringBuilder twoNum = new StringBuilder();
            int leftover = 0;
            while(arr[i] != 0){
                leftover = arr[i] % 2;
                arr[i] = arr[i] / 2;
                twoNum.append(String.valueOf(leftover));
            }
            while(twoNum.length() != arr.length){
                twoNum.append("0");
            }
            twoNumArr[i] = twoNum.reverse().toString();
        }
        return twoNumArr;
    }
}