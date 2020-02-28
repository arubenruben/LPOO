import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private Position position;

    Hero(int x, int y){
        this.position=new Position(x,y);
    }
    public void draw(Screen screen){
        screen.setCharacter(this.position.getX(), this.position.getY(), new TextCharacter('X'));
    }
    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getX()-1, position.getY());
    }
    public Position moveRight() {
        return new Position(position.getX()+1, position.getY());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}






