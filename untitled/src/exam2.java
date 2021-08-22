import java.lang.reflect.Array;
import java.security.KeyPair;
import java.util.*;

public class exam2 {
    public static String[] solution(String[] code) {
//        String[] answer = {};
        List<String> answer = new ArrayList<>();
        int ii=0;
        Map<String, LinkedHashMap<String,String>> paramMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        String tempChar="";
        for (String cur : code) {
            int num = countChar(cur, '.');
            String curT = cur.replace(".", "");
            String[] split = curT.split("=");

            ///

            LinkedHashMap<String, String> stringStringLinkedHashMap = paramMap.get(split[0]);
            if(stringStringLinkedHashMap!=null) {
                for (String s : stringStringLinkedHashMap.keySet()) {
                    int i = Integer.parseInt(s);
                    if (i > num) {
                        tempChar = split[0];
                        list.add(s);
                        continue;
                    }
                }
            }

            String[] spp = curT.split(" ");
            if(spp.length==2) {
                stringStringLinkedHashMap = paramMap.get(spp[1]);
                if (stringStringLinkedHashMap != null) {
                    for (String s : stringStringLinkedHashMap.keySet()) {
                        int i = Integer.parseInt(s);
                        if (i > num) {
                            tempChar = spp[1];
                            list.add(s);
                            continue;
                        }
                    }
                }
            }
            ///
            LinkedHashMap<String, String> stringStringLinkedHashMap1 = paramMap.get(tempChar);
            if(stringStringLinkedHashMap1!=null) {
                for (String s : list) {
                    stringStringLinkedHashMap1.remove(s);
                }
                list.clear();
                tempChar = "";
            }
            ////

            if (split.length == 1) {

                String[] sp = curT.split(" ");
                int res = -1;
                if (paramMap.containsKey(sp[1])) {
                    stringStringLinkedHashMap = paramMap.get(sp[1]);
                    for (String s : stringStringLinkedHashMap.keySet()) {
                        int i = Integer.parseInt(s);
                        if (i > num) {
//                            stringStringLinkedHashMap.remove(s);
                            tempChar = sp[1];
                            list.add(s);
                            continue;
                        }
                        res = Integer.parseInt(stringStringLinkedHashMap.get(s));
                    }
                    if (res != -1) {
                        System.out.println(sp[1] +  " = " + res);
                        answer.add(sp[1] + " = " + res);
                    }else{
                        answer.add("error");
                        System.out.println("error");
                    }
                    continue;
                }else{
                    answer.add("error");
                    System.out.println("error");
                    continue;
                }
            }

            if (paramMap.containsKey(split[0])) {
                stringStringLinkedHashMap = paramMap.get(split[0]);
                for (String s : stringStringLinkedHashMap.keySet()) {
                    int i = Integer.parseInt(s);
                    if (i > num) {
//                        stringStringLinkedHashMap.remove(s);
                        tempChar = split[0];
                        list.add(s);
                        continue;
                    }
                }

                LinkedHashMap<String,String> h = paramMap.get(split[0]);
                h.put(Integer.toString(num), split[1]);

            }else{
                LinkedHashMap<String, String> h = new LinkedHashMap<>();
                h.put(Integer.toString(num), split[1]);
                paramMap.put(split[0], h);
            }
        }
        return answer.toArray(new String[0]);
    }

    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }


    public static void main(String[] args) {
        String[] a = {"a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a"};
        String[]res = solution(a);
    }
}
