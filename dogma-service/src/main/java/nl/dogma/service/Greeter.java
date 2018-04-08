package nl.dogma.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class Greeter extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516103ec3803806103ec83398101604052808051820191905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060019080519060200190610081929190610088565b505061012d565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100c957805160ff19168380011785556100f7565b828001600101855582156100f7579182015b828111156100f65782518255916020019190600101906100db565b5b5090506101049190610108565b5090565b61012a91905b8082111561012657600081600090555060010161010e565b5090565b90565b6102b08061013c6000396000f30060606040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806341c0e1b514610051578063cfae321714610066575b600080fd5b341561005c57600080fd5b6100646100f4565b005b341561007157600080fd5b610079610185565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100b957808201518184015260208101905061009e565b50505050905090810190601f1680156100e65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415610183576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b565b61018d610270565b3373ffffffffffffffffffffffffffffffffffffffff167fef81b6801c85f4e9b0e5b357f71647e7ae6534f60f48370955eabab8e67c9cb360405160405180910390a260018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102665780601f1061023b57610100808354040283529160200191610266565b820191906000526020600020905b81548152906001019060200180831161024957829003601f168201915b5050505050905090565b6020604051908101604052806000815250905600a165627a7a7230582079bd32a2c889bf3a85c06b21ebe0a34b4226a0d1b9ff397d886223989ce326f30029";

    protected Greeter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Greeter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<CallbackDummyEventResponse> getCallbackDummyEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("callbackDummy", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<CallbackDummyEventResponse> responses = new ArrayList<CallbackDummyEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CallbackDummyEventResponse typedResponse = new CallbackDummyEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._value = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CallbackDummyEventResponse> callbackDummyEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("callbackDummy", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CallbackDummyEventResponse>() {
            @Override
            public CallbackDummyEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                CallbackDummyEventResponse typedResponse = new CallbackDummyEventResponse();
                typedResponse.log = log;
                typedResponse._value = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

//    public List<CallbackDummyEventResponse> getCallbackDummyEvents(TransactionReceipt transactionReceipt) {
//        final Event event = new Event("callbackDummy",
//                Arrays.<TypeReference<?>>asList(),
//                Arrays.<TypeReference<?>>asList());
//        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
//        ArrayList<CallbackDummyEventResponse> responses = new ArrayList<CallbackDummyEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            CallbackDummyEventResponse typedResponse = new CallbackDummyEventResponse();
//            typedResponse.log = eventValues.getLog();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }
//
//    public Observable<CallbackDummyEventResponse> callbackDummyEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        final Event event = new Event("callbackDummy",
//                Arrays.<TypeReference<?>>asList(),
//                Arrays.<TypeReference<?>>asList());
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(event));
//        return web3j.ethLogObservable(filter).map(new Func1<Log, CallbackDummyEventResponse>() {
//            @Override
//            public CallbackDummyEventResponse call(Log log) {
//                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
//                CallbackDummyEventResponse typedResponse = new CallbackDummyEventResponse();
//                typedResponse.log = log;
//                return typedResponse;
//            }
//        });
//    }

    public RemoteCall<TransactionReceipt> kill() {
        final Function function = new Function(
                "kill", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> greet() {
        final Function function = new Function("greet", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<Greeter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _greeting) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)));
        return deployRemoteCall(Greeter.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Greeter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _greeting) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)));
        return deployRemoteCall(Greeter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Greeter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Greeter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class CallbackDummyEventResponse {
        public Log log;

        public String _value;
    }

}
