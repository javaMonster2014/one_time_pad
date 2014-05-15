 import java.math.BigInteger;
 import java.util.Random;
 import java.util.Scanner;
 import java.math.*;

public class MyClass {
	/* message is a String container that either stores the enciphered
           message or the deciphered messaged. Wherein, the key String container
           is treated the same.*/
        private static String message, key;

        /* takes a String message and enciphers the message using
           a one-time pad key
        ======================================================================*/
	public static String translateMessage(final String message)
	{
            /* translateMessage(final String) delcarations:
            =========================================================*/
	    String _temp_strBinMessage, _temp_strKey;
	    BigInteger _temp_BigInt_binMessage,  _temp_BigInt_key;
            final int intMessage_length;
            
            //=========================================================
	    
            //convert the message from standard in to a BigInteger of 
            //bytes 
	    _temp_BigInt_binMessage= new BigInteger(message.getBytes());
            
            //convert _temp_BigInt_binMessage to a String: used later 
            //to determine the length of the key to generate.
            //========================================================
	    _temp_strBinMessage = _temp_BigInt_binMessage.toString(2);
	    intMessage_length = _temp_strBinMessage.length();
            _temp_BigInt_key= genKey(intMessage_length);
	    
            //perform a bitwise XOR to produce the enciphered message
	    _temp_BigInt_binMessage=_temp_BigInt_binMessage.xor(_temp_BigInt_key);
	    
	    //convert the key from BigInteger to a String: used later for output
	    _temp_strKey=_temp_BigInt_key.toString(2);
	    
            //stores boyh the key and enciphered message,as a String, 
            //in the repsective class variables
	    MyClass.key=_temp_strKey;
	    MyClass.message= _temp_BigInt_binMessage.toString(2);  

            //returns the enciphered message to main()
	    return MyClass.message;
	    
	}
	
        /* overloads previous translateMessage() method: takes two String 
           parameters, message and key. The key is used to decipher the 
           message that has been enciphered 
        ======================================================================*/
	 private static String translateMessage(final String message, final String key)
	{
            /* translateMessage(final String, final String) delcarations:
            =========================================================*/
            String _tempStrDecipheredMessage;
	    BigInteger _temp_BigInt_binMessage, _temp_BigInt_key;
            //========================================================
            
            //convert the String key and String message into a binary BigInteger
            //==================================================================
            _temp_BigInt_key= new BigInteger(key,2);
            _temp_BigInt_binMessage= new BigInteger(message,2);
            //==================================================================
            
            //perform a bitwise XOR on the binary key and message: store the
            //results in _temp_BigInt_binMessage
            _temp_BigInt_binMessage=_temp_BigInt_binMessage.xor(_temp_BigInt_key);
            
            //convert the deciphered, binary message into a String - for readability
            _tempStrDecipheredMessage = _temp_BigInt_binMessage.toString(2);
            
            //return the full, deciphered message to main()
            return new String(new BigInteger(_tempStrDecipheredMessage,2).toByteArray());   
	} 
	
        /* BigInteger generates a pseudorandom key, based on the length of
        _temp_strBinMessage in translateMessage 
        ======================================================================*/
	private static final BigInteger genKey(int MLENGTH)
	{
	     BigInteger rand_key= new BigInteger("0");
	     String rand_bits="";
	        
                //produces a BigInteger, pseudorandom key, the same length 
                //as the message: _temp_strBinMessage
	        while (rand_bits.length()!=MLENGTH)
	        {
	        rand_key = new BigInteger(MLENGTH, new Random());
                
                //the generated key, as a String: used to determine 
                //if the generated binary literal is long enough/acceptable
	        rand_bits=rand_key.toString(2);
	        }
                
                //returns the accepted, generated key
	        return rand_key;
	}
	
        /* TRIVIAL! returns the value of the key class variable, i.e., 
        the generated key 
        ======================================================================*/
	public static final String getKey()
	{
	    return key;
	}

	public static void main(String args[]){
		String op = args[0], key, translated_message;
                
                //stores both the key and message to be deciphered:
                //from StringBuilder message_and_key
                String[] _temp_strMessage_and_Key;
                
                //used to read from the console
		Scanner input = new Scanner(System.in);
                
                //used to store the the message to be enciphered, from the console
		StringBuilder message_to_translate = new StringBuilder();
                
                //used to store both the message and key to be deciphered, from 
                //console
                StringBuilder message_and_key = new StringBuilder();
		
                //used to determined which argument was chosen
		switch(op)
		{
		    case "-e":
                        
                    //retrieve the message to be enciphered: from console
		    while (input.hasNextLine())
		    {
		        message_to_translate.append(input.nextLine());
		        
		    }
                    
                    //enciphers the message
		    translated_message= MyClass.translateMessage(message_to_translate.toString());
                    
                    //gets the one-time pad key used to encipher the message
		    key=MyClass.getKey();
		    
                    //output and formatting:
		    //System.out.println("Message to translate: "+ "\n" + message_to_translate.toString());
		    System.out.println("\n" + "Enciphered message:"+ "\n" + translated_message);
		    System.out.println("\n" + "Encipher key:"+ "\n" + key);
                    
                    
                    
		    break;
                        
                    case "-d":
                    while (input.hasNextLine())
		    {
		        message_and_key.append(input.nextLine());
		        
		    }
                    
                    //split the _temp_strMessage_and_Key StringBuilder into
                    //a message and a key
                    _temp_strMessage_and_Key=message_and_key.toString().split(":");
                    
                    //decipher the message, using the provided key
		    translated_message= MyClass.translateMessage(_temp_strMessage_and_Key[0],_temp_strMessage_and_Key[1]);
                    
                    //output the deciphered message
                    System.out.println("\n" + "Deciphered message:"+ "\n" + translated_message + "\n");
                    break;
                        
                    default: break;
		}
	}
}