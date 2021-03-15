import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1676 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int cnt = 0;

        for( int i = 2 ; i <= n ; i ++){
            cnt+=count(i);
        }
        System.out.println(cnt);
    }
    public static int count(int n ){
        int answer = 0;
        while(n>0){
            if(n%5 == 0){
                answer++;
                n = n/5;
                continue;
            }
            break;
        }
        return answer;
    }
}
