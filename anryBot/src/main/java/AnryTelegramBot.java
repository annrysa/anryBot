
import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AnryTelegramBot extends TelegramLongPollingBot {

    final static Logger LOG = Logger.getLogger(AnryTelegramBot.class);

    private static final String BOT_USERNAME = "anry0717Bot";
    private static final String BOT_TOKEN = "621426577:AAEroJ3slr-x0JVSTKYdqWYezolEHsxaKko";
    private static final String RESULT_MESSAGE = "Brave new world!";

    //example Start
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();

        try {
            botapi.registerBot(new AnryTelegramBot());
        } catch (TelegramApiException e) {
            LOG.error("Can't start bot");
        }
    }

    //example answer TEXT
    public void sendTextMsg(Message msg, String text) {
        try {
            execute(new SendMessage().setChatId(msg.getChatId()).setText(text));
        } catch (Exception e) {
            LOG.error("Can't send Text message: ", e);
        }
    }

    //example answer GIF
    public void sendGIFMsg(Message msg, String gif) {
        try {
            execute(new SendDocument().setChatId(msg.getChatId()).setDocument(gif));
        } catch (Exception e) {
            LOG.error("Can't send GIF message: ", e);
        }
    }

    //example answer IMAGE
    public void sendImageMsg(Message msg, String image) {
        try {
            execute(new SendPhoto().setChatId(msg.getChatId()).setPhoto(image));
        } catch (Exception e) {
            LOG.error("Can't send Photo message: ", e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendTextMsg(update.getMessage(), RESULT_MESSAGE);
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
