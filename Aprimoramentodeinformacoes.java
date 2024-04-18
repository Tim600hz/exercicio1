import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definindo a classe Produto
class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Métodos getters e setters (opcional)
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
        // Definindo o nome do arquivo CSV
        String nomeArquivo = "produtos.csv";

        // Criando um scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Pedindo ao usuário para escolher entre adicionar ou atualizar produtos
        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar novo produto");
        System.out.println("2. Atualizar produto existente");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumindo a quebra de linha após o número

        // Opção de adicionar um novo produto
        if (opcao == 1) {
            adicionarProduto(nomeArquivo, scanner);
        }
        // Opção de atualizar um produto existente
        else if (opcao == 2) {
            atualizarProduto(nomeArquivo, scanner);
        }
        // Opção inválida
        else {
            System.out.println("Opção inválida. Programa encerrado.");
        }

        // Fechando o scanner
        scanner.close();
    }

    // Método para adicionar um novo produto ao arquivo CSV
    private static void adicionarProduto(String nomeArquivo, Scanner scanner) {
        // Pedindo ao usuário para inserir os detalhes do produto
        System.out.println("Insira os detalhes do novo produto (nome, preço, quantidade).");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumindo a quebra de linha após o número

        // Criando um objeto da classe Produto com base nos detalhes fornecidos pelo usuário
        Produto produto = new Produto(nome, preco, quantidade);

        // Tentativa de adicionar os detalhes do produto ao arquivo CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo, true))) {
            // Escrevendo os detalhes do produto no arquivo CSV
            writer.writeNext(new String[]{produto.getNome(), String.valueOf(produto.getPreco()),
                    String.valueOf(produto.getQuantidade())});
            System.out.println("Produto adicionado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar um produto existente no arquivo CSV
    private static void atualizarProduto(String nomeArquivo, Scanner scanner) {
        // Pedindo ao usuário para inserir o nome do produto a ser atualizado
        System.out.print("Digite o nome do produto que deseja atualizar: ");
        String nomeProduto = scanner.nextLine();

        // Tentativa de ler os dados do arquivo CSV e encontrar o produto pelo nome
        List<Produto> produtos = new ArrayList<>();
        boolean produtoEncontrado = false;
        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            List<String[]> linhas = reader.readAll();

            // Iterando sobre as linhas do arquivo CSV
            for (String[] linha : linhas) {
                if (linha[0].equalsIgnoreCase(nomeProduto)) {
                    produtoEncontrado = true;
                    // Criando um objeto da classe Produto com base nos dados encontrados
                    Produto produto = new Produto(linha[0], Double.parseDouble(linha[1]), Integer.parseInt(linha[2]));
                    produtos.add(produto);
                    break; // Parando a busca assim que o produto for encontrado
                }
            }

            // Se o produto for encontrado, permite que o usuário atualize suas informações
            if (produtoEncontrado) {
                // Pedindo ao usuário para inserir os novos detalhes do produto
                System.out.println("Insira os novos detalhes do produto (preço, quantidade).");

                System.out.print("Novo preço: ");
                double novoPreco = scanner.nextDouble();

                System.out.print("Nova quantidade: ");
                int novaQuantidade = scanner.nextInt();
                scanner.nextLine(); // Consumindo a quebra de linha após o número

                // Atualizando as informações do produto na lista
                Produto produto = produtos.get(0); // Como só pode haver um produto com o mesmo nome
                produto.setPreco(novoPreco);
                produto.setQuantidade(novaQuantidade);

                // Reescrevendo todos os dados do arquivo CSV com as informações atualizadas
                try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
                    for (Produto p : produtos) {
                        writer.writeNext(new String[]{p.getNome(), String.valueOf(p.getPreco()),
                                String.valueOf(p.getQuantidade())});
                    }
                    System.out.println("Produto atualizado com sucesso.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
