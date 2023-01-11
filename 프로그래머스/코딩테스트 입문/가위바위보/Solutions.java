// 나의 풀이
class Solution {
    public String solution(String rsp) {
        //rsp를 보고 하나씩 추출
        //하나씩 추출한 값을 보고 0이면 5, 2면 0, 5면 2를 answer에 추가
        //answer를 리턴
        String answer = "";
        String[] rspList = rsp.split("");

        for(int i = 0; i<rspList.length; i++){
            if(rspList[i].equals("0")){
                answer += "5";
            }else if(rspList[i].equals("2")){
                answer += "0";
            }else if(rspList[i].equals("5")){
                answer += "2";
            }
        }
        return answer;
    }
}