public class Grille{
    protected final char[][] grilles;
    public Grille(){
	grilles=new char[7][4];
    }
    public void afficher(){
	System.out.println("---------------");
	for(int i=0;i<grilles.length;i++){
	    for(int j=0;j<grilles[i].length;j++){
		System.out.print(grilles[i][j] + " | ");
		if(j==grilles[i].length-1) System.out.println();
	    }
	    System.out.println("---------------");
	}
	System.out.println("-------------------------------------------");
    }
}
