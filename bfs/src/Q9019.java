import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Q9019 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;
        stack = new Stack<>();
        for(int cir = 0 ; cir < t ; cir++){
            String[] strArr= bf.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            LinkedList<Integer> queue = new LinkedList<>();
            int [] from = new int[10001];
            char[] memo = new char[10001];
            queue.add(a);
            boolean endFlag = false;
            while(!queue.isEmpty()) {
                int target = queue.remove();
                for (int i = 0; i < 4; i++) {
                    int num = target;
                    switch (i) {
                        case 0:
                            num = (num*2)%10000;
                            if (memo[num] == 0) {
                                memo[num] = 'D';
                                from[num] = target;
                                if (num == b) {
                                    endFlag = true;
                                }
                                queue.add(num);
                            }
                            break;
                        case 1:
                            num = num == 0 ? 9999 : num-1;
                            if (memo[num] == 0) {
                                memo[num] = 'S';
                                from[num] = target;
                                if (num == b) {
                                    endFlag = true;
                                }
                                queue.add(num);
                            }
                            break;
                        case 2:
                            num = ((num%1000)*10)+(num/1000);
                            if (memo[num] == 0) {
                                memo[num] = 'L';
                                from[num] = target;
                                if (num == b) {
                                    endFlag = true;
                                }
                                queue.add(num);
                            }
                            break;
                        default:
                            num = (num/10)+(num%10)*1000;
                            if (memo[num] == 0) {
                                memo[num] = 'R';
                                from[num] = target;
                                if (num == b) {
                                    endFlag = true;
                                }
                                queue.add(num);
                            }
                            break;
                    }
                    if(endFlag){
                        break;
                    }
                }
                if(endFlag){
                    break;
                }
            }
            while(b!=a){
                stack.push(memo[b]);
                b = from[b];
            }
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
