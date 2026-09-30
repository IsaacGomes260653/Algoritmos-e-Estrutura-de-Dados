import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        // System.in = entrada padrão (o que o usuário digita no terminal)
        Scanner leitor = new Scanner(System.in);

        /*
            ORDENAÇÃO POR BOLHA (Bubble Sort).

            A ideia: comparar cada par de VIZINHOS e trocar
            os dois se estiverem fora de ordem. A cada volta,
            o maior valor ainda desordenado "sobe" até o fim,
            como uma bolha subindo na água.

            Primeira volta com [5  3  8  1  4]:

                [5  3  8  1  4]    5 > 3 → troca
                [3  5  8  1  4]    5 < 8 → fica
                [3  5  8  1  4]    8 > 1 → troca
                [3  5  1  8  4]    8 > 4 → troca
                [3  5  1  4 |8]    o 8 chegou ao fim: está no lugar

            A barra | separa a parte que ainda falta ordenar
            (esquerda) da parte JÁ ORDENADA (direita).
            É o contrário do Selection Sort, que ordena
            da esquerda para a direita.
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
            O laço externo (i) conta quantas voltas já foram dadas.
            Com n elementos, n - 1 voltas bastam: quando os n - 1
            maiores estão no lugar, o que sobrou é o menor.
        */
        for (int i = 0; i < vetor.length - 1; i++) {
            /*
                O laço interno (j) compara vetor[j] com vetor[j + 1].

                POR QUE "vetor.length - 1 - i"?

                - O "-1": j + 1 precisa ser um índice válido.
                  Com j indo até length - 1, vetor[j + 1] seria
                  vetor[5] e o programa quebraria com
                  ArrayIndexOutOfBoundsException.

                - O "-i": depois de i voltas, os i últimos elementos
                  já estão no lugar certo. Compará-los de novo
                  não quebraria nada, mas seria trabalho à toa.
            */
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    /*
                        A mesma troca com variável auxiliar
                        do Selection Sort, só que entre vizinhos.
                    */
                    int auxiliar = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = auxiliar;
                }
            }
        }

        /*
            CUSTO: O(n²) comparações e até O(n²) TROCAS.

            Troca muito mais que o Selection Sort: um valor
            pequeno no fim do vetor anda uma casa por volta,
            trocando com cada vizinho no caminho.

            MELHORIA CLÁSSICA (pergunta de prova): guardar num
            boolean se houve alguma troca na volta. Se uma volta
            inteira passar sem trocas, o vetor já está ordenado
            e dá para parar. Com o vetor já ordenado, o custo
            cai para O(n) — uma única volta de verificação.
        */

        // ===== EXIBIÇÃO =====
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor["+i+"]="+vetor[i]);
        }
    }
}
