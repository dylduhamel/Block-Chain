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
        userFillTransaction(firstTransaction);
        Block genesisBlock = new Block(firstTransaction, "0", new Date().getTime());
        blockchain.add(genesisBlock);
        //genesisBlock.mineBlock(prefix);
        blockTextOutput(genesisBlock, 1);


    }
    public static void userFillTransaction(Transaction t) {

        // setting artifact
        t.getArtifact().setArtifactID("58367561");
        t.getArtifact().setArtifactName("Mona Lisa");

        // setting country of artifact
        t.getArtifact().getArtifactCountry().setIdNumber("19583");
        t.getArtifact().getArtifactCountry().setHolderName("America");
        t.getArtifact().getArtifactCountry().setHolderAddress("North America");
        t.getArtifact().getArtifactCountry().setHolderBalance(500000);

        // setting currOwner of artifact
        t.getArtifact().getCurrOwner().setIdNumber("23894");
        t.getArtifact().getCurrOwner().setHolderName("Dylan Duhamel");
        t.getArtifact().getCurrOwner().setHolderAddress("4518 35th St North");
        t.getArtifact().getCurrOwner().setHolderBalance(6786);


        // setting time
        t.setTimestamp(LocalDateTime.now());


        // setting stakeholder seller
        t.getSeller().setIdNumber("17893257");
        t.getSeller().setHolderName("Matt Zamp");
        t.getSeller().setHolderAddress("1220 Kress Dr");
        t.getSeller().setHolderBalance(56321);


        // setting stakeholder buyer
        t.getBuyer().setIdNumber("89012365");
        t.getBuyer().setHolderName("Nick Barsanti");
        t.getBuyer().setHolderAddress("1573 North Pelham St");
        t.getBuyer().setHolderBalance(3421);


        // setting stakeholder auctionHouse
        t.getAuctionHouse().setIdNumber("45671204");
        t.getAuctionHouse().setHolderName("Media Sellers");
        t.getAuctionHouse().setHolderAddress("567 West 45th St");
        t.getAuctionHouse().setHolderBalance(678231);


        // setting transaction price
        t.setPrice(3423);

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