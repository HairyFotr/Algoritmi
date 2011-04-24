@echo off
del *.bak
for %%a in (*.eps) do @(
	ren %%a %%a.bak
	gswin32c -sDEVICE=epswrite -r72 -sOutputFile=%%a -dNOPAUSE -dEPSCrop %%a.bak -c quit
	if not exist %%a ren %%a.bak %%a
)
pause