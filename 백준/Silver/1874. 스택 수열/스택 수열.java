// 스택에 1 넣고 시작
// 매번 스택에서 값 꺼내서 만들려는 수열의 맨 첫 값과 비교
    // 비교했는데 만약 같으면 스택에서 값 삭제하고 수열 인덱스도 변경
    // 비교 했는데 다르면 그냥 패스하고 값만 넣기
// 배열 맨 끝까지 진행했는데 스택 비어 있으면 + - 출력
// 배열 맨 끝까지 진행했는데 스택 안 비어 있으면 no 출력
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        List<String> desc = new ArrayList<String>();
        for(int i = 0; i<count; i++){
            nums[i] = sc.nextInt();
        }
        int index = 0;
        int n = 1;
        boolean isNotPrint = true;
        Stack<Integer> stack = new Stack<Integer>();
        while(index <= count-1){
            if(!stack.isEmpty() && (stack.peek() > nums[index])){
                System.out.println("NO");
                isNotPrint = false;
                break;
            }
            if(!stack.isEmpty() && stack.peek() == nums[index]){
                stack.pop();
                index++;
                desc.add("-");
            }else{
                stack.push(n++);
                desc.add("+");
            }
        }

        if(isNotPrint){
            for(String str : desc){
                System.out.println(str);
            }
        }

    }
}
