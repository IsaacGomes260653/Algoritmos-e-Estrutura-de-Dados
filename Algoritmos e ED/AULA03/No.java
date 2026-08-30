public class No {
    // Propriedades da classe
    /*
        AUTORREFERÊNCIA: um No guarda uma referência a outro No.
        É exatamente isso que permite encadear os elementos —
        a classe se referencia a si mesma.

        Em Java não existe ponteiro explícito como em C.
        A variável "proximo" guarda o ENDEREÇO do próximo
        objeto na memória, ou null se não houver próximo.

        Valores iniciais:
        - int começa em 0 (padrão dos tipos primitivos)
        - No começa em null (padrão dos tipos de referência)

        Ambos são private: ninguém de fora acessa direto.
    */
    private int numero = 0;
    private No proximo = null;

    //Métodos construtores da classe
    /*
        Existem DOIS construtores com o mesmo nome, mas com
        parâmetros diferentes. Isso se chama SOBRECARGA
        (overloading) — o Java escolhe qual usar pelo número
        e tipo dos argumentos.

        Construtor não tem tipo de retorno, nem mesmo void,
        e precisa ter exatamente o nome da classe.
    */

    /*
        Construtor VAZIO (sem parâmetros).
        Cria um nó com numero = 0 e proximo = null.

        Atenção: assim que você declara qualquer construtor,
        o Java para de fornecer o construtor vazio automático.
        Por isso ele precisa ser escrito à mão aqui.
    */
    public No( ) {
        /*
            super() chama o construtor da classe pai.
            Toda classe em Java herda de Object, mesmo sem extends.

            Esta chamada é IMPLÍCITA — o Java a insere sozinho
            se você não escrever. Escrever apenas deixa
            a intenção visível.
        */
        super();
    }

    /*
        Construtor COMPLETO.
        É o usado pela Lista: new No(numero, null) cria
        o nó já com o valor e a ligação corretos.
    */
    public No(int numero, No proximo) {
        super();
        /*
            "this" distingue o ATRIBUTO da classe do PARÂMETRO
            recebido, já que os dois têm o mesmo nome:

                this.numero = atributo do objeto
                numero      = parâmetro do método

            Sem o "this", a linha seria "numero = numero",
            o parâmetro atribuído a si mesmo, e o atributo
            continuaria valendo 0. É um erro silencioso:
            compila normalmente e não funciona.
        */
        this.numero = numero;
        this.proximo = proximo;
    }

    //Métodos de acesso da classe
    /*
        GETTERS e SETTERS.

        Como os atributos são private, o acesso de fora
        passa obrigatoriamente por estes métodos.
        Isso é ENCAPSULAMENTO.

        Por que não deixar os atributos public e acabar?
        Porque assim é possível, mais tarde, validar valores
        ou mudar a implementação interna sem quebrar
        nenhum código que já usa a classe.

        Convenção Java:
        - getX()  devolve o valor, não recebe parâmetro
        - setX()  recebe o valor, não devolve nada (void)
    */
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*
        getProximo() devolve um OBJETO No, não um número.

        É a origem de um erro comum: imprimir o retorno deste
        método mostra o endereço na memória (No@4554617c)
        em vez de um valor. Para exibir o conteúdo,
        use getNumero().
    */
    public No getProximo() {
        return proximo;
    }
    /*
        setProximo() é o método que a Lista usa para
        RELIGAR os nós — tanto na inserção quanto na exclusão.
        É ele que efetivamente altera a estrutura da lista.
    */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}