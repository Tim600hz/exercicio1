import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_python.txt";

        
        substituirPalavra(nomeArquivoEntrada, nomeArquivoSaida, "Java", "Python");

        System.out.println("Substituição concluída. Verifique o arquivo " + nomeArquivoSaida + ".");
    }

    
    private static void substituirPalavra(String nomeArquivoEntrada, String nomeArquivoSaida, String palavraAntiga, String palavraNova) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoEntrada));
             PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivoSaida))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.replaceAll(palavraAntiga, palavraNova);
                writer.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
