import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q11725 {
    static ArrayList<Integer>[] parents = new ArrayList[100001];
    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        for(int i = 1 ; i <= t ; i ++){
            parents[i] = new ArrayList<>();
        }
        for(int i  = 1 ; i < t; i ++){
            String[] strArr = bf.readLine().split(" ");
            int num1 = Integer.parseInt(strArr[0]);
            int num2 = Integer.parseInt(strArr[1]);
            if(num1 == 1 || num2 == 1){
                if(num1 == 1){
                    parents[num1].add(num2);
                }
                else{
                    parents[num2].add(num1);
                }
            }
            else{
                parents[num2].add(num1);
                parents[num1].add(num2);
            }
        }
        int[] queue = new int[100001];
        int[] parent = new int[100001];
        boolean[] check = new boolean[100001];
        int rear = 0;
        int front = 0;
        queue[rear++] = 1;
        while(rear > front){
            int num = queue[front++];
            if(!check[num]) {
                check[num] = true;
                while (!parents[num].isEmpty()) {
                    int tmp = parents[num].remove(0);
                    if(parent[tmp] ==0) {
                        parent[tmp] = num;
                        queue[rear++] = tmp;
                    }
                }
            }
        }
        for(int i = 2 ; i <= t ; i ++){
            System.out.println(parent[i]);
        }
    }

}
