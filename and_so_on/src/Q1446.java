import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1446 {
    static class Node{
        int cur, next, distance;
        public Node(int cur, int next, int distance){
            this.cur = cur;
            this.next = next ;
            this.distance = distance;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int D = Integer.parseInt(init[1]);
        ArrayList<Node> node = new ArrayList<>();
        int n = 0;
        for(int i = 0 ; i < N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int cur = Integer.parseInt(tmp[0]);
            int next = Integer.parseInt(tmp[1]);
            int distance = Integer.parseInt(tmp[2]);
            if(next - cur < distance)continue;
            if(next > D)continue;
            node.add(new Node(cur,next,distance));
            n++;
        }
        Collections.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.cur == o2.cur){
                    return o1.next - o2.next;
                }
                else{
                    return o1.cur - o2.cur;
                }

            }
        });
        N = n;
        solve(N, D,node);
    }

    public static void solve(int N, int D, ArrayList<Node> node){
        int[] dp = new int[D + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int nowD = 0;
        int nowIdx = 0;
        while(nowD < D){
            while (nowIdx < N) {
                if(node.get(nowIdx).cur != nowD)
                    break;
                int tmp = dp[nowD] + node.get(nowIdx).distance;
                if(tmp < dp[node.get(nowIdx).next]){
                    dp[node.get(nowIdx).next] = tmp;
                }
                nowIdx ++;
            }
            if( dp[nowD] + 1 < dp[nowD+1]){
                dp[nowD+1] = dp[nowD]+1;
            }
            nowD ++;
        }
        System.out.println(dp[D]);
    }
}
