import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivo = "arquivo.bin";

        
        try (InputStream in = new FileInputStream(nomeArquivo)) {
            byte[] buffer = new byte[100]; 
            int bytesLidos = in.read(buffer);

            
            System.out.println("Primeiros 100 bytes do arquivo:");
            System.out.println(new String(buffer, 0, bytesLidos)); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
