import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q17406 {
    static int N ;
    static int M ;
    static int K ;
    static int[][] array ;
    static ArrayList<int[]> circular;
    static int minAns = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        K = Integer.parseInt(size[2]);
        array = new int[N+1][M+1];
        circular = new ArrayList<>();
        for(int i = 1 ; i <= N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 1 ; j <= M ; j ++){
                array[i][j] = Integer.parseInt(tmp[j-1]);
            }
        }
        for(int i = 0 ; i < K; i ++){
            String[] tmp = bf.readLine().split(" ");
            int r = Integer.parseInt(tmp[0]);
            int c = Integer.parseInt(tmp[1]);
            int s = Integer.parseInt(tmp[2]);
            circular.add(new int[] {r,c,s});
        }
        solve(0,new boolean[K],new int[K]);
        System.out.println(minAns);
    }
    public static void solve(int select, boolean[] check, int[] answer){
        if(select >= K){
            int[][] numArr = new int[N+1][M+1];
            for(int i = 1 ; i <= N ; i ++){
                numArr[i] = Arrays.copyOf(array[i],array[i].length);
            }
            for(int ans : answer){
                int[] rcs = circular.get(ans);
                turn(rcs[0],rcs[1],rcs[2],numArr);


            }
            int ans = Integer.MAX_VALUE;
            for(int i = 1 ; i <= N ; i ++){
                int tmp = 0;
                for(int j = 1 ; j <= M ; j ++){
                    tmp += numArr[i][j];
                }
                ans = Math.min(ans,tmp);
            }
            minAns = Math.min(minAns,ans);
            return;
        }
        for(int i = 0 ; i < K ; i ++){
            if(check[i])continue;
            check[i] = true;
            answer[select] = i;
            solve(select+1,check,answer);
            check[i] = false;
        }
    }
    public static void turn(int r, int c, int s,int[][] numArr){
        int r1 = r-s;
        int c1 = c-s;
        int r2 = r+s;
        int c2 = c+s;
        int tmpS = s;
        while(r1 < r2 && c1 < c2){
            int[] last = new int[tmpS*2];
            for(int i = c1 ; i < c2 ; i ++){
                last[i-c1] = numArr[r1][i];
            }
            // 좌
            for(int i = r1; i < r2; i ++){
                numArr[i][c1] = numArr[i+1][c1];
            }
            // 하
            for(int i = c1; i < c2; i ++){
                numArr[r2][i] = numArr[r2][i+1];
            }
            // 우
            for(int i = r2 ; i > r1; i--){
                numArr[i][c2] = numArr[i-1][c2];
            }
            for(int i = c1+1 ; i <= c2 ; i ++){
                numArr[r1][i] = last[i-(c1+1)];
            }
            r1 +=1;
            c1 +=1;
            r2 -=1;
            c2 -=1;
        }
    }
}
