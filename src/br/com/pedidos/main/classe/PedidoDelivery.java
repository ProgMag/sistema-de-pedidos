package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;
import br.com.pedidos.main.interfaces.ComTaxaEntrega;

public class PedidoDelivery extends Pedido implements ComDesconto, ComTaxaEntrega {

    private double distanciaKm;

    public PedidoDelivery(int idPedido, String nomeCliente, double valorPedido) {
        super(idPedido, nomeCliente, valorPedido);
    }

    @Override
    public double calcularTaxaEntrega(double distanciaKm) {
        return 2.50 * distanciaKm;
    }

    @Override
    public double calcularValorFinal() {
        return calcularValoComTaxa(getValorPedido(), distanciaKm);
    }
}
