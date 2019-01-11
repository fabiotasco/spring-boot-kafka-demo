
package io.fab.connector.utils;

public class JsonUtils {

	/**
	 * Altera o nome do enumerador do formato {@code ONE_ENUM} para {@code One Enum}.
	 *
	 * @param name Nome do enumerador.
	 * @return O nome formatado.
	 */
	public static String formatEnumName(final String name) {
		if (name == null || name.isEmpty()) {
			return name;
		}
		final String[] split = name.split("_");

		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			if (i > 0) {
				sb.append(' ');
			}
			sb.append(split[i].substring(0, 1).toUpperCase());
			sb.append(split[i].substring(1, split[i].length()).toLowerCase());
		}
		return sb.toString();
	}

}
