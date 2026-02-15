public class ex_Commande {

  private static ex_GestionStock exGestionStock;

  public ex_Commande(ex_GestionStock exGestionStock) {
      ex_Commande.exGestionStock = exGestionStock;
  }

  public void processOrder() {
      if (exGestionStock != null) {
          // Simulation des opérations d'achat
          exGestionStock.addProduct(); // Méthode utilisée
          exGestionStock.updateProduct(); // Méthode utilisée
         
          analyser.registerMethodCall("processOrder");
        } else {
          System.out.println("Erreur : ex_GestionStock non initialisé.");
      }
  }
}
