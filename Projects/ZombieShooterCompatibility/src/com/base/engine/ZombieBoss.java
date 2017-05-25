package com.base.engine;

import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Prottoy on 12/19/2016.
 */
public class ZombieBoss {
    //CHANGE ZOMBIE HEIGHT CHANGE SCALE VARIABLE
    public static final float SCALE = 0.7f;
    public static final float SIZEY = SCALE;
    public static final float SIZEX = (float) ((double) SIZEY / (1.9310344827586206896551724137931 * 1.0));
    ;

    public static final float START = 0;

    public static final float OFFSET_X = 0.05f; //0.05f
    public static final float OFFSET_Y = 0.01f; //0.01f
    public static final float OFFSET_FROM_GROUND = -0.075f; //-0.075f

    public static final float TEX_X_MINIMUM = -OFFSET_X;
    public static final float TEX_X_MAXIMUM = -1 - OFFSET_X;
    public static final float TEX_Y_MINIMUM = -OFFSET_Y;
    public static final float TEX_Y_MAXIMUM = 1 - OFFSET_Y;

    public static final int STATE_IDLE = 0;
    public static final int STATE_CHASE = 1;
    public static final int STATE_ATTACK = 2;
    public static final int STATE_DYING = 3;
    public static final int STATE_DEAD = 4;

    public static final float MOVE_SPEED = 1.0f;
    public static final float MOVEMENT_STOP_DISTANCE = 0.7f;
    public static final float MONSTER_WIDTH = 0.42f;
    public static final float MONSTER_LENGTH = 0.45f;

    public static final float SHOOT_DISTANCE = 1000f;
    public static final float SHOOT_ANGLE = 10.0f;
    public static final float ATTACK_CHANCE = 0.5f;
    public static final int MAX_ZOMBIE_CREEP_HEALTH = 100;
    public static final int ZOMBIE_DAMAGE_MIN = 10;
    public static final int ZOMBIE_DAMAGE_MAX = 30;

    private static Mesh mesh;
    private Material material;
    private Transform transform;
    private Random rand;
    private Random attackrand;
    private boolean canLook;
    private boolean canAttack;
    private int health;
    private int state;
    private double deathTime;
    private static ArrayList<Texture> animations;

    public ZombieBoss(Transform transform) {
        this.transform = transform;
        this.state = STATE_IDLE;
        this.rand = new Random();
        this.canLook = false;
        this.health = MAX_ZOMBIE_CREEP_HEALTH;
        this.canAttack = false;

        //material = new Material(new Texture("zombie.png"));
        if(animations == null)
        {
            animations = new ArrayList<Texture>();
            //Zombie Moving Animation
            animations.add(new Texture("POSSA1.png"));
            animations.add(new Texture("POSSB1.png"));
            animations.add(new Texture("POSSC1.png"));
            animations.add(new Texture("POSSD1.png"));

            //Zombie attacks Animation
            animations.add(new Texture("POSSE1.png"));
            animations.add(new Texture("POSSF1.png"));
            animations.add(new Texture("POSSG1.png"));

            animations.add(new Texture("POSSE1.png"));

            //Death Animation After Getting Shot
            animations.add(new Texture("POSSH0.png"));
            animations.add(new Texture("POSSI0.png"));
            animations.add(new Texture("POSSJ0.png"));
            animations.add(new Texture("POSSL0.png"));

            animations.add(new Texture("POSSM0.png"));
        }
        this.material = new Material(animations.get(0));
        this.deathTime = 0;
        if (mesh == null)
        {
            Vertex[] vertices = new Vertex[]{new Vertex(new Vector3f(-SIZEX, START, START), new Vector2f(TEX_X_MAXIMUM, TEX_Y_MAXIMUM)),
                    new Vertex(new Vector3f(-SIZEX, SIZEY, START), new Vector2f(TEX_X_MAXIMUM, TEX_Y_MINIMUM)),
                    new Vertex(new Vector3f(SIZEX, SIZEY, START), new Vector2f(TEX_X_MINIMUM, TEX_Y_MINIMUM)),
                    new Vertex(new Vector3f(SIZEX, START, START), new Vector2f(TEX_X_MINIMUM, TEX_Y_MAXIMUM))};


            int[] indices = new int[]{
                    0, 1, 2,
                    0, 2, 3,};

            mesh = new Mesh(vertices, indices);
        }

    }

    public Transform getTransform()
    {
        return transform;
    }

    public Vector2f getSize()
    {
        return new Vector2f(MONSTER_WIDTH,MONSTER_LENGTH);
    }

    public void damage(int amount)
    {
        if(state == STATE_IDLE)
            state = STATE_CHASE;

        health -= amount;

        if(health <= 0)
            state = STATE_DYING;
    }

    private void idleUpdate(Vector3f orientation, float distance)
    {
        double time = ((double)Time.getTime())/((double)Time.SECOND);
        double timeDecimals = time - (double)((int)time);

        if(timeDecimals < 0.5)
        {
            canLook = true;
            material.setTexture(animations.get(0));
        }
        else
        {
            material.setTexture(animations.get(1));

            if(canLook)
            {
                Vector2f lineStart = new Vector2f(transform.getTranslation().getX(), transform.getTranslation().getZ());
                Vector2f castDirection = new Vector2f(orientation.getX(), orientation.getZ());
                Vector2f lineEnd = lineStart.add(castDirection.mul(SHOOT_DISTANCE));

                Vector2f collisionVector = Game.getLevel().checkIntersectionsBoss(lineStart, lineEnd, false);

                Vector2f playerIntersectVector = new Vector2f(Transform.getCamera().getPos().getX(), Transform.getCamera().getPos().getZ());

                if(distance <= 4.0f || playerIntersectVector.sub(lineStart).length() < collisionVector.sub(lineStart).length())
                {
                    //System.out.println("SEEN PLAYER");
                    state = STATE_CHASE;
                }

                canLook = false;
            }
        }
    }

    private void chaseUpdate(Vector3f orientation, float distance) {


        double time = ((double)Time.getTime())/((double)Time.SECOND);
        double timeDecimals = time - (double)((int)time);

        if(timeDecimals < 0.25)
            material.setTexture(animations.get(0));
        else if(timeDecimals < 0.5)
            material.setTexture(animations.get(1));
        else if(timeDecimals < 0.75)
            material.setTexture(animations.get(2));
        else
            material.setTexture(animations.get(3));

        this.attackrand = new Random();
        int random = rand.nextInt((4-1)+1)+1;
        boolean attackflag = false;
        if(random == 1 || random == 3)
        {
            attackflag = true;
        }

        /*if(rand.nextDouble() < ATTACK_CHANCE * Time.getDelta())
        {
            attackflag = true;
        }*/

        if (distance > MOVEMENT_STOP_DISTANCE)
        {
            float moveAmount = MOVE_SPEED * (float) Time.getDelta();

            Vector3f oldPos = transform.getTranslation();
            Vector3f newPos = transform.getTranslation().add(orientation.mul(moveAmount));

            Vector3f collisionVector = Game.getLevel().checkCollision(oldPos, newPos, MONSTER_WIDTH , MONSTER_LENGTH);
            Vector3f movementVector = collisionVector.mul(orientation);

            if(movementVector.length() > 0)
            {
                transform.setTranslation(transform.getTranslation().add(movementVector.mul(moveAmount)));
            }
            if(movementVector.sub(orientation).length() != 0)
            {
                Game.getLevel().openDoors(transform.getTranslation(),false);
            }
        }
        else if(attackflag && distance <= MOVEMENT_STOP_DISTANCE){
            state = STATE_ATTACK;
        }
        //System.out.println(Time.getDelta());
    }


    private void attackUpdate(Vector3f orientation, float distance)
    {

        double time = ((double)Time.getTime())/((double)Time.SECOND);
        double timeDecimals = time - (double)((int)time);

        if(timeDecimals < 0.25)
            material.setTexture(animations.get(4));
        else if(timeDecimals < 0.5)
            material.setTexture(animations.get(5));
        else if(timeDecimals < 0.75)
        {
            material.setTexture(animations.get(6));
            if (canAttack)
            {
                //state = STATE_CHASE;
                Vector2f lineStart = new Vector2f(transform.getTranslation().getX(), transform.getTranslation().getZ());
                Vector2f castDirection = new Vector2f(orientation.getX(), orientation.getZ());
                Vector2f lineEnd = lineStart.add(castDirection.mul(SHOOT_DISTANCE));

                Vector2f collisionVector = Game.getLevel().checkIntersectionsBoss(lineStart, lineEnd, true);

                Vector2f playerShotVector = Game.getLevel().lineIntersectRect(lineStart, lineEnd,
                        new Vector2f(Transform.getCamera().getPos().getX(), Transform.getCamera().getPos().getY()), new Vector2f(Player.PLAYER_SIZE, Player.PLAYER_SIZE));
                //System.out.println("distance "+distance);
                if (distance <= MOVEMENT_STOP_DISTANCE) {
                    Game.getLevel().DamagePlayer(rand.nextInt(ZOMBIE_DAMAGE_MAX - ZOMBIE_DAMAGE_MIN) + ZOMBIE_DAMAGE_MIN);
                    //System.out.println("Eating Player");
                    //state = STATE_CHASE;
                }

                canAttack = false;

            }
        }
        else
        {
            material.setTexture(animations.get(5));
            state = STATE_CHASE;
            canAttack = true;
        }
    }

    private void dyingUpdate(Vector3f orientation, float distance)
    {
        double time = ((double)Time.getTime())/((double)Time.SECOND);
        double timeDecimals = time - (double)((int)time);

        if(deathTime == 0)
            deathTime = time;

        final float time1 = 0.1f;
        final float time2 = 0.3f;
        final float time3 = 0.45f;
        final float time4 = 0.6f;

        if(time < deathTime + time1)
        {
            material.setTexture(animations.get(8));
            transform.setScale(1,0.96428571428571428571428571428571f,1);
        }
        else if(time < deathTime + time2)
        {
            material.setTexture(animations.get(9));
            transform.setScale(1.7f,0.9f,1);
        }
        else if(time < deathTime + time3)
        {
            material.setTexture(animations.get(10));
            transform.setScale(1.7f,0.9f,1);
        }
        else if(time < deathTime + time4)
        {
            material.setTexture(animations.get(11));
            transform.setScale(1.7f,0.5f,1);
        }
        else
        {
            state = STATE_DEAD;
        }
    }

    private void deadUpdate(Vector3f orientation, float distance)
    {
        material.setTexture(animations.get(12));
        transform.setScale(1.7586206896551724137931034482759f,0.28571428571428571428571428571429f,1);
    }

    private void alignWithGround()
    {
        transform.getTranslation().setY(OFFSET_FROM_GROUND);
    }

    private void faceTheCamera(Vector3f directionToCamera)
    {
        float ANGLE_TO_FACE_CAMERA = (float)Math.toDegrees(Math.atan(directionToCamera.getZ() / directionToCamera.getX()));

        if(directionToCamera.getX() < 0)
        {
            ANGLE_TO_FACE_CAMERA += 180;
        }
        transform.getRotation().setY(ANGLE_TO_FACE_CAMERA+90);
    }

    public void update()
    {
        Vector3f directionToCamera = Transform.getCamera().getPos().sub(transform.getTranslation());

        float distance = directionToCamera.length();
        Vector3f orientation = directionToCamera.div(distance);

        alignWithGround();
        faceTheCamera(orientation);
        //System.out.println("GRRRRRRRRRRR");
        switch(state)
        {
            case STATE_IDLE:
                idleUpdate(orientation,distance);
                break;
            case STATE_CHASE:
                chaseUpdate(orientation,distance);
                break;
            case STATE_ATTACK:
                attackUpdate(orientation,distance);
                break;
            case STATE_DYING:
                dyingUpdate(orientation,distance);
                break;
            case STATE_DEAD:
                deadUpdate(orientation,distance);
                break;
        }
    }

    public void render()
    {
        Shader shader = Game.getLevel().getShader();
        shader.updateUniforms(transform.getTransformation(), transform.getProjectedTransformation(), material);
        mesh.draw();
    }


}

