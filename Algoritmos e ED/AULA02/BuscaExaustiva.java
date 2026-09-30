import java.util.Scanner;

public class BuscaExaustiva {

    public static void main(String[] args) {
        // System.in = entrada padrão (o que o usuário digita no terminal)
        Scanner leitor = new Scanner(System.in);

        /*
            BUSCA EXAUSTIVA (também chamada de busca sequencial
            ou busca linear).

            A ideia: olhar as posições UMA POR UMA, do começo
            ao fim, até achar o valor procurado ou acabar o vetor.

            Vantagem: funciona com o vetor em QUALQUER ordem.
            Desvantagem: no pior caso, olha todas as posições.
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

        // ===== BUSCA =====
        /*
            "posicao" começa em -1, que NUNCA é um índice válido.
            Se continuar valendo -1 depois do laço, é porque
            o valor não foi encontrado.

            Usar um valor impossível como sinal de "não achei"
            é um padrão muito comum — o indexOf() da String
            faz exatamente isso.
        */
        int posicao = -1;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == procurado) {
                posicao = i;
                /*
                    break encerra o laço na hora.
                    Achou: não há motivo para olhar o resto.

                    Sem ele o programa continuaria certo,
                    mas guardaria a ÚLTIMA ocorrência em vez da
                    primeira, e sempre percorreria o vetor inteiro.
                */
                break;
            }
        }

        /*
            CUSTO:
            - melhor caso: O(1) — o valor está na posição 0
            - pior caso:   O(n) — o valor está no fim ou não existe

            Um vetor de 1 milhão de posições pode exigir
            1 milhão de comparações.
        */

        // ===== EXIBIÇÃO =====
        if (posicao == -1) {
            System.out.println(procurado + " não foi encontrado");
        } else {
            System.out.println(procurado + " está na posição " + posicao);
        }
    }
}
