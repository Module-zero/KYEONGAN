import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1967 {
    static ArrayList<Node>[] tree ;
    static int maxDistance = 0;
    static int maxIdx ;
    static class Node{
        int edge;
        int distance;
        public Node(int edge, int distance){
            this.edge = edge;
            this.distance = distance;
        }
    }
    public static void main(String[] args)throws Exception{
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
         BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

         int t = Integer.parseInt(bf.readLine());
         tree = new ArrayList[t+1];
         for(int i = 0 ; i <= t; i ++){
             tree[i] = new ArrayList<>();
         }
         for(int i = 1 ; i < t; i ++){
             String[] strArr = bf.readLine().split(" ");
             tree[Integer.parseInt(strArr[0])].add(new Node(Integer.parseInt(strArr[1]),Integer.parseInt(strArr[2])));
             tree[Integer.parseInt(strArr[1])].add(new Node(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[2])));
         }
         dfs(1,new boolean[t+1],0);
         dfs(maxIdx,new boolean[t+1],0);
        System.out.println(maxDistance);
    }
    public static void dfs(int start,boolean[] check,int sum ){
        check[start] = true;
        for(Node node : tree[start]){
            if(!check[node.edge]){
                sum += node.distance;
                dfs(node.edge,check,sum);
                sum -= node.distance;
            }
        }
        if(maxDistance < sum){
            maxDistance = sum;
            maxIdx = start;
        }
    }
}
