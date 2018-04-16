pragma solidity ^0.4.0;

contract mortal {

    /* Define variable greeting of the type string */
    string greeting;

    event greeted(
        address indexed _value
    );

    event greetedAnother(
        address indexed _value
    );

    /* Define variable owner of the type address */
    address owner;

    function greet() public returns (string) {
        emit greeted(address(this));
        return greeting;
    }

    function greetAnother() public returns (string) {
        emit greetedAnother(address(this));
        return greeting;
    }

    /* This function is executed at initialization and sets the owner of the contract */
    function mortal() public {owner = msg.sender;}

    /* Function to recover the funds on the contract */
    function kill() public {if (msg.sender == owner) selfdestruct(owner);}
}