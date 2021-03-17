import java.io.*;
import java.util.*;

public class Line2019_1 {
    public static void main(String[]args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int C = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);

        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[200001][2];
        queue.add(new int[]{C,B,1,1});
        check[B][1%2] = true;
        boolean catchB = false;
        int ans = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int curC = cur[0];
            int curB = cur[1];
            int moveC = cur[2];
            int minute = cur[3];
            System.out.println(curC+","+curB+","+moveC+","+minute);
            if(curC+moveC > 200000)continue;
            int c = curC+moveC;
            if(curB - 1 >= 0){
                int b = curB-1;
                if(!check[b][minute%2]) {
                    check[b][minute%2] = true;
                    if (c != b) {
                        queue.add(new int[]{c, b, moveC+1, minute+1});
                    } else {
                        catchB = true;
                    }
                }
            }

            if(curB + 1 <= 200000){
                int b = curB + 1;
                if(!check[b][minute%2]) {
                    check[b][minute%2] = true;
                    if (c != b) {
                        queue.add(new int[]{c, b, moveC+1, minute+1});
                    } else {
                        catchB = true;
                    }
                }
            }

            if(curB * 2 <= 200000){
                int b = curB * 2;
                if(!check[b][minute%2]) {
                    check[b][minute%2] = true;
                    if (c != b) {
                        queue.add(new int[]{c, b, moveC+1, minute+1});
                    } else {
                        catchB = true;
                    }
                }
            }
            if(catchB){
                ans = minute;
                break;
            }
        }
        System.out.println(ans);
    }
}
