import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1261 {
    static class Pos{
        int i ;
        int j ;
        public Pos(int i ,int j ){
            this.i = i;
            this.j = j;
        }
    }
    static int[] goI = {0,-1,1,0};
    static int[] goJ = {-1,0,0,1};
    static int[][] answer ;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[1]);
        int m = Integer.parseInt(strArr[0]);
        int[][] map = new int[n][m];

        for(int i = 0 ; i < n ; i ++){
            char[] strArr1 = bf.readLine().toCharArray();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = strArr1[j]-'0';
            }
        }
        answer  = new int[n][m];

        LinkedList<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0));
        boolean[][] check = new boolean[n][m];
        while(!queue.isEmpty()){
            Pos p = queue.remove();
            int i = p.i;
            int j = p.j;
            for(int k = 0 ; k < 4; k++){
                int curI = i + goI[k];
                int curJ = j + goJ[k];
                if(curI < 0 || curJ < 0 ||curI >= n || curJ >= m)continue;
                if(!check[curI][curJ]){
                    check[curI][curJ] = true;
                    if(map[curI][curJ] == 1){
                        answer[curI][curJ] = answer[i][j] + 1;
                        queue.addLast(new Pos(curI,curJ));
                    }
                    else{
                        answer[curI][curJ] = answer[i][j];
                        queue.addFirst(new Pos(curI,curJ));
                    }

                }
            }
        }
        System.out.println(answer[n-1][m-1]);
    }
}
