import java.util.HashMap;
import java.util.Map;

public class exam1 {
    public static int solution(int[][] passwords, String s) {
        Map<String,String> paMap = new HashMap<String,String>();
        String[] sParsing = s.split("#");
        int answer=0;
        for (int[] password : passwords) {
            paMap.put(Integer.toString(password[0]), Integer.toString(password[1]));
        }

        for (int i = 0; i < sParsing.length-1; i++) {
            if(paMap.containsKey(sParsing[i])){
                if(paMap.get(sParsing[i]).equals(sParsing[i + 1])){
                    answer++;
                    i++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] aa = {{101, 1234}, {102, 54321}, {201, 202}, {202, 1}};
        int a = solution(aa, "101#1234#102#654321#51#203#201#202#1#");
        System.out.println(a);
    }
}
