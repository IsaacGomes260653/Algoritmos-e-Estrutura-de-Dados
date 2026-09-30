public class Principal {
    public static void main(String[] args){
        /*
            Como na AULA03, Principal nunca menciona a classe No.
            Todo o trabalho com os ponteiros acontece dentro
            da Lista — aqui só chamamos os métodos públicos.
        */
        Lista objLista = new Lista();

        //Primeiro teste: lista vazia
        /*
            TESTE DE BORDA. Nenhum dos dois métodos pode quebrar
            com cabeca == null. Nada aparece entre os títulos —
            e é exatamente esse o comportamento esperado.
        */
        System.out.println("--- vazia, para frente ---");
        objLista.imprimir();
        System.out.println("--- vazia, de trás para frente ---");
        objLista.imprimirInverso();

        // Cinco inserções em sequência
        objLista.inserir(1);
        objLista.inserir(2);
        objLista.inserir(3);
        objLista.inserir(4);
        objLista.inserir(5);

        //Segundo teste: os dois sentidos
        /*
            Saída esperada: 1 2 3 4 5 e depois 5 4 3 2 1.

            O TESTE MAIS IMPORTANTE DA LISTA DUPLA é imprimir
            nos dois sentidos. Se algum "anterior" tivesse
            ficado errado, a ida sairia certa e só a volta
            mostraria o problema.
        */
        System.out.println("--- 1 a 5, para frente ---");
        objLista.imprimir();
        System.out.println("--- 1 a 5, de trás para frente ---");
        objLista.imprimirInverso();

        //Terceiro teste: os cenários de exclusão
        /*
            Um de cada cenário do excluir():
            - 1  → o primeiro nó (a cabeça muda)
            - 3  → um nó do meio (religa os dois vizinhos)
            - 5  → o último nó   (não existe próximo para religar)
            - 10 → um número que não existe (nada muda)
        */
        objLista.excluir(1);
        objLista.excluir(3);
        objLista.excluir(5);
        objLista.excluir(10);

        // Saída esperada: 2 4 e depois 4 2
        System.out.println("--- sem 1, 3 e 5, para frente ---");
        objLista.imprimir();
        System.out.println("--- sem 1, 3 e 5, de trás para frente ---");
        objLista.imprimirInverso();

        //Quarto teste: esvaziar e reaproveitar
        /*
            Exclui os dois que sobraram. A lista precisa voltar
            a ficar vazia (nada impresso) e, depois, aceitar
            uma inserção nova normalmente.

            Se o excluir() deixasse algum ponteiro velho para trás,
            é aqui que o erro apareceria.
        */
        objLista.excluir(2);
        objLista.excluir(4);
        System.out.println("--- esvaziada ---");
        objLista.imprimir();

        objLista.inserir(7);
        // Saída esperada: 7 e depois 7
        System.out.println("--- só o 7, para frente ---");
        objLista.imprimir();
        System.out.println("--- só o 7, de trás para frente ---");
        objLista.imprimirInverso();
    }
}
