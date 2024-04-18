import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Venda {
    private String data;
    private double valor;
    private String produto;

    
    public Venda(String data, double valor, String produto) {
        this.data = data;
        this.valor = valor;
        this.produto = produto;
    }

    
    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }
}

public class Main {
    public static void main(String[] args) {
        
        List<Venda> vendas = criarListaVendas();

        
        exportarVendasParaCSV(vendas);
    }

    
    private static List<Venda> criarListaVendas() {
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-20", 100.0, "Produto A"));
        vendas.add(new Venda("2024-04-21", 150.0, "Produto B"));
        vendas.add(new Venda("2024-04-22", 200.0, "Produto C"));
        return vendas;
    }

  
    private static void exportarVendasParaCSV(List<Venda> vendas) {
       
        String nomeArquivo = "vendas.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
           
            writer.writeNext(new String[]{"Data", "Valor", "Produto"});


            for (Venda venda : vendas) {
                writer.writeNext(new String[]{venda.getData(), String.valueOf(venda.getValor()), venda.getProduto()});
            }

            System.out.println("Vendas exportadas para o arquivo " + nomeArquivo + " com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
