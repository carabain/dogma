pragma solidity ^0.4.0;

contract salary {

    address owner;
    bool salaryBelowTarget;

    event salaryBelowTargetRequested(uint32 target);
    event salaryBelowTargetUpdated();

    /* This function is executed at initialization and sets the owner of the contract */
    function salary() public {
        owner = msg.sender;
    }

    function isSalaryBelowTarget(uint32 target) public returns (bool) {
        emit salaryBelowTargetRequested(target);
        return salaryBelowTarget;
    }

    function setSalaryBelowTarget(bool _salaryBelowTarget) public {
        // TODO: Controleren dat call van Oracle komt? Met een modifier?
        salaryBelowTarget = _salaryBelowTarget;
        emit salaryBelowTargetUpdated();
    }

    /* Function to recover the funds on the contract */
    function kill() public {
        if (msg.sender == owner) {
            selfdestruct(owner);
        }
    }
}