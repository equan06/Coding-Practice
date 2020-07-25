import java.util.Comparator;

public class LinkedList<T> {
    Node head;
    int length;

    private class Node {
        T val;
        Node next;

        Node() {
            this.val = null;
            this.next = null;
        }
        Node(T val) {
            this.val = val;
            this.next = null;
        }
    }
    public LinkedList() {
        head = null;
        length = 0;
    }
    public LinkedList(T input) {
        head = new Node(input);
        length = 1;
    }

    public T head() {
        return head.val;
    }

    public int length() {
        return this.length;
    }

    public void append(T val) {
        Node curr = head;
        if (curr == null) {
            head = new Node(val);
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(val);
        }
        length += 1;
    }

    public boolean equals(LinkedList<T> list2) {
        if (this.length != list2.length) {
            return false;
        }

        Node next1 = this.head;
        Node next2 = list2.head;

        while (next1 != null) {
            if (!next1.val.equals(next2.val)) {
                return false;
            }
            next1 = next1.next;
            next2 = next2.next;
        }
        return true;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= this.length) {
            throw new IndexOutOfBoundsException();
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = head.next;
        }
        return curr.val;
    }

    public String toString() {
        Node curr = head;
        String res = "";
        while (curr.next != null) {
            res += curr.val.toString() + " -> ";
            curr = curr.next;
        }
        res += curr.val.toString();
        return res;
    }

    public void reverse() {
        // reverse the current linked list, mutatively
        Node curr = head;
        Node temp = null;
        Node prev = null;
        while (curr != null) {
            temp = curr.next; // save pointer to the next node
            curr.next = prev; // reverse the link to the prev node
            prev = curr; // curr node is now prev
            curr = temp; // continue to the next node
        }
        head = prev;
    }





    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        String str = "abcde";
        for (int i = 0; i < str.length(); i ++) {
            test.append(str.charAt(i));
        }
        System.out.println(test);
        System.out.println(test.length);
        test.reverse();
        System.out.println(test);
        test.reverse();
        System.out.println(test);
    }
}
