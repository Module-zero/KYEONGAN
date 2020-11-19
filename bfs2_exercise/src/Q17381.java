//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//
//public class Q17381 {
//    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
//    static char[] limit = {'U','D','R','L'};
//    static int n;
//    static int m;
//    static char[][] maze;
//    static boolean[][] clean;
//    public static void main(String[] args)throws Exception{
////        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
//        String[] strArr = bf.readLine().split(" ");
//        n = Integer.parseInt(strArr[0]);
//        m = Integer.parseInt(strArr[1]);
//        int q = Integer.parseInt(strArr[2]);
//        maze = new char[n+1][m+1];
//        for(int i = 1 ; i <= n; i ++){
//            String str = bf.readLine();
//            for(int j = 1 ; j <= m ; j++){
//                maze[i][j] = str.charAt(j-1);
//            }
//        }
//        for(int i = 0 ; i < q ; i++){
//            int answer = 0;
//            String[] idx = bf.readLine().split(" "); // startI startJ endI endJ
//            clean = new boolean[n+1][m+1];
//            int startI = Integer.parseInt(idx[0]);
//            int startJ = Integer.parseInt(idx[1]);
//            int endI = Integer.parseInt(idx[2]);
//            int endJ = Integer.parseInt(idx[3]);
//            dfs(startI,startJ,endI,endJ,new boolean[n+1][m+1][4],0,-1);
//            for(boolean[] cc :clean){
//                for(boolean c : cc){
//                    if(c) {
//                        answer++;
//                    }
//                }
//            }
//            System.out.println(answer);
//        }
//    }
//    public static void dfs(int i,int j, int endI, int endJ, boolean[][][] check, int cnt,int his){
//        if(his == -1) {
//            check[i][j][0] = true;
//        }
//        else{
//            check[i][j][his] = true;
//        }
//        if(i == endI && j == endJ){
//            for(int ii = 1 ; ii <= n ; ii++){
//                for(int jj = 1 ; jj<= m ; jj++ ){
//                    for(int kk = 0 ; kk < 4 ; kk++) {
//                        if (check[ii][jj][kk]) {
//                            clean[ii][jj] = check[ii][jj][kk];
//                        }
//                    }
//                }
//            }
//        }
//        for(int k = 0 ; k < 4 ; k++){
//            int curI = i + move[k][0];
//            int curJ = j + move[k][1];
//            if(curI <= 0 || curI > m || curJ <= 0 || curJ > m)continue;
//            if(maze[i][j] == limit[k])continue;
//            if(check[curI][curJ][k])continue;
//            dfs(curI,curJ,endI,endJ,check,cnt+1,k);
//        }
//        if(his != -1) {
//            check[i][j][his] = false;
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q17381{
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    static char[] limit = {'U','D','R','L'};
    static int n;
    static int m;
    static char[][] maze;
    static int[][] group;
    static LinkedList<int[]> queue = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);
        int q = Integer.parseInt(strArr[2]);
        maze = new char[n+1][m+1];
        for(int i = 1 ; i <= n; i ++){
            String str = bf.readLine();
            for(int j = 1 ; j <= m ; j++){
                maze[i][j] = str.charAt(j-1);
            }
        }
        group = new int[n+1][m+1];
        for(int i = 0 ; i < q ; i++){
            String[] idx = bf.readLine().split(" "); // startI startJ endI endJ
            int newNum ;
            int startI = Integer.parseInt(idx[0]);
            int startJ = Integer.parseInt(idx[1]);
            int endI = Integer.parseInt(idx[2]);
            int endJ = Integer.parseInt(idx[3]);
            newNum = group(startI,startJ,endI,endJ,i+1);
            System.out.println(newNum);
            if(newNum != 0){
                for(int iii = 1 ; iii <= n ; iii++){
                    for(int jjj = 1 ; jjj <= m ; jjj++ ){
                        if(group[iii][jjj] == i+1){
                            group[iii][jjj] = 0;
                        }
                    }
                }
            }
        }
    }
    public static int group(int i,int j,int endI, int endJ,int groupNum){
        queue.add(new int[]{i,j});
        group[i][j] = groupNum;
        boolean arrive = false;
        if(i == endI && j == endJ){
            arrive = true;
        }
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            int startI = idx[0];
            int startJ = idx[1];
            for(int k = 0 ; k < 4; k ++){
                int curI = startI + move[k][0];
                int curJ = startJ + move[k][1];
                if(curI <= 0 || curJ <= 0 || curI > n || curJ > m)continue;
                if(maze[startI][startJ] == limit[k])continue;
                if(group[curI][curJ] != 0)continue;
                group[curI][curJ] = groupNum;
                if(curI == endI && curJ == endJ){
                    arrive = true;
                }
                queue.add(new int[] {curI,curJ});
            }
        }
        if(!arrive){
            return 0;
        }
        else{
            int cnt = 0;
            for(int[] kk : group){
                for(int kkk : kk){
                    if(kkk == groupNum){
                        cnt ++;
                    }
                }
            }
            return cnt;
        }
    }
}
