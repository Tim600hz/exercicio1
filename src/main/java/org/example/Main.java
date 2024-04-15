package org.example;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] text = {"Hello World"};
        try {
            File Arquivo = new File("Arquivo.txt");
            System.out.println("Arquivo criado!");
            FileWriter fileReader = new FileWriter(Arquivo); // A stream that connects to the text file
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // Connect the FileWriter to the BufferedWriter
            System.out.println("Programado o escritor de arquivo");
            for (String s : text) {
                bufferedWriter.write(s + "\n");
            }
            System.out.println(" Arquivo gravado com sucesso");

            bufferedWriter.close (); // Close the stream
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
