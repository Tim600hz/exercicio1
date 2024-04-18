import java.io.*;

// Definindo a classe ContaBancaria
class ContaBancaria implements Serializable {
    private static final long serialVersionUID = 1L; // Adicionando número de versão
    private String titular;
    private double saldo;
    
    // Construtor
    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    
    // Método para atualizar o saldo
    public void atualizarSaldo(double valor) {
        saldo += valor;
    }
    
    // Método para exibir os detalhes da conta
    public void exibirDetalhes() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        // Deserializando o objeto ContaBancaria do arquivo
        ContaBancaria conta = null;
        try {
            FileInputStream arquivo = new FileInputStream("conta.dat");
            ObjectInputStream objetoStream = new ObjectInputStream(arquivo);
            conta = (ContaBancaria) objetoStream.readObject();
            objetoStream.close();
            arquivo.close();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Atualizando o saldo
        if (conta != null) {
            conta.atualizarSaldo(100.0); // Por exemplo, adicionando 100 ao saldo
            
            // Serializando o objeto atualizado de volta ao arquivo
            try {
                FileOutputStream arquivo = new FileOutputStream("conta.dat");
                ObjectOutputStream objetoStream = new ObjectOutputStream(arquivo);
                objetoStream.writeObject(conta);
                objetoStream.close();
                arquivo.close();
                System.out.println("Conta atualizada e serializada com sucesso.");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
