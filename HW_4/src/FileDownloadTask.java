import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileDownloadTask implements Runnable {
    private String fileUrl;

    public FileDownloadTask(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        try {
            downloadFile(fileUrl);
            System.out.println("Загружено: " + fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadFile(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        try (InputStream in = url.openStream();
             FileOutputStream fos = new FileOutputStream(getFileName(url))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private String getFileName(URL url) {
        String[] parts = url.getFile().split("/");
        return parts[parts.length - 1];
    }
}