import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        String arquivoOrigem = "arquivo_grande.bin";
        String arquivoDestino = "copia_arquivo_grande.bin";


        try (InputStream in = new FileInputStream(arquivoOrigem);
             OutputStream out = new FileOutputStream(arquivoDestino)) {
           
            byte[] buffer = new byte[8192]; 
            int bytesLidos;

            
            while ((bytesLidos = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesLidos);
            }

            
            System.out.println("Arquivo copiado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
