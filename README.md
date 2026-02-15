# Metriques_de_qualite_du_code_Java

Développement d’un programme **Java** pour analyser la **qualité du code source** et calculer différentes métriques afin d’améliorer la **maintenabilité**, la **lisibilité** et l’**efficacité** du code, ainsi que la **détection précoce de risques**.

## Fonctionnalités
- Analyse de projets / fichiers Java
- Calcul de métriques de qualité (standard + personnalisées)
- Aide à l’identification de problèmes : complexité élevée, modularité faible, redondance, code mort, etc.

## Métriques calculées
- **Complexité cyclomatique**
- **Lignes de code (LOC)**
- **Indicateurs personnalisés**

## Structure du projet

### Point d’entrée
- **Main** : `App.java`

### Interface (Frames)
- **First Frame** : `principalFrame.java`

### Classes des métriques

#### Indice de Complexité Méthodologique (ICM)
- `ICMCalculator.java`
- `ProjectAnalyzer.java`
- `ClassMetrics.java`

#### Methods Calculator (MC)
- `Calculter.java`

#### Reusability Metric (RM)
- `ReusabilityMetric.java`

#### Détection de code mort (DCM)
- `analyser.java`
- Tests avec :
  - `ex_Commande.java`
  - `ex_GestionStock.java`

#### Indice de Structuration du Code (ISC)
- `CBOmetric.java`
- `CodeQualityAnalyzer.java`
- `LCOMCalculator.java`
- `ModularityCalculator.java`

#### Taille de la Redondance Logique (TRL)
- `TRLmetric.java`

---
