# gods-and-glory-assistant

A little assistant for the game Gods &amp; Glory

## Installation

* Install [sdk](https://sdkman.io/install)
* Install [Java 17](https://sdkman.io/usage)
    * View a list of available versions

      ```
      sdk list java
      ```
    * Install `java`, e.g.

      ```
      sdk instal java 17.0.9-graalce
      ```
    * View the list of installed versions

      ```
      sdk list java | grep -E 'installed|local'
      ```
    * Select the default version of java, e.g.

      ```
      sdk default java 17.0.9-graalce
      ```
    * Select the version of java in the current terminal, e.g.

      ```
      sdk use java 17.0.9-graalce
      ```
    * View the current version of java

      ```
      sdk current java
      ```
* Install `sbt`

    ```
    sdk install sbt
    ```
* Install [brew](http://brew.sh)
* Install `Node.js` 20
    * Install `nvm`

      ```
      brew install nvm
      ```
    * View a list of available versions

      ```
      nvm ls-remote
      ```
    * Install `Node.js`, e.g.

      ```
      nvm install 20.12.2 
      ```
    * View the list of installed versions

      ```
      nvm ls
      ```
    * Select the default version of `Node.js`, e.g.

      ```
      nvm alias default 20.12.2
      ```
    * Select the `Node.js` version in the current terminal, e.g.

      ```
      nvm use 20.12.2 
      ```
    * View the current version of `Node.js`

      ```
      nvm current
      ```
* Install `Vite`

    ```
    brew install vite
    ```
* Install `Turbo`

    ```
    npm install turbo --global
    ```

* Install [IDE](https://www.jetbrains.com/idea/#chooseYourEdition)
* Clone repository
* Open repository in IDE

📔 If a build in IntelliJ IDE fails at
[java.io.IOException: Cannot run program "yarn"](https://github.com/ScalablyTyped/SlinkyDemos/issues/12),
then you need to close the IDE and then open it in the console using the `open -na "<Name of Intellij on your system>"`,
for example `open -na "IntelliJ IDEA.app"` or paste `open -na "Intel` into the console and press Tab.

## Prepare

Before doing anything, including before importing in an IDE, run
```
npm install
```

## Development

Open two terminals. In the first one, start sbt and, within, continuously build the Scala.js project:

```
sbt dev
```

In the second one, start the Vite (via Turbo) development server with

```
turbo dev
```

Follow the URL presented to you by Turbo to open the application.

## Production build

Make a production build with

```
turbo build
```

You can then find the built files in the `dist/` directory. 
