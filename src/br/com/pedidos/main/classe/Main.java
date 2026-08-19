package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;
import br.com.pedidos.main.interfaces.ComTaxaEntrega;

import java.util.ArrayList;

public class Main {
    static void main() {

        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new PedidoBalcao(1, "Ricardo", 40.99));
        pedidos.add(new PedidoDelivery(2, "Claudio", 32.89, 14));

        for (Pedido pedido : pedidos) {
            pedido.exibirPedido();

            if (pedido instanceof ComDesconto desconto) {
                System.out.printf("""
                        Você teve um desconto de %.2f reais
                        """, desconto.calcularDesconto(pedido.getValorPedido()));
            } else {
                System.out.print("Você não recebeu desconto\n");
            }

            if (pedido instanceof ComTaxaEntrega taxa) {
                System.out.printf("""
                        A taxa de entrega é %.2f
                        """, taxa.calcularTaxaEntrega(pedido.getValorPedido()));
            } else {
                System.out.print("Seu pedido não se adequa a uma taxa de entrega\n");
            }
        }
    }
}