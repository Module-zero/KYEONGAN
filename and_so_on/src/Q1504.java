import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class Q1504 {
    static int N;
    static int E;
    static ArrayList<int[]>[] list;
    static long[][] pass;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        E = Integer.parseInt(str[1]);
        if(E == 0){
            System.out.println(-1);
            return;
        }
        list = new ArrayList[N+1];
        pass = new long[2][2];
        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < E ; i ++){
            String[] abc = bf.readLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        str = bf.readLine().split(" ");
        int pass1 = Integer.parseInt(str[0]);
        int pass2 = Integer.parseInt(str[1]);
        long ans = bfs(pass1, pass2, new long[N + 1]);
        if(ans == -1){
            System.out.println(-1);
            return ;
        }
        if( (pass1 == 1 && pass2 == N) || pass1 == N && pass2 == 1){
            System.out.println(ans);
            return ;
        }
        boolean[] check = new boolean[2];
        pass[0][0] = bfs(1,pass1,new long[N+1]);
        if(pass[0][0] != -1){
            pass[1][1] = bfs(pass2,N,new long[N+1]);
            if(pass[1][1] == -1){
                check[0] = true;
            }
        }
        else{
            check[0] = true;
        }
        pass[0][1] = bfs(pass1,N,new long[N+1]);
        if(pass[0][1] != -1){
            pass[1][0] = bfs(1,pass2,new long[N+1]);
            if(pass[1][0] == -1){
                check[1] = true;
            }
        }
        else{
            check[1] = true;
        }
        if(check[1] && check[0]){
            System.out.println(-1);
            return;
        }

        if(!check[0] && check[1]) {
            System.out.println(ans + pass[0][0] + pass[1][1]);
        }
        else if(!check[1] && check[0]) {
            System.out.println(ans + pass[1][0] + pass[0][1]);
        }
        else{
            long ans1 = ans + pass[0][0] + pass[1][1];
            long ans2 = ans + pass[1][0] + pass[0][1];
            System.out.println(Math.min(ans1,ans2));
        }
    }
    public static long bfs(int start, int end,long[] check){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});
        check[start] = 0;
        boolean arrive = false;
        while(!queue.isEmpty()){
            int[] target = queue.remove();
            int idx = target[0];
            int cnt = target[1];
            for(int[] i : list[idx]){
                int curIdx = i[0];
                int curCnt = i[1]+cnt;
                if(check[curIdx] != 0 && check[curIdx] <= curCnt)continue;
                check[curIdx] = curCnt;
                if(curIdx != end){
                    queue.add(new int[]{curIdx,curCnt});
                }
                else{
                    arrive = true;
                }
            }
        }
        if(arrive) {
            return check[end];
        }
        else{
            return -1;
        }
    }
}
