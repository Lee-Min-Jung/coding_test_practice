import java.util.*;

class Solution {
    public String solution(String s) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        String[] arr = s.split("");

        for(int i = 0; i<arr.length; i++){
            if(m.containsKey(arr[i])){
                m.put(arr[i], m.get(arr[i])+1);
            }else{
                m.put(arr[i], 1);
            }
        }
        String result = "";
        for(String key : m.keySet()){
            if(m.get(key) == 1){
                result += key;
            }
        }

        char[] charArr = result.toCharArray();
        Arrays.sort(charArr);

        String answer = new String(charArr);

        return answer;


    }
}