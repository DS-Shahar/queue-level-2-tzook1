import java.util.LinkedList;
import java.util.Queue;

public class Queue<T>
{
  private Node<T> first;
  private Node<T> last;

  public Queue()
  {
    this.first = null;
    this.last = null;
  }

  public void insert(T x)
  {
    Node<T> temp = new Node<T>(x);
    if (first == null)
      first = temp;
    else
      last.setNext(temp);
    last = temp;
  }

  public T remove()
  {
    T x = first.getValue();
    first = first.getNext();
    if (first == null)
      last = null;
    return x;
  }

  public T head()
  {
    return first.getValue();
  }

  public boolean isEmpty()
  {
    return first == null;
  }

  public String toString()
  {
    if (isEmpty())
      return "[]";
    String s = "[";
    insert(null);
    T temp = remove();
    while (temp != null) {
      s += temp;
      insert(temp);
      temp = remove();
      if (temp != null)
        s += ", ";
    }
    return s + "]";
  }
}

public class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) {
    this.value = value;
    this.next = null;
  }

  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }

  public T getValue() {
    return this.value;
  }

  public Node<T> getNext() {
    return this.next;
  }

  public boolean hasNext() {
    return (this.next != null);
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public String toString() {
    return value + " ==> " + next;
  }
}

public class RadixSortExample {

    public static int findMax(Queue<Integer> queue) {
        int max = Integer.MIN_VALUE;
        for (int num : queue) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int getNumberOfDigits(int x) {
        return (int)Math.log10(x) + 1;
    }

    public static int getDigitAtPosition(int number, int position) {
        return (number / (int)Math.pow(10, position)) % 10;
    }

    public static void radixSort(Queue<Integer> queue) {
        int max = findMax(queue);
        int numOfDigits = getNumberOfDigits(max);

        for (int i = 0; i < numOfDigits; i++) {
            Queue<Integer>[] bins = new Queue[10];
            for (int j = 0; j < 10; j++) {
                bins[j] = new LinkedList<>();
            }

            while (!queue.isEmpty()) {
                int num = queue.poll();
                int digit = getDigitAtPosition(num, i);
                bins[digit].offer(num);
            }

            for (Queue<Integer> bin : bins) {
                while (!bin.isEmpty()) {
                    queue.offer(bin.poll());
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(803);
        queue.offer(7);
        queue.offer(24);
        queue.offer(18);

        radixSort(queue);

        System.out.println(queue); 
    }
}
