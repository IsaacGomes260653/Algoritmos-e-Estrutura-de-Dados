public class No {
    //Propriedade da classe
    /*
        AUTORREFERÊNCIA: um No guarda uma referência a outro No.
        É isso que permite encadear os elementos —
        a classe se referencia a si mesma.

        Em Java não existe ponteiro explícito como em C.
        A variável "proximo" guarda o ENDEREÇO do próximo
        objeto na memória.

        IMPORTANTE: esta classe é EXATAMENTE a mesma usada
        na lista simplesmente encadeada. O nó não sabe se está
        numa lista simples ou circular — quem decide isso é a
        classe Lista, pela forma como liga os nós:

            lista simples:  último → null
            lista circular: último → cabeça

        O nó apenas guarda um valor e uma referência.

        Valores iniciais:
        - int começa em 0    (padrão dos tipos primitivos)
        - No  começa em null (padrão dos tipos de referência)
    */
    private int numero = 0;
    private No proximo = null;

    //Métodos construtores da classe
    /*
        Dois construtores com o mesmo nome e parâmetros
        diferentes: isso é SOBRECARGA (overloading).
        O Java escolhe qual usar pelo número e tipo
        dos argumentos passados.

        Construtor não tem tipo de retorno, nem void,
        e precisa ter exatamente o nome da classe.
    */

    /*
        Construtor VAZIO.
        Cria um nó com numero = 0 e proximo = null.

        Assim que você declara qualquer construtor, o Java
        deixa de fornecer o vazio automaticamente —
        por isso ele precisa estar escrito aqui.
    */
    public No() {
        /*
            super() chama o construtor da classe pai.
            Toda classe em Java herda de Object, mesmo sem extends.

            A chamada é IMPLÍCITA: o Java a insere sozinho
            se você não escrever. Escrever só deixa a intenção clara.
        */
        super();
    }

    /*
        Construtor COMPLETO — o usado pela Lista.

        Na lista circular ele aparece de duas formas:
            new No(numero, null)    → primeiro nó, ajustado logo depois
            new No(numero, cabeca)  → nós seguintes, já fechando o círculo
    */
    public No(int numero, No proximo){
        super();
        /*
            "this" distingue o ATRIBUTO do PARÂMETRO,
            já que os dois se chamam "numero":

                this.numero = atributo do objeto
                numero      = parâmetro recebido

            Sem o "this", a linha viraria "numero = numero" —
            o parâmetro atribuído a si mesmo. O atributo
            continuaria valendo 0. Compila sem erro
            e não funciona: um bug silencioso.
        */
        this.numero = numero;
        this.proximo = proximo;
    }

    //Métodos de acesso da classe
    /*
        GETTERS e SETTERS.

        Os atributos são private, então todo acesso vindo
        de fora passa por estes métodos. Isso é ENCAPSULAMENTO.

        Por que não deixar os atributos public?
        Porque assim é possível, depois, validar valores ou
        mudar a implementação interna sem quebrar nenhum
        código que já usa a classe.

        Convenção Java:
        - getX() devolve o valor, sem parâmetro
        - setX() recebe o valor, sem retorno (void)
    */
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*
        getProximo() devolve um OBJETO No, não um número.

        Na lista circular ele nunca devolve null (a não ser
        no instante entre criar o primeiro nó e fazê-lo
        apontar para si mesmo). Percorrer comparando com null
        aqui geraria laço infinito.

        Cuidado ao imprimir o retorno deste método: aparece
        o endereço na memória (No@4554617c), não um valor.
        Para exibir o conteúdo, use getNumero().
    */
    public No getProximo() {
        return proximo;
    }
    /*
        setProximo() é o método que a Lista usa para RELIGAR
        os nós — na inserção, na exclusão, e para fechar
        o círculo apontando o último de volta para a cabeça.
        É ele que efetivamente altera a estrutura.
    */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}