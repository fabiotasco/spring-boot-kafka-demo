
package io.fab.connector.utils;

public class CurrencyUtils {

	private CurrencyUtils() {}

	/**
	 * Converte um valor decimal em inteiro, preservando 2 casas decimais.
	 *
	 * @param amount Valor decimal.
	 * @return Valor inteiro representando o decimal. Ex: 250,99 => 25099
	 */
	public static Long toLong(final Double amount) {
		return (long) (amount.doubleValue() * 100);
	}

}
