# Bridge Designer 2016 (2nd Edition)

This is a modified distribution of Bridge Designer 2016. See the original
source headers and [`DISTRIBUTION-NOTICE.md`](./DISTRIBUTION-NOTICE.md) for
licensing details.

## Run the prebuilt application

The standalone JAR is:

```text
build/universal/BridgeDesigner-2016-Universal.jar
```

Install a Java runtime, then run:

```sh
java -jar BridgeDesigner-2016-Universal.jar
```

The JAR includes its Java dependencies and native libraries; no separate
`lib/` directory is needed. You do not need Maven to run the prebuilt JAR.

This build bundles graphics natives for **64-bit x86 Linux**, **64-bit x86
Windows**, and **Intel macOS**. It is not a universal binary for all operating
systems or processor architectures. The application was compiled with Java 25 using Java 8
source/target compatibility; runtime compatibility can vary with the operating
system and Java version.

The JAR itself does not include a Java runtime. For a Windows installer that
does not require users to install Java, see [Build a Windows installer](#build-a-windows-installer).

## Build from source

Install a JDK (Java Development Kit) and Maven 3.x. Example install commands:

### Fedora

```sh
sudo dnf install java-25-openjdk-devel maven
```

### Debian or Ubuntu

```sh
sudo apt update
sudo apt install default-jdk maven
```

### Windows

Install a JDK and Maven, for example with [WinGet](https://learn.microsoft.com/windows/package-manager/winget/):

```powershell
winget install EclipseAdoptium.Temurin.17.JDK
winget install Apache.Maven
```

### macOS

With [Homebrew](https://brew.sh/):

```sh
brew install openjdk@17 maven
```

Check that both tools are available:

```sh
java -version
mvn -version
```

From the project directory, build the standalone JAR:

```sh
mvn clean package
```

Maven downloads the declared dependencies on the first build. The output is:

```text
build/universal/BridgeDesigner-2016-Universal.jar
```

### Build a Windows installer

The Windows installer is a separate, Windows-only build. It bundles a Java
runtime, so users do not need Java installed separately. Build it on a
64-bit Windows machine with:

- A JDK 17 or newer, with `jpackage` on `PATH`.
- Maven 3.x, with `mvn` on `PATH`.
- WiX Toolset 3.x, with `candle.exe` and `light.exe` on `PATH`.

In PowerShell, from the project directory, run:

```powershell
.\build-windows.ps1
```

The installer is created at:

```text
build\windows\output\BridgeDesigner-2016-2016.0.exe
```

`jpackage` creates native packages only for its host operating system, so this
Windows installer cannot be built from Linux or macOS. The universal JAR
remains available for those platforms, but requires a separately installed
Java runtime.

## Bridge-file key

At startup, enter a non-empty key. Use exactly the same key (including
capitalization) whenever you reopen bridge files created with it. The default
value is a local replacement, not the original Bridge Designer key. This
build cannot read original-key files unless you know and enter that original
key. Files written with this replacement-key build are not compatible with
the original application or with builds using a different key.

## What changed in this build

The original Bridge Designer program is distinct from the local build changes.
Changes in this distribution include:

- A startup dialog to choose the key used for bridge-file reads and writes.
- A replacement RC4 key provider; it does not recover or reproduce the
  original omitted key.
- Linux operating-system detection in the application.
- A Maven build that creates a single shaded JAR with Linux, Windows, and
  macOS graphics natives.
- Build and licensing documentation.

## AI and authorship disclosure

The person preparing this distribution states that they did not create the
original Bridge Designer program. The changes listed above in this working
copy were implemented with AI at the maintainer's request. The
maintainer states that they did not independently write these added code
changes. Original upstream authorship and copyright notices remain in the
source files. This disclosure does not transfer or alter any copyright or
license.

## License and redistribution

The project website identifies Bridge Designer as GPLv3; the full GPLv3 text
is in [`COPYING-GPL-3.0.txt`](./COPYING-GPL-3.0.txt). Some bundled third-party
components have their own licenses and notices; see
[`COPYING-LGPL-2.1.txt`](./COPYING-LGPL-2.1.txt) and
[`DISTRIBUTION-NOTICE.md`](./DISTRIBUTION-NOTICE.md) before redistributing.
The distribution notice also records the legacy commercial-use wording found
in the application's embedded license resource and third-party notices that
may need to accompany a redistribution.

When sharing the JAR, also provide the corresponding source archive,
`BridgeDesigner-2016-Source.tar.gz`, and the applicable license/notice files.
