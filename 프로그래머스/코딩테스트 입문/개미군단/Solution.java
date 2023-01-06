class Solution {
    public int solution(int hp) {
        // 장군개미 공격력: 5
        // 병정개미 공격력: 3
        // 일개미 : 1
        // 장군개미 수 먼저 구하고, 병정개미 수 구하고, 일개미 수 구하기

        int general = hp / 5;
        int soldiar = (hp % 5) / 3;
        int worker = (hp % 5) % 3;

        return general + soldiar + worker;

    }
}