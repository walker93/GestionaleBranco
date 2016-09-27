package gestionalebranco.walker93.com.gestionalebranco;

import com.orm.SugarRecord;

/**
 * Created by Workstation 2 on 27/09/2016.
 */

public class Specialità extends SugarRecord {
    public String Nome;
    public Pista Pista;
    public Colore Colore;


    public Specialità(){
    }

    public Specialità(String nome, Pista pista, Colore colore){
        this.Nome=nome;
        this.Pista=pista;
        this.Colore=colore;
    }
}
