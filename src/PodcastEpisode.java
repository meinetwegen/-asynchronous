public class PodcastEpisode extends ContentItem implements Downloadable{
    private String hostName;
    private int downloadsUsed = 0;

    public PodcastEpisode(String title, int year, int durationMinutes, String hostName){
        super(title, year, durationMinutes);
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }
    public void setHostName(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("Host name cannot be null");
        }
        else{
            this.hostName = hostName;}
    }

    @Override
    public double getLicenseCost(int currentYear) {
        if (getAge(currentYear) <= 2){
            return (0.03 * getDurationMinutes() + 3);
        }
        else{
            return (0.03 * getDurationMinutes() + 1);
        }
    }

    @Override
    public void download() {
        if (getRemainingDownloads() > 0) {
            downloadsUsed++;
            System.out.println("Downloading podcast by " + hostName + "... (Downloads used: " + downloadsUsed + ")");
        } else {
            System.out.println("Download failed: No downloads remaining");
        }
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 10;
    }

    @Override
    public int getRemainingDownloads() {
        return getMaxDownloadsPerDay() - downloadsUsed;
    }

    @Override
    public String toString() {
        return super.toString() + ", Host Name: " + this.hostName;
    }
}
