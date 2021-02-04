import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1644 {
    static boolean[] primeNum;
    static int N;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader (new FileReader(new File("data.txt")));

        N = Integer.parseInt(bf.readLine());
        primeNum = new boolean[N+1];
        prime();
        int ans = 0;
        for(int i = 2 ; i <= N ; i ++){
            if(primeNum[i])continue;
            int sum = 0;
            for(int j = i ; j <= N ; j ++){
                if(primeNum[j])continue;
                sum += j;
                if (sum >= N) {
                    if(sum == N){
                        ans++;
                    }
                    break;
                }
            }
        }
        System.out.println(ans);
    }
    public static void prime(){
        for(int i = 2 ; i <= N ; i ++){
            if(primeNum[i])continue;
            for(int j = i+i ; j <= N  ; j += i){
                if(primeNum[j])continue;
                primeNum[j] = true;
            }
        }
    }
}
