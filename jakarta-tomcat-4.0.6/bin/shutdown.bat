@echo off
if "%OS%" == "Windows_NT" setlocal
rem ---------------------------------------------------------------------------
rem Stop script for the CATALINA Server
rem
rem $Id: shutdown.bat,v 1.4.4.2 2002/01/30 18:10:40 patrickl Exp $
rem ---------------------------------------------------------------------------

rem Guess CATALINA_HOME if not defined
if not "%CATALINA_HOME%" == "" goto gotHome
set CATALINA_HOME=.
if exist "%CATALINA_HOME%\bin\catalina.bat" goto okHome
set CATALINA_HOME=..
:gotHome
if exist "%CATALINA_HOME%\bin\catalina.bat" goto okHome
echo The CATALINA_HOME environment variable is not defined correctly
echo This environment variable is needed to run this program
goto end
:okHome

set EXECUTABLE=%CATALINA_HOME%\bin\catalina.bat

rem Check that target executable exists
if exist "%EXECUTABLE%" goto okExec
echo Cannot find %EXECUTABLE%
echo This file is needed to run this program
goto end
:okExec

rem Get remaining unshifted command line arguments and save them in the
set CMD_LINE_ARGS=
:setArgs
if ""%1""=="""" goto doneSetArgs
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto setArgs
:doneSetArgs

call "%EXECUTABLE%" stop %CMD_LINE_ARGS%

:end
