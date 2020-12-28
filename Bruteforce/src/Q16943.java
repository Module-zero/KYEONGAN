import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16943 {
    static long b ;
    static int a[];
    static int n;
    static long max = -1;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        b = Long.parseLong(str[1]);
        n = str[0].length();
        a = new int[n];
        for(int i = 0 ; i < str[0].length(); i ++){
            a[i] = str[0].charAt(i) - '0';
        }
        select(new int[n],new boolean[n],0);
        System.out.println(max);
    }
    public static void select(int[] ans, boolean[] check, int cnt){
        if(cnt >= n){
            if(a[ans[0]] == 0){
                return;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : ans){
                sb.append(a[i]);
            }
            long num = Long.parseLong(sb.toString());
            if(num < b) {
                max = Math.max(num, max);
            }
            return;
        }
        for(int i = 0 ; i < n ; i ++){
            if(check[i])continue;
            ans[cnt] = i;
            check[i] = true;
            select(ans,check,cnt+1);
            check[i] = false;
        }
    }
}
