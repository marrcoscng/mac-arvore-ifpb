package macifpb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instanciando cliente e conta de teste
        Cliente cliente = new Cliente("Marcos Silva", "", "");
        Conta conta = new Conta("12345-6", 1000.00);

        // Construção da BST
        BinarySearchTree menuTree = new BinarySearchTree();

        /*
         * ORDEM DE INSERÇÃO BALANCEADA:
         * Inserir o 3 primeiro define a RAIZ PRINCIPAL no centro do menu.
         * A distribuição abaixo gera uma árvore balanceada com bifurcações à esquerda e direita.
         */

        // [3] RAIZ PRINCIPAL - Ver Extrato
        menuTree.inserir(3, "Ver Extrato", (sc, c, cl) -> {
            c.exibirExtrato();
        });

        // [1] Filha ESQUERDA da Raiz 3 - Sacar Dinheiro
        menuTree.inserir(1, "Sacar Dinheiro", (sc, c, cl) -> {
            System.out.println("\n--- OPERAÇÃO DE SAQUE ---");
            System.out.print("Informe seu CPF: ");
            cl.setCpf(sc.next());
            System.out.print("Informe seu Telefone: ");
            cl.setTelefone(sc.next());

            System.out.print("Informe o valor a sacar: R$ ");
            double valor = sc.nextDouble();

            if (c.sacar(valor)) {
                System.out.printf("Saque efetuado com sucesso! Saldo restante: R$ %.2f\n", c.getSaldo());
            } else {
                System.out.println("Erro: Saldo insuficiente ou valor inválido.");
            }
        });

        // [0] Sair
        menuTree.inserir(0, "Sair", (sc, c, cl) -> {
            System.out.println("\nObrigado por utilizar nossos serviços bancários. Até logo!");

            // Exibe o desenho visual da árvore na memória ao encerrar
            menuTree.desenharArvore();
        });

        // [2] Filha DIREITA do Nó 1 - Depositar Dinheiro
        menuTree.inserir(2, "Depositar Dinheiro", (sc, c, cl) -> {
            System.out.println("\n--- OPERAÇÃO DE DEPÓSITO ---");
            System.out.print("Informe o número da conta destino: ");
            String numConta = sc.next();

            if (numConta.equals(c.getNumeroConta())) {
                System.out.print("Informe o valor a depositar: R$ ");
                double valor = sc.nextDouble();
                c.depositar(valor);
                System.out.printf("Depósito realizado com sucesso! Saldo atual: R$ %.2f\n", c.getSaldo());
            } else {
                System.out.println("Erro: Número de conta não encontrado no sistema.");
            }
        });

        // [5] Filha DIREITA da Raiz 3 - Solicitar Ajuda
        menuTree.inserir(5, "Solicitar Ajuda", (sc, c, cl) -> {
            sc.nextLine(); // Limpa o buffer do scanner
            System.out.println("\n--- SUPORTE AO CLIENTE ---");
            System.out.print("Descreva o problema que você está enfrentando: ");
            String problema = sc.nextLine();
            System.out.println("\nSua mensagem foi enviada: \"" + problema + "\"");
            System.out.println("Em breve entraremos em contato!");
        });

        // [4] Filha ESQUERDA do Nó 5 - Consultar Saldo
        menuTree.inserir(4, "Consultar Saldo", (sc, c, cl) -> {
            System.out.printf("\n--- SALDO ATUAL --- \nR$ %.2f\n", c.getSaldo());
        });

        // Loop principal de navegação pelo menu
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n==================================");
            System.out.println("        BANCO DIGITAL - MENU       ");
            System.out.println("==================================");

            // A travessia Em-Ordem (In-Order) continua exibindo na sequência 0, 1, 2, 3, 4, 5
            menuTree.exibirMenuEmOrdem();

            System.out.print("\nDigite o número da opção desejada: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                Node noEncontrado = menuTree.buscar(opcao);

                if (noEncontrado != null) {
                    noEncontrado.acao.executar(scanner, conta, cliente);
                } else {
                    System.out.println("\nOpção inválida! Escolha um número do menu.");
                }
            } else {
                System.out.println("\nEntrada inválida! Digite apenas números inteiros.");
                scanner.next(); // Limpa entrada inválida
            }
        }

        scanner.close();
    }
}