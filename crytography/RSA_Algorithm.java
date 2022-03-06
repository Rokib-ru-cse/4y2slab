import java.io.File;
import java.math.BigInteger;
import java.util.Formatter;
import java.util.Scanner;

/**
 * RSA_Algorithm
 */
public class RSA_Algorithm {

    private static long e;
    private static long n;
    private static long d;

    private static long generatePrime() {
        while (true) {
            long x = (long) (Math.random()*100) + 100;
            boolean y = isPrime(x);
            if (y) {
                return x;
            }
        }
    }

    private static boolean isPrime(long n) {
        if (n == 0 || n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        }else if(n%2==0){
            return false;
        }
         else {
            for (long i = 3; i <= Math.sqrt(n)+2; i+=2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static long findCoPrimeOf(long n) {
        while (true) {
            long x = (long) (Math.random()*n);
            if (gcd(x, n) == 1) {
                return x;
            }
        }
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) {   //if a%b==0 then b is gcd of a and b
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    private static long modInverse(long a, long b) {
        for (long i = 1; i <= b - 1; i++) {
            if ((a * i) % b == 1) {  //(a*i)%b ==1 then i is the modinverse of a
                return i;
            }
        }
        return 0;
    }

    private static String encrypt(String plainText) {
        char[] number = plainText.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < number.length; i += 3) {
            for (int j = 0; j < 3; j++) {
                if ((i + j) < number.length) {
                    sb.append(number[i + j]);
                }
            }
            BigInteger bigInteger = new BigInteger(sb.toString());
            BigInteger smallCipher = bigInteger.pow((int) e).mod(new BigInteger("" + n));
            sb = new StringBuilder();
            cipherText.append(smallCipher.toString() + " ");
        }
        return cipherText.toString();
    }

    private static String decrypt(String cipherText) {
        String[] number = cipherText.split(" ");
        StringBuilder originalText = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            BigInteger bigInteger = new BigInteger(number[i]);
            BigInteger smallCipher = bigInteger.pow((int) d).mod(new BigInteger("" + n));
            originalText.append(smallCipher);
        }
        return originalText.toString();
    }

    public static void main(String[] args) {
        try {
            File file = new File("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/rsa.txt");
            Scanner input = new Scanner(file);
            String plainText = input.nextLine().split(" ")[2];
            // String plainText = "6882326879666683";
            long p = generatePrime();
            long q = generatePrime();
            n = p * q;
            e = findCoPrimeOf((p - 1) * (q - 1));
            d = modInverse(e, (p - 1) * (q - 1));
            System.out.println(p);
            System.out.println(q);
            System.out.println(n);
            System.out.println(e);
            System.out.println(d);
            // n = 3337;
            // e = 79;
            // d = 1019;
            String cipherText = encrypt(plainText);
            String originalText = decrypt(cipherText);
            Formatter formatter = new Formatter("/home/rokib-ru-cse/Desktop/problems/4y2slab/crytography/rsa.txt");
            formatter.format("plainText = %s\r\n", plainText);
            formatter.format("cipherText = %s\r\n", cipherText);
            formatter.format("originalText = %s\r\n", originalText);
            System.out.println("plainText = " + plainText);
            System.out.println("cipherText = " + cipherText);
            System.out.println("originalText = " + originalText);
            input.close();
            formatter.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}