import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q2146 {
    static int[][] map;
    static int[][] group;
    static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static int[] mI = {0,0,-1,1};
    static int[] mJ = {1,-1,0,0};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        map = new int[t][t];
        group = new int[t][t];
        for( int i = 0 ; i < t; i ++){
            String[] strArr = bf.readLine().split(" ");
            for(int j = 0 ; j < t; j ++){
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        int g = 2;
        LinkedList<Point> gQueue = new LinkedList<>();
        for(int i = 0 ; i < t ; i ++){
            for(int j = 0 ; j < t ; j ++){
                if(map[i][j] == 1 && group[i][j] == 0){
                    gQueue.add(new Point(i,j));
                    while(!gQueue.isEmpty()){
                        Point p = gQueue.remove();
                        int startI = p.i;
                        int startJ = p.j;
                        group[startI][startJ] = g;
                        for(int k = 0 ; k < 4; k ++){
                            int tmpI = startI+mI[k];
                            int tmpJ = startJ+mJ[k];
                            if(tmpI >=0 && tmpJ >=0 && tmpI < t && tmpJ < t){
                                if(group[tmpI][tmpJ] == 0 && map[tmpI][tmpJ] == 1){
                                    gQueue.add(new Point(tmpI,tmpJ));
                                    group[tmpI][tmpJ] = g;
                                }
                            }
                        }
                    }
                    g++;
                }
            }
        }
        LinkedList<Point> queue = new LinkedList<>();
        int cnt = 0;
        while(true) {
            boolean flag = false;
            boolean match = false;
            cnt++;
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    if (map[i][j] == cnt) {
                        flag = true;
                        int sI = i;
                        int sJ = j;
                        for (int k = 0; k < 4; k++) {
                            int tmpI = sI + mI[k];
                            int tmpJ = sJ + mJ[k];
                            if (tmpI >= 0 && tmpJ >= 0 && tmpI < t && tmpJ < t) {
                                if (map[tmpI][tmpJ] == 0) {
                                    map[tmpI][tmpJ] = map[sI][sJ] + 1;
                                    group[tmpI][tmpJ] = group[sI][sJ];
                                }
                            }
                        }
                    }
                }
            }
            if(!flag){
                break;
            }
        }
        for(int i = 0 ; i < t ; i ++){
            for(int j = 0 ; j < t ; j ++){
                for(int k = 0 ; k < 4 ; k ++){
                    int tmpI = i + mI[k];
                    int tmpJ = j + mJ[k];
                    if (tmpI >= 0 && tmpJ >= 0 && tmpI < t && tmpJ < t) {
                        if(group[i][j] != group[tmpI][tmpJ]){
                            answer = Math.min(answer,map[i][j]+map[tmpI][tmpJ]);
                        }
                    }
                }
            }
        }
        System.out.println(answer-2);
    }
}
