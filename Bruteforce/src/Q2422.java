import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2422 {
    static int ans = 0;
    static int choice = 3;
    static int N;
    static ArrayList<Integer>[] dontMix ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        dontMix = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i ++){
            dontMix[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int fi = Integer.parseInt(tmp[0]);
            int se = Integer.parseInt(tmp[1]);
            dontMix[fi].add(se);
            dontMix[se].add(fi);
        }
        solve(0,1,new int[3]);
        System.out.println(ans);
    }
    public static void solve(int cnt, int idx,int[] select){
        if(cnt >= 3){
            ans++;
            return ;
        }
        if(idx > N){
            return;
        }
        boolean mix = true;
        for(int i = 0 ; i < cnt; i ++){
            int target = select[i];
            for(int ic : dontMix[target]){
                if(ic == idx){
                    mix = false;
                }
            }
        }
        solve(cnt,idx+1,select);
        if(mix) {
            select[cnt] = idx;
            solve(cnt + 1, idx + 1, select);
        }
    }
}
