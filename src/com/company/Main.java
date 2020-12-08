package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<>(); // storing each block

    public static void main(String[] args) {
        int prefix = 4;   //we want our hash to start with four zeroes
        String prefixString = new String(new char[prefix]).replace('\0', '0');

        // first block
        BlockForum genesisForum = new BlockForum();
        // making node
        Block genesisBlock = new Block(genesisForum.getFillTrans(), "0", new Date().getTime());
        genesisBlock.mineBlock(prefix);
        writeBlock(genesisBlock, 1);
        if (verify_Blockchain(blockchain) ) {
            blockchain.add(genesisBlock);
        } else {
            System.out.println("Malicious block, not added to the chain");
        }

        // second block
        BlockForum secondForum = new BlockForum();
        // making node
        Block secondBlock = new Block(secondForum.getFillTrans(), genesisBlock.getHash(), new Date().getTime());
        secondBlock.mineBlock(prefix);
        writeBlock(secondBlock, 2);
        if (verify_Blockchain(blockchain) ) {
            blockchain.add(secondBlock);
        } else {
            System.out.println("Malicious block, not added to the chain");
        }

        // third block
        BlockForum thirdForum = new BlockForum();
        // making node
        Block thirdBlock = new Block(thirdForum.getFillTrans(), secondBlock.getHash(), new Date().getTime());
        thirdBlock.mineBlock(prefix);
        writeBlock(thirdBlock, 3);
        if (verify_Blockchain(blockchain) ) {
            blockchain.add(thirdBlock);
        } else {
            System.out.println("Malicious block, not added to the chain");
        }


        // method to print the entire blockchain and keep that info each time
        writeFullBlockchain(blockchain);
    }
    public static boolean verify_Blockchain(ArrayList<Block> BC) {
        // criteria for hash prefix
        int prefix = 4;   //we want our hash to start with four zeroes
        String prefixString = new String(new char[prefix]).replace('\0', '0');

        // blocks to be checked
        Block currBlock;
        Block prevBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currBlock = blockchain.get(i);
            prevBlock = blockchain.get(i - 1);

            if (!currBlock.getHash().equals(currBlock.calculateBlockHash()) || !prevBlock.getHash().equals(prevBlock.calculateBlockHash()) || !currBlock.getHash().substring(0, prefix).equals(prefixString)) {
                System.out.println("Inconsistent hashes");
                return false;
            }

        }
        return true;
    }


    public static void writeBlock(Block b, int index) {
        PrintWriter fileWriter;
        FileOutputStream myFile = null;

        // trying to open a file
        try {
            myFile = new FileOutputStream("Node_" + index + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // opening a new print writer
        fileWriter = new PrintWriter(myFile);

        // writing to file
        fileWriter.println("Node_" + index);
        fileWriter.println("\nArtifact Data");
        fileWriter.println("\t" + b.getData().getArtifact().toString());
        fileWriter.println("\nTime Stamp");
        fileWriter.println("\t" + b.getData().getTimestamp());
        fileWriter.println("\nArtifact Seller");
        fileWriter.println("\t" + b.getData().getSeller().toString());
        fileWriter.println("\nArtifact Buyer");
        fileWriter.println("\t" + b.getData().getBuyer().toString());
        fileWriter.println("\nArtifact Auction House");
        fileWriter.println("\t" + b.getData().getAuctionHouse().toString());
        fileWriter.println("\nTransaction Price");
        fileWriter.println("\t" + b.getData().getPrice());
        fileWriter.close();
    }

    public static void writeFullBlockchain(ArrayList<Block> blockchain) {
        PrintWriter fileWriter;
        FileOutputStream myFile = null;

        // trying to open a file
        try {
            myFile = new FileOutputStream("Blockchain", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // opening a new print writer
        fileWriter = new PrintWriter(myFile);

        // iterating through each block
        for (int i = 0; i < blockchain.size(); i++) {
            // writing to file
            fileWriter.println("Node_" + (i + 1));
            fileWriter.println("\nArtifact Data");
            fileWriter.println("\t" + blockchain.get(i).getData().getArtifact().toString());
            fileWriter.println("\nTime Stamp");
            fileWriter.println("\t" + blockchain.get(i).getData().getTimestamp());
            fileWriter.println("\nArtifact Seller");
            fileWriter.println("\t" + blockchain.get(i).getData().getSeller().toString());
            fileWriter.println("\nArtifact Buyer");
            fileWriter.println("\t" + blockchain.get(i).getData().getBuyer().toString());
            fileWriter.println("\nArtifact Auction House");
            fileWriter.println("\t" + blockchain.get(i).getData().getAuctionHouse().toString());
            fileWriter.println("\nTransaction Price");
            fileWriter.println("\t" + blockchain.get(i).getData().getPrice());
            fileWriter.println("\n\n");
        }
        fileWriter.close();
    }
}

// FIXME Questions
// 1. LocalDataTime for transaction do we need to make a method? what should we store that data in
// 2. UTF_8?
// should I make nonce a random int when creating a block?