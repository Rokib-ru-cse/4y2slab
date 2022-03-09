public class ArithmeticCoding {
    static char[] ch = new char[256];
    static int in;
    static double a;
    static double[] probability = new double[256];
    static int[] mark = new int[300];

    public static double arithmetic_coding(String msg) {

        double range = 1.0, point = 0.0, temp_range = 0.0;
        for (int i = 0; i < msg.length(); i++) {
            point = point - temp_range;
            for (int j = 0; j < in; j++) {
                temp_range = range * probability[j];
                point = point + temp_range;
                if (msg.charAt(i) == ch[j]) {
                    range = temp_range;
                    break;
                }
            }
        }
        double tag = (point + (point - temp_range)) / 2.0;
        System.out.println(in);
        for (int i = 0; i < in; i++) {
            System.out.println(ch[i] + " " + probability[i]);
        }
        System.out.print("encoded data : ");
        System.out.println(tag);
        return tag;
    }

    public static String decode(double encoded) {

        double range = 1.0, point = 0, temp_range = 0;
        StringBuilder output = new StringBuilder("");
        double tag = encoded;
        while (true) {
            if(output.length()>0){
                if(output.charAt(output.length()-1)=='$'){
                    break;
                }
            }
            point = point - temp_range;
            for (int i = 0; i < in; i++) {
                temp_range =range*probability[i];
                point = point+temp_range;
                if(((point-temp_range)<tag&&point>tag)||temp_range<0.000001){
                    range =temp_range;
                    output.append(ch[i]);
                    break;
                }
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        double encoded;
        String msg = "CAEFEEAC$";
        String decoded;
        for (int k = 0; k < msg.length(); k++) {
            mark[(int) (msg.charAt(k))]++;
        }
        in = 0;
        for (int i = 0; i <= 255; i++) {
            if (mark[i] != 0) {
                ch[in] = (char) i;
                probability[in] = (float) mark[i] / (float) msg.length();
                in++;
            }
        }
        // for (int i = 0; i < in; i++) {
        // System.out.print(ch[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < in; i++) {
        // System.out.print(probability[i] + " ");
        // }

        encoded = arithmetic_coding(msg);
        System.out.println("original msg = " + msg);
        decoded = decode(encoded);
        System.out.println(decoded);
    }
}
