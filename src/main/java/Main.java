import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class Main {
    public static void main(String []args) throws IOException {
        Parser parser = new Parser();
        ExecutorService executor = new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy()
        );


        try(ServerSocket server = new ServerSocket(8080)){
            while (true) {
                Socket client = server.accept();
                try {
                    executor.execute(() -> handleClient(client, parser));
                } catch (RejectedExecutionException e) {
                    client.close();
                }
            }
        } finally {
            executor.shutdown();
        }
    }

    private static void handleClient(Socket client, Parser parser) {
        try(client){
            client.setSoTimeout(5000);
            StringBuilder request = new StringBuilder();
            int bytesRead = -2;
            while(bytesRead != -1){
                InputStream input = client.getInputStream();
                byte [] buffer = new byte[4096];
                bytesRead = input.read(buffer);
                request.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}