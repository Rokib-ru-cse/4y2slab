package crytography.practice;

import java.math.BigInteger;
import java.util.Scanner;

public class RabinMiller {


    public static boolean miller(long num){
        long m = num-1;
        int b = 0;
        while(m%2==0){
            m/=2;
            b++;
        }
        int j=0;
        long a = (long)(Math.random()*(num-2)+2);
        long z = new BigInteger(""+a).pow((int)m).mod(new BigInteger(""+num)).longValue();
        long prev;
        while(j<b&&z!=1){
            prev = z;
            z*=z;
            z%=num;
            if(z==1&&(prev!=1&&prev!=(num-1))){
                return false;
            }
            j++;
        }
        if(z==1){
            return true;
        }else{
            return false;
        }


    }

    public static boolean rabin(long num,int tries){
        if(num==0||num==1){
            return false;
        }else if(num ==2||num==3){
            return true;
        }else if(num%2==0){
            return false;
        }else{
            boolean b = miller(num);
            if(!b){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be tested as prime or not : \n");
        long num = input.nextLong();
        System.out.print("Enter the number iteration : \n");
        int tries = input.nextInt();
        if(rabin(num,tries)){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }
    }
}
