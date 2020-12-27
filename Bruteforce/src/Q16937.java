import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16937 {
    static int H;
    static int W;
    static int N;
    static int[][] sticker;
    static int max = 0;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        H = Integer.parseInt(size[0]);
        W = Integer.parseInt(size[1]);
        N = Integer.parseInt(bf.readLine());
        sticker = new int[N][2];
        for( int i = 0 ; i < N ; i ++){
            String[] str = bf.readLine().split(" ");
            sticker[i][0] = Integer.parseInt(str[0]);
            sticker[i][1] = Integer.parseInt(str[1]);
        }

        select(H,W,H,W,0,new boolean[N],new int[2]);
        System.out.println(max);
    }
    public static void select(int h1, int w1, int h2, int w2, int cnt, boolean[] check, int[] answer){
        if(cnt == 2){
            int tmp = 0;
            for(int i : answer){
                tmp += (sticker[i][0] * sticker[i][1]);
            }
            max = Math.max(tmp,max);
            return;
        }
        for(int i = 0 ; i < N ; i ++){
            if(check[i])continue;
            if( (sticker[i][0] <= h1 && sticker[i][1] <= w1) || (sticker[i][0] <= h2 && sticker[i][1] <= w2)){
                check[i] = true;
                answer[cnt] = i;
                select(h1-sticker[i][0],w1,h2,w2-sticker[i][1],cnt+1,check,answer);
                check[i] = false;
            }
            if((sticker[i][1] <= h1 && sticker[i][0] <= w1) || (sticker[i][1] <= h2 && sticker[i][0] <= w2)){
                check[i] = true;
                answer[cnt] = i;
                select(h1-sticker[i][1],w1,h2,w2-sticker[i][0],cnt+1,check,answer);
                check[i] = false;
            }
        }
    }
}
