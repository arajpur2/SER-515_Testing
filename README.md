# SER-515_Testing

### Assignment - For the given problem, develop the solution and write unit tests using JUnit 5

### The Problem Statement -

In men's public toilets with urinals, there is this unwritten rule that you leave at least one urinal free between you and the next person peeing. For example, if there are 3 urinals and one person is already peeing in the left one, you will choose the urinal on the right and not the one in the middle. You need to write a function that returns the maximum of free urinals as an integer according to the unwritten rule. Take input from both, the user as well a text file. Output to the console as well as a text file.

### Sample input and output -

- 10001 returns 1 (10101)
- 1001 returns 0 (1001)
- 00000 returns 3 (10101)
- 0000 returns 2 (1001)
- 01000 returns 1 (01010 or 01001)
- 011 returns -1
