import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2003 {
    public static void main(String [] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        long M = Long.parseLong(str[1]);
        long[] numArr = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N ; i ++) {
            numArr[i] = Long.parseLong(st.nextToken());
        }

        long ans = 0;
        for(int target = 0 ; target < N ; target++){
            if(numArr[target] >= M){
                if(numArr[target] == M )
                    ans++;
                continue;
            }
            long sum = 0;
            for(int i = target ; i < N ; i ++){
                sum += numArr[i];
                if(sum >= M)
                    break;
            }
            if(sum == M)
                ans++;

        }

        System.out.println(ans);
    }
}
