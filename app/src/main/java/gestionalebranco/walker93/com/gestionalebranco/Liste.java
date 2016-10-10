package gestionalebranco.walker93.com.gestionalebranco;

/**
 * Created by Workstation 2 on 27/09/2016.
 */

 enum Sestiglie {
    Bianchi, Neri, Grigi, Rossi, Fulvi, Pezzati, Bruni
}


 enum Pista {
     Ammissione,
     Promessa,
     Prima_stella {
         @Override
         public String toString() {
             return "1° Stella";
         }
     },
     Seconda_stella {
         @Override
         public String toString() {
             return "2° Stella";
         }
     },
     Lupo_anziano {
         @Override
         public String toString() {
             return "Lupo Anziano";
         }
     }
}

enum Colore {
    Bianca,
    Rossa,
    Verde,
    Gialla,
    Blu
}