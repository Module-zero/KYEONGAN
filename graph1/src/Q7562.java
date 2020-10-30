import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q7562 {
    static class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] mX = {-2,-1,1,2,2,1,-1,-2};
    static int[] mY = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < t ; i ++){
            int size = Integer.parseInt(bf.readLine());
            int[][] map = new int[size][size];
            String[] idx = bf.readLine().split(" ");
            int startX = Integer.parseInt(idx[0]);
            int startY = Integer.parseInt(idx[1]);
            map[startX][startY] = 1;
            String[] idx2 = bf.readLine().split(" ");
            int endX = Integer.parseInt(idx2[0]);
            int endY = Integer.parseInt(idx2[1]);
            LinkedList<Point> queue = new LinkedList<>();
            queue.add(new Point(startX,startY));
            boolean flag = false;
            while(!queue.isEmpty()){
                Point p = queue.pop();
                int x = p.x;
                int y = p.y;
                for(int k = 0 ; k < 8 ; k++){
                    int tmpX = x+mX[k];
                    int tmpY = y+mY[k];
                    if(tmpX >= 0 && tmpY >= 0 && tmpX < size && tmpY <size) {
                        if (map[tmpX][tmpY] == 0) {
                            map[tmpX][tmpY] = map[x][y] + 1;
                            if(tmpX == endX && tmpY == endY){
                                flag = true;
                                break;
                            }
                            queue.add(new Point(tmpX,tmpY));
                        }
                    }
                }
                if(flag){
                    break;
                }
            }
            sb.append((map[endX][endY]-1)+"\n");
        }
        System.out.println(sb);
    }
}
