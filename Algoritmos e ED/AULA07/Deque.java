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

}
