import java.util.ArrayList;
import java.util.Scanner;

public class ContentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java", 2024, 45, "HD"));
        items.add(new VideoLecture("OOP", 2015, 120, "4K"));
        items.add(new PodcastEpisode("Python", 2025, 30, "Alex"));
        items.add(new PodcastEpisode("C++", 2020, 60, "Sam"));

        System.out.print("Enter current year: ");
        int currentYear;
        if (scanner.hasNextInt()) {
            currentYear = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Using java.time.Year.now().getValue()");
            currentYear = java.time.Year.now().getValue();
        }

        System.out.println("\nTesting Methods");
        for (ContentItem item : items) {
            System.out.println(item.toString());
            System.out.println("Item Age: " + item.getAge(currentYear) + " years");
            System.out.println("License Cost: " + item.getLicenseCost(currentYear));

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                System.out.println("Daily Limit: " + d.getMaxDownloadsPerDay());
                for (int i = 0; i < 4; i++) {
                    System.out.print("Attempt " + (i + 1) + ": ");
                    d.download();
                }
                System.out.println("Remaining downloads: " + d.getRemainingDownloads());
            }
            System.out.println("---");
        }

        System.out.println("\nValidation tsests");
        try {
            System.out.println("Attempting to set an invalid year:");
            new VideoLecture("Time Travel", 1800, 60, "HD");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }

        try {
            System.out.println("Attempting to set an empty title");
            new PodcastEpisode("", 2024, 30, "Host");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught error: " + e.getMessage());
        }

        scanner.close();
    }
}