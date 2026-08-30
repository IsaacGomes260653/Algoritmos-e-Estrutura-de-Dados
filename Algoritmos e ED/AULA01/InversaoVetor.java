import java.util.Scanner;

public class InversaoVetor {

    public static void main(String[] args) {
        // System.in = entrada padrão (o que o usuário digita no terminal)
        Scanner leitor = new Scanner(System.in);

        /*
            Dois arrays de 5 posições cada, com índices de 0 a 4.
            Um guarda a entrada, o outro o resultado.

            Gasta o dobro da memória, mas preserva o original.
        */
        int[] vetorOriginal = new int[5];
        int[] vetorInvertido = new int[5];

        // ===== PREENCHIMENTO =====
        for ( int i = 0; i < vetorOriginal.length; i++) {
            /*
                .length é um ATRIBUTO do array, não um método —
                por isso não leva parênteses.

                Usar .length em vez de escrever 5 evita erros
                caso o tamanho do array mude depois.
            */
            System.out.println("Digite o valor da posição " + i + ": ");
            vetorOriginal[i] = leitor.nextInt();
        }

        // Libera o recurso da entrada padrão
        leitor.close();

        // ===== INVERSÃO =====
        /*
            A FÓRMULA DO ESPELHAMENTO:

                destino = tamanho - 1 - origem

            Com 5 posições (length = 5):
                i=0  →  5-1-0 = 4
                i=1  →  5-1-1 = 3
                i=2  →  5-1-2 = 2   (o meio fica no lugar)
                i=3  →  5-1-3 = 1
                i=4  →  5-1-4 = 0

            O "-1" existe porque o último índice válido é 4, não 5.
            Sem ele, a primeira gravação tentaria a posição 5
            e o programa quebraria com ArrayIndexOutOfBoundsException.

            Repare: LÊ em ordem crescente, GRAVA em ordem decrescente.
        */
        for( int i = 0; i < vetorOriginal.length; i++){
            vetorInvertido[vetorOriginal.length - 1 - i] = vetorOriginal[i];
        }

        // ===== EXIBIÇÃO =====
        for (int i = 0; i < vetorInvertido.length; i++) {
            System.out.println("vetorInvertido["+i+"]="+vetorInvertido[i]);
        }
    }
}