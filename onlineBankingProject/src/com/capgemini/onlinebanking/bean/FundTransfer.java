package com.capgemini.onlinebanking.bean;

import java.sql.Date;

public class FundTransfer
{
    private int FundTransferID;
    private int AccountID;
    private int PayeeAccountID;
    private Date DateOfTransfer;
    private int TransferAmount;
}
