package crytography.practice;

import java.util.HashMap;
import java.util.Map;

public class Otp {
    public static void main(String[] args) {
        Map<Character, Integer> upmap = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            upmap.put((char) (i + 65-1), i);
        }
        System.out.println(upmap);
        String msg = "XYZ";
        String otp = "XYZ";
        char[] msgarr = msg.toCharArray();
        char[] otparr = otp.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < otparr.length; i++) {
            int a = (upmap.get(otparr[i]) + upmap.get(msgarr[i]));
            a = a%26==0?26:a% 26;
            for (char c : upmap.keySet()) {
                if (upmap.get(c) == a) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
        msgarr = sb.toString().toCharArray();
        sb = new StringBuilder();
        for (int i = 0; i < otparr.length; i++) {
            int a = (upmap.get(msgarr[i])-upmap.get(otparr[i]));
            a = a==0?26:a<0?(a+26)%26:a%26;
            for (char c : upmap.keySet()) {
                if (upmap.get(c) == a) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);

    }
}
