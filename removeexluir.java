import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_sem_excluir.txt";

        
        List<String> linhas = lerLinhasArquivo(nomeArquivoEntrada);

        
        removerLinhasComPalavra(linhas, "excluir");

        
        escreverLinhasArquivo(nomeArquivoSaida, linhas);

        System.out.println("Linhas com 'excluir' removidas e salvas no arquivo " + nomeArquivoSaida + ".");
    }

    
    private static List<String> lerLinhasArquivo(String nomeArquivo) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }

    
    private static void removerLinhasComPalavra(List<String> linhas, String palavra) {
        linhas.removeIf(line -> line.contains(palavra));
    }

    
    private static void escreverLinhasArquivo(String nomeArquivo, List<String> linhas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (String linha : linhas) {
                writer.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
