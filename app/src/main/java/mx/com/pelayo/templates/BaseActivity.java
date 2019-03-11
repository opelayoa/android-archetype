package mx.com.pelayo.templates;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import mx.com.pelayo.callbacks.CallbackResponse;

public abstract class BaseActivity extends AppCompatActivity {

    private CallbackResponse callbackResponse;

    /**
     * Método de Android que es llamado cuando la actividad se crea
     *
     * @param savedInstanceState contiene información sobre el estado de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Llamado para fijar la vista (layout) a la actividad
     *
     * @param viewId
     */
    @Override
    public void setContentView(int viewId) {
        super.setContentView(viewId);
        initViews();
        hideKeyboard();
    }

    /**
     * Método de Android que es llamado cuando la Actividad se vuelve visible para el usuario
     * En este método establecemos la interfaz de la vista necesaria para el presenter
     */
    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().setView(getModelView());

    }

    /**
     * Obtiene el presenter relacionado con la actividad
     *
     * @return
     */
    protected abstract BasePresenter getPresenter();

    /**
     * Obtiene la interfaz de la vista necesaria para la actividad
     *
     * @return BaseView
     * @see BaseView
     */
    protected abstract BaseView getModelView();

    /**
     * En este método se inicializarán los elementos de la vista,
     * obteniendo las referencias a los componentes creados en cada layout
     */
    protected abstract void initViews();

    /**
     * Muestra un mensaje informativo al usuario con la información que se pasará en el parámetro
     */
    public abstract void showMessage(BaseResponse response);

    /**
     * Muestra un mensaje de error al usuario con la información que se pasará en el parámetro,
     */
    public abstract void showError(BaseResponse response);

    /**
     * Muestra un diálogo durante la carga de una actividad o proceso, con el texto que se pasará en el parámetro
     *
     * @param text Texto a mostrar en el diálogo
     */
    public abstract void showLoading(String text);

    /**
     * Oculta el diálogo de carga
     */
    public abstract void hideLoading();

    /**
     * Oculta el teclado al iniciar una actividad
     */
    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Guarda el callback enviado como parámetro de forma temporal para ser utilizado una vez que necesite
     *
     * @param actionCallbackResponse callback
     */
    public void setActionCallback(CallbackResponse actionCallbackResponse) {
        if (actionCallbackResponse == null) {
            throw new IllegalStateException("Callback could not be null");
        }
        if (this.callbackResponse != null) {
            throw new IllegalStateException("You need end your operation");
        }
        this.callbackResponse = actionCallbackResponse;
    }

    /**
     * Obtiene el callback temporal guardado en está actividad
     *
     * @return callback
     */
    public CallbackResponse getActionCallback() {
        if (callbackResponse == null) {
            throw new IllegalStateException("You need set the callback first");
        }
        CallbackResponse callbackResponse = this.callbackResponse;
        this.callbackResponse = null;
        return callbackResponse;
    }

    /**
     * Llamado por el sistema Android cuando se terminan de solicitar permisos al usuario, en este método se
     * resuelve si los permisos han sido concedidos o denegados por el usuario
     *
     * @param requestCode  código de acción
     * @param permissions  permisos solicitados
     * @param grantResults resultado de la solicitud
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
