import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1927 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i ++){
            int tmp = Integer.parseInt(bf.readLine());
            if(tmp == 0){
                if(heap.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(heap.poll()).append("\n");
                }
            }
            else{
                heap.add(tmp);
            }
        }
        System.out.println(sb);
    }
}
