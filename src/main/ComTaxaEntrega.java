package main;

public interface ComTaxaEntrega {

    double calcularTaxaEntrega(double distanciaKm);

    default double calcularValoComTaxa(double valorPedido, double distanciaKm) {
        double taxaEntrega = calcularTaxaEntrega(distanciaKm);
        return taxaEntrega + valorPedido;
    }
}
