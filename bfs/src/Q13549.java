import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q13549 {
    static class Pos{
        int pos ;
        int cnt;
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
            return;
        }
        LinkedList<Pos> queue = new LinkedList<>();
        queue.add(new Pos(n,0));
        boolean[] check = new boolean[100001];
        boolean endFlag = false;
        int answer = 0;
        while(!queue.isEmpty()){
            Pos p = queue.remove();
            int pos = p.pos;
            int cnt = p.cnt;

            for(int i = 0 ; i < 3; i ++){
                int cur;
                int curCnt;
                if(i == 0){
                    cur = pos * move[i];
                    curCnt = cnt;
                }
                else{
                    cur = pos + move[i];
                    curCnt = cnt + 1;
                }
                if(cur < 0 || cur > 100000) continue;
                if(!check[cur]) {
                    check[cur] = true;
                    if (cur == k) {
                        answer = curCnt;
                        endFlag = true;
                    } else {
                        queue.add(new Pos(cur, curCnt));
                    }
                }
            }
            if(endFlag){
                break;
            }
        }
        System.out.println(answer);
    }
}
