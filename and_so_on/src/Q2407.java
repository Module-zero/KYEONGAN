import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q2407 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        m = Math.min (m,n-m);
        BigInteger answer = new BigInteger("1");

        for( int i = 1 ; i <= m ; i ++){
            answer = answer.multiply(BigInteger.valueOf(n-(i-1)));
            answer = answer.divide(BigInteger.valueOf(i));
        }

        System.out.println(answer);
    }
}
