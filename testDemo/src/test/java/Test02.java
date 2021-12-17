import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Test02 {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(1));
        blockingQueue.put(1);
        System.out.println("hello");
        System.out.println(blockingQueue.offer(1));




        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.poll());
    }
}


class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println("写入：" + key);
            this.map.put(key, value);
            System.out.println(key + "写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String read(String key) {
        readWriteLock.readLock().lock();
        String res = null;
        try {
            System.out.println("读取：" + key);
            res = (String) this.map.get(key);
            System.out.println(key + "读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return res;

    }
}


