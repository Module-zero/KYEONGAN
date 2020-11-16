import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q1931 {
    static class Time{
        int start;
        int end;
        public Time(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    static Time[] time;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        time = new Time[n];
        for(int i = 0; i < n ; i ++){
            String[] strArr = bf.readLine().split(" ");
            time[i] = new Time(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]));
        }
        Arrays.sort(time, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.end - o2.end != 0){
                    return o1.end - o2.end;
                }
                else{
                    return o1.start - o2.start;
                }
            }
        });
        int cnt = 0;
        int end = -1;
        for(int i = 0 ; i < n ; i ++){
            if(end > time[i].start)continue;
            end = time[i].end;
            cnt++;
        }
        System.out.println(cnt);
    }
}
