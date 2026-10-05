package org.example;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Scanner leia;
    private Random random = new Random();
    private boolean acertou = false;

    public Jogo(Scanner leia) {
        this.leia = leia;
    }

    public int jogar() {
        System.out.println("\n--- INTRODUÇÃO ---");
        System.out.println("O marciano está escondido em uma árvore de 1 a 100.");
        System.out.println("Descubra em qual árvore ele está!");

        String levelS = """
                Escolha o seu nível de dificuldade:
                Nível Fácil: [F]
                Nível Médio: [M]
                Nível Difícil: [D]
               
                """;
        System.out.println(levelS);
        System.out.print("Opção: ");
        char nivel = leia.next().toUpperCase().charAt(0);

        int maxTentativas = 10;
        switch (nivel) {
            case 'D': maxTentativas = 7; break;
            case 'M': maxTentativas = 8; break;
            case 'F': maxTentativas = 10; break;
        }

        int numeroSorteado = random.nextInt(100) + 1;
        int tentativas = 0;
        acertou = false;

        while (tentativas < maxTentativas && !acertou) {
            System.out.print("Digite o número da árvore (1 a 100): ");
            int palpite = leia.nextInt();
            tentativas++;

            if (palpite == numeroSorteado) {
                System.out.println("Parabéns! Acertou em " + tentativas + " tentativas!");
                acertou = true;
            } else if (palpite < numeroSorteado) {
                System.out.println("O marciano está em uma árvore MAIOR.");
            } else {
                System.out.println("O marciano está em uma árvore MENOR.");
            }
        }

        if (!acertou) {
            System.out.println("Perdeu, irmão! O marciano estava na árvore " + numeroSorteado + ". Da próxima vez, " +
                    "se atente mais as dicas.");
        }

        return tentativas;
    }

    public boolean acertou() {
        return acertou;
    }
}