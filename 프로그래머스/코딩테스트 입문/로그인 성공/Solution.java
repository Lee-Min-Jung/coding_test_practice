class Solution {
    public String solution(String[] id_pw, String[][] db) {
        // db를 돌면서 id 있는지 확인
        // id 있으면 해당 id에 맞는 비밀번호인지 확인

        for(int i = 0; i<db.length; i++){
            if(db[i][0].equals(id_pw[0])){
                if(db[i][1].equals(id_pw[1])){
                    return "login";
                }
                return "wrong pw";
            }
        }
        return "fail";
    }
}