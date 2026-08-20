package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;
import br.com.pedidos.main.interfaces.ComTaxaEntrega;

import java.util.ArrayList;

public class Main {
    static void main() {

        ComDesconto valorFinalComAniversario = valorPedido -> valorPedido * 0.2;
        ComDesconto valorFinalComFidelidade = valorPedido -> valorPedido * 0.05;

        System.out.printf("");

        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new PedidoBalcao(1, "Ricardo", 40.99));
        pedidos.add(new PedidoDelivery(2, "Claudio", 32.89, 14.00));

        for (Pedido pedido : pedidos) {
            pedido.exibirPedido();

            double valorFinalComAniversario = descontoAniversario.calcularDesconto(pedido.getValorPedido());
            double valorFinalComFidelidade = descontoFidelidade.calcularDesconto(pedido.getValorPedido());

            if (pedido instanceof ComDesconto desconto) {
                System.out.printf("""
                        Você teve um desconto de %.2f reais
                        Desconto de aniversário: R$ %.2f
                        Desconto de fidelidade: R$ %.2f
                        """, desconto.calcularDesconto(pedido.getValorPedido()), valorFinalComAniversario, valorFinalComFidelidade);
            } else {
                System.out.print("Você não recebeu desconto\n");
            }

            if (pedido instanceof ComTaxaEntrega taxa) {
                System.out.printf("""
                        A taxa de entrega é %.2f
                        """, taxa.calcularTaxaEntrega(taxa.getDistanciaKm()));
            } else {
                System.out.print("Seu pedido não se adequa a uma taxa de entrega\n");
            }
        }
    }
}