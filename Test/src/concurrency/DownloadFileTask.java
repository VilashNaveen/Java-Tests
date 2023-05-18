package concurrency;

public class DownloadFileTask implements Runnable{
    public void run() {
        System.out.println("Downloading a File");
        for (var i = 0; i < Integer.MAX_VALUE; i++) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            System.out.println("Downloading byte " + i);
        }
        System.out.println("Complete");
    }
}
