import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Q2210 {
    static int[][] map;
    static TreeSet<Integer> answer;
    static int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        map = new int[5][5];
        answer = new TreeSet<>();
        for(int i = 0 ; i < 5; i ++){
            String [] tmp = bf.readLine().split(" ");
            for(int j = 0 ; j < 5 ; j ++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        for(int i = 0 ; i < 5 ; i ++){
            for(int j = 0 ; j < 5 ; j ++){
                go(i,j,0,0);
            }
        }
        System.out.println(answer.size());
    }
    public static void go(int i, int j, int cnt,int sum){
        if(cnt >= 6){
            answer.add(sum);
            return;
        }
        for(int k = 0 ; k < 4 ; k ++){
            int curI = i+move[k][0];
            int curJ = j+move[k][1];
            if(0 > curI || curI >= 5 || 0 > curJ || curJ >= 5)continue;
            int num = map[curI][curJ];
            go(curI,curJ,cnt+1,(sum*10)+num);
        }
    }
}
