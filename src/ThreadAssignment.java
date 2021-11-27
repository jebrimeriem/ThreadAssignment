public class ThreadAssignment {

    static class Counter {
        void count() {
            for ( int i=350;i>=1;i--)
                system.out.println(i);
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run(){
        synchronized (counter);
                    counter.count();
                    system.out.println("finich !");
        }
    }

    public static void main(String[] args)  throws InterruptedException {
       

           Counter counter=new Counter();
           MyThread t1=new MyThread(counter);
           t1.start();
           MyThread t2=new MyThread(counter);
           t2.start();
           t1.join();
           t2.join();
           system.out.println("done !");
    }
}
