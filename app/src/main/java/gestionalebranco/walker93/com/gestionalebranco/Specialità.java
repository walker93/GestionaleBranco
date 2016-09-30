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
            add(new Specialità("Accolito", Pista.Prima_stella, Colore.Bianca));
            add(new Specialità("Catechista", Pista.Seconda_stella, Colore.Bianca));
            add(new Specialità("Cerimoniere", Pista.Seconda_stella, Colore.Bianca));
            add(new Specialità("Lettore", Pista.Seconda_stella, Colore.Bianca));
            add(new Specialità("Liturgista", Pista.Seconda_stella, Colore.Bianca));
            add(new Specialità("Storia Sacra", Pista.Prima_stella, Colore.Bianca));
            add(new Specialità("Attore Folletto", Pista.Seconda_stella, Colore.Blu));
            add(new Specialità("Collezionista", Pista.Prima_stella, Colore.Blu));
            add(new Specialità("Giornalista", Pista.Seconda_stella, Colore.Blu));
            add(new Specialità("Occhio di Lince", Pista.Seconda_stella, Colore.Blu));
            add(new Specialità("Osservatore", Pista.Seconda_stella, Colore.Blu));
            add(new Specialità("Piccolo Europeo", Pista.Prima_stella, Colore.Blu));
            add(new Specialità("Segnalatore", Pista.Seconda_stella, Colore.Blu));
            add(new Specialità("Ago e filo", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Amico degli animali", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Artigiano", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Artista", Pista.Prima_stella, Colore.Gialla));
            add(new Specialità("Canterino", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Elettricista", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Fotografo", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Giardiniere", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Mani Abili", Pista.Prima_stella, Colore.Gialla));
            add(new Specialità("Scultore", Pista.Seconda_stella, Colore.Gialla));
            add(new Specialità("Atleta", Pista.Prima_stella, Colore.Verde));
            add(new Specialità("Ciclista", Pista.Seconda_stella, Colore.Verde));
            add(new Specialità("Giocatore di squadra", Pista.Seconda_stella, Colore.Verde));
            add(new Specialità("Montanaro", Pista.Seconda_stella, Colore.Verde));
            add(new Specialità("Nuotatore", Pista.Seconda_stella, Colore.Verde));
            add(new Specialità("Pattinatore", Pista.Prima_stella, Colore.Verde));
            add(new Specialità("Sciatore", Pista.Seconda_stella, Colore.Verde));
            add(new Specialità("Guida", Pista.Seconda_stella, Colore.Rossa));
            add(new Specialità("Infermiere", Pista.Seconda_stella, Colore.Rossa));
            add(new Specialità("Massaio", Pista.Prima_stella, Colore.Rossa));
            add(new Specialità("Messaggero", Pista.Prima_stella, Colore.Rossa));
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

}
