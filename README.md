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

## Modelagem matemática
Problema a modelar: Uma empresa possui tarefas a executar em 19 cidades diferentes espalhadas pelo mundo. Essa mesma empresa possui 20 funcionários aptos a viajar para desempenhar as atividades mencionadas. De que modo é necessário alocar esses funcionários para que todos possuam uma designação e custem o mínimo possível à empresa nas viagens até as cidades de interesse?
![teste](https://github.com/OtavioESP/AlgoritmoHungaro/assets/78800453/3ad90602-ca37-415a-94eb-ef5c156770c4)
![teste2](https://github.com/OtavioESP/AlgoritmoHungaro/assets/78800453/c0020f00-70db-4d05-a5e5-2a095805e7a6)
![teste3](https://github.com/OtavioESP/AlgoritmoHungaro/assets/78800453/a5c42e61-35c9-495e-9dd1-3a29208f5d6a)

(Fonte demonstrando o passo passo em anexo: [Modelagem Matemática (19x20).xlsx](https://github.com/OtavioESP/AlgoritmoHungaro/files/13468583/Modelagem.Matematica.19x20.xlsx))

## Exemplo de solução com o algoritmo implementado
### MATRIZ ORIGINAL
865 705 844 727 618 894 529 626 619 946 707 784 591 968 667 587 925 589 879 769 <br>
798 574 618 692 987 948 768 559 648 753 783 570 592 611 710 923 981 865 833 702 <br>
916 812 887 685 978 816 784 891 575 808 716 934 676 692 727 957 674 998 584 905 <br>
681 976 566 559 989 938 747 729 798 934 952 783 680 994 569 582 922 972 696 612 <br>
858 773 836 890 977 684 939 613 651 636 590 641 695 525 535 781 556 999 784 952 <br>
796 784 825 905 712 676 628 625 695 671 826 733 601 640 695 628 567 639 967 743 <br>
677 936 586 926 950 534 571 826 644 643 697 691 734 550 812 905 606 939 651 546 <br>
681 827 838 839 625 953 696 877 811 639 796 612 844 978 899 558 832 523 899 536 <br>
664 731 621 933 677 893 621 793 698 855 534 748 756 587 695 700 553 720 987 925 <br>
768 951 587 781 913 662 698 533 565 779 628 640 868 693 758 902 951 703 701 932 <br>
769 983 762 529 958 823 581 731 764 892 744 998 907 674 978 980 792 823 746 982 <br>
598 785 574 800 896 918 653 735 818 546 783 988 808 686 516 992 718 884 938 946 <br>
762 677 587 982 642 693 654 661 737 836 998 641 816 894 917 746 700 984 548 991 <br>
565 923 637 896 789 539 640 612 911 532 834 713 758 731 520 682 870 789 813 639 <br>
590 716 722 674 566 851 996 787 554 998 733 978 568 887 710 590 719 847 585 566 <br>
878 866 944 799 556 940 594 940 622 855 963 983 595 966 725 854 700 861 559 748 <br>
606 552 789 864 644 759 671 964 813 975 673 870 834 594 556 755 577 523 601 789 <br>
626 742 613 597 732 698 878 678 894 985 588 693 797 999 648 854 620 561 656 838 <br>
826 547 853 577 723 748 790 701 559 662 788 708 853 893 929 888 678 939 972 819 <br>

### SOLUÇÃO DO ALGORITMO HÚNGARO
Pares ordenados (Linha, Coluna) de elementos integrantes da solução ótima, referenciando matriz original de custo:  <br>
Linha 1, Coluna 7: 529 <br>
Linha 2, Coluna 8: 559 <br>
Linha 3, Coluna 9: 575 <br>
Linha 4, Coluna 4: 559 <br>
Linha 5, Coluna 14: 525 <br>
Linha 6, Coluna 17: 567 <br>
Linha 7, Coluna 6: 534 <br>
Linha 8, Coluna 18: 523 <br>
Linha 9, Coluna 11: 534 <br>
Linha 10, Coluna 3: 587 <br>
Linha 11, Coluna 19: 746 <br>
Linha 12, Coluna 15: 516 <br>
Linha 13, Coluna 12: 641 <br>
Linha 14, Coluna 10: 532 <br>
Linha 15, Coluna 5: 566 <br>
Linha 16, Coluna 13: 595 <br>
Linha 17, Coluna 2: 552 <br>
Linha 18, Coluna 1: 626 <br>
Linha 19, Coluna 20: 819 <br>
Linha 20, Coluna 0: 0 (Dummy) <br>
Custo mínimo: 11085 <br>
