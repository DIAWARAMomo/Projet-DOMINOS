import java.util.*;
public class Plateau{
    protected CheminMine[][] tableau;
    public Plateau(){
	tableau = new CheminMine[7][8];
	LinkedList<CheminMine> list= new LinkedList<CheminMine>();
	list.add(new CarteDarriver("Or       "));
	list.add(new CarteDarriver("Charbon  "));
	list.add(new CarteDarriver("Bois     "));
	Collections.shuffle(list);
	tableau[1][6]=list.get(0);
	tableau[3][6]=list.get(1);
	tableau[5][6]=list.get(2);
	tableau[3][0]=new CheminMine("Depart   ");
    }
    public void afficherPlateu(){
	System.out.println("------------------------------------------------------------------------------------------------------------");
	for(int i=0;i<tableau.length;i++){
	    for(int j=0;j<tableau[i].length;j++){
		if(tableau[i][j]==null) System.out.print("case(" + i+ "," + j+ ")   | ");
		else{
		    System.out.print(tableau[i][j].nom + "   | ");
		}
		if(j==tableau[i].length-1) System.out.println();
	    }
	    System.out.println("---------------------------------------------------------------------------------------------------------------");
	   
	}
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
    }
    public void  PlacerUneCarte(Carte c,int i,int j){
	if(c instanceof CheminMine){
	    CheminMine a= (CheminMine)c;
	    if(i>0 && j>0 && j+1<tableau[0].length && i+1<tableau.length){
		if(tableau[i+1][j]!=null){
		    if(tableau[i][j]==null && tableau[i+1][j].est==true && a.ouest==true){
			tableau[i][j]=a;
			return;
		    }
		}
		if(tableau[i-1][j]!=null){ 
		    if(tableau[i][j]==null && tableau[i-1][j].ouest==true && a.est==true){
			tableau[i][j]=a;
			return;
		    }
		}
		if(tableau[i][j-1]!=null){
		    if(tableau[i][j]==null && tableau[i][j-1].sud==true && a.nord==true){
			tableau[i][j]=a;
			return;
		    }
		}
		if(tableau[i][j+1]!=null){
		    if(tableau[i][j]==null && tableau[i][j+1].nord==true && a.sud==true) tableau[i][j]=a;
		    return;
		}
	    }
	    if(i==0 && j==0){
		if(tableau[i][j+1]!=null){
		    if(tableau[i][j]==null && tableau[i][j+1].nord==true && a.sud==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i+1][j]!=null){
		    if(tableau[i][j]==null && tableau[i+1][j].est==true && a.ouest==true) tableau[i][j]=a;
		    return;
		}
	    }
	    if(i==0 && j>0 && j<tableau[0].length-1){
		if(tableau[i][j+1]!=null){
		    if(tableau[i][j]==null && tableau[i][j+1].nord==true && a.sud==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i+1][j]!=null){
		    if(tableau[i][j]==null && tableau[i+1][j].est==true && a.ouest==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i][j-1]!=null){
		    if(tableau[i][j]==null && tableau[i][j-1].sud==true && a.nord==true) tableau[i][j]=a;
		    return;
		}
	    }
	    if(i>0 && j==0 && i<tableau.length-1){
		if(tableau[i][j+1]!=null){
		    if(tableau[i][j]==null && tableau[i][j+1].nord==true && a.sud==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i+1][j]!=null){
		    if(tableau[i][j]==null && tableau[i+1][j].est==true && a.ouest==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i-1][j]!=null){
		    if(tableau[i][j]==null && tableau[i-1][j].ouest==true && a.est==true) tableau[i][j]=a;
		    return;
		}
	    }
	    if(i>0 && j==tableau[0].length-1 && i<tableau.length-1){
		if(tableau[i][j-1]!=null){
		    if(tableau[i][j]==null && tableau[i][j-1].sud==true && a.nord==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i+1][j]!=null){
		    if(tableau[i][j]==null && tableau[i+1][j].est==true && a.ouest==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i-1][j]!=null){
		    if(tableau[i][j]==null && tableau[i-1][j].ouest==true && a.est==true) tableau[i][j]=a;
		    return;
		}
	    }
	    if(i==tableau.length && j==tableau[0].length-1){
		if(tableau[i][j-1]!=null){
		    if(tableau[i][j]==null && tableau[i][j-1].sud==true && a.nord==true) tableau[i][j]=a;
		    return;
		}
		if(tableau[i-1][j]!=null){
		    if(tableau[i][j]==null && tableau[i-1][j].ouest==true && a.est==true) tableau[i][j]=a;
		    return;
		}
	    }
	    System.out.println("cette carte n'est pas placeable");
	    return;
	}
	System.out.println("cette carte n'est pas placeable");
    }
     
    
    public static void main(String[]args){
	Plateau p= new Plateau();
	CheminMine c= new CheminMine("chem");
	 CheminMine c1= new CheminMine("chem1");
	// Carte c2= new CheminMine("chem2");
	// Carte c3= new CheminMine("chem3");
	// Carte c4= new CheminMine("chem4") ;
	 p.PlacerUneCarte(c,3,1);
	p.PlacerUneCarte(c1,4,0);
	System.out.println(c1.est);
	//	System.out.println(c.nord);

	p.afficherPlateu();
    }
}
    

	



		    
