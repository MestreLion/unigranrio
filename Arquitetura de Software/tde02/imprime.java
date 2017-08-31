/*
 * Imprime - Exibe as linhas de um arquivo texto eficientemente
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
import java.io.BufferedReader;
import java.io.IOException;

public class imprime
{
	public static void main(String[] args)
	{
		if(args.length != 1) {
			usage("");
			System.exit(1);
		}

		try {
			imprime(args[0]);
		}
		catch (IOException e) {
			usage("Não foi possível abrir o arquivo: " + e.getMessage());
		}
	}


	private static void usage(String msg)
	{
		System.err.println("Exibe as linhas de um arquivo texto");
		if(msg != "")
			System.err.println("ERRO: " + msg);
		System.err.println("Uso: `java imprime ARQUIVO`");
	}


	private static void imprime(String path) throws IOException
	{
		BufferedReader buf = new BufferedReader(new FileReader(path));
		for (String line; (line = buf.readLine()) != null;)
			System.out.println(line);
		buf.close();
	}
}
