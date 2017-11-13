/**
 * @author: zhangyongbin
 * @Time: 7/15/2017.
 */
public class AtomicitySample {
    public static long t = 0;

    public static class ChangeT implements Runnable {
        private long to;

        public ChangeT(long to) {
            this.to = to;
        }

        @Override
        public void run() {
            while (true) {
                AtomicitySample.t = to;
                Thread.yield();
            }
        }

    }

    public static class ReadT implements Runnable {

        @Override
        public void run(){
            while (true) {
                long tmp = AtomicitySample.t;
                if (tmp != 111L && tmp !=-999L && tmp != -444L && tmp != 333L)
                System.out.println(tmp);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args){
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ReadT()).start();
    }
}
