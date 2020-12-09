package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlockForum extends JDialog implements ActionListener {
    // transaction class
    Transaction fillTrans = new Transaction();

    // frame of text entry
    JDialog frame = new JDialog();
    JButton submitButton = new JButton("Submit");
    JLabel titlePage = new JLabel("Blockchain Transaction Forum");

    // Artifact abstract
    JTextField artifactID = new JTextField();
    JLabel artifactIDLabel = new JLabel("Artifact ID#:");
    JTextField artifactName = new JTextField();
    JLabel artifactNameLabel = new JLabel("Artifact name:");
    // Stakeholder country
    JTextField countryID = new JTextField();
    JLabel countryIDLabel = new JLabel("Country ID#:");
    JTextField countryName = new JTextField();
    JLabel countryNameLabel = new JLabel("Country name:");
    JTextField countryAddress = new JTextField();
    JLabel countryAddressLabel = new JLabel("Country address:");
    JTextField countryBalance = new JTextField();
    JLabel countryBalanceLabel = new JLabel("Country balance:");
    // Stakeholder currOwner
    JTextField currOwnerID = new JTextField();
    JLabel currOwnerIDLabel = new JLabel("Current owner ID#:");
    JTextField currOwnerName = new JTextField();
    JLabel currOwnerNameLabel = new JLabel("Current owner name:");
    JTextField currOwnerAddress = new JTextField();
    JLabel currOwnerAddressLabel = new JLabel("Current owner address:");
    JTextField currOwnerBalance = new JTextField();
    JLabel currOwnerBalanceLabel = new JLabel("Current owner balance:");

    // time stamp
    JTextField timeStamp = new JTextField();
    JLabel timeStampLabel = new JLabel("Year:");

    // Stakeholder seller
    JTextField sellerID = new JTextField();
    JLabel sellerIDLabel = new JLabel("Seller ID#:");
    JTextField sellerName = new JTextField();
    JLabel sellerNameLabel = new JLabel("Seller name:");
    JTextField sellerAddress = new JTextField();
    JLabel sellerAddressLabel = new JLabel("Seller address:");
    JTextField sellerBalance = new JTextField();
    JLabel sellerBalanceLabel = new JLabel("Seller balance:");

    // Stakeholder buyer
    JTextField buyerID = new JTextField();
    JLabel buyerIDLabel = new JLabel("Buyer ID#:");
    JTextField buyerName = new JTextField();
    JLabel buyerNameLabel = new JLabel("Buyer name:");
    JTextField buyerAddress = new JTextField();
    JLabel buyerAddressLabel = new JLabel("Buyer address:");
    JTextField buyerBalance = new JTextField();
    JLabel buyerBalanceLabel = new JLabel("Buyer balance:");

    // Stakeholder auction
    JTextField auctionID = new JTextField();
    JLabel auctionIDLabel = new JLabel("Auction ID#:");
    JTextField auctionName = new JTextField();
    JLabel auctionNameLabel = new JLabel("Auction name:");
    JTextField auctionAddress = new JTextField();
    JLabel auctionAddressLabel = new JLabel("Auction address:");
    JTextField auctionBalance = new JTextField();
    JLabel auctionBalanceLabel = new JLabel("Auction balance:");

    // Transaction price
    JTextField transPrice = new JTextField();
    JLabel transPriceLabel = new JLabel("Transaction price:");

    // next button
    JButton nextButton = new JButton();


    BlockForum() {
        frame.setModal(true);

        // adding title
        titlePage.setBounds(330, 10, 400 , 25);
        titlePage.setFont(new Font("Arial", Font.BOLD, 20 ));

        // adding labels
        submitButton.setBounds(420, 440,100,25);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        artifactIDLabel.setBounds(50,50,200,25);
        artifactNameLabel.setBounds(50,80,200,25);
        countryIDLabel.setBounds(50,110,200,25);
        countryNameLabel.setBounds(50,140,200,25);
        countryAddressLabel.setBounds(50,170,200,25);
        countryBalanceLabel.setBounds(50,200,200,25);
        currOwnerIDLabel.setBounds(50,230,200,25);
        currOwnerNameLabel.setBounds(50,260,200,25);
        currOwnerAddressLabel.setBounds(50,290,200,25);
        currOwnerBalanceLabel.setBounds(50,320,200,25);
        timeStampLabel.setBounds(50,350,200,25);
        sellerIDLabel.setBounds(50,380,200,25);

        sellerNameLabel.setBounds(505,50,200,25);
        sellerAddressLabel.setBounds(505,80,200,25);
        sellerBalanceLabel.setBounds(505,110,200,25);
        buyerIDLabel.setBounds(505,140,200,25);
        buyerNameLabel.setBounds(505,170,200,25);
        buyerAddressLabel.setBounds(505,200,200,25);
        buyerBalanceLabel.setBounds(505,230,200,25);
        auctionIDLabel.setBounds(505,260,200,25);
        auctionNameLabel.setBounds(505,290,200,25);
        auctionAddressLabel.setBounds(505,320,200,25);
        auctionBalanceLabel.setBounds(505,350,200,25);
        transPriceLabel.setBounds(505,380,200,25);


        // adding fields
        artifactID.setBounds(200, 50, 200, 25);
        artifactName.setBounds(200, 80, 200, 25);
        countryID.setBounds(200,110,200,25);
        countryName.setBounds(200,140,200,25);
        countryAddress.setBounds(200,170,200,25);
        countryBalance.setBounds(200,200,200,25);
        currOwnerID.setBounds(200,230,200,25);
        currOwnerName.setBounds(200,260,200,25);
        currOwnerAddress.setBounds(200,290,200,25);
        currOwnerBalance.setBounds(200,320,200,25);
        timeStamp.setBounds(200,350,200,25);
        sellerID.setBounds(200,380,200,25);

        sellerName.setBounds(680,50,200,25);
        sellerAddress.setBounds(680,80,200,25);
        sellerBalance.setBounds(680,110,200,25);
        buyerID.setBounds(680,140,200,25);
        buyerName.setBounds(680,170,200,25);
        buyerAddress.setBounds(680,200,200,25);
        buyerBalance.setBounds(680,230,200,25);
        auctionID.setBounds(680,260,200,25);
        auctionName.setBounds(680,290,200,25);
        auctionAddress.setBounds(680,320,200,25);
        auctionBalance.setBounds(680,350,200,25);
        transPrice.setBounds(680,380,200,25);



        // adding to frame
        frame.add(timeStamp);
        frame.add(timeStampLabel);
        frame.add(sellerName);
        frame.add(sellerNameLabel);
        frame.add(sellerAddress);
        frame.add(sellerAddressLabel);
        frame.add(sellerBalance);
        frame.add(sellerBalanceLabel);
        frame.add(sellerID);
        frame.add(sellerIDLabel);
        frame.add(buyerName);
        frame.add(buyerNameLabel);
        frame.add(buyerAddress);
        frame.add(buyerAddressLabel);
        frame.add(buyerBalance);
        frame.add(buyerBalanceLabel);
        frame.add(buyerID);
        frame.add(buyerIDLabel);
        frame.add(auctionName);
        frame.add(auctionNameLabel);
        frame.add(auctionAddress);
        frame.add(auctionAddressLabel);
        frame.add(auctionBalance);
        frame.add(auctionBalanceLabel);
        frame.add(auctionID);
        frame.add(auctionIDLabel);
        frame.add(transPrice);
        frame.add(transPriceLabel);
        frame.add(countryIDLabel);
        frame.add(countryID);
        frame.add(countryName);
        frame.add(countryNameLabel);
        frame.add(countryAddressLabel);
        frame.add(countryAddress);
        frame.add(countryBalanceLabel);
        frame.add(countryBalance);
        frame.add(currOwnerIDLabel);
        frame.add(currOwnerID);
        frame.add(currOwnerNameLabel);
        frame.add(currOwnerName);
        frame.add(currOwnerAddressLabel);
        frame.add(currOwnerAddress);
        frame.add(currOwnerBalanceLabel);
        frame.add(currOwnerBalance);
        frame.add(countryID);
        frame.add(countryIDLabel);
        frame.add(submitButton);
        frame.add(artifactNameLabel);
        frame.add(artifactIDLabel);
        frame.add(titlePage);
        frame.add(artifactID);
        frame.add(artifactName);

        // operations for frame
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setSize(960,540);
        frame.setLayout(null);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {

            // making an artifact
            Artifact userArt = new Artifact();
            userArt.setArtifactID(artifactID.getText());
            userArt.setArtifactName(artifactName.getText());

            // setting country of artifact
            Stakeholder country = new Stakeholder();
            country.setIdNumber(countryID.getText());
            country.setHolderName(countryName.getText());
            country.setHolderAddress(countryAddress.getText());
            try {
                country.setHolderBalance(Double.parseDouble(countryBalance.getText()));
            } catch (Exception e1) {
                System.out.println("The program exited due to wrong variable type. Please enter a double for country balance");
                System.exit(-1);
            }

            // setting currOwner of artifact
            Stakeholder currOwner = new Stakeholder();
            currOwner.setIdNumber(currOwnerID.getText());
            currOwner.setHolderName(currOwnerName.getText());
            currOwner.setHolderAddress(currOwnerAddress.getText());
            try {
                currOwner.setHolderBalance(Double.parseDouble(currOwnerBalance.getText()));
            } catch (Exception e1) {
                System.out.println("The program exited due to wrong variable type. Please enter a double for current owner balance");
                System.exit(-1);
            }


            // adding country and currOwner to artifact
            userArt.setArtifactCountry(country);
            userArt.setCurrOwner(currOwner);

            // ADDING ARTIFACT TO TRANSACTION
            fillTrans.setArtifact(userArt);

            // setting time
            try {
                fillTrans.setTimestamp(Integer.parseInt(timeStamp.getText()));
            } catch (Exception e1) {
                System.out.println("The program exited due to wrong variable type. Please enter an integer for time in years");
                System.exit(-1);
            }



            // making a new seller
            Stakeholder userSeller = new Stakeholder();
            userSeller.setIdNumber(sellerID.getText());
            userSeller.setHolderName(sellerName.getText());
            userSeller.setHolderAddress(sellerAddress.getText());
            try {
                userSeller.setHolderBalance(Double.parseDouble(sellerBalance.getText()));
            } catch (Exception e1) {
                System.out.println("The program exited due to wrong variable type. Please enter a double for seller balance");
                System.exit(-1);
            }

            // ADDING SELLER TO TRANSACTION
            fillTrans.setSeller(userSeller);


            // making a new buyer
            Stakeholder userBuyer = new Stakeholder();
            userBuyer.setIdNumber(buyerID.getText());
            userBuyer.setHolderName(buyerName.getText());
            userBuyer.setHolderAddress(buyerAddress.getText());
            try {
                userBuyer.setHolderBalance(Double.parseDouble(buyerBalance.getText()));
            } catch (Exception e1) {
                System.out.println("The program exited due to wrong variable type. Please enter a double for buyer balance");
                System.exit(-1);
            }

            // ADDING BUYER TO TRANSACTION
            fillTrans.setBuyer(userBuyer);


            // making a new auctionHouse
            Stakeholder userAuction = new Stakeholder();
            userAuction.setIdNumber(artifactID.getText());
            userAuction.setHolderName(artifactName.getText());
            userAuction.setHolderAddress(auctionAddress.getText());
            try {
                userAuction.setHolderBalance(Double.parseDouble(auctionBalance.getText()));
            } catch (Exception e1) {
                System.out.println("The program exited due to wrong variable type. Please enter a double for auction balance");
                System.exit(-1);
            }

            // ADDING AUCTIONHOUSE TO TRANSACTION
            fillTrans.setAuctionHouse(userAuction);


            // setting transaction price
            try {
                fillTrans.setPrice(Double.parseDouble(transPrice.getText()));
            } catch (Exception e1) {
                System.out.println("The program exited due to wrong variable type. Please enter a double for transaction price");
                System.exit(-1);
            }

            dispose();
        }
    }

    public Transaction getFillTrans() {
        return fillTrans;
    }

    public void setFillTrans(Transaction fillTrans) {
        this.fillTrans = fillTrans;
    }

}
