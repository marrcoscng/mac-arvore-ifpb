package macifpb;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> arvore = new BinarySearchTree<>();

        /*
         * Montando a seguinte árvore:
         *
         *          50
         *        /    \
         *      30      70
         *     /  \    /  \
         *   20   40  60  80
         */

        System.out.println("Inserindo valores: 50, 30, 70, 20, 40, 60, 80...\n");

        arvore.insert(50);
        arvore.insert(30);
        arvore.insert(70);
        arvore.insert(20);
        arvore.insert(40);
        arvore.insert(60);
        arvore.insert(80);

        // 1. Exibição Visual no Terminal
        arvore.printTree();

        // 2. Testando Percursos
        System.out.println("--- PERCURSOS ---");
        arvore.inOrder();   // Deve imprimir em ordem crescente (20 30 40 50 60 70 80)
        arvore.preOrder();  // Raiz primeiro (50 30 20 40 70 60 80)
        arvore.postOrder(); // Filhos primeiro, raiz por último (20 40 30 60 80 70 50)

        // 3. Teste de Validação de Duplicado (Opcional)
        try {
            System.out.println("\nTentando inserir valor duplicado (30)...");
            arvore.insert(30);
        } catch (Exception e) {
            System.out.println("Sucesso no tratamento! Exceção capturada: " + e.getMessage());
        }
    }
}