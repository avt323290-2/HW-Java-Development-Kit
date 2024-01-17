import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите URL-адреса файлов (через пробел): ");
        String[] urls = scanner.nextLine().split(" ");

        System.out.print("Введите количество потоков: ");
        int numThreads = scanner.nextInt();

        List<String> fileUrls = new ArrayList<>();
        for (String url : urls) {
            fileUrls.add(url.trim());
        }

        downloadFiles(fileUrls, numThreads);

        scanner.close();
    }

    private static void downloadFiles(List<String> fileUrls, int numThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (String fileUrl : fileUrls) {
            executor.execute(new FileDownloadTask(fileUrl));
        }

        executor.shutdown();
    }
}