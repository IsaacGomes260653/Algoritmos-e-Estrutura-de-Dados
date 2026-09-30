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

    //Devolve o diretor do resto do número. Se ele não existir, CRIA um novo.
    //Por isso só serve para inserir: buscar e remover não podem criar diretores.
    private Diretor procurarDiretor(int numero){
        int resto = calcularResto(numero);

        //O ponteiro começa no primeiro diretor e anda um diretor por volta.
        //Para quando: chegou ao fim (null) OU achou o diretor do resto.
        //A ordem do && importa: se ponteiro for null, o Java nem avalia
        //ponteiro.getResto() (curto-circuito), evitando NullPointerException.
        Diretor ponteiro = cabeca;
        while ((ponteiro != null) && (ponteiro.getResto() != resto)){
            ponteiro = ponteiro.getProximoDiretor();
        }

        //Cenário de resto encontrado
        if (ponteiro != null){
            return ponteiro;
        }

        //Cenário de resto NÃO encontrado: cria o diretor já no INÍCIO da lista
        //de diretores. O novo diretor aponta para a cabeca antiga e depois
        //passa a ser a nova cabeca. Custa O(1) e funciona até com a lista vazia
        //(cabeca == null: o novo diretor aponta para null e vira o único).
        cabeca = new Diretor(resto, null, cabeca);
        return cabeca;
    }
    public void inserir(int numero){
        Diretor ponteiroDiretor = procurarDiretor(numero);
        //Inserção no início da lista de nós, em dois passos numa linha só:
        //1) new No(numero, ponteiroDiretor.getProximoNo()): o novo nó aponta
        //   para quem ERA o primeiro nó do diretor (ou null se não havia nenhum);
        //2) setProximoNo(...): o diretor passa a apontar para o novo nó.
        //A ordem é essencial: se o diretor mudasse primeiro, perderíamos a
        //referência para o resto da lista.
        ponteiroDiretor.setProximoNo(new No(numero, ponteiroDiretor.getProximoNo()));
    }
    public boolean buscar(int numero){
        int resto = calcularResto(numero);

        //Procura o diretor do resto SEM criar (diferente de procurarDiretor)
        Diretor ponteiroDiretor = cabeca;
        while ((ponteiroDiretor != null) && (ponteiroDiretor.getResto() != resto)){
            ponteiroDiretor = ponteiroDiretor.getProximoDiretor();
        }

        //Cenário de diretor NÃO encontrado (inclui a estrutura vazia):
        //se nem o grupo existe, o número com certeza não está lá.
        if (ponteiroDiretor == null){
            return false;
        }

        //Cenário de diretor encontrado: percorre SÓ os nós deste diretor.
        //Os outros diretores nem são olhados: essa é a vantagem da dispersão.
        No ponteiro = ponteiroDiretor.getProximoNo();
        while ((ponteiro != null) && (ponteiro.getNumero() != numero)){
            ponteiro = ponteiro.getProximo();
        }
        //Se o ponteiro parou antes do fim, parou em cima do número
        return ponteiro != null;
    }
}
