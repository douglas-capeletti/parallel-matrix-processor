/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class MatrixThread implements Runnable {

    private final int initialPosition;
    private final int finalPosition;
    private final Matrix m;

    public MatrixThread(int initialPosition, int finalPosition, Matrix m) {
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
        this.m = m;
    }

    public void run() {
        for (int i = initialPosition; i < finalPosition; i++) {
            for (int j = 0; j < m.mres[0].length; j++) {
                m.mres[i][j] = 0;
                for (int k = 0; k < m.m2.length; k++) {
                    m.mres[i][j] += m.m1[i][k] * m.m2[k][j];
                }
            }
        }
    }
}
