import java.math.BigInteger;
import java.util.Scanner;

public class LehmannPrimalityTest {

    private static int lehmann(BigInteger bigInteger, int tries) {
        int a = (int) (Math.random() * (bigInteger.intValue() - 1)) + 1;
        int e = bigInteger.subtract(BigInteger.valueOf(1)).divide(BigInteger.valueOf(2)).intValue() ;
        while(tries>0){
            int result = (int)(Math.pow(a,e))%bigInteger.intValue();
            if((result%bigInteger.intValue())==1||(result%bigInteger.intValue()==(bigInteger.subtract(BigInteger.valueOf(1)).intValue()))){
                 a =  (int) (Math.random() * (bigInteger.intValue() - 1)) + 1;
                tries--;
            }else{
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to be tested : ");
        BigInteger bigInteger = input.nextBigInteger();
        int tries;
        System.out.print("Enter the number of tries : ");
        tries = input.nextInt();
        if (bigInteger.equals(BigInteger.valueOf(2))) {
            System.out.println("The number " + bigInteger + " is prime");
        } else if (bigInteger.remainder(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) {
            System.out.println("The number " + bigInteger + " is composite");
        } else {
            long flag = lehmann(bigInteger, tries);
            if (flag == 1) {
                System.out.println(bigInteger + " may be Prime.");
            } else {
                System.out.println(bigInteger + " is Composite.");
            }
        }
    }

}
