import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivo = "alunos.csv";

        
        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            List<String[]> linhas = reader.readAll(); 

            
            for (String[] linha : linhas) {
                for (String dado : linha) {
                    System.out.print(dado + "\t"); 
                }
                System.out.println(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
