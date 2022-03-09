package crytography.practice;

import java.math.BigInteger;

public class rsa {

    private static long n;
    private static long e;
    private static long d;

    public static long generatePrime(){
        while(true){
            long a = (long)(Math.random()*1000+100);
            if(isPrime(a)){
                return a;
            }
        }
    }
    public static boolean isPrime(long a){
        if(a%2==0){
            return false;
        }
        for (int i = 3; i <= Math.sqrt(a); i+=2) {
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    public static long findCoPrime(long a){
        while(true){
            long b = (long)(Math.random()*1000+100);
            if(gcd(a,b)==1){
                return b;
            }
        }
    }
    public static int gcd(long a,long b){
        if(a%b==0){
            return (int)b;
        }else{
            return gcd(b,a%b);
        }
    }
    public static long findModInverse(long a,long b){
        for (int i = 1; i < b; i++) {
            if((a*i)%b==1){
                return i;
            }
        }
        return 0;
    }
    public static String encrypt(String msg){
        char[] c = msg.toCharArray();
        StringBuilder ci = new StringBuilder();
        for (int i = 0; i < c.length; i+=3) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                if(i+j<c.length){
                    sb.append(c[i+j]);
                }
            }
            ci.append(new BigInteger(sb.toString()).pow((int)e).mod(new BigInteger(""+n))+" ");

        }
        return ci.toString();
    }
    public static String decrypt(String msg){
        String[] c = msg.split(" ");
        StringBuilder ci = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            ci.append(new BigInteger(c[i]).pow((int)d).mod(new BigInteger(""+n)));
        }
        return ci.toString();
    }
    public static void main(String[] args) {
        long p = generatePrime();
        long q = generatePrime();
        n = p*q;
        e = findCoPrime((p-1)*(q-1));
        d = findModInverse(e,(p-1)*(q-1));
        System.out.println(n);
        System.out.println(e);
        System.out.println(d);
        String msg = "12345678";
        String c = encrypt(msg);
        String o = decrypt(c);
        System.out.println(msg);
        System.out.println(c);
        System.out.println(o);
    }
}
