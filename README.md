# Mentoria de Java, clean code, a vida, o universo e tudo mais...

## Como está o programa

O programa dá a possibilidade ao usuário de adicionar, exibir, atualizar e remover uma pessoa com nome e CPF cadastrados.
As informações gravadas não são persistentes, ou seja, cada vez que o programa é iniciado, a lista está vazia.

## O que aprendi nessa semana

* 04/02 - Aprendi a lidar melhor com ArrayList, criei um método privado para iterar sobre a lista e exibir seu conteúdo, deixando o código mais limpo, e explorei um pouco a diferença entre classes e interfaces em uma tentativa de otimizar o código.

## Resumo do livro Clean Code

### O que é o Clean Code
O código limpo é um conceito fácil de entender e difícil de aplicar. 
É fácil de entender porque é notável quando um código é limpo: está bem escrito, de fácil entendimento, simples e eficiente. 
Porém, para escrever algo neste nível, é que mora a grande dificuldade: como? 
O primeiro capítulo explora como alguns notáveis programadores percebem um código limpo e suas qualidades. 
Apesar de ideias divergentes, todas se complementam e culminam na necessidade de um código limpo com algo que traz valor ao negócio.
Novamente, é bem simples de entender o porquê. Um código limpo diminui o tempo gasto com ele, pois é mais fácil de entender, de manter, e de resistir ao tempo.

###  Nomes significativos
Todos os palavras que não são reservadas da linguagem precisam ser muito bem pensadas antes de serem escritas em um código. 
Essas palavras, sejam nomes de funções, variáveis, classes, precisam ser significativas e responder a pergunta: o que essa coisa nomeada faz?
Como nenhum código vem com o programador embutido para explicar todos os detalhes, tal programador deve se preocupar em escrever seu código como um escritor faria.
Para tanto, o bom senso deve imperar: nomes claros, significativos, consistentes e que reflitam o negócio em questão.

Caso o negócio seja uma escola, nada melhor do que usar uma classe chamada `Alunos` para tratar dos mesmos, ao invés de `Usuários`, por exemplo. 
Se há um método `exibeNomes`, e outro `mostraTurmas`, não há motivo para termos diferentes como exibir e mostrar, já que ambos fazem a mesma coisa.
Nomes confusos, siglas, acrônimos, ou qualquer outro que possa trazer dúvidas a alguém devem ser evitados. 
Também pensando que um atributo ou variável é um dado, e uma função ou método é uma ação, melhor nomeá-los como substantivo e verbo, respectivamente.

### Funções
As funções são pedaços de código que podem ser repetidos somente chamando a função pelo seu nome.
Com isso, é possível perceber a importância de uma função limpa, e com um nome que a define com clareza.
Para fácil entendimento, uma função deve ser pequena e específica: somente uma ação deve ser executada por função.
Se a função tem duas funções, algo não está certo.

Uma função também pode receber parâmetros, mas o ideal é que não receba nenhum.
Um parâmetro se não for possível evitar, dois no máximo, três já pode trazer problemas, mas podem ser usados se houver uma boa justificativa.
E parâmetros do tipo booleano já implicam que a função faz mais do que deveria.
Além dos parâmetros, uma função por excelência retorna algo, e é assim que ela deve ser na programação também. 
Se possível, que ela não altere nada fora do seu escopo, ou seja, que ela não cause efeitos colaterais.

### Comentários
Os comentários devem ser evitados a todo custo. 
São práticas ruins de programação, e se existem, normalmente algo no código não está correto.
Ou um método que está fazendo mais coisas do que devia, ou uma variável com um nome ruim, ou uma lógica que não faz sentido.
Explicar esses porblemas com comentários, além de não resolver o problema em si, pode trazer consequências piores.
Um comentário pode não evoluir conforme o código evolui, deixando-o desatualizado e por muitas vezes, deslocado do código.
E uma situação pior é que um comentário pode explicar o que o código faz de uma maneira errada, trazendo consequências potencialmente catastróficas para os programadores que o lerão.

Mas há situações que um comentário pode ajudar um código que já é bem escrito por natureza. 
Podem explicar a importância de um ponto do código, ou trazer informações de caráter legal, ou ainda prevenir que algumas coisas sejam executadas ou modificadas.
Porém, no geral, ainda é possível melhorar o código para evitar tais situações, e deixá-lo mais limpo como consequência.
Importante salientar que é possível comentar trechos de códigos, porém só deixam o código mais poluído e trazem dúvidas a quem vai ler, portanto essa prática também deve ser evitada.


## Para executar o programa
```shell script
git clone https://github.com/f-ernanda/mentoria-java.git
cd src
javac -cp . application/*.java
java -cp . application/Program
```