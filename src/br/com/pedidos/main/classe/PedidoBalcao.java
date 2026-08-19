package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;

public class PedidoBalcao extends Pedido implements ComDesconto {

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

    @Override
    public void exibirPedido() {
        super.exibirPedido();
        System.out.printf("""
                Valor final do pedido : R$ %.2f
                """, calcularValorFinal());
    }
}
