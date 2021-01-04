import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q16987 {
    static class Egg {
        int s;
        int w;
        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
    static int max ;
    static int n;
    static Egg[] eggs;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader ( new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        if(n == 1){
            System.out.println(0);
            return;
        }
        eggs = new Egg[n];
        for(int c = 0 ; c < n ; c ++){
            String[] tmp = bf.readLine().split(" ");
            eggs[c] = new Egg(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
        }
        solve(0,0,new boolean[n]);
        System.out.println(max);
    }
    public static void solve(int idx,int cnt, boolean[] broken){
        if(idx == n || cnt == n-1){
            max = Math.max(cnt,max);
            return;
        }
        if(broken[idx]){
            solve(idx+1,cnt,broken);
            return;
        }
        for(int i = 0 ; i < n ; i ++){
            if(i == idx || broken[i])continue;
            int tmp = 0;
            eggs[idx].s -= eggs[i].w;
            eggs[i].s -= eggs[idx].w;
            if(eggs[idx].s <= 0){
                broken[idx] = true;
                tmp++;
            }
            if(eggs[i].s <= 0 ){
                broken[i] = true;
                tmp++;
            }
            solve(idx+1,tmp+cnt,broken);
            eggs[idx].s += eggs[i].w;
            eggs[i].s += eggs[idx].w;
            broken[i] = false;
            broken[idx] = false;
        }

    }
}
