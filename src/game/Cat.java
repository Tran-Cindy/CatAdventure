package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


//extends - it will get all the properties from DynamicBody (extends = inheritance)

/**
 * The character the user plays as.
 */

public class Cat extends Walker {

    //final = only assigned once, value cannot change
    private float walkingSpeed = 3;
    private int lives;
    private int stars;
    boolean facingRight;
    float projectileSpeed = 15;

    //Adding images
    private static final BodyImage Right =  new BodyImage("data/mainCat.png", 4f);
    private static final BodyImage Left =  new BodyImage("data/mainCatLeft.png", 4f);

    private GameLevel level;
    private Game game;

    /**
     * Sets the speed of the player's walk.
     * The speed can change by the player pressing shift to sprint.
     * @param walkingSpeed The speed that the player should walk at.
     */
    public void setWalkingSpeed(float walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
    }


    /**
     * Gets the number of lives the player has.
     * Useful for triggering game over or displaying lives left.
     * @return The number of lives a player has
     */
    public int getLives() {

        return lives;
    }

    /**
     * Used at the beginning of each level to set how many lives the player has.
     * @param lives The number of lives a player has.
     */
    public void setLives(int lives) {

        this.lives = lives;
    }

    /**
     * Sets the number of stars the player has.
     * @param stars
     */
    public void setStars(int stars) {

        this.stars = stars;
    }

    /**
     * Gets the number of stars a player has.
     * @return stars
     */
    public int getStars() {

        return stars;
    }

    /**
     * Used to add stars to the player when a star is collected.
     */
    public void addStars(){

        setStars(getStars()+1);
    }

    //since the cat has ears, hands and legs that are concave shapes, it is split into 2 halves made up of convex shapes
    PolygonShape leftOfCatShape = new PolygonShape(0.15f,-1.91f, -0.7f,-1.93f, -1.4f,-0.74f, -1.44f,1.73f, -0.99f,1.99f, 0.09f,1.67f);
    PolygonShape rightOfCatShape = new PolygonShape(0.12f,-1.91f, 0.71f,-1.89f, 1.42f,-0.65f, 1.41f,1.58f, 0.94f,1.96f, 0.09f,1.67f);

    /**
     * Creates a cat.
     * @param lvl The level that the cat is created in
     * @param g The game that the cat is created in
     */
    public Cat(GameLevel lvl, Game g) {
        super(lvl);

        level = lvl;
        game = g;

        SolidFixture leftOfCat = new SolidFixture(this,leftOfCatShape );
        SolidFixture rightOfCat = new SolidFixture(this,rightOfCatShape );
        this.addImage(Right);

        facingRight = true; //default way the student faces
        lives = 3;
    }

    /**
     * Called when the left key is pressed, changes the image of the cat to one that's facing left & changes the direction of walking.
     */
    public void moveLeft(){
        removeAllImages(); //removes all images from the cat
        addImage(Left);
        startWalking(-walkingSpeed);
        facingRight = false;
    }

    /**
     * Called when the right key is pressed, changes the image of the cat to one that's facing right & changes the direction of walking.
     */
    public void moveRight(){
        removeAllImages();
        addImage(Right);
        startWalking(walkingSpeed);
        facingRight = true;
    }

    /**
     * Called when the s key is pressed, allows the player to shoot out bullets to destroy MovingEnemy and GhostEnemy.
     */
    public void shoot(){
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.4f));

        ProjectileDamage damage = new ProjectileDamage(level, game);
        //registers a listener for collisions
        //When the projectile collides with the GhostEnemy both bodies are notified
        projectile.addCollisionListener(damage);

        //this.getPosition().x+2 so that the projectile does not collide with the student
        //if the projectile collides with the student it will be destroyed
        //setLinearVelocity, the speed along the x-axis
        if (facingRight){
            projectile.addImage(new BodyImage("data/beachball.png", 0.8f));
            projectile.setPosition(new Vec2(this.getPosition().x+2, this.getPosition().y+2));
            projectile.setLinearVelocity(new Vec2(projectileSpeed, 0));
        } else {
            projectile.addImage(new BodyImage("data/beachball.png", 0.8f));
            projectile.setPosition(new Vec2(this.getPosition().x-2, this.getPosition().y+2));
            projectile.setLinearVelocity(new Vec2(-projectileSpeed, 0));
        }

    }

}
