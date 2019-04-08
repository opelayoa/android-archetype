package mx.com.pelayo.ui.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import mx.com.pelayo.R;

public class DialogFactory {

    public static Dialog getInfoDialog(Context context, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dialog.findViewById(R.id.buttonOk).setOnClickListener(v -> dialog.dismiss());
        ((TextView) dialog.findViewById(R.id.title)).setText("Información");
        ((TextView) dialog.findViewById(R.id.message)).setText(message);
        ((TextView) dialog.findViewById(R.id.icon)).setText(context.getString(R.string.icon_check_circle));

        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static Dialog getInfoDialog(Context context, String message, DialogListener dialogListener) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dialog.findViewById(R.id.buttonOk).setOnClickListener(v -> dialogListener.onClickListener(dialog));
        ((TextView) dialog.findViewById(R.id.title)).setText("Información");
        ((TextView) dialog.findViewById(R.id.message)).setText(message);
        ((TextView) dialog.findViewById(R.id.icon)).setText(context.getString(R.string.icon_check_circle));

        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static Dialog getAlertDialog(Context context, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dialog.findViewById(R.id.buttonOk).setOnClickListener(v -> dialog.dismiss());
        ((TextView) dialog.findViewById(R.id.title)).setText("Alerta");
        ((TextView) dialog.findViewById(R.id.message)).setText(message);
        ((TextView) dialog.findViewById(R.id.icon)).setText(context.getString(R.string.icon_exclamation_circle));

        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static Dialog getAlertDialog(Context context, String message, DialogListener dialogListener) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dialog.findViewById(R.id.buttonOk).setOnClickListener(v -> dialogListener.onClickListener(dialog));
        ((TextView) dialog.findViewById(R.id.title)).setText("Alerta");
        ((TextView) dialog.findViewById(R.id.message)).setText(message);
        ((TextView) dialog.findViewById(R.id.icon)).setText(context.getString(R.string.icon_exclamation_circle));

        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static Dialog getErrorDialog(Context context, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dialog.findViewById(R.id.buttonOk).setOnClickListener(v -> dialog.dismiss());
        ((TextView) dialog.findViewById(R.id.title)).setText("Error");
        ((TextView) dialog.findViewById(R.id.message)).setText(message);
        ((TextView) dialog.findViewById(R.id.icon)).setText(context.getString(R.string.icon_times_circle));

        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static Dialog getErrorDialog(Context context, String message, DialogListener dialogListener) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        dialog.findViewById(R.id.buttonOk).setOnClickListener(v -> dialogListener.onClickListener(dialog));
        ((TextView) dialog.findViewById(R.id.title)).setText("Error");
        ((TextView) dialog.findViewById(R.id.message)).setText(message);
        ((TextView) dialog.findViewById(R.id.icon)).setText(context.getString(R.string.icon_times_circle));

        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static Dialog getProgressDialog(Context context, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_progress_layout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        ((TextView) dialog.findViewById(R.id.title)).setText(message);
        ProgressBar progressBar = dialog.findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(context, R.color.colorWhite), PorterDuff.Mode.SRC_IN);

        dialog.getWindow().setAttributes(lp);
        return dialog;
    }

    public static interface DialogListener {

        void onClickListener(Dialog dialog);
    }
}
