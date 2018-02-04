package gestionalebranco.walker93.com.gestionalebranco;


import com.orm.dsl.Ignore;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Workstation 2 on 27/09/2016.
 */

public class Specialità {
    @Ignore
    public static final List<Specialità> allSpecialità = new ArrayList<Specialità>() {
        {
            add(new Specialità("Accolito", Pista.C_Prima_stella, Colore.Bianca));
            add(new Specialità("Catechista", Pista.D_Seconda_stella, Colore.Bianca));
            add(new Specialità("Cerimoniere", Pista.D_Seconda_stella, Colore.Bianca));
            add(new Specialità("Lettore", Pista.D_Seconda_stella, Colore.Bianca));
            add(new Specialità("Liturgista", Pista.D_Seconda_stella, Colore.Bianca));
            add(new Specialità("Storia Sacra", Pista.C_Prima_stella, Colore.Bianca));
            add(new Specialità("Attore Folletto", Pista.D_Seconda_stella, Colore.Blu));
            add(new Specialità("Collezionista", Pista.C_Prima_stella, Colore.Blu));
            add(new Specialità("Giornalista", Pista.D_Seconda_stella, Colore.Blu));
            add(new Specialità("Occhio di Lince", Pista.D_Seconda_stella, Colore.Blu));
            add(new Specialità("Osservatore", Pista.D_Seconda_stella, Colore.Blu));
            add(new Specialità("Piccolo Europeo", Pista.C_Prima_stella, Colore.Blu));
            add(new Specialità("Segnalatore", Pista.D_Seconda_stella, Colore.Blu));
            add(new Specialità("Ago e filo", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Amico degli animali", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Artigiano", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Artista", Pista.C_Prima_stella, Colore.Gialla));
            add(new Specialità("Canterino", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Elettricista", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Fotografo", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Giardiniere", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Mani Abili", Pista.C_Prima_stella, Colore.Gialla));
            add(new Specialità("Scultore", Pista.D_Seconda_stella, Colore.Gialla));
            add(new Specialità("Atleta", Pista.C_Prima_stella, Colore.Verde));
            add(new Specialità("Ciclista", Pista.D_Seconda_stella, Colore.Verde));
            add(new Specialità("Giocatore di squadra", Pista.D_Seconda_stella, Colore.Verde));
            add(new Specialità("Montanaro", Pista.D_Seconda_stella, Colore.Verde));
            add(new Specialità("Nuotatore", Pista.D_Seconda_stella, Colore.Verde));
            add(new Specialità("Pattinatore", Pista.C_Prima_stella, Colore.Verde));
            add(new Specialità("Sciatore", Pista.D_Seconda_stella, Colore.Verde));
            add(new Specialità("Guida", Pista.D_Seconda_stella, Colore.Rossa));
            add(new Specialità("Infermiere", Pista.D_Seconda_stella, Colore.Rossa));
            add(new Specialità("Massaio", Pista.C_Prima_stella, Colore.Rossa));
            add(new Specialità("Messaggero", Pista.C_Prima_stella, Colore.Rossa));
        }
    };
    public String Nome;
    public Pista Pist;
    public Colore Color;

    public Specialità(){
    }

    public Specialità(String nome, Pista pista, Colore colore){
        this.Nome=nome;
        this.Pist = pista;
        this.Color = colore;
    }

    public static String idsToString(List<Specialità> list) {
        String result = "";
        for (Specialità s : list) {
            result = result + allSpecialità.indexOf(s) + ";";
        }
        return result;
    }

    public static List<Specialità> stringToIDs(String ids) {
        List<Specialità> result = new ArrayList<>();
        if (ids.length()>=1) {
            String[] split = ids.split(";");
            for (int i = 0; i < split.length; i++) {
                result.add(Specialità.allSpecialità.get(Integer.parseInt(split[i])));
            }
        }
        return result;
    }

    public static String IDsToVerboseString(String ids) {

        return ListSpecialitàToVerboseString(stringToIDs(ids));
    }

    public static List<Specialità> verboseStringToList(String verboseString) {
        List<Specialità> result = new ArrayList<>();
        if (verboseString.length() >= 1) {
            String[] split = verboseString.split(", ");
            for (int i = 0; i < split.length; i++) {
                String nome = split[i];
                for (Specialità p : allSpecialità) {
                    if (p.Nome.equals(nome)) {
                        result.add(p);
                    }
                }
            }
        }
        return result;
    }

    public static String ListSpecialitàToVerboseString(List<Specialità> list) {
        String result = "";
        for (Specialità s : list) {
            result = result + s.Nome + ", ";
        }
        return result;
    }


}
