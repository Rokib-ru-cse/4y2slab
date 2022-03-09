import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 * runlength_compression
 */
public class RunLengthCompression {
    public static void main(String[] args) {
        try {
            File file = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/runlength.txt");
            Formatter formatter = new Formatter("/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/runlengthencode.txt");
            
            Scanner input = new Scanner(file);
            String s1;
            int cnt;
            while (input.hasNextLine()) {
                s1 =  input.nextLine();
                StringBuilder s2 = new StringBuilder("");
                for (int i = 0; i < s1.length();) {
                    cnt = 0;
                    for (int j = i; j < s1.length(); j++) {
                        if(s1.charAt(i)==s1.charAt(j)){
                            cnt++;
                        }else{
                            break;
                        }
                    }
                    s2.append(s1.charAt(i)+Integer.toString(cnt));
                    i +=cnt;
                }
                formatter.format("%s\r\n",s2);
            }
            
            formatter.close();
            input.close();
            File file1 = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/runlengthencode.txt");
            Formatter formatter1 = new Formatter("/home/rokib-ru-cse/Desktop/problems/4y2slab/multimedia/runlengthdecode.txt");
            Scanner input1 = new Scanner(file1);
            while(input1.hasNextLine()){
                s1 = input1.nextLine();
                StringBuilder s2 = new StringBuilder("");
                for (int i = 0; i < s1.length(); i+=2) {
                    String k = Character.toString(s1.charAt(i+1));
                    for (int j = 0; j <Integer.parseInt(k); j++) {
                        s2.append(s1.charAt(i));  
                    } 
                }
                formatter1.format("%s\r\n",s2);
            }
            input1.close();
            formatter1.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}