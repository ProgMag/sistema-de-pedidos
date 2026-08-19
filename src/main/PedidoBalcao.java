package main;

public class PedidoBalcao extends Pedido implements ComDesconto{

    public PedidoBalcao(int idPedido, String nomeCliente, double valorPedido) {
        super(idPedido, nomeCliente, valorPedido);
    }

    @Override
    public double calcularDesconto(double valorPedido) {
        return valorPedido * 0.08;
    }

    @Override
    public double calcularValorFinal() {
        return calcularValorComDesconto(getValorPedido());
    }
}
