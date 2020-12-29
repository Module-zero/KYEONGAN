import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q3019 {
    static int c;
    static int p;
    static int[] block;
    static int ans;
    static int[][][] tetris = {
            {{0},{0,0,0,0}},
            {{0,0}},
            {{0,0,1},{1,0}},
            {{1,0,0},{0,1}},
            {{0,0,0},{0,1},{1,0,1},{1,0}},
            {{0,0,0},{0,0},{0,1,1},{2,0}},
            {{0,0,0},{0,2},{1,1,0},{0,0}}
    };

    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        c = Integer.parseInt(str[0]);
        p = Integer.parseInt(str[1]);
        block = new int [c];
        String[] b = bf.readLine().split(" ");
        for(int i = 0 ; i < c ; i ++){
            block[i] = Integer.parseInt(b[i]);
        }
        int cir = tetris[p-1].length;
        for(int i = 0 ; i < cir ; i ++){
            solve(tetris[p-1][i],0);
        }
        System.out.println(ans);
    }
    public static void solve(int[] shape,int idx){
        if(idx >= c){
            return;
        }
        int len = shape.length;
        int gap = block[idx] - shape[0];
        boolean success = true;
        for(int i = 0 ; i < len ;i ++){
            int curIdx = idx+i;
            if(curIdx >= c ){
                success = false;
                continue;
            }
            int tmp = block[curIdx] - shape[i];
            if(tmp != gap){
                success = false;
            }
        }
        if(success){
            ans++;
        }
        solve(shape,idx+1);
    }
}
