package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;
import br.com.pedidos.main.interfaces.ComTaxaEntrega;

public class PedidoDelivery extends Pedido implements ComDesconto, ComTaxaEntrega {

    public PedidoDelivery(int idPedido, String nomeCliente, double valorPedido) {
        super(idPedido, nomeCliente, valorPedido);
    }
}
