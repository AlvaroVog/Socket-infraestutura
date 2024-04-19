import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        
        // Porta em que o servidor estará escutando
        int porta = 8001;

        try {
            // Criar um servidor socket
            ServerSocket serverSocket = new ServerSocket(porta);
            System.out.println("Servidor escutando na porta " + porta);

            // Aceitar conexão de cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Conexão recebida: " + clientSocket);

            // Configurar fluxos de entrada e saída para o cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Ler mensagens do cliente e enviar resposta
            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                System.out.println("Mensagem recebida do cliente: " + mensagem);
                out.println("Recebido: " + mensagem);
            }

            // Fechar recursos
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
