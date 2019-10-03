package SP2;

public interface QueueInterface<T> {
    boolean offer(T x); //adds an user input element if the queue is not full else returns
    T poll(); // removes the first element in the queue if the queue is not empty
    T peek(); // returns the first element in the queue without removing it
    int size(); // returns tje current size of the array
    boolean isEmpty(); //returns true if the queue is empty
    void clear(); // clears the queue
    void toArray(T[] a); // copies the elements of the queue in the same order into an array defined by the user
}
