public class StringBuilderStringBufferExample {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        Runnable stringBuilderRunnable = () -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("a");
            }
        };
        Runnable stringBufferRunnable = () -> {
            for(int i=0; i<1000;i++){
                stringBuffer.append("a");
            }
        };
        Thread[] stringBuilderThreads = new Thread[10];
        Thread[] stringBufferThreads = new Thread[10];

        // Create threads for String builder
        for(int i=0; i<10; i++) {
            stringBuilderThreads[i] = new Thread(stringBuilderRunnable);
            stringBuilderThreads[i].start();
        }

        // Create threads for String buffer
        for(int i=0; i<10; i++) {
            stringBufferThreads[i] = new Thread(stringBufferRunnable);
            stringBufferThreads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < 10; i++) {
            stringBuilderThreads[i].join();
            stringBufferThreads[i].join();
        }
        // StringBuffer is thread safe as compared to StringBuilder
        System.out.println(stringBuilder.length());
        System.out.println(stringBuffer.length());
    }
}