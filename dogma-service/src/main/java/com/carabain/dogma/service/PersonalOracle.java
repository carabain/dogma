package com.carabain.dogma.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Subscription;

/**
 * An {@link Oracle} for handling personal data.
 */
public class PersonalOracle implements Oracle<Personal> {

    final Logger logger = LoggerFactory.getLogger(PersonalOracle.class);

    private Web3j web3j = new AdminWeb3j();

    @Override
    public Personal deployContract(String ownerAddress) {
        TransactionManager manager = new ClientTransactionManager(web3j, ownerAddress);
        try {
            return Personal.deploy(web3j, manager, Contract.GAS_PRICE, Contract.GAS_LIMIT).send();
        } catch (Exception e) {
            throw new ChainException("Error while deploying contract", e);
        }
    }

    @Override
    public Personal loadContract(String contractAddress, String ownerAddress) {
        TransactionManager manager = new ClientTransactionManager(web3j, ownerAddress);
        try {
            return Personal.load(contractAddress, web3j, manager, Contract.GAS_PRICE, Contract.GAS_LIMIT);
        } catch (Exception e) {
            throw new ChainException("Error while loading contract", e);
        }
    }

    public void subscribeToEvents(Personal contract) {
        logger.info("Subscribing to contract event 'aliveRequested'");
        Subscription aliveRequestedSubscription = contract.aliveRequestedEventObservable(
                DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    handleAliveRequested(contract);
                }, Throwable::printStackTrace);

        logger.info("Subscribing to contract event 'aliveUpdated'");
        Subscription aliveUpdatedSubscription = contract.aliveUpdatedEventObservable(
                DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    handleAliveUpdated(contract);
                }, Throwable::printStackTrace);
    }

    private void handleAliveRequested(Personal contract) {
        logger.info("Received event 'aliveRequested'");

        boolean alive = true; // hier gegevens bepalen (database internet? etc/ etc/)
        logger.info("Determined value for 'alive': {}", alive);

        try {
            logger.info("Invoking 'setAlive={}' on contract {}", alive, contract.getContractAddress());
            contract.setAlive(alive).send();
        } catch (Exception e) {
            throw new ChainException("Error while invoking contract", e);
        }
    }

    private void handleAliveUpdated(Personal contract) {
        logger.info("Received event 'aliveUpdated'");
    }
}
