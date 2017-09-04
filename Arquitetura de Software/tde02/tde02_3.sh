#!/bin/bash -ue
#
# imprime - wrapper to run a java class, recompiling it if needed
#
#    Copyright (C) 2017 Rodrigo Silva (MestreLion) <linux@rodrigosilva.com>
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program. See <http://www.gnu.org/licenses/gpl.html>
#
# Installs 'default-jdk' if needed and recompiles the class from source if
# either source is newer or class does not exist. Then runs the class from
# its directory passing all argumments.

exists() { type "${1:-}" >/dev/null 2>&1; }
mtime()  { date +%s -r "${1:-}" 2>/dev/null || echo 0; }
fatal()  { [[ "${1:-}" ]] && echo "$myname: error: $@" >&2; exit 1; }
msg()    { [[ "${1:-}" ]] && echo "$myname: $@" >&2; }


myname="${0##*/}"
mydir=$(dirname "$(readlink -f "$0")")

cls=${myname%.*}
src=$mydir/$cls.java
obj=$mydir/$cls.class


if ! exists java || ! exists javac; then
	msg "Installing Java JDK"
	sudo apt-get install default-jdk || fatal "java is required"
fi

if (( $(mtime "$obj") <= $(mtime "$src") )); then
	msg "Recompiling source"
	javac "$src" || fatal
fi

cd "$mydir" &&
java "$cls" "$@"
