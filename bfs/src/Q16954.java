import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q16954 {
    static int size = 8;
    static int startI = 7;
    static int startJ = 0;
    static int endI = 0;
    static int endJ = 7;
    static int[] moveI = {-1,1,0,0,1,1,-1,-1,0};
    static int[] moveJ = {0,0,-1,1,1,-1,1,-1,0};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        char[][] map = new char[size][size];
        for(int i = 0 ; i < size; i ++){
            map[i] = bf.readLine().toCharArray();
        }
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][][] check = new boolean[size][size][9];
        queue.add(new int[]{startI,startJ,0});
        check[startI][startJ][0] = true;
        boolean arrive = false;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            int idxI = idx[0];
            int idxJ = idx[1];
            int cnt = idx[2];
            if(idxI == endI && idxJ == endJ){
                arrive = true;
            }
            for(int i = 0 ; i < moveI.length; i ++){
                int curI = idxI +moveI[i];
                int curJ = idxJ +moveJ[i];
                int curCnt = Math.min(cnt+1,8);
                if(curI < 0 || curJ < 0 || curI >= size || curJ >= size)continue;
                if(curI - cnt >= 0 && map[curI- cnt][curJ] == '#')continue; // 이동한 벽
                if(curI - (cnt+1) >= 0 && map[curI- (cnt+1)][curJ] == '#')continue; // 이동한 후 벽이 이동
                if(check[curI][curJ][curCnt])continue;
                check[curI][curJ][curCnt] = true;
                queue.add(new int[]{curI,curJ,cnt+1});
            }
        }
        if(arrive){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
