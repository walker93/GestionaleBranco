package gestionalebranco.walker93.com.gestionalebranco;

import com.orm.SugarRecord;

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


    public Lupetto(){
    }

    public Lupetto(String nome, String cognome, Sestiglie sestiglia, Pista pista,
                   String specialità, boolean cda, Anagrafica anagrafica) {

        this.Nome = nome;
        this.Cognome = cognome;
        this.Sestiglia = sestiglia;
        this.Pista = pista;
        this.Specialità = specialità;
        this.CdA = cda;
        this.Anagrafica = anagrafica;
    }
}
