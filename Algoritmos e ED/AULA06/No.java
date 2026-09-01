/*
    package = a pasta/pacote onde a classe vive.
    Todas as classes deste pacote (No, Fila, Pilha, Principal)
    se enxergam sem precisar de import.

    O arquivo precisa estar numa pasta chamada AULA06,
    e a compilação é feita a partir da pasta ACIMA dela:

        javac AULA06/*.java
        java AULA06.Principal
*/
package AULA06;

public class No {

    //Propriedades da classe
    /*
        AUTORREFERÊNCIA: um No guarda uma referência a outro No.
        É isso que permite encadear os elementos.

        Esta classe é EXATAMENTE a mesma usada nas listas
        encadeadas. O nó não sabe se está numa lista, numa
        pilha ou numa fila — ele só guarda um valor e uma
        referência. Quem define o comportamento é a estrutura
        que decide ONDE inserir e ONDE remover.

        Valores iniciais:
        - int começa em 0    (padrão dos tipos primitivos)
        - No  começa em null (padrão dos tipos de referência)
    */
    private int numero = 0;
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
    public No( int numero, No proximo){
        super();
        /*
            "this" distingue o ATRIBUTO do PARÂMETRO,
            já que ambos se chamam "numero".
            Sem ele, "numero = numero" atribuiria o parâmetro
            a si mesmo e o atributo continuaria valendo 0.
        */
        this.numero = numero;
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
    public No getProximo(){
        return proximo;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
}