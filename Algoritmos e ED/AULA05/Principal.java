import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        //Declaração de variáveis
        Scanner leitor = new Scanner(System.in);
        Lista objLista = new Lista();

        /*
            opcao começa em 0 apenas para que o while
            execute pelo menos uma vez (0 != 5).

            É o padrão de "menu controlado por sentinela":
            a variável guarda a escolha e também controla o laço.
        */
        int opcao = 0;

        //Processamento
        /*
            O laço só termina quando o usuário digita 5.
            Repare que o 5 aparece em dois lugares — na condição
            do while e no texto do menu. Se um mudar sem o outro,
            o programa fica impossível de encerrar.
        */
        while (opcao != 5) {
            System.out.println("+======================================+");
            System.out.println("|            Menu de Opções            |");
            System.out.println("+======================================+");
            System.out.println("|      1 - Inserir                     |");
            System.out.println("|      2 - Remover                     |");
            System.out.println("|      3 - Imprimir                    |");
            System.out.println("|      4 - Inverter                    |");
            System.out.println("|      5 - Sair                        |");
            System.out.println("+======================================+");
            /*
                Aqui caberia print() em vez de println():
                o cursor ficaria na mesma linha do texto,
                logo depois dos dois-pontos.
            */
            System.out.println("Digite a sua opção: ");

            /*
                nextInt() lê só um número inteiro.
                Se o usuário digitar uma letra, o programa
                lança InputMismatchException e encerra.
            */
            opcao = leitor.nextInt();

            /*
                O switch compara "opcao" com cada case.

                O "break" é OBRIGATÓRIO: sem ele o Java continua
                executando os cases seguintes (fall-through).
                É um erro clássico e difícil de notar, porque
                compila normalmente.
            */
            switch(opcao) {
                case 1:
                    System.out.print("Digite um número: ");
                    /*
                        leitor.nextInt() é avaliado ANTES da chamada,
                        e o valor lido é passado direto ao método —
                        sem precisar de uma variável intermediária.
                    */
                    objLista.inserir(leitor.nextInt());
                    break;
                case 2:
                    System.out.print("Digite um número: ");
                    objLista.excluir(leitor.nextInt());
                    break;
                case 3:
                    objLista.imprimir();
                    break;
                case 4:
                    /*
                        ⚠ O menu promete "Inverter", mas este código
                        INSERE 1000 números. É código de teste
                        ocupando o lugar do método real.

                        ⚠ Além disso: o for está SEM CHAVES.
                        Em Java, um for sem chaves executa apenas
                        a PRÓXIMA instrução. Aqui funciona por sorte —
                        só existe uma linha. Se alguém acrescentar
                        uma segunda, ela ficará FORA do laço,
                        mesmo parecendo estar dentro pela indentação.
                        Use sempre chaves.
                    */
                    for (int i = 0; i < 1000; i++) 
                    objLista.inserir(i);
                    break;         

                /*
                    ⚠ Não existe "case 5" nem "default".

                    Digitar 5 não cai em nenhum case: o switch
                    não faz nada e o while encerra na próxima
                    verificação. Funciona, mas sem mensagem de saída.

                    Digitar 7 também não cai em lugar nenhum:
                    o menu simplesmente reaparece, e o usuário
                    não sabe se errou ou se o programa travou.
                    Um "default" resolveria isso.
                */
            }       
         }
        /*
            close() só depois do laço: fechar o Scanner dentro
            do while impediria todas as leituras seguintes.
        */
        leitor.close();
    }
}