public class Arthmetic {
    private static double[] probability = new double[256];
    private static char[] character = new char[256];
    private static int[] mark = new int[300];
    private static int in;

    public static double encode(String msg) {
        double range=1,point=0,temp_range=0;
        for (int i = 0; i < msg.length(); i++) {
            point = point-temp_range;
            for (int j = 0; j < in; j++) {
                temp_range = range*probability[j];
                point = point+temp_range;
                if(msg.charAt(i)==character[j]){
                    range = temp_range;
                    break;
                }
            }
        }
        double tag = (point+(point-temp_range))/2.0;
        return tag;
    }

    private static String decode(double encoded){
        double tag = encoded;
        double range = 1,point = 0,temp_range= 0;
        StringBuilder output = new StringBuilder();
        while(true){
            if(output.length()>0){
                if(output.charAt(output.length()-1)=='$'){
                    break;
                }
            }
            point = point -temp_range;
            for (int i = 0; i < in; i++) {
                temp_range = range*probability[i];
                point = point+temp_range;
                if(((point-temp_range)<tag&&point>tag)||temp_range<0.000001){
                    range =temp_range;
                    output.append(character[i]);
                    break;
                }
            }
        }


        return output.toString();
    }

    public static void main(String[] args) {
        String msg = "CAEFEEAC$";
        for (char c : msg.toCharArray()) {
            mark[(int) c]++;
        }
        in = 0;
        for (int i = 0; i < 256; i++) {
            if (mark[i] != 0) {
                character[in] = (char) i;
                probability[in] = (float) mark[i] / (float) msg.length();
                in++;
            }
        }

        double encoded = encode(msg);
        String decoded = decode(encoded);
        System.out.println(encoded);
        System.out.println(decoded);
    }
}
