package com.juegofinal.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.juegofinal.BaseScreen;
import com.juegofinal.MainGame;

public class screen extends BaseScreen {

    private Stage stage;
    private Jugador jugador;
    private Pinchos pinchos;
    private Texture textureJugador, texturePinchos;
    private TextureRegion regionPinchos;

    public screen(MainGame game) {
        super(game);
        textureJugador = new Texture("player1.png");
        texturePinchos = new Texture("pincho.png");
        regionPinchos = new TextureRegion(texturePinchos, 0, 0, 80, 80);
    }

    @Override
    public void show(){
        stage = new Stage();
        stage.setDebugAll(true);

        jugador = new Jugador(textureJugador);
        pinchos = new Pinchos(regionPinchos);

        stage.addActor(jugador);
        stage.addActor(pinchos);

        jugador.setPosition(20, 100);
        pinchos.setPosition(500, 100);
    }

    @Override
    public void hide(){
        stage.dispose();
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();

        comprobarColisiones();

        stage.draw();
    }

    private void comprobarColisiones(){
        if(jugador.isVivo() && jugador.getX() + jugador.getWidth() > pinchos.getX()){
            System.out.println("colision");
            jugador.setVivo(false);
        }
    }

    @Override
    public void dispose(){
        textureJugador.dispose();
    }

}
