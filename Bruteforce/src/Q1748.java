import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1748 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File( "data.txt")));

        int num = Integer.parseInt(bf.readLine());
        long[] dp = new long[10];
        long ten = 1;
        int cnt = 1;
        do{
            dp[cnt] = ((ten*10)-ten)*cnt;
            ten *= 10;
            ++cnt;
        }while(num >= ten);
        dp[cnt-1] = dp[cnt-1]-((ten-1)-num)*(cnt-1);

        long answer = 0;
        for(int i = 1; i <= cnt-1 ; i ++){
            answer += dp[i];
        }
        System.out.println(answer);
    }
}
