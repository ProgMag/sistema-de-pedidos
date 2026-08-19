# Sistema de Pedidos (Restaurante/Delivery)
 
Projeto de estudo em Java, focado em **Programação Orientada a Objetos** com ênfase em:
- Classes abstratas
- Interfaces com métodos `default`
- Interface Segregation Principle (ISP)
- Polimorfismo com `instanceof` (pattern matching)
> **Nota:** este projeto foi desenhado propositalmente para, no futuro, servir de base ao estudo de **integração com banco de dados** (JDBC). O campo `idPedido` já simula o papel de uma futura chave primária.
 
---
 
## Estrutura do projeto
 
```
br.com.pedidos.main.classe
├── Pedido.java            (classe abstrata)
├── PedidoBalcao.java      (implements ComDesconto)
├── PedidoDelivery.java    (implements ComTaxaEntrega)
└── Main.java
 
br.com.pedidos.main.interfaces
├── ComDesconto.java
└── ComTaxaEntrega.java
```
 
---
 
## Modelagem
 
### Classe abstrata `Pedido`
Contém o estado comum a **todo** pedido, independente do tipo:
 
| Atributo       | Tipo    | Descrição                                   |
|----------------|---------|----------------------------------------------|
| `idPedido`     | `int`   | Identificador único do pedido                |
| `nomeCliente`  | `String`| Nome do cliente                              |
| `valorPedido`  | `double`| Valor bruto do pedido (sem desconto/taxa)    |
 
Define o método abstrato `calcularValorFinal()`, que cada subclasse implementa de forma diferente.
 
### Interface `ComDesconto`
```java
double calcularDesconto(double valorPedido);
default double calcularValorComDesconto(double valorPedido);
```
Aplicada apenas a `PedidoBalcao`. Representa um incentivo comercial: quem retira o pedido no balcão economiza o custo de entrega do restaurante, então recebe desconto.
 
### Interface `ComTaxaEntrega`
```java
double calcularTaxaEntrega(double distanciaKm);
double getDistanciaKm();
default double calcularValorComTaxa(double valorPedido, double distanciaKm);
```
Aplicada apenas a `PedidoDelivery`. O cálculo depende da **distância percorrida**, não do valor do pedido — por isso o parâmetro é `distanciaKm`. O getter `getDistanciaKm()` existe para que código externo (como a `Main`), que só enxerga o objeto pelo tipo da interface, consiga acessar esse dado sem precisar de cast para a classe concreta.
 
---
 
## Regras de negócio
 
| Tipo de pedido    | Desconto | Taxa de entrega       |
|-------------------|----------|------------------------|
| `PedidoBalcao`    | 8% sobre o valor do pedido | — |
| `PedidoDelivery`  | — | R$ 2,50 por km percorrido |
 
As duas capacidades (`ComDesconto` e `ComTaxaEntrega`) são **mutuamente exclusivas** neste projeto: não faz sentido de negócio dar desconto de retirada para quem está recebendo em casa.
 
---
 
## Decisões de design (ISP)
 
- `PedidoBalcao` **não** implementa `ComTaxaEntrega`, e `PedidoDelivery` **não** implementa `ComDesconto`. Cada classe só implementa as interfaces que representam capacidades **reais** dela — evitando métodos "vazios" ou que retornariam `0.0` sem propósito real.
- O `Main` verifica capacidades via `instanceof` contra a **interface**, nunca contra a classe concreta — isso mantém o código desacoplado: se um novo tipo de pedido (ex: `PedidoRetiradaExpressa`) surgir no futuro e implementar `ComDesconto`, o `Main` já vai lidar com ele automaticamente, sem precisar de alteração.
---
 
## Sobre o `idPedido` (pensando em banco de dados)
 
O `idPedido` é recebido **de fora**, via construtor — o objeto `Pedido` não gera esse número sozinho (ex: com um contador estático interno). Essa escolha é proposital: em um sistema com banco de dados, normalmente é a própria base de dados a responsável por gerar identificadores únicos e sem conflito. Fazer o objeto Java "decidir" esse valor internamente criaria um conflito de responsabilidade quando a persistência entrar em cena.
 
---
 
## Como executar
 
```bash
cd src
javac br/com/pedidos/main/classe/*.java br/com/pedidos/main/interfaces/*.java
java br.com.pedidos.main.classe.Main
```
