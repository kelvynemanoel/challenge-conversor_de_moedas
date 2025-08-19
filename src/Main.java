import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Conversor de Moedas ===");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Dólar (USD) -> Real (BRL)");
        System.out.println("2 - Real (BRL) -> Dólar (USD)");
        System.out.println("3 - Euro (EUR) -> Real (BRL)");
        System.out.println("4 - Real (BRL) -> Euro (EUR)");
        System.out.println("5 - Dólar (USD) -> Euro (EUR)");
        System.out.println("6 - Euro (EUR) -> Dólar (USD)");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();

        System.out.print("Digite o valor a ser convertido: ");
        double valor = sc.nextDouble();

        String from = "";
        String to = "";

        switch (opcao) {
            case 1 -> { from = "USD"; to = "BRL"; }
            case 2 -> { from = "BRL"; to = "USD"; }
            case 3 -> { from = "EUR"; to = "BRL"; }
            case 4 -> { from = "BRL"; to = "EUR"; }
            case 5 -> { from = "USD"; to = "EUR"; }
            case 6 -> { from = "EUR"; to = "USD"; }
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        double taxa = ConversorMoedas.getTaxa(from, to);

        if (taxa > 0) {
            double convertido = valor * taxa;
            System.out.printf("%.2f %s = %.2f %s%n", valor, from, convertido, to);
        } else {
            System.out.println("Não foi possível realizar a conversão.");
        }

        sc.close();
    }
}