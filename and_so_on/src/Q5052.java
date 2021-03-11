import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q5052 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < T ; t ++){
            int line = Integer.parseInt(bf.readLine());
            String[] phone_number = new String[line];
            for(int i = 0 ; i < line; i ++){
                phone_number[i] = bf.readLine();
            }
            boolean res = solution(phone_number);
            if(res){
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean solution(String[] phone_number){
        boolean res = true;
        Trie root = new Trie();
        for(int i = 0 ; i < phone_number.length; i ++){
            if(!root.insert(phone_number[i])){
                res = false;
                break;
            }
        }
        return res;
    }
    static class Trie{
        public TrieNode root;
        public Trie(){
            this.root = new TrieNode();
        }
        public boolean insert(String word){
            boolean isInsert = true;
            Map<Character, TrieNode> children = root.children;

            for(int i = 0 ; i < word.length(); i++){
                char w = word.charAt(i);

                TrieNode node;
                boolean same = false;

                if(children.containsKey(w)){
                    node = children.get(w);
                    if(node.isLast){
                        isInsert = false;
                        break;
                    }
                    same = true;
                }
                else{
                    node = new TrieNode();
                }

                if(i == word.length()-1){
                    if(same){
                        isInsert = false;
                        break;
                    }
                    node.isLast = true;
                }
                children.put(w,node);
                children = node.children;
            }
            return isInsert;
        }
    }


    static class TrieNode{
        public Map<Character,TrieNode> children;
        public boolean isLast ;
        public TrieNode(){
            this.children = new HashMap<>();
            this.isLast = false;
        }
    }
}
