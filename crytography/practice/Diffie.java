package crytography.practice;

import java.math.BigInteger;

public class Diffie {

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
        long n = 13; //prime
        int a = proot(n); // primitive root of 13
        System.out.println(a);
        long Xa = (long)(Math.random()*1000+1); //private of a
        long Xb = (long)(Math.random()*1000+1); //private of b

        long Ya = new BigInteger(a+"").pow((int)Xa).mod(new BigInteger((n+""))).longValue();
        long Yb = new BigInteger(a+"").pow((int)Xb).mod(new BigInteger((n+""))).longValue();

        long ka = new BigInteger(Yb+"").pow((int)Xa).mod(new BigInteger((n+""))).longValue();
        long kb = new BigInteger(Ya+"").pow((int)Xb).mod(new BigInteger((n+""))).longValue();

        System.out.println(ka);
        System.out.println(ka);

    }
}
