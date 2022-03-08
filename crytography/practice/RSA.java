package crytography.practice;

import java.math.BigInteger;

import javax.print.DocFlavor.STRING;

/**
 * RSA
 */

public class RSA {

    private static long n;
    private static long e;
    private static long d;

    public static long generatePrime(){
        while(true){
            long x = (long) (Math.random()*1000) + 100;
            boolean y = isPrime(x);
            if(y){
                return x;
            }
        }
    }
    public static boolean isPrime(long x){
        if(x%2==0){
            return false;
        }else{
            for (int i = 3; i <= Math.sqrt(x); i+=2) {
                if(x%i==0){
                    return false;
                }
            }
        }
        return true;
    }
    public static long findCoPrimeOf(long coprm){
        while(true){
            long x = (long) (Math.random()*1000) + 100;
            int y = (int)gcd(x,coprm);
            if(y==1){
                return x;
            }
        }
    }
    public static long gcd(long a,long b){
        if(a%b==0){
            return b;
        }
        return gcd(b, a%b);
    }
    public static long findModInverseOf(long a,long b){
        for (int i = 1; i < b; i++) {
            if((i*a)%b==1){
                return i;
            }
        }
        return 0;
    }
    public static String encrypt(String msg) {
        char[] ca = msg.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < ca.length; i+=3) {
            for (int j = 0; j < 3; j++) {
                if(j+i<ca.length){
                    sb.append(ca[i+j]);
                }
            }
            BigInteger bigInteger = new BigInteger(sb.toString());
            BigInteger smallCipher = bigInteger.pow((int)e).mod(new BigInteger(n+""));
            cipherText.append(smallCipher.toString()+" ");
            sb = new StringBuilder();
        }
        return cipherText.toString();
    }
    public static String decrypt(String cipherText) {
        String[] s = cipherText.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : s) {
            BigInteger bigInteger = new BigInteger(string);
            BigInteger smallCipher = bigInteger.pow((int)d).mod(new BigInteger(n+""));
            sb.append(smallCipher.toString());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String msg = "12345678";
        long p = generatePrime();
        long q = generatePrime();
        // System.out.println("p = "+p);
        // System.out.println("q = "+q);
        n = p*q;
        e = findCoPrimeOf((p-1)*(q-1));
        d = findModInverseOf(e,(p-1)*(q-1));
        // System.out.println(e);
        // System.out.println(d);
        String cipherText = encrypt(msg);
        System.out.println(cipherText);
        System.out.println(msg);
        String orginalText = decrypt(cipherText);
        System.out.println(orginalText);
    }
    
}