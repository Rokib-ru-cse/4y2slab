package crytography.practice;

public class Transposition {
    public static void main(String[] args) {
        String msg = "abcdefg";
        char[][] carr = new char[100][100];
        char[] c = msg.toCharArray();
        int k =0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (; i < 2; i++) {
            for (int j = i; j < c.length; j+=2) {
                if(k<msg.length()){
                    sb.append(c[j]);
                }
            }
        }
        System.out.println(sb);
        sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            for (int j2 = 0; j2 < 2; j2++) {
                sb.append(carr[j][j2]);
            }
        }
        System.out.println(sb);

    }
}
