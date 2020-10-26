import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q11724 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int vertex = Integer.parseInt(strArr[0]);
        int edge = Integer.parseInt(strArr[1]);
        ArrayList<Integer>[] list = new ArrayList[vertex+1];
        for(int i = 0 ; i <= vertex ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < edge ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int u = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            list[u].add(v);
            list[v].add(u);
        }
        boolean[] check = new boolean[vertex+1];
        int[] queue = new int[vertex+1];
        int front = 0;
        int rear = 0;
        int answer = 0;
        for(int start = 1; start <= vertex; start++) {
            if(check[start]){
                continue;
            }
            answer ++;
            queue[rear++] = start;
            check[start] = true;
            while (front < rear) {
                int bfs = queue[front++];
                for (int i = 0; i < list[bfs].size(); i++) {
                    int num = list[bfs].get(i);
                    if (!check[num]) {
                        check[num] = true;
                        queue[rear++] = num;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
