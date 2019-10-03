package SP1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoublyLinkedList<T> extends SinglyLinkedList <T> {

    static class Entry<E> extends SinglyLinkedList.Entry<E> {

        Entry<E> prev;

        Entry(E x, Entry<E> next, Entry<E> prev) {
            super(x, next);
            this.prev = prev;
        }
    }


    public DoublyLinkedList() {
        head = new DoublyLinkedList.Entry<>(null, null,null);
        tail = head;
        size = 0;
    }

    // interface
    public Iterator<T> iterator()
    {
        return new DLLIterator();
    }

    protected class DLLIterator extends SinglyLinkedList.SLLIterator {

        public boolean hasPrev(){
            return ((Entry) cursor).prev != null;
        }

        public T prev(){
            T temp = (T)((Entry)cursor).prev.element;
            cursor = ((Entry)cursor).prev;
            return temp;
        }

        public void add(T x){


            Entry<T> e = new Entry<>(x,null,null);

            if(cursor == tail){
                cursor.next = e;
                e.prev = ((Entry)cursor).prev;

            }else{
                e.next = cursor.next;
                e.prev = ((Entry)cursor.next).prev;
                ((Entry)cursor.next).prev = e;
                cursor.next = e;
                if(cursor == head){
                    head.next = e;
                }
            }

            cursor = e;

            size++;
        }

        // remove current element
        public void remove() {
            if(!ready) {
                throw new NoSuchElementException();
            }

            if(size == 0){
                return;
            }

            // Handles the deletion of tail element
            if(cursor == tail){
                tail = ((Entry)cursor).prev;
                ((Entry)cursor).prev.next = null;
                cursor = ((Entry)cursor).prev;
//                ready = true;
            }else{
                // Sets the previous and next of the elements before and after deleted element accordingly.
                ((Entry)cursor.next).prev =((Entry)cursor).prev;

                ((Entry)cursor).prev.next =  ((Entry)cursor).next;

                ready = false;  // Calling remove again without calling next will result in exception thrown.
            }
            size--;
        }
    }


    // Add new elements to the end of the list and also set previous element to it.
    public void add(T x) {
        add(new Entry<>(x, null,null));
    }

    public void add(Entry<T> ent) {
        ent.prev = (Entry)tail;
        tail.next = ent;
        tail = tail.next;
        size++;
    }


    public static void main(String[] args) throws NoSuchElementException {
        int n = 10;
        if(args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>();
        for(int i=1; i<=n; i++) {
            lst.add(Integer.valueOf(i));
        }
        lst.printList();

        Iterator<Integer> it = lst.iterator();



        Scanner in = new Scanner(System.in);
        whileloop:
        while(in.hasNext()) {
            int com = in.nextInt();
            switch(com) {
                case 1:  // Move to next element and print it
                    if (it.hasNext()) {
                        System.out.println(it.next());
                    } else {
                        break whileloop;
                    }
                    break;
                case 3:  // Remove element

                    try{
                        it.remove();
                        lst.printList();
                    }catch(NoSuchElementException e){
                        System.out.print("You cannot perform two successive delete operation but from the tail end, you can!");
                    }

                    break;
                case 2 :        // move to previous element and print

                        if (((DoublyLinkedList.DLLIterator)it).hasPrev()) {
                            System.out.print(((DoublyLinkedList.DLLIterator)it).prev());
                        } else {
                            break whileloop;
                        }


                     break;

                case 4:
                        Scanner input = new Scanner(System.in);
                        int x = input.nextInt();
                    ((DoublyLinkedList.DLLIterator)it).add(x);
                        break;

                default:  // Exit loop
                    break whileloop;
            }

        }
        lst.printList();

    }
}


/*
    Sample Output: 1 2 1 1 3 1 1 3 2 1 1 2 3 1 1 1 1 1 3 3 2 2 3 1 1 1
    10: 1 2 3 4 5 6 7 8 9 10
    1
    null
    1
    2
    9: 1 3 4 5 6 7 8 9 10
    3
    4
    8: 1 3 5 6 7 8 9 10
    3
    5
    6
    5
    7: 1 3 6 7 8 9 10
    6
    7
    8
    9
    10
    6: 1 3 6 7 8 9
    5: 1 3 6 7 8
    7
    6
    4: 1 3 7 8
    7
    8
    4: 1 3 7 8


 */