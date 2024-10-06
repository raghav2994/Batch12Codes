package inheritenceConcept;

public class GrandKid extends Kid{

    public static void main(String[] args){
        GrandKid gk = new GrandKid();
        gk.landOfFather();
        gk.landOfGrandFather();
        gk.grandKidEat();
    } 
 
    public void grandKidEat(String pizza){
		System.out.println("My favourite food is   " + pizza );
    }

}
