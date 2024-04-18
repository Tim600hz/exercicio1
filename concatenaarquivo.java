import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        criarArquivos();

       
        concatenarArquivos("arquivo1.txt", "arquivo2.txt", "arquivo_concatenado.txt");

        System.out.println("Conteúdo dos arquivos concatenado e salvo em arquivo_concatenado.txt.");
    }

    
    private static void criarArquivos() {
        String conteudoArquivo1 = "Conteúdo do arquivo 1.";
        String conteudoArquivo2 = "Conteúdo do arquivo 2.";

        escreverArquivo("arquivo1.txt", conteudoArquivo1);
        escreverArquivo("arquivo2.txt", conteudoArquivo2);
    }

    
    private static void escreverArquivo(String nomeArquivo, String conteudo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private static void concatenarArquivos(String nomeArquivo1, String nomeArquivo2, String nomeArquivoConcatenado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivoConcatenado))) {
            escreverConteudoArquivo(nomeArquivo1, writer);
            escreverConteudoArquivo(nomeArquivo2, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private static void escreverConteudoArquivo(String nomeArquivo, BufferedWriter writer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
