import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Q13913 {
    static class Pos{
        int pos ;
        int cnt ;
        public Pos(int pos,int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    static int[] move = {2,-1,1};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);
        if(n == k){
            System.out.println(0);
            System.out.println(n);
            return;
        }
        LinkedList<Pos> queue = new LinkedList<>();
        boolean[] check = new boolean[100001];
        queue.add(new Pos(n,0));
        int answerCnt = 0 ;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[100001];
        dp[n] = n;
        check[n] = true;
        boolean endFlag = false;
        while(!queue.isEmpty()){
            Pos p = queue.remove();
            int start = p.pos;
            int cnt = p.cnt+1;
            for(int i = 0 ; i < 3; i ++){
                int cur;
                if(i == 0){
                    cur = start * move[i];
                }
                else{
                    cur = start + move[i];
                }
                if(0 <= cur && cur <= 100000){
                    if(!check[cur]){
                        check[cur] = true;
                        dp[cur] = start;
                        if(cur == k){
                            answerCnt = cnt;
                            while(true){
                                stack.push(cur);
                                cur = dp[cur];
                                if(cur == n){
                                    stack.push(cur);
                                    break;
                                }
                            }
                            endFlag = true;
                        }
                        else{
                            queue.add(new Pos(cur,cnt));
                        }
                    }
                }
            }
            if(endFlag){
                break;
            }
        }
        System.out.println(answerCnt);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
