package br.com.pedidos.main.interfaces;

public interface ComTaxaEntrega {

    double calcularTaxaEntrega(double distanciaKm);

    default double calcularValoComTaxa(double valorPedido, double distanciaKm) {
        double taxaEntrega = calcularTaxaEntrega(distanciaKm);
        return taxaEntrega + valorPedido;
    }
}
