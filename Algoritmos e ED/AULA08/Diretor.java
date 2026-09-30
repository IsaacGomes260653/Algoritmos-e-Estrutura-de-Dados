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

    //Métodos de acesso da classe
    public int getResto(){
        return resto;
    }
    //Não existe setResto de propósito: se o resto mudasse, todos os números
    //pendurados neste diretor ficariam no grupo errado.
    public No getProximoNo(){
        return proximoNo;
    }
    public void setProximoNo(No proximoNo){
        this.proximoNo = proximoNo;
    }
    public Diretor getProximoDiretor(){
        return proximoDiretor;
    }
    public void setProximoDiretor(Diretor proximoDiretor){
        this.proximoDiretor = proximoDiretor;
    }
}
