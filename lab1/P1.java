import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input option of choice: ");

        String option = sc.next();
        char alphabet = option.charAt(0);
        
        switch(alphabet) {
            case 'a':
            case 'A':
                System.out.println("Action movie fan");
                break;
            case 'c':
            case 'C':
                System.out.println("Comedy movie fan");
                break;
            case 'd':
            case 'D':
                System.out.println("Drame movie fan");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        sc.close();
    }
}
