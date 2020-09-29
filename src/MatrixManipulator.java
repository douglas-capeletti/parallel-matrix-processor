public class MatrixManipulator {

    public static void run(int size, int threadCount, boolean show) {
        Matrix matrix = new Matrix(size);

        // PREPARA PARA MEDIR TEMPO
        long inicio = System.nanoTime();

        process(size, threadCount, matrix);

        // OBTEM O TEMPO
        long fim = System.nanoTime();
        double total = (fim - inicio) / 1000000000.0;

        // VERIFICA SE O RESULTADO DA MULTIPLICACAO ESTA CORRETO
        matrix.verify();
        if(show){
            matrix.show(matrix.mres);
            System.out.println();
        }

        // MOSTRA O TEMPO DE EXECUCAO
        System.out.println("Tempo de processamento: " + total);
    }

    //Efetua a multiplicação
    private static void process(int size, int threadCount, Matrix matrix) {
        int step = size / threadCount;

        int initialPosition = 0;
        int finalPosition = step;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new MatrixThread(initialPosition, finalPosition, matrix));
            threads[i] = t;
            t.start();

            initialPosition += step;
            finalPosition += step;
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error joining thread[" + i + "]\n");
                e.printStackTrace();
            }
        }
    }
}