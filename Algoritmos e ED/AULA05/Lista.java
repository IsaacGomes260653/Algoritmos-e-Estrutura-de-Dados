public class Lista {
    //Propriedade da classe
    /*
        LISTA CIRCULAR: o último nó aponta de volta para a cabeça,
        em vez de apontar para null.

            cabeca → [1] → [2] → [3] ─┐
              ↑                       │
              └───────────────────────┘

        CONSEQUÊNCIA PRINCIPAL: não existe mais um "fim" marcado
        por null. Todo percurso passa a comparar com a CABEÇA:

            while (ponteiro != null)     ← lista simples
            while (ponteiro != cabeca)   ← lista circular

        Esquecer essa troca gera laço infinito.
    */
    private No cabeca = null;

     //Métodos da classe
    public void inserir(int numero){
        //Cenário fácil: lista vazia
        /*
            Um único nó precisa apontar para SI MESMO,
            para que o círculo já exista com um só elemento.

            Repare que são duas etapas: o construtor recebe null
            porque o objeto ainda não existe quando é criado —
            só depois de atribuído a "cabeca" é possível
            fazê-lo apontar para si mesmo.
        */
        if(cabeca == null){
            cabeca = new No(numero, null);
            cabeca.setProximo(cabeca);
            return;
        }

        //Cenário difícil: lista NÃO vazia
        /*
            O último nó é aquele cujo próximo é a CABEÇA
            (e não null, como na lista simples).

            O novo nó entra no fim e já nasce apontando
            para a cabeça — é o que mantém o círculo fechado.
        */
        No ultimo = cabeca;
        while (ultimo.getProximo() != cabeca){
            ultimo = ultimo.getProximo();
        }
        ultimo.setProximo(new No(numero, cabeca));
    }

    public void excluir(int numero){
        /*
            A exclusão numa lista circular tem QUATRO cenários.
            Vale memorizar a lista — é pergunta clássica de prova.
        */

        //Cenário MUITO fácil: lista vazia
        if (cabeca == null){
            return;
        }

        //Cenário fácil: excluir o único
        /*
            Como saber que só existe um nó?
            Ele aponta para si mesmo: getProximo() == cabeca.

            As duas condições precisam ser verdadeiras:
            é o número procurado E é o único elemento.
            A lista fica vazia.
        */
        if ((cabeca.getNumero() == numero) && (cabeca.getProximo() == cabeca)){
            cabeca = null;
            return;
        }

        //Cenário médio: excluir o primeiro
        /*
            AQUI ESTÁ A GRANDE DIFERENÇA em relação à lista simples.

            Numa lista simples bastaria "cabeca = cabeca.getProximo()".
            Na circular isso quebraria o círculo: o ÚLTIMO nó
            continuaria apontando para o nó que acabou de sair.

            Por isso percorremos a lista inteira só para
            encontrar o último e religá-lo à nova cabeça.
        */
        if (cabeca.getNumero() == numero){
            No ultimo = cabeca;
            while (ultimo.getProximo() != cabeca){
                ultimo = ultimo.getProximo();
            }
            cabeca = cabeca.getProximo();
            ultimo.setProximo(cabeca);
            return;
        }

        //Cenário difícil: excluir no meio ou no fim
        /*
            Mesma lógica da lista simples: guardamos o ANTERIOR,
            porque é ele quem vai religar os ponteiros.

            A única mudança é a condição de parada, que compara
            com "cabeca" em vez de null.

            O && faz curto-circuito da esquerda para a direita:
            se o primeiro teste falha, o segundo nem é avaliado.
            É isso que evita NullPointerException.
        */
        No anterior = cabeca;
        while ((anterior.getProximo() != cabeca) && (anterior.getProximo().getNumero() != numero)){
            anterior=anterior.getProximo();
        }
        if (anterior.getProximo() == cabeca) {
            return; //Cenário não foi encontrado
            // Deu a VOLTA COMPLETA sem achar: o número não existe
        }
        /*
            A exclusão em si: o anterior "pula" o nó do meio.

                antes:  [A] → [B] → [C]
                depois: [A] ------→ [C]
        */
        anterior.setProximo(anterior.getProximo().getProximo());
    }

    public void imprimir(){
        No ponteiro = cabeca;

        /*
            Lista vazia: precisa sair ANTES do do-while.
            Como o do-while executa o corpo antes de testar,
            uma lista vazia causaria NullPointerException
            na primeira linha do laço.
        */
        if (ponteiro == null){
            return;
        }

        /*
            POR QUE do-while E NÃO while?

            Num while comum, a condição (ponteiro != cabeca)
            seria FALSA logo de cara — ponteiro começa valendo
            cabeca — e nada seria impresso.

            O do-while executa o corpo PRIMEIRO e testa depois,
            garantindo que a cabeça também apareça.
            É pergunta clássica de prova.
        */
        do{
            /*
                ⚠ BUG AQUI.

                getProximo() devolve o OBJETO No seguinte.
                Imprimir um objeto mostra o endereço na memória
                (algo como No@4554617c), e ainda por cima
                exibe o nó ERRADO — o seguinte, não o atual.

                O correto seria:
                    System.out.println(ponteiro.getNumero());

                getNumero() devolve o int guardado no nó atual,
                que é o que queremos ver na tela.
            */
            System.out.println(ponteiro.getProximo());
            ponteiro = ponteiro.getProximo();
        } while(ponteiro != cabeca);
    }
}