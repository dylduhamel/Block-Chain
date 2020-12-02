package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {
        int prefix = 4;   //we want our hash to start with four zeroes
        String prefixString = new String(new char[prefix]).replace('\0', '0');

        Transaction firstTransaction = new Transaction();
        Block genesisBlock = new Block(firstTransaction, "0", new Date().getTime());
        blockchain.add(genesisBlock);
        //genesisBlock.mineBlock(prefix);
        blockTextOutput(genesisBlock, 1);


    }

    public static void blockTextOutput(Block b, int index) {
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
        fileWriter.println(b.getData().getArtifact().toString());
        fileWriter.println(b.getData().getTimestamp());
        fileWriter.println(b.getData().getSeller().toString());
        fileWriter.println(b.getData().getBuyer().toString());
        fileWriter.println(b.getData().getAuctionHouse().toString());
        fileWriter.println(b.getData().getPrice());
        fileWriter.close();
    }
}

// FIXME Questions
// 1. LocalDataTime for transaction do we need to make a method? what should we store that data in
// 2. UTF_8?
// should I make nonce a random int when creating a block?