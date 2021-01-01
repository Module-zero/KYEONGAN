import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1629 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] initial = bf.readLine().split(" ");
        long a = Long.parseLong(initial[0]);
        long b = Long.parseLong(initial[1]);
        long c = Long.parseLong(initial[2]);
        long ans = solve(a,b,c)%c;
        System.out.println(ans);
    }
    public static long solve(long a, long b,long c){
        if( b== 0){
            return 1;
        }
        else if (b == 1){
            return a;
        }
        if(b%2 != 0){
            return solve(a,b-1,c)*a;
        }
        long half = solve(a,b/2,c);
        half%=c;
        return (half*half)%c;
    }
}
