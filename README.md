# ALGORITMO HÚNGARO (Problema da Designação)

## Integrantes do grupo de trabalho:

Felipe Coelho da Silva<br>
Gabriel Max Soares e Souza<br>
Matheus Mastellona de Azevedo Noronha<br>
Otavio Emilio da Silva Pinto<br>

## Contextualização do <b>Problema da Designação</b>:

Esse problema, também chamado de Problema de Atribuição ou Alocação, consiste numa subcategoria do problema de Transporte, de modo que o objetivo também é a minimização do custo. O assunto, porém, se dá no escopo de Pessoas disponíveis para realizar tarefas e das respectivas atividades a serem executadas.<br>

O método escolhido para solucionar o problema em questão é Algoritmo Húngaro. Sendo assim, é necessário atender alguns requisitos para configurar o problema adequadamente e atingir a solução ótima, equivalente ao custo mínimo:
* Cada tarefa deve ser atribuída a exatamente uma pessoa;
* Nenhuma pessoa pode ficar sem atribuição de tarefa (à toa), pois seria um desperdício na alocação;
* Se tratando de um problema de transporte, cada tarefa tem um custo associado para sua execução;
A partir dessas designações de pessoas a tarefas, é possível encontrar o custo mínimo das alocações, objetivo do problema.

É possível entender rapidamente a utilidade dessa ferramenta se imaginarmos, por exemplo: temos 3 empregados, que podem pode realizar 3 trabalhos distintos, e naturalmente cada empregado realiza esse trabalho em seu próprio tempo que pode diferir dos demais (conforme aptidão para a tarefa). Quando a quantidade de variáveis na situação cresce, calcular as atribuições manualmente se torna muito complexo e é aí que se destaca o algoritmo Húngaro, para solucionar o problema de modo eficiente.
