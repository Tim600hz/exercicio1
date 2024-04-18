import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivo = "meuarquivo.txt";

       
        int numeroLinhas = contarLinhasArquivo(nomeArquivo);

       
        System.out.println("Número de linhas no arquivo " + nomeArquivo + ": " + numeroLinhas);
    }

    
    private static int contarLinhasArquivo(String nomeArquivo) {
        int numeroLinhas = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            while (reader.readLine() != null) {
                numeroLinhas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numeroLinhas;
    }
}
