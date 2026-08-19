package br.com.pedidos.main.interfaces;

public interface ComDesconto {

    double calcularDesconto(double valorPedido);

    default double calcularValorComDesconto(double valorPedido) {
        double desconto = calcularDesconto(valorPedido);
        return valorPedido - desconto;
    }
}
