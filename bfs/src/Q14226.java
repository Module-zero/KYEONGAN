import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q14226 {
    static class Count{
        int value;
        int cnt;
        int clipboard;
        public Count(int value,int cnt,int clipboard){
            this.value = value;
            this.cnt = cnt;
            this.clipboard = clipboard;
        }
    }

    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int current = 1;
        if(current == n){
            System.out.println(0);
            return;
        }

        LinkedList<Count> queue = new LinkedList<>();
        queue.add(new Count(1,0,0));
        int answer = Integer.MAX_VALUE ;
        boolean endFlag = false;
        int[][] dp = new int[1001][10001];
        while(!queue.isEmpty()){
            Count c = queue.remove();
            int val = c.value;
            int cnt = c.cnt;
            for(int i = 0 ; i < 3 ; i ++){
                int cur;
                int curCnt;
                int clipboard = c.clipboard;
                if(i == 0){
                    if(clipboard == 0)continue;
                    cur = val + clipboard;
                    curCnt = cnt + 1;
                }
                else if(i == 1){
                    cur = val - 1;
                    curCnt = cnt + 1;
                }
                else{
                    cur = val * 2;
                    curCnt = cnt + 2;
                    clipboard = val;
                }
                if(cur < 2 || cur > 1000) continue;
                if (cur == n) {
                    answer = Math.min(answer, curCnt);
                } else {
                    if(dp[cur][clipboard] == 0 || dp[cur][clipboard] > curCnt) {
                        dp[cur][clipboard] = curCnt;
                        queue.add(new Count(cur, curCnt, clipboard));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
