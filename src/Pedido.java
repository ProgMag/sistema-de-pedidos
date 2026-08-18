public abstract class Pedido {

    private int idPedido;
    private String nomeCliente;
    private double valorPedido;

    public Pedido(int idPedido, String nomeCliente, double valorPedido) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.valorPedido = valorPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorPedido() {
        return valorPedido;
    }
}
