package mx.com.pelayo.templates;

import android.content.DialogInterface;

import java.util.HashMap;

public class BaseResponse {

    private static final String TAG = BaseResponse.class.getSimpleName();

    private String message;
    private HashMap<String, DialogInterface.OnClickListener> action;
    private DialogInterface.OnClickListener onDismissListener;

    /**
     * Obtiene el mensaje a mostrar
     *
     * @return mensaje
     */
    public String getMessage() {
        return message;
    }

    /**
     * Obtiene la acción con el listener de acción
     *
     * @return acción con listener
     */
    public HashMap<String, DialogInterface.OnClickListener> getAction() {
        return action;
    }

    /**
     * Obtiene el listener de acción de cerrado
     *
     * @return acción
     */
    public DialogInterface.OnClickListener getOnDismissListener() {
        return onDismissListener;
    }

    /**
     * Clase Builder utilizada para la creación de instancias de esta clase
     */
    public static class Builder {

        private BaseResponse baseResponse;

        public Builder(String message) {
            baseResponse = new BaseResponse();
            baseResponse.message = message;
            baseResponse.action = new HashMap<>();
        }

        /**
         * Agrega a la instancia de BaseResponse un click listener
         *
         * @param onClickListener listener
         * @return instancia de BaseResponse.Builder
         */
        public Builder addClickAction(String message, DialogInterface.OnClickListener onClickListener) {
            baseResponse.action.put(message, onClickListener);
            return this;
        }

        /**
         * Agrega a la instancia de BasicResponse un dismiss listener (listener de cerrado)
         *
         * @param onDismissListener listener
         * @return instancia de BasicResponse.Builder
         */
        public Builder addDismissAction(DialogInterface.OnClickListener onDismissListener) {
            baseResponse.onDismissListener = onDismissListener;
            return this;
        }

        /**
         * Devuelve la instancia BaseResponse
         *
         * @return instancia BaseResponse
         */
        public BaseResponse build() {
            return baseResponse;
        }
    }

}
