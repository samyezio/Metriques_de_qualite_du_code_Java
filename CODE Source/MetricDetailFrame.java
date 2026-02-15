import javax.swing.*;
import java.awt.*;

public class MetricDetailFrame extends JFrame {
    public MetricDetailFrame(String metricName) {
        setTitle("Metric Detail: " + removeHtmlTags(metricName));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display detailed information based on the metric name
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JLabel metricLabel = new JLabel(metricName);
        metricLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(metricLabel, BorderLayout.NORTH);

       
        // Create the JEditorPane
        JEditorPane detailTextArea = new JEditorPane();
        detailTextArea.setContentType("text/html"); // Set content type for HTML
        detailTextArea.setEditable(false); // Make the editor pane non-editable

        // Add details specific to each metric
        switch (metricName) {
            case "<html><u>NMO (Number of Methods):</font></u></html>":
                String htmlText = "<html>" +
                        "<h1 style='text-align: center;'><u>NMO (Number of Methods)</h1>" +
                        "<h2><u>référence bibliographique:</h2>" +

                        "<ul>" +
                        "<li>Auteurs: Shriram R. Chidamber And Chris F. Kemerer</li>" +
                        "<li>Titre: A Metrics Suite for Object-Oriented Design</li>" +
                        "<li>Année de publication: 1994</li>" +
                        "<li>Lieu de publication: IEEE Transactions on Software Engineering</li>" +
                        "<li>Nom de l'éditeur: IEEE Computer Society Press</li>" +
                        "<li>Numéro de page(s): 477-491</li>" +
                        "</ul>" +
                        "<h2><u>Description:</h2>" +
                        "<p>NMO (Number of Methods) est une métrique logicielle qui mesure la complexité d'une classe en comptant le nombre de méthodes qu'elle définit.</p>"
                        +
                        "<h2><u>Calcul de NMO:</h2>" +
                        "<p>Le calcul de NMO est relativement simple. Il suffit de compter le nombre de méthodes définies dans une classe.</p>"
                        +
                        "<ol>" +
                        "<li>Identifier toutes les classes dans le système logiciel.</li>" +
                        "<li>Pour chaque classe, compter le nombre de méthodes qu'elle définit.</li>" +
                        "<li>Le NMO de la classe est le nombre de méthodes comptées.</li>" +
                        "</ol>" +
                        "<h2><u>Algorithmes de calcul de NMO:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer NMO.</p>" +
                        "<p>L'algorithme le plus simple est une boucle itérative qui parcourt toutes les classes et compte le nombre de méthodes pour chaque classe.</p>"
                        +
                        "<p>Des algorithmes plus sophistiqués peuvent être utilisés pour améliorer les performances, par exemple en utilisant des structures de données telles que des arbres ou des hachages.</p>"
                        +
                        "<h2><u>Implémentations de calcul de NMO en Java:</h2>"
                        +
                        "<p>La bibliothèque Apache Commons Lang: <a href='https://commons.apache.org/proper/commons-lang/'>https://commons.apache.org/proper/commons-lang/</a> contient une classe NMOCalculator qui peut être utilisée pour calculer NMO</p>"
                        +
                        "</html>";

                // Set the HTML text in the editor pane
                detailTextArea.setText(htmlText);

                break;

            case "<html><u>LOC (Lines of Code):</font></u></html>":
                String htmlContent = "<html>" +
                        "<body>" +
                        "<h1 style='text-align: center;'><font color='cyan'><u>LOC (Lines of Code)</u></font></h1>" +
                        "<h2><font color='cyan'><u>référence bibliographique:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Auteurs: Maurice H. Halstead</font></li>" +
                        "<li><font color='cyan'>Titre: Elements of software science</font></li>" +
                        "<li><font color='cyan'>Année de publication: 1977</font></li>" +
                        "<li><font color='cyan'>Lieu de publication: New York, États-Unis</font></li>" +
                        "<li><font color='cyan'>Nom de l'éditeur: Elsevier</font></li>" +
                        "<li><font color='cyan'>Numéro de page(s): 11-12</font></li>" +
                        "</ul>" +
                        "<h2><font color='cyan'><u>Description:</u></font></h2>" +
                        "<p><font color='cyan'>LOC (Lines of Code) est une mesure de la taille d'un logiciel.</font></p>"
                        +
                        "<p><font color='cyan'>Elle est définie comme le nombre de lignes de code source dans un programme.</font></p>"
                        +
                        "<h2><font color='cyan'><u>La métrique LOC est utilisée pour:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Comparer la taille des logiciels</font></li>" +
                        "<li><font color='cyan'>Estimer l'effort de développement d'un logiciel</font></li>" +
                        "<li><font color='cyan'>Prédire la qualité d'un logiciel</font></li>" +
                        "</ul>" +
                        "<p><font color='cyan'>Il est important de noter que la métrique LOC ne doit pas être utilisée comme la seule mesure de la taille ou de la complexité d'un logiciel. Car, le nombre de LOC ne tient pas compte de la complexité logique du code, de la structure du code, ou de la qualité du code.</font></p>"
                        +
                        "</body>" +
                        "</html>";

                // Set the HTML content to the JEditorPane
                detailTextArea.setText(htmlContent);
                break;

            case "<html><u>NOM (Number of Attributes):</font></u></html>":
                String htmlContent2 = "<html>" +
                        "<body>" +
                        "<h1 style='text-align: center;'><font color='cyan'><u>NOM (Number of Attributes)</u></font></h1>"
                        +
                        "<h2><font color='cyan'><u>référence bibliographique:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Auteurs: S. R. Chidamber et C. F. Kemerer</font></li>" +
                        "<li><font color='cyan'>Titre: A Metrics Suite for Object Oriented Design</font></li>" +
                        "<li><font color='cyan'>Année de publication: 1994</font></li>" +
                        "<li><font color='cyan'>Lieu de publication: IEEE Transactions on Software Engineering</font></li>"
                        +
                        "<li><font color='cyan'>Nom de l'éditeur: IEEE Computer Society</font></li>" +
                        "<li><font color='cyan'>Numéro de page(s): 481</font></li>" +
                        "</ul>" +
                        "<h2><font color='cyan'><u>Description:</u></font></h2>" +
                        "<p><font color='cyan'>NOM (Nombre d'attributs):</font></p>" +
                        "<ul>" +
                        "<li><font color='cyan'>est une mesure de la complexité d'une classe dans un programme orienté objet</font></li>"
                        +
                        "<li><font color='cyan'>Elle est définie comme le nombre d'attributs déclarés dans une classe.</font></li>"
                        +
                        "<li><font color='cyan'>Elle peut être utilisée pour comparer des classes et identifier les classes complexes.</font></li>"
                        +
                        "<li><font color='cyan'>Il est important de tenir compte des limites de la métrique NOM lors de son utilisation.</font></li>"
                        +
                        "</ul>" +
                        "<h2><font color='cyan'><u>Voici quelques avantages de la métrique NOM:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Simple à calculer</font></li>" +
                        "<li><font color='cyan'>Facile à comprendre</font></li>" +
                        "<li><font color='cyan'>Peut être utilisé pour comparer des classes de différents langages de programmation</font></li>"
                        +
                        "</ul>" +
                        "<h2><font color='cyan'><u>Voici quelques inconvénients de la métrique NOM:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Ne prend pas en compte la complexité des attributs</font></li>" +
                        "<li><font color='cyan'>Ne prend pas en compte la relation entre les attributs</font></li>" +
                        "<li><font color='cyan'>Peut être trompeur pour les classes avec des attributs simples</font></li>"
                        +
                        "</ul>" +
                        "</body>" +
                        "</html>";

                // Set the HTML content to the JEditorPane
                detailTextArea.setText(htmlContent2);
                break;

            case "<html><u>CLOC (Comment Lines of Code):</font></u></html>":
                String htmlContent3 = "<html>" +
                        "<body>" +
                        "<h1 style='text-align: center;'><font color='cyan'><u>CLOC (Comment Lines of Code)</u></font></h1>"
                        +
                        "<h2><font color='cyan'><u>référence bibliographique:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Auteurs: David A. Wheeler et Michael L. Wilson</font></li>" +
                        "<li><font color='cyan'>Titre: Software Engineering Notes</font></li>" +
                        "<li><font color='cyan'>Année de publication: 1996</font></li>" +
                        "<li><font color='cyan'>Lieu de publication: New York, NY, USA</font></li>" +
                        "<li><font color='cyan'>Nom de l'éditeur: Association for Computing Machinery (ACM)</font></li>"
                        +
                        "<li><font color='cyan'>Numéro de page(s): 69 et 70</font></li>" +
                        "</ul>" +
                        "<h2><font color='cyan'><u>Description:</u></font></h2>" +
                        "<p><font color='cyan'>CLOC est un outil de comptage de lignes de code qui s'utilise sur des fichiers de code source. Il permet de dénombrer les lignes de code, les lignes de commentaires et les lignes vides.</font></p>"
                        +
                        "<h2><font color='cyan'><u>Avantages:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Simple à utiliser</font></li>" +
                        "<li><font color='cyan'>Rapide et précis</font></li>" +
                        "<li><font color='cyan'>Gratuit et open source</font></li>" +
                        "</ul>" +
                        "<h2><font color='cyan'><u>Inconvénients:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Ne compte pas les lignes de code imbriquées</font></li>" +
                        "<li><font color='cyan'>Ne peut pas identifier les commentaires de documentation</font></li>" +
                        "</ul>" +
                        "<h2><font color='cyan'><u>Utilisations:</u></font></h2>" +
                        "<ul>" +
                        "<li><font color='cyan'>Estimation de la taille d'un projet logiciel</font></li>" +
                        "<li><font color='cyan'>Comparaison de la taille de différents projets</font></li>" +
                        "<li><font color='cyan'>Suivi de l'avancement d'un projet</font></li>" +
                        "<li><font color='cyan'>Identification des fichiers qui contiennent le plus de code</font></li>"
                        +
                        "</ul>" +
                        "</body>" +
                        "</html>";

                // Set the HTML content to the JEditorPane
                detailTextArea.setText(htmlContent3);
                break;

            case "<html><u>CBO (Coupling Between Objects):</font></u></html>":
                String htmlContent4 = "<html>" +
                        "<body>" + "<h1 style='text-align: center;'>CBO (Coupling Between Objects):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Shriram R. Chidamber And Chris F. Kemerer</li>" +
                        "<li><strong>Titre:</strong> A Metrics Suite for Object-Oriented Design</li>" +
                        "<li><strong>Année de publication:</strong> 1994</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 476-493</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>CBO (Coupling Between Objects)</strong> Représente le nombre de classes couplées à une classe donnée, Le couplage entre classes se produit lorsque des classes interagissent les unes avec les autres à travers des relations comme l'héritage, l'appel de méthodes, l'utilisation de variables ou de paramètres, etc...</p>"
                        +
                        "<h2>Formule De Calcule:</h2>" +
                        "<p>CBO(c) = |{d : c → d}|</p>" +
                        "<p>Où:</p>" +
                        "<ul>" +
                        "<li><code>CBO(c)</code> est la valeur CBO de la classe <code>c</code>.</li>" +
                        "<li><code>|S|</code> est la cardinalité de l'ensemble <code>S</code>.</li>" +
                        "<li><code>d</code> est une classe distincte avec laquelle la classe <code>c</code> interagit.</li>"
                        +
                        "<li><code>c → d</code> indique que la classe <code>c</code> appelle une méthode ou accède à une variable de la classe <code>d</code>.</li>"
                        +
                        "</ul>" +
                        "</html>";
                detailTextArea.setText(htmlContent4);
                break;

            case "<html><u>RFC (Reference For Class):</font></u></html>":
                String RFC = "<html>" +
                        "<h1>RFC (Response For Class):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteur:</strong> Briand, L. C., Daly, J. W., & Wüst, J</li>" +
                        "<li><strong>Titre:</strong> A unified framework for coupling measurement in object-oriented systems</li>"
                        +
                        "<li><strong>Année de publication:</strong> 1999</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Numéro de page:</strong> 25(1), 91-121.</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p>Mesure le nombre total de méthodes qui peuvent être potentiellement invoquées (directement ou indirectement) à partir d'une instance de la classe donnée. En d'autres termes, RFC représente le nombre de méthodes différentes auxquelles une classe peut potentiellement répondre.</p>"
                        +
                        "<p>Elle est utilisée pour évaluer la complexité et la taille d'une classe en programmation orientée objet.</p>"
                        +
                        "<p>Une RFC élevée peut indiquer une classe complexe avec de nombreuses responsabilités ou dépendances, ce qui peut rendre la classe plus difficile à maintenir, à tester et à comprendre.</p>"
                        +
                        "<h2>Formule de calcul:</h2>" +
                        "<p>La formule de calcul de la métrique RFC (Response For Class) peut être définie comme suit:</p>"
                        +
                        "<p><strong>RFC = NOM + CBO</strong></p>" +
                        "<p>où :</p>" +
                        "<ul>" +
                        "<li><strong>NOM (Number of Methods):</strong> Nombre total de méthodes définies dans la classe.</li>"
                        +
                        "<li><strong>CBO (Coupling Between Object classes):</strong> Nombre de classes couplées à la classe donnée.</li>"
                        +
                        "</ul>" +
                        "</html>";
                detailTextArea.setText(RFC);
                break;

            case "<html><u>CBM (Coupling Between Methods):</font></u></html>":
                String cbm = "<html>" + "<h1>CBM (Coupling Between Methods):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Lionel C. Briand et Yvan Labiche</li>" +
                        "<li><strong>Titre:</strong> A Comprehensive Framework for the Assessment of Software Quality</li>"
                        +
                        "<li><strong>Année de publication:</strong> 2002</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 145-165</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>CBM (Coupling Between Methods)</strong> est une métrique qui mesure le couplage entre les méthodes d'une classe en comptant le nombre de fois où une méthode en appelle une autre.</p>"
                        +
                        "<h2>Calcul de CBM:</h2>" +
                        "<p>Le calcul de CBM implique de compter le nombre d'appels de méthode entre différentes méthodes au sein d'une même classe.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes dans le système logiciel.</li>" +
                        "<li>Pour chaque méthode, compter le nombre d'appels de méthodes qu'elle effectue.</li>" +
                        "<li>Le CBM est la somme de tous les appels de méthode.</li>" +
                        "</ol>" +
                        "<h2>Algorithmes de calcul de CBM:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer CBM. Un algorithme simple peut utiliser une boucle itérative pour parcourir toutes les méthodes et compter le nombre d'appels de méthode pour chaque méthode.</p>"
                        +
                        "</html>";
                detailTextArea.setText(cbm);
                break;

            case "<html><u>Cd (Coupling Density):</font></u></html>":
                String cd = "<html>" +
                        "<h1>Cd (Coupling Density):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteur:</strong> Brian Henderson-Sellers</li>" +
                        "<li><strong>Titre:</strong> Coupling and Cohesion Metrics for C++</li>" +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> Journal of Object-Oriented Programming</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> SIGS Publications</li>" +
                        "<li><strong>Numéro de page(s):</strong> 9(5), 47-50</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p>La densité de couplage (Cd) est une métrique utilisée pour évaluer la complexité et l'interdépendance des modules au sein d'un système logiciel. "
                        +
                        "Elle mesure la proportion de relations de dépendance entre les modules par rapport au nombre total de modules.</p>"
                        +
                        "<p>Un couplage élevé signifie que les modules sont fortement dépendants les uns des autres, ce qui peut rendre le système plus difficile à maintenir, tester et modifier. "
                        +
                        "En revanche, un faible couplage est généralement souhaitable, car il implique que les modules sont plus indépendants et peuvent être modifiés sans affecter de manière significative les autres parties du système.</p>"
                        +
                        "<h2>Formule de calcul:</h2>" +
                        "<p>La formule de calcul de la densité de couplage est donnée par :</p>" +
                        "<p><strong>Cd = C / (N(N-1))</strong></p>" +
                        "<p>où :</p>" +
                        "<ul>" +
                        "<li>Cd est la densité de couplage</li>" +
                        "<li>C est le nombre total de relations de dépendance (ou de couplage) entre les modules</li>" +
                        "<li>N est le nombre total de modules dans le système</li>" +
                        "</ul>" +
                        "</html>";

                detailTextArea.setText(cd);
                break;

            case "<html><u>LCOM (Lack of Cohesion of Methods):</font></u></html>":
                String lcom = "<html>" +
                        "<h1>LCOM (Lack of Cohesion of Methods):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Victor R. Basili, Lionel C. Briand, et Walcelio L. Melo</li>" +
                        "<li><strong>Titre:</strong> A Validation of Object-Oriented Design Metrics as Quality Indicators</li>"
                        +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 751-761</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>LCOM (Lack of Cohesion of Methods)</strong> est une métrique qui mesure la cohésion d'une classe en évaluant le degré de similarité entre les méthodes de la classe en termes d'utilisation des attributs de la classe.</p>"
                        +
                        "<h2>Calcul de LCOM:</h2>" +
                        "<p>Le calcul de LCOM se base sur le nombre de paires de méthodes qui n'utilisent pas d'attributs communs moins le nombre de paires de méthodes qui utilisent des attributs communs.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes et les attributs dans une classe.</li>" +
                        "<li>Pour chaque paire de méthodes, vérifier les attributs qu'elles accèdent.</li>" +
                        "<li>Calculer LCOM en utilisant la formule :</li>" +
                        "</ol>" +
                        "<p><strong>LCOM = (nombre de paires de méthodes qui n'ont pas d'attributs communs) - (nombre de paires de méthodes qui ont des attributs communs)</strong></p>"
                        +
                        "<p>Si le résultat est négatif, LCOM est considéré comme 0.</p>" +
                        "<h2>Algorithmes de calcul de LCOM:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer LCOM. Un algorithme simple consiste à examiner chaque paire de méthodes et à vérifier les attributs qu'elles accèdent. Les algorithmes plus sophistiqués peuvent utiliser des structures de données comme des matrices d'adjacence pour optimiser le calcul.</p>"
                        +
                        "</html>";

                detailTextArea.setText(lcom);
                break;

            case "<html><u>CHC (Coupling Between Methods):</font></u></html>":
                String chc = "<html>" +
                        "<h1>CHC (Coupling Between Methods):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Victor R. Basili, Lionel C. Briand, et Walcelio L. Melo</li>" +
                        "<li><strong>Titre:</strong> A Validation of Object-Oriented Design Metrics as Quality Indicators</li>"
                        +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 751-761</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>CHC (Coupling Between Methods)</strong> est une métrique qui mesure le couplage entre les méthodes de différentes classes en comptant le nombre de fois où une méthode dans une classe appelle une méthode dans une autre classe.</p>"
                        +
                        "<h2>Calcul de CHC:</h2>" +
                        "<p>Le calcul de CHC implique de compter le nombre d'appels de méthode entre les méthodes de différentes classes.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes dans le système logiciel.</li>" +
                        "<li>Pour chaque méthode, identifier les appels de méthode qu'elle effectue vers des méthodes dans d'autres classes.</li>"
                        +
                        "<li>Le CHC est la somme de tous les appels de méthode entre les méthodes de différentes classes.</li>"
                        +
                        "</ol>" +
                        "<h2>Algorithmes de calcul de CHC:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer CHC. Un algorithme simple peut utiliser une boucle itérative pour parcourir toutes les méthodes et compter les appels de méthode vers d'autres classes. Les algorithmes plus sophistiqués peuvent améliorer les performances en utilisant des structures de données efficaces comme des graphes de dépendance.</p>"
                        +
                        "</html>";

                detailTextArea.setText(chc);
                break;
            case "<html><u>TCC (Tight Class Cohesion) and LCC (Loose Class Cohesion):</font></u></html>":
                String tcc = "<html>" +
                        "<h1>TCC (Tight Class Cohesion):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteur:</strong> Brian Henderson-Sellers</li>" +
                        "<li><strong>Titre:</strong> Coupling and Cohesion Metrics for C++</li>" +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> Journal of Object-Oriented Programming</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> SIGS Publications</li>" +
                        "<li><strong>Numéro de page(s):</strong> 47-50</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>TCC (Tight Class Cohesion)</strong> est une métrique qui mesure la cohésion d'une classe en évaluant le nombre de méthodes d'une classe qui utilisent des attributs communs.</p>"
                        +
                        "<h2>Calcul de TCC:</h2>" +
                        "<p>Le calcul de TCC implique de déterminer le pourcentage de paires de méthodes d'une classe qui accèdent au moins à un attribut commun.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes et les attributs dans une classe.</li>" +
                        "<li>Pour chaque paire de méthodes, vérifier si elles accèdent à au moins un attribut commun.</li>"
                        +
                        "<li>Calculer TCC en utilisant la formule :</li>" +
                        "</ol>" +
                        "<p><strong>TCC = (nombre de paires de méthodes accédant à au moins un attribut commun) / (nombre total de paires de méthodes).</strong></p>"
                        +
                        "<h2>Algorithmes de calcul de TCC:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer TCC. Un algorithme simple consiste à examiner chaque paire de méthodes et à vérifier les attributs qu'elles accèdent. Les algorithmes plus sophistiqués peuvent améliorer les performances en utilisant des structures de données efficaces comme des matrices d'adjacence.</p>"
                        +
                        "</html>";

                detailTextArea.setText(tcc);
                break;

            case "<html><u>CAM (Class Access Metric):</font></u></html>":
                String cam = "<html>" +
                        "<h1>CAM (Class Access Metric):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Lionel C. Briand et Yvan Labiche</li>" +
                        "<li><strong>Titre:</strong> A Comprehensive Framework for the Assessment of Software Quality</li>"
                        +
                        "<li><strong>Année de publication:</strong> 2002</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 145-165</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>CAM (Class Access Metric)</strong> est une métrique qui mesure l'accès aux attributs d'une classe par ses méthodes. "
                        +
                        "Cette métrique évalue dans quelle mesure les méthodes d'une classe accèdent aux attributs de cette classe.</p>"
                        +
                        "<h2>Calcul de CAM:</h2>" +
                        "<p>Le calcul de CAM implique de déterminer la proportion d'attributs de la classe qui sont accédés par ses méthodes.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier tous les attributs et toutes les méthodes dans une classe.</li>" +
                        "<li>Pour chaque méthode, identifier les attributs de la classe auxquels elle accède.</li>" +
                        "<li>Calculer CAM en utilisant la formule :</li>" +
                        "</ol>" +
                        "<p><strong>CAM = (nombre d'attributs distincts accédés par toutes les méthodes) / (nombre total d'attributs de la classe)</strong></p>"
                        +
                        "<h2>Algorithmes de calcul de CAM:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer CAM. Un algorithme simple consiste à examiner chaque méthode et à lister les attributs qu'elle accède, "
                        +
                        "puis à comparer cette liste avec l'ensemble des attributs de la classe. Les algorithmes plus sophistiqués peuvent optimiser ce processus en utilisant "
                        +
                        "des structures de données comme des matrices d'adjacence pour représenter les accès.</p>" +
                        "</html>";

                detailTextArea.setText(cam);
                break;

            case "<html><u>DIT (Depth of Inheritance Tree):</font></u></html>":
                String dit = "<html>" +
                        "<h1>DIT (Depth of Inheritance Tree):</h1>" +
                        "<h2>Référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Victor R. Basili, Lionel C. Briand, et Walcelio L. Melo</li>" +
                        "<li><strong>Titre:</strong> A Validation of Object-Oriented Design Metrics as Quality Indicators</li>"
                        +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 751-761</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>DIT (Depth of Inheritance Tree)</strong> est une métrique qui mesure la profondeur d'une classe dans la hiérarchie d'héritage d'un système orienté objet. "
                        +
                        "Cette métrique évalue le nombre de niveaux de classes parents au-dessus d'une classe donnée, jusqu'à la classe racine (généralement Object en Java).</p>"
                        +
                        "<h2>Calcul de DIT:</h2>" +
                        "<p>Le calcul de DIT consiste à compter le nombre de niveaux de la hiérarchie d'héritage depuis une classe jusqu'à la classe racine.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier la classe cible dont on veut calculer la profondeur d'héritage.</li>" +
                        "<li>Tracer la chaîne d'héritage en remontant de la classe cible jusqu'à la classe racine.</li>"
                        +
                        "<li>Compter le nombre de niveaux dans cette chaîne d'héritage.</li>" +
                        "<li>Le DIT de la classe est le nombre total de niveaux dans la chaîne d'héritage.</li>" +
                        "</ol>" +
                        "<h2>Algorithmes de calcul de DIT:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer DIT. Un algorithme simple consiste à utiliser une boucle récursive ou itérative pour remonter la chaîne d'héritage "
                        +
                        "et compter le nombre de niveaux. Les algorithmes plus sophistiqués peuvent utiliser des structures de données comme des arbres de classe pour optimiser ce processus.</p>"
                        +
                        "</html>";

                detailTextArea.setText(dit);
                break;

            case "<html><u>NPM (Number of Public Methods) :</font></u></html>":
                String npm = "<html>" +
                        "<h1>NPM (Number of Public Methods):</h1>" +
                        "<h2>référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Victor R. Basili, Lionel C. Briand, et Walcelio L. Melo</li>" +
                        "<li><strong>Titre:</strong> A Validation of Object-Oriented Design Metrics as Quality Indicators</li>"
                        +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 751-761</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>NPM (Number of Public Methods)</strong> est une métrique qui mesure le nombre de méthodes publiques définies dans une classe. "
                        +
                        "Cette métrique est utilisée pour évaluer la taille et la complexité potentielle d'une classe.</p>"
                        +
                        "<h2>Calcul de NPM:</h2>" +
                        "<p>Le calcul de NPM est relativement simple. Il suffit de compter le nombre de méthodes publiques définies dans une classe.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes publiques dans le système logiciel.</li>" +
                        "<li>Pour chaque classe, compter le nombre de méthodes publiques qu'elle définit.</li>" +
                        "<li>Le NPM de la classe est le nombre total de ses méthodes publiques.</li>" +
                        "</ol>" +
                        "<h2>Algorithmes de calcul de NPM:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer NPM. L'algorithme le plus simple est une boucle itérative qui parcourt toutes les classes "
                        +
                        "pour compter le nombre de méthodes publiques définies dans chaque classe.</p>" +
                        "</html>";

                detailTextArea.setText(npm);
                break;

            case "<html><u>WMC (Weighted Methods per Class):</font></u></html>":
                String wmc = "<html>" +
                        "<h1>WMC (Weighted Methods per Class):</h1>" +
                        "<h2>Référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Shyam R. Chidamber et Chris F. Kemerer</li>" +
                        "<li><strong>Titre:</strong> A Metrics Suite for Object-Oriented Design</li>" +
                        "<li><strong>Année de publication:</strong> 1994</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 476-493</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>WMC (Weighted Methods per Class)</strong> est une métrique qui mesure la complexité d'une classe en évaluant le nombre et la complexité des méthodes qu'elle contient. "
                        +
                        "Cette métrique utilise un poids pour chaque méthode, basé sur sa complexité cyclomatique ou d'autres critères de complexité.</p>"
                        +
                        "<h2>Calcul de WMC:</h2>" +
                        "<p>Le calcul de WMC implique de sommer les poids de toutes les méthodes définies dans une classe.</p>"
                        +
                        "<p>WMC = ∑<sub>i=0</sub><sup>n</sup> Ci</p>" +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes dans une classe.</li>" +
                        "<li>Attribuer un poids à chaque méthode en fonction de sa complexité.</li>" +
                        "<li>Sommer les poids de toutes les méthodes pour obtenir le WMC de la classe.</li>" +
                        "</ol>" +
                        "<h2>Algorithmes de calcul de WMC:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer WMC, en fonction de la méthode choisie pour attribuer les poids aux méthodes. "
                        +
                        "Un algorithme simple peut attribuer un poids fixe (par exemple, 1) à chaque méthode, tandis que des algorithmes plus sophistiqués peuvent utiliser "
                        +
                        "la complexité cyclomatique ou d'autres métriques de complexité pour déterminer les poids.</p>"
                        +
                        "</html>";

                detailTextArea.setText(wmc);
                break;

            case "<html><u>FAN (Fan-In) :</font></u></html>":
                String fan = "<html>" +
                        "<h1>FOUT (Fan-Out):</h1>" +
                        "<h2>Référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Victor R. Basili, Lionel C. Briand, et Walcelio L. Melo</li>" +
                        "<li><strong>Titre:</strong> A Validation of Object-Oriented Design Metrics as Quality Indicators</li>"
                        +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 751-761</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>FOUT (Fan-Out)</strong> est une métrique qui mesure le nombre de fois qu'une méthode appelle d'autres méthodes dans le système logiciel. "
                        +
                        "Cette métrique est utilisée pour évaluer la complexité et les dépendances externes d'une méthode.</p>"
                        +
                        "<h2>Calcul de FOUT:</h2>" +
                        "<p>Le calcul de FOUT implique de compter le nombre de fois qu'une méthode appelle d'autres méthodes dans le système.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes dans le système logiciel.</li>" +
                        "<li>Pour chaque méthode, compter le nombre d'appels sortants (c'est-à-dire les appels vers d'autres méthodes).</li>"
                        +
                        "<li>Le FOUT de la méthode est le nombre total de ses appels sortants.</li>" +
                        "</ol>" +
                        "<h2>Algorithmes de calcul de FOUT:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer FOUT. Un algorithme simple peut utiliser une boucle itérative pour parcourir toutes les méthodes "
                        +
                        "et compter le nombre d'appels sortants pour chaque méthode. Les algorithmes plus sophistiqués peuvent utiliser des structures de données comme des "
                        +
                        "graphes de dépendance pour optimiser ce processus.</p>" +
                        "</html>";

                detailTextArea.setText(fan);
                break;

            case "<html><u>FOUT (Fan-Out):</font></u></html>":
                String fout = "<html>" +
                        "<h1>FOUT (Fan-Out):</h1>" +
                        "<h2>Référence bibliographique:</h2>" +
                        "<ul>" +
                        "<li><strong>Auteurs:</strong> Victor R. Basili, Lionel C. Briand, et Walcelio L. Melo</li>" +
                        "<li><strong>Titre:</strong> A Validation of Object-Oriented Design Metrics as Quality Indicators</li>"
                        +
                        "<li><strong>Année de publication:</strong> 1996</li>" +
                        "<li><strong>Lieu de publication:</strong> IEEE Transactions on Software Engineering</li>" +
                        "<li><strong>Nom de l'éditeur:</strong> IEEE Computer Society Press</li>" +
                        "<li><strong>Numéro de page(s):</strong> 751-761</li>" +
                        "</ul>" +
                        "<h2>Description:</h2>" +
                        "<p><strong>FOUT (Fan-Out)</strong> est une métrique qui mesure le nombre de fois qu'une méthode appelle d'autres méthodes dans le système logiciel. "
                        +
                        "Cette métrique est utilisée pour évaluer la complexité et les dépendances externes d'une méthode.</p>"
                        +
                        "<h2>Calcul de FOUT:</h2>" +
                        "<p>Le calcul de FOUT implique de compter le nombre de fois qu'une méthode appelle d'autres méthodes dans le système.</p>"
                        +
                        "<p>Voici les étapes à suivre:</p>" +
                        "<ol>" +
                        "<li>Identifier toutes les méthodes dans le système logiciel.</li>" +
                        "<li>Pour chaque méthode, compter le nombre d'appels sortants (c'est-à-dire les appels vers d'autres méthodes).</li>"
                        +
                        "<li>Le FOUT de la méthode est le nombre total de ses appels sortants.</li>" +
                        "</ol>" +
                        "<h2>Algorithmes de calcul de FOUT:</h2>" +
                        "<p>Il existe plusieurs algorithmes pour calculer FOUT. Un algorithme simple peut utiliser une boucle itérative pour parcourir toutes les méthodes "
                        +
                        "et compter le nombre d'appels sortants pour chaque méthode. Les algorithmes plus sophistiqués peuvent utiliser des structures de données comme des "
                        +
                        "graphes de dépendance pour optimiser ce processus.</p>" +
                        "</html>";

                detailTextArea.setText(fout);
                break;
            default:
                detailTextArea.setText("No detailed information available.");
                System.out.println("fooo");
                break;
        }

        JScrollPane scrollPane = new JScrollPane(detailTextArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        setContentPane(contentPane);
    }

    public static String removeHtmlTags(String htmlString) {
        return htmlString.replaceAll("<[^>]*>", "");
    }
}