
import java.util.Scanner;

/**
 *
 * @author Ayetolu Samuel Setonji Ayetolusamuel@gmail.com 08167137007
 *
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        System.out.println("Enter number to find the multiplication table");
        int result;
        Scanner scanner = new Scanner(System.in);
        int enterValue = scanner.nextInt();
        int count;

        System.out.println("******************************************************");
        System.out.println("multiplication of " + enterValue + " is as below!!!!!!!!!!!!!!!");
        for (count = 1; count <= enterValue; count++) {
            result = enterValue * count;

            System.out.println(enterValue + "\t" + count + "\t" + "=" + "\t" + result);

        }
        System.out.println("******************************************************");

    }

}
