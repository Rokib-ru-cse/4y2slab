package crytography.practice;

public class DoubleTransposition {
    public static void main(String[] args) {
        String msg = "abcdefg";
        char[][] carr = new char[100][100];
        char[] msgarr = msg.toCharArray();
        int i = 0;
        int k = 0;
        for (; k < msgarr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (k < msgarr.length) {
                    carr[i][j] = msgarr[k];
                    k++;
                }
            }
        }
    }
}
