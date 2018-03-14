#!/usr/bin/bash
rm src/*/*orig
rm src/*/*bak
rm src/*/*/*orig
rm src/*/*/*bak
rm src/*/*/*/*orig
rm src/*/*/*/*bak

grep "<<" src/*/* 2>/dev/null
grep "<<" src/*/*/* 2>/dev/null
grep "<<" src/*/*/*/* 2>/dev/null
