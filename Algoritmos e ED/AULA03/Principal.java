public class Principal {
    public static void main(String[] args){
        /*
            Cria o objeto Lista. A partir daqui, todo o
            trabalho com nós acontece DENTRO da classe Lista —
            aqui só chamamos os métodos públicos.

            Repare que Principal nunca menciona a classe No.
            Isso é o encapsulamento funcionando: quem usa a Lista
            não precisa saber como ela guarda os dados por dentro.
        */
        Lista objLista = new Lista();
        
        //Primeiro teste
        /*
            TESTE DE CORRETUDE — verifica se as operações funcionam.

            Imprimir uma lista VAZIA logo de cara é proposital:
            é um teste de borda. Se o método imprimir() não
            tratasse o caso de cabeca == null, o programa
            quebraria aqui com NullPointerException.

            Nada aparece na tela — e é exatamente esse
            o comportamento esperado.
        */
        objLista.imprimir();

        // Cinco inserções em sequência
        objLista.inserir(1);
        objLista.inserir(2);
        objLista.inserir(3);
        objLista.inserir(4);
        objLista.inserir(5);

        /*
            Saída esperada: 1, 2, 3, 4, 5 — nesta ordem.

            A ordem confirma que a inserção acontece no FIM
            da lista. Se fosse no início, sairia 5, 4, 3, 2, 1.
        */
        objLista.imprimir();

        /*
            Insere valores REPETIDOS (1, 3 e 5 já existem).
            A lista aceita duplicatas sem reclamar — não há
            verificação de unicidade em inserir().

            Isso importa na exclusão: excluir(3) removeria
            apenas a PRIMEIRA ocorrência encontrada,
            deixando a segunda na lista.
        */
        objLista.inserir(1);
        objLista.inserir(3);
        objLista.inserir(5);
        objLista.inserir(10);

        // Saída esperada: 1, 2, 3, 4, 5, 1, 3, 5, 10
        objLista.imprimir();

        //Segundo teste
        /*
            TESTE DE DESEMPENHO — este laço não está aqui por acaso.
            Ele existe para você SENTIR o custo do algoritmo.

            Cada chamada a inserir() percorre a lista inteira
            para achar o último nó. Com a lista crescendo:

                inserção 1        → 1 passo
                inserção 2        → 2 passos
                ...
                inserção 1000000  → 1000000 passos

            Somando tudo: n(n+1)/2 ≈ 500 BILHÕES de operações.
            É a definição prática de O(n²).

            O QUE OBSERVAR: os números do println vão
            desacelerando visivelmente conforme sobem.
            O começo é instantâneo; depois de alguns milhares,
            o programa praticamente trava.

            A LIÇÃO: complexidade não é teoria abstrata.
            Se a Lista guardasse também um ponteiro para a CAUDA,
            inserir() seria O(1) e este laço inteiro O(n) —
            terminaria em segundos.

            Para interromper a execução: Ctrl + C no terminal.
        */
        for (int i = 0; i < 1000000; i++){
            objLista.inserir(i);
            System.out.println(i);
        }
    }

}