package crytography.practice;

import java.io.File;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        try{

            File file = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/practice/caesar.txt");
        Scanner input = new Scanner(file);
        String s="";
        while(input.hasNextLine()){
            s = input.nextLine();
        }
        char[] carr = s.toCharArray();
        Map<Character,Integer> upmap = new HashMap<>();
        Map<Character,Integer> lowmap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            lowmap.put((char)(i+97), i);
        }
        for (int i = 0; i < 26; i++) {
            upmap.put((char)(i+65), i);
        }
        // System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carr.length; i++) {
            if(upmap.get(carr[i])!=null){
                int a = (upmap.get(carr[i])+3)%26;
                for (char c : upmap.keySet()) {
                    if(upmap.get(c)==a){
                        sb.append(c);
                        break;
                    }
                }
            }else if(lowmap.get(carr[i])!=null){
                int a = (lowmap.get(carr[i])+3)%26;
                for (char c : lowmap.keySet()) {
                    if(lowmap.get(c)==a){
                        sb.append(c);
                        break;
                    }
                }
            }
            else{
                sb.append(carr[i]);
            }
        }
        System.out.println(sb);
        carr = sb.toString().toCharArray();
        sb = new StringBuilder();
        for (int i = 0; i < carr.length; i++) {
            if(upmap.get(carr[i])!=null){
                int a = (upmap.get(carr[i])-3)%26;
                for (char c : upmap.keySet()) {
                    if(upmap.get(c)==a){
                        sb.append(c);
                        break;
                    }
                }
            }else if(lowmap.get(carr[i])!=null){
                int a = (lowmap.get(carr[i])-3)%26;
                for (char c : lowmap.keySet()) {
                    if(lowmap.get(c)==a){
                        sb.append(c);
                        break;
                    }
                }
            }
            else{
                sb.append(carr[i]);
            }
        }

        System.out.println(sb);
        Formatter formatter = new Formatter();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
