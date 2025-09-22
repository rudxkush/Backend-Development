import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static final String STORED_HASH =
        Hashing.sha256().hashString("adithiManava", StandardCharsets.UTF_8).toString();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String input = sc.nextLine();
        String hash = Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();

        if (hash.equals(STORED_HASH)) {
            System.out.println("Access Granted!");
        } else {
            System.out.println("Access Denied!");
        }
        sc.close();
    }
}
