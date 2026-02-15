public class ex_GestionStock{ 

  public void addProduct() {
    System.out.println("Produit ajouté !");
   
    analyser.registerMethodCall("addProduct");  //ajout de la methode a l'ensemble "usedMethods".
}

public void updateProduct() {
    System.out.println("Produit mis à jour !");
    analyser.registerMethodCall("updateProduct");
}

public void deleteProduct() {
    System.out.println("Produit supprimé !");
    analyser.registerMethodCall("deleteProductt");
}

public void displayProductDetails() {
    System.out.println("Détails du produit affichés !");
    analyser.registerMethodCall("displayProductDetails");
}


}