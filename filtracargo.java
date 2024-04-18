import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

   
    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: " + salario);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        
        String nomeArquivo = "funcionarios.csv";

        
        Scanner scanner = new Scanner(System.in);

        
        List<Funcionario> funcionarios = lerFuncionarios(nomeArquivo);

        
        System.out.println("Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirDetalhes();
        }

        
        System.out.println("Filtrar funcionários por critérios:");
        System.out.println("1. Cargo");
        System.out.println("2. Salário mínimo");
        System.out.print("Escolha o critério de filtro: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        
        switch (opcao) {
            case 1:
                filtrarPorCargo(funcionarios, scanner);
                break;
            case 2:
                filtrarPorSalarioMinimo(funcionarios, scanner);
                break;
            default:
                System.out.println("Opção inválida. Nenhum filtro aplicado.");
        }

        
        scanner.close();
    }

    
    private static List<Funcionario> lerFuncionarios(String nomeArquivo) {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            List<String[]> linhas = reader.readAll();

            
            for (int i = 1; i < linhas.size(); i++) { 
                String[] linha = linhas.get(i);
                String nome = linha[0];
                String cargo = linha[1];
                double salario = Double.parseDouble(linha[2]);
                Funcionario funcionario = new Funcionario(nome, cargo, salario);
                funcionarios.add(funcionario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    
    private static void filtrarPorCargo(List<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite o cargo para filtrar: ");
        String cargo = scanner.nextLine();

        System.out.println("Funcionários com o cargo de " + cargo + ":");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().equalsIgnoreCase(cargo)) {
                funcionario.exibirDetalhes();
            }
        }
    }

    
    private static void filtrarPorSalarioMinimo(List<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite o salário mínimo para filtrar: ");
        double salarioMinimo = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Funcionários com salário maior ou igual a " + salarioMinimo + ":");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() >= salarioMinimo) {
                funcionario.exibirDetalhes();
            }
        }
    }
}
