import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q12970 {
    static int N;
    static int K;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        for(int a = 1 ; a <= N ; a++){
            StringBuilder sb = new StringBuilder();
            int b = N - a;
            if(a * b < K)continue;
            int idx = (a*b)-K;
            if(idx == 0){
                sb.append("A");
            }
            for(int i = 1 ; i < a ; i ++){
                sb.append("A");
            }
            for(int i = 1 ; i <= b ; i ++){
                sb.append("B");
                if(i == idx){
                    sb.append("A");
                }
            }
            System.out.println(sb);
            return;
        }
        System.out.println(-1);
    }
}
