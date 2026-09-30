package AULA08;

public class No {
    //Propriedades da classe
    private int numero = 0;
    private No proximo = null;

    //Métodos construtores da classe
    public No(){
        super();
    }
    public No(int numero, No proximo){
        super();
        this.numero = numero;
        this.proximo = proximo;
    }

    //Métodos de acesso da classe
    public int getNumero(){
        return numero;
    }
    //Não existe setNumero de propósito: se o número mudasse, o resto também
    //mudaria e o nó ficaria pendurado no diretor errado.
    public No getProximo(){
        return proximo;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
}
