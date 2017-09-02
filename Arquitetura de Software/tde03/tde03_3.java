/*
 * TDE03-3 - Exibe os 20 primeiros números da seuência de Fibonacci
 *
 * Copyright (C) 2017 Rodrigo Silva (MestreLion) <linux@rodrigosilva.com>
 * License: GPLv3 or later, at your choice. See <http://www.gnu.org/licenses/gpl>
 */

public class tde03_3
{
	public static void main(String[] args)
	{
		int a1 = 0;
		int a2 = 1;
		int a3;

		System.out.printf("%4d\n", a1);
		System.out.printf("%4d\n", a2);

		for(int i = 3; i <= 20; i++) {
			a3 = a1 + a2;
			System.out.printf("%4d\n", a3);
			a1 = a2;
			a2 = a3;
		}
	}
}
