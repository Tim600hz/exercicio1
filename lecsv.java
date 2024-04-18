import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivo = "dados.csv";

        
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            System.out.println("Conteúdo do arquivo " + nomeArquivo + ":");
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(","); 
                for (String campo : campos) {
                    System.out.print(campo + " | "); 
                }
                System.out.println(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
