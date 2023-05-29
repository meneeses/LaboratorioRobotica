import java.util.ArrayList;
import java.util.List;

public class Robo {
  public final List<Peca> pecasUtilizadas;
  public double custoTotal;

  public Robo() {
      pecasUtilizadas = new ArrayList<>();
      custoTotal = 0;
  }

  public void adicionarPeca(Peca peca) {
      pecasUtilizadas.add(peca);
      custoTotal += peca.getValorUnitario();
  }

  public void mostrarPecasUtilizadas() {
      System.out.println("Pecas utilizadas no robo:");
      for (Peca peca : pecasUtilizadas) {
          System.out.println(peca.getItem());
      }
  }

  public double getCustoTotal() {
      return custoTotal;
  }
}
