echo off
for /l %%a in (1,1,100) do (
curl -Hhost:hostnamej.example.com http://10.0.75.2:31380/version/
ECHO.
timeout /t 2 /nobreak > NUL
)
PAUSE