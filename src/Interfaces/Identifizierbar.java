package Interfaces;

/**
 * Hiermit werden alle Objekte gekennzeichnet, die eine Textuelle ID von mindestens 10
 * Stellen zurückgeben können.
 * @author Lisa Vittori
 * @version 20.03.2018
 */
public interface Identifizierbar {
    /**
     * Diese Methode gibt einen ID-Bezeichnung mit mindestens 10 Stellen zurück
     * @return eine ID als Text mit mindestens 10 Zeichen.
     */
    public String identifier();
}
