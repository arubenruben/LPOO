import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero=new Hero(10,10);
        this.walls=createWalls();
        this.coins=createCoins();

    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            int coinX=random.nextInt(width - 2) + 1;
            int coinY=random.nextInt(height - 2) + 1;
            Position positionTemp=new Position(coinX,coinY);

            if(!positionTemp.equals(this.hero.getPosition())){
                for(Coin coin:coins){
                    if(coin.position.equals(positionTemp))
                        continue;
                }
                coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
            }else{
                continue;
            }
        }
        return coins;
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
        if (canHeroMove(position)){
            hero.setPosition(position);
            retrieveCoins();
        }
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() > this.width || position.getY() > this.height || position.getX() < 0 || position.getY() < 0) {
            return false;
        }
        for (Wall wall : this.walls) {
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        this.hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for(Coin coin:coins){
            coin.draw(graphics);
        }
    }

    private void retrieveCoins(){
        List<Coin>auxCoinsList=new ArrayList<>();

        for(Coin coin:coins){

            if(!coin.position.equals(this.hero.getPosition())){
                auxCoinsList.add(coin);
            }
        }
        //Reference update
        this.coins=auxCoinsList;
    }


}
