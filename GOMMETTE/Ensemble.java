import java.util.*;
public interface Ensemble{
    abstract  boolean EstVide();
    abstract  void initialisation();
    abstract void melanger();
    abstract int taille();
    abstract LinkedList<Gommette> distribuer();
      abstract Gommette piocher();
}
