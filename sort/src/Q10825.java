import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q10825 {
    static class Inform{
        String name;
        int kor;
        int eng;
        int math;
        public Inform(String name, int kor,int eng,int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        Inform[] informs = new Inform[n];
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            informs[i] = new Inform(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]),Integer.parseInt(str[3]));
        }
        Arrays.sort(informs, new Comparator<Inform>() {
            @Override
            public int compare(Inform o1, Inform o2) {
                if(o1.kor > o2.kor){
                    return -1;
                }
                else if(o1.kor < o2.kor){
                    return 1;
                }
                else{
                    if(o1.eng > o2.eng){
                        return 1;
                    }
                    else if(o1.eng < o2.eng){
                        return -1;
                    }
                    else{
                        if(o1.math > o2.math){
                            return -1;
                        }
                        else if(o1.math < o2.math){
                            return 1;
                        }
                        else{
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Inform i : informs){
            sb.append(i.name).append("\n");
        }
        System.out.println(sb);
    }
}
