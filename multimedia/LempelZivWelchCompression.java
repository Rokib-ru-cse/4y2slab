package multimedia;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LempelZivWelchCompression {

    public static List<Integer> encode(String text) {
        int dictSize = 256;
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            dictionary.put(String.valueOf((char) i), i);
        }

        String foundChars = "";
        List<Integer> result = new ArrayList<>();
        for (char character : text.toCharArray()) {
            String charsToAdd = foundChars + character;
            if (dictionary.containsKey(charsToAdd)) {
                foundChars = charsToAdd;
            } else {
                result.add(dictionary.get(foundChars));
                dictionary.put(charsToAdd, dictSize++);
                foundChars = String.valueOf(character);
            }
        }
        if (!foundChars.isEmpty()) {
            result.add(dictionary.get(foundChars));
        }
        return result;
    }

    public static String decode(List<Integer> encodedText) {
        int dictSize = 256;
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            dictionary.put(i, String.valueOf((char) i));
        }

        String characters = String.valueOf((char) encodedText.remove(0).intValue());
        StringBuilder result = new StringBuilder(characters);
        for (int code : encodedText) {
            String entry = dictionary.containsKey(code)
                    ? dictionary.get(code)
                    : characters + characters.charAt(0);
            result.append(entry);
            dictionary.put(dictSize++, characters + entry.charAt(0));
            characters = entry;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try {
            File file1 = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/lzw.txt");
            Formatter formatter = new Formatter("/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/lzwencode.txt");
            Scanner input = new Scanner(file1);
            String s1;
            while (input.hasNextLine()) {
                s1 = input.nextLine();
                StringBuilder sb = new StringBuilder("");
                List<Integer> en = encode(s1);
                for (Integer i : en) {
                    sb.append(i.toString()+" ");
                }
                formatter.format("%s\r\n", sb);
            }
            input.close();
            formatter.close();
            File file2 = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/lzwencode.txt");
            Formatter formatter1 = new Formatter(
                    "/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/lzwdecode.txt");
            Scanner input1 = new Scanner(file2);
            String s2;
            while (input1.hasNextLine()) {
                s2 = input1.nextLine();
                List<Integer> en = new ArrayList<>();
                String[] strings = s2.split(" ");
                for (String s : strings) {
                    en.add(Integer.parseInt(s));
                }
                String result = decode(en);
                formatter1.format("%s\r\n",result);
            }
            input1.close();
            formatter1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
