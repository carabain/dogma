package com.carabain.dogma.service;

import org.junit.Test;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.util.concurrent.TimeUnit;

/**
 * Unittests for {@link DogmaChainServiceImpl}.
 */
public class DogmaChainServiceImplTest {

    @Test
    public void test() throws Exception {
        DogmaChainService service = new DogmaChainServiceImpl();

        String password = "xxx";
        String pathToWallet = "C:\\ws\\blockchain\\DogmaChain\\data\\keystore\\UTC--2018-04-07T09-07-27.336619000Z--8f4203671809e42f10c8dc6a406816e98c5e2828";

        Web3j web3 = Web3j.build(new HttpService());
        Credentials credentials = WalletUtils.loadCredentials(password, pathToWallet);
        PersonalChild contract = PersonalChild.deploy(web3, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send();
        System.out.println("Deployed contract: " + contract.getContractAddress());

        service.callContract(contract.getContractAddress(), credentials);

        // trigger an event
        contract.isAlive().sendAsync();
        // wait for a while
        pause(60);
    }

    private void pause(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
