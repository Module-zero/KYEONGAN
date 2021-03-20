import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q17780 {
    static int[][] move = {{0,1},{0,-1},{-1,0},{1,0}}; // 우 좌 상 하
    static class Horse{
        int x,y,direction;
        public Horse(int x,int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
        public void dReverse(){
            if(this.direction % 2 == 0)
                this.direction ++;
            else
                this.direction --;

        }
    }
    public static void main(String[]args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = bf.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        Horse[] horses = new Horse[K];
        ArrayList<Integer>[][] map = new ArrayList[N][N];
        for(int i = 0 ; i < N ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++){
                map[i][j] = new ArrayList<>();
                int num = Integer.parseInt(str[j]);
                map[i][j].add(num);
            }
        }
        boolean[] under = new boolean[K];
        int[][] count = new int[N][N];
        for(int i = 0 ; i < K ; i ++){
            String[] str = bf.readLine().split(" ");
            int x = Integer.parseInt(str[0])-1;
            int y = Integer.parseInt(str[1])-1;
            horses[i] = new Horse(x,y,Integer.parseInt(str[2])-1);
            under[i] = true;
            map[x][y].add(i+3);
            count[x][y] = 1;
        }
        boolean end = false;
        int answer = 0 ;
        for(int turn = 1 ; turn <= 1000 ; turn ++){
            for(int t = 0 ; t < K ; t ++){
                if(!under[t])continue;
                int d = horses[t].direction;
                int curX = horses[t].x;
                int curY = horses[t].y;
                int moveX = curX + move[d][0];
                int moveY = curY + move[d][1];
                if((0 > moveX || 0 > moveY || N <= moveX || N <= moveY)|| (map[moveX][moveY].get(0) == 2)){
                    horses[t].dReverse();
                }
                d = horses[t].direction;
                moveX = curX + move[d][0];
                moveY = curY + move[d][1];
                if(0 > moveX || 0 > moveY || N <= moveX || N <= moveY)continue;
                boolean stay = false;
                ArrayList<Integer> tmp = map[curX][curY];
                int bottom = tmp.get(1);
                int top = tmp.get(tmp.size()-1);
                if(map[moveX][moveY].get(0) == 1){
                    int num = bottom;
                    bottom = top;
                    top = num;
                    under[top-3] = false;
                    under[bottom-3] = true;
                }
                else if(map[moveX][moveY].get(0) == 2){
                    stay = true;
                }

                if(!stay){
                    if(map[moveX][moveY].size() == 3){
                        map[moveX][moveY].set(2,top);
                        under[top-3] = false;
                        under[bottom-3] = false;
                    }
                    else if(map[moveX][moveY].size() == 2){
                        map[moveX][moveY].add(top);
                        under[top-3] = false;
                        under[bottom-3] = false;
                    }
                    else{
                        if(tmp.size() == 3){
                            map[moveX][moveY].add(bottom);
                        }
                        map[moveX][moveY].add(top);
                    }
                    count[moveX][moveY] += count[curX][curY];
                    count[curX][curY] = 0;
                    int s= tmp.size()-1;
                    for(int i = 1;  i <= s; i ++){
                        int num = map[curX][curY].remove(1);
                        horses[num-3].x = moveX;
                        horses[num-3].y = moveY;
                    }

                }
                if(count[moveX][moveY] >= 4){
                    answer = turn;
                    end = true;
                    break;
                }
            }
            if(end){
                break;
            }
        }
        if(end)
            System.out.println(answer);
        else
            System.out.println(-1);

    }
    public static void print(Horse[] horses, int t, ArrayList<Integer>[][] map,boolean[] under,int[][] count){
        System.out.println("move:"+t);
        int cnt = 0;
        for(Horse h : horses){
            System.out.println(h.x+","+h.y+","+under[cnt++]+","+ h.direction);
        }
        for(ArrayList<Integer>[] mm : map){
            for(ArrayList<Integer> m : mm){
                for(Integer a : m){
                    System.out.print(a);
                }
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        for(int[] cc : count){
            for(int c : cc){
                System.out.print(c+" ");
            }
            System.out.println(" ");
        }
        System.out.println("---------------");
    }
}
