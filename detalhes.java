import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       String nomeArquivo = "funcionarios.csv";
       Scanner scanner = new Scanner(System.in);

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
           
            System.out.println("Insira os detalhes dos funcionários (nome, cargo, salário).");
            System.out.println("Digite 'sair' para parar.");

            
            while (true) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("sair")) {
                    break; 
                }

                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();

                System.out.print("Salário: ");
                String salario = scanner.nextLine();

                
                writer.writeNext(new String[]{nome, cargo, salario});
            }

            System.out.println("Informações dos funcionários foram escritas no arquivo CSV com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
            scanner.close();
        }
    }
}
