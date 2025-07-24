@echo off
echo Building Android Tetris Game APK...
echo.

REM Check if gradlew.bat exists
if not exist "gradlew.bat" (
    echo Error: gradlew.bat not found. Please run this script from the project root directory.
    pause
    exit /b 1
)

REM Clean previous builds
echo Cleaning previous builds...
call gradlew.bat clean

REM Build debug APK
echo Building debug APK...
call gradlew.bat assembleDebug

REM Check if build was successful
if %ERRORLEVEL% equ 0 (
    echo.
    echo Build successful!
    echo APK location: app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo You can now install this APK on your Android device.
    echo Make sure to enable "Unknown Sources" in your device settings.
) else (
    echo.
    echo Build failed! Please check the error messages above.
)

pause 