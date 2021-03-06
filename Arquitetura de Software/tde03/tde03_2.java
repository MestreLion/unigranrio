/*
 * TDE03-2 - Encontra uma string num array de strings, e informa sua posição
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
import java.util.ArrayList;

public class tde03_2
{
	public static void main(String[] args)
	{
		String            path;      // Text file path
		String            line;      // Line being searched in text file
		ArrayList<String> lines;     // Text file lines as ArrayList
		int               position;  // Line position, -1 = not found

		if(args.length != 2) {
			usage();
			System.exit(1);
		}

		path = args[0];
		line = args[1];

		lines = readfile(path);
		position = searchline(lines, line);
		System.out.println(position);

		if (position < 0)
			System.exit(1);
	}


	private static void usage(String msg, Throwable e)
	{
		String err = "";
		String out = "";

		if (e != null)
			err = e.getMessage();

		if(notBlank(msg) && notBlank(err))
			out = String.format("%s: %s", msg, err);
		else
			out = String.format("%s%s", msg, err);

		System.err.println("TDE03-2: Encontra a linha de uma string em um arquivo texto");
		if(notBlank(out))
			System.err.println("ERRO: " + out);
		System.err.println("Uso: `java tde03_2 ARQUIVO STRING`");
	}
	private static void usage()            { usage("",  null); }
	private static void usage(String msg)  { usage(msg, null); }
	private static void usage(Throwable e) { usage("",  e); }


	private static boolean notBlank(String s)
	{
		return (s != null && s.length() == 0 && s.trim().length() == 0);
	}


	private static ArrayList<String> readfile(String path)
	{
		ArrayList<String> out = new ArrayList<String>();
		BufferedReader buf = null;
		try {
			buf = new BufferedReader(new FileReader(path));
			for (String line; (line = buf.readLine()) != null;)
				out.add(line);
		}
		catch (IOException e) {
			usage("Não foi possível ler o arquivo", e);
		}
		finally {
			if (buf != null)
				try { buf.close(); } catch (IOException e) {}
		}
		return out;
	}


	private static int searchline(ArrayList<String> lines, String search)
	{
		for(int i=0; i<lines.size(); i++)
			if (lines.get(i).equals(search))
				return i;

		return -1;
	}
}
