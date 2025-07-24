@echo off
echo ========================================
echo Android Tetris Game - Build Script
echo ========================================
echo.

REM Check if running as administrator
net session >nul 2>&1
if %errorLevel% == 0 (
    echo Running as Administrator - Good!
) else (
    echo Warning: Not running as Administrator
    echo This might cause permission issues with Gradle
    echo.
)

REM Set environment variables if not already set
if "%JAVA_HOME%"=="" (
    echo JAVA_HOME not set. Please install Java 8+ and set JAVA_HOME
    echo Download from: https://adoptium.net/
    pause
    exit /b 1
)

if "%ANDROID_HOME%"=="" (
    echo ANDROID_HOME not set. Please install Android SDK and set ANDROID_HOME
    echo Download Android Studio from: https://developer.android.com/studio
    pause
    exit /b 1
)

echo Environment Check:
echo - JAVA_HOME: %JAVA_HOME%
echo - ANDROID_HOME: %ANDROID_HOME%
echo.

REM Try to create Gradle directories with proper permissions
echo Creating Gradle directories...
if not exist "%USERPROFILE%\.gradle" mkdir "%USERPROFILE%\.gradle"
if not exist "%USERPROFILE%\.gradle\wrapper" mkdir "%USERPROFILE%\.gradle\wrapper"
if not exist "%USERPROFILE%\.gradle\wrapper\dists" mkdir "%USERPROFILE%\.gradle\wrapper\dists"

REM Try to clean any existing lock files
echo Cleaning any existing lock files...
del /q "%USERPROFILE%\.gradle\wrapper\dists\*.lck" 2>nul

echo.
echo Attempting to build APK...
echo.

REM Try the build
call gradlew.bat assembleDebug

if %ERRORLEVEL% equ 0 (
    echo.
    echo ========================================
    echo BUILD SUCCESSFUL!
    echo ========================================
    echo.
    echo APK location: app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo You can now install this APK on your Android device.
    echo Make sure to enable "Unknown Sources" in your device settings.
    echo.
) else (
    echo.
    echo ========================================
    echo BUILD FAILED!
    echo ========================================
    echo.
    echo Error code: %ERRORLEVEL%
    echo.
    echo Troubleshooting tips:
    echo 1. Try running this script as Administrator (Right-click -^> Run as Administrator)
    echo 2. Make sure Java 8+ is installed and JAVA_HOME is set
    echo 3. Make sure Android SDK is installed and ANDROID_HOME is set
    echo 4. Try using Android Studio instead for easier building
    echo 5. Check that all project files are present
    echo.
)

pause 