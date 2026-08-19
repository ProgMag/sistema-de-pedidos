package br.com.pedidos.main.classe;

import br.com.pedidos.main.interfaces.ComDesconto;
import br.com.pedidos.main.interfaces.ComTaxaEntrega;

public class PedidoDelivery extends Pedido implements ComTaxaEntrega {

    private double distanciaKm;

    public PedidoDelivery(int idPedido, String nomeCliente, double valorPedido, double distanciaKm) {
        super(idPedido, nomeCliente, valorPedido);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularTaxaEntrega(double distanciaKm) {
        return 2.50 * distanciaKm;
    }

    @Override
    public double calcularValorFinal() {
        return calcularValoComTaxa(getValorPedido(), distanciaKm);
    }

    @Override
    public void exibirPedido() {
        super.exibirPedido();
        System.out.printf("""
                Valor final do pedido : R$ %.2f
                """, calcularValorFinal());
    }
}
