import java.util.*;
public interface Ensemble{
    abstract  boolean EstVide();
    abstract  void initialisation();
    abstract void melanger();
    abstract int taille();
      abstract LinkedList<Domino> distribuer();
    abstract Domino piocher();
}
