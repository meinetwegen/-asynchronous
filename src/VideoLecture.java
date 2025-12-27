public class VideoLecture extends ContentItem implements Downloadable{
    private String quality;
    private int downloadsUsed = 0;

    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes);
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        if (quality == null || quality.isEmpty()) {
            throw new IllegalArgumentException("Quality cannot be null or empty");
        }
        else{
            this.quality = quality;}
    }

    @Override
    public double getLicenseCost(int currentYear) {
        if (getAge(currentYear) <= 2){
            return (0.05 * getDurationMinutes() + 5);
        }
        else{
            return (0.05 * getDurationMinutes() + 2);
        }
    }

    @Override
    public void download() {
        if (getRemainingDownloads() > 0) {
            downloadsUsed++;
            System.out.println("Downloading video in " + quality + "... (Downloads used: " + downloadsUsed + ")");
        } else {
            System.out.println("Download failed: No downloads remaining");
        }
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }

    @Override
    public int getRemainingDownloads() {
        return getMaxDownloadsPerDay() - downloadsUsed;
    }

    @Override
    public String toString() {
        return super.toString() + ", Quality: " + this.quality;
    }
}
