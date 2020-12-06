package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
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
        //userFillTransaction(firstTransaction);

        Block genesisBlock = new Block(genesisForum.getFillTrans(), "0", new Date().getTime());
        genesisBlock.mineBlock(prefix);
        blockTextOutput(genesisBlock, 1);
        if (verify_Blockchain(blockchain) ) {
            blockchain.add(genesisBlock);
        } else {
            System.out.println("Malicious block, not added to the chain");
        }

        // second block
        Transaction secondTransaction = new Transaction();




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


    public static void userFillTransaction(Transaction t) {

        // making an artifact
        Artifact userArt = new Artifact();
        userArt.setArtifactID("58367561");
        userArt.setArtifactName("Mona Lisa");

        // setting country of artifact
        Stakeholder country = new Stakeholder();
        country.setIdNumber("19583");
        country.setHolderName("America");
        country.setHolderAddress("North America");
        country.setHolderBalance(500000);

        // setting currOwner of artifact
        Stakeholder currOwner = new Stakeholder();
        currOwner.setIdNumber("23894");
        currOwner.setHolderName("Dylan Duhamel");
        currOwner.setHolderAddress("4518 35th St North");
        currOwner.setHolderBalance(6786);

        // adding country and currOwner to artifact
        userArt.setArtifactCountry(country);
        userArt.setCurrOwner(currOwner);

        // ADDING ARTIFACT TO TRANSACTION
        t.setArtifact(userArt);

        // setting time
        t.setTimestamp(2018);


        // making a new seller
        Stakeholder userSeller = new Stakeholder();
        userSeller.setIdNumber("17893257");
        userSeller.setHolderName("Matt Zamp");
        userSeller.setHolderAddress("1220 Kress Dr");
        userSeller.setHolderBalance(56321);

        // ADDING SELLER TO TRANSACTION
        t.setSeller(userSeller);


        // making a new buyer
        Stakeholder userBuyer = new Stakeholder();
        userBuyer.setIdNumber("89012365");
        userBuyer.setHolderName("Nick Barsanti");
        userBuyer.setHolderAddress("1573 North Pelham St");
        userBuyer.setHolderBalance(3421);

        // ADDING BUYER TO TRANSACTION
        t.setBuyer(userBuyer);


        // making a new auctionHouse
        Stakeholder userAuction = new Stakeholder();
        userAuction.setIdNumber("45671204");
        userAuction.setHolderName("Media Sellers");
        userAuction.setHolderAddress("567 West 45th St");
        userAuction.setHolderBalance(678231);

        // ADDING AUCTIONHOUSE TO TRANSACTION
        t.setAuctionHouse(userAuction);


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