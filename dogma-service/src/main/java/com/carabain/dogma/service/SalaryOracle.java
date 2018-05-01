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
 * An {@link Oracle} fot handling salary data.
 */
public class SalaryOracle implements Oracle<Salary> {

    final Logger logger = LoggerFactory.getLogger(SalaryOracle.class);

    private Web3j web3j= new AdminWeb3j();

    @Override
    public Salary deployContract(String ownerAddress) {
        TransactionManager manager = new ClientTransactionManager(web3j, ownerAddress);
        try {
            return Salary.deploy(web3j, manager, Contract.GAS_PRICE, Contract.GAS_LIMIT).send();
        } catch (Exception e) {
            throw new ChainException("Error while deploying contract", e);
        }
    }

    @Override
    public Salary loadContract(String contractAddress, String ownerAddress) {
        TransactionManager manager = new ClientTransactionManager(web3j, ownerAddress);
        try {
            return Salary.load(contractAddress, web3j, manager, Contract.GAS_PRICE, Contract.GAS_LIMIT);
        } catch (Exception e) {
            throw new ChainException("Error while loading contract", e);
        }
    }

    public void subscribeToEvents(Salary contract) {
        logger.info("Subscribing to contract event 'salaryBelowTargetRequested'");
        Subscription salaryBelowTargetRequestedSubscription = contract.salaryBelowTargetRequestedEventObservable(
                DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    handlesalaryBelowTargetRequested(contract);
                }, Throwable::printStackTrace);

        logger.info("Subscribing to contract event 'salaryBelowTargetUpdated'");
        Subscription salaryBelowTargetUpdatedSubscription = contract.salaryBelowTargetUpdatedEventObservable(
                DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
                .subscribe(event -> {
                    handlesalaryBelowTargetUpdated(contract);
                }, Throwable::printStackTrace);
    }

    private void handlesalaryBelowTargetRequested(Salary contract) {
        logger.info("Received event 'salaryBelowTargetRequested'");

        boolean salaryBelowTarget = true; // hier gegevens bepalen (database internet? etc/ etc/)
        logger.info("Determined value for 'salaryBelowTarget': {}", salaryBelowTarget);

        try {
            logger.info("Invoking 'setsalaryBelowTarget={}' on contract {}", salaryBelowTarget, contract.getContractAddress());
            contract.setSalaryBelowTarget(salaryBelowTarget).send();
        } catch (Exception e) {
            throw new ChainException("Error while invoking contract", e);
        }
    }

    private void handlesalaryBelowTargetUpdated(Salary contract) {
        logger.info("Received event 'salaryBelowTargetUpdated'");
    }
}
