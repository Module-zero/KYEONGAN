import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Q6087 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[1]);
        int m = Integer.parseInt(strArr[0]);
        char[][] map = new char[n][m];
        boolean first = false;
        int endI = n+1;
        int endJ = m+1;
        LinkedList<int []> queue = new LinkedList<>();
        int[][] memo = new int[n][m];
        int[] c1 = new int[2];
        int[] c2 = new int[2];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j ++){
                map[i][j] = str.charAt(j) ;
                if(!first && map[i][j] == 'C'){
                    queue.add(new int[]{i,j,0});
                    memo[i][j] = 1;
                    c1[0] = i;
                    c1[1] = j;
                    first = true;
                }
                else if(first && map[i][j] == 'C'){
                    c2[0] = i;
                    c2[1] = j;
                }
            }
        }
        int[][] move = {{1,0},{-1,0},{0,-1},{0,1}};
        int[][] check = new int[n][m];
        int answer = 0;
        while(!queue.isEmpty()){
            int[] idx = queue.pop();
            int idxI = idx[0];
            int idxJ = idx[1];
            int cnt = idx[2];
            check[idxI][idxJ] = cnt;
            for(int i = 0 ; i < 4; i ++){
                int curI = idxI;
                int curJ = idxJ;
                while(true){
                    curI += move[i][0];
                    curJ += move[i][1];
                    if(curI >= n || curI < 0 || curJ >= m || curJ < 0)break;
                    if(check[curI][curJ] != 0)continue;
                    if(map[curI][curJ] == '*') break;
                    check[curI][curJ] = cnt+1;
                    if(curI == c2[0] && curJ == c2[1]){
                        answer = cnt;
                        continue;
                    }
                    queue.add(new int[]{curI,curJ,cnt+1});
                }
            }
        }
        for(int[] i : check){
            for(int j : i){
                System.out.print(j);
            }
            System.out.println("");
        }
        System.out.println(answer);
    }
}
