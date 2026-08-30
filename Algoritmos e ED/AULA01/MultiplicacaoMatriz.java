import java.util.Scanner;

public class MultiplicacaoMatriz {
     public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        /*
            REGRA DA MULTIPLICAÇÃO DE MATRIZES:
            o número de COLUNAS da primeira precisa ser igual
            ao número de LINHAS da segunda.

                [2][3] · [3][2]  →  [2][2]
                    ↑     ↑
                    iguais: 3 = 3

            O resultado herda as LINHAS da primeira
            e as COLUNAS da segunda.
        */
        int[][] operando1 = new int[2][3];
        int[][] operando2 = new int[3][2];
        int[][] resultado = new int[2][2];

        // ===== PREENCHIMENTO DO OPERANDO 1 (2 linhas x 3 colunas) =====
        for (int i = 0; i < operando1.length; i++) {
            for (int j = 0; j < operando1[i].length; j++) {
                System.out.print("operando1 [" + i + "][" + j + "]: ");
                operando1[i][j] = leitor.nextInt();
            }
        }

        // ===== PREENCHIMENTO DO OPERANDO 2 (3 linhas x 2 colunas) =====
        for (int i = 0; i < operando2.length; i++) {
            for (int j = 0; j < operando2[i].length; j++) {
                System.out.print("operando2 [" + i + "][" + j + "]: ");
                operando2[i][j] = leitor.nextInt();
            }
        }

        leitor.close();

        // ===== MULTIPLICAÇÃO =====
        /*
            TRÊS LAÇOS ANINHADOS — o algoritmo clássico, O(n³):

            i → escolhe a LINHA do resultado
            j → escolhe a COLUNA do resultado
            k → percorre e ACUMULA a soma dos produtos

            Cada resultado[i][j] é o produto escalar entre
            a linha i do operando1 e a coluna j do operando2:

                resultado[0][0] = op1[0][0]*op2[0][0]
                                + op1[0][1]*op2[1][0]
                                + op1[0][2]*op2[2][0]

            Repare no papel duplo do k:
            ele é a COLUNA no operando1 e a LINHA no operando2.
            É o índice que "casa" as duas matrizes — e por isso
            as dimensões precisam bater.

            O += funciona sem inicialização porque todo int
            em Java já nasce valendo 0.
        */
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                for (int k = 0; k < operando1[i].length; k++) {
                    resultado[i][j] += operando1[i][k] * operando2[k][j];
                }
            }
        }

        // ===== EXIBIÇÃO DO RESULTADO =====
        /*
            ADICIONADO: sem este bloco, o programa lia 12 números,
            calculava tudo corretamente e terminava sem mostrar nada.

            \n dentro da string cria uma linha em branco antes do título.
            \t alinha as colunas; o println() vazio quebra a linha
            ao terminar cada linha da matriz.
        */
        System.out.println("\nResultado:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + "\t");
            }
            System.out.println();
        }
    }
}