package AULA06;

public class Fila {
    //Propriedades da classe
    /*
        FILA (Queue) — política FIFO: First In, First Out.
        O primeiro a entrar é o primeiro a sair.

        Analogia: a fila do banco. Quem chega entra atrás,
        quem é atendido sai da frente.

        NESTA IMPLEMENTAÇÃO:
        - entrar() insere na CABEÇA (igual ao push da Pilha)
        - sair()  remove da CAUDA  (o oposto do pop)

        É essa assimetria que transforma a mesma estrutura
        de dados numa fila em vez de uma pilha.

            entrar(1) → [1]
            entrar(2) → [2] → [1]
            entrar(3) → [3] → [2] → [1]
                                     ↑
                                 mais antigo — sai primeiro
    */
    private No cabeca = null;
    
    //Métodos da classe
    public void entrar (int numero){
        /*
            Idêntico ao push() da Pilha: insere na cabeça.
            CUSTO: O(1).
        */
        cabeca= new No( numero, cabeca);
    }

    public void sair(){
        //Caso fácil: fila vazia
        if (cabeca == null){
            System.out.println("A fila está vazia");
            return;
        }

        //Caso médio: fila só tem um único nó
        /*
            Como saber que só há um? Ele não tem próximo.
            Precisa ser tratado à parte porque o caso geral
            abaixo procura o PENÚLTIMO nó — que aqui não existe.
        */
        if (cabeca.getProximo() == null){
            System.out.println(cabeca.getNumero());
            cabeca = null;
            return;
        }

        //Caso difícil: fila tem mais de um nó
        /*
            ⚠⚠ BUG CRÍTICO NA LINHA ABAIXO ⚠⚠

            "ponteiro" começa valendo null, e a linha seguinte
            chama ponteiro.getProximo(). Chamar um método em
            null lança NullPointerException IMEDIATAMENTE.

            O programa quebra na primeira chamada a sair()
            que chegue até aqui.

            CORREÇÃO:
                No ponteiro = cabeca;

            O percurso precisa COMEÇAR em algum nó real —
            e a cabeça é o único ponto de entrada que temos.
        */
        No ponteiro = null;

        /*
            A ideia do laço (correta, uma vez consertada a linha acima):

            Procura o PENÚLTIMO nó — aquele cujo
            proximo.proximo é null.

                [3] → [2] → [1] → null
                       ↑     ↑
                  penúltimo último

            Precisamos do penúltimo, e não do último, porque
            é ele quem vai passar a apontar para null quando
            o último for removido. Numa lista simplesmente
            encadeada não dá para voltar.

            CUSTO: O(n) — percorre a fila inteira a cada remoção.
            Esta é a diferença essencial em relação à Pilha,
            cujo pop() é O(1).
        */
        while (ponteiro.getProximo().getProximo() !=null){
            ponteiro = ponteiro.getProximo();
        }
        /*
            Imprime o ÚLTIMO (ponteiro.getProximo()) e depois
            corta a ligação, fazendo o penúltimo virar o novo fim.

                antes:  [2] → [1] → null
                depois: [2] → null
        */
        System.out.println(ponteiro.getProximo().getNumero());
        ponteiro.setProximo(null);
    }
}