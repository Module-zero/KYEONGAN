import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1167 {
    public static class Vertex{
        public int ver;
        public int dis;
        public Vertex(int ver, int dis){
            this.ver = ver;
            this.dis = dis;
        }
    }
    static int maxNum = 0;
    static int maxVertex;
    static ArrayList<Vertex>[] tree = new ArrayList[100001];
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int t = Integer.parseInt(bf.readLine());

        for(int i = 1 ; i <= t; i ++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < t; i ++){
            String[] strArr = bf.readLine().split(" ");
            int target = Integer.parseInt(strArr[0]);
            int k = -1;
            while( (k+=2) < strArr.length){
                int vertex = Integer.parseInt(strArr[k]);
                if(vertex == -1){
                    break;
                }
                int distance = Integer.parseInt(strArr[k+1]);
                tree[target].add(new Vertex(vertex,distance));
            }
        }
        Stack<Vertex> stack = new Stack<>();
        stack.push(new Vertex(1,0));

        dfs(new boolean[100001],0,1);
        dfs(new boolean[100001],0,maxVertex);
        System.out.println(maxNum);
    }
    public static void dfs(boolean[] check, int sum, int start){
        if(maxNum < sum){
            maxNum = sum;
            maxVertex = start;
        }
        check[start] = true;
        for(Vertex v : tree[start]){
            if(!check[v.ver]) {
                dfs(check,sum+v.dis,v.ver);
            }
        }
    }
}
