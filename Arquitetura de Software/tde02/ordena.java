/*
 * Ordena - Exibe as linhas de um arquivo texto ordenadas alfabeticamente
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

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ordena
{
	public static void main(String[] args)
	{
		FileReader file;
		String line;

		if(args.length != 1) {
			usage("");
			return;
		}

		try {
			file = new FileReader(args[0]);
		} catch (IOException e) {
			usage(e.getMessage());
			return;
		}


		try {
			BufferedReader buf = new BufferedReader(file);
			while ((line = buf.readLine()) != null)
				System.out.println(line);
			buf.close();
			file.close();
		} catch (IOException e) {
			System.err.println("ERRO: " + e.getMessage() + ": " + e);
		}
	}


	private static void usage(String msg)
	{
		System.err.println("Exibe as linhas de um arquivo texto ordenadas alfabeticamente");
		if(msg != "")
			System.err.println("ERRO: " + msg);
		System.err.println("Uso: `java ordena ARQUIVO`");
	}
}
