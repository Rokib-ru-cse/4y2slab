package crytography.practice;

import java.math.BigInteger;
import java.util.Scanner;

public class newlahman {
    public static boolean lehmanp(long n,int i){
        if(n==0||n==1){
            return false;
        }else if(n==2||n==3){
            return true;
        }else if(n%2==0){
            return false;
        }else{
            for (int j = 0; j < i; j++) {
                long a = (long)(Math.random()*(n-3)+2);
                int b = new BigInteger(a+"").pow((int)((n-1)/2)).mod(new BigInteger(n+"")).intValue();
                if(b!=1&&b!=-1&&b!=(n-1)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int i = in.nextInt();
        if(lehmanp(n,i)){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }
    }
}
