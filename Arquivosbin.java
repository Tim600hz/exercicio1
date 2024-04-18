import java.io.*;

class Pessoa implements Serializable {
    String nome;
    int idade;
    
  
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}


public class Main {
    public static void main(String[] args) {
        
        Pessoa pessoa = new Pessoa("João", 30);
        
        
        try {
            FileOutputStream arquivo = new FileOutputStream("pessoa.dat");
            ObjectOutputStream objetoStream = new ObjectOutputStream(arquivo);
            objetoStream.writeObject(pessoa);
            objetoStream.close();
            arquivo.close();
            System.out.println("Objeto Pessoa serializado com sucesso.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
