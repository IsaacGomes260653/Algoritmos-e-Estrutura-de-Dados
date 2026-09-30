package AULA07;

public class Deque {
    //Propriedades da classe
    /*
        DEQUE (Double Ended QUEue) — fila de duas pontas.
        Insere e remove tanto no INÍCIO quanto no FIM.

        Analogia: um baralho em que você pode pôr ou tirar
        cartas por cima e por baixo.

        É a generalização das estruturas da AULA06:
        - usado só pelo início     → vira uma PILHA (LIFO)
        - entra no fim, sai no início → vira uma FILA (FIFO)

        A DIFERENÇA QUE RESOLVE TUDO: dois pontos de entrada.

            cabeca                     cauda
              ↓                          ↓
            null ← [1] ⇄ [2] ⇄ [3] ⇄ [4] → null

        Com a "cauda" guardada, ninguém precisa percorrer
        a estrutura para achar o fim. As QUATRO operações
        passam a ser O(1).

        Deque vazio: cabeca == null E cauda == null.
        Com um só nó: cabeca e cauda apontam para o MESMO nó.
    */
    private No cabeca = null;
    private No cauda = null;

    //Métodos da classe
    public void inserirInicio(int numero){
        //Caso fácil: deque vazio
        /*
            O único nó é ao mesmo tempo o primeiro e o último,
            então cabeca e cauda apontam para ele.

            Esquecer de ajustar a cauda aqui é o bug clássico
            do deque: a próxima inserção no fim encontraria
            cauda == null e se comportaria como se o deque
            estivesse vazio, apagando o que já existia.
        */
        if (cabeca == null){
            cabeca = new No(numero, null, null);
            cauda = cabeca;
            return;
        }

        //Caso difícil: deque não vazio
        /*
            Parecido com o push() da Pilha, com um passo a mais:

            1) new No(numero, null, cabeca) cria um nó que aponta
               para frente, para a antiga cabeça, e vira a cabeça
            2) a antiga cabeça (agora o segundo nó) passa a
               apontar para trás, para o nó novo

                antes:          [1] ⇄ [2]
                depois:  [0] ⇄ [1] ⇄ [2]

            CUSTO: O(1).
        */
        cabeca = new No(numero, null, cabeca);
        cabeca.getProximo().setAnterior(cabeca);
    }

    public void inserirFim(int numero){
        //Caso fácil: deque vazio
        // Mesma situação do inserirInicio(): cabeça e cauda no mesmo nó
        if (cauda == null){
            cauda = new No(numero, null, null);
            cabeca = cauda;
            return;
        }

        //Caso difícil: deque não vazio
        /*
            O ESPELHO do inserirInicio(): troca cabeca por cauda
            e anterior por proximo.

            Compare com o inserir() da lista dupla (AULA04), que
            precisava de um while para achar o último nó.
            Aqui a cauda já está guardada: não há percurso.

            CUSTO: O(1).
        */
        cauda = new No(numero, cauda, null);
        cauda.getAnterior().setProximo(cauda);
    }

    public void removerInicio(){
        //Caso MUITO fácil: deque vazio
        /*
            Mesmo comportamento do sair() da Fila (AULA06):
            avisa na tela e sai.
        */
        if (cabeca == null){
            System.out.println("O deque está vazio");
            return;
        }

        /*
            Como no pop() da Pilha, o método IMPRIME o valor
            removido em vez de devolvê-lo.
        */
        System.out.println(cabeca.getNumero());

        //Caso fácil: deque com um único nó
        /*
            Como saber que só existe um? A cabeça e a cauda
            são o MESMO objeto — o == compara referências.

            As duas precisam virar null. Se só a cabeça mudasse,
            a cauda continuaria apontando para o nó removido.
        */
        if (cabeca == cauda){
            cabeca = null;
            cauda = null;
            return;
        }

        //Caso difícil: deque com mais de um nó
        /*
            A cabeça passa para o segundo nó, e o novo primeiro
            deixa de apontar para trás.

                antes:  [1] ⇄ [2] ⇄ [3]
                depois:       [2] ⇄ [3]

            CUSTO: O(1).
        */
        cabeca = cabeca.getProximo();
        cabeca.setAnterior(null);
    }

    public void removerFim(){
        //Caso MUITO fácil: deque vazio
        if (cauda == null){
            System.out.println("O deque está vazio");
            return;
        }

        System.out.println(cauda.getNumero());

        //Caso fácil: deque com um único nó
        if (cabeca == cauda){
            cabeca = null;
            cauda = null;
            return;
        }

        //Caso difícil: deque com mais de um nó
        /*
            O MÉTODO QUE A FILA DA AULA06 NÃO CONSEGUIA FAZER RÁPIDO.

            Lá, remover do fim exigia um while para achar o
            PENÚLTIMO nó, porque numa lista simples não dá
            para voltar — O(n) a cada remoção.

            Aqui o penúltimo é simplesmente cauda.getAnterior():

                antes:  [1] ⇄ [2] ⇄ [3]
                depois: [1] ⇄ [2]

            CUSTO: O(1). Nenhum percurso.
        */
        cauda = cauda.getAnterior();
        cauda.setProximo(null);
    }

}
