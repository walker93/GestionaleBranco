package gestionalebranco.walker93.com.gestionalebranco;

import com.orm.SugarRecord;

/**
 * Created by Workstation 2 on 27/09/2016.
 */

public class Anagrafica extends SugarRecord {
    public String Nome;
    public String Cognome;
    public String Indirizzo;
    public String Email;
    public String Tel_fisso;
    public String Cell_Madre;
    public String Cell_Padre;
    public String DataNascita;
    public String Luogo_Nascita;
    public Anagrafica(){
    }

    public Anagrafica(String nome, String cognome, String indirizzo,
                      String email, String tel_fisso,
                      String cell_Madre, String cell_Padre, String dataNascita, String luogo_nascita) {
        Nome = nome;
        Cognome = cognome;
        Indirizzo = indirizzo;
        Email = email;
        Tel_fisso = tel_fisso;
        Cell_Madre = cell_Madre;
        Cell_Padre = cell_Padre;
        DataNascita = dataNascita;
        Luogo_Nascita = luogo_nascita;
    }

    public String print(){
        String result ="";
        result+=(this.Nome+",");
        result+=(this.Cognome+",");
        result+=(this.Indirizzo+",");
        result+=(this.Email+",");
        result+=(this.Tel_fisso+",");
        result+=(this.Cell_Madre+",");
        result+=(this.Cell_Padre+",");
        result+=(this.DataNascita+",");
        result+=(this.Luogo_Nascita);

        return result;
    }

    public static Anagrafica read(String text){
        String[] values = text.split(",",-1);
        return new Anagrafica(
                values[0].trim(),
                values[1].trim(),
                values[2].trim(),
                values[3].trim(),
                values[4].trim(),
                values[5].trim(),
                values[6].trim(),
                values[7].trim(),
                values[8].trim()
        );

    }
}
