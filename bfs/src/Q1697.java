import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1697 {
    static int[] move = {2,-1,1};
    static class Current{
        int pos;
        int cnt;
        public Current(int pos, int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
    }
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
        LinkedList<Current> queue = new LinkedList<>();
        queue.add(new Current(n,0));
        int answer = 0 ;
        boolean[] check = new boolean[100001];
        while(!queue.isEmpty()){
            boolean endFlag = false;
            Current c = queue.remove();
            int start = c.pos;
            int cnt = c.cnt;
            int num ;
            for(int i = 0 ; i < 3; i ++){
                if(i == 0){
                    num = start * move[i];
                }
                else{
                    num = start + move[i];
                }
                if(0 <= num && num <= 100000) {
                    if (!check[num]) {
                        check[num] = true;
                        if (num == k) {
                            endFlag = true;
                            answer = cnt+1;
                            break;
                        } else {
                            queue.add(new Current(num,cnt+1));
                        }
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
