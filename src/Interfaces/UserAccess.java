package Interfaces;

public interface UserAccess {
    boolean buchAusleihen(String titel, String personNamen);
    void buchZurueckgeben(String titel);
}
