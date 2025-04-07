import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("starting: ");
        int start = sc.nextInt();
        System.out.println("ending: ");
        int end = sc.nextInt();
        System.out.println("increment; ");
        int incre  = sc.nextInt();
        
        final double conversionRate = 1.82;

        //for loop
        if (start > end) {
            System.out.println("Error input!!");
            sc.close();
            return;
        } 
        PrintHeader();
        for (int usd = start; usd <= end; usd += incre) {
        double sgd = usd*conversionRate;
        printRow(usd,sgd);

        // while loop
        //PrintHeader();
        //int usd = start;
        //while (usd <= end) {
        //double sgd = usd*conversionRate;
        //printRow(usd,sgd);
        //usd += incre;

        //do-while loop
        //PrintHeader();
        //int usd = start;
        //do {
        //    double sgd = usd*conversionRate;
        //    printRow(usd,sgd);
        //    usd += incre; 
        //} while (usd <=end);
        }
        sc.close();
    }
    private static void PrintHeader() {
        System.out.println("US$" + " ".repeat(7) + "S$");
        System.out.println("-".repeat(12));
    }
    
    private static void printRow(int usd, double sgd) {
        System.out.printf("%3.1f    %6.2f%n",(double)usd,sgd);
    }
} 
    
