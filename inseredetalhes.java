import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivo = "produtos.csv";

        
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Insira os detalhes dos produtos (nome, preço, quantidade).");
        System.out.println("Digite 'sair' para parar.");

        
        while (true) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break; 
            }

            System.out.print("Preço: ");
            double preco = scanner.nextDouble();

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            
            Produto produto = new Produto(nome, preco, quantidade);

            
            try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo, true))) {
                
                writer.writeNext(new String[]{produto.getNome(), String.valueOf(produto.getPreco()),
                        String.valueOf(produto.getQuantidade())});
                System.out.println("Produto adicionado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       
        scanner.close();
    }
}
