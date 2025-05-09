package threads;

public class SharedResource {

    private volatile boolean flag = false;

    private static volatile int sharedCounter=0;

    public void start() {
        Thread readerThread = new Thread(() -> {
            System.out.println("Reader Thread: Waiting for flag to become true...");
            System.out.println(flag+" from thread1 ");
            while (!flag) {
                // Busy-waiting for flag to change
            }
            System.out.println("Reader Thread: Detected flag is true!");
        });

        // Thread 2: Sets the flag to true after 1 second
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            flag = true; // This change is visible to readerThread
            System.out.println("Writer Thread: Flag set to true.");
        });


        readerThread.start();
        writerThread.start(); // this change is immediately visible to the other thread
    }

    public static void main(String[] args) {
        SharedResource example = new SharedResource();
        example.start();

        Runnable volatileTask=()->{
            for(int i=0;i<10000;i++){
                sharedCounter++;
            }
        };

        Thread thread1=new Thread(volatileTask);
        Thread thread2=new Thread(volatileTask);

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
            System.out.println("print volatile thread : "+sharedCounter);
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }

}
