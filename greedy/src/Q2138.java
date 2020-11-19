import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2138 {
    static int[] targets;
    static int n ;
    static int maxValue;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        n = Integer.parseInt(bf.readLine());

        int[] lights = new int[n];
        int[] lights1 = new int[n];
        targets = new int[n];
        String init = bf.readLine();
        String target = bf.readLine();
        for(int i = 0 ; i < n ; i ++){
            lights[i] = init.charAt(i)-'0';
            lights1[i] = lights[i];
            targets[i] = target.charAt(i) -'0';
        }
        maxValue = -1;
        onOff(1,lights,0);
        lights1[0] = change(lights1[0]);
        lights1[1] = change(lights1[1]);
        onOff(1,lights1,1);
        System.out.println(maxValue);
    }
    public static void onOff(int start,int[] lights,int cnt){
        if(start >= n){
            boolean same = true;
            for(int i = 0 ; i < n ; i ++){
                if(lights[i]==targets[i])continue;
                same = false;
            }
            if(same){
                if(maxValue == -1){
                    maxValue = cnt;
                }
                else{
                    maxValue = Math.min(maxValue,cnt);
                }
            }
            return;
        }
        if(lights[start-1]==targets[start-1]){
            onOff(start+1,lights,cnt);
        }
        else{
            lights[start-1] = change(lights[start-1]);
            lights[start] = change(lights[start]);
            if(start+1 <= n-1){
                lights[start+1] = change(lights[start+1]);
            }
            onOff(start+1,lights,cnt+1);
        }
    }
    public static int change(int light){
        return (light == 0) ? 1: 0;
    }
}
