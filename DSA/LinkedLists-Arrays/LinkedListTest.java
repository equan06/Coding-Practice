import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinkedListTest {


    @Test
    void reverseTest() {
        LinkedList<Integer> list1 = new LinkedList();
        LinkedList<Integer> expected = new LinkedList();
        for (int i = 0; i < list1.length; i++) {
            list1.append(i);
            expected.append(list1.length - i - 1);
        }
        list1.reverse();
        if (!list1.equals(expected)) {
            throw new AssertionError();
        }
    }
}