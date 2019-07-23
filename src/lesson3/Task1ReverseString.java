package lesson3;

public class Task1ReverseString {

    public static void main(String[] args) {
        String str;
        str="abcdef";
        MyStack<Character> stack=new MyStack<>();
        for (int i = 0; i <str.length() ; i++) {
            stack.push(str.charAt(i));
        }
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            System.out.print(stack.pop());
        }

    }
}
