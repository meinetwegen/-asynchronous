public interface Downloadable {
    void download();
    int getMaxDownloadsPerDay();
    int getRemainingDownloads();
}