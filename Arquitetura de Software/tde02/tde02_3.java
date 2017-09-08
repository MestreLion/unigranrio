/*
 * TDE02-3 - Exibe em ordem alfabética as linhas de um arquivo texto
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

package tde02;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class tde02_3
{
	public static void main(String[] args)
	{
		ArrayList<String> lines;     // Text file lines as ArrayList

		if(args.length != 1) {
			usage();
			System.exit(1);
		}

		lines = readfile(args[0]);
		sortlines(lines);
		printlines(lines);
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

		System.err.println("TDE02-3: Ordena as linhas de um texto");
		if(notBlank(out))
			System.err.println("ERRO: " + out);
		System.err.println("Uso: `cd .. && java tde02.tde02_3 ARQUIVO`");
	}
	private static void usage()            { usage("",  null); }
	private static void usage(String msg)  { usage(msg, null); }
	private static void usage(Throwable e) { usage("",  e); }


	private static boolean notBlank(String s)
	{
		return (s != null && s.length() == 0 && s.trim().length() == 0);
	}


	public static ArrayList<String> readfile(String path)
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


	public static void sortlines(ArrayList<String> lines)
	{
		String aux;
		boolean swap;
		for (int i = 0; i < lines.size() - 1; i++) {
			swap = false;
			for (int j = 0; j < lines.size() - 1 - i; j++)
				if (lines.get(j).compareTo(lines.get(j + 1)) > 0) {
					aux = lines.get(j);
					lines.set(j, lines.get(j + 1));
					lines.set(j + 1, aux);
					swap = true;
				}
			if(!swap)
				break;
		}
	}


	public static void printlines(ArrayList<String> lines)
	{
		for(String line: lines)
			System.out.println(line);
	}
}
