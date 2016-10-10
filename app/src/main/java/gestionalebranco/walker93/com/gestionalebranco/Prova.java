package gestionalebranco.walker93.com.gestionalebranco;

import com.orm.dsl.Ignore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Workstation 2 on 10/10/2016.
 */

public class Prova {
    @Ignore
    public static final List<Prova> allProve = new ArrayList<Prova>(){
        {
            add(new Prova("piano", gestionalebranco.walker93.com.gestionalebranco.Pista.Ammissione,"nodo piano"));
            add(new Prova("rete", gestionalebranco.walker93.com.gestionalebranco.Pista.Ammissione,"nodo rete"));
            add(new Prova("tessitore", gestionalebranco.walker93.com.gestionalebranco.Pista.Ammissione,"nodo tessitore"));
        }
    };

    String Nome;
    Pista Pista;
    String Descrizione;

    public Prova(){
    };

    public Prova(String nome, Pista pista, String descrizione) {
        Nome = nome;
        Pista = pista;
        Descrizione = descrizione;
    }

    public static List<Prova> verboseStringToList(String verboseString){
        List<Prova> result = new ArrayList<>();
        if (verboseString.length()>=1) {
            String[] split = verboseString.split(", ");
            for (int i = 0; i < split.length; i++) {
                String nome = split[i];
                for (Prova p : allProve) {
                    if (p.Nome.equals(nome)) {result.add(p);}
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
        if (ids.length()>=1) {
            String[] split = ids.split(", ");
            for (int i = 0; i < split.length; i++) {
                result.add(allProve.get(Integer.parseInt(split[i])));
            }
        }
        return result;
    }

    public static List<String> ProveToName(){
       return Prova.ProveToName(allProve);
    }

    public static List<String> ProveToName(List<Prova> list){
        List<String> result =  new ArrayList<>();
        for (Prova s : list) {
            result.add(s.Nome);
        }
        return result;
    }
}
