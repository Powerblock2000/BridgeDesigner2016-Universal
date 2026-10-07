/*
 * Local replacement for the omitted Bridge Designer RC4 key.
 * Bridge files written with this key are not compatible with the original app.
 *
 * This file is distributed under the GNU General Public License, version 3.
 * See COPYING-GPL-3.0.txt in the project root.
 */
// SPDX-License-Identifier: GPL-3.0-only
package bridgedesigner;

import java.nio.charset.StandardCharsets;

public final class RC4Key {

    private static final String DEFAULT_KEY = "BridgeDesigner-2016-local-key";
    private static volatile byte[] scrambleKey = DEFAULT_KEY.getBytes(StandardCharsets.UTF_8);

    private RC4Key() {
    }

    public static String getDefaultKey() {
        return DEFAULT_KEY;
    }

    public static void setScrambleKey(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("The bridge-file key must not be empty.");
        }
        scrambleKey = key.getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] getScrambleKey() {
        return scrambleKey.clone();
    }
}
