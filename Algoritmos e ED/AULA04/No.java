public class No {
    //Propriedades da classe
    /*
        NÓ DE LISTA DUPLAMENTE ENCADEADA: além do "proximo",
        cada nó guarda também o "anterior".

            null ← [1] ⇄ [2] ⇄ [3] → null

        A única diferença para o No da lista simples
        (AULA03) é esse terceiro atributo. Mas ele muda tudo:
        agora dá para andar pela lista nos DOIS sentidos.

        O preço: cada nó gasta memória para uma referência
        a mais, e toda religação passa a mexer em dois
        ponteiros em vez de um.

        Valores iniciais:
        - int começa em 0    (padrão dos tipos primitivos)
        - No  começa em null (padrão dos tipos de referência)
    */
    private int numero = 0;
    private No anterior = null;
    private No proximo = null;

    //Métodos construtores da classe
    /*
        Dois construtores com o mesmo nome e parâmetros
        diferentes: SOBRECARGA (overloading).
    */
    public No() {
        // super() chama o construtor de Object — implícito em Java
        super();
    }

    /*
        Construtor COMPLETO — o usado pela Lista.

        O número vem primeiro, como nos outros Nos.
        Depois vêm os ponteiros, na ordem em que aparecem
        na lista — primeiro quem vem antes, depois quem vem depois:

            new No(numero, anterior, proximo)
    */
    public No(int numero, No anterior, No proximo) {
        super();
        /*
            "this" distingue o ATRIBUTO do PARÂMETRO,
            já que os dois têm o mesmo nome.
        */
        this.numero = numero;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    //Métodos de acesso da classe
    /*
        Getters e setters: os atributos são private,
        então todo acesso externo passa por aqui.
        Isso é ENCAPSULAMENTO.
    */
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*
        getAnterior() é o que a lista simples NÃO tinha.
        É ele que permite voltar um nó sem precisar
        percorrer tudo de novo a partir da cabeça.
    */
    public No getAnterior() {
        return anterior;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
