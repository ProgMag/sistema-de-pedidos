package br.com.pedidos.main.interfaces;

@FunctionalInterface
public interface ComDesconto {

    double calcularDesconto(double valorPedido);

    default double calcularValorComDesconto(double valorPedido) {
        double desconto = calcularDesconto(valorPedido);
        return valorPedido - desconto;
    }
}
