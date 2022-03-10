public class Runlength {


    private static String decode(String msg){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < msg.length(); i+=2) {
            char c = msg.charAt(i);
            int a = Integer.parseInt(String.valueOf(msg.charAt(i+1)));
            for (int j = 0; j < a; j++) {
                output.append(c);
            }
        }
        return output.toString();
    }

    private static String encode(String msg) {
        StringBuilder output = new StringBuilder();
        int a = 0;
        for (int i = 0; i < msg.length(); i = i + a) {
            a = 0;
            for (int j = i;; j++) {
                if (j < msg.length()) {
                    if (msg.charAt(i) != msg.charAt(j)) {
                        break;
                    } else {
                        a++;
                    }
                } else {
                    break;
                }
            }
            output.append(msg.charAt(i) + String.valueOf(a));
        }
        return output.toString();

    }

    public static void main(String[] args) {
        String msg = "aaabbbcc aa";
        String encoded = encode(msg);
        String decoded = decode(encoded);
        System.out.println(encoded);
        System.out.println(decoded);
    }
}
