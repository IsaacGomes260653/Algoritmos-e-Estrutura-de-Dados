# Ciência da Computação — UniCEUB

Repositório de estudos e trabalhos da graduação em Ciência da Computação no UniCEUB. Reúne exercícios, projetos e implementações das disciplinas cursadas, organizados por matéria.

Todo o código é comentado com foco em revisão: a ideia é que cada arquivo continue fazendo sentido meses depois, quando eu voltar para consultá-lo.

*Coursework repository for my Computer Science degree at UniCEUB. Exercises, projects, and from-scratch implementations organized by subject, with study-oriented comments throughout.*

---

## 📚 Disciplinas

### Algoritmos e Estruturas de Dados — Java

Estruturas implementadas do zero, sem usar as classes prontas do `java.util`.

| Módulo | Conteúdo |
|--------|----------|
| `01-vetores-e-matrizes` | Preenchimento, inversão, transposição e multiplicação de matrizes |
| `02-lista-encadeada` | Lista simplesmente encadeada — inserção, exclusão e percurso |
| `03-lista-circular` | Lista circular com menu interativo |

**Conceitos:** arrays uni e bidimensionais, laços aninhados, encapsulamento, referências entre objetos, religação de ponteiros e análise de complexidade — O(n), O(n²), O(n³).

<!--
    Conforme novas disciplinas forem cursadas, adicione a seção
    seguindo este mesmo padrão: título, tabela de módulos e
    uma linha de conceitos praticados.
-->

---

## 📁 Organização

```
├── algoritmos-e-estruturas-de-dados/
│   ├── 01-vetores-e-matrizes/
│   ├── 02-lista-encadeada/
│   └── 03-lista-circular/
│
└── (novas disciplinas entram aqui)
```

Cada disciplina fica em uma pasta própria, e cada tópico em uma subpasta numerada. A numeração preserva a ordem em que o conteúdo foi visto em aula.

Pastas separadas também evitam colisão de nomes: `Lista.java` e `No.java` existem tanto na lista encadeada quanto na circular, e o Java não permite duas classes de mesmo nome no mesmo diretório.

---

## ▶️ Como executar

Cada pasta é independente. Entre nela e compile:

```bash
cd algoritmos-e-estruturas-de-dados/02-lista-encadeada
javac *.java
java Principal
```

Para exercícios com um único arquivo:

```bash
javac MatrizTransposta.java
java MatrizTransposta
```

**Requisito:** JDK 8 ou superior.

Projetos de outras linguagens trazem suas próprias instruções no README da respectiva pasta.

---

## 🎓 Sobre

Isaac Gomes de Moraes — Ciência da Computação, UniCEUB (conclusão prevista para dez/2028).

Este repositório é material acadêmico. Os projetos autorais estão em repositórios próprios, listados no meu [perfil](https://github.com/IsaacGomes260653).
