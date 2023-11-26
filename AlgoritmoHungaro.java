import java.util.Arrays;

public class AlgoritmoHungaro {

    public static boolean isInteiro(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void preProcessarMatriz(Object[][] matriz, int valorSubstituto) {
        int numLinhas = matriz.length;
        int numColunas = matriz[0].length;

        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
                if (matriz[i][j] instanceof String && !isInteiro((String) matriz[i][j])) {
                    matriz[i][j] = valorSubstituto;
                }
            }
        }
    }

    public static Object[] executarAlgoritmoHungaro(Object[][] matriz) {
        int numLinhas = matriz.length;
        int numColunas = matriz[0].length;

        int[][] matrizOriginal = new int[numLinhas][numColunas];
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
                matrizOriginal[i][j] = Integer.parseInt(String.valueOf(matriz[i][j]));
            }
        }

        if (numLinhas != numColunas) {
            int tamanhoMaximo = Math.max(numLinhas, numColunas);
            int[][] novaMatriz = new int[tamanhoMaximo][tamanhoMaximo];
            for (int i = 0; i < tamanhoMaximo; i++) {
                for (int j = 0; j < tamanhoMaximo; j++) {
                    if (i < numLinhas && j < numColunas) {
                        novaMatriz[i][j] = matrizOriginal[i][j];
                    } else {
                        novaMatriz[i][j] = 0;
                    }
                }
            }
            matrizOriginal = novaMatriz;
            numLinhas = numColunas = tamanhoMaximo;
        }

        for (int i = 0; i < numLinhas; i++) {
            int valorMinimo = Arrays.stream(matrizOriginal[i]).min().getAsInt();
            for (int j = 0; j < numColunas; j++) {
                matrizOriginal[i][j] -= valorMinimo;
            }
        }

        for (int j = 0; j < numColunas; j++) {
            int valorMinimo = Integer.MAX_VALUE;
            for (int i = 0; i < numLinhas; i++) {
                if (matrizOriginal[i][j] < valorMinimo) {
                    valorMinimo = matrizOriginal[i][j];
                }
            }
            for (int i = 0; i < numLinhas; i++) {
                matrizOriginal[i][j] -= valorMinimo;
            }
        }

        boolean[] linhasCobertas = new boolean[numLinhas];
        boolean[] colunasCobertas = new boolean[numColunas];
        int[] solucao = new int[numLinhas];
        boolean[] tarefasAtribuidas = new boolean[numColunas];
        boolean[] pessoasAtarefadas = new boolean[numLinhas];
        Arrays.fill(solucao, -1);

        for (int i = 0; i < numLinhas; i++) {
            boolean encontrado = false;

            for (int j = 0; j < numColunas; j++) {
                if (matrizOriginal[i][j] == 0 && !linhasCobertas[i] && !colunasCobertas[j]) {
                    solucao[i] = j;
                    linhasCobertas[i] = true;
                    colunasCobertas[j] = true;
                    tarefasAtribuidas[j] = true;
                    pessoasAtarefadas[i] = true;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                int valorMinimo = Integer.MAX_VALUE;

                for (int j = 0; j < numColunas; j++) {
                    if (!colunasCobertas[j]) {
                        valorMinimo = Math.min(valorMinimo, matrizOriginal[i][j]);
                    }
                }

                for (int j = 0; j < numColunas; j++) {
                    if (!colunasCobertas[j]) {
                        matrizOriginal[i][j] -= valorMinimo;
                    } else if (linhasCobertas[i] && colunasCobertas[j]) {
                        matrizOriginal[i][j] += valorMinimo;
                    }
                }

                i--;
            }
        }

        for (int i = 0; i < pessoasAtarefadas.length; i++) {
            if (!pessoasAtarefadas[i]) {
                System.out.println("Erro: Não foi possível atribuir uma tarefa à pessoa " +
                        i);
                return new Object[] { null, Integer.MAX_VALUE };
            }
        }

        return new Object[] { solucao, matrizOriginal };
    }

    public static void main(String[] args) {

        Object[][] matriz = {
                { 865, 705, 844, 727, 618, 894, 529, 626, 619, 946, 707, 784, 591, 968, 667,
                        587, 925, 589, 879, 769 },
                { 798, 574, 618, 692, 987, 948, 768, 559, 648, 753, 783, 570, 592, 611, 710,
                        923, 981, 865, 833, 702 },
                { 916, 812, 887, 685, 978, 816, 784, 891, 575, 808, 716, 934, 676, 692, 727,
                        957, 674, 998, 584, 905 },
                { 681, 976, 566, 559, 989, 938, 747, 729, 798, 934, 952, 783, 680, 994, 569,
                        582, 922, 972, 696, 612 },
                { 858, 773, 836, 890, 977, 684, 939, 613, 651, 636, 590, 641, 695, 525, 535,
                        781, 556, 999, 784, 952 },
                { 796, 784, 825, 905, 712, 676, 628, 625, 695, 671, 826, 733, 601, 640, 695,
                        628, 567, 639, 967, 743 },
                { 677, 936, 586, 926, 950, 534, 571, 826, 644, 643, 697, 691, 734, 550, 812,
                        905, 606, 939, 651, 546 },
                { 681, 827, 838, 839, 625, 953, 696, 877, 811, 639, 796, 612, 844, 978, 899,
                        558, 832, 523, 899, 536 },
                { 664, 731, 621, 933, 677, 893, 621, 793, 698, 855, 534, 748, 756, 587, 695,
                        700, 553, 720, 987, 925 },
                { 768, 951, 587, 781, 913, 662, 698, 533, 565, 779, 628, 640, 868, 693, 758,
                        902, 951, 703, 701, 932 },
                { 769, 983, 762, 529, 958, 823, 581, 731, 764, 892, 744, 998, 907, 674, 978,
                        980, 792, 823, 746, 982 },
                { 598, 785, 574, 800, 896, 918, 653, 735, 818, 546, 783, 988, 808, 686, 516,
                        992, 718, 884, 938, 946 },
                { 762, 677, 587, 982, 642, 693, 654, 661, 737, 836, 998, 641, 816, 894, 917,
                        746, 700, 984, 548, 991 },
                { 565, 923, 637, 896, 789, 539, 640, 612, 911, 532, 834, 713, 758, 731, 520,
                        682, 870, 789, 813, 639 },
                { 590, 716, 722, 674, 566, 851, 996, 787, 554, 998, 733, 978, 568, 887, 710,
                        590, 719, 847, 585, 566 },
                { 878, 866, 944, 799, 556, 940, 594, 940, 622, 855, 963, 983, 595, 966, 725,
                        854, 700, 861, 559, 748 },
                { 606, 552, 789, 864, 644, 759, 671, 964, 813, 975, 673, 870, 834, 594, 556,
                        755, 577, 523, 601, 789 },
                { 626, 742, 613, 597, 732, 698, 878, 678, 894, 985, 588, 693, 797, 999, 648,
                        854, 620, 561, 656, 838 },
                { 826, 547, 853, 577, 723, 748, 790, 701, 559, 662, 788, 708, 853, 893, 929,
                        888, 678, 939, 972, 819 }
        };

        System.out.println("A matriz em questão: ");
        for (Object[] objects : matriz) {
            for (Object object : objects) {
                System.out.print(object + " ");
            }
            System.out.println();
        }
        System.out.println();

        int valorSubstituto = Integer.MAX_VALUE;
        int custoMinimo = 0;
        preProcessarMatriz(matriz, valorSubstituto);

        Object[] resultado = executarAlgoritmoHungaro(matriz);

        System.out.println();

        if (resultado[0] == null) {
            System.out.println("Solução não encontrada.");
        } else {
            int[] solucao = (int[]) resultado[0];
            System.out.print(
                    "Pares ordenados (Linha, Coluna) de elementos integrantes da solução ótima, referenciando matriz original de custo: \n");

            for (int i = 0; i < solucao.length; i++) {
                int j = (i < matriz.length) ? solucao[i] : -1;
                if (j >= 0 && j < matriz[i].length) {
                    System.out.println("Linha " + (i + 1) + ", Coluna " + (j + 1) + ": " + matriz[i][j]);
                    custoMinimo += Integer.parseInt(String.valueOf(matriz[i][j]));
                } else {
                    System.out.println("Linha " + (i + 1) + ", Coluna " + (j + 1) + ": " + 0 + " (Dummy)");
                }
            }

            System.out.println("Custo mínimo: " + custoMinimo);
        }
    }
}
