@echo off
echo Setting up Android Tetris Game build environment...

REM Set JAVA_HOME if not already set
if "%JAVA_HOME%"=="" (
    echo JAVA_HOME not set. Please install Java 8 or higher and set JAVA_HOME.
    echo You can download OpenJDK from: https://adoptium.net/
    pause
    exit /b 1
)

REM Set ANDROID_HOME if not already set
if "%ANDROID_HOME%"=="" (
    echo ANDROID_HOME not set. Please install Android SDK and set ANDROID_HOME.
    echo You can download Android Studio from: https://developer.android.com/studio
    pause
    exit /b 1
)

echo Using Java: %JAVA_HOME%
echo Using Android SDK: %ANDROID_HOME%

REM Try to build with gradlew
echo Building APK...
call gradlew.bat assembleDebug

if %ERRORLEVEL% equ 0 (
    echo.
    echo Build successful!
    echo APK location: app\build\outputs\apk\debug\app-debug.apk
) else (
    echo.
    echo Build failed with error code: %ERRORLEVEL%
    echo.
    echo Troubleshooting tips:
    echo 1. Make sure Java 8+ is installed and JAVA_HOME is set
    echo 2. Make sure Android SDK is installed and ANDROID_HOME is set
    echo 3. Try running this script as Administrator
    echo 4. Check that all project files are present
)

pause 