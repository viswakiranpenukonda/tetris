@echo off
echo ========================================
echo Setting up Custom Gradle Home Directory
echo ========================================
echo.

REM Create a custom Gradle home directory in the project folder
set CUSTOM_GRADLE_HOME=%CD%\gradle-home
echo Setting custom Gradle home: %CUSTOM_GRADLE_HOME%

REM Create the directory
if not exist "%CUSTOM_GRADLE_HOME%" (
    mkdir "%CUSTOM_GRADLE_HOME%"
    echo Created custom Gradle home directory
)

REM Set the environment variable for this session
set GRADLE_USER_HOME=%CUSTOM_GRADLE_HOME%
echo Set GRADLE_USER_HOME=%CUSTOM_GRADLE_HOME%

REM Create necessary subdirectories
if not exist "%CUSTOM_GRADLE_HOME%\wrapper" mkdir "%CUSTOM_GRADLE_HOME%\wrapper"
if not exist "%CUSTOM_GRADLE_HOME%\wrapper\dists" mkdir "%CUSTOM_GRADLE_HOME%\wrapper\dists"

echo.
echo ========================================
echo Custom Gradle setup completed!
echo ========================================
echo.
echo Now try building with:
echo .\gradlew.bat assembleDebug
echo.
echo The Gradle files will be stored in: %CUSTOM_GRADLE_HOME%
echo This avoids permission issues with the user profile directory.
echo.
pause 