import java.io.*;


class Pessoa implements Serializable {
    String nome;
    int idade;
    
  
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}


public class Main {
    public static void main(String[] args) {
        
        try {
            FileInputStream arquivo = new FileInputStream("pessoa.dat");
            ObjectInputStream objetoStream = new ObjectInputStream(arquivo);
            Pessoa pessoa = (Pessoa) objetoStream.readObject();
            objetoStream.close();
            arquivo.close();
            
            
            pessoa.exibirDetalhes();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
