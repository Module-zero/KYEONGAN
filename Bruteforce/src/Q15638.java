import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q15638 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int cctv_num = 0 ;
    static ArrayList<int[]> cc;
    static ArrayList<int[]> cc5;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        map = new int[N][M];
        cc = new ArrayList<>();
        cc5 = new ArrayList<>();
        int cc5Count = 0;
        for(int i = 0  ; i < N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = Integer.parseInt(tmp[j]);
                if(1<=map[i][j]&&map[i][j]<=5){
                    if(map[i][j] != 5){
                        cc.add(new int[]{i,j,map[i][j]});
                        cctv_num++;
                    }
                    else{
                        cc5.add(new int[]{i,j});
                    }
                }
            }
        }
        for(int[] a : cc5){
            int i = a[0];
            int j = a[1];
            for(int ii = 0 ; ii < 4 ; ii ++){
                see(i,j,move[ii][0],move[ii][1],map);
            }
        }
        select(0,new int[cctv_num]);

        System.out.println(min);
    }
    public static void see(int i, int j,int n, int m,int[][] cloneMap){
        while(true){
            i += n;
            j += m;
            if(0 > i || i >= N || 0 > j || j >= M)break;
            if(cloneMap[i][j] == 6)break;
            if(cloneMap[i][j] == 0){
                cloneMap[i][j] = 9;
            }
        }
    }
    public static void select(int cnt,int[] answer){
        if(cnt >= cctv_num){
            int[][] copy = new int[N][M];
            for(int i = 0 ; i < N ; i ++) {
                 copy[i] = Arrays.copyOf(map[i], M);
            }
            for(int i = 0 ; i < cctv_num ; i ++){
                int[] idx;
                int target;
                switch(cc.get(i)[2]){
                    case 1:
                        target = answer[i];
                        idx = cc.get(i);
                        see(idx[0],idx[1],move[target][0],move[target][1],copy);
                        break;
                    case 2:
                        idx = cc.get(i);
                        for(int ii = answer[i] ; ii < 4 ; ii +=2) {
                            target = ii;
                            see(idx[0],idx[1],move[target][0],move[target][1],copy);
                        }
                        break;
                    case 3:
                        idx = cc.get(i);
                        for(int c = 0 ; c <= 1 ; c ++){
                            target = answer[i]+c ;
                            target = target > 3 ? 0 : target;
                            see(idx[0],idx[1],move[target][0],move[target][1],copy);
                        }
                        break;
                    case 4:
                        idx = cc.get(i);
                        for(int c = 0; c <= 2 ; c++ ){
                            target = answer[i]+c;
                            target = target > 3 ? target - 4 : target;
                            see(idx[0],idx[1],move[target][0],move[target][1],copy);
                        }
                        break;
                    default:
                        break;

                }
            }
            int tmp = 0;
            for(int[] r : copy){
                for(int c : r){
                    if(c == 0){
                        tmp++;
                    }
                }
            }
            if( min > tmp){
                min = tmp;
                print(copy);
                System.out.println("--------["+min+"]-------");
            }
            return;
        }
        for(int i = 0 ; i < 4; i ++){
            if(cc.get(cnt)[2] == 2 && i >= 2) continue;
            answer[cnt] = i;
            select(cnt+1,answer);
        }
    }


    public static void print(int[][] m){
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
