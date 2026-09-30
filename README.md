# Ciência da Computação — UniCEUB

Repositório de estudos e trabalhos da graduação em Ciência da Computação no UniCEUB. Reúne exercícios, projetos e implementações das disciplinas cursadas, organizados por matéria.

Todo o código é comentado com foco em revisão: a ideia é que cada arquivo continue fazendo sentido meses depois, quando eu voltar para consultá-lo.

*Coursework repository for my Computer Science degree at UniCEUB. Exercises, projects, and from-scratch implementations organized by subject, with study-oriented comments throughout.*

---

## 📚 Disciplinas

### Algoritmos e Estruturas de Dados — Java

Estruturas implementadas do zero, sem usar as classes prontas do `java.util`.

| Pasta | Conteúdo |
|-------|----------|
| `AULA01` | Vetores e matrizes — preenchimento, inversão, transposição e multiplicação de matrizes |
| `AULA02` | Ordenação (Selection Sort e Bubble Sort) e busca (exaustiva e binária) em vetores |
| `AULA03` | Lista simplesmente encadeada — inserção, exclusão e percurso |
| `AULA04` | Lista duplamente encadeada — exclusão sem nó anterior e percurso nos dois sentidos |
| `AULA05` | Lista circular com menu interativo |
| `AULA06` | Pilha (LIFO) e fila (FIFO) com nós encadeados — experimento de desempenho O(1) × O(n) |
| `AULA08` | Matriz esparsa como tabela de dispersão — resto da divisão, colisões e encadeamento |

**Conceitos:** arrays uni e bidimensionais, laços aninhados, encapsulamento, referências entre objetos, religação de ponteiros, lista circular, pilha (LIFO) e fila (FIFO), tabela de dispersão com encadeamento e análise de complexidade — O(1), O(n), O(n²), O(n³).

<!--
    Conforme novas disciplinas forem cursadas, adicione a seção
    seguindo este mesmo padrão: título, tabela de módulos e
    uma linha de conceitos praticados.
-->

---

## 📁 Organização

```
├── Algoritmos e ED/
│   ├── AULA01/   vetores e matrizes
│   ├── AULA03/   lista encadeada
│   ├── AULA05/   lista circular
│   ├── AULA06/   pilha e fila
│   └── AULA08/   matriz esparsa (tabela de dispersão)
│
└── (novas disciplinas entram aqui)
```

Cada disciplina fica em uma pasta própria, e cada aula com código em uma subpasta `AULAxx`. O número é o da aula em que o conteúdo foi visto, por isso a sequência pode ter saltos.

Pastas separadas também evitam colisão de nomes: `No.java` existe em quatro aulas e `Lista.java` em duas, e o Java não permite duas classes de mesmo nome no mesmo diretório.

---

## ▶️ Como executar

Cada pasta é independente. As aspas nos comandos são necessárias por causa dos espaços em `Algoritmos e ED`.

**Pastas sem `package`** (`AULA01`, `AULA03`, `AULA05`): entre na pasta e compile.

```bash
cd "Algoritmos e ED/AULA03"
javac *.java
java Principal
```

Para exercícios com um único arquivo (`AULA01`):

```bash
cd "Algoritmos e ED/AULA01"
javac MatrizTransposta.java
java MatrizTransposta
```

**Pastas com `package`** (`AULA06`, `AULA08`): compile a partir da pasta de cima. O Java exige que as classes do pacote `AULA08` estejam numa pasta chamada `AULA08`, e o nome da classe passa a incluir o pacote.

```bash
cd "Algoritmos e ED"
javac AULA08/*.java
java AULA08.Principal
```

No Windows com JDK anterior ao 18, acrescente `-encoding UTF-8` ao `javac` para os acentos aparecerem corretamente.

**Requisito:** JDK 8 ou superior.

Projetos de outras linguagens trazem suas próprias instruções no README da respectiva pasta.

---

## 🎓 Sobre

Isaac Gomes de Moraes — Ciência da Computação, UniCEUB (conclusão prevista para dez/2028).

Este repositório é material acadêmico. Os projetos autorais estão em repositórios próprios, listados no meu [perfil](https://github.com/IsaacGomes260653).
