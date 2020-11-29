package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;

public class Block {
    private String previousHash;
    private Transaction data;
    private long timeStamp;
    private int nonce;
    private String hash;

    // FIXME add more specific constructors for the data class
    public Block(Transaction data, String previousHash, long timeStamp) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
    }

    public boolean TreatySC(Transaction t) {

    }

    public int retrieveProvenance(String id) {
        if (data.getArtifact().getArtifactID().equals(id)) {

        }
    }

    public String mineBlock(int prefix) {
        // add the Treaty method

        String prefixString = new String(new char[prefix]).replace('\0', '0'); // creating the difficulty of the hash to be mined

        while (!hash.substring(0, prefix).equals(prefixString)) { // brute force to crack the hash
            nonce++;
            hash = calculateBlockHash();
        }
        return hash;
    }

    public String calculateBlockHash() {
        String dataToHash = previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + data;
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            System.out.println("The encoding is not supported");
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timeStamp;
    }

    public void setTimestamp(long timestamp) {
        this.timeStamp = timestamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
