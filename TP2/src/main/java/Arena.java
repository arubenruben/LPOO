import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class Arena {

    private int width;
    private int height;
    private Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero=new Hero(10,10);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void processKey(KeyStroke key) {

        switch (key.getKeyType()){

            case ArrowUp:
                this.moveHero(hero.moveUp());
                break;

            case ArrowRight:
                this.moveHero(hero.moveRight());
                break;

            case ArrowDown:
                this.moveHero(hero.moveDown());
                break;

            case ArrowLeft:
                this.moveHero(hero.moveLeft());
                break;

            default:

                break;
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        if(position.getX()>this.width||
                position.getY()>this.height
        ){
            return false;
        }else
            return  true;
    }

    public void draw(Screen screen) {
        this.hero.draw(screen);
    }
}
