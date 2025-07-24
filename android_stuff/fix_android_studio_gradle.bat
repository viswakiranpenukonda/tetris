@echo off
echo ========================================
echo Fixing Android Studio Gradle Issues
echo ========================================
echo.

REM Check if running as administrator
net session >nul 2>&1
if %errorLevel% == 0 (
    echo Running as Administrator - Good!
) else (
    echo WARNING: Not running as Administrator
    echo Please run this script as Administrator for best results
    echo.
)

echo Creating alternative Gradle home directories...

REM Create alternative Gradle home in C: drive
if not exist "C:\gradle-home" (
    mkdir "C:\gradle-home"
    echo Created: C:\gradle-home
)

if not exist "C:\gradle-home\wrapper" (
    mkdir "C:\gradle-home\wrapper"
    echo Created: C:\gradle-home\wrapper
)

if not exist "C:\gradle-home\wrapper\dists" (
    mkdir "C:\gradle-home\wrapper\dists"
    echo Created: C:\gradle-home\wrapper\dists
)

REM Set permissions
echo Setting permissions...
icacls "C:\gradle-home" /grant "%USERNAME%":(OI)(CI)F /T >nul 2>&1

REM Also try to fix the original directory
echo Fixing original Gradle directory...
if not exist "%USERPROFILE%\.gradle" mkdir "%USERPROFILE%\.gradle"
if not exist "%USERPROFILE%\.gradle\wrapper" mkdir "%USERPROFILE%\.gradle\wrapper"
if not exist "%USERPROFILE%\.gradle\wrapper\dists" mkdir "%USERPROFILE%\.gradle\wrapper\dists"

REM Clean any lock files
echo Cleaning lock files...
del /q "%USERPROFILE%\.gradle\wrapper\dists\*.lck" 2>nul
del /q "C:\gradle-home\wrapper\dists\*.lck" 2>nul

echo.
echo ========================================
echo Fix completed!
echo ========================================
echo.
echo Now in Android Studio:
echo 1. Go to File → Settings → Build, Execution, Deployment → Gradle
echo 2. Set "Gradle user home" to: C:\gradle-home
echo 3. Click Apply and OK
echo 4. Restart Android Studio
echo.
echo Alternative: Run Android Studio as Administrator
echo.
pause 