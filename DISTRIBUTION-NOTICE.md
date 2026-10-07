# Bridge Designer 2016 distribution notice

This notice describes the modified build and the third-party components used
by `BridgeDesigner-2016-Universal.jar`. It is not legal advice and is not a
substitute for the license texts or corresponding source code.

## Main application license

The project website identifies Bridge Designer as distributed under GNU GPL
version 3. The application's bundled `bridgedesigner/resources/license.txt`
also names GPL version 3. The full license text is provided in
[`COPYING-GPL-3.0.txt`](./COPYING-GPL-3.0.txt). Existing source files retain
their original copyright and license headers.

The bundled `license.txt` additionally says commercial use is prohibited.
That statement conflicts with the GPLv3 terms. This build preserves the
original resource and does not purport to modify or interpret the rights
holder's license; the project website's GPLv3 statement is reflected here.
For a redistribution where the distinction matters, seek clarification from
the rights holder and retain this disclosure of the inconsistent legacy
resource.

## Changes in this build

- `src/bridgedesigner/BDApp.java`: added a startup dialog to enter a
  non-empty bridge-file key; the entered key is used for subsequent bridge
  reads and writes. Added Linux OS detection.
- `src/bridgedesigner/RC4Key.java`: added a replacement key provider with a
  local default and a runtime setter. This is not the omitted original key.
  Bridge files made with this replacement will not be compatible with files
  encrypted using the original key or another replacement key.
- `.gitignore`: removed the rule that excluded `src/bridgedesigner/RC4Key.java`.
- `pom.xml`: added a Maven build for a standalone shaded JAR, including
  Linux x86-64, Windows x86-64, and Intel macOS JOGL/GlueGen natives.
  Dependency signatures are excluded when shading because the combined JAR
  contents no longer match the original signatures.
- `DISTRIBUTION-NOTICE.md`, `COPYING-GPL-3.0.txt`,
  `COPYING-LGPL-2.1.txt`, and `README.md`: added setup, build, authorship/AI,
  licensing, and redistribution information.

`build.xml` and the original application's other source files were not changed
for this build.

## Bundled dependencies and notices

The shaded JAR contains these direct runtime dependencies:

| Component | Version | License information found |
|---|---:|---|
| BSAF (Swing Application Framework) | 1.9.2 | LGPL 2.1; its `COPYING` text is retained in the JAR and [`COPYING-LGPL-2.1.txt`](./COPYING-LGPL-2.1.txt) |
| Swing Worker | 1.1 | Its Maven metadata does not declare a license. Confirm the upstream license before redistributing. |
| NetBeans AbsoluteLayout | RELEASE113 | Apache License 2.0; the JAR's `META-INF/LICENSE` and `META-INF/NOTICE` are retained |
| Quaqua | 9.1 | Upstream Maven metadata lists LGPL 2.1 and Modified BSD; confirm which terms apply to the distributed portions and retain the upstream notices |
| JavaHelp API | 2.0.05 | GPL version 2 with the classpath exception, according to Maven metadata |
| JOGL | 2.3.2 | Upstream metadata lists BSD-2-Clause, BSD-3-Clause, SGI Free Software License B, Apache 2.0, Apache 1.1, and Ubuntu Font License 1.0 |
| GlueGen Runtime | 2.3.2 | Upstream metadata lists BSD-2-Clause, BSD-3-Clause, and BSD-4-Clause |

The JOGL, GlueGen, Quaqua, JavaHelp, and Swing Worker upstream license texts
and notices are not all embedded in the shaded JAR. Obtain and include the
applicable upstream texts and notices for each dependency when redistributing
the JAR. References:

- [BSAF](https://kenai.com/projects/bsaf)
- [Swing Worker](https://swingworker.dev.java.net/)
- [NetBeans AbsoluteLayout](https://netbeans.apache.org/)
- [Quaqua](https://bitbucket.org/devzendo/quaqua)
- [JavaHelp](https://javahelp.dev.java.net/)
- [JOGL](https://jogamp.org/jogl/www/)
- [GlueGen](https://jogamp.org/gluegen/www/)

## Source and build materials

When redistributing the JAR, also provide the corresponding preferred form for
modification: the complete `src/` and `help/` trees, build configuration,
README, and licensing files. `BridgeDesigner-2016-Source.tar.gz` is the
companion source archive for this build. Do not distribute only the JAR. The
archive refers to third-party libraries through Maven and does not contain
their source code.

Build with `mvn clean package`. The output is
`build/universal/BridgeDesigner-2016-Universal.jar`.

The JAR includes native code only for Linux x86-64, Windows x86-64, and Intel
macOS; it is not universal across CPU architectures or operating systems.
Users need a compatible Java runtime and platform graphics support.
