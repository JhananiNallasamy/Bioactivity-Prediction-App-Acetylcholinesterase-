@echo off
set filename=molecule.smi
set count=0
for /f %%a in ('type %filename% ^| find /c /v ""') do set /a count=%%a
echo %count%
