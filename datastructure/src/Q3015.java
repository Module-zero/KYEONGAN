import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q3015 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Stack<int[] > stack = new Stack<>();
        long ans = 0 ;
        for(int i = 0 ; i < n ; i ++){
            int[] pair = new int[]{arr[i],1};
            while(!stack.isEmpty()) {
                if (stack.peek()[0] <= arr[i]) {
                    ans += (long)stack.peek()[1];
                    if(stack.peek()[0] == arr[i]){
                        pair[1] += stack.peek()[1];
                    }
                    stack.pop();
                } else {
                    break;
                }
            }
            if(!stack.isEmpty()){
                ans++;
            }
            stack.push(pair);
        }
        System.out.println(ans);
    }
}
