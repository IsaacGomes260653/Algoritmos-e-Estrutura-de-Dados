package AULA08;

public class MatrizEsparsa {
    //Propriedades da classe
    private Diretor cabeca = null;
    private int modulo = 0;

    //Método construtor cheio da classe
    public MatrizEsparsa(int modulo){
        super();
        //Cenário de módulo inválido: modulo 0 causaria divisão por zero em
        //todo cálculo de resto, e modulo negativo geraria restos negativos.
        //Melhor avisar agora, na criação, do que falhar depois no meio do uso.
        if (modulo <= 0){
            throw new IllegalArgumentException("O módulo deve ser maior que zero: " + modulo);
        }
        this.modulo = modulo;
    }

    //Métodos da classe

    //Função de dispersão: diz em qual diretor (grupo) o número deve ficar.
    //Math.floorMod sempre devolve um resto entre 0 e modulo - 1, mesmo para
    //números negativos (-7 % 5 dá -2, mas Math.floorMod(-7, 5) dá 3).
    private int calcularResto(int numero){
        return Math.floorMod(numero, modulo);
    }

    private Diretor procurarDiretor(int numero){
        int resto = calcularResto(numero);

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
