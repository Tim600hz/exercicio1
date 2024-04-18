import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivo = "meuarquivo.txt";

        
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("Olá, mundo!");
            System.out.println("Mensagem escrita no arquivo " + nomeArquivo + " com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
