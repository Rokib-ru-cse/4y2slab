package crytography;

import java.io.File;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OneTimePadEncryption {
    public static void main(String[] args) {
        try {
            File file = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/onetimepadsrc.txt");
            Formatter formatter = new Formatter(
                    "/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/onetimepad.txt");
            Scanner input = new Scanner(file);
            StringBuilder otp = new StringBuilder();
            while (input.hasNextLine()) {
                otp.append(input.nextLine());
            }
            Map<Integer, Character> map = new HashMap<>();
            Map<Character, Integer> remap = new HashMap<>();
            for (int i = 1; i <= 26; i++) {
                map.put(i, (char) (i - 1 + 65));
                remap.put((char) (i - 1 + 65), i);
            }
            String plainText = "ONETIMEPAD";
            StringBuilder cipherText = new StringBuilder();
            char c;
            for (int i = 0; i < plainText.length(); i++) {
                c = map.get((remap.get(plainText.charAt(i)) + remap.get(otp.charAt(i))) % 26);
                cipherText.append(c);
            }
            formatter.format("CipherText = %s\r\n", cipherText);
            System.out.println(cipherText);
            StringBuilder originalText = new StringBuilder();
            int x;
            for (int i = 0; i < cipherText.length(); i++) {

                x = (remap.get(cipherText.charAt(i)) - remap.get(otp.charAt(i)));
                x = x < 0 ? x + 26 : x;
                c = map.get(x);
                originalText.append(c);

            }
            System.out.println(originalText);
            formatter.format("OriginalText = %s\r\n", originalText);
            formatter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
