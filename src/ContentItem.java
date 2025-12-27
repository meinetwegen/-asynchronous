public abstract class ContentItem {
    private int id;
    private static int idGen = 1;
    private String title;
    private int year;
    private int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        this.id = idGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        else{
        this.title = title;}
    }
    public void setYear(int year) {
        if (year < 1990 || year > 2025) {
            throw new IllegalArgumentException("Year must be between 1990 and 2025");
        }
        else{
        this.year = year;}
    }
    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        else{
        this.durationMinutes = durationMinutes;}
    }
    public int getAge(int currentYear){
        return currentYear - getYear();
    }

    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Year: " + year + ", Duration: " + durationMinutes;
    }
}
