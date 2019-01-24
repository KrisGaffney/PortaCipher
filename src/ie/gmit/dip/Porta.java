package ie.gmit.dip;

public class Porta {
    private char[] key;
    
    private char[][] tabulaRecta = {
        
        {' ',' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
        {'A','B','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
        {'C','D','O','P','Q','R','S','T','U','V','W','X','Y','Z','N','M','A','B','C','D','E','F','G','H','I','J','K','L'},
        {'E','F','P','Q','R','S','T','U','V','W','X','Y','Z','N','O','L','M','A','B','C','D','E','F','G','H','I','J','K'},
        {'G','H','Q','R','S','T','U','V','W','X','Y','Z','N','O','P','K','L','M','A','B','C','D','E','F','G','H','I','J'},
        {'I','J','R','S','T','U','V','W','X','Y','Z','N','O','P','Q','J','K','L','M','A','B','C','D','E','F','G','H','I'},
        {'K','L','S','T','U','V','W','X','Y','Z','N','O','P','Q','R','I','J','K','L','M','A','B','C','D','E','F','G','H'},
        {'M','N','T','U','V','W','X','Y','Z','N','O','P','Q','R','S','H','I','J','K','L','M','A','B','C','D','E','F','G'},
        {'O','P','U','V','W','X','Y','Z','N','O','P','Q','R','S','T','G','H','I','J','K','L','M','A','B','C','D','E','F'},
        {'Q','R','V','W','X','Y','Z','N','O','P','Q','R','S','T','U','F','G','H','I','J','K','L','M','A','B','C','D','E'},
        {'S','T','W','X','Y','Z','N','O','P','Q','R','S','T','U','V','E','F','G','H','I','J','K','L','M','A','B','C','D'},
        {'U','V','X','Y','Z','N','O','P','Q','R','S','T','U','V','W','D','E','F','G','H','I','J','K','L','M','A','B','C'},
        {'W','X','Y','Z','N','O','P','Q','R','S','T','U','V','W','X','C','D','E','F','G','H','I','J','K','L','M','A','B'},
        {'Y','Z','Z','N','O','P','Q','R','S','T','U','V','W','X','Y','B','C','D','E','F','G','H','I','J','K','L','M','A'}
        
        };
    
    
    
    public Porta(String key){
        setKey(key);
    }

    public void setKey(String key){
        this.key = key.trim().toUpperCase().toCharArray();
    }
    public String encrypt(String plainText){
        plainText = plainText.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int j = 0; 
        for (int i = 0; i < plainText.length(); i++){
            // Use j to track key word position
            sb.append(getEncryptedCharacter(key[j] , plainText.charAt(i)));
            
            // If j has reached key limit reest to read from start of key 
            if(j == key.length-1){
                j = 0; 
            }else{
                j++; 
            }
           
        }
        return sb.toString();
    }
    private char getEncryptedCharacter(char key, char plain){
        for (int row = 0; row < tabulaRecta.length; row++){
            //using the first two Columns for key
            if (tabulaRecta[row][0] == key || tabulaRecta[row][1] == key){
                for (int col = 0; col < tabulaRecta[row].length; col++){
                    if (tabulaRecta[0][col] == plain){
                        return tabulaRecta[row][col];
                        
                    }
                }
                
            }
        }
        return plain;
    }
    public String decrypt(String cipherText){
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < cipherText.length(); i++){
            sb.append(getDecryptedCharacter(key[i], cipherText.charAt(i)));
        }
        return sb.toString();
        
    }
    private char getDecryptedCharacter(char key, char cipher){
        for (int col = 0; col < tabulaRecta[0].length; col++){
            if (tabulaRecta[0][col] == key){
                for (int row = 0; row < tabulaRecta.length; row++){
                    if (tabulaRecta[row][col] == cipher){
                        return tabulaRecta[row][0];
                        
                    }
                }
            }
        }
        return cipher;
        
    }
}


