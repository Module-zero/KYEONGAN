/*
스타트링크
s와 g가 같아질 동안 bfs를 진행한다.
+u / -d 를 통해 bfs를 하면된다.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if(s == g){
            System.out.println(0);
            return;
        }
        int[] move = {u,-d};
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s,0});
        boolean[] check = new boolean[f+1];
        check[s] = true;
        boolean arrive = false;
        while(!queue.isEmpty()){
            int[] idx = queue.poll();
            int start = idx[0];
            for(int i = 0 ; i < 2 ; i ++){
                int cur = start+move[i];
                int cnt = idx[1];
                if(cur < 1 || cur > f)continue;
                if(check[cur])continue;
                check[cur] = true;
                if(cur == g){
                    arrive = true;
                    answer = cnt+1;
                    continue;
                }
                queue.add(new int[]{cur,cnt+1});
            }
        }
        if(arrive){
            System.out.println(answer);
        }
        else{
            System.out.println("use the stairs");
        }
    }
}
