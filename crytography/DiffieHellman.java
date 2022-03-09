package crytography;

import java.math.BigInteger;

public class DiffieHellman {

    public static long generatePrime() {
        while (true) {
            long x = (long) (Math.random() * 100 + 100);
            boolean y = isPrime(x);
            if (y) {
                return x;
            }
        }
    }

    public static boolean isPrime(long a){
        if(a%2==0){
            return false;
        }
        for (int i = 3; i <= Math.sqrt(a); i+=2){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
   
    

    public static int proot(long n) {
        long a;
        while(true){
            a = (long)(Math.random()*(n-2)+1);
            if(gcd(a,n)==1){
                break;
            }
        }
        for (int i = 2; ; i++) {
            if(new BigInteger(""+a).pow(i).mod(new BigInteger(""+n)).intValue()==1){
                return i; // i is the premitive root of n
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

    public static void main(String[] args) {
        long n = generatePrime(); // prime
        long a = proot(n); // primitive root of n
        System.out.println(n);
        System.out.println(a);
        long Xa = 1 + (long) (Math.random() * 1000); // A Private Key
        long Xb = 1 + (long) (Math.random() * 1000); // B Private Key
        System.out.println(Xa);
        System.out.println(Xb);
        long Ya = new BigInteger(a + "").pow((int) Xa).mod(new BigInteger(n + "")).longValue(); // A public Key
        long Yb = new BigInteger(a + "").pow((int) Xb).mod(new BigInteger(n + "")).longValue(); // B public Key

        int Ka = new BigInteger(Yb + "").pow((int) Xa).mod(new BigInteger(n + "")).intValue();
        int Kb = new BigInteger(Ya + "").pow((int) Xb).mod(new BigInteger(n + "")).intValue();

        System.out.println(Ka);
        System.out.println(Kb);
    }
}
