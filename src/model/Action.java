package model;

/**
 * Classe Action. Repr�sente l'objet envoy� par les diff�rentes m�thodes "Actions"
 * Cette classe permet la communication entre les Items et le Game
 * @author Nicolas Nguyen
 */
public class Action {

    /**
     * numero du signal (NORMAL VICTORY ou LOSE)
     */
    private int signal;

    /**
     * String de l'Action
     */
    private String message;

    /**
     * Constructeur d'Action
     * @param signal numero du signal (NORMAL VICTORY ou  LOSE)
     * @param message String de l'Action
     */
    public Action(int signal, String message) {
        this.signal = signal;
        this.message = message;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public int getSignal() {
        return signal;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
