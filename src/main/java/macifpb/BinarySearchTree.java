package macifpb;

import java.util.DuplicateFormatFlagsException;

public class BinarySearchTree <T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(T no){
        if(root == null){
            root = new Node<>(no);
        }else {
            insertRecursive(root, no);
        }
    }

    // nodeCurrent -> nó atual
    private void insertRecursive(Node<T> nodeCurrent, T value){

        int decision = value.compareTo(nodeCurrent.getValue());

        if(decision > 0){
            if(nodeCurrent.getRight() != null){
                insertRecursive(nodeCurrent.getRight(),value);
            }else{
                nodeCurrent.setRight(new Node<>(value));
            }
        }
        else if(decision < 0){
            if(nodeCurrent.getLeft() != null){
                insertRecursive(nodeCurrent.getLeft(),value);
            }else{
                nodeCurrent.setLeft(new Node<>(value));
            }
        }
        else{
            throw new DuplicateFormatFlagsException("Duplicate value null");
        }

    }

    private void fileTree(Node<T> root){
        if(this.root == null){
            System.out.println("Null");
        }
        fileTree(root.getLeft());
        fileTree(root.getRight());
    }


    // ==================== CAMINHAMENTOS ====================

    // 1. Em-Ordem (In-Order): Esquerda -> Raiz -> Direita (Exibe os dados ORDENADOS)
    public void inOrder() {
        System.out.print("Em-Ordem (In-Order): ");
        inOrderRecursive(this.root);
        System.out.println();
    }

    private void inOrderRecursive(Node<T> nodeCurrent) {
        if (nodeCurrent != null) {
            inOrderRecursive(nodeCurrent.getLeft());
            System.out.print(nodeCurrent.getValue() + " | ");
            inOrderRecursive(nodeCurrent.getRight());
        }
    }

    // 2. Pré-Ordem (Pre-Order): Raiz -> Esquerda -> Direita
    public void preOrder() {
        System.out.print("Pré-Ordem (Pre-Order): ");
        preOrderRecursive(this.root);
        System.out.println();
    }

    private void preOrderRecursive(Node<T> nodeCurrent) {
        if (nodeCurrent != null) {
            System.out.print(nodeCurrent.getValue() + " | ");
            preOrderRecursive(nodeCurrent.getLeft());
            preOrderRecursive(nodeCurrent.getRight());
        }
    }

    // 3. Pós-Ordem (Post-Order): Esquerda -> Direita -> Raiz
    public void postOrder() {
        System.out.print("Pós-Ordem (Post-Order): ");
        postOrderRecursive(this.root);
        System.out.println();
    }

    private void postOrderRecursive(Node<T> nodeCurrent) {
        if (nodeCurrent != null) {
            postOrderRecursive(nodeCurrent.getLeft());
            postOrderRecursive(nodeCurrent.getRight());
            System.out.print(nodeCurrent.getValue() + " | ");
        }
    }

// ==================== IMPRESSÃO VISUAL ====================

    // Desenha a árvore em formato hierárquico no terminal
    public void printTree() {
        System.out.println("\n--- ESTRUTURA DA ÁRVORE ---");
        printTreeRecursive(this.root, "", true);
        System.out.println("---------------------------\n");
    }

    private void printTreeRecursive(Node<T> nodeCurrent, String indent, boolean isRight) {
        if (nodeCurrent != null) {
            printTreeRecursive(nodeCurrent.getRight(), indent + (isRight ? "        " : " |      "), true);
            System.out.print(indent);
            if (isRight) {
                System.out.print(" /");
            } else {
                System.out.print(" \\");
            }
            System.out.print("----- ");
            System.out.println(nodeCurrent.getValue());
            printTreeRecursive(nodeCurrent.getLeft(), indent + (isRight ? " |      " : "        "), false);
        }
    }



}
