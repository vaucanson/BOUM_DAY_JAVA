package tool;

abstract public class CommonTools
{
	/**
	 * Détermine si une chaîne est composée uniquement de lettres minuscules
	 * 
	 * @param str
	 *            une chaîne
	 * @return vrai si la chaîne n'est composée que de lettres minuscules, faux
	 *         sinon
	 */
	public static boolean isAlphabetical(String str)
	{
		// pattern correspondant à uniquement des lettres unicodes minuscules
		String pattern = "^\\p{Ll}*$";
		return str != null && str.matches(pattern);
	}

	/**
	 * Détermine si la chaîne donnée est un entier
	 * 
	 * @param str
	 *            une chaîne
	 * @return vrai si la chaîne est composée uniquement de chiffres arabes,
	 *         faux sinon
	 */
	public static boolean isInteger(String str)
	{
		// pattern correspondant à uniquement des chiffres
		String pattern = "^\\d+$";
		return str != null && str.matches(pattern);
	}

	/**
	 * Détermine si la chaîne donnée est un float
	 * 
	 * @param str
	 *            une chaîne
	 * @return vrai si la chaîne est composée de chiffres avec optionnellement
	 *         un point ou une virgule dedans
	 */
	public static boolean isFloat(String str)
	{
		// des chiffres, puis optionnellement un point ou une virgule et encore
		// des chiffres
		String pattern = "^\\d+([.,]\\d+)?$";
		return str != null && str.matches(pattern);
	}

}
