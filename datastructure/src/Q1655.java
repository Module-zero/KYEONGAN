import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1655 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i ++){
            int num = Integer.parseInt(bf.readLine());
            if(max.size() == min.size()){
                max.add(num);
            }
            else{
                min.add(num);
            }
            if(!min.isEmpty() && !max.isEmpty() && min.peek() < max.peek()){
                int maxTop = max.poll();
                int minTop = min.poll();
                min.add(maxTop);
                max.add(minTop);
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
