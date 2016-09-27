package gestionalebranco.walker93.com.gestionalebranco;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;
import java.util.List;

/**
 * Created by Workstation 2 on 26/09/2016.
 */

public class Lupetto extends SugarRecord{
    public String Nome;
    public String Cognome;
    public Sestiglie Sestiglia;
    public Pista Pista;
    // public List<Specialità> Specialità;
    public boolean CdA;
    public Date DataNascita;
    public String Luogo_Nascita;
    public Anagrafica Anagrafica;


    public Lupetto(){
    }

    public Lupetto(String nome, String cognome, Sestiglie sestiglia, Pista pista,
                   boolean cda, Anagrafica anagrafica){
        this.Nome = nome;
        this.Cognome = cognome;
        this.Sestiglia = sestiglia;
        this.Pista = pista;
        //this.Specialità = specialità;
        this.CdA = cda;
        this.Anagrafica = anagrafica;
    }
}
