# TPJAVAFLO

Pourquoi est-il important de ne pas inclure la clé API directement dans le code source ?
Mettre les clés Api en dur  dans le code peut etre dangereux les mettres dans un fichier à pars permet de les sécuriser pour que personnes nous les voles pour les utiliser il est aussi bien de les mettre le fichier config.properties dans le gitignore pour éviter de le publier sur git 


Quelle est la différence entre une base SQL et MongoDB pour stocker ce
type de données ?

La structure des donnée SQL utilisse des table avec un shéma rigide alors que mongo stock les données avec des schéma flexible
SQL gère des relations complexes via des jointures, MongoDB favorise l’imbrication ou la référence entre documents.

Dans quel cas choisiriez-vous MongoDB plutôt qu’une base relationnelle ?

Je choisirais MongoDB si les données sont non structurées, évolutives ou nécessitent un schéma flexible. C’est aussi idéal pour des relations simples ou des performances sur des données massives comme des logs.