import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q10792 {
    public static int[] numArr;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] strArr = bf.readLine().split(" ");
        numArr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        int start = 0;
        int target = -1;
        Stack<Boolean> stack = new Stack<>(); // up = true; down = false;
        while(start+1 < n){
            boolean current;
            if(numArr[start] >= numArr[start+1]){
                current = false;
            }
            else{
                current = true;
            }
            if(!stack.isEmpty()){
                if(stack.peek() != current ){
                    target = start-1;
                }
            }
            stack.push(current);
            start++;
        }
        if (!stack.isEmpty() && (target != -1 || stack.peek())) {
            if (stack.peek() == true) {
                swap(start, start - 1);
            } else {
                int cnt = target + 1;
                int comp = 10001;
                while (cnt < n && numArr[target] + 1 <= numArr[cnt]){
                    comp = comp < numArr[cnt] ? comp : numArr[cnt];
                    cnt++;
                }
                if (comp != 10001) {
                    swap(--cnt, target);
                    Arrays.sort(numArr, target+1, n);
                } else {
                    Arrays.sort(numArr, target, n);
                    swap(target, target - 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int num : numArr) {
                sb.append(num + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

    }
    public static void swap(int a, int b){
        int tmp = numArr[a];
        numArr[a] = numArr[b];
        numArr[b] = tmp;
    }
}
