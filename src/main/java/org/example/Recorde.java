package org.example;
import java.io.*;

public class Recorde {
    private static final String ARQUIVO = "recorde.txt";
    private String nome;
    private int tentativas;

    public Recorde() {
        carregar();
    }

    public void atualizar(String nome, int tentativas) {
        this.nome = nome;
        this.tentativas = tentativas;
        salvar();
        System.out.println("Recorde salvo: " + nome + " com " + tentativas + " tentativas!");
    }

    public void mostrar() {
        if (tentativas == Integer.MAX_VALUE) {
            System.out.println("Nenhum recorde ainda.");
        } else {
            System.out.println("Recorde: " + nome + " com " + tentativas + " tentativas.");
        }
    }

    public int getTentativas() {
        return tentativas;
    }

    private void carregar() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha = br.readLine();
            if (linha != null) {
                String[] partes = linha.split(";");
                nome = partes[0];
                tentativas = Integer.parseInt(partes[1]);
            }
        } catch (IOException e) {
            nome = "Ninguém";
            tentativas = Integer.MAX_VALUE;
        }
    }

    private void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            bw.write(nome + ";" + tentativas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}