package inheritenceConcept;

public class GrandKid extends Kid{
        
    public static void main(String[] args){
        GrandKid gk = new GrandKid();
        gk.landOfFather();
        gk.landOfGrandFather();
        //gk.grandKidEat();
    } 
    {
    System.out.println("Hello!Commited By arijit");
    }
 
    public void grandKidEat(String pizza){
		System.out.println("My favourite food is   " + pizza );
    }

}
