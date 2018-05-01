package com.carabain.dogma.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.TimeUnit;

/**
 * Unittests for {@link SalaryOracle}.
 */
public class SalaryOracleTest {

    public static final String ACCOUNT_ADDRESS = "0x8f4203671809e42f10c8dc6a406816e98c5e2828";
    public static final String ACCOUNT_PASSWORD = "xxx";

    public static final String WALLET_FILENAME = "UTC--2018-04-07T09-07-27.336619000Z--8f4203671809e42f10c8dc6a406816e98c5e2828";
    private static final String WALLETS_DIRECTORY = "C:\\ws\\blockchain\\DogmaChain\\data\\keystore";

    final Logger logger = LoggerFactory.getLogger(SalaryOracleTest.class);

    private AdminWeb3j web3j = new AdminWeb3j();

    @Test
    public void test() {
        SalaryOracle oracle = new SalaryOracle();

        unlockAccount();
        SalaryChild childContract = deployContract(web3j);

        // Load contract and register event subscriptions
        Salary baseContract = oracle.loadContract(childContract.getContractAddress(), ACCOUNT_ADDRESS);
        oracle.subscribeToEvents(baseContract);

        // Trigger an event by calling the contract
        try {
            logger.info("Triggering event 'salaryBelowTargetRequested' on contract {}", childContract.getContractAddress());
            childContract.isSalaryBelowTarget(BigInteger.TEN).send();
        } catch (Exception e) {
            throw new ChainException("Error while invoking contract", e);
        }

        // Wait for a while to make sure we receive all events
        pause(10);
    }

    private void unlockAccount() {
        try {
            web3j.personalUnlockAccount(ACCOUNT_ADDRESS, ACCOUNT_PASSWORD).send();
        } catch (IOException e) {
            throw new ChainException("Error while unlocking account", e);
        }
    }

    private SalaryChild deployContract(Web3j web3j) {
        SalaryChild contract;
        TransactionManager manager = new ClientTransactionManager(web3j, ACCOUNT_ADDRESS);
        try {
            contract = SalaryChild.deploy(web3j, manager, Contract.GAS_PRICE, Contract.GAS_LIMIT).send();
        } catch (Exception e) {
            throw new ChainException("Error while deploying contract", e);
        }
        logger.info("Deployed contract {}", contract.getContractAddress());
        return contract;
    }

    private void pause(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////

    private String generateWallet(String password, boolean light) {
        try {
            return WalletUtils.generateNewWalletFile(password, new File(WALLETS_DIRECTORY), !light);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException | CipherException | IOException e) {
            throw new ChainException("Could not create wallet", e);
        }
    }

    // Credentials credentials = loadCredentials(ACCOUNT_PASSWORD, WALLETS_DIRECTORY + "\\" + WALLET_FILENAME);
    private Credentials loadCredentials(String password, String walletFile) {
        try {
            return WalletUtils.loadCredentials(password, walletFile);
        } catch (IOException | CipherException e) {
            throw new ChainException("Could not load credentials", e);
        }
    }
}
