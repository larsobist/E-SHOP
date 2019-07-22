package domain.exceptions;

/**
 * @author Lars Obist, Yuliya Litvin, Thao Phoung Nguyen
 */

@SuppressWarnings("serial")
public class StueckzahlException extends Exception{
	
	public StueckzahlException(int anzahl, int stueck) {
		super("Die angegebene St�ckzahl "+stueck+" ist h�her als der verf�gbare Bestand von "+ anzahl + ".\n");
	}
}
