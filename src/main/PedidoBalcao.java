package main;

public class PedidoBalcao extends Pedido implements ComDesconto{

    @Override
    public double calcularDesconto(double valorPedido) {
        return valorPedido * 0.08;
    }
}
