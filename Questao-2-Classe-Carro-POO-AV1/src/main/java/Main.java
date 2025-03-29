import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Informe o ano atual: ");

    int anoAtual = scanner.nextInt();

    Carro[] carros = new Carro[5];

    int totalImpostos = 0;
    int carrosIsentos = 0;

    for (int i = 0; i < 5; i++) {

      System.out.print("Informe a placa do carro " + (i + 1) + ": ");
      String placa = scanner.next();
      System.out.print("Informe o ano de fabricação do carro " + (i + 1) + ": ");
      int anoFabricacao = scanner.nextInt();

      carros[i] = new Carro(placa, anoFabricacao);

    }

    System.out.println("\nResumo dos Impostos:");

    for (Carro carro : carros) {

      System.out.println("Carro " + carro.getPlaca() + " (Ano: " + carro.getAnoFabricacao() + ")");
      int totalPago = 0;
      boolean isentoMostrado = false;



      for (int ano = carro.getAnoFabricacao(); ano <= anoAtual; ano++) {
        int imposto = carro.calcularImposto(ano);
        if (imposto == 0 && !isentoMostrado) {
          System.out.println("Ano " + ano + " em diante - Imposto: R$ 0 (Isento)");
          isentoMostrado = true;
        } else if (imposto > 0) {
          System.out.println("Ano " + ano + " - Imposto: R$ " + imposto);
          totalPago += imposto;

        }

      }

      System.out.println("Total pago pelo carro: R$ " + totalPago + "\n");
      totalImpostos += totalPago;

      if (isentoMostrado) {
        carrosIsentos++;

      }

    }

    System.out.println("Total de impostos arrecadados: R$ " + totalImpostos);
    System.out.println("Quantidade de carros isentos: " + carrosIsentos);

    scanner.close();

  }
}

