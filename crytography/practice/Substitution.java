package crytography.practice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Substitution {
    public static void main(String[] args) {
        try {
            Map<String, String> map = new HashMap<>();
            Map<String, String> remap = new HashMap<>();
            File file = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/practice/sub.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String[] s = input.nextLine().split(" ");
                map.put(s[0], s[1]);
                remap.put(s[1], s[0]);
            }
            String msg = "abcdefxt";
            char[] carr = msg.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < carr.length; i += 3) {
                StringBuilder sb1 = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    if (j + i < carr.length) {
                        sb1.append(carr[i + j]);
                    }
                }
                if (map.get(sb1.toString()) != null) {
                    sb.append(map.get(sb1.toString()));
                } else {
                    sb.append(sb1);
                }
            }
            System.out.println(sb);
             carr = sb.toString().toCharArray();
            sb = new StringBuilder();
            for (int i = 0; i < carr.length; i += 3) {
                StringBuilder sb1 = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    if (j + i < carr.length) {
                        sb1.append(carr[i + j]);
                    }
                }
                if (remap.get(sb1.toString()) != null) {
                    sb.append(remap.get(sb1.toString()));
                } else {
                    sb.append(sb1);
                }
            }
            System.out.println(sb);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
