import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q18500 {
    static char[][]map;
    static int R,C;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] scale = bf.readLine().split(" ");
        R = Integer.parseInt(scale[0]);
        C = Integer.parseInt(scale[1]);
        map = new char[R][C];
        for(int i = 0 ; i < R ; i ++){
            map[i] = bf.readLine().toCharArray();
        }
        int N = Integer.parseInt(bf.readLine());
        String[] tc = bf.readLine().split(" ");
        for(int i = 0 ; i < N ; i ++){
            int height = R - Integer.parseInt(tc[i]);
            int broken ;
            if(i % 2 == 0){
                broken = 0;
                while(broken < C && map[height][broken] != 'x'){
                    broken++;
                }
            }
            else{
                broken = C-1;
                while(broken >= 0 && map[height][broken] != 'x'){
                    broken--;
                }
            }
            if(0 <= broken && broken < C){
                map[height][broken] = '.';
                solve(height,broken);
            }
        }
        print();
    }
    public static void solve(int i,int j){
        int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
        ArrayList<int[]> block = new ArrayList<>();
        boolean flag = false;
        for(int k = 0 ; k < 4 ; k ++){
            block = new ArrayList<>();
            int curI = i + move[k][0];
            int curJ = j + move[k][1];
            if(0 > curI || 0 > curJ || curI >= R || curJ >= C)continue;
            if(map[curI][curJ] == 'x'){
                block = isChain(curI,curJ);
                if(!block.isEmpty()){
                    flag = true;
                    break;
                }
            }
        }
        if(flag) {
            int downNum = down(block);
            for (int[] b : block) {
                map[b[0] + downNum][b[1]] = 'x';
            }
        }
    }
    public static int down(ArrayList<int[]> block){
        for(int[] b : block){
            map[b[0]][b[1]] = '.';
        }
        int answer = 0;
        for(int i = 1 ; i < R ; i ++){
            for(int[] b : block){
                if(b[0]+i >= R || map[b[0]+i][b[1]] == 'x'){
                    answer = i - 1;
                    break;
                }
            }
            if(answer != 0){
                break;
            }
        }
        return answer;
    }
    public static ArrayList<int[]> isChain(int i, int j){
        if(i == R - 1){
            return new ArrayList<>();
        }
        int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
        LinkedList<int[]> queue = new LinkedList<>();
        ArrayList<int[]> block = new ArrayList<>();
        queue.add(new int[]{i,j});
        block.add(new int[]{i,j});
        boolean[][] check = new boolean[R][C];
        check[i][j] = true;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            for(int k = 0 ; k < 4 ; k ++){
                int curI = idx[0] + move[k][0];
                int curJ = idx[1] + move[k][1];
                if(0 > curI || 0 > curJ || curI >= R || curJ >= C)continue;
                if(check[curI][curJ] || map[curI][curJ] == '.')continue;
                check[curI][curJ] = true;
                block.add(new int[]{curI,curJ});
                if(curI == R-1){
                    return new ArrayList<>();
                }
                queue.add(new int[]{curI,curJ});
            }
        }
        return block;
    }
    public static void print(){
        for(char[] mm : map){
            for(char m : mm){
                System.out.print(m);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
