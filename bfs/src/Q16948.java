import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q16948 {
    static class Pos{
        int r;
        int c;
        int cnt;
        public Pos(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int[] moveR = {-2,-2,0,0,2,2};
    static int[] moveC = {-1,+1,-2,+2,-1,+1};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int size = Integer.parseInt(bf.readLine());

        boolean[][] check = new boolean[size][size];
        String[] strArr = bf.readLine().split(" ");
        int r1 = Integer.parseInt(strArr[0]);
        int c1 = Integer.parseInt(strArr[1]);
        int r2 = Integer.parseInt(strArr[2]);
        int c2 = Integer.parseInt(strArr[3]);

        LinkedList<Pos> queue = new LinkedList<>();
        queue.add(new Pos(r1,c1,0));
        check[r1][c1] = true;
        int answer = -1;
        while(!queue.isEmpty()){
            Pos p = queue.remove();
            int r = p.r;
            int c = p.c;
            int cnt = p.cnt;
            for(int i = 0 ; i < 6; i ++){
                int curR = r+moveR[i];
                int curC = c+moveC[i];
                int curCnt = cnt+1;
                if(curR < 0 || curC < 0 || curR >= size || curC >= size)continue;
                if(!check[curR][curC]){
                    check[curR][curC] = true;
                    if(curR != r2 || curC != c2){
                        queue.add(new Pos(curR,curC,curCnt));
                        continue;
                    }
                    answer = curCnt;
                }
            }
        }
        System.out.println(answer);
    }
}
