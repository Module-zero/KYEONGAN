import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1202 {
    static class Jewelry implements Comparable<Jewelry>{
        int m;
        int v;
        public Jewelry(int m,int v){
            this.m = m;
            this.v = v;
        }
        public int compareTo(Jewelry j){
            if (this.v > j.v) {
                return -1;
            }
            else if(this.v == j.v){
                return 0;
            }
            else{
                return 1;
            }
        }

    }
    public static void main(String[] args)throws Exception {
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        Jewelry[] jewelry = new Jewelry[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            jewelry[i] = new Jewelry(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        Arrays.sort(jewelry);
        TreeMap<Integer,Integer> bags = new TreeMap<>();
        for(int i = 0 ; i < k ; i++){
            int c = Integer.parseInt(bf.readLine());
            Integer num = bags.get(c);
            if(num == null){
                num = 0;
            }
            num++;
            bags.put(c,num);
        }
        long answer = 0;
        for(int i = 0 ; i < n ; i ++){
            Map.Entry<Integer,Integer> it = bags.ceilingEntry(jewelry[i].m);
            if(it != null){
                answer += jewelry[i].v;
                int c = (int)it.getKey();
                Integer val = it.getValue()-1;
                if(val == 0){
                    bags.remove(c);
                }
                else{
                    bags.put(c,val);
                }
            }
        }
        System.out.println(answer);
    }
}
