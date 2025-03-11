import com.google.gson.Gson;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private String city;

    public Main() {}

    public Main(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Search{city='" + city + "'}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Main> searches = new ArrayList<>();

        System.out.println("Enter city names in JSON format (type 'exit' to stop):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            Gson gson = new Gson();
            Main search = gson.fromJson(input, Main.class);

            if (search != null && search.getCity() != null && !search.getCity().isEmpty()) {
                searches.add(search);
                System.out.println("Search received for city: " + search.getCity());
            } else {
                System.out.println("Invalid input. Please provide a valid city name in JSON format.");
            }
        }

        System.out.println("Summary of received searches:");
        for (Main s : searches) {
            System.out.println(s);
        }

        System.out.println("Total cities searched: " + searches.size());
    }
}
