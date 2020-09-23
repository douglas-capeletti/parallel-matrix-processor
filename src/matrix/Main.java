package matrix;

public class Main {

    public static void main(String[] args) throws Exception {

        int matrixLength = 0;
        String threadFormat = "100%";
        switch (args.length) {
            case 0:
                System.err.println("Missing parameters [matrix_length] <thread_number/thread_percentage>");
                System.exit(1);
            case 2:
                threadFormat = args[1];
            case 1:
                matrixLength = Integer.parseInt(args[0]);
        }

        Matrix.run(matrixLength, Math.min(parseFormat(threadFormat), matrixLength));
    }

    private static int parseFormat(String threadFormat) {
        int totalThreads = Runtime.getRuntime().availableProcessors();
        if (threadFormat.endsWith("%")) {
            int percent = Integer.parseInt(threadFormat.substring(0, threadFormat.length() - 1));
            return totalThreads / (100 / percent);
        }
        int threadRequested = Integer.parseInt(threadFormat);
        return Math.min(threadRequested, totalThreads);
    }
}
