import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       
        String nomeArquivo = "meuarquivo.txt";

        
        int contador = contarPalavraNoArquivo(nomeArquivo, "Java");

        
        System.out.println("A palavra 'Java' aparece no arquivo " + nomeArquivo + " " + contador + " vezes.");
    }

    
    private static int contarPalavraNoArquivo(String nomeArquivo, String palavra) {
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                contador += contarPalavraNaLinha(linha, palavra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contador;
    }

    
    private static int contarPalavraNaLinha(String linha, String palavra) {
        int contador = 0;
        String[] palavras = linha.split("\\s+"); 

        for (String p : palavras) {
            if (p.equalsIgnoreCase(palavra)) {
                contador++;
            }
        }

        return contador;
    }
}
