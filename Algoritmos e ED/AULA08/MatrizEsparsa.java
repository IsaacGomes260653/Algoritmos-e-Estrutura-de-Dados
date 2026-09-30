package AULA08;

public class MatrizEsparsa {
    //Propriedades da classe
    private Diretor cabeca = null;
    private int modulo = 0;

    //Método construtor cheio da classe
    public MatrizEsparsa(int modulo){
        this.modulo = modulo;
    }

    //Métodos da classe
    private Diretor procurarDiretor(int numero){
        int resto = (numero & modulo);

        Diretor ponteiro = cabeca;
        while ((ponteiro != null) && (ponteiro.getResto() != resto)){
            ponteiro = ponteiro.getProximoDiretor();
        }

        //Cenário de resto encontrado
        if (ponteiro != null){
            return ponteiro;
        }

        //Cenário de resto NÃO encontrado
        cabeca = new Diretor(resto, null, cabeca);
        return cabeca;
    }
    public void inserir(int numero){
        Diretor ponteiroDiretor = procurarDiretor(numero);
        ponteiroDiretor.setProximoNo(new No(numero, ponteiroDiretor.getProximoNo()));
    }

}
