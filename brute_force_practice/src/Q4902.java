import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q4902 {
    static int answer;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        while(true){
            answer = 0;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int line = Integer.parseInt(st.nextToken());
            if(line == 0)break;
            ArrayList<Integer>[] triangle = new ArrayList[line+1];
            for(int i = 0 ; i < line ; i ++){
                triangle[i] = new ArrayList<>();
            }
            int curLine = 1;
            int cnt = 0;
            while(curLine < line){
                triangle[curLine].add(Integer.parseInt(st.nextToken()));
                cnt ++ ;
                if((2 * curLine) - 1 <= cnt){
                    curLine++;
                    cnt = 0;
                }
            }
            for(int i = 0 ; i < line ; i ++){
                for(int j = 0 ; j < triangle[i].size();j++){
                    if(j % 2 != 0 )continue;
                    search(triangle,i,j);
                }
            }
        }
    }
    public static void search(ArrayList<Integer>[] triangle,int startI,int startJ){
        int tmpAns = 0 ;
        int step = 1;
        while(true){
            ArrayList<Integer> target = triangle[startI];
            
        }
    }
}
