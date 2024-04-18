import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definindo a classe Funcionario
class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L; // Adicionando número de versão
    private int id;
    private String nome;
    private String cargo;
    
    // Construtor
    public Funcionario(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }
    
    // Getters e setters (opcional)
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    // Método para exibir os detalhes do funcionário
    public void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        // Lista para armazenar os registros de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        
        // Carregando registros de funcionários do arquivo (se existir)
        carregarRegistros(funcionarios);
        
        // Exibindo menu de opções
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Atualizar Funcionário");
            System.out.println("3. Excluir Funcionário");
            System.out.println("4. Exibir Todos os Funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            // Realizando ação de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    adicionarFuncionario(funcionarios, scanner);
                    break;
                case 2:
                    atualizarFuncionario(funcionarios, scanner);
                    break;
                case 3:
                    excluirFuncionario(funcionarios, scanner);
                    break;
                case 4:
                    exibirFuncionarios(funcionarios);
                    break;
                case 0:
                    salvarRegistros(funcionarios); // Salvando registros antes de sair
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        
        // Fechando o scanner
        scanner.close();
    }
    
    // Método para carregar registros de funcionários do arquivo
    private static void carregarRegistros(List<Funcionario> funcionarios) {
        try (ObjectInputStream objetoStream = new ObjectInputStream(new FileInputStream("funcionarios.dat"))) {
            List<Funcionario> registros = (List<Funcionario>) objetoStream.readObject();
            funcionarios.addAll(registros);
            System.out.println("Registros de funcionários carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum registro de funcionário encontrado.");
        }
    }
    
    // Método para salvar registros de funcionários no arquivo
    private static void salvarRegistros(List<Funcionario> funcionarios) {
        try (ObjectOutputStream objetoStream = new ObjectOutputStream(new FileOutputStream("funcionarios.dat"))) {
            objetoStream.writeObject(funcionarios);
            System.out.println("Registros de funcionários salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para adicionar um novo funcionário
    private static void adicionarFuncionario(List<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();
        
        Funcionario novoFuncionario = new Funcionario(id, nome, cargo);
        funcionarios.add(novoFuncionario);
        System.out.println("Funcionário adicionado com sucesso.");
    }
    
    // Método para atualizar os detalhes de um funcionário
    private static void atualizarFuncionario(List<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite o ID do funcionário que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número
        
        // Procurar o funcionário pelo ID
        Funcionario funcionario = null;
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                funcionario = f;
                break;
            }
        }
        
        if (funcionario != null) {
            System.out.print("Digite o novo nome do funcionário: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo cargo do funcionário: ");
            String novoCargo = scanner.nextLine();
            
            funcionario.setNome(novoNome);
            funcionario.setCargo(novoCargo);
            System.out.println("Detalhes do funcionário atualizados com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado com o ID fornecido.");
        }
    }
    
    // Método para excluir um funcionário
    private static void excluirFuncionario(List<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite o ID do funcionário que deseja excluir: ");
        int id = scanner.nextInt();
        
        // Procurar o funcionário pelo ID
        Funcionario funcionario = null;
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                funcionario = f;
                break;
            }
        }
        
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            System.out.println("Funcionário excluído com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado com o ID fornecido.");
        }
    }
    
    // Método para exibir todos os funcionários
    private static void exibirFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário registrado.");
        } else {
            System.out.println("Registros de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                funcionario.exibirDetalhes();
                System.out.println(); // Adiciona uma linha em branco entre os funcionários
            }
        }
    }
}
