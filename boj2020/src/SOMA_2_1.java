import java.io.*;
import java.util.*;

public class SOMA_2_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int t = 0; t < T ; t ++){
            String[] size = bf.readLine().split(" ");
            int I = Integer.parseInt(size[0]); // 세로
            int J = Integer.parseInt(size[1]); // 가로
            int[][] map = new int[I][J];
            int[] curIdx  = new int[2];
            int[] key = new int[2];
            int[] box = new int[2];
            for(int i = 0 ; i < I ; i ++){
                String[] str = bf.readLine().split(" ");
                for(int j = 0;j < J ; j ++){
                    map[i][j] = Integer.parseInt(str[j]);
                    if(map[i][j] == 0 || map[i][j] == 1)continue;
                    if(map[i][j] == 3){
                        curIdx[0] = i;
                        curIdx[1] = j;
                    }
                    else if(map[i][j] == 4){
                        key[0] = i;
                        key[1] = j;
                    }
                    else if(map[i][j] == 2){
                        box[0] = i;
                        box[1] = j;
                    }
                }
            }

            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(new int[]{curIdx[0],curIdx[1]});
            map[curIdx[0]][curIdx[1]] = -1;
            while(!queue.isEmpty()){
                int[] idx = queue.remove();
                int curX = idx[0];
                int curY = idx[1];
                boolean success = false;
                for(int i = 0 ; i < 4 ; i ++){
                    int tmpI = curX + move[i][0];
                    int tmpJ = curY + move[i][1];
                    if( 0 > tmpI || 0 > tmpJ || tmpI >= I ||tmpJ >= J)continue;
                    if(map[tmpI][tmpJ] == 1 || map[tmpI][tmpJ] == -1)continue;
                    if (map[tmpI][tmpJ] == 4) {
                        key[0] = tmpI;
                        key[1] = tmpJ;
                    }
                    else if(map[tmpI][tmpJ] == 2){
                        box[0] = tmpI;
                        box[1] = tmpJ;
                        success = true;
                    }
                    map[tmpI][tmpJ] = -1;

                    if(success){
                        break;
                    }
                    else{
                        queue.add(new int[]{tmpI,tmpJ});
                    }
                }
                if(success){
                    break;
                }
            }
            if(map[key[0]][key[1]]!=4 && map[box[0]][box[1]]!=2){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
