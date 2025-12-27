import java.util.ArrayList;
import java.util.Scanner;

public class ContentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ContentItem> items = new ArrayList<>();

        VideoLecture v1 = new VideoLecture("Java", 2024, 45, "HD");
        items.add(v1);
        items.add(new PodcastEpisode("Python", 2025, 30, "Alex"));

        System.out.print("Enter current year: ");
        int currentYear;
        if (scanner.hasNextInt()) {
            currentYear = scanner.nextInt();
        } else {
            System.out.println("Invalid input.Using 2025.");
            currentYear = 2025;
        }

        for (ContentItem item : items) {
            System.out.println(item.toString());

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;

                for (int i = 0; i < 4; i++) {
                    System.out.print("Attempt " + (i+1) + ": ");
                    d.download();
                }
                System.out.println("Remaining tokens: " + d.getRemainingDownloads());
            }
            System.out.println("---");
        }
    }
}