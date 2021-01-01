import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    public static void main(String[] args) {

        new Thread(()->{

            while ( true ){
                int localFlag = flag;
                System.out.println("当前标志位：flag值为：" + localFlag + " =====> "+ "timeStamp : " +
                        System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread( () ->{

            int localFlag = flag;
            while (true){
                localFlag += 1;
                flag = localFlag;
                System.out.println("修改标志位数据:" + localFlag +"=====>"+ "timeStamp : " +
                        System.currentTimeMillis());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
