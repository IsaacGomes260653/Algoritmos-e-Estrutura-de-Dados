/*
    package = a pasta/pacote onde a classe vive.
    Todas as classes deste pacote (No, Deque, Principal)
    se enxergam sem precisar de import.

    O arquivo precisa estar numa pasta chamada AULA07,
    e a compilação é feita a partir da pasta ACIMA dela:

        javac AULA07/*.java
        java AULA07.Principal
*/
package AULA07;

public class No {

    //Propriedades da classe
    /*
        O MESMO nó da lista duplamente encadeada (AULA04):
        um valor e duas referências, uma para cada lado.

            null ← [1] ⇄ [2] ⇄ [3] → null

        O deque precisa do "anterior" para remover do FIM
        em O(1): sem ele, achar o penúltimo exigiria percorrer
        tudo desde a cabeça — exatamente o problema do
        sair() da Fila na AULA06.

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
    public No(){
        // super() chama o construtor de Object — implícito em Java
        super();
    }
    public No(int numero, No anterior, No proximo){
        super();
        /*
            "this" distingue o ATRIBUTO do PARÂMETRO,
            já que ambos têm o mesmo nome.
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
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public No getAnterior(){
        return anterior;
    }
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }
    public No getProximo(){
        return proximo;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
}
