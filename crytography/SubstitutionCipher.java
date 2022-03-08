package crytography;

import java.io.File;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * SubstitutionCipher
 */
public class SubstitutionCipher {

    public static void main(String[] args) {
        try{
            Map<String,String> map = new HashMap<>();
            File file = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/substitutioncipherdictionary.txt");
            Formatter formatter = new Formatter("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/substitutioncipher.txt");
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                String[] s = input.nextLine().split(" ");
                map.put(s[0], s[1]);
            }
            String plainText = "abcdefghi123";
            StringBuilder cipherText = new StringBuilder();
            for (int i = 0; i < plainText.length(); i+=3) {
                if(map.containsKey(plainText.substring(i, i+3))){
                    cipherText.append(map.get(plainText.substring(i, i+3)));
                }else{
                    cipherText.append(plainText.substring(i, i+3));
                }
            }
            System.out.println(cipherText);
            formatter.format("CipherText = %s\r\n", cipherText);
            boolean flag = true;
            StringBuilder originalText = new StringBuilder();
            for (int i = 0; i < cipherText.length(); i+=3) {
                for (String key : map.keySet()) {
                    if(map.get(key).equals(cipherText.substring(i, i+3))){
                        originalText.append(key);
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    originalText.append(cipherText.substring(i, i+3));
                }
                flag = true;
            }
            formatter.format("OriginalText = %s\r\n", originalText);
            System.out.println(originalText);
            formatter.close();

        }catch(Exception e){

        }

    }
}