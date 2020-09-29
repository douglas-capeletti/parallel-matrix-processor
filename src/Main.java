public class Main {

    public static void main(String[] args) {

        int matrixLength = 0;
        String threadFormat = "100%";
        boolean show = false;
        switch (args.length) {
            case 0:
                System.err.println("Missing parameters [matrix_length] <thread_number/thread_percentage> <show?>");
                System.exit(1);
            case 3:
                show = Boolean.parseBoolean(args[2]);
            case 2:
                threadFormat = args[1];
            case 1:
                matrixLength = Integer.parseInt(args[0]);
        }

        MatrixManipulator.run(matrixLength, Math.min(parseFormat(threadFormat), matrixLength), show);
    }

    private static int parseFormat(String threadFormat) {
        int totalThreads = Runtime.getRuntime().availableProcessors();
        int supportedThreads = 256;
        int usedThreads;
        if (threadFormat.endsWith("%")) {
            int percent = Integer.parseInt(threadFormat.substring(0, threadFormat.length() - 1));
            usedThreads = Math.min(supportedThreads, (totalThreads / (100 / percent)));
        }
        int threadRequested = Integer.parseInt(threadFormat);
        usedThreads = Math.min(supportedThreads, threadRequested);
        System.out.println("Total de threads disponíveis: " + totalThreads);
        System.out.println("Total de threads utilizadas: " + usedThreads);
        return usedThreads;
    }
}
