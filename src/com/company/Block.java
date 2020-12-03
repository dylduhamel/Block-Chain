package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

        ArrayList<Transaction> treatyTrans = retrieveProvenance(t.getArtifact().getArtifactID(), 2001);

        // certification for blockchain <=2
        if (Main.blockchain.size() <= 2) {
            return true;
        }

        if (treatyTrans.size() <= 2) {
            return false;
        } else if (t.getBuyer().getHolderBalance() < t.getPrice()){
            return false;
        } else {
            t.getAuctionHouse().setHolderBalance(t.getAuctionHouse().getHolderBalance() + t.getPrice() * 0.10);
            t.getArtifact().getArtifactCountry().setHolderBalance(t.getArtifact().getArtifactCountry().getHolderBalance() + t.getPrice() * 0.2);
            t.getSeller().setHolderBalance(t.getSeller().getHolderBalance() + t.getPrice() * 0.7);
            return true;
        }
    }

    public ArrayList<Transaction> retrieveProvenance(String id) {
        ArrayList<Transaction> blockTran = new ArrayList<>();

        if (Main.blockchain.size() != 0) {
            for (int i = 0; i < Main.blockchain.size(); i++) {
                if (Main.blockchain.get(i).getData().getArtifact().getArtifactID().equals(id)) {
                    blockTran.add(Main.blockchain.get(i).getData());
                }
            }
        }
        return blockTran;
    }
    public ArrayList<Transaction> retrieveProvenance(String id, int timeStamp) {
        ArrayList<Transaction> blockTran = new ArrayList<>();
        if (Main.blockchain.size() != 0) {
            for (int i = 0; i < Main.blockchain.size(); i++) {
                if (Main.blockchain.get(i).getData().getArtifact().getArtifactID().equals(id) && Main.blockchain.get(i).getData().getTimestamp() > timeStamp) {
                    blockTran.add(Main.blockchain.get(i).getData());
                }
            }
        }
        return blockTran;
    }

    public String mineBlock(int prefix) {
        if (TreatySC(this.getData())) {
            String prefixString = new String(new char[prefix]).replace('\0', '0'); // creating the difficulty of the hash to be mined

            while (!hash.substring(0, prefix).equals(prefixString)) { // brute force to crack the hash
                nonce++;
                hash = calculateBlockHash();
            }
            return hash;
        } else {
            System.out.println("Transaction does not meet the stakeholders agreement");
            return "Transaction does not meet the stakeholders agreement";
        }
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

    public void setTimestamp(int timestamp) {
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
