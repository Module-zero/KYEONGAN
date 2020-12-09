import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q10814 {
    static class Member{
        int age;
        String name;
        int mId;
        public Member(int age,String name,int mId){
            this.age = age;
            this.name = name;
            this.mId = mId;
        }
    }
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        Member[] list = new Member[n];
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            list[i] = new Member(Integer.parseInt(str[0]),str[1],i);
        }
        Arrays.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age > o2.age){
                    return 1;
                }
                else if( o1.age < o2.age){
                    return -1;
                }
                else {
                    if(o1.mId > o2.mId){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Member m : list){
            sb.append(m.age+" "+ m.name+"\n");
        }
        System.out.println(sb);
    }
}
