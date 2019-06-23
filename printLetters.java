public class printLetters {
    Object m = new Object();
    volatile char letter1 = 'A';

    public static void main(String[] args) throws InterruptedException {
        printLetters pl = new printLetters();

        new Thread(() -> pl.printLetter('A', 'B', 5)).start();
        new Thread(() -> pl.printLetter('B', 'C', 5)).start();
        new Thread(() -> pl.printLetter('C', 'A', 5)).start();
        System.out.println();
        Thread.sleep(100000);
        System.out.println();
    }
    void printLetter(char letter, char nextL, int n) {
        synchronized (m) {
            try {
                for (int i = 0; i < n; i++) {
                    while (letter1 != letter)
                        m.wait();
                    System.out.print(letter);
                    letter1 = nextL;
                    m.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}