package SP2;

import java.util.Scanner;

public class BoundedQueue<T> implements QueueInterface<T> {

    private Object [] arr;
    private int maxQueueSize, currSize=0, front, rear;

    BoundedQueue(int size){ //Constructor
        maxQueueSize = size;
        arr = new Object[size];
        front = 0;
        rear = -1;
    }

    public boolean offer(T x){ //adds an user input element if the queue is not full else returns

        if(!isFull()){
            rear = (rear+1) % maxQueueSize;
            arr[rear] = x;
            currSize++;
            return true;
        }else{
            return false;
        }
    }

    public T poll(){ // removes the first element in the queue if the queue is not empty
        if(!isEmpty()){
            T last = (T)arr[front];
            currSize--;
            front = (front + 1) % maxQueueSize;
            return last;
        }else{
            return null;
        }
    }

    public T peek(){ // returns the first element in the queue without removing it
        if(!isEmpty()){
            return  (T)arr[front];
        }else{
            return null;
        }
    }

    public int size() { // returns the number of elements in the queue
        return currSize;
    } // returns tje current size of the array

    public boolean isEmpty(){ //returns true if the queue is empty

        if(size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){ // returns true if the queue is full
        if(size() == maxQueueSize){
            return true;
        }else{
            return false;
        }
    }

    public void clear(){ // clears the queue
        arr = new Object[maxQueueSize];
        currSize = 0;
        front = 0;
        rear = -1;
    }

    public void toArray(T[] a){ // copies the elements of the queue in the same order into an array defined by the user

        for(int i =0 ; i< currSize ; i++){
            int index = (i + front) % maxQueueSize;
            a[i] = (T)arr[index];
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Queue Size");//Enter the size of the queue

        QueueInterface<Integer> queue = new BoundedQueue<>(input.nextInt());

        whileloop:
        while(true){

            switch(input.nextInt()){
                case 1:                 // insert element
                    System.out.println("Enter Element:");
                    if(!queue.offer(input.nextInt())){
                        System.out.println("Queue is Full");
                    }
                    break;
                case 2:                 // pop element
                    if(queue.isEmpty()){
                        System.out.println("Queue is empty");
                    }
                    else {
                        System.out.println(queue.poll());
                    }
                    break;
                case 3:                 // peek element
                    System.out.println(queue.peek());
                    break;
                case 4:                 // queue size
                    System.out.println(queue.size());
                    break;
                case 5:                 // print element as in queue order

                    Integer a[]= new Integer[queue.size()];
                    queue.toArray(a);
                    for(int i = 0  ; i < a.length ; i++){
                        System.out.print(a[i] + " ");
                    }
                    break;

                default:                // exit loop
                    System.out.println("Invalid Choice");
                    break whileloop;

            }
        }


    }

}