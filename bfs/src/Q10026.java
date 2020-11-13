import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q10026 {
    static char[][]map;
    static int[][] blindNessGroup;
    static int[][] group;
    static LinkedList<int[] >queue;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        map = new char[n][n];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < n ; j ++){
                map[i][j] = str.charAt(j);
            }
        }
        blindNessGroup = new int[n][n];
        group = new int[n][n];
        int blindGroupNum = 0;
        int groupNum = 0;
        queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j++){
                if(blindNessGroup[i][j] == 0) {
                    ++blindGroupNum;
                    bfs(i, j, blindGroupNum, map[i][j], true);
                }
                if(group[i][j] == 0) {
                    ++groupNum;
                    bfs(i, j, groupNum, map[i][j], false);
                }
            }
        }
        System.out.println(groupNum+" "+blindGroupNum);
    }
    public static void bfs(int startI, int startJ, int groupNum,char target,boolean blindness){
        queue.add(new int[] {startI,startJ});
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            int idxI = idx[0];
            int idxJ = idx[1];
            for(int i = 0 ; i < 4; i ++){
                int curI = idxI + move[i][0];
                int curJ = idxJ + move[i][1];
                if(curI >= n || curI < 0 || curJ >= n || curJ < 0)continue;
                if(blindness){
                    if(blindNessGroup[curI][curJ] != 0)continue;
                    if(target == 'B'){
                        if(map[curI][curJ] != 'B')continue;
                    }
                    else{
                        if(map[curI][curJ] == 'B')continue;
                    }
                    blindNessGroup[curI][curJ] = groupNum;
                }

                else{
                    if(group[curI][curJ]!= 0)continue;
                    if(target != map[curI][curJ])continue;
                    group[curI][curJ] = groupNum;
                }
                queue.add(new int[]{curI,curJ});
            }
        }
    }
}
