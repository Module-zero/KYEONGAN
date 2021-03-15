import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q9613 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < t ; i ++){
            String[] strArr = bf.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            long answer = 0;
            for(int j = 1; j < n ; j++){
                long numA = Long.parseLong(strArr[j]);
                for(int k = j+1; k<= n ; k++){
                    long numB = Long.parseLong(strArr[k]);
                    answer += gcd(numA,numB);
                }
            }
            System.out.println(answer);
        }
    }

    public static long gcd(long a , long b ){
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
