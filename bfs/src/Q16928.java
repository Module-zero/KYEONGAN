import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;

public class Q16928 {
    static class Move{
        int from;
        int to;
        public Move(int from, int to){
            this.from = from;
            this.to = to;
        }
    }
    static class Current{
        int cur;
        int cnt;
        public Current(int cur,int cnt){
            this.cur = cur;
            this.cnt = cnt;
        }
    }
    static Move[] ladder;
    static Move[] snake;
    static int[] dice = {1,2,3,4,5,6};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int ladderNum = Integer.parseInt(strArr[0]);
        ladder = new Move[ladderNum];
        int snakeNum = Integer.parseInt(strArr[1]);
        snake = new Move[snakeNum];
        for(int i = 0 ; i < ladderNum ; i ++){
            String[] stArr = bf.readLine().split(" ");
            ladder[i] = new Move(Integer.parseInt(stArr[0]), Integer.parseInt(stArr[1]));
        }
        for(int i = 0 ; i < snakeNum ; i ++){
            String[] stArr = bf.readLine().split(" ");
            snake[i] = new Move(Integer.parseInt(stArr[0]), Integer.parseInt(stArr[1]));
        }

        LinkedList<Current> queue = new LinkedList<>();
        queue.add( new Current(1,0));
        HashMap<Integer,Boolean> check = new HashMap<>();
        check.put(1,true);
        int answer = 0;
        while(!queue.isEmpty()){
            boolean flag = false;
            Current c = queue.remove();
            int cur = c.cur;
            int cnt = c.cnt+1;
            for(int i = 0 ; i < 6 ; i ++){
                int newCur = cur + dice[i];
                if(check.containsKey(newCur)) continue;
                check.put(newCur,true);
                for(Move m : ladder){
                    if(m.from != newCur)continue;
                    newCur = m.to;
                }
                for(Move m : snake){
                    if(m.from != newCur)continue;
                    newCur = m.to;
                }
                check.put(newCur,true);
                if(newCur == 100) {
                    answer = cnt;
                    flag = true;
                }
                queue.add(new Current(newCur, cnt));
            }
            if(flag){
                break;
            }
        }
        System.out.println(answer);
    }
}
