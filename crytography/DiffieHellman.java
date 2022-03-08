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
    public static long primitiveRoot(long n){
        long a = eulerTotient(n);
        for (int i = 1; i < n; i++) {
            if((int)Math.pow(a, i)%n==1){
                return i;
            }
        }
        return 1;
    }
    public static long eulerTotient(long b){
        int cnt = 0;
        for (int i = 1; i < b; i++) {
            if(gcd(i,b)==1){
                cnt++;
            }
        }
        return cnt;
    }

    public static int gcd(long a,long b){
        if(a%b==0){
            return (int)b;
        }
        else{
            return gcd(b,a%b);
        }
    }

    public static void main(String[] args) {
        long n = generatePrime(); // prime
        long a = primitiveRoot(n); // primitive root of n
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
