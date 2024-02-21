package com.juegofinal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.juegofinal.entities.Jugador;
import com.juegofinal.entities.Pincho;
import com.juegofinal.entities.Suelo;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends BaseScreen{

    private Stage stage;
    private World world;
    private Jugador jugador;
    private List<Suelo> listaSuelos = new ArrayList<Suelo>();
    private List<Pincho> listaPinchos = new ArrayList<Pincho>();
    private Sound saltoSonido, muerteSonido;
    private Music musica;
    private Vector3 position;

    public GameScreen(MainGame game) {
        super(game);
        saltoSonido = game.getManager().get("jump.ogg");
        muerteSonido = game.getManager().get("die.ogg");
        musica = game.getManager().get("song.ogg");

        stage = new Stage(new FitViewport(1000, 500));
        position = new Vector3(stage.getCamera().position);
        world = new World(new Vector2(0, -10), true); //Agregar gravedad

        world.setContactListener(new ContactListener() {

            private boolean areCollided(Contact contact, Object userA, Object userB){
                Object userDataA = contact.getFixtureA().getUserData();
                Object userDataB = contact.getFixtureB().getUserData();
                if (userDataA == null || userDataB == null) {
                    return false;
                }
                return (userDataA.equals(userA) && userDataB.equals(userB)) ||
                        (userDataA.equals(userB) && userDataB.equals(userA));
            }

            @Override
            public void beginContact(Contact contact) {
                if(areCollided(contact, "jugador", "suelo")){
                    jugador.setSaltando(false);
                    if(Gdx.input.isTouched()){
                        saltoSonido.play();
                        jugador.setDebeSaltar(true);
                    }
                    if(!jugador.isVivo()){
                        musica.stop();
                        muerteSonido.play();
                        stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(new Runnable() {
                            @Override
                            public void run() {
                                game.setScreen(game.gameOverScreen);
                            }
                        })));
                    }
                }
                if(areCollided(contact, "jugador", "pincho")){
                    if(jugador.isVivo()){
                        jugador.setVivo(false);
                        musica.stop();
                        muerteSonido.play();

                        stage.addAction(Actions.sequence(Actions.delay(1.5f), Actions.run(new Runnable() {
                            @Override
                            public void run() {
                                game.setScreen(game.gameOverScreen);
                            }
                        })));
                    }
                }
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
    }


    @Override
    public void show() {
        Texture jugadorTexture = game.getManager().get("player1.png");
        Texture floorTexture = game.getManager().get("overfloor.png");
        Texture overFloorTexture = game.getManager().get("overfloor.png");
        Texture pinchoTexture = game.getManager().get("pincho.png");

        jugador = new Jugador(world, jugadorTexture, new Vector2(1.5f, 1.5f));

        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 0, 1000, 1));//Suelo donde se desplaza el jugador

        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 12, 10, 2));
        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 32, 10, 2));
        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 60, 10, 2));
        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 85, 10, 2));
        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 90, 10, 3));
        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 90, 10, 2));
        listaSuelos.add(new Suelo(world, floorTexture, overFloorTexture, 100, 10, 1));

        listaPinchos.add(new Pincho(world, pinchoTexture, 18, 2));
        listaPinchos.add(new Pincho(world, pinchoTexture, 30, 1));
        listaPinchos.add(new Pincho(world, pinchoTexture, 50, 1));
        listaPinchos.add(new Pincho(world, pinchoTexture, 58, 1));
        listaPinchos.add(new Pincho(world, pinchoTexture, 67, 2));
        listaPinchos.add(new Pincho(world, pinchoTexture, 76, 1));
        listaPinchos.add(new Pincho(world, pinchoTexture, 77, 1));

        stage.addActor(jugador);

        for(Suelo suelo: listaSuelos){
            stage.addActor(suelo);
        }
        for(Pincho pincho: listaPinchos){
            stage.addActor(pincho);
        }

        //Restaurar posicion de la camara
        stage.getCamera().position.set(position);
        stage.getCamera().update();

        musica.setVolume(0.75f);
        musica.play();

    }

    @Override
    public void hide() {
        jugador.detach();
        jugador.remove();

        for(Suelo suelo: listaSuelos){
            suelo.detach();
            suelo.remove();
        }
        for(Pincho pincho: listaPinchos){
            pincho.detach();
            pincho.remove();
        }
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Seguimineto de la camara
        if(jugador.getX() > 150 && jugador.isVivo()){
            stage.getCamera().translate(Constantes.VELOCIDAD_JUGADOR * delta * Constantes.PIXEL_EN_METROS, 0, 0);
        }

        if(Gdx.input.justTouched()){
            jugador.saltar();
        }

        stage.act();
        world.step(delta, 6, 2);
        stage.draw();
    }

    @Override
    public void dispose(){
        stage.dispose();
        world.dispose();
    }
}
