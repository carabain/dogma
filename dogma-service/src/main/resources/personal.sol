pragma solidity ^0.4.0;

contract personal {

    address owner;
    bool alive;

    event aliveRequested(); // iemand vraagt op of iemand levend is aan het oracle
    event aliveUpdated(); // de waarde van "alive" is ge-update in het contract

    /* This function is executed at initialization and sets the owner of the contract */
    function personal() public {
        owner = msg.sender;
    }

    function isAlive() public returns (bool) {
        emit aliveRequested();
        return alive;
    }

    function setAlive(bool _alive) public {
        // TODO: Controleren dat call van Oracle komt? Met een modifier?
        alive = _alive;
        emit aliveUpdated();
    }

    /* Function to recover the funds on the contract */
    function kill() public {
        if (msg.sender == owner) {
            selfdestruct(owner);
        }
    }
}