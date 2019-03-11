package mx.com.pelayo.templates;

public class BasePresenter<T extends BaseView> {

    private T baseView;

    /**
     * Coloca la interfaz de la vista
     *
     * @param baseView
     */
    public void setView(T baseView) {
        this.baseView = baseView;
    }

    /**
     * Obtiene la pantalla que implementa la vista, la cual a su vez tiene que heredar de BasicView
     *
     * @return Vista
     * @see BaseView
     */
    protected T getView() {
        return baseView;
    }
}
