package gestionalebranco.walker93.com.gestionalebranco;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Workstation 2 on 26/09/2016.
 */

public class Lupetto extends SugarRecord{

    public String Nome;
    public String Cognome;
    public Sestiglie Sestiglia;
    public Pista Pista;
    public String Specialità;
    public boolean CdA;
    public Anagrafica Anagrafica;
    public String Prove;
    public static String Assenze;

    public Lupetto(){
    }

    public Lupetto(String nome, String cognome, Sestiglie sestiglia, Pista pista,
                   String specialità, boolean cda, Anagrafica anagrafica, String prove, String assenze) {

        this.Nome = nome;
        this.Cognome = cognome;
        this.Sestiglia = sestiglia;
        this.Pista = pista;
        this.Specialità = specialità;
        this.CdA = cda;
        this.Anagrafica = anagrafica;
        this.Prove = prove;
        this.Assenze = assenze;
    }

    public static String LupettiToCSV(List<Lupetto> list){
        String result="Nome;Cognome;Sestiglia;Pista;Specialità;CdA;Anagrafica;Prove;Assenze;\n";
        for (Lupetto s : list) {
            result+=(s.Nome+";");
            result+=(s.Cognome+";");
            result+=(s.Sestiglia.name()+";");
            result+=(s.Pista.name()+";");
            result+=(gestionalebranco.walker93.com.gestionalebranco.Specialità.IDsToVerboseString(
                                s.Specialità) + ";");
            result+=(s.CdA+";");
            result+=(s.Anagrafica.print()+";");
            result+=(Prova.ListProveToVerboseString(s.Prove)+";");
            result+=(s.Assenze+";");
            result+=("\n");
        }
        return result;
    }


}
