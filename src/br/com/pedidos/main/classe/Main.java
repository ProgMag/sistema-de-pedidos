package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;
import br.com.pedidos.main.interfaces.ComTaxaEntrega;

import java.util.ArrayList;

public class Main {
    static void main() {

        PedidoDelivery delivery = new PedidoDelivery(2, "Guilherme", 83, 12);
        delivery.exibirPedido();
    }
}