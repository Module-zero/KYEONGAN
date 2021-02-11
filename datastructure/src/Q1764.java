import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[0]);

        Set<String>hear = new HashSet<>();
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            hear.add(str);
        }
        ArrayList<String> hearSee = new ArrayList<>();
        for(int i = 0 ; i < m ; i ++){
            String str = bf.readLine();
            if(hear.contains(str)){
                hearSee.add(str);
            }
        }
        Collections.sort(hearSee, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str : hearSee){
            sb.append(str).append("\n");
        }
        System.out.println(hearSee.size());
        System.out.println(sb);
    }
}
