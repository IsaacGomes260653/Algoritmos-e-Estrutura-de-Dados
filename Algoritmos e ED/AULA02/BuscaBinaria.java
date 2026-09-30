import java.util.Scanner;

public class BuscaBinaria {

    public static void main(String[] args) {
        // System.in = entrada padrão (o que o usuário digita no terminal)
        Scanner leitor = new Scanner(System.in);

        /*
            BUSCA BINÁRIA.

            A ideia: olhar o elemento do MEIO e descartar
            a metade onde o valor com certeza não está.
            É como procurar uma palavra no dicionário:
            ninguém lê página por página.

            EXIGÊNCIA: o vetor precisa estar ORDENADO.
            É por isso que ordenação e busca são vistas
            na mesma aula — uma prepara o terreno da outra.
        */
        int[] vetor = new int[5];

        // ===== PREENCHIMENTO =====
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor da posição " + i + ": ");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Digite o valor a procurar: ");
        int procurado = leitor.nextInt();

        // Libera o recurso da entrada padrão
        leitor.close();

        // ===== ORDENAÇÃO =====
        /*
            O usuário pode digitar os números em qualquer ordem,
            então o vetor é ordenado antes da busca.
            É o mesmo Bubble Sort do arquivo BubbleSort.java.

            Sem esta etapa, a busca binária daria respostas
            ERRADAS sem nenhum aviso: ela descartaria metades
            onde o valor poderia estar.
        */
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int auxiliar = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = auxiliar;
                }
            }
        }

        // ===== BUSCA =====
        /*
            "inicio" e "fim" delimitam a parte do vetor onde
            o valor AINDA PODE estar. Começa sendo o vetor todo.

            Exemplo procurando 8 em [1  3  4  5  8]:

                inicio=0 fim=4 → meio=2 → vetor[2]=4 < 8 → descarta a esquerda
                inicio=3 fim=4 → meio=3 → vetor[3]=5 < 8 → descarta a esquerda
                inicio=4 fim=4 → meio=4 → vetor[4]=8 = 8 → achou!

            Se inicio passar de fim, a parte ficou vazia:
            o valor não existe no vetor.
        */
        int inicio = 0;
        int fim = vetor.length - 1;
        int posicao = -1;

        while (inicio <= fim) {
            /*
                Divisão entre int descarta a parte decimal:
                (0 + 4) / 2 = 2   e   (3 + 4) / 2 = 3.

                Curiosidade: com vetores ENORMES (mais de 1 bilhão
                de posições), inicio + fim poderia passar do
                maior int e ficar negativo. A forma à prova disso é
                inicio + (fim - inicio) / 2.
            */
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == procurado) {
                posicao = meio;
                break;
            } else if (vetor[meio] < procurado) {
                /*
                    O meio é menor que o procurado, e o vetor
                    está ordenado: tudo à esquerda do meio
                    (e o próprio meio) também é menor.
                    A busca continua só na metade direita.
                */
                inicio = meio + 1;
            } else {
                // O raciocínio espelhado: descarta a metade direita
                fim = meio - 1;
            }
        }

        /*
            CUSTO: O(log n).

            Cada volta corta a parte restante pela metade.
            Com 1 milhão de posições, bastam no máximo
            20 comparações (2^20 ≈ 1 milhão) — contra até
            1 milhão da busca exaustiva.

            Mas lembre do preço: a ordenação feita acima
            custa O(n²). Só compensa ordenar uma vez e
            buscar muitas.
        */

        // ===== EXIBIÇÃO =====
        /*
            A posição exibida é a do vetor JÁ ORDENADO,
            não a ordem em que os números foram digitados.
        */
        System.out.print("Vetor ordenado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + vetor[i]);
        }
        System.out.println();

        if (posicao == -1) {
            System.out.println(procurado + " não foi encontrado");
        } else {
            System.out.println(procurado + " está na posição " + posicao);
        }
    }
}
