import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1790 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        long n = Integer.parseInt(str[0]);
        String strN = n+"";
        int lenN = strN.length();
        long k = Integer.parseInt(str[1]);
        int len = 0 ;
        long start =1;
        long end = 0;
        int a = 1;
        for(int i = 1 ; i <= lenN; i ++){
            len = i;
            start = end + 1;
            end = start + (i*a*9) - 1 ;
            a *= 10;
            if(end >= k)break;
        }
        end = ((n-(a/10)+1)*lenN) + (start-1);
        if(k > end){
            System.out.println("-1");
            return ;
        }
        long target = (k-start)/len;
        long r = (k-start)%len;
        String num = (a/10 + target)+"";
        int answer = num.charAt((int)r) -'0';
        System.out.println(answer);
    }
}
