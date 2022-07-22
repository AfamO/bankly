package com.ng.bankly;

import java.time.LocalDateTime;

public class TransactionModel {

    public TransactionModel(String transactionTypeName, Double amount, LocalDateTime transactionDate, String statusName){
        this.transactionTypeName = transactionTypeName;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "TransactionModel{amount="+this.amount+" transactionDate="+transactionDate+" statusName=="+statusName+" transactionTypeName="+transactionTypeName+"}";
    }

    public Object creditAccountNo;
    public Object debitAccountNo;
    public Object transactionBy;
    public String channelName;
    public String statusName;
    public int userType;
    public int userId;
    public Object initiator;
    public boolean archived;
    public Object product;
    public boolean hasProduct;
    public String senderName;
    public String receiverName;
    public double balanceBeforeTransaction;
    public int id;
    public String reference;
    public int transactionType;
    public String transactionTypeName;
    public String description;
    public String narration;
    public double amount;
    public String creditAccountNumber;
    public String deditAccountNumber;
    public String parentReference;
    public LocalDateTime transactionDate;
    public Object credit;
    public int debit;

    public Object getCreditAccountNo() {
        return creditAccountNo;
    }

    public void setCreditAccountNo(Object creditAccountNo) {
        this.creditAccountNo = creditAccountNo;
    }

    public Object getDebitAccountNo() {
        return debitAccountNo;
    }

    public void setDebitAccountNo(Object debitAccountNo) {
        this.debitAccountNo = debitAccountNo;
    }

    public Object getTransactionBy() {
        return transactionBy;
    }

    public void setTransactionBy(Object transactionBy) {
        this.transactionBy = transactionBy;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Object getInitiator() {
        return initiator;
    }

    public void setInitiator(Object initiator) {
        this.initiator = initiator;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
    }

    public boolean isHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public double getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public void setBalanceBeforeTransaction(double balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCreditAccountNumber() {
        return creditAccountNumber;
    }

    public void setCreditAccountNumber(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
    }

    public String getDeditAccountNumber() {
        return deditAccountNumber;
    }

    public void setDeditAccountNumber(String deditAccountNumber) {
        this.deditAccountNumber = deditAccountNumber;
    }

    public String getParentReference() {
        return parentReference;
    }

    public void setParentReference(String parentReference) {
        this.parentReference = parentReference;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Object getCredit() {
        return credit;
    }

    public void setCredit(Object credit) {
        this.credit = credit;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(double balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getCharges() {
        return charges;
    }

    public void setCharges(Object charges) {
        this.charges = charges;
    }

    public Object getAggregatorCommission() {
        return aggregatorCommission;
    }

    public void setAggregatorCommission(Object aggregatorCommission) {
        this.aggregatorCommission = aggregatorCommission;
    }

    public boolean isHasCharges() {
        return hasCharges;
    }

    public void setHasCharges(boolean hasCharges) {
        this.hasCharges = hasCharges;
    }

    public Object getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(Object agentCommission) {
        this.agentCommission = agentCommission;
    }

    public String getDebitAccountNumber() {
        return debitAccountNumber;
    }

    public void setDebitAccountNumber(String debitAccountNumber) {
        this.debitAccountNumber = debitAccountNumber;
    }

    public Object getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(Object initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public Object getStateId() {
        return stateId;
    }

    public void setStateId(Object stateId) {
        this.stateId = stateId;
    }

    public Object getLgaId() {
        return lgaId;
    }

    public void setLgaId(Object lgaId) {
        this.lgaId = lgaId;
    }

    public Object getRegionId() {
        return regionId;
    }

    public void setRegionId(Object regionId) {
        this.regionId = regionId;
    }

    public Object getAggregatorId() {
        return aggregatorId;
    }

    public void setAggregatorId(Object aggregatorId) {
        this.aggregatorId = aggregatorId;
    }

    public boolean isCredit() {
        return isCredit;
    }

    public void setCredit(boolean credit) {
        isCredit = credit;
    }

    public double balanceAfterTransaction;
    public String sender;
    public String receiver;
    public int channel;
    public int status;
    public Object charges;
    public Object aggregatorCommission;
    public boolean hasCharges;
    public Object agentCommission;
    public String debitAccountNumber;
    public Object initiatedBy;
    public Object stateId;
    public Object lgaId;
    public Object regionId;
    public Object aggregatorId;
    public boolean isCredit;
}
