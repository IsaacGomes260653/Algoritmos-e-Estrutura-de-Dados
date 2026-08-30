/*
    A classe Scanner não vem carregada por padrão.
    O import busca a classe no pacote java.util,
    que faz parte da biblioteca padrão do Java.
*/
import java.util.Scanner;

public class PreenchimentoVetor {

    public static void main(String[] args) {
        // System.in = entrada padrão (o que o usuário digita no terminal)
        Scanner leitor = new Scanner(System.in);

        /*
            Em Java o tamanho do array é FIXO na criação.
            new int[5] reserva 5 posições, com índices de 0 a 4.

            Todas começam valendo 0 — é o valor padrão do tipo int.
            Se fosse um array de objetos, começariam valendo null.
        */
        int[] vetor = new int [5];

        // ===== PREENCHIMENTO =====
        for (int i = 0; i < vetor.length; i++ ) {
            /*
                .length é um ATRIBUTO do array, não um método,
                por isso não leva parênteses.
                (Diferente de String, onde se usa .length() com parênteses.)

                Repare na condição: i < vetor.length, e não i <= .
                Com 5 posições, o último índice válido é 4.
                Usar <= tentaria acessar vetor[5] e o programa
                quebraria com ArrayIndexOutOfBoundsException.
            */
            System.out.println("Digite o valor da posição " + i + ": ");

            /*
                nextInt() lê apenas o próximo número inteiro.
                Se o usuário digitar uma letra, o programa lança
                InputMismatchException.
            */
            vetor[i] = leitor.nextInt();
        }

        /*
            Fechar o Scanner libera o recurso da entrada padrão.
            Depois disso não é mais possível ler nada do teclado —
            por isso o close() vem só quando a leitura terminou.
        */
        leitor.close();

        // ===== EXIBIÇÃO =====
        /*
            Um segundo laço, separado do primeiro.

            Seria possível imprimir dentro do laço de leitura,
            mas separar deixa claro que são duas etapas distintas:
            primeiro coletar todos os dados, depois exibi-los.
        */
        for (int i = 0; i < vetor.length; i++) {
            /*
                O operador + concatena texto.
                Quando um dos lados é String, o Java converte
                o int automaticamente para texto.
            */
            System.out.println("vetor["+i+"]="+vetor[i]);
        }
    }
}