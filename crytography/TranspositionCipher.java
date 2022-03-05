import java.util.Formatter;
import java.util.Scanner;

public class TranspositionCipher {
    public static void main(String[] args) {
        try {
            String plainText = "DEPARTMENT OF COMPUTER SCIENCE AND TECHNOLY UNIVERSITY OF RAJSHAHI BANGLADESH";
            Formatter formatter = new Formatter("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/transpositioncipher.txt");
            Scanner input = new Scanner(System.in);
            int width;
            System.out.print("Enter the width : ");
            width = input.nextInt();
            // Character matrix[width][width];
            int k = 0;
            int strlen = plainText.length();
            System.out.println(strlen);
            char[][] matrix = new char[100][100];
            boolean flag = false;
            int i=0;
            for (;; i++) {
                for (int j = 0; j < width; j++) {

                    if (k < strlen) {
                        matrix[i][j] = plainText.charAt(k);
                        k++;
                    }else{
                        matrix[i][j] = '#';
                        flag = true;
                    }
                }
                if(flag){
                    break;
                }
            }
            StringBuilder cipherText = new StringBuilder();
            for (int j = 0; j < width; j++) {
                for (int j2 = 0; j2 <= i; j2++) {
                    cipherText.append(matrix[j2][j]);
                }
            }
            formatter.format("CipherText = %s\r\n", cipherText);
            System.out.println(cipherText);
            StringBuilder originalText = new StringBuilder();
            k=0;
            for (int j = 0; j <= i; j++) {
                for (int j2 = 0; j2 < width; j2++) {
                    if(k<strlen){
                        originalText.append(matrix[j][j2]);
                        k++;
                    }
                }
            }
            formatter.format("OriginalText = %s\r\n", originalText);
            System.out.println(originalText);
            formatter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
