SP-1 submitted by Nilkumar Pateland Sanjana Annamaneni

According to our program
1.if you input 1 it moves to the next element and prints it.
2.if you input 2 it moves to the previous element and prints it.
3.if you input 3  it deletes the element.
4. If you input 4 it will ask for number and add node after current cursor

Steps to compile and run the program:
(If you run on an ide)
1.download and import the package folder from the program file.
2.run the DoublyLinkedList.java and given the inputs from the terminal.

(If you run on command run prompt)
1. Unzip the folder.
2.  SP1/SinglyLinkedList.java
3. javac SP1/DoublyLinkedList.java
4. java SP1.DoublyLinkedList

NOTE: You cannot perform two successive delete operation in middle of list but from the tail end, you can!

1-> Go forward
2-> Go Previous
3-> delete current element
4-> add element after current cursor eg. 4(100) -> 4 will add element with input 100 from user.

/*
    Sample Output: 1 3 1 1 2 2 4(12) 1 3 1 1 1 4(34) 1 3 1 1 1 1 3 2 4(100) 1 4(200) 1
    10: 1 2 3 4 5 6 7 8 9 10
    1		// Delete first element
    9: 2 3 4 5 6 7 8 9 10 
		
		// Go forward		
    2
    3
    		// Go Previous
    2
    Null
		// Add 12 Element to first position
    12
    		// Go forward
    2
		// Delete 2 (current)
    9: 12 3 4 5 6 7 8 9 10
    		// Add 34 element after 5 before 6
    3
    4
    5
    34
    6
		// Delete 6 element (current)
    9: 12 3 4 5 34 7 8 9 10 
		// Delete Last element
    7
    8
    9
    10		
    8: 12 3 4 5 34 7 8 9 
     		 // Go Previous
    8
    		 // Add 100 after 8 before 9
   100
        	// go forward
    9
    9: 12 3 4 5 34 7 8 100 9 
      		// add 200 to last
    200
    10: 12 3 4 5 34 7 8 100 9 200


 */