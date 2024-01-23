/**
 * Класс, представляющий философа за обеденным столом.
 */
public class Philosopher extends Thread {
    private int id;
    private Fork leftFork;
    private Fork rightFork;

    /**
     * Конструктор для создания философа с указанным ID и вилками.
     *
     * @param id         ID философа.
     * @param leftFork   Левая вилка.
     * @param rightFork  Правая вилка.
     */
    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void eat() {
        System.out.println("Философ " + id + " обедает.");
    }

    private void think() {
        System.out.println("Философ " + id + " размышляет.");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            think();
            leftFork.pickUp();
            rightFork.pickUp();
            eat();
            leftFork.putDown();
            rightFork.putDown();
        }
    }
}