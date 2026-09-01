package AULA06;

public class Principal {
    public static void main(String[] args){
        /*
            ESTE ARQUIVO É UM EXPERIMENTO DE DESEMPENHO.

            As duas estruturas recebem exatamente a mesma carga:
            100.001 inserções e 100.001 remoções.
            A diferença no tempo de execução vem apenas
            da complexidade dos algoritmos.
        */

        Fila objFila = new Fila();

        /*
            Atenção ao <= : o laço roda de 0 a 100000,
            ou seja, 100.001 vezes — e não 100.000.
            Com < seriam 100.000. É o clássico erro
            de "off-by-one", que vale sempre conferir.

            entrar() é O(1), então esta parte é rápida.
        */
        for (int i= 0; i <= 100000; i++){
            objFila.entrar(i);
        }

        /*
            ⚠ O PROGRAMA QUEBRA AQUI, na primeira iteração,
            por causa do "No ponteiro = null" em Fila.sair().

            Uma vez corrigido, observe: como sair() é O(n),
            remover n elementos custa O(n²) — cerca de
            5 BILHÕES de operações. Vai demorar muito.
        */
        for (int i = 0; i <=100000; i++){
            objFila.sair();
        }

        Pilha objPilha = new Pilha();

        /*
            A MESMA carga aplicada à Pilha.

            push() e pop() são ambos O(1), então os dois laços
            juntos são O(n) — terminam quase instantaneamente.

            ESTA É A LIÇÃO DA AULA: mesma estrutura de dados
            por baixo (nós encadeados), mesma quantidade de
            operações, tempos de execução completamente
            diferentes. O que muda é ONDE cada estrutura
            insere e remove.

            Remover da cabeça é O(1).
            Remover da cauda, sem ponteiro para ela, é O(n).
        */
        for(int i = 0; i <= 100000; i++){
            objPilha.push(i);
        }
        for (int i = 0; i <= 100000; i++){
            objPilha.pop();
        }
    }
}