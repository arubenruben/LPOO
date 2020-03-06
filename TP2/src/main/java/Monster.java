import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{

    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#BAEF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public void moveMonster(int height, int width){
        Random random = new Random();
        boolean validPlay=false;

        while (!validPlay){
            //left:0
            //right:1
            //up:2
            //down:3
            int newX=random.nextInt()%4;

            switch (newX){

                case 0:
                    if(!(this.position.getX()-1<=0)){
                        this.position=new Position(this.position.getX()-1,this.position.getY());
                        validPlay=true;
                        break;
                    }
                    break;
                    case 1:
                        if(!(this.position.getX()+1>=width)){
                            this.position=new Position(this.position.getX()+1,this.position.getY());
                            validPlay=true;
                            break;
                        }
                    break;
                    case 2:
                        if(!(this.position.getY()+1>=height)){
                            this.position=new Position(this.position.getX(),this.position.getY()+1);
                            validPlay=true;
                            break;
                        }
                    break;
                    case 3:
                        if(!(this.position.getY()-1<=0)){
                            this.position=new Position(this.position.getX(),this.position.getY()-1);
                            validPlay=true;
                            break;
                        }
                    break;
            }
        }
    }
}
