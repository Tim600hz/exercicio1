import java.io.*;

public class Main {
    public static void main(String[] args) {
       
      
        String nomeArquivo = "meuarquivo.txt";

        
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nomeArquivo, true)))) {
            writer.println("Isso é uma adição!");
            System.out.println("Mensagem adicionada ao arquivo " + nomeArquivo + " com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
