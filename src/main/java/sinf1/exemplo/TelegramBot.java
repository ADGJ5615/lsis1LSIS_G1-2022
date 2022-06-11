package sinf1.exemplo;

import io.vertx.core.Vertx;
import org.telegram.telegrambots.bots.TelegramLongPollingBot; //PROJEC STRUCTURE - GLOBAL LIBRARIES - INSTALAR <---
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author Misterio
 */
public class TelegramBot extends TelegramLongPollingBot {

  Vertx vertx;
  private final String chat_id = "idchat"; //mudar

  public TelegramBot(Vertx vertx) {
    this.vertx = vertx;

    System.out.println("O meu Bot do Telegram");
  }

  public void sendMessage(String msg) {
    SendMessage message = new SendMessage();
    message.setText(msg);
    message.setChatId(chat_id);
    try {
      execute(message);
    } catch (TelegramApiException e) {
      e.printStackTrace(System.out);
    }
  }

  @Override
  public void onUpdateReceived(Update update) {

    // verifica se existe uma mensagem e se a msg tem texto
    if (update.hasMessage()) {
      // quem enviou a msg
      System.out.print("Mensagem de: ");
      System.out.println(update.getMessage().getFrom().getFirstName() );

      if (update.getMessage().hasText()) {
        String msgRec = update.getMessage().getText();
        System.out.println(msgRec);
      }
    }
  }

  @Override
  public String getBotUsername() {
    return "nome do utilizador bot";
  }

  @Override
  public String getBotToken() {
    return "o token";
  }

}
