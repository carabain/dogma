pragma solidity ^0.4.0;
import "doc/mortal.sol";
contract greeter is mortal {

    /* This runs when the contract is executed */
    function greeter(string _greeting) public {
        greeting = _greeting;
    }
}