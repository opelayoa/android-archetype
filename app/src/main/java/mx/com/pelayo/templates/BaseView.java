package mx.com.pelayo.templates;

public interface BaseView<T> {

    /**
     * Obtiene la pantalla que implementa la vista, la cual a su vez tiene que heredar de esta interfaz para utilizarlo
     *
     * @return Pantalla de la vista
     */
    T getScreen();

}