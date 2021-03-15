import java.util.*;
import java.io.*;
public class SOMA_2_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] b = new int[N];
        String[] str = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++){
            b[i] = Integer.parseInt(str[i]);
        }
        int ans = 0;
        for(int i = 0 ; i < N ; i ++){
            int start = i;
            int[] check = new int[N];
            int cnt = 0;
            while(check[start] != 2){
                if(check[start] == 1){
                    cnt++;
                }
                check[start] ++;
                start = start + b[start];
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
