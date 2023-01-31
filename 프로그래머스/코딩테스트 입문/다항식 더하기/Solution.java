class Solution {
    public String solution(String polynomial) {
        // 공백기준으로 split하기
        // 위에서 만든 배열 돌기
        // 돌면서 x있는 것과 없는것으로 구분해서 따로 놔두기

        String[] polynomial_arr = polynomial.split(" ");
        int x_val = 0;
        int const_val = 0;
        for(int i = 0; i<polynomial_arr.length; i++){
            if(polynomial_arr[i].contains("x")){
                polynomial_arr[i] = polynomial_arr[i].replace("x", "");
                System.out.println(polynomial_arr[i]);
                if(polynomial_arr[i].equals("")){
                    x_val += 1;
                }else{
                    x_val += Integer.parseInt(polynomial_arr[i]);
                }
            }else if(polynomial_arr[i].contains("+")){
                continue;
            }else{
                const_val += Integer.parseInt(polynomial_arr[i]);
            }
        }

        String answer = "";

        if(x_val > 1){
            answer += String.valueOf(x_val) + "x";
        }else if(x_val == 1){
            answer += "x";
        }

        if(answer.equals("") && const_val > 0){
            answer += String.valueOf(const_val);
        }else if(!answer.equals("") && const_val > 0){
            answer += " + " + String.valueOf(const_val);
        }


        return answer;
    }
}

// 약간 정리한 코드
class Solution {
    public String solution(String polynomial) {
        // 공백기준으로 split하기
        // 위에서 만든 배열 돌기
        // 돌면서 x있는 것과 없는것으로 구분해서 따로 놔두기

        String[] polynomial_arr = polynomial.split(" ");
        int x_val = 0;
        int const_val = 0;
        for(String s : polynomial_arr){
            if(s.contains("x")){
                x_val += s.equals("x") ? 1 : Integer.parseInt(s.replace("x",""));
            }else if(!s.contains("+")){
                const_val += Integer.parseInt(s);
            }
        }


        String answer = "";

        if(x_val > 1){
            answer += String.valueOf(x_val) + "x";
        }else if(x_val == 1){
            answer += "x";
        }

        if(answer.equals("") && const_val > 0){
            answer += String.valueOf(const_val);
        }else if(!answer.equals("") && const_val > 0){
            answer += " + " + String.valueOf(const_val);
        }


        return answer;
    }
}