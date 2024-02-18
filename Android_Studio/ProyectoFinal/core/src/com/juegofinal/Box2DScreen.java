package com.juegofinal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Box2DScreen extends BaseScreen{

    private World world;
    private Box2DDebugRenderer renderer;
    private OrthographicCamera camera;
    private Body jugadorBody, sueloBody, pinchoBody;
    private Fixture jugadorFixture, sueloFixture, pinchoFixture;
    private boolean debeSaltar, jugadorSaltando, jugadorVivo = true;

    public Box2DScreen(MainGame game) {
        super(game);
    }

    @Override
    public void show(){
        world = new World(new Vector2(0, -10), true); //Gravedad
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(16, 9);
        camera.translate(0, 1);

        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();

                if((fixtureA.getUserData().equals("player") && fixtureB.getUserData().equals("floor")) || (fixtureA.getUserData().equals("floor") && fixtureB.equals("player"))){
                    if(Gdx.input.isTouched()){
                        debeSaltar = true;
                    }
                    jugadorSaltando = false;
                }

                if((fixtureA.getUserData().equals("player") && fixtureB.getUserData().equals("spike")) || (fixtureA.getUserData().equals("spike") && fixtureB.equals("player"))){
                    jugadorVivo = false;
                }
            }

            @Override
            public void endContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();

                if(fixtureA == jugadorFixture && fixtureB == sueloFixture){
                    jugadorSaltando = true;
                }
                if(fixtureA == sueloFixture && fixtureB == jugadorFixture){
                    jugadorSaltando = true;
                }
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });

        jugadorBody = world.createBody(createJugadorDef());
        sueloBody = world.createBody(createSueloDef());
        pinchoBody = world.createBody(createPinchoDef(6f));

        PolygonShape jugadorShape = new PolygonShape();
        jugadorShape.setAsBox(0.5f, 0.5f);
        jugadorFixture = jugadorBody.createFixture(jugadorShape, 3);
        jugadorShape.dispose();

        PolygonShape sueloShape = new PolygonShape();
        sueloShape.setAsBox(500, 1);
        sueloFixture = sueloBody.createFixture(sueloShape, 1);
        sueloShape.dispose();

        pinchoFixture = createPinchoFixture(pinchoBody);

        jugadorFixture.setUserData("player");
        sueloFixture.setUserData("floor");
        pinchoFixture.setUserData("spike");
    }

    private BodyDef createPinchoDef(float x){
        BodyDef def = new BodyDef();
        def.position.set(x, 0.5f);
        return def;
    }

    private BodyDef createSueloDef(){
        BodyDef def = new BodyDef();
        def.position.set(0, -1);
        return def;
    }

    private BodyDef createJugadorDef(){
        BodyDef def = new BodyDef();
        def.position.set(-10, 0);
        def.type = BodyDef.BodyType.DynamicBody;
        return def;
    }

    private Fixture createPinchoFixture(Body pinchoBody){
        Vector2[] vertices = new Vector2[3]; //Crear un triangulo (3 vercites)
        vertices[0] = new Vector2(-0.5f, -0.5f);
        vertices[1] = new Vector2(0.5f, -0.5f);
        vertices[2] = new Vector2(0.5f, 0.5f);

        PolygonShape shape = new PolygonShape();
        shape.set(vertices);
        Fixture fix = pinchoBody.createFixture(shape, 1);
        shape.dispose();
        return fix;
    }
    @Override
    public void dispose(){
        jugadorBody.destroyFixture(jugadorFixture);
        sueloBody.destroyFixture(sueloFixture);
        pinchoBody.destroyFixture(pinchoFixture);
        world.destroyBody(jugadorBody);
        world.destroyBody(sueloBody);
        world.destroyBody(pinchoBody);
        world.dispose();
        renderer.dispose();
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(debeSaltar){
            debeSaltar = false;
            saltar();
        }

        if(Gdx.input.justTouched() && !jugadorSaltando){
            debeSaltar = true;
        }

        if(jugadorVivo){
            float velocidadY = jugadorBody.getLinearVelocity().y;
            jugadorBody.setLinearVelocity(8, velocidadY);
        }


        world.step(delta, 6, 2);

        camera.update();
        renderer.render(world, camera.combined);
    }

    private void saltar(){
        Vector2 position = jugadorBody.getPosition();
        jugadorBody.applyLinearImpulse(0, 20, position.x, position.y, true);
    }

}
