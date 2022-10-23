import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("InfiniteLoopStatement")
public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)) {
            while (true) {
                Socket socket = serverSocket.accept();
                serverClient(socket);
            }
        }
    }

    private static void serverClient(Socket socket) throws IOException{
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        System.out.println("Обслуживаемый клиент: " + socket.getInetAddress());
        int request;

        do{
            request = inputStream.read();
            System.out.println("Пришло: " + request);
            request *= request;
            outputStream.write(request);
            outputStream.flush();
            System.out.println("Отправленно: " + request);
        }while (true);
    }
}