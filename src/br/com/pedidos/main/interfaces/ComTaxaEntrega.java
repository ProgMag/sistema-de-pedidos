package br.com.pedidos.main.interfaces;

public interface ComTaxaEntrega {

    double calcularTaxaEntrega(double distanciaKm);

    double getDistanciaKm();

    default double calcularValorComTaxa(double valorPedido, double distanciaKm) {
        double taxaEntrega = calcularTaxaEntrega(distanciaKm);
        return taxaEntrega + valorPedido;
    }
}
