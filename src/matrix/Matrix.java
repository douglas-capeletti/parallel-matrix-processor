package matrix;

public class Matrix {

    // ESTRUTURAS DE DADOS COMPARTILHADA
    public static int[][] m1;
    public static int[][] m2;
    public static int[][] mres;

    public static void run(int size){
        run(size, false);
    }

    public static void run(int size, boolean print) {

        // INICIALIZA OS ARRAYS A SEREM MULTIPLICADOS
        m1 = new int[size][size];
        m2 = new int[size][size];
        mres = new int[size][size];
        if (m1[0].length != m2.length || mres.length != m1.length || mres[0].length != m2[0].length) {
            System.err.println("Impossivel multiplicar matrizes: parametros invalidos.");
            System.exit(1);
        }
        int k = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (k % 2 == 0)
                    m1[i][j] = -k;
                else
                    m1[i][j] = k;
            }
            k++;
        }
        k = 1;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (k % 2 == 0)
                    m2[i][j] = -k;
                else
                    m2[i][j] = k;
            }
            k++;
        }

        // PREPARA PARA MEDIR TEMPO
        long inicio = System.nanoTime();

        // REALIZA A MULTIPLICACAO
        for (int i = 0; i < mres.length; i++) {
            for (int j = 0; j < mres[0].length; j++) {
                mres[i][j] = 0;
                for (k = 0; k < m2.length; k++) {
                    mres[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        // OBTEM O TEMPO
        long fim = System.nanoTime();
        double total = (fim - inicio) / 1000000000.0;

        // VERIFICA SE O RESULTADO DA MULTIPLICACAO ESTA CORRETO
        for (int i = 0; i < size; i++) {
            k = size * (i + 1);
            for (int j = 0; j < size; j++) {
                int k_col = k * (j + 1);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (mres[i][j] != k_col)
                            System.exit(1);
                    } else {
                        if (mres[i][j] != -k_col)
                            System.exit(1);
                    }
                } else {
                    if (j % 2 == 0) {
                        if (mres[i][j] != -k_col)
                            System.exit(1);
                    } else {
                        if (mres[i][j] != k_col)
                            System.exit(1);
                    }
                }
            }
        }

        // MOSTRA O TEMPO DE EXECUCAO
        System.out.println(total);

        if(print){
            System.out.println("\n------ Matriz 1 ------");
            System.out.println(print(m1));
            System.out.println("\n------ Matriz 2 ------");
            System.out.println(print(m2));
            System.out.println("\n------ Matriz R ------");
            System.out.println(print(mres));
        }

    }

    public static String print(int[][] matriz){
        StringBuilder saida= new StringBuilder();
        for (int[] ints : matriz) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                saida.append(ints[coluna]).append(" ");
            }
            saida.append("\n");
        }
        return saida.toString();
    }

}