package inheritenceConcept;

public class Kid extends Father{

    public static void main(String[] args){
        Kid k = new Kid();
        k.landOfFather();
        k.landOfGrandFather();
        k.eat();
    }

    public void landOfFather(){
        System.out.println("I am a kid and this is my father land");
    }

    public void eat(){}

    public void eat(String burger){

    }

}
