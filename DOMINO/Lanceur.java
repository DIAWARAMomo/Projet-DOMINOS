import java.util.*;
public class Lanceur{

    public static Jeu jeu;
    public static void main(String []args){
	boolean z=false;
	Scanner sc = new Scanner(System.in);
	System.out.println("fais un choix");
	System.out.println(" 1 pour Domino ");
	int choix= sc.nextInt();
	if(choix==1){
	    jeu= new JeuDomino(2,new EnsembleDomino(),new PlateauD());
	    while(z==false){
		jeu.commencer();
	 	z=true;
	    }
	}


    }
	
}
