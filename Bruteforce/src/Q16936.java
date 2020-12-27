import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16936 {
    static long[] num;
    static int n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        num = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0 ; i < n ; i ++){
            num[i] = Long.parseLong(st.nextToken());
        }
        for(int i = 0 ; i < n ; i ++){
            boolean[] check = new boolean[n];
            int[] answer = new int[n];
            answer[0] = i;
            check[i] = true;
            if(select(num[i],1,check,answer)){
                break;
            }
            check[i] = false;
        }
    }
    public static boolean select(long curNum,int cnt,boolean[] check,int[] answer){
        if(cnt == n){
            for(int i : answer){
                System.out.print(num[i]+" ");
            }
            return true;
        }
        for(int i = 0 ; i < n ; i ++){
            if(check[i])continue;
            if(curNum * 2 != num[i] && (curNum%3 != 0 || curNum / 3 != num[i]))continue;
            check[i] = true;
            answer[cnt] = i;
            select(num[i],cnt+1,check,answer);
        }
        return false;
    }
}
