import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("salary: ");
        String input = sc.next();
        System.out.println("merit: ");
        String input2 = sc.next();
        int merit = Integer.parseInt(input2);
        double value;

        if (input.startsWith("$")) {
            String numericPart = input.substring(1);
            value = Double.parseDouble(numericPart);
        }
        else {
            value = Double.parseDouble(input);
        }

        if (value >= 500 && value <= 599) {
            System.out.println("- Grade C");
        }
        else if (value >= 600 && value <= 649) {
            if (merit < 10){
                System.out.println("- Grade C");
            }
            else {
                System.out.println("-Grade B");
            }
        }
        else if (value >= 650 && value <= 699) {
            System.out.println("- Grade B");
        }
        else if (value >= 700 && value <= 799) {
            if (merit < 20) {
                System.out.println("- Grade B");
            }
            else {
                System.out.println("- Grade A");
            }
        }
        else if (value >= 800 && value <= 899) {
            System.out.println("- Grade A");
        }
        sc.close();
    }   


}



