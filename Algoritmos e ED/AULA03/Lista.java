public class Lista {
    //Propriedades da classe
    /*
        A lista inteira é conhecida por UM único ponto: a cabeça.
        A partir dela, cada nó aponta para o seguinte.
        O último aponta para null, marcando o fim.

            cabeca → [1] → [2] → [3] → null

        cabeca == null significa lista vazia.

        O atributo é private: só os métodos desta classe
        mexem nele. Isso é ENCAPSULAMENTO — quem usa a Lista
        não precisa saber que existem nós por trás.
    */
    private No cabeca = null;

    //Métodos da classe
    public void inserir(int numero){
        // Caso fácil: lista vazia
        /*
            O novo nó vira a própria cabeça e aponta para null,
            já que não há ninguém depois dele.

            O "return" encerra o método aqui, evitando um else
            e deixando o código mais plano.
        */
        if (cabeca == null){
            cabeca = new No(numero, null);
            return;
        } 

        //caso difícil: lista não vazia
        /*
            Precisamos achar o ÚLTIMO nó — o único cujo
            getProximo() devolve null — e prender o novo nele.

            "ultimo" é uma variável auxiliar que caminha pela lista.
            Nunca mova a própria "cabeca": você perderia a
            referência ao início e a lista inteira junto.

            CUSTO: este while percorre a lista toda a cada chamada.
            Inserir 1 elemento é O(n); inserir n elementos é O(n²).
            Guardar também um ponteiro para a cauda tornaria
            a inserção O(1).
        */
        No ultimo = cabeca;
        while (ultimo.getProximo() != null){
            ultimo = ultimo.getProximo();
        }
        ultimo.setProximo(new No(numero, null));
    }

    public void excluir(int numero){
        // Caso fácil: lista vazia
        // Nada a excluir — sai sem fazer nada
        if (cabeca == null){
            return;
        } 

        //Caso fácil: excluir o primeiro nó da lista
        /*
            Basta a cabeça passar a ser o segundo nó.

            O nó antigo some da lista e o coletor de lixo
            (garbage collector) libera a memória sozinho —
            em Java não existe free() como em C.

            Se a lista tinha um só elemento, getProximo()
            devolve null e a lista fica corretamente vazia.
        */
        if (cabeca.getNumero() == numero){
            cabeca = cabeca.getProximo();
            return;
        }

        //caso difícil: excluir no meio ou no final da lista 
        /*
            Guardamos o nó ANTERIOR, não o nó a excluir.

            Numa lista simplesmente encadeada não há como voltar:
            cada nó só conhece o seguinte. Quem religa os
            ponteiros precisa ser o anterior, então é ele
            que precisamos localizar.

            O while tem DUAS condições, ligadas por &&:
            1) ainda existe um próximo (não chegamos ao fim)
            2) o próximo NÃO é o número procurado (ainda não achamos)

            A ordem importa: o Java avalia da esquerda para a direita
            e para assim que a primeira condição é falsa
            (curto-circuito). Se fosse ao contrário, chamar
            .getNumero() em null causaria NullPointerException.
        */
         No anterior = cabeca;
         while ((anterior.getProximo() != null) && (anterior.getProximo().getNumero() != numero)){
             anterior = anterior.getProximo();
         }
         
         if (anterior.getProximo() ==null){
            //Caso em que foi tentada a exclusão de um número que não existe
            // Chegou ao fim da lista sem encontrar: sai sem alterar nada
            return;
         }
         //Caso da exclusão propriamente dita no meio ou no fim
            /*
                O anterior "pula" o nó do meio e passa a apontar
                direto para o seguinte:

                    antes:  [A] → [B] → [C]
                    depois: [A] ------→ [C]

                getProximo().getProximo() = o nó DEPOIS do que sai.

                Se o nó excluído era o último, o segundo
                getProximo() devolve null — e o anterior
                vira o novo fim da lista. O mesmo código
                atende os dois casos.
            */
            anterior.setProximo(anterior.getProximo().getProximo());
    }

    public void imprimir(){
        /*
            "ponteiro" é a variável auxiliar que caminha pela lista.
            Começa na cabeça e avança até encontrar null.

            Este padrão — copiar a cabeça numa variável temporária
            e caminhar com ela — se repete em quase toda operação
            de lista encadeada.
        */
        No ponteiro = cabeca;
        while (ponteiro != null){
            /*
                getNumero() devolve o int guardado no nó.

                Cuidado: getProximo() devolveria o OBJETO No,
                e imprimi-lo mostraria o endereço na memória
                (algo como No@4554617c) em vez do valor.
            */
            System.out.println(ponteiro.getNumero());
            ponteiro = ponteiro.getProximo();
        }
        // Lista vazia: o while nem executa, e nada é impresso
    }

}