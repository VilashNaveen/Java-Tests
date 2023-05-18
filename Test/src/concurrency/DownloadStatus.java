package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int TotalBytes;
    private int totalFiles;

    public int getTotalBytes() {
        return TotalBytes;
    }

    public void incrementTotalBytes() {
        synchronized (this) {
            TotalBytes++;
        }
    }
}