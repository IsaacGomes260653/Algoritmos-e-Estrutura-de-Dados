package AULA07;

public class Principal {
    public static void main(String[] args){
        Deque objDeque = new Deque();

        //Primeiro teste: deque vazio
        /*
            TESTE DE BORDA. As duas remoções precisam avisar
            que o deque está vazio, sem NullPointerException.
        */
        System.out.println("--- remover do deque vazio ---");
        objDeque.removerInicio();
        objDeque.removerFim();

        //Segundo teste: o deque usado como PILHA
        /*
            Entra pelo início e sai pelo início: LIFO.
            Saída esperada: 3 2 1 na impressão e na remoção.
        */
        objDeque.inserirInicio(1);
        objDeque.inserirInicio(2);
        objDeque.inserirInicio(3);
        System.out.println("--- como pilha: imprimir ---");
        objDeque.imprimir();
        System.out.println("--- como pilha: remover pelo início ---");
        objDeque.removerInicio();
        objDeque.removerInicio();
        objDeque.removerInicio();

        //Terceiro teste: o deque usado como FILA
        /*
            Entra pelo fim e sai pelo início: FIFO.
            Saída esperada: 1 2 3 na impressão e na remoção.
        */
        objDeque.inserirFim(1);
        objDeque.inserirFim(2);
        objDeque.inserirFim(3);
        System.out.println("--- como fila: imprimir ---");
        objDeque.imprimir();
        System.out.println("--- como fila: remover pelo início ---");
        objDeque.removerInicio();
        objDeque.removerInicio();
        objDeque.removerInicio();

        //Quarto teste: as duas pontas misturadas
        /*
            Inserindo alternadamente dos dois lados:

                inserirFim(2)    → [2]
                inserirInicio(1) → [1] ⇄ [2]
                inserirFim(3)    → [1] ⇄ [2] ⇄ [3]
                inserirInicio(0) → [0] ⇄ [1] ⇄ [2] ⇄ [3]
        */
        objDeque.inserirFim(2);
        objDeque.inserirInicio(1);
        objDeque.inserirFim(3);
        objDeque.inserirInicio(0);
        System.out.println("--- misturado: imprimir (0 1 2 3) ---");
        objDeque.imprimir();

        /*
            Remove 3 pelo fim, 0 pelo início, e depois 2 e 1
            pelo fim. A última remoção passa pelo caso de
            UM ÚNICO NÓ, que precisa zerar cabeça E cauda.
            A remoção seguinte confirma: o deque está vazio.
        */
        System.out.println("--- misturado: removerFim, removerInicio, removerFim x3 ---");
        objDeque.removerFim();
        objDeque.removerInicio();
        objDeque.removerFim();
        objDeque.removerFim();
        objDeque.removerFim();

        /*
            Depois de esvaziado, o deque precisa aceitar
            inserções de novo. Se a cauda tivesse ficado
            apontando para um nó velho, o 9 se perderia.
        */
        objDeque.inserirFim(9);
        System.out.println("--- reaproveitado: imprimir (9) ---");
        objDeque.imprimir();
        objDeque.removerInicio();

        //Quinto teste: o experimento de desempenho da AULA06
        /*
            A MESMA CARGA da Fila da AULA06: 100.001 entradas
            pela cabeça e 100.001 saídas pela cauda.

            Na Fila, cada sair() percorria a lista inteira atrás
            do penúltimo nó: O(n) por remoção, O(n²) no total —
            cerca de 5 BILHÕES de operações.

            Aqui o removerFim() acha o penúltimo direto pelo
            cauda.getAnterior(): O(1) por remoção, O(n) no total.
            Os 100.001 números aparecem na tela em segundos,
            limitados só pela velocidade do terminal.

            ESTA É A LIÇÃO DA AULA: o mesmo comportamento de fila,
            com um ponteiro a mais em cada nó (anterior) e um
            ponteiro a mais na estrutura (cauda), troca O(n²)
            por O(n).
        */
        for (int i = 0; i <= 100000; i++){
            objDeque.inserirInicio(i);
        }
        for (int i = 0; i <= 100000; i++){
            objDeque.removerFim();
        }
    }
}
