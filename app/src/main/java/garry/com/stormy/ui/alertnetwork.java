package garry.com.stormy.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Garry on 12/15/2015.
 */
public class alertnetwork extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       Context context=getActivity();
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("OOPS!")
               .setMessage("NO NETWORK")
                .setPositiveButton("ok",null);
      AlertDialog dialog = builder.create();
        return dialog;
    }
}
