package discofy;

import com.google.common.util.concurrent.FutureCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brend
 */
public class DiscoBot {
    
    private DiscordAPI api;
    private String token = "MzQ2MzkxMzA0NzU1ODcxNzQ1.DIkj8g.uxYbS9GhdDlk57DUbDL5S4HM8Kw";
    private HashMap<String, String> list = new HashMap<>();
    
    private void connectAPI(){
        this.api.connect(new FutureCallback<DiscordAPI>() {
            @Override
            public void onSuccess(DiscordAPI v) {
                api.registerListener(new MessageCreateListener() {
                    @Override
                    public void onMessageCreate(DiscordAPI dapi, Message msg) {
                        if (list.containsKey(msg.getContent())){
                            
                            msg.reply(list.get(msg.getContent()));
                        }
                    }
                });
            }

            @Override
            public void onFailure(Throwable thrwbl) {
                thrwbl.printStackTrace();
                System.out.println("Error!");
            }
        });
    }
    
    public void recieveMessage (String recieved, String send){
        list.put(recieved, send);
    }
    
    public DiscoBot(String token) {
        this.token = token;
        this.api = Javacord.getApi(token, true);
        this.connectAPI();
        
    }

    public DiscoBot() {
        this.api = Javacord.getApi(token, true);
        this.connectAPI();
    }
    
}