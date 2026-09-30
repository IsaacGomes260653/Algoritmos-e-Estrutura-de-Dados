package AULA08;

public class Principal {
    public static void main(String[] args){
        MatrizEsparsa matriz = new MatrizEsparsa(5);

        System.out.println("=== Estrutura vazia ===");
        matriz.exibir();
        System.out.println("contar() = " + matriz.contar());
        System.out.println("buscar(3) = " + matriz.buscar(3));
        System.out.println("remover(3) = " + matriz.remover(3));

        //Repetido: 7 | negativos: -7 e -1 | zero: 0
        matriz.inserir(12);
        matriz.inserir(7);
        matriz.inserir(3);
        matriz.inserir(0);
        matriz.inserir(-7);
        matriz.inserir(13);
        matriz.inserir(7);
        matriz.inserir(25);
        matriz.inserir(-1);

        System.out.println();
        System.out.println("=== Depois das inserções ===");
        matriz.exibir();
        System.out.println("contar() = " + matriz.contar());

        System.out.println();
        System.out.println("=== Buscas ===");
        System.out.println("buscar(13) = " + matriz.buscar(13));
        System.out.println("buscar(-7) = " + matriz.buscar(-7));
        System.out.println("buscar(0) = " + matriz.buscar(0));
        System.out.println("buscar(8) = " + matriz.buscar(8) + "  (diretor 3 existe, número não)");
        System.out.println("buscar(6) = " + matriz.buscar(6) + "  (nem o diretor 1 existe)");

        System.out.println();
        System.out.println("=== Remoções ===");
        System.out.println("remover(25) = " + matriz.remover(25) + "  (primeiro nó do diretor 0)");
        System.out.println("remover(0) = " + matriz.remover(0) + "  (último número: diretor 0 do meio sai)");
        System.out.println("remover(-1) = " + matriz.remover(-1) + "  (único número: diretor 4 da cabeca sai)");
        System.out.println("remover(13) = " + matriz.remover(13) + "  (primeiro nó do diretor 3)");
        System.out.println("remover(12) = " + matriz.remover(12) + "  (último nó do diretor 2)");
        System.out.println("remover(7) = " + matriz.remover(7) + "  (só uma das duas cópias)");
        System.out.println("remover(99) = " + matriz.remover(99) + "  (diretor 4 não existe mais)");
        System.out.println("remover(8) = " + matriz.remover(8) + "  (diretor 3 existe, número não)");

        System.out.println();
        System.out.println("=== Depois das remoções ===");
        matriz.exibir();
        System.out.println("contar() = " + matriz.contar());

        System.out.println();
        System.out.println("=== Módulo inválido ===");
        try{
            new MatrizEsparsa(0);
        }
        catch (IllegalArgumentException erro){
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}
