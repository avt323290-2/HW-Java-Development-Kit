import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс, представляющий вилку на обеденном столе.
 */
public class Fork {
    private Lock lock = new ReentrantLock();

    /**
     * Поднимает вилку.
     */
    public void pickUp() {
        lock.lock();
    }

    /**
     * Опускает вилку.
     */
    public void putDown() {
        lock.unlock();
    }
}