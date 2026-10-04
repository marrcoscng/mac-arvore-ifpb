package macifpb;

import java.util.Scanner;

@FunctionalInterface
public interface OpcaoMenu {
    void executar(Scanner scanner, Conta conta, Cliente cliente);
}
