import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2021SOMA4 {
    static int list[] ;
    static int max;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        list = new int[n];
        for(int i = 0 ; i < n ; i ++){
            list[i] = Integer.parseInt(str[i]);
        }
        for(int i = 0 ; i < 3 ; i ++){
            select(i,1,new boolean[n]);
        }
        System.out.println(max);
    }
    public static void select(int cur, int cnt, boolean[] check){
        if(check[cur]){
            if(max < cnt){
                max = cnt;
            }
            return;
        }
        check[cur] = true;
        select(cur+list[cur],cnt+1,check);
    }
}
