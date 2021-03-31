import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {



    static   int flag = 0;





    /**
     *[1],
     *[1,1],
     *[1,2,1],
     *[1,3,3,1],
     *[1,4,6,4,1]
     **/
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            int size = i + 1;
            List<Integer> row = new ArrayList<>(size);
            int j = 0;
            while (row.size() < size) {
                if (j == 0 || j == i){
                    row.add(1);
                }else {
                    List<Integer> prevRow = res.get(i - 1);
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }
                j++;
            }
            res.add(row);
        }
        return res;
    }


    private static AtomicInteger ai = new AtomicInteger(0);
    public static void main(String[] args) {
        int num  = 100;

        new Thread(()->{

        }).start();

        new Thread( () ->{

        }).start();
    }


    class TestSemaphore implements Runnable{

        private Semaphore sp;

        public TestSemaphore(Semaphore sp) {
            this.sp = sp;
        }

        @Override
        public void run() {
            try {
                System.out.println("=======>开始执行方法");
                int val = ai.incrementAndGet();
                sp.acquire();
                System.out.println("=======>执行结束方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
