package assignment2;

public class ActionQueue extends MyQueue<Direction>{
    private MyStack<String> string_stack;
    public ActionQueue(){
        this.string_stack= new MyStack<String>();
    }
    public void clear(){
        this.string_stack.clear();
        super.clear();
    }
    public void loadFromEncodedString(String movement){
        String num="";
        String move="";
        int count=0;
        int rep = 0;
        clear();
        for (int i=0; i<movement.length(); i++){
            char c = movement.charAt(i);
            if ((c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')){
                num+=c;
            }else if (c=='['){
                if(num==""){
                    throw new IllegalArgumentException("The syntax is incorrect");
                }else {
                    if (count==0){
                        rep=Integer.parseInt(num);
                    }
                    num="";
                    count++;
                }
            }else if (c=='N' || c=='S'|| c=='E' || c=='W'){
                char b=movement.charAt(i-1);
                if (!(b=='[' || b=='N' || b=='S' || b=='E' || b=='W')){
                    throw new IllegalArgumentException("The syntax is incorrect");
                }else{
                    move+=c;
                }
            }else if (c==']') {
                char b = movement.charAt(i - 1);
                if (!(b == 'N' || b == 'S' || b == 'E' || b == 'W' || b==']')) {
                    throw new IllegalArgumentException("The syntax is incorrect");
                } else if (b == ']' && count == 0) {
                    throw new IllegalArgumentException("The syntax is incorrect");
                }else{
                    if (count==1) {
                        for (int k=0; k<rep; k++) {
                            for (int m=0; m<move.length();m++) {
                                char cBis=move.charAt(m);
                                if (cBis == 'N') {
                                    enqueue(Direction.NORTH);
                                } else if (cBis == 'E') {
                                    enqueue(Direction.EAST);
                                } else if (cBis == 'W') {
                                    enqueue(Direction.WEST);
                                } else if (cBis == 'S') {
                                    enqueue(Direction.SOUTH);
                                }
                            }
                        }
                    }else{
                        for (int k=0; k<rep;k++){
                            for (int l=0;l<Integer.parseInt(num);l++){
                                for (int m=0; m<move.length();m++) {
                                    char cBis=movement.charAt(m);
                                    if (cBis == 'N') {
                                        enqueue(Direction.NORTH);
                                    } else if (cBis == 'E') {
                                        enqueue(Direction.EAST);
                                    } else if (cBis == 'W') {
                                        enqueue(Direction.WEST);
                                    } else if (cBis == 'S') {
                                        enqueue(Direction.SOUTH);
                                    }
                                }
                            }
                        }
                    }
                    count--;
                    move="";
                }
            }else{
                throw new IllegalArgumentException("The syntax is incorrect");
            }
        }
    }
}

