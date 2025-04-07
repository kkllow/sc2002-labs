import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        System.out.println("height= ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();

        if (height <= 0) {
            System.out.println("Error input!!");
            sc.close();
            return;
        }
        for (int row = 1; row <= height;row++){
            StringBuilder pattern = new StringBuilder();

            for (int repeat = 1; repeat <= row; repeat++) {
                if (repeat % 2 == 1) {
                    pattern.append("AA");
                }
                else {
                    pattern. append("BB");
                }
            }
            System.out.println(pattern);
        }
        sc.close();
    }
}
