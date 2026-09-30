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

    public void excluir(int numero){
        //Caso fácil: lista vazia
        // Nada a excluir — sai sem fazer nada
        if (cabeca == null){
            return;
        }

        //Caso fácil: excluir o primeiro nó da lista
        /*
            A cabeça passa a ser o segundo nó, como na lista simples.

            O PASSO NOVO: o novo primeiro nó ainda aponta para trás,
            para o nó que acabou de sair. Esse "anterior" precisa
            virar null, senão a lista continua presa ao nó removido.

            O if protege o caso de a lista ter um só elemento:
            aí a nova cabeça é null, e chamar setAnterior()
            em null causaria NullPointerException.
        */
        if (cabeca.getNumero() == numero){
            cabeca = cabeca.getProximo();
            if (cabeca != null){
                cabeca.setAnterior(null);
            }
            return;
        }

        //Caso difícil: excluir no meio ou no final da lista
        /*
            AQUI ESTÁ A GRANDE VANTAGEM da lista dupla.

            Na lista simples era preciso parar no nó ANTERIOR
            ao que sai, porque não havia como voltar.
            Aqui o "ponteiro" pode parar EM CIMA do nó que sai:
            ele mesmo sabe quem é o seu anterior.

            O && faz curto-circuito da esquerda para a direita:
            se ponteiro for null, getNumero() nem é chamado.
        */
        No ponteiro = cabeca;
        while ((ponteiro != null) && (ponteiro.getNumero() != numero)){
            ponteiro = ponteiro.getProximo();
        }

        if (ponteiro == null){
            //Caso em que foi tentada a exclusão de um número que não existe
            // Chegou ao fim da lista sem encontrar: sai sem alterar nada
            return;
        }

        //Caso da exclusão propriamente dita no meio ou no fim
        /*
            Os vizinhos do nó que sai passam a apontar um
            para o outro, "pulando" o nó do meio:

                antes:  [A] ⇄ [B] ⇄ [C]
                depois: [A] ⇄ [C]          (B ficou de fora)

            1) o anterior (A) passa a apontar para frente, para C
            2) o próximo (C) passa a apontar para trás, para A

            Não precisa testar se o anterior existe: o caso do
            primeiro nó já foi tratado lá em cima, então aqui
            o nó que sai SEMPRE tem alguém antes dele.

            Mas o próximo pode não existir — se o nó que sai
            for o último, não há C para religar. Daí o if.
        */
        ponteiro.getAnterior().setProximo(ponteiro.getProximo());
        if (ponteiro.getProximo() != null){
            ponteiro.getProximo().setAnterior(ponteiro.getAnterior());
        }
    }

}
