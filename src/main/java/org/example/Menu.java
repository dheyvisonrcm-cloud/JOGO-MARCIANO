package org.example;


import java.util.Scanner;

public class Menu {
    private Scanner leia = new Scanner(System.in);
    private Jogo jogo = new Jogo(leia);
    private Recorde recorde = new Recorde();

    public void iniciar() {
        int opcao = 0;
        do {
            System.out.println("\n===== JOGO DO MARCIANO =====");
            System.out.println("1 - Jogar");
            System.out.println("2 - Ver recorde");
            System.out.println("3 - Lore e Regras do game");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    int tentativas = jogo.jogar();
                    if (jogo.acertou() && tentativas < recorde.getTentativas()) {
                        System.out.print("Novo recorde! Digite seu nome: ");
                        String nome = leia.next();
                        recorde.atualizar(nome, tentativas);
                    }
                    break;
                case 2:
                    recorde.mostrar();
                    break;
                case 3:
                    String regras = """
                            Em um planeta rochoso e poroso, com gases vermelhos, um pequeno marciano entrou numa nave espacial.
                            Após muitos meses de viagem, ele chegou ao nosso planeta.
                            Claro, que ele ficou maravilhado com tanta árvore e biologia. Porém, ficou embasbacado com a burrice humana.
                            Portanto, ele está se escondendo em árvores.
                            Seu dever é achar ele.
                            REGRAS:
                            1 - Caso você escolha uma dificuldade, só poderá mudar DEPOIS que começar uma nova partida.
                            2 - Recordes são salvos.
                            3 - não use hack, seja honesto
                            """;
                    System.out.println(regras);
                        break;
                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }
        } while (opcao != 4);
    }
}