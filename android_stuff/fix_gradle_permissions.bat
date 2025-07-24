@echo off
echo ========================================
echo Fixing Gradle Permission Issues
echo ========================================
echo.

REM Check if running as administrator
net session >nul 2>&1
if %errorLevel% == 0 (
    echo Running as Administrator - Good!
) else (
    echo WARNING: Not running as Administrator
    echo Please run this script as Administrator for best results
    echo Right-click on this file and select "Run as administrator"
    echo.
)

echo Current user: %USERNAME%
echo Gradle home: %USERPROFILE%\.gradle
echo.

REM Create Gradle directories with proper permissions
echo Creating Gradle directories...
if not exist "%USERPROFILE%\.gradle" (
    mkdir "%USERPROFILE%\.gradle"
    echo Created: %USERPROFILE%\.gradle
)

if not exist "%USERPROFILE%\.gradle\wrapper" (
    mkdir "%USERPROFILE%\.gradle\wrapper"
    echo Created: %USERPROFILE%\.gradle\wrapper
)

if not exist "%USERPROFILE%\.gradle\wrapper\dists" (
    mkdir "%USERPROFILE%\.gradle\wrapper\dists"
    echo Created: %USERPROFILE%\.gradle\wrapper\dists
)

REM Clean any existing lock files
echo Cleaning existing lock files...
del /q "%USERPROFILE%\.gradle\wrapper\dists\*.lck" 2>nul
del /q "%USERPROFILE%\.gradle\wrapper\dists\*\*.lck" 2>nul
del /q "%USERPROFILE%\.gradle\wrapper\dists\*\*\*.lck" 2>nul

REM Set proper permissions on Gradle directories
echo Setting permissions...
icacls "%USERPROFILE%\.gradle" /grant "%USERNAME%":(OI)(CI)F /T >nul 2>&1
icacls "%USERPROFILE%\.gradle\wrapper" /grant "%USERNAME%":(OI)(CI)F /T >nul 2>&1
icacls "%USERPROFILE%\.gradle\wrapper\dists" /grant "%USERNAME%":(OI)(CI)F /T >nul 2>&1

echo.
echo ========================================
echo Permission fix completed!
echo ========================================
echo.
echo Now try building the project again:
echo 1. Run: .\gradlew.bat assembleDebug
echo 2. Or use: .\build_with_admin.bat
echo.
echo If you still have issues, try:
echo 1. Running as Administrator
echo 2. Using Android Studio instead
echo 3. Changing Gradle home directory
echo.
pause 