import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1020)){
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(System.in);
            String line;
            int counter;
            int response;

            while (true) {
                line = scanner.nextLine();
                if (line.equals("end")){
                    break;
                }else {
                    counter = Integer.parseInt(line);
                }
                outputStream.write(counter);
                outputStream.flush();
                System.out.println("Отправленно: " + counter);
                response = inputStream.read();
                System.out.println("Пришло: " + response);
            }
        }
    }
}
