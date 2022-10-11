```shell
--add-opens java.base/java.lang=ALL-UNNAMED
--add-opens java.base/java.math=ALL-UNNAMED
--add-opens java.base/sun.net.util=ALL-UNNAMED
```

```shell

# windows set java8 environment, via environment variable or absolute path
set JAVA_HOME=%JAVA8_HOME%
set JAVA_HOME=E:\java\jdk\corretto-1.8.0_342
set PATH=%JAVA_HOME%\bin;%PATH%

# linux or mac set java8 environment, via environment variable or absolute path
JAVA_HOME=$JAVA8_HOME
JAVA_HOME=/e/java/jdk/corretto-1.8.0_342
PATH="$JAVA_HOME/bin:$PATH"

```