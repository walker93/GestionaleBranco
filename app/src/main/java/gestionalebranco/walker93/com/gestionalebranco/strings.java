package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Workstation 2 on 24/10/2016.
 */

public class strings {

    public static String byIdName(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }
}
