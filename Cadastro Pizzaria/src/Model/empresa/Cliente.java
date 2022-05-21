package Model.empresa;

import Model.infos.Pessoa;

public class Cliente extends Pessoa {
    /**
     * media de consumo
     * enviar desconto para consumo acima de X
     * total de pedidos
     */
    private int totalGasto;
    private int tempoAfiliado;
    private String ultimoPedido;
    private int valorDoUltimoPedido;
}
