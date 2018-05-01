package com.carabain.dogma.service;

import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.JsonRpc2_0Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Async;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Extension of {@link JsonRpc2_0Web3j} which implements the {@link Admin} interface for working with accounts.
 */
public class AdminWeb3j extends JsonRpc2_0Web3j implements Admin {

    private static final String SERVICE_URL = HttpService.DEFAULT_URL;
    private static final int BLOCK_TIME_MILISECONDS = (JsonRpc2_0Web3j.DEFAULT_BLOCK_TIME / 3);

    /**
     * Creates a new instance using a {@link HttpService} with url "http://localhost:8545/"
     * and a block time of 5 seconds.
     */
    public AdminWeb3j() {
        this(SERVICE_URL);
    }

    /**
     * Creates a new instance using a {@link HttpService} with the given url and a block time of 5 seconds.
     *
     * @param serviceUrl the url to use for the {@link HttpService}
     */
    public AdminWeb3j(String serviceUrl) {
        super(new HttpService(serviceUrl), BLOCK_TIME_MILISECONDS, Async.defaultExecutorService());
    }

    /**
     * Returns a {@link Request} for retrieving a list of accounts from the chain.
     *
     * @return a {@link Request} for retrieving a list of accounts from the chain
     */
    public Request<?, PersonalListAccounts> personalListAccounts() {
        return new Request("personal_listAccounts", Collections.emptyList(), this.web3jService, PersonalListAccounts.class);
    }

    /**
     * Returns a {@link Request} for creating s new account on the chain.
     *
     * @param password the password for the account
     * @return a {@link Request} for creating s new account on the chain
     */
    public Request<?, NewAccountIdentifier> personalNewAccount(String password) {
        return new Request("personal_newAccount", Arrays.asList(password), this.web3jService, NewAccountIdentifier.class);
    }

    /**
     * Returns a {@link Request} for unlocking an account on the chain.
     *
     * @param address  the address of the account
     * @param password the password for the account
     * @param duration the time in ?? to keep the account unlocked
     * @return a {@link Request} for unlocking an account on the chain
     */
    public Request<?, PersonalUnlockAccount> personalUnlockAccount(String address, String password, BigInteger duration) {
        List<Object> attributes = new ArrayList(3);
        attributes.add(address);
        attributes.add(password);
        if (duration != null) {
            attributes.add(duration.longValue());
        } else {
            attributes.add((Object) null);
        }

        return new Request("personal_unlockAccount", attributes, this.web3jService, PersonalUnlockAccount.class);
    }

    /**
     * Returns a {@link Request} for unlocking an account on the chain.
     *
     * @param address  the address of the account
     * @param password the password for the account
     * @return a {@link Request} for unlocking an account on the chain
     */
    public Request<?, PersonalUnlockAccount> personalUnlockAccount(String address, String password) {
        return this.personalUnlockAccount(address, password, (BigInteger) null);
    }

    /**
     * Create a {@link Request} to send a {@link Transaction} towards the chain
     *
     * @param transaction a {@link Transaction}
     * @param passphrase  ??
     * @return a {@link Request} to send a {@link Transaction} towards the chain
     */
    public Request<?, EthSendTransaction> personalSendTransaction(Transaction transaction, String passphrase) {
        return new Request("personal_sendTransaction", Arrays.asList(transaction, passphrase), this.web3jService, EthSendTransaction.class);
    }
}

