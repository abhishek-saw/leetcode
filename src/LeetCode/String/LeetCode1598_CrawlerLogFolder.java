package String;


public class LeetCode1598_CrawlerLogFolder {
    public static void main(String[] args) {
        String[] logs1 = {"d1/","d2/","../","d21/","./"};
        String[] logs2 = {"d1/","d2/","./","d3/","../","d31/"};
        String[] logs3 = {"d1/","../","../","../"};
        String[] logs4 = {"1/"};
        String[] logs5 = {"./","wz4/","../","mj2/","../","../","ik0/","il7/"};
        System.out.println(minOperations(logs1));
        System.out.println(minOperations(logs2));
        System.out.println(minOperations(logs3));
        System.out.println(minOperations(logs4));
        System.out.println(minOperations(logs5));
    }

    private static int minOperations(String[] logs) {
        int count = 0;
        for (String s : logs){
            if(s.endsWith("../") && count>0){
                count-=1;
            }
            else if(s.endsWith("./")){
                count+=0;
            }
            else if(s.charAt(s.length() - 1) == '/'){
                count+=1;
            }
        }
        return Math.max(count,0);
    }
}
