class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        new_id = new_id.replaceAll("[^-.\\w]","");
        // 3단계
        new_id = new_id.replaceAll("\\.{2,}","\\.");
        // 4단계
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");
        // 5단계
        new_id = new_id.equals("") ? "a" : new_id;
        // 6단계
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        // 7단계
        if(new_id.length() <= 2){
            String last = String.valueOf(new_id.charAt(new_id.length()-1));
            while(new_id.length() != 3){
                new_id += last;
            }
        }
        return new_id;

    }
}