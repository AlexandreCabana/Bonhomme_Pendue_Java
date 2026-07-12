# Bonhomme pendu
Ce bonhomme pendu est le premier projet que j'ai fait en Java. Je l'ai fait dans le but d'apprendre le langage.
## Comment exécuter
Compiler le projet avec un interpréteur java. Dans mon cas, j'utilise le SDK 21. Une fois le programme lancé. On peut commencer à deviner le mot choisi aléatoirement dans une liste de mots. 
## Comment jouer
Le but est deviné le mot mystère choisi aléatoirement par le programme. Pour ce faire, on peut essayer des lettres ou rentrer le mot directement.
Si la lettre est dans le mot, il s'affichera à l'endroit que la lettre doit être.
![image](image%20docs/lettreDeviné.png)
Si elle n'est pas dans le mot, des membres vont apparaitre sur le bonhomme et le compteur d'essai augmentent d'un. Si c'est dans le mot, vous allez voire les lettres à la bonne place
![image](image%20docs/mauvaiseLettre.png)
Si à un moment, vous pensez avoir le mot, vous pouvez l'écrire directement. S'il est bon, vous avez gagné. Sinon, votre nombre d'essaie augmente de un.
![image](image%20docs/motTrouvéDirect.png)
Vous perder lorsque votre nombre d'essai est égale à 6.
![image](image%20docs/perdu.png)
## Amélioration futur
- Faire une interface graphique
- Laissez l'utilisateur choisir son propre fichier de mots (possibilité de plusieurs langues)