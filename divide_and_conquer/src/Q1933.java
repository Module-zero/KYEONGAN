import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1933 {
    static ArrayList<long[]> queue ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        queue = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            long l = Long.parseLong(str[0]);
            long height = Long.parseLong(str[1]);
            long r = Long.parseLong(str[2]);
            queue.add(new long[]{l,height});
            queue.add(new long[]{r,-height});
        }
        Collections.sort(queue, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] == o2[0])return (int)(o1[1] - o2[1]);
                return (int)(o1[0] - o2[0]);
            }
        });
        long maxHeight = 0;
        TreeMap<Long,Long> tmp = new TreeMap<>();
        TreeMap<Long,Long> answer = new TreeMap<>();
        for(long[] t : queue){
            // 시작점일경우
            if(t[1] > 0){
                tmp.put(t[1],tmp.getOrDefault(t[1],(long)0)+1);
                //갱신
                if(maxHeight < t[1]){
                    maxHeight = t[1];
                    answer.put(t[0],maxHeight);
                }
            }
            //끝점일경우
            else{
                // 최고높이
                long tmpH = t[1]*(-1);
                if(tmp.containsKey(tmpH)){
                    tmp.put(tmpH, tmp.get(tmpH) - 1);
                    if(tmp.get(tmpH) == 0){
                        tmp.remove(tmpH);
                    }
                    if(maxHeight == tmpH){
                        if(!tmp.isEmpty()) {
                            long tmpKey = tmp.lastKey();
                            maxHeight = tmpKey;
                        }
                        else{
                            maxHeight = 0;
                        }
                        if(maxHeight < tmpH) {
                            answer.put(t[0], maxHeight);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Set<Long> it = answer.keySet();
        for(Long k : it){
            long key = k;
            long value = answer.get(key);
            sb.append(key).append(" ").append(value).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);

    }
}
