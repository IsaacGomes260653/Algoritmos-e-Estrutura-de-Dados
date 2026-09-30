package AULA08;

public class Diretor {
    //Propriedades da classe
    private int resto = 0;
    private No proximoNo = null;
    private Diretor proximoDiretor = null;

    //Métodos construtores da classe
    public Diretor(){
        super();
    }
    public Diretor(int resto, No proximoNo, Diretor proximoDiretor){
        super();
        this.resto = resto;
        this.proximoNo = proximoNo;
        this.proximoDiretor = proximoDiretor;
    }
}
