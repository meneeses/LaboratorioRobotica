public class Peca {
  public final String item;
    public int quantidade;
    public final double valorUnitario;

    public Peca(String identificacao, int quantidade, double valorUnitario) {
        this.item = identificacao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void decrementarQuantidade(int quantidadeUtilizada) {
        quantidade -= quantidadeUtilizada;
    }

}
