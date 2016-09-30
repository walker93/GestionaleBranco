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
}
