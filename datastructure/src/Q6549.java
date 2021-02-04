import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q6549 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0)break;
            long[] arr = new long[n];

            Stack<Integer> stack = new Stack<>();
            for(int i = 0 ; i < n ; i ++){
                arr[i] = Long.parseLong(st.nextToken());
            }

            long ans = 0;
            for(int i = 0 ; i < n ; i ++){
                int right = i-1;
                if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                        long topNum = arr[stack.pop()];
                        while (!stack.isEmpty()) {
                            if (arr[stack.peek()] < topNum) {
                                break;
                            }
                            stack.pop();
                        }
                        int width ;
                        if( !stack.isEmpty() )
                            width = right - stack.peek() ;
                        else
                            width = right + 1;
                        if (ans < width * topNum) {
                            ans = width * topNum;
                        }
                    }
                }
                stack.push(i);
            }
            if(!stack.isEmpty()){
                int rightIdx = stack.peek();
                while (!stack.isEmpty()) {
                    long target = arr[stack.pop()];
                    while(!stack.isEmpty() && target <= arr[stack.peek()]){
                        stack.pop();
                    }
                    if( stack.isEmpty() ){
                        if(ans < (rightIdx+1) * target){
                            ans = (rightIdx+1) * target;
                        }
                    }
                    else{
                        if(ans < (rightIdx - stack.peek())*target ){
                            ans = (rightIdx - stack.peek())*target;
                        }
                    }
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);

    }
}
