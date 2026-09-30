import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        // System.in = entrada padrão (o que o usuário digita no terminal)
        Scanner leitor = new Scanner(System.in);

        /*
            ORDENAÇÃO POR SELEÇÃO (Selection Sort).

            A ideia: a cada volta, SELECIONA o menor elemento
            da parte ainda desordenada e o coloca no começo dela.

                [5  3  8  1  4]    menor de tudo = 1 → troca com a posição 0
                [1 |3  8  5  4]    menor do resto = 3 → já está no lugar
                [1  3 |8  5  4]    menor do resto = 4 → troca com a posição 2
                [1  3  4 |5  8]    menor do resto = 5 → já está no lugar
                [1  3  4  5 |8]    sobrou um só: está ordenado

            A barra | separa a parte JÁ ORDENADA (esquerda)
            da parte que ainda falta ordenar (direita).
        */
        int[] vetor = new int[5];

        // ===== PREENCHIMENTO =====
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor da posição " + i + ": ");
            vetor[i] = leitor.nextInt();
        }

        // Libera o recurso da entrada padrão
        leitor.close();

        // ===== ORDENAÇÃO =====
        /*
            O laço externo (i) marca a posição que vai receber
            o próximo menor valor.

            Repare no "vetor.length - 1": quando sobra um único
            elemento no fim, ele já é necessariamente o maior.
            Não há mais nada a selecionar.
        */
        for (int i = 0; i < vetor.length - 1; i++) {
            /*
                "menor" guarda o ÍNDICE do menor valor encontrado,
                e não o valor em si. É o índice que permite fazer
                a troca depois.

                Começa supondo que o menor é o próprio vetor[i].
            */
            int menor = i;

            /*
                O laço interno (j) procura um valor ainda menor
                na parte desordenada, que começa em i + 1.
            */
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }

            /*
                A TROCA precisa de uma variável auxiliar.

                Sem ela, "vetor[i] = vetor[menor]" apagaria o valor
                antigo de vetor[i] antes de ele ser copiado para
                vetor[menor] — os dois ficariam iguais.

                    auxiliar = A        guarda A
                    A = B               A recebe B
                    B = auxiliar        B recebe o A guardado
            */
            int auxiliar = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = auxiliar;
        }

        /*
            CUSTO: O(n²) comparações, SEMPRE.

            O laço interno roda (n-1) + (n-2) + ... + 1 vezes,
            ou seja, n(n-1)/2 — mesmo que o vetor já chegue
            ordenado, porque ele nunca "percebe" isso.

            Em compensação, faz no máximo n - 1 TROCAS
            (uma por volta do laço externo). É a ordenação
            que menos escreve na memória.
        */

        // ===== EXIBIÇÃO =====
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor["+i+"]="+vetor[i]);
        }
    }
}
