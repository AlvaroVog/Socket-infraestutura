import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketCliente {
    public static void main(String[] args) {

        try { //O try-catch permite lidar com exceções (erros) que podem ocorrer durante a execução

            System.out.println("Cliente Iniciado ");
            Socket soc = new Socket("localhost", 8001);
            BufferedReader userInput = new BufferedReader(new InputStreamReader (System.in)); //Cria o objeto 'BufferedReader que esta vinculado à entrada padrão do sistma
            System.out.println("Insira uma string ");
            String str = userInput.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true); //Cria um objeto novo 'PrintWriter' que sera usado para escrever dados para o fluxo de saida do socket
            out.println(str);
            //Aqui lemos alguns dados do teclado e enviamos para o servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream())); //vai ler os dados do fluxo de entrada dos sockets corretamente
            System.out.println(in.readLine()); //tudo que o servidor enviou vamos imprimir na tela.
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
