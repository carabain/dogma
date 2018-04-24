/*
import "salary.sol"; // does not work!, see:
https://github.com/web3j/web3j-maven-plugin/issues/17

For now include the contents of the required contract(s):
*/

/********* Start contract inclusion *********/
pragma solidity ^0.4.0;

contract salary {

    address owner;
    bool salaryBelowTarget;

    event salaryBelowTargetRequested();
    event salaryBelowTargetUpdated();

    /* This function is executed at initialization and sets the owner of the contract */
    function salary() public {
        owner = msg.sender;
    }

    function isSalaryBelowTarget(uint32 target) public returns (bool) {
        emit salaryBelowTargetRequested();
        return salaryBelowTarget;
    }

    function setSalaryBelowTarget(bool _salaryBelowTarge) public {
        // TODO: Controleren dat call van Oracle komt? Met een modifier?
        salaryBelowTarget = _salaryBelowTarge;
        emit salaryBelowTargetUpdated();
    }

    /* Function to recover the funds on the contract */
    function kill() public {
        if (msg.sender == owner) {
            selfdestruct(owner);
        }
    }
}
/********* End contract inclusion *********/

contract salaryChild is salary {

}