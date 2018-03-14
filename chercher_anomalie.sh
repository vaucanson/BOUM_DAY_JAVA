#!/usr/bin/bash
printf "SUPPRESSION DES FICHIERS INDÉSIRÉS :\n"
rm -i src/*/*orig
rm -i src/*/*bak
rm -i src/*/*/*orig
rm -i src/*/*/*bak
rm -i src/*/*/*/*orig
rm -i src/*/*/*/*bak
rm -i src/*/*/*/*/*bak
rm -i src/*/*/*/*/*orig

printf "\nRECHERCHE DE FICHIERS CONTENANT DES ANOMALIES :\n"
grep "<<" src/*/* 2>/dev/null
grep "<<" src/*/*/* 2>/dev/null
grep "<<" src/*/*/*/* 2>/dev/null
grep "<<" src/*/*/*/*/* 2>/dev/null
