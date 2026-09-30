public class Lista {
    //Propriedades da classe
    /*
        LISTA DUPLAMENTE ENCADEADA: cada nó conhece o seguinte
        E o anterior.

            cabeca
              ↓
            null ← [1] ⇄ [2] ⇄ [3] → null

        Duas pontas soltas, e não uma:
        - o PRIMEIRO nó tem anterior == null
        - o ÚLTIMO  nó tem proximo  == null

        Como na AULA03, a lista inteira é conhecida por um
        único ponto de entrada: a cabeça.
        cabeca == null significa lista vazia.
    */
    private No cabeca = null;

    //Métodos da classe
    public void inserir(int numero){
        //Caso fácil: lista vazia
        /*
            O novo nó vira a cabeça. Ele é o primeiro e o
            último ao mesmo tempo, então os dois ponteiros
            são null.
        */
        if (cabeca == null){
            cabeca = new No(numero, null, null);
            return;
        }

        //Caso difícil: lista não vazia
        /*
            Igual à lista simples: caminha até o ÚLTIMO nó,
            o único cujo getProximo() devolve null.

            A diferença está na criação do nó novo:
            ele já nasce sabendo quem vem ANTES dele (o "ultimo").

                antes:  [1] ⇄ [2] → null
                depois: [1] ⇄ [2] ⇄ [3] → null

            São DUAS ligações, uma em cada sentido:
            1) new No(numero, ultimo, null) → o novo aponta para trás
            2) ultimo.setProximo(...)       → o antigo último aponta para frente

            Esquecer uma delas deixa a lista "torta": ela funciona
            num sentido e quebra no outro. É um bug que só aparece
            quando alguém percorre de trás para frente.

            CUSTO: O(n), por causa do percurso até o fim.
            Guardar um ponteiro para a cauda tornaria a
            inserção O(1) — é o que o Deque da AULA07 faz.
        */
        No ultimo = cabeca;
        while (ultimo.getProximo() != null){
            ultimo = ultimo.getProximo();
        }
        ultimo.setProximo(new No(numero, ultimo, null));
    }

}
