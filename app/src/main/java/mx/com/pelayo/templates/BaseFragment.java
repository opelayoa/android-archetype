package mx.com.pelayo.templates;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import mx.com.pelayo.callbacks.CallbackResponse;

public abstract class BaseFragment extends Fragment {

    private CallbackResponse actionCallbackResponse;

    /**
     * Método de Android llamado cuando la actividad que contiene al fragmento ha terminado su creación
     *
     * @param savedInstanceState contiene información sobre el estado de la actividad
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        hideKeyboard();
    }

    /**
     * Método de Android que es llamado cuando el fragmento ha sido creado
     *
     * @param savedInstanceState contiene información sobre el estado de la actividad
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Oculta el teclado al iniciar una actividad
     */
    protected void hideKeyboard() {
        View view = this.getBaseActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getBaseActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Método de Android que es llamado cuando la Actividad se vuelve visible para el usuario
     * En este método establecemos la interfaz de la vista necesaria para el presenter
     */
    @Override
    public void onStart() {
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
     * @return
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
    protected void showMessage(BaseResponse response) {
        getBaseActivity().showMessage(response);
    }

    /**
     * Muestra un mensaje de error al usuario con la información que se pasará en el parámetro,
     */
    protected void showError(BaseResponse response) {
        getBaseActivity().showError(response);
    }

    /**
     * Muestra un diálogo durante la carga de una actividad o proceso, con el texto que se pasará en el parámetro
     *
     * @param text Texto a mostrar en el diálogo
     */
    protected void showLoading(String text) {
        getBaseActivity().showLoading(text);
    }

    /**
     * Oculta el diálogo de carga
     */
    protected void hideLoading() {
        getBaseActivity().hideLoading();
    }

    /**
     * Utilizado para cambiar el fragmento en la actividad
     *
     * @param containerView identificador de la vista en la que se va a modificar el contenido
     * @param fragment      fragmento que se va a colocar
     * @param title         título del fragmento nuevo
     */
    public void changeFragment(int containerView, Fragment fragment, String title) {
        BaseActivity baseActivity = getBaseActivity();
        baseActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerView, fragment)
                .addToBackStack(null)
                .commit();
        baseActivity.getSupportActionBar().setTitle(title);
    }

    /**
     * Utilizado para cambiar el fragmento en la actividad
     *
     * @param containerView identificador de la vista en la que se va a modificar el contenido
     * @param fragment      fragmento que se va a colocar
     * @param title         título del fragmento nuevo
     */
    public void changeFragmentWithoutBackStack(int containerView, Fragment fragment, String title) {
        BaseActivity pulpomaticBasicActivity = getBaseActivity();
        pulpomaticBasicActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerView, fragment)
                .commit();
        pulpomaticBasicActivity.getSupportActionBar().setTitle(title);
    }

    /**
     * Obtiene la actividad que contiene al fragmento
     *
     * @return actividad
     */
    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    /**
     * Guarda el callback enviado como parámetro de forma temporal para ser utilizado una vez que necesite
     *
     * @param actionCallbackResponse callback
     */
    public final void setActionCallback(CallbackResponse actionCallbackResponse) {
        if (actionCallbackResponse == null) {
            throw new IllegalStateException("Callback could not be null");
        }
        if (this.actionCallbackResponse != null) {
            throw new IllegalStateException("You need end your operation");
        }
        this.actionCallbackResponse = actionCallbackResponse;
    }

    /**
     * Obtiene el callback temporal guardado en está actividad
     *
     * @return callback
     */
    public final CallbackResponse getActionCallback() {
        if (actionCallbackResponse == null) {
            throw new IllegalStateException("You need set the callback first");
        }
        CallbackResponse callbackResponse = actionCallbackResponse;
        actionCallbackResponse = null;
        return callbackResponse;
    }

    /**
     * Llamado por el sistema Android cuando se regresa de una actividad que sea llamada por el método
     * <code>startActivityForResult</code>, en este método se resuelve la acción <code>pictureFrom</code>
     *
     * @param requestCode código de acción
     * @param resultCode  código de resultado
     * @param data        datos enviados por la actividad terminada
     */
    @Override
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
