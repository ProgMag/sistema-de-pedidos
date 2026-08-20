package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;
import br.com.pedidos.main.interfaces.ComTaxaEntrega;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    static void main() {

        ComDesconto descontoAniversario = valorPedido -> valorPedido * 0.2;
        ComDesconto descontoFidelidade = valorPedido -> valorPedido * 0.05;

        Predicate<Pedido> temTaxaDeEntrega = pedido -> pedido instanceof ComTaxaEntrega;

        Function<Pedido, String> formatarResumo = pedido ->
                "Resumo: #%d - Nome: %s - valor: R$ %.2f".formatted(pedido.getIdPedido(), pedido.getNomeCliente(), pedido.getValorPedido());


        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new PedidoBalcao(1, "Ricardo", 40.99));
        pedidos.add(new PedidoDelivery(2, "Claudio", 32.89, 14.00));

        mostrarComDesconto(pedidos, descontoAniversario, descontoFidelidade);

            if (pedido instanceof ComTaxaEntrega taxa) {
                System.out.printf("""
                        A taxa de entrega é %.2f
                        """, taxa.calcularTaxaEntrega(taxa.getDistanciaKm()));
            } else {
                System.out.print("Seu pedido não se adequa a uma taxa de entrega\n");
            }

            if (temTaxaDeEntrega.test(pedido)) {
                System.out.println("Tem taxa de entrega");
            }

            System.out.println(formatarResumo.apply(pedido));

        }
    }

    public static void mostrarInformacoes(ArrayList<Pedido> pedidos, ComDesconto descontoAniversario, ComDesconto descontoFidelidade, Predicate<Pedido> temTaxaDeEntrega, Function<Pedido, String> formatarResumo) {
        for (Pedido pedido : pedidos) {
            pedido.exibirPedido();
            mostrarComDesconto(pedido, descontoAniversario, descontoFidelidade);
            mostrarComTaxaEntrega(pedido, temTaxaDeEntrega, formatarResumo);

        }
    }

    public static void mostrarComDesconto(Pedido pedido, ComDesconto descontoAniversario, ComDesconto descontoFidelidade) {

        if (pedido instanceof ComDesconto desconto) {

            double valorFinalComAniversario = descontoAniversario.calcularDesconto(pedido.getValorPedido());
            double valorFinalComFidelidade = descontoFidelidade.calcularDesconto(pedido.getValorPedido());

            System.out.printf("""
                    Você teve um desconto de %.2f reais
                    Desconto de aniversário: R$ %.2f
                    Desconto de fidelidade: R$ %.2f
                    """, desconto.calcularDesconto(pedido.getValorPedido()), valorFinalComAniversario, valorFinalComFidelidade);
        } else {
            System.out.print("Você não recebeu desconto\n");
        }
    }

    public static void mostrarComTaxaEntrega(Pedido pedido, Predicate<Pedido> temTaxaDeEntrega, Function<Pedido, String> formatarResumo) {

        if (pedido instanceof ComTaxaEntrega taxa) {
            System.out.printf("""
                    A taxa de entrega é %.2f
                    """, taxa.calcularTaxaEntrega(taxa.getDistanciaKm()));
        } else {
            System.out.print("Seu pedido não se adequa a uma taxa de entrega\n");
        }

        if (temTaxaDeEntrega.test(pedido)) {
            System.out.println("Tem taxa de entrega");
        }

        System.out.println(formatarResumo.apply(pedido));
    }
}