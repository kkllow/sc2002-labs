import java.util.Scanner;
public class Lab2p1 {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.println("Perform the following methods:");
            System.out.println("1: multiplication test");
            System.out.println("2: quotient using division by subtraction");
            System.out.println("3: remainder using division by subtraction");
            System.out.println("4: count the number of digits");
            System.out.println("5: position of a digit");
            System.out.println("6: extract all odd digits");
            System.out.println("7: quit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: 
                mulTest();
                break;

                case 2:
                Scanner s2 = new Scanner(System.in);
                System.out.print("m = ");
                int m = s2.nextInt();
                System.out.print("n = ");
                int n = s2.nextInt();
                System.out.println(m +"/" + n + " = " + divide(m,n));
                break;

                case 3:
                Scanner s3 = new Scanner(System.in);
                System.out.print("m = ");
                int first  = s3.nextInt();
                System.out.print("n = ");
                int second = s3.nextInt();
                System.out.println(first +" % " + second + " = " + modulus(first,second));
                break;

                case 4:
                Scanner s4 = new Scanner(System.in);
                System.out.print("n: ");
                int num = s4.nextInt();

                int count = countDigits(num);
                if (count != -1) {
                    System.out.println("n: " + num + "-count = " + count);
                }
                break;

                case 5: 
                Scanner s5 = new Scanner(System.in);
                System.out.print("n: ");
                int number = s5.nextInt();
                System.out.print("digit: ");
                int digit = s5.nextInt();
                System.out.println("position= " + position(number, digit));
                break;

                case 6:
                Scanner s6 = new Scanner(System.in);
                System.out.print("n: ");
                int longnum = s6. nextInt();
                System.out.println("oddDigits = " + extractOddDigits(longnum));
                break;

                case 7:
                System.out.println("Program terminating ...");
            }
            
        } while (choice < 7);
        sc.close();
    }

    public static void mulTest() {
        int correct = 0;
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int x = (int)(Math.random() * 9) + 1;
            int y = (int)(Math.random() * 9) + 1;
            System.out.println("How much is " + x + " times " + y + " ? ");
            int ans= s.nextInt();
            if (ans == x*y) {
                correct += 1;
            }
        }
        System.out.println(correct + " answers out of 5 are correct.");
        s.close();
    }
    public static int divide(int m, int n) {
        int count = 0;
        while (m >= n ) {
            m = m - n;
            count++;
        }
        return count;
    }
    public static int modulus(int m, int n) {
        while (m >= n) {
            m = m - n;
        }
        return m;
    }
    public static int countDigits(int n) {
        if (n <= 0) {
            System.out.println("Error input!!");
            return -1; 
        }
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }
    public static int position(int n, int digit) {
        // start count from rightmost digit
        int pos = 1;
        while (n > 0) {
            // extract last digit 
            int lastDigit = n % 10;
            // if it is the digit
            if (lastDigit == digit) {
                // return position
                return pos;
            }
            // remove last digit
            n /= 10;
            // increment pos by one to move to next digit
            pos++;
        }
        // digit is not found
        return -1;
    }
    public static long extractOddDigits(long n) {
        if (n < 0) {
            System.out.println("Error input!!");
            return -1; 
        }

        long result = 0;
        long placeValue = 1;
        boolean foundOdd = false; 

        while (n > 0) {
            long digit = n % 10;

            if (digit % 2 == 1) {
                result = digit*placeValue + result;
                placeValue *= 10;
                foundOdd = true;
            }
            n /= 10;
        }
        return foundOdd ? result : -1;
    }

}
