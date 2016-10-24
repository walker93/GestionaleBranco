package gestionalebranco.walker93.com.gestionalebranco;

import com.orm.dsl.Ignore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Workstation 2 on 10/10/2016.
 */

public class Prova {
    @Ignore
    public static final List<Prova> allProve = new ArrayList<Prova>() {
        {
            add(new Prova(1, "Principali Preghiere", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa1));
            add(new Prova(2, "Pregh. Del branco", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa2));
            add(new Prova(3, "Battesimo", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa3));
            add(new Prova(4, "Pregare col corpo", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa4));
            add(new Prova(5, "Parabola", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa5));
            add(new Prova(6, "Canto liturgico", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa6));
            add(new Prova(7, "Parola Maestra", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa7));
            add(new Prova(7, "Legge", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa8));
            add(new Prova(7, "B_Promessa", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa9));
            add(new Prova(8, "B. A.", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa10));
            add(new Prova(9, "Saluto", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa11));
            add(new Prova(9, "Grande urlo", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa12));
            add(new Prova(10, "Distintivi", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa13));
            add(new Prova(11, "Sapersi presentare", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa14));
            add(new Prova(12, "Eseguire Danza giungla", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa15));
            add(new Prova(13, "Canto lupetto", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa16));
            add(new Prova(14, "Annodare Foulard", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa17));
            add(new Prova(15, "Allacciarsi Scarpe", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa18));
            add(new Prova(16, "Nodo Piano", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa19));
            add(new Prova(17, "Scrivere Dati anagrafici", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa20));
            add(new Prova(18, "Indirizzi VV.LL.", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa21));
            add(new Prova(19, "Scrivere cartolina", gestionalebranco.walker93.com.gestionalebranco.Pista.A_Ammissione, R.string.promessa22));
            add(new Prova(1, "Confessione", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima0));
            add(new Prova(2, "Pregh. Lupetto", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima1));
            add(new Prova(3, "vita gesù", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima2));
            add(new Prova(4, "Ricorrenze cristiane", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima3));
            add(new Prova(5, "S. Francesco", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima4));
            add(new Prova(6, "Parabole", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima5));
            add(new Prova(7, "Massime", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima6));
            add(new Prova(8, "Conoscenza giungla", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima7));
            add(new Prova(9, "Popoli giungla", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima8));
            add(new Prova(10, "Canti lupetto", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima9));
            add(new Prova(11, "Cura propri abiti", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima10));
            add(new Prova(12, "Pulire scarpe", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima11));
            add(new Prova(13, "Cura proprie cose", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima12));
            add(new Prova(14, "Bandiera Italia", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima13));
            add(new Prova(15, "Bandiera Europa", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima14));
            add(new Prova(16, "Norme Stradali", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima15));
            add(new Prova(17, "Indirizzo su busta", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima16));
            add(new Prova(18, "Orologio", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima17));
            add(new Prova(19, "Saper telefonare", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima18));
            add(new Prova(20, "Osservazione natura", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima19));
            add(new Prova(21, "Nodo rete", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima20));
            add(new Prova(21, "Nodo Galera", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima21));
            add(new Prova(21, "Nodo tessitore", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima22));
            add(new Prova(22, "Fare pacchetto", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima23));
            add(new Prova(23, "Capriola", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima24));
            add(new Prova(24, "Salto quaglia", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima25));
            add(new Prova(25, "Salto staccionata", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima26));
            add(new Prova(26, "Pié zoppo", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima27));
            add(new Prova(27, "Palla", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima28));
            add(new Prova(28, "Salto corda", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima29));
            add(new Prova(29, "Igiene personale", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima30));
            add(new Prova(30, "Respirare con naso", gestionalebranco.walker93.com.gestionalebranco.Pista.C_Prima_stella, R.string.prima31));
            add(new Prova(1, "Eucarestia", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda1));
            add(new Prova(2, "S. Messa", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda2));
            add(new Prova(3, "Vita gesù", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda8));
            add(new Prova(4, "Vangelo", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda3));
            add(new Prova(5, "Ricorrenze cristiane", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda4));
            add(new Prova(6, "Madonna", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda6));
            add(new Prova(7, "S. Francesco", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda7));
            add(new Prova(8, "Vita primi cristiani", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda5));
            add(new Prova(9, "Danza giungla", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda15));
            add(new Prova(10, "Dirigere scenetta", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda16));
            add(new Prova(11, "Diario di Branco", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda14));
            add(new Prova(12, "B.P", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(13, "Messaggio", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(14, "Risparmio", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(15, "Storia patria", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda9));
            add(new Prova(15, "Realizzazione Scientifica", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda10));
            add(new Prova(15, "Personaggi Illustri", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda11));
            add(new Prova(16, "Bandiere paesi europei", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda12));
            add(new Prova(17, "Alza-Amm. Bandiera", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.seconda13));
            add(new Prova(18, "Termometro", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(19, "Punti cardinali", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(19, "Corso del sole", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(20, "Stella polare", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(21, "Bussola", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(22, "Natura", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(23, "Trattamento ferita", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(24, "Tratt. Ustione leggera", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(25, "Conoscenza pericoli sporco", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(26, "Nodo Barcaiolo", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(26, "Nodo Margherita", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(26, "Nodo cappio bombardiere", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(27, "Cucire distintivo", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(27, "Attaccare bottore", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(29, "Stirare foulard", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(30, "Lavoretto", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(31, "Accensione Fuoco", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(32, "Conoscenza tracce - piantina", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(34, "Esercizi B.P.", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
            add(new Prova(37, "Salto fosso", gestionalebranco.walker93.com.gestionalebranco.Pista.D_Seconda_stella, R.string.promessa1));
        }
    };

    String Nome;
    Pista Pista;
    int Descrizione;
    int numProva;

    public Prova() {
    }

    ;

    public Prova(int numprova, String nome, Pista pista, int descrizione) {
        numProva = numprova;
        Nome = nome;
        Pista = pista;
        Descrizione = descrizione;
    }

    public static List<Prova> verboseStringToList(String verboseString) {
        List<Prova> result = new ArrayList<>();
        if (verboseString.length() >= 1) {
            String[] split = verboseString.split(", ");
            for (int i = 0; i < split.length; i++) {
                String nome = split[i];
                for (Prova p : allProve) {
                    if (p.Nome.equals(nome)) {
                        result.add(p);
                    }
                }
            }
        }
        return result;
    }

    public static String ListProveToIDString(List<Prova> list) {
        String result = "";
        for (Prova s : list) {
            result = result + allProve.indexOf(s) + ", ";
        }
        return result;
    }

    public static List<Prova> IDStringToProveList(String ids) {
        List<Prova> result = new ArrayList<>();
        if (ids != null) {
            if (ids.length() >= 1) {
                String[] split = ids.split(", ");
                for (int i = 0; i < split.length; i++) {
                    result.add(allProve.get(Integer.parseInt(split[i])));
                }
            }
        }
        return result;
    }

    public static List<String> ProveToName() {
        return Prova.ProveToName(allProve);
    }

    public static List<String> ProveToName(List<Prova> list) {
        return ProveToName(list, false);
    }

    public static List<String> ProveToName(List<Prova> list, boolean ShowPista) {
        List<String> result = new ArrayList<>();
        for (Prova s : list) {
            if (ShowPista) {
                result.add(s.Nome + " - " + s.Pista);
            } else {
                result.add(s.Nome);
            }
        }
            return result;
        }

    }


    class Prova_compare implements Comparator<Prova> {
        @Override
        public int compare(Prova o1, Prova o2) {
            if (o1.Pista.ordinal() > o2.Pista.ordinal()) {
                return 1;
            } else if (o1.Pista.ordinal() < o2.Pista.ordinal()) {
                return -1;
            } else {
                if (o1.numProva > o2.numProva) {
                    return 1;
                } else if (o1.numProva < o2.numProva) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

