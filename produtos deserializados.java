import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Produto implements Serializable {
    String nome;
    double preco;
    
    
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
    }
}


public class Main {
    public static void main(String[] args) {
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Celular", 999.99));
        produtos.add(new Produto("Notebook", 1499.99));
        produtos.add(new Produto("Fone de Ouvido", 49.99));
        
        try {
            FileOutputStream arquivo = new FileOutputStream("produtos.dat");
            ObjectOutputStream objetoStream = new ObjectOutputStream(arquivo);
            objetoStream.writeObject(produtos);
            objetoStream.close();
            arquivo.close();
            System.out.println("Lista de produtos serializada com sucesso.");
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        
        try {
            FileInputStream arquivo = new FileInputStream("produtos.dat");
            ObjectInputStream objetoStream = new ObjectInputStream(arquivo);
            List<Produto> produtosDeserializados = (List<Produto>) objetoStream.readObject();
            objetoStream.close();
            arquivo.close();
            
            
            for (Produto produto : produtosDeserializados) {
                produto.exibirDetalhes();
                System.out.println(); // Adiciona uma linha em branco entre os produtos
            }
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
