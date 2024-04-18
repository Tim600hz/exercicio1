package org.example;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] text = {"Hello World"};
        try {
            File Arquivo = new File("Arquivo.txt");
            System.out.println("Arquivo criado!");
            FileWriter fileReader = new FileWriter(Arquivo); 
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
            System.out.println("Programado o escritor de arquivo");
            for (String s : text) {
                bufferedWriter.write(s + "\n");
            }
            System.out.println(" Arquivo gravado com sucesso");

            bufferedWriter.close (); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
