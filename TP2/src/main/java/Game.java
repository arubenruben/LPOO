import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.*;

public class Game {

    private Screen screen=null;
    private Arena arena=null;

   Game(){
       this.arena=new Arena(20,20);

        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            //object type screen controls, controls the panels and then render them
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary
            this.screen.clear();
            this.screen.setCharacter(10, 10, new TextCharacter('X'));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException{
        screen.clear();
        screen.doResizeIfNecessary();
        this.arena.draw(screen.newTextGraphics());
        screen.refresh();

    }
    public void run() throws IOException {

       while(true){
           this.draw();
           KeyStroke key = screen.readInput();
           //Read if it is a q, if so close the window
           if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
               screen.close();
           else if(key.getKeyType()== KeyType.EOF){
               break;
           }
           else {
               try {
                   processKey(key);
               } catch (Exception e) {
                   System.out.println("End");
                   screen.close();
               }
           }
       }

    }
    private void processKey(KeyStroke key) throws Exception {
        this.arena.processKey(key);
    }


}
