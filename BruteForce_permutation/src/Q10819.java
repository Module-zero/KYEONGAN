import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10819 {
    static int n ;
    static int[] numArr;
    static int maxValue;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        String[] strArr = bf.readLine().split(" ");
        numArr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        select(new int[n],new boolean[n],0);
        System.out.println(maxValue);
    }
    public static void select(int[] answer, boolean[] check,int cnt){
        if(cnt >= n){
            int tmp = 0;
            for(int i = 0 ; i < n-1; i ++){
                tmp += Math.abs(answer[i]-answer[i+1]);
            }

            maxValue = Math.max(maxValue,tmp);
            return;
        }
        for(int i = 0 ; i < n ; i ++){
            if(!check[i]){
                check[i] = true;
                answer[cnt] = numArr[i];
                select(answer,check,cnt+1);
                check[i] = false;
            }
        }
    }
}
