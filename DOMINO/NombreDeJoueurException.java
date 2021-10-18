public class NombreDeJoueurException extends Exception{
    public NombreDeJoueurException(int i){
	if(i<=1 ||i>4){
	    System.out.println(" vous essayez d'instancier une class Joueur avec un nombre de joueur qui ne respect pas le jeu");
	}
    }
}
