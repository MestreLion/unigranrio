/*
 * Raiz - Calcula a raiz quadrada de um número utilizando busca binária
 *
 *   Copyright (C) 2017 Rodrigo Silva (MestreLion) <linux@rodrigosilva.com>
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program. See <http://www.gnu.org/licenses/gpl.html>
 */

public class raiz
{
	public static void main(String[] args)
	{
		float num  = 0;

		if(args.length != 1) {
			usage("");
			return;
		}

		try {
			num = Float.parseFloat(args[0]);
		} catch (NumberFormatException e) {
			usage("'" + args[0] + "' não é um número válido");
			return;
		}

		double r2 = raiz(num);
		System.out.println(r2);
	}


	private static void usage(String msg)
	{
		System.err.println("Calcula a raiz quadrada de um número");
		if(msg != "")
			System.err.println("ERRO: " + msg);
		System.err.println("Uso: `java raiz NUMERO`");
	}


	public static double raiz(double num)
	{
		double prec = 0.000000000001;  // Precision, 10^(-12)
		int    max  = 1000;            // Max iterations

		double  high = num;  // upper bound
		double  low  = 0;    // lower bound
		int     i    = 0;    // iterations
		double  root = 0;    // current root guess
		boolean inv  = false;
		double  sq   = 0;
		double  old  = -1;

		if (num < 0)
			return Double.NaN;

		if (num == 0 || num == 1)
			return num;

		// Handle num < 1 by inverting it and its calculated root
		if (num < 1) {
			inv = true;
			num = 1 / num;
			high = num;
		}

		while ( (old != root) &&        // Avoid repetitions
			(sq != num) &&          // Detect exact matches
			(high - low > prec) &&  // Resolution limit check
			(i++ < max) )           // Avoid infinite loops
		{
			old  = root;
			root = (high + low) / 2;
			sq   = root * root;

			if (sq > num)
				high = root;
			else
				low  = root;
		}

		if (i >= max)
			System.err.println("WARNING: Max iterations!");

		if (inv)
			root = 1 / root;

		return root;
	}
}
