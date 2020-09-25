public class Matrix {

    public final int size;
    public volatile int[][] m1;
    public volatile int[][] m2;
    public volatile int[][] mres;

    public Matrix(int size) {
        this.size = size;
        this.m1 = new int[size][size];
        this.m2 = new int[size][size];
        this.mres = new int[size][size];
        init();
    }

    private void init(){
        // INICIALIZA OS ARRAYS A SEREM MULTIPLICADOS
        if (m1[0].length != m2.length || mres[0].length != m2[0].length) {
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
    }

    public void verify(){
        for (int i = 0; i < size; i++) {
            int k = size * (i + 1);
            for (int j = 0; j < size; j++) {
                int k_col = k * (j + 1);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (mres[i][j] != k_col)
                            throwVerifyError();
                    } else {
                        if (mres[i][j] != -k_col)
                            throwVerifyError();
                    }
                } else {
                    if (j % 2 == 0) {
                        if (mres[i][j] != -k_col)
                            throwVerifyError();
                    } else {
                        if (mres[i][j] != k_col)
                            throwVerifyError();
                    }
                }
            }
        }
    }

    private void throwVerifyError(){
        System.err.println("Error verifying matrix");
        System.exit(1);
    }

    public void show(int [][] matrix){
        for (int[] line : matrix) {
            for (int column : line) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

}