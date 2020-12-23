import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1933 {
    static ArrayList<int[]> queue ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        queue = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int height = Integer.parseInt(str[1]);
            int r = Integer.parseInt(str[2]);
            queue.add(new int[]{l,height});
            queue.add(new int[]{r,-height});
        }
        Collections.sort(queue, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int maxHeight = 0;
        TreeSet<Integer> tmp = new TreeSet<>();
        TreeMap<Integer,Integer> answer = new TreeMap<>();
        for(int[] t : queue){
            // 시작점일경우
            if(t[1] > 0){
                //갱신
                tmp.add(t[1]);
                if(maxHeight < t[1]){
                    maxHeight = t[1];
                    answer.put(t[0],maxHeight);
                }
            }
            //끝점일경우
            else{
                // 최고높이
                if(tmp.contains(-t[1])){
                    tmp.remove(-t[1]);
                    if(maxHeight == -t[1]){
                        if(!tmp.isEmpty()) {
                            maxHeight = tmp.last();
                        }
                        else{
                            maxHeight = 0;
                        }
                        answer.put(t[0],maxHeight);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = answer.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            int value = answer.get(key);
            sb.append(key+" "+value+" ");
        }
        System.out.println(sb.toString());

    }
}
