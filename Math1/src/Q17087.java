import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q17087 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        long subinPos = Long.parseLong(strArr[1]);

        String[] strArr1 = bf.readLine().split(" ");
        long[] findPos = new long[n];
        for(int i = 0 ;i < n ; i ++){
            long tmp = subinPos - Long.parseLong(strArr1[i]);
            findPos[i] = tmp > 0 ? tmp : -tmp ;
        }
        long answer = findPos[0];
        for(int i = 1; i < n ; i ++){
            long tmp = gcd(answer,findPos[i]);
            answer = answer > tmp ? tmp : answer;
        }
        System.out.println(answer);
    }

    public static long gcd(long a, long b){
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
