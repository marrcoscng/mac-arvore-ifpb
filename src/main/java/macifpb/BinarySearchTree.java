package macifpb;

public class BinarySearchTree {
    private Node raiz;

    public void inserir(int id, String descricao, OpcaoMenu acao) {
        raiz = inserirRecursivo(raiz, id, descricao, acao);
    }

    private Node inserirRecursivo(Node atual, int id, String descricao, OpcaoMenu acao) {
        if (atual == null) {
            return new Node(id, descricao, acao);
        }
        if (id < atual.id) {
            atual.esquerda = inserirRecursivo(atual.esquerda, id, descricao, acao);
        } else if (id > atual.id) {
            atual.direita = inserirRecursivo(atual.direita, id, descricao, acao);
        }
        return atual;
    }

    public Node buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Node buscarRecursivo(Node atual, int id) {
        if (atual == null || atual.id == id) {
            return atual;
        }
        if (id < atual.id) {
            return buscarRecursivo(atual.esquerda, id);
        }
        return buscarRecursivo(atual.direita, id);
    }

    // Exibe os nós ordenados pelo ID (Travessia Em-Ordem)
    public void exibirMenuEmOrdem() {
        exibirEmOrdemRecursivo(raiz);
    }

    private void exibirEmOrdemRecursivo(Node node) {
        if (node != null) {
            exibirEmOrdemRecursivo(node.esquerda);
            System.out.println("[" + node.id + "] " + node.descricao);
            exibirEmOrdemRecursivo(node.direita);
        }
    }

    // Método público para iniciar a impressão gráfica da árvore
    public void desenharArvore() {
        System.out.println("\n--- ESTRUTURA VISUAL DA ÁRVORE (BST) ---");
        desenharArvoreRecursivo(raiz, "", true);
        System.out.println("----------------------------------------");
    }

    // Algoritmo recursivo para desenhar as ramificações
    private void desenharArvoreRecursivo(Node no, String prefixo, boolean ehUltimo) {
        if (no != null) {
            System.out.print(prefixo);
            System.out.print(ehUltimo ? "└── " : "├── ");
            System.out.println("[" + no.id + "] " + no.descricao);

            // Monta o caractere de ramificação dependendo da posição do nó pai
            String novoPrefixo = prefixo + (ehUltimo ? "    " : "│   ");

            // Define se há subárvores
            boolean temEsquerda = (no.esquerda != null);
            boolean temDireita = (no.direita != null);

            if (temEsquerda || temDireita) {
                if (temEsquerda) {
                    desenharArvoreRecursivo(no.esquerda, novoPrefixo, !temDireita);
                }
                if (temDireita) {
                    desenharArvoreRecursivo(no.direita, novoPrefixo, true);
                }
            }
        }
    }
}