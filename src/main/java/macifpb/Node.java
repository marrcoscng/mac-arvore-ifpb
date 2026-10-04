package macifpb;

public class Node {
    int id;
    String descricao;
    OpcaoMenu acao;
    Node esquerda;
    Node direita;

    public Node(int id, String descricao, OpcaoMenu acao) {
        this.id = id;
        this.descricao = descricao;
        this.acao = acao;
        this.esquerda = null;
        this.direita = null;
    }
}
