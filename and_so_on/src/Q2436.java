import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2436 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] num = bf.readLine().split(" ");
        int GCD = Integer.parseInt(num[0]);
        int LCM = Integer.parseInt(num[1]);
        int numMul = LCM * GCD;

        int minVal = 1 + numMul;
        int answer = 1;
        for(int i = numMul / 2 ; i >= 1 ; i --){
            if(numMul % i != 0) continue;
            int a = i;
            int b = numMul/i;
            if(minVal <= a + b)break;
            if(a%GCD != 0 || b % GCD != 0)continue;
            minVal = a+b;
            answer = a;
        }
        System.out.println((numMul/answer)+" "+answer);
    }
}
