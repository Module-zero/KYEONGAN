import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q18809 {
    static class Pos {
        int x, y;
        boolean use;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Pos(Pos p){
            this(p.x,p.y);
            this.use = p.use;
        }
        public Pos(int x, int y, boolean use){
            this(x,y);
            this.use = use;
        }
    }

    static ArrayList<Pos> seed;
    static int R;
    static int G;
    static ArrayList<Pos> red;
    static ArrayList<Pos> green;
    static int[][] map;
    static int N;
    static int M;
    static int max;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        M = Integer.parseInt(init[1]);
        G = Integer.parseInt(init[2]);
        R = Integer.parseInt(init[3]);
        red = new ArrayList<>();
        green = new ArrayList<>();
        map = new int[N][M];
        seed = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = (-1)*Integer.parseInt(tmp[j]);
                if(map[i][j] == 0){
                    map[i][j] = -3;
                }
                if(map[i][j] == -2){
                    seed.add(new Pos(i,j,false));
                }
            }
        }
        dfs(3,0);
        System.out.println(max);
    }
    public static void dfs(int color, int idx){
        if(color == 3 && red.size() >= R){
            dfs(4,0);
            return;
        }
        if(color == 4 && green.size() >= G ){
            max = Math.max(bfs(),max);
            return;
        }
        for(int i = idx; i < seed.size() ; i ++) {
            Pos p = seed.get(i);
            if (p.use) {
                dfs(color, i + 1);
                return;
            }
            p.use = true;
            if (color == 3) {
                red.add(new Pos(p));
            }
            if (color == 4) {
                green.add(new Pos(p));
            }
            dfs(color, i + 1);
            p.use = false;
            if (red.size() > 0 && color == 3) {
                red.remove(red.size()-1);
            }
            if (green.size() > 0 && color == 4) {
                green.remove(green.size() - 1);
            }
        }
    }
    public static int bfs(){
        int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
        int[][] mapClone = new int[N][M];
        int[][] check = new int[N][M]; // 꽃 표시
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                mapClone[i][j] = map[i][j];
            }
        }
        LinkedList<Pos> greenQ = new LinkedList<>();
        for(Pos p : green){
            greenQ.add(p);
            mapClone[p.x][p.y] = 4;
        }
        LinkedList<Pos> redQ = new LinkedList<>();
        for(Pos p : red){
            redQ.add(p);
            mapClone[p.x][p.y] = 3;
        }
        int ans = 0;
        int time = 1;
        do {
            int redTime = redQ.size();
            int greenTime = greenQ.size();
            while (redTime --> 0) {
                Pos p = redQ.remove();
                if(mapClone[p.x][p.y] == -4)continue;
                for (int[] ints : move) {
                    int curI = p.x + ints[0];
                    int curJ = p.y + ints[1];
                    if (0 > curI || 0 > curJ || curI >= N || curJ >= M) continue;
                    if (mapClone[curI][curJ] == -1 || mapClone[curI][curJ] == -2){
                        mapClone[curI][curJ] = 3;
                        check[curI][curJ] = time;
                        redQ.add(new Pos(curI, curJ));
                    }
                }
            }

            while (greenTime --> 0) {
                Pos p = greenQ.remove();
                for (int[] m : move) {
                    int curI = p.x + m[0];
                    int curJ = p.y + m[1];
                    if (0 > curI || 0 > curJ || curI >= N || curJ >= M) continue;
                    if(mapClone[curI][curJ] == -1 || mapClone[curI][curJ] == -2){
                        mapClone[curI][curJ] = 4;
                        greenQ.add(new Pos(curI, curJ));
                    }
                    if (mapClone[curI][curJ] == 3 && check[curI][curJ] == time) {
                        ans++;
                        mapClone[curI][curJ] = -4;
                    }
                }
            }
            time ++;
        }while(!greenQ.isEmpty() || !redQ.isEmpty());
        return ans;
    }
}
