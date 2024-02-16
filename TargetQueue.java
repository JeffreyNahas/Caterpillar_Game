package Caterpillar_Game;

public class TargetQueue extends MyQueue<Position> {
    private MyStack<String> string_stack;
    public TargetQueue(){
        super();
        string_stack= new MyStack<String>();
    }
    public void clear(){
        string_stack.clear();
        super.clear();
    }
    public void addTargets(String pos_str){
        boolean correctSyntax=false;
        String num="";
        for(int i=0; i<pos_str.length(); i++){
            char c= pos_str.charAt(i);
            if (c=='(' ){
                if( string_stack.isEmpty() && num.equals("") ){
                    string_stack.push("(");
                }else{
                    throw new IllegalArgumentException("You have a syntax error");
                }
            } else if (c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                num+=c;
            }else if (c==')') {
                boolean opened = false;
                String one = string_stack.pop();
                String two = string_stack.pop();
                String three = string_stack.pop();
                string_stack.push("");
                if (num==""){
                    throw new IllegalArgumentException("You have a syntax error.");
                }
                int numToInt = Integer.parseInt(num);
                int to_int = Integer.parseInt(two);
                if (one.equals(",") && to_int>=0 && three.equals("(") && numToInt>=0){
                    correctSyntax=true;
                    opened=true;
                }
                if (opened=false){
                    throw new IllegalArgumentException("You have a syntax error.");
                }else {
                    Position position= new Position(to_int, numToInt);
                    enqueue(position);
                    num="";
                }
            }else if (c=='.'){
                if (correctSyntax==true){
                    string_stack.clear();
                    num="";
                    correctSyntax=false;
                }else{
                    throw new IllegalArgumentException("You have a syntax error.");
                }

            }else if (c==','){
                if (num==""){
                    throw new IllegalArgumentException("You have a syntax error.");
                }else{
                    int numToInt=Integer.parseInt(num);
                    if (numToInt>=0){
                        string_stack.push(num);
                        string_stack.push(Character.toString(c));
                        num="";
                    }else{
                        throw new IllegalArgumentException("Integer is not valid");
                    }
                }

            }else {
                throw new IllegalArgumentException("This character is not valid");
            }
        }
    }
}
