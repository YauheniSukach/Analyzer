import java.util.Stack;

public class Brackets {
    //true-если скобка является открывающей,иначе false
    public boolean OpeningBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }
    //true-если скобка является закрывающей,иначе false
    public boolean ClosingBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }
    //true-если закрывающей скобке есть пара,иначе false
    public boolean Pair(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']' || opening == '{' && closing == '}';
    }

    public void Test(String txt) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : txt.toCharArray()) {
            //Если первый входящий элемент является закрывающая скобка то "Incorrect"
            if (ClosingBracket(c) && stack.isEmpty()) {
                System.out.print("Incorrect!\n");
            }
            //Если встретилась открывающая скобка,то она пушится в стэк
            if (OpeningBracket(c)) {
                stack.push(c);
            }
            //Если встретилась закрывающая скобка,то проверяем или есть ей пара в стеке
            if (ClosingBracket(c)) {
                if (Pair(stack.peek(), c)) {
                    stack.pop();
                }
            }
        }
        //Если стек остается пустым ,то скобки расставлены верно,иначе неверно
        if (stack.isEmpty()) {
            System.out.print("Correct!\n");//
        } else {
            System.out.print("Incorrect!\n");
        }
    }
}

