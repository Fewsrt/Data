// public class StackString {
//     int top = -1;
//     static final int MAX = 1000;
//     String[] stack = new String[MAX];

//     public void push(String element) {
//         if (top > MAX) {

//         } else {
//             stack[++top] = element;
//         }
//     }

//     public String pop() {
//         if (!isEmpty()) {
//             return stack[top--];
//         } else {
//             return 0;
//         }
//     }

//     public boolean isEmpty() {
//         if (top < 0) {
//             return true;
//         } else {
//             return false;
//         }
//     }

//     public String stacktop() {
//         return stack[top];
//     }
// }