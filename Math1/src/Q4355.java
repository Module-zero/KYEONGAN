import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q4355 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            int N = Integer.parseInt(bf.readLine());
            if(N == 0)break;
            int ans = N;
            for(int i = 2; i <= N ; i ++){
                if(N%i != 0)continue;
                while(N%i == 0){
                    N = N / i;
                }
                ans = ans - ans / i ;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
