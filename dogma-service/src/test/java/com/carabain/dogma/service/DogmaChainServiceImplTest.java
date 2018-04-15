package com.carabain.dogma.service;

import org.junit.Ignore;
import org.junit.Test;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import rx.Subscription;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Unittests for {@link DogmaChainServiceImpl}.
 */
public class DogmaChainServiceImplTest {

    private Subscription subscription;

    @Test
    public void test() {
        DogmaChainService service = new DogmaChainServiceImpl();
        ContractData xxx = createAnddeployContract();
        service.callContract(xxx.address, xxx.credentials);
    }

    private ContractData createAnddeployContract() {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        String password = "xxx";
        String pathToWallet = "C:\\ws\\blockchain\\DogmaChain\\data\\keystore\\UTC--2018-04-07T09-07-27.336619000Z--8f4203671809e42f10c8dc6a406816e98c5e2828";
        String message = "Hallo Dogma! Lekkere cocktails ;-)";

        try {
            Credentials credentials = WalletUtils.loadCredentials(password, pathToWallet);
            Greeter contract = Greeter.deploy(web3, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT, message).send();
            System.out.println("Deployed contract: " + contract.getContractAddress());

            ContractData data = new ContractData();
            data.address = contract.getContractAddress();
            data.credentials = credentials;
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
