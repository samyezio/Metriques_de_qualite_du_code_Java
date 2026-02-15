import javax.swing.*;
import java.awt.*;

public class ourMetricDetailFrame extends JFrame {
    public ourMetricDetailFrame(String metricName) {
        setTitle("Metric Detail: " + metricName);
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
        switch (metricName) {
            case "Indice de Complexité Méthodologique (ICM)":
                String htmlContent2 = """
                        <html>
                        <body>
                        <h1>Indice de Complexité Méthodologique (ICM)</h1>
                        <h2>Définition</h2>
                        <p>L'Indice de Complexité Méthodologique (ICM) évalue la complexité d'une classe en tenant compte de la distribution et de la diversité de ses méthodes. Il combine plusieurs facteurs tels que le nombre total de méthodes, les modificateurs d'accès, les propriétés spécifiques des méthodes (comme <strong>static</strong>, <strong>final</strong>, <strong>abstract</strong>), et les relations d'héritage pour fournir une mesure unique de complexité.</p>
                        <h2>Composants :</h2>
                        <h3>1. Nombre Total de Méthodes (NTM)</h3>
                        <p><strong>Description</strong>: Nombre total de méthodes dans une classe, y compris les méthodes héritées.</p>
                        <h3>2. Complexité des Modificateurs d'Accès (CMA)</h3>
                        <p><strong>Formule</strong>:</p>
                        <img src="https://prod-files-secure.s3.us-west-2.amazonaws.com/66c48e29-83f3-46ec-9c0a-8ad0b0004a87/5ae88b04-3edd-40d0-8252-a6670b925e84/Untitled.png" alt="CMA formula">
                        <p><strong>PM</strong>: Nombre de méthodes publiques.</p>
                        <p><strong>PRM</strong>: Nombre de méthodes privées.</p>
                        <p><strong>PTM</strong>: Nombre de méthodes protégées.</p>
                        <p><strong>DAM</strong>: Nombre de méthodes avec accès par défaut.</p>
                        <p>Où Wpm, Wprm, Wptm, Wdam sont des poids attribués respectivement aux méthodes publiques, privées, protégées et par défaut. Les poids peuvent être ajustés en fonction de l'importance ou de la visibilité des méthodes dans le contexte du projet.</p>
                        <h3>3. Propriétés Spécifiques des Méthodes (PSM)</h3>
                        <p><strong>Formule</strong>:</p>
                        <img src="https://prod-files-secure.s3.us-west-2.amazonaws.com/66c48e29-83f3-46ec-9c0a-8ad0b0004a87/e7e26546-3be7-4f75-beb9-8c539af8b93b/Untitled.png" alt="PSM formula">
                        <p><strong>FM</strong>: Nombre de mé thodes finales.</p>
                        <p><strong>SM</strong>: Nombre de méthodes statiques.</p>
                        <p><strong>AM</strong>: Nombre de méthodes abstraites.</p>
                        <p>Où Wfm, Wsm, Wam sont des poids attribués respectivement aux méthodes finales, statiques et abstraites.</p>
                        <h3>4. Indice d'Héritage (IH)</h3>
                        <p><strong>Formule</strong>:</p>
                        <img src="https://prod-files-secure.s3.us-west-2.amazonaws.com/66c48e29-83f3-46ec-9c0a-8ad0b0004a87/6c77bb36-c709-4527-9ab6-5f66234fad48/Untitled.png" alt="IH formula">
                        <p><strong>IM</strong>: Nombre de méthodes héritées.</p>
                        <p><strong>OM</strong>: Nombre de méthodes surchargées.</p>
                        <h3>5. Diversité Méthodologique (DM)</h3>
                        <p><strong>Formule</strong>:</p>
                        <img src="https://prod-files-secure.s3.us-west-2.amazonaws.com/66c48e29-83f3-46ec-9c0a-8ad0b0004a87/b4e0797e-aa58-4580-ac23-a741e16b0172/Untitled.png" alt="DM formula">
                        <p><strong>e</strong>: Constante mathématique (approx. 2.71828).</p>
                        <p><strong>&mu;</strong>: Moyenne du nombre total de méthodes dans l'ensemble des classes du projet.</p>
                        <p><strong>&sigma;</strong>: Écart type du nombre total de méthodes dans l'ensemble des classes du projet.</p>
                        <h2>Formule Finale :</h2>
                        <p>L'Indice de Complexité Méthodologique (ICM) est calculé en combinant tous les composants mentionnés ci-dessus pour obtenir une mesure unique de la complexité.</p>
                        <img src="https://prod-files-secure.s3.us-west-2.amazonaws.com/66c48e29-83f3-46ec-9c0a-8ad0b0004a87/0466a713-154a-4b62-8e23-f63b342b5764/Untitled.png" alt="Final ICM formula">
                        <h2>Raison de la Sélection des Formules :</h2>
                        <p>Les formules choisies visent à fournir une évaluation équilibrée et complète de la complexité des méthodes d'une classe. Voici les raisons spécifiques :</p>
                        <ul>
                            <li><strong>Nombre Total de Méthodes (NTM)</strong>: Indicateur simple de la taille brute de la classe, utile pour identifier les classes potentiellement surchargées.</li>
                            <li><strong>Complexité des Modificateurs d'Accès (CMA)</strong>: Balance l'impact des différents modificateurs d'accès. Une classe bien conçue aura une distribution équilibrée de méthodes avec différents niveaux d'accès, reflétant une bonne encapsulation.</li>
                            <li><strong>Propriétés Spécifiques des Méthodes (PSM)</strong>: Les propriétés spécifiques des méthodes (final, static, abstract) influencent la flexibilité et la réutilisabilité. Une classe avec trop de méthodes de ces types peut être rigide ou difficile à tester.</li>
                            <li><strong>Indice d'Héritage (IH)</strong>: L'héritage est fondamental en programmation orientée objet, mais une mauvaise gestion peut introduire une complexité inutile. Cette métrique aide à évaluer cet aspect.</li>
                            <li><strong>Diversité Méthodologique (DM)</strong>: La diversité méthodologique donne une idée de la spécialisation d'une classe par rapport au projet global, évitant une mesure trop centrée sur des valeurs extrêmes.</li>
                        </ul>
                        <h2>Utilisation Pratique et Indications des Valeurs</h2>
                        <ul>
                            <li><strong>Valeur Minima (ICM &lt; 3)</strong>: Indication: Classe extrêmement simple, probablement sous-développée ou avec très peu de méthodes.</li>
                            <li><strong>Valeur Basse (3 &lt; ICM &lt; 10)</strong>: Indication: Classe relativement simple, avec peu de méthodes et une faible complexité.</li>
                            <li><strong>Valeur Modérée (10 &le; ICM &lt; 50)</strong>: Indication: Classe de complexité moyenne, bien équilibrée en termes de méthodes et de modificateurs d'accès.</li>
                            <li><strong>Valeur Élevée (50 &le; ICM &lt; 250)</strong>: Indication: Classe complexe avec un grand nombre de méthodes et une diversité élevée. Peut nécessiter une refactorisation pour améliorer la maintenabilité.</li>
                            <li><strong>Valeur Très Élevée (ICM &ge; 250)</strong>: Indication: Classe très complexe. Forte probabilité de problèmes de maintenabilité et de besoin urgent de refactorisation.</li>
                        </ul>
                        <h2>Cas d'Utilisation :</h2>
                        <ul>
                            <li><strong>Vue d'ensemble</strong>: En combinant différentes mesures, l'ICM fournit une vue d'ensemble de la complexité de la classe, en tenant compte à la fois du nombre et de la nature des méthodes et de l'influence de l'héritage.</li>
                            <li><strong>Analyse Avancée de la Complexité du Code</strong>: Permet de comparer la complexité de différentes classes au sein du même projet ou entre différents projets, ce qui aide à identifier les classes particulièrement complexes ou potentiellement problématiques.</li>
                            <li><strong>Planification de la Maintenance</strong>: Des valeurs d'ICM plus élevées peuvent indiquer des classes qui peuvent nécessiter plus d'efforts pour être comprises, maintenues et modifiées, aidant les développeurs à prioriser le refactorage ou les efforts de documentation supplémentaires.</li>
                            <li><strong>Optimisation de la Conception du Code</strong>: Aider à évaluer et à améliorer la conception des classes pour assurer un bon équilibrage entre fonctionnalité et maintenabilité.</li>
                            <li><strong>Audit de Qualité du Code</strong>: Utiliser l'ICM comme indicateur de la qualité du code pour les revues de code et les audits de qualité.</li>
                        </ul>
                        </body>
                        </html>
                        """;
                detailTextArea.setText(htmlContent2);
                break;
            case "methods calculator (MC) :":
                String htmlContent3 = """
                        <html>
                        <body>
                        <h1>Methods Calculator (MC)</h1>
                        <h2>Définition</h2>
                        <p>La MC fournit une répartition détaillée des méthodes dans une classe, catégorisée par leurs modificateurs d'accès, leur statut d'héritage et des propriétés spécifiques telles que <strong>static</strong>, <strong>final</strong> ou <strong>abstract</strong>.</p>
                        <h2>Composants :</h2>
                        <h3>1. Méthodes Totales</h3>
                        <p><strong>Description</strong>: Nombre total de méthodes dans une classe, y compris les méthodes héritées.</p>
                        <h3>2. Méthodes Publiques</h3>
                        <p><strong>Déclarées dans la Classe</strong>: Méthodes publiques déclarées directement dans la classe.</p>
                        <p><strong>Toutes les Publiques</strong>: Toutes les méthodes publiques, y compris celles héritées.</p>
                        <h3>3. Méthodes Privées</h3>
                        <p><strong>Déclarées dans la Classe</strong>: Méthodes privées déclarées directement dans la classe.</p>
                        <p><strong>Toutes les Privées</strong>: Toutes les méthodes privées, y compris celles héritées.</p>
                        <h3>4. Méthodes Protégées</h3>
                        <p><strong>Déclarées dans la Classe</strong>: Méthodes protégées déclarées directement dans la classe.</p>
                        <p><strong>Toutes les Protégées</strong>: Toutes les méthodes protégées, y compris celles héritées.</p>
                        <h3>5. Méthodes à Accès par Défaut</h3>
                        <p><strong>Déclarées dans la Classe</strong>: Méthodes avec accès par défaut déclarées directement dans la classe.</p>
                        <p><strong>Toutes les Méthodes à Accès par Défaut</strong>: Toutes les méthodes avec accès par défaut, y compris celles héritées.</p>
                        <h3>6. Méthodes Spéciales</h3>
                        <p><strong>Méthodes Finales</strong>: Méthodes déclarées <strong>final</strong>.</p>
                        <p><strong>Méthodes Statiques</strong>: Méthodes déclarées <strong>static</strong>.</p>
                        <p><strong>Méthodes Abstraites</strong>: Méthodes déclarées <strong>abstract</strong>.</p>
                        <h3>7. Héritage</h3>
                        <p><strong>Méthodes Héritées</strong>: Méthodes héritées des superclasses ou des interfaces.</p>
                        <p><strong>Méthodes Surchargées</strong>: Méthodes qui surchargent des méthodes des superclasses ou des interfaces.</p>
                        <h2>Méthode de Calcul :</h2>
                        <p>Chaque composant est calculé en itérant sur les méthodes de la classe en utilisant l'API de Réflexion Java et en comptant les méthodes en fonction de leurs propriétés et modificateurs d'accès.</p>
                        <h2>Cas d'Utilisation :</h2>
                        <ul>
                            <li><strong>Analyse de la Complexité du Code</strong>: Identifier les classes avec un grand nombre de méthodes, qui pourraient être complexes et difficiles à maintenir.</li>
                            <li><strong>Identification des Refactorings</strong>: Repérer les zones où les classes pourraient nécessiter un refactoring en raison d'un grand nombre de méthodes ou de méthodes héritées.</li>
                            <li><strong>Évaluation du Design</strong>: Évaluer si une classe suit de bons principes de conception orientée objet en analysant la distribution des méthodes.</li>
                        </ul>
                        </body>
                        </html>
                        """;
                detailTextArea.setText(htmlContent3);
                break;
            case "ReusabilityMetric :":
                String description = "<html><body>"
                        + "<h1>Reusability Metric</h1>"
                        + "<p>La classe <b>ReusabilityMetric</b> est conçue pour évaluer la réutilisabilité d'une classe Java en calculant un score basé sur trois aspects clés : la cohésion, le couplage et l'utilisation des interfaces. Voici une description détaillée de cette métrique :</p>"
                        + "<h2>1. Calcul du Score de Réutilisabilité :</h2>"
                        + "<p>La méthode principale de cette classe est <b>calculateReusability</b> qui combine les scores de cohésion, de couplage et d'utilisation des interfaces pour calculer un score global de réutilisabilité.</p>"
                        + "<ul>"
                        + "<li><b>Score de Cohésion (cohesionScore)</b> : Mesure à quel point les méthodes de la classe travaillent ensemble vers un objectif commun.</li>"
                        + "<li><b>Score de Couplage (couplingScore)</b> : Mesure le degré de dépendance de la classe par rapport aux classes externes.</li>"
                        + "<li><b>Score d'Utilisation des Interfaces (interfaceUsageScore)</b> : Évalue la flexibilité et l'extensibilité de la classe en mesurant son utilisation des interfaces.</li>"
                        + "</ul>"
                        + "<p>Le score global est calculé comme la somme des scores de cohésion et d'utilisation des interfaces divisée par le score de couplage plus un.</p>"
                        + "<p><b>Formule de calcul :</b></p>"
                        + "<pre>R = (C + I) / (K + 1)</pre>"
                        + "<p>Où :</p>"
                        + "<ul>"
                        + "<li><b>C</b> : est le score de cohésion</li>"
                        + "<li><b>I</b> : est le score d'utilisation des interfaces</li>"
                        + "<li><b>K</b> : est le score de couplage</li>"
                        + "</ul>"
                        + "<h2>2. Calcul du Score de Cohésion :</h2>"
                        + "<p>La méthode <b>calculateCohesionScore</b> évalue la cohésion de la classe en comptant les méthodes pertinentes qui ne sont ni des getters, ni des setters, ni des constructeurs.</p>"
                        + "<ul>"
                        + "<li><b>Nombre de Méthodes Pertinentes (relevantMethodsCount)</b> : Méthodes qui ne sont pas des getters, des setters ou des constructeurs.</li>"
                        + "<li><b>Score de Cohésion (cohesionScore)</b> : évalue des méthodes pertinentes par rapport au nombre total de méthodes déclarées.</li>"
                        + "</ul>"
                        + "<p><b>Formule de calcul :</b></p>"
                        + "<pre>CohesionScore = (NBR de méthodes) / (NBR total de méthodes)</pre>"
                        + "<h2>3. Calcul du Score de Couplage :</h2>"
                        + "<p>La méthode <b>calculateCouplingScore</b> mesure le couplage en comptant les champs publics et les types de paramètres des méthodes qui ne font pas partie des packages standard de Java.</p>"
                        + "<ul>"
                        + "<li><b>Nombre de Dépendances Externes (externalDependenciesCount)</b> : Champs publics et types de paramètres des méthodes non standards.</li>"
                        + "<li><b>Score de Couplage (couplingScore)</b> : évalue des dépendances externes par rapport au nombre total de champs et de méthodes.</li>"
                        + "</ul>"
                        + "<p><b>Formule de calcul :</b></p>"
                        + "<pre>CouplingScore = (NBR de dépendances externes) / (NBR total de champs et de méthodes)</pre>"
                        + "<h2>4. Calcul du Score d'Utilisation des Interfaces :</h2>"
                        + "<p>La méthode <b>calculateInterfaceUsageScore</b> évalue l'utilisation des interfaces par la classe.</p>"
                        + "<ul>"
                        + "<li><b>Nombre d'Interfaces Implémentées (implementedInterfacesCount)</b> : Interfaces implémentées par la classe.</li>"
                        + "<li><b>Score d'Utilisation des Interfaces (interfaceUsageScore)</b> : évalue des interfaces implémentées par rapport au total (avec +1 pour éviter la division par zéro).</li>"
                        + "</ul>"
                        + "<p><b>Formule de calcul :</b></p>"
                        + "<pre>InterfaceUsageScore = (NBR d’interfaces implémentées) / (NBR_total d’interfaces)</pre>"
                        + "<h2>Objectif :</h2>"
                        + "<p>La métrique de réutilisabilité, implémentée par la classe <b>ReusabilityMetric</b>, a pour objectif d'évaluer quantitativement la facilité avec laquelle une classe Java peut être réutilisée dans différents contextes. Elle combine trois aspects essentiels de la conception du code pour fournir un score global de réutilisabilité : la cohésion, le couplage et l'utilisation des interfaces.</p>"
                        + "<h2>Conclusion :</h2>"
                        + "<p>Cette métrique de réutilisabilité fournit une évaluation quantifiée de la réutilisabilité des classes en Java en intégrant des aspects de conception essentiels tels que la cohésion, le couplage et l'utilisation des interfaces. Les résultats peuvent aider à identifier les classes qui sont bien conçues pour être réutilisées, ainsi que celles qui pourraient bénéficier d'améliorations pour augmenter leur réutilisabilité.</p>"
                        + "</body></html>";

                detailTextArea.setText(description);
                break;

            case "Métrique de détection de code mort (DCM) : ":
                String description2 = "<html><body>"
                        + "<h1>Détection de Code Mort (DCM)</h1>"
                        + "<p>La métrique <b>DCM</b>, ou Détection de Code Mort, est un processus d'analyse statique du code source visant à identifier les parties inutilisées d'une application logicielle, communément appelées \"code mort\". Ces fragments de code peuvent résulter d'erreurs de conception, de refactoring inapproprié, de fonctionnalités abandonnées, de commentaires désactivés ou de blocs conditionnels inutilisés.</p>"
                        + "<p>L'objectif principal de la métrique <b>DCM</b> est de repérer ces segments de code superflus afin de les éliminer, améliorant ainsi la qualité, la maintenabilité et les performances globales du logiciel.</p>"
                        + "<p>En scrutant le code source, la métrique DCM permet aux développeurs d'identifier les zones de complexité inutile et de risques potentiels, facilitant ainsi la décision de refactoriser et d'optimiser le code. En intégrant cette détection de codes inutilisés dans leur processus de développement, les équipes logicielles peuvent garantir un code plus propre, plus efficace et plus robuste, réduisant ainsi les risques de bugs et améliorant l'expérience utilisateur finale.</p>"
                        + "<h2>Objectifs et utilités de la Métrique DCM :</h2>"
                        + "<ul>"
                        + "<li><b>Optimisation du Code :</b> En identifiant les parties non utilisées, la métrique DCM encourage les développeurs à nettoyer et à optimiser le code, réduisant ainsi la complexité inutile et améliorant sa lisibilité.</li>"
                        + "<li><b>Réduction de la Taille du Code :</b> En éliminant le code mort, la taille du code source diminue, réduisant ainsi le temps de compilation, de déploiement et la consommation de mémoire.</li>"
                        + "<li><b>Détection d'Erreurs Potentielles :</b> Les sections de code inutilisées peuvent contenir des erreurs non détectées, la métrique DCM aide à les repérer, améliorant ainsi la fiabilité globale du logiciel.</li>"
                        + "<li><b>Meilleure Compréhension du Système et du Code :</b> En éliminant le code mort, les développeurs obtiennent une vision plus claire du système, facilitant l'intégration de nouvelles fonctionnalités et la maintenance du logiciel.</li>"
                        + "</ul>"
                        + "<h2>Conclusion :</h2>"
                        + "<p>La métrique DCM est un outil essentiel pour les équipes de développement, contribuant à la création de programmes plus propres, optimisés et évolutifs. En éliminant le code mort, elle améliore la qualité et la maintenabilité du logiciel, conduisant à une meilleure expérience utilisateur et à une réduction des risques de bugs. Ainsi, la métrique DCM joue un rôle crucial dans le processus de développement logiciel, garantissant la production de logiciels robustes et fiables.</p>"
                        + "</body></html>";

                detailTextArea.setText(description2);
                break;

            case "Indice de Structuration du Code ISC : ":
                String htmlContent = "<html>" +
                        "<body>" +
                        "<h2>Indice de Structuration du Code (ISC)</h2>" +
                        "<p><font color='cyan'><u>L'Indice de Structuration du Code (ISC)</u> est une mesure composite conçue pour évaluer la qualité de la structuration du code source en tenant compte de plusieurs aspects essentiels : la cohésion, le couplage et la modularité. Ces aspects sont mesurés à l'aide de métriques standard telles que LCOM (Lack of Cohésion in Methods), FANIN (Fan-in), FANOUT (Fan-out) et CBO (Coupling Between Objects). L'ISC fournit une évaluation globalisée de la qualité du code, facilitant l'identification des points forts et des faiblesses structurelles.</font></p>"
                        +
                        "<h3>Objectif</h3>" +
                        "<p><font color='cyan'>L'objectif de l'ISC est de fournir aux développeurs et aux équipes de développement un outil de mesure unique et normalisé pour évaluer la qualité structurelle du code. En combinant plusieurs métriques en une seule, l'ISC permet de mieux comprendre la maintenabilité, la modularité et le niveau de couplage du code. Une haute valeur d'ISC indique une bonne structuration du code, facilitant la maintenance et l'évolution du logiciel, tandis qu'une basse valeur met en lumière des besoins potentiels en refactorisation.</font></p>"
                        +
                        "<h3>Formule et Explication de la Normalisation</h3>" +
                        "<p><font color='cyan'>Formule de l'ISC :</font></p>" +
                        "<pre><font color='cyan'>ISC = ((NC + NM) - (NCBO + 1)) / 2</font></pre>" +
                        "<p><font color='cyan'>Pourquoi cette formule ?</font></p>" +
                        "<ul>" +
                        "<li><font color='cyan'>Intégration de plusieurs aspects : La formule intègre trois aspects clés de la qualité du code : la cohésion (NC), la modularité (NMOD) et le couplage (NCBO). Cela permet d'avoir une vue d'ensemble de la qualité de la structure du code en prenant en compte ces différentes dimensions.</font></li>"
                        +
                        "<li><font color='cyan'>Normalisation des métriques : Chaque métrique (NC, NMOD, NCBO) est normalisée, ce qui les rend comparables et équitablement pondérées dans le calcul de l'ISC. La normalisation garantit que les métriques contribuent de manière proportionnelle à l'indice final.</font></li>"
                        +
                        "<li><font color='cyan'>Facteur correctif : L'ajout de +1 dans le numérateur assure que l'ISC est toujours positif ou nul. Cela permet une interprétation intuitive des résultats et évite les valeurs négatives, même lorsque les métriques individuelles sont faibles.</font></li>"
                        +
                        "<li><font color='cyan'>Influence du couplage : La soustraction de NCBO reflète notre souhait d'avoir un couplage faible dans le code, ce qui est considéré comme une caractéristique de bonne conception logicielle. Ainsi, des valeurs élevées de NCBO (faible couplage) contribuent à des valeurs plus élevées d'ISC.</font></li>"
                        +
                        "<li><font color='cyan'>Moyenne pondérée : La division par 2 à la fin de la formule permet d'obtenir une moyenne pondérée des métriques normalisées. Cela garantit que l'ISC est exprimé sur une échelle de 0 à 1, où des valeurs plus élevées indiquent une meilleure qualité de la structure du code.</font></li>"
                        +

                        "<p><font color='cyan'><u>En combinant ces différents aspects, la formule fournit une mesure composite de la qualité de la structuration du code, prenant en compte la cohésion, la modularité et le couplage, tout en assurant une interprétation cohérente et intuitive des résultats.</u></font></p>"
                        +
                        "<h3>Explication des Composantes de la Formule:</h3>" +
                        "<p><font color='cyan'><u>NC (Normalized Cohésion)</u> : Cohésion normalisée, dérivée de LCOM.</font></p>"
                        +
                        "<p><font color='cyan'><u>NM (Normalized Modularity)</u> : Modularité normalisée, combinant FANIN et FANOUT.</font></p>"
                        +
                        "<p><font color='cyan'><u>NCO (Normalized Coupling)</u> : Couplage normalisé, dérivé de CBO.</font></p>"
                        +
                        "<h3>Normalisation des Composantes:</h3>" +
                        "<p><font color='cyan'><u>LCOM (Lack of Cohesion in Methods)</u> : Mesure la cohésion d'une classe en évaluant si les méthodes partagent ou non des variables. Une faible LCOM indiquerait une forte cohésion, ce qui est important pour notre métrique d'ISC.</font></p>"
                        +
                        "<p><font color='cyan'>Valeur maximale supposée : 3000</font></p>" +
                        "<p><font color='cyan'>Normalisation :</font></p>" +
                        "<pre><font color='cyan'>NC=1-LCOM/3000</font></pre>" +
                        "<p><font color='cyan'>Cette formule assure que la cohésion est comprise entre 0 (faible cohésion) et 1 (haute cohésion).</font></p>"
                        +
                        "<p><font color='cyan'><u>FANIN (Fan-in) et FANOUT (Fan-out)</u> :</font></p>" +
                        "<p><font color='cyan'>FANIN (Fan-in) : Mesure le nombre de modules qui utilisent un module donné. Cela peut nous aider à évaluer la réutilisabilité du code et l'impact de chaque module sur le reste du système.</font></p>"
                        +
                        "<p><font color='cyan'>FANOUT (Fan-out) : Mesure le nombre de modules utilisés par un module donné. Cela peut nous aider à évaluer la complexité et la dépendance de chaque module.</font></p>"
                        +
                        "<p><font color='cyan'>Modularité :</font></p>" +
                        "<pre><font color='cyan'>NM=(FANIN+FANOUT)/2*MAX(FANIN,FANOUT)</font></pre>" +
                        "<p><font color='cyan'>Ces formules assurent que la modularité est comprise entre 0 (faible modularité) et 1 (haute modularité).</font></p>"
                        +
                        "<p><font color='cyan'><u>CBO (Coupling Between Objects)</u> : Mesure le nombre de classes sur lesquelles une classe donnée dépend. Cela peut nous aider à évaluer le niveau de dépendance entre les différentes parties du code.</font></p>"
                        +
                        "<p><font color='cyan'>Valeur maximale supposée : 100</font></p>" +
                        "<p><font color='cyan'>Normalisation :</font></p>" +
                        "<pre><font color='cyan'>NCBO=1-CBO/100</font></pre>" +
                        "<p><font color='cyan'>Cette formule inverse le couplage pour que 0 représente un couplage maximal et 1 représente un couplage minimal (meilleur couplage), alignant ainsi avec l'objectif de faible couplage.</font></p>"
                        +
                        "<h3>Plages de valeurs pour l'ISC:</h3>" +
                        "<p><font color='cyan'><u>Haute valeur d'ISC (proche de 1)</u> : Indique une bonne structuration du code. Cela signifie généralement que :</font></p>"
                        +
                        "<ul>" +
                        "<li><font color='cyan'>La cohésion (LCOM) est élevée : Les méthodes et les attributs d'une classe sont bien liés entre eux.</font></li>"
                        +
                        "<li><font color='cyan'>La modularité (FANIN et FANOUT) est élevée : Les classes sont bien modulaires, avec une bonne répartition des responsabilités et des dépendances bien gérées.</font></li>"
                        +
                        "<li><font color='cyan'>Le couplage (CBO) est faible : Les classes ont peu de dépendances avec d'autres classes, ce qui facilite la maintenance et la réutilisation du code.</font></li>"
                        +
                        "</ul>" +
                        "<p><font color='cyan'><u>Valeur moyenne d'ISC (proche de 0.5)</u> : Indique une structuration du code correcte mais perfectible. Cela signifie généralement que :</font></p>"
                        +
                        "<ul>" +
                        "<li><font color='cyan'>La cohésion est moyenne : Les méthodes et les attributs d'une classe sont modérément liés entre eux.</font></li>"
                        +
                        "<li><font color='cyan'>La modularité est moyenne : Les classes sont modulaires, mais il y a des opportunités d'amélioration.</font></li>"
                        +
                        "<li><font color='cyan'>Le couplage est modéré : Les classes ont quelques dépendances avec d'autres classes, ce qui peut rendre la maintenance et la réutilisation du code plus difficiles.</font></li>"
                        +
                        "</ul>" +
                        "<p><font color='cyan'><u>Basse valeur d'ISC (proche de 0)</u> : Indique une structuration du code faible. Cela signifie généralement que :</font></p>"
                        +
                        "<ul>" +
                        "<li><font color='cyan'>La cohésion est faible : Les méthodes et les attributs d'une classe sont peu liés entre eux, ce qui peut indiquer que la classe a plusieurs responsabilités ou est mal conçue.</font></li>"
                        +
                        "<li><font color='cyan'>La modularité est faible : Les classes ne sont pas bien modulaires, avec des responsabilités mal définies et des dépendances mal gérées.</font></li>"
                        +
                        "<li><font color='cyan'>Le couplage est élevé : Les classes ont de nombreuses dépendances avec d'autres classes, ce qui rend la maintenance et la réutilisation du code très difficiles.</font></li>"
                        +
                        "</ul>" +
                        "<h3>Plages de valeurs spécifiques</h3>" +
                        "<ul>" +
                        "<li><font color='cyan'>0.8 - 1.0 : Excellente structuration du code. Reflète un code bien conçu, facile à maintenir et à étendre.</font></li>"
                        +
                        "<li><font color='cyan'>0.6 - 0.8 : Bonne structuration du code. Le code est généralement bien conçu avec quelques points à améliorer.</font></li>"
                        +
                        "<li><font color='cyan'>0.4 - 0.6 : Structuration moyenne du code. Le code pourrait bénéficier de quelques améliorations pour atteindre une meilleure qualité.</font></li>"
                        +
                        "<li><font color='cyan'>0.2 - 0.4 : Structuration faible du code. Des refactorisations sont probablement nécessaires pour améliorer la qualité du code.</font></li>"
                        +
                        "<li><font color='cyan'>0.0 - 0.2 : Très mauvaise structuration du code. Des changements majeurs sont nécessaires pour améliorer la qualité du code.</font></li>"
                        +
                        "</ul>" +
                        "<h3>Conclusion</h3>" +
                        "<p><font color='cyan'>L'ISC est une métrique puissante pour évaluer la qualité de la structuration du code. En combinant les métriques de cohésion, modularité et couplage, il fournit une mesure globale de la qualité du code. Cependant, il est important de comprendre que l'ISC est une métrique agrégée et ne capture pas tous les aspects de la qualité du code. Il doit être utilisé en conjonction avec d'autres métriques et techniques d'analyse pour obtenir une image complète de la qualité du code.</font></p>"
                        +
                        "</body>" +
                        "</html>";

                // Set the HTML content to the JEditorPane
                detailTextArea.setText(htmlContent);
                break;

            case "Taille de la Redondance Logique (TRL) :":
                String description3 = "<html>" +
                        "<h1>TRL (Taille de la Redondance Logique) :</h1>" +
                        "<h2>Description de la Métrique (TRL) :</h2>" +
                        "<p>La Taille de la Redondance Logique (TRL) est une métrique conçue pour quantifier la fréquence de répétition des structures de contrôle logiques au sein d'un code source. "
                        +
                        "Elle mesure la diversité et l'unicité des motifs logiques. En fournissant une indication de la redondance logique globale, cette métrique aide à identifier les sections de code où des structures de contrôle similaires sont utilisées de manière répétée. "
                        +
                        "De plus, la TRL permet de repérer les segments de code qui accomplissent des tâches identiques ou très similaires, mais avec des implémentations légèrement différentes. Cela peut révéler des opportunités pour rationaliser et unifier le code, améliorant ainsi la maintenabilité et la performance globales.</p>"
                        +
                        "<h2>Objectifs de la Métrique TRL :</h2>" +
                        "<ul>" +
                        "<li><strong>Réduire les Redondances :</strong> Identifier et minimiser les répétitions inutiles de motifs logiques pour améliorer la clarté et l'efficacité du code.</li>"
                        +
                        "<li><strong>Diminuer la Complexité :</strong> Favoriser l'utilisation de structures logiques diversifiées pour rendre le code moins complexe et plus facile à comprendre.</li>"
                        +
                        "<li><strong>Réduire la Taille du Code :</strong> Éliminer les redondances permet de réduire la taille globale du code source, rendant le projet plus léger et plus facile à maintenir.</li>"
                        +
                        "<li><strong>Faciliter le Refactoring :</strong> Aider les développeurs à repérer les opportunités de refactorisation pour unifier et optimiser le code, rendant ainsi le projet plus cohérent et performant.</li>"
                        +
                        "</ul>" +
                        "<h2>Formule de Calcul de TRL :</h2>" +
                        "<p>TRL = (Nombre total de motifs logiques / Nombre de motifs logiques distincts) * 100%</p>" +
                        "<h2>Étapes de Calcul :</h2>" +
                        "<ol>" +
                        "<li><strong>Identification des Motifs Logiques Distincts :</strong> Analyser le code source pour identifier les différents types de structures de contrôle logiques utilisées (ex. if, for, while, switch, try, catch, etc.).</li>"
                        +
                        "<li><strong>Comptage des Occurrences Totales de Motifs Logiques :</strong> Compter le nombre total d'occurrences de toutes les structures de contrôle logiques dans le code.</li>"
                        +
                        "<li><strong>Calcul du Pourcentage de Redondance Logique :</strong></li>" +
                        "<ul>" +
                        "<li>Diviser le nombre de motifs logiques distincts par le nombre total de motifs logiques.</li>"
                        +
                        "<li>Multiplier le résultat par 100 pour obtenir le pourcentage de la TRL.</li>" +
                        "</ul>" +
                        "</ol>" +
                        "<h2>Conclusion :</h2>" +
                        "<p>En résumé, la Taille de la Redondance Logique (TRL) offre une évaluation fine de la répétition des structures de contrôle logiques dans le code source. En réduisant les redondances, la complexité et la taille du code, elle favorise une maintenance plus aisée et une meilleure performance. "
                        +
                        "Par l'identification des motifs logiques récurrents, elle guide les développeurs vers des pratiques de codage plus efficaces, améliorant ainsi la clarté et la robustesse du logiciel.</p>"
                        +
                        "</html>";

                detailTextArea.setText(description3);
                break;

            default:

                break;

        }
        JScrollPane scrollPane = new JScrollPane(detailTextArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        setContentPane(contentPane);
    }

}