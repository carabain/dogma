package com.carabain.dogma.service;

import org.junit.Ignore;
import org.junit.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * Unittests for {@link DogmaChainServiceImpl}.
 */
public class DogmaChainServiceImplTest {

    private Subscription subscription;

    @Test
    public void test() {
        DogmaChainService service = new DogmaChainServiceImpl();
        DogmaChainServiceImpl.Xxx xxx = service.createAnddeployContract();
        service.callContract(xxx);
    }

    @Test
    @Ignore
    public void test2() throws Exception {
        Web3j web3 = Web3j.build(new HttpService());
        //Web3j web3 = Web3j.build(new WindowsIpcService("\\\\.\\pipe\\geth.ipc"));
        subscription = web3.blockObservable(true).subscribe(block -> {
            System.out.println("Sweet, block number " + block.getBlock().getNumber() + " has just been created");
        }, Throwable::printStackTrace);
        TimeUnit.MINUTES.sleep(1);
        subscription.unsubscribe();

        System.out.println("here");
        //TimeUnit.MINUTES.sleep(1);
    }
}
