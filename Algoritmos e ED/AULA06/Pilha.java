package AULA06;

public class Pilha {
    //Propriedades da classe
    /*
        PILHA (Stack) — política LIFO: Last In, First Out.
        O último a entrar é o primeiro a sair.

        Analogia: uma pilha de pratos. Você empilha por cima
        e retira por cima.

        A "cabeca" é o TOPO da pilha.

            push(1) → [1]
            push(2) → [2] → [1]
            push(3) → [3] → [2] → [1]
                       ↑
                     topo (cabeca)

            pop() devolve 3, depois 2, depois 1.
    */
    private No cabeca = null;

    //Métodos da classe
    public void push(int numero){
        /*
            INSERE NO TOPO — e cabe em uma única linha.

            Lendo da direita para a esquerda:
            1) new No(numero, cabeca) cria um nó que já aponta
               para o antigo topo
            2) esse nó novo passa a ser a cabeça

            Não há caso especial para pilha vazia: se cabeca
            for null, o novo nó simplesmente aponta para null,
            que é o comportamento correto.

            CUSTO: O(1) — sempre uma operação, não importa
            o tamanho da pilha. É o que torna a pilha rápida.
        */
        cabeca = new No(numero, cabeca);
    }

    public void pop(){
        //Caso MUITO fácil: pilha vazia
        /*
            Nada a remover. Sai sem fazer nada.

            Repare que a Fila imprime "A fila está vazia"
            neste caso, e a Pilha fica em silêncio —
            uma pequena inconsistência entre as duas classes.
        */
        if(cabeca == null){
            return;
        }
        //Caso fácil: pilha NÃO vazia
        /*
            Remove do TOPO: imprime o valor e a cabeça
            passa a ser o nó de baixo.

            O nó removido some da pilha, e o coletor de lixo
            (garbage collector) libera a memória sozinho.

            CUSTO: O(1) — não há percurso nenhum.

            OBSERVAÇÃO DE PROJETO: este método IMPRIME o valor
            em vez de devolvê-lo. Uma pilha de verdade teria
            "public int pop()" com return, deixando quem chama
            decidir o que fazer com o dado. Do jeito atual,
            a estrutura só serve para exibir na tela.
        */
        System.out.println(cabeca.getNumero());
        cabeca = cabeca.getProximo();
    }
}