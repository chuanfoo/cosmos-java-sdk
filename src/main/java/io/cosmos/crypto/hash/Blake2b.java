package io.cosmos.crypto.hash;

import org.bouncycastle.crypto.digests.Blake2bDigest;


public class Blake2b {

    public static byte[] blake2b160(byte[]... args) {
        Blake2bDigest digest = new Blake2bDigest(160);
        for (byte[] bytes : args) {
            digest.update(bytes, 0, bytes.length);
        }
        byte[] out = new byte[160 / 8];
        digest.doFinal(out, 0);
        return out;
    }

    public static byte[] blake2b256(byte[]... args) {
        Blake2bDigest digest = new Blake2bDigest(256);
        for (byte[] bytes : args) {
            digest.update(bytes, 0, bytes.length);
        }
        byte[] out = new byte[256 / 8];
        digest.doFinal(out, 0);
        return out;
    }

    public static byte[] blake2b384(byte[]... args) {
        Blake2bDigest digest = new Blake2bDigest(384);
        for (byte[] bytes : args) {
            digest.update(bytes, 0, bytes.length);
        }
        byte[] out = new byte[384 / 8];
        digest.doFinal(out, 0);
        return out;
    }

    public static byte[] blake2b512(byte[]... args) {
        Blake2bDigest digest = new Blake2bDigest(512);
        for (byte[] bytes : args) {
            digest.update(bytes, 0, bytes.length);
        }
        byte[] out = new byte[512 / 8];
        digest.doFinal(out, 0);
        return out;
    }

}
