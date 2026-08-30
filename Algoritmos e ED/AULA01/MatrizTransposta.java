import java.util.Scanner;

public class MatrizTransposta {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        /*
            Matriz em Java = array de arrays.
            [2][3] significa 2 linhas, cada uma com 3 colunas.

            A transposta troca linhas por colunas,
            então suas dimensões são o inverso: [3][2].

                original            transposta
                [ a  b  c ]         [ a  d ]
                [ d  e  f ]         [ b  e ]
                                    [ c  f ]
        */
        int[][] matrizOriginal = new int[2][3];
        int[][] matrizTransposta = new int[3][2];

        // ===== PREENCHIMENTO =====
        for (int i = 0; i < matrizOriginal.length; i++) {
            /*
                matrizOriginal.length     = número de LINHAS  (2)
                matrizOriginal[i].length  = número de COLUNAS daquela linha (3)

                Como cada linha é um array independente, elas
                poderiam até ter tamanhos diferentes — por isso
                o laço interno consulta o tamanho da linha atual,
                e não um valor fixo.

                O laço externo (i) percorre as linhas,
                o interno (j) percorre as colunas de cada linha.
            */
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                System.out.print("matrizOriginal [" + i + "][" + j + "]: ");
                matrizOriginal[i][j] = leitor.nextInt();
            }
        }

        leitor.close();

        // ===== TRANSPOSIÇÃO =====
        /*
            O coração do exercício cabe em uma linha:
            basta INVERTER A ORDEM DOS ÍNDICES na gravação.

                lê   de  [i][j]
                grava em [j][i]

            O valor da linha 0, coluna 2 vai para a linha 2, coluna 0.

            Os laços continuam percorrendo a matriz ORIGINAL —
            é o destino que muda de lugar, não a origem.
        */
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                matrizTransposta[j][i] = matrizOriginal[i][j];
            }
        }

        // ===== EXIBIÇÃO DA MATRIZ ORIGINAL =====
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                /*
                    print (sem "ln") mantém tudo na mesma linha.
                    \t é o caractere de tabulação, que alinha as colunas.
                */
                System.out.print(matrizOriginal[i][j] + "\t");
            }
            /*
                println() vazio quebra a linha ao terminar cada linha
                da matriz. Fica FORA do laço interno e DENTRO do externo —
                é isso que dá o formato de tabela.
            */
            System.out.println();
        }
        System.out.println();   // linha em branco separando as duas matrizes

        // ===== EXIBIÇÃO DA MATRIZ TRANSPOSTA =====
        /*
            Mesma lógica, mas agora sobre matrizTransposta,
            que tem 3 linhas e 2 colunas.

            Usar .length em vez de números fixos faz o mesmo
            bloco funcionar para qualquer dimensão.
        */
        for (int i = 0; i < matrizTransposta.length; i++) {
            for (int j = 0; j < matrizTransposta[i].length; j++) {
                System.out.print(matrizTransposta[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}