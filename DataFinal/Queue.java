// public class Queue {
//     private String arr[];
//     private int front;
//     private int rear;
//     private int capacity;
//     private int count;

//     Queue() {
//         arr = new [size];
//         capacity = size;
//         front = 0;
//         rear = -1;
//         count = 0;
//     }

//     public String remove() {
//         if (isEmpty()) {
//             System.out.println("UnderFlow\nProgram Terminated");
//             System.exit(1);
//         }

//         System.out.println("Removing " + arr[front]);

//         front = (front + 1) % capacity;
//         count--;
//         return arr[front];
//     }

//     public void add(String infix) {
//         if (isFull()) {
//             System.out.println("OverFlow\nProgram Terminated");
//             System.exit(1);
//         }

//         System.out.println("Inserting " + infix);

//         rear = (rear + 1) % capacity;
//         arr[rear] = infix;
//         count++;
//     }

//     public String peek() {
//         if (isEmpty()) {
//             System.out.println("UnderFlow\nProgram Terminated");
//             System.exit(1);
//         }
//         return arr[front];
//     }

//     public int size() {
//         return count;
//     }

//     public Boolean isEmpty() {
//         return (size() == 0);
//     }

//     public Boolean isFull() {
//         return (size() == capacity);
//     }
// }
