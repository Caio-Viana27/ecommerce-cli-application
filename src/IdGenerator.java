import java.lang.Math;

final public class IdGenerator {

    private IdGenerator() {
    }

    public static int radomIdGenerator() {
        int id = 0;
        id += (int) (Math.random() * 10);
        id += (int) (Math.random() * 100);
        id += (int) (Math.random() * 1000);
        id += (int) (Math.random() * 10000);
        id += (int) (Math.random() * 100000);
        id += (int) (Math.random() * 1000000);
        return id;
    }
}
