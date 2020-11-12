import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Q3055 {
    static char[][] map;
    static int n;
    static int m;
    static int[] moveI = {-1,1,0,0};
    static int[] moveJ = {0,0,-1,1};
    static boolean[][][] check;
    static LinkedList<int[]> wQueue;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);
        map = new char[n][m];
        wQueue = new LinkedList<>();
        LinkedList<int[]> mQueue = new LinkedList<>();
        check = new boolean[n][m][2];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j++){
                char tmp = str.charAt(j);
                if(tmp == 'S'){
                    mQueue.add(new int[]{i,j,0});
                    check[i][j][0] = true;
                }
                if(tmp == '*'){
                    wQueue.add(new int[]{i,j});
                    check[i][j][1] = true;
                }
                map[i][j] = tmp;
            }
        }

        boolean arrive = false;
        int answer = Integer.MAX_VALUE;
        Stack<int[]> stack = new Stack<>();
        while(!mQueue.isEmpty()){
            while(!wQueue.isEmpty()){
                stack.push(wQueue.remove());
            }
            while(!stack.isEmpty()){
                int[] wIdx = stack.pop();
                bfs(wIdx[0],wIdx[1]);
            }
            while(!mQueue.isEmpty()){
                stack.push(mQueue.pop());
            }
            while(!stack.isEmpty()) {
                int[] mIdx = stack.pop();
                int mIdxI = mIdx[0];
                int mIdxJ = mIdx[1];
                int cnt = mIdx[2];
                for (int i = 0; i < 4; i++) {
                    int curI = mIdxI + moveI[i];
                    int curJ = mIdxJ + moveJ[i];
                    if (curI < 0 || curJ < 0 || curI >= n || curJ >= m) continue;
                    if (map[curI][curJ] == '*' || map[curI][curJ] == 'X') continue;
                    if (check[curI][curJ][0]) continue;
                    check[curI][curJ][0] = true;
                    if (map[curI][curJ] == 'D') {
                        arrive = true;
                        answer = Math.min(answer, cnt + 1);
                        continue;
                    }
                    mQueue.add(new int[]{curI, curJ, cnt + 1});
                }
            }
        }
        if(arrive){
            System.out.println(answer);
        }
        else{
            System.out.println("KAKTUS");
        }

    }
    public static void bfs(int i , int j){
        for(int k = 0 ; k < 4; k ++){
            int curI = i + moveI[k];
            int curJ = j + moveJ[k];
            if(curI < 0 || curJ < 0 || curI >= n || curJ >= m)continue;
            if(map[curI][curJ] == 'D' || map[curI][curJ] == 'X')continue;
            if(check[curI][curJ][1])continue;
            check[curI][curJ][1] = true;
            map[curI][curJ] = '*';
            wQueue.add(new int[]{curI,curJ});
        }
    }
}
