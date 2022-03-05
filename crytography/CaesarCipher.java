

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {

    static Map<Character, Integer> map = new HashMap<>();

    private static String cipher(String plainText) {
        StringBuilder sb = new StringBuilder();
        for (Character character : plainText.toCharArray()) {
            if (map.containsKey(character)) {
                int newChar = (map.get(character) + 3) % 52;
                for (Character key : map.keySet()) {
                    if (map.get(key) == newChar) {
                        sb.append(key);
                        break;
                    }
                }
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    private static String decipher(String cipherText) {
        StringBuilder sb = new StringBuilder();
        for (Character character : cipherText.toCharArray()) {
            if (map.containsKey(character)) {
                int newChar = (map.get(character) - 3) % 52;
                for (Character key : map.keySet()) {
                    if (map.get(key) == newChar) {
                        sb.append(key);
                        break;
                    }
                }
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        try {
            Formatter formatter = new Formatter(
                    "/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/caesarcipher.txt");

            for (int i = 0; i < 26; i++) {
                map.put((char) (i + 65), i);
            }
            for (int i = 0; i < 26; i++) {
                map.put((char) (i + 97), i + 26);
            }
            // System.out.println(map);
            String plainText = "abCd123*&^";
            String cipherText = cipher(plainText);
            formatter.format("CipherText = %s\r\n", cipherText);
            System.out.println(cipherText);
            String originalText = decipher(cipherText);
            formatter.format("OriginalText = %s\r\n", originalText);
            System.out.println(originalText);
            formatter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
