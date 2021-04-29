# Mentoria de Java, clean code, a vida, o universo e tudo mais...

## Como está o programa

O programa dá a possibilidade ao usuário de adicionar, exibir, atualizar e remover uma pessoa com nome e CPF cadastrados.
As informações gravadas são persistentes, e foi usado o JDBC Template para a conexão com o banco de dados.

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
Comentários podem ser utilizados, mas com exceção de situações específicas, devem ser evitados, pois geralmente indicam algo errado no código.
Ou um método que está fazendo mais coisas do que devia, ou uma variável com um nome ruim, ou uma lógica que não faz sentido.
Explicar esses porblemas com comentários, além de não resolver o problema em si, pode trazer consequências piores.
Um comentário pode não evoluir conforme o código evolui, deixando-o desatualizado e por muitas vezes, deslocado do código.
E uma situação pior é que um comentário pode explicar o que o código faz de uma maneira errada, trazendo consequências potencialmente catastróficas para os programadores que o lerão.

Mas há situações que um comentário pode ajudar um código que já é bem escrito por natureza. 
Podem explicar a importância de um ponto do código, ou trazer informações de caráter legal, ou ainda prevenir que algumas coisas sejam executadas ou modificadas.
Porém, no geral, ainda é possível melhorar o código para evitar tais situações, e deixá-lo mais limpo como consequência.
Importante salientar que é possível comentar trechos de códigos, porém só deixam o código mais poluído e trazem dúvidas a quem vai ler, portanto essa prática também deve ser evitada.

### Formatação
Neste capítulo ficou claro qual é o principal trabalho de um desenvolvedor: a comunicação. 
A formatação ajuda a melhorar essa comunicação entre desenvolvedores, e pode ser dividida em formatação vertical e horizontal.
A formatação vertical diz respeito a quantidade de linhas e o agrupamento em blocos.
A quantidade de linhas, em termos gerais, reflete no tamanho que um arquivo possui. 
Um arquivo mais leve geralmente é preferível, e facilita a leitura e entendimento do código.
Já o agrupamento, pode ser feito de diversas maneiras. 
Uma boa prática é separar por uma linha em branco pedaços de código que refletem um pensamento, e deixar blocos afins ou relacionados próximos no arquivo.

Já a formatação horizontal é relacionada com a quantidade de caracteres presentes em uma linha, e espaçamentos entre termos.
Um número sugerido de caracteres por linha gira em torno de 120, pois linhas longas são incômodas de ler e geram um scroll horizontal.
Já o espaçamento, apesar de não ser regra, é recomendado deixar termos que são separados com espaço, como uma atribuição e o operador, e termos afins sem espaços, como os parênteses e a palavra reservada `for`.
Outra questão de espaçamentos é a indetação, que auxilia entender a hierarquia de um código, e facilita sua assimilação.

### Objetos e estruturas de dados
Uma importante diferença entre objetos e estruturas é com cada um lida com a exposição dos seus dados.
Um objeto esconde os dados por meio de abstrações e expõe funções para trabalhar com esses dados. 
Isso permite com que o usuário manipule a essência do dado, sem saber as suas implementações.
A programação orientada a objetos tem a abstração como um dos seus pilares.

Já nas estruturas, os dados são expostos, e nenhuma função significativa é implementada.
As estruturas são pensadas de uma maneira procedural, e neste paradigma, é mais fácil adicionar novas funções sem mexer nas estruturas já existentes.
Contudo, é mais difícil para adicionar novas estruturas, já que todas as funções devem ser adaptadas.

E qual usar? Como sempre, depende. Há situações que é preciso flexibilidade para adicionar novos dados, então objetos são preferíveis. 
Mas também haverá situações que novos comportamentos serão mais frequentes, então uma abordagem procedural é mais eficiente.
O único conselho é não misturar os paradigmas em uma mesma estrutura, pois dificultará a adição de qualquer coisa no programa.

### Tratamento de erros
O tratamento de erros deve ser planejado com cuidado pelos programadores, já que pode obstruir a lógica do programa se usado em excesso.
Eles devem existir em situações que façam sentido, e sempre da melhor maneira possível.
Isso inclui lançar uma exceção ao invés de esconder o erro, criar mensagens significativas sobre o erro e evitar retornar e passar o `null` nos métodos, pois pode gerar mais erros.
Também é interessante separar o tratamento de erros da lógica do negócio, criando um programa robusto e limpo ao mesmo tempo.
Quando os tratamentos de erros estão declarados de maneira independente da lógica, fica mais simples entender os porquês dos erros, melhorando a manutenção do programa.

### Limites
Ao usar códigos de terceiros, é importante ter em mente que as APIs são pensadas de maneira genérica, para atender diversas situações, mas o que normalmente se quer no programa é uma solução específica.
Portanto, encapsular o código de terceiros para que métodos não pertinentes vazem para outras partes do programa é uma boa solução.
Outra questão interessante, tanto para o programa quanto para a aprender ferramentas novas, é fazer testes com códigos de terceiros que podem ser adicionados no programa.
Além de aprender de forma mais eficiente como o código funciona, ainda se garante que ele funcione do jeito esperado.
Ter esses testes escritos é válido também quando o código terceiro evoluí, ou tirando bugs, ou acrescentando funcionalidades, e garantir que esse código ainda seja efetivo no programa.

### Testes unitários


### Classes


### Sistema