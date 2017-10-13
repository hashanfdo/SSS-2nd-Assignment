/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sss2nd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author Hashan
 */
public class keygen {

    private KeyPairGenerator keyGen;
    private KeyPair pair;
    private PrivateKey prKey;
    private PublicKey puKey;

    public keygen(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(keylength);
    }

    public void ckey() {
        this.pair = this.keyGen.generateKeyPair();
        this.prKey = pair.getPrivate();
        this.puKey = pair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return this.prKey;
    }

    public PublicKey getPublicKey() {
        return this.puKey;
    }

    public void writeToFile(String path, byte[] key) throws IOException {
        File g = new File(path);
        g.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(g);
        fos.write(key);
        fos.flush();
        fos.close();
    }

}
