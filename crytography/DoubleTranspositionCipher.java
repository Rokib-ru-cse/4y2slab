import java.util.Formatter;
import java.util.Scanner;

public class DoubleTranspositionCipher {
    public static void main(String[] args) {
        try {
            String plainText = "DEPARTMENTOFCOMPUTERSCIENCEANDENGINEERING";
            Formatter formatter = new Formatter(
                    "/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/doubletranspositioncipher.txt");
            Scanner input = new Scanner(System.in);
            int width;
            System.out.print("Enter the width : ");
            width = input.nextInt();
            int strlen = plainText.length();
            char[][] matrix = new char[100][100];
            int k = 0;
            boolean flag = false;
            int i = 0;
            for (;; i++) {
                for (int j = 0; j < width; j++) {

                    if (k < strlen) {
                        matrix[i][j] = plainText.charAt(k);
                        k++;
                    } else {
                        matrix[i][j] = '#';
                        flag = true;
                    }
                }
                if (flag) {
                    break;
                }
            }
            StringBuilder cipherText = new StringBuilder();
            for (int j = 0; j < width; j++) {
                for (int j2 = 0; j2 <= i; j2++) {
                    cipherText.append(matrix[j2][j]);
                }
            }
            System.out.println(cipherText);
            k = 0;
            flag = false;
            i = 0;
            strlen = cipherText.length();
            for (;; i++) {
                for (int j = 0; j < width; j++) {

                    if (k < strlen) {
                        matrix[i][j] = cipherText.charAt(k);
                        k++;
                    } else {
                        matrix[i][j] = '#';
                        flag = true;
                    }
                }
                if (flag || k >= strlen) {
                    break;
                }
            }
            cipherText = new StringBuilder();
            for (int j = 0; j < width; j++) {
                for (int j2 = 0; j2 <= i; j2++) {
                    cipherText.append(matrix[j2][j]);
                }
            }
            formatter.format("CipherText = %s\r\n", cipherText);
            System.out.println(cipherText);
            strlen = cipherText.length();
            char[][] matrix2 = new char[i+2][width];
            for (int j = 0, y = 0; j <= i; j++, y++) {
                for (int j2 = 0, x = 0; j2 < width; j2++) {
                    matrix2[x][y] = matrix[j][j2];
                    x++;
                    if (j2 == i) {
                        y++;
                        x = 0;
                    }
                }
            }

            StringBuilder originalText = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                for (int j2 = 0; j2 < width; j2++) {
                    if(matrix2[j][j2]=='#'){
                        continue;
                    }
                    originalText.append(matrix2[j][j2]);
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
