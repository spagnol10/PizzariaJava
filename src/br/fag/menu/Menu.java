package br.fag.menu;

import br.fag.pagamentos.Pagamentos;
import br.fag.produtos.pizzaSabores.Sabores;
import br.fag.produtos.tamanho.EnumTamanho;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static int totalPizza;
    private static double valorPizza;

    private static double somaPizza;
    private static Scanner sc;

    public Menu() {
    }

    public void Cardapio() throws InterruptedException {

        sc = new Scanner(System.in);
        int opcao;
        int valorDeCadaPizza = 0;
        int tamanho = 0;
        int pizza = 0;
        totalPizza = 0;
        somaPizza = 0;
        String continuar;

        //TIPO-PEDIDO
            System.out.println("=========== CATALOGO ===========");
            System.out.println("[0]- Pequena -->  1 Sabor");
            System.out.println("[1]- Grande  -->  2 Sabor");
            System.out.println("[2]- Gigante -->  3 Sabor");
            System.out.println("Escolha o tamanho da sua Pizza:");
            tamanho = sc.nextInt();
            System.out.println(EnumTamanho.values()[tamanho]);

            //########### CARDAPIO-PIZZA ###########
            System.out.println("Escolha o sabor da sua pizza!");
            for (Sabores s : Sabores.values()) {
                System.out.println(s.ordinal() + "-" + "Sabor: " + s.name() + ": $" + s.getPreco());
            }

            int[] saboresSelecionados = new int[3];

            int tamanhoSelecionado = List.of(EnumTamanho.values()).get(tamanho).getQuantidadesDesabor();

            for (int i = 0; i <= tamanho; i++) {
                System.out.println("Digite o número da pizza que você quer:");
                pizza = sc.nextInt();
                saboresSelecionados[i] = pizza;
                System.out.println(Sabores.values()[pizza]);
            }
            System.out.println("=========================================");
            System.out.println("Você está pedindo 1 pizza ");
            System.out.println("Tamanho " + EnumTamanho.values()[tamanho]);

            System.out.println("========= Sabores ========= ");
            for (int i = 0; i <= tamanho; i++) {
                Sabores listaDosSaboresSelecionados = Sabores.values()[saboresSelecionados[i]];
                System.out.println(listaDosSaboresSelecionados);
                somaPizza += listaDosSaboresSelecionados.getPreco();
            }
                System.out.println("===============" + somaPizza);
                totalPizza = (int) somaPizza / (tamanho);

                Pagamentos.telaInicialPagamentos();
    }

    public static int getValorPizza() {
        return totalPizza;
    }

}
