/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discofy;

/**
 *
 * @author brend
 */
public class Discofy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiscoBot bot = new DiscoBot();
        bot.recieveMessage(".ping", "pong");
        bot.recieveMessage("batata", "frita");
    }
    
}
