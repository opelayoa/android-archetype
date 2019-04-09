package mx.com.pelayo.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Writer;

import java.io.IOException;
import java.net.SocketTimeoutException;

import mx.com.pelayo.R;
import retrofit2.HttpException;

public class Tools {

    public static void setSystemBarColor(Activity act) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(act.getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public static int dpToPx(Context context, int dp) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static Bitmap convertToBarcode(String contents) {
        BitMatrix bitMatrix;
        try {
            int width = 1024;
            int height = 256;
            bitMatrix = new Code39Writer().encode(contents, BarcodeFormat.CODE_39, width, height);
            Bitmap bitmap = Bitmap.createBitmap(bitMatrix.getWidth(), bitMatrix.getHeight(), Bitmap.Config.RGB_565);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    bitmap.setPixel(i, j, bitMatrix.get(i, j) ? Color.BLACK : Color.WHITE);
                }
            }
            return bitmap;
        } catch (WriterException e) {
            return null;
        }
    }

    public static String addSpacesBetween(String string, int spaces) {
        String aux = "";
        if (string == null)
            return null;
        for (int i = 0; i < string.length(); i++) {
            aux += string.charAt(i);
            for (int j = 0; j < spaces; j++) {
                aux += " ";
            }
        }
        return aux.trim();
    }

    public static String parseError(Throwable throwable) {
        String error = "";
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            switch (httpException.code()){
                case 500:
                    error = "Error Interno del Servidor";
                    break;
                case 404:
                    error = "Recurso no encontrado";
                    break;
                case 401:
                    error = "Necesitas autenticación";
                    break;
                case 403:
                    error = "No tienes permisos para ver este recurso";
                    break;
            }
        } else if (throwable instanceof SocketTimeoutException){
            error = "Se agoto el tiempo, intentalo más tarde";
        } else if (throwable instanceof IOException){
            error = "Ocurrio un error inesperado, intentelo más tarde";
        } else {
            error = "Error interno, intentelo más tarde.";
        }
        return error;
    }

    public static String parseError(int code) {
        String error = "";
        switch (code){
            case 500:
                error = "Error Interno del Servidor";
                break;
            case 404:
                error = "Recurso no encontrado";
                break;
            case 401:
                error = "Necesitas autenticación";
                break;
            case 403:
                error = "No tienes permisos para ver este recurso";
                break;
        }
        return error;
    }

}