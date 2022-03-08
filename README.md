# caesar-cipher

## how to use
for encryption, there's a basic caesar shift pattern applied to the char vals of the inputed values. 
```cmd
  java Caesar 3 "hello world"
  
  >>>   khoor zruog
  ```
  for decryption, in order to produce results without the key, we have to annalyse the likely hood of a certain char within a simplistic english sentence.
  
  A formula known as **Chi Squared** formula is used to produce a integer relating to the likely hood of 2 datasets being close to each other.
  In this instance, the chi-squared formula is being used to determine the key shift of the encrypted message
  
  ```cmd
  java brutus "khoor zruog"   
  
  >>>    Determined Key Shift = 3.365395823413051
  >>>    Decrypted Message = hello world
```
