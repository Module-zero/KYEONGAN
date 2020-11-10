import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Q16946 {
    static int[] groupCnt;
    static int[] moveI = {-1,1,0,0};
    static int[] moveJ = {0,0,-1,1};
    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] size = bf.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        map = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j ++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        groupCnt = new int[n*m+2];


        int groupNum = 2;
        boolean[][] check = new boolean[n][m];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(map[i][j] == 0 && !check[i][j]){
                    bfs(i,j,groupNum++,check);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(map[i][j] == 1){
                    LinkedHashSet<Integer> set = new LinkedHashSet<>();
                    for(int k = 0 ; k < 4 ; k++){
                        int curI = i + moveI[k];
                        int curJ = j + moveJ[k];
                        if(curI < 0 || curJ < 0 || curI >= n || curJ >= m)continue;
                        if(map[curI][curJ]!=1) {
                            set.add(map[curI][curJ]);
                        }
                    }
                    int tmp = 1;
                    for(int a : set){
                        tmp+= groupCnt[a];
                    }
                    sb.append(tmp%10);
                }
                else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    public static void bfs(int i , int j,int groupNum,boolean[][] check){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        check[i][j] = true;
        map[i][j] = groupNum;
        int size = 1;
        while(!queue.isEmpty()){
            int[] Idx = queue.remove();
            int idxI = Idx[0];
            int idxJ = Idx[1];
            for(int k = 0 ; k < 4; k ++ ){
                int curI = idxI + moveI[k];
                int curJ = idxJ + moveJ[k];
                if(curI < 0 || curJ < 0 || curI >= n || curJ >= m)continue;
                if(check[curI][curJ] || map[curI][curJ]==1)continue;
                check[curI][curJ] = true;
                map[curI][curJ] = groupNum;
                size ++;
                queue.add(new int[]{curI,curJ});
            }
        }
        groupCnt[groupNum] = size;
    }
}


