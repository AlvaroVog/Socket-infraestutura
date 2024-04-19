import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class SocketServidor {
    public static  void main(String[] args) {
        try {
            System.out.println("Esperando por Clientes...");
            ServerSocket ss = new ServerSocket(8001); //Cria o servidor socket que fica disponivel para aceitar conexões
            Socket soc = ss.accept();
            System.out.println("Conexão estabelecida ");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); //Estabelece um meio de ler dados enviados para um socket através da rede
            String str = in.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true); //cria um objeto PrintWriter que enviará dados para o socket e o associa à variável out, assim permite que você envie dados para o cliente que está conectado ao socket.
            out.println("Server fala: " + str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
