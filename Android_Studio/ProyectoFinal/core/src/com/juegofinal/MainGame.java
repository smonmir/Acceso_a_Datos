package com.juegofinal;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class MainGame extends Game {

	private AssetManager manager;
	public GameScreen gameScreen;
	public GameOverScreen gameOverScreen;
	public MenuScreen menuScreen;
	public CargaScreen cargaScreen;

	public AssetManager getManager() {
		return manager;
	}

	@Override
	public void create(){
		manager = new AssetManager();
		manager.load("floor.png", Texture.class);
		manager.load("overfloor.png", Texture.class);
		manager.load("pincho.png", Texture.class);
		manager.load("player1.png", Texture.class);
		manager.load("gameover.png", Texture.class);
		manager.load("die.ogg", Sound.class);
		manager.load("jump.ogg", Sound.class);
		manager.load("song.ogg", Music.class);
		//manager.finishLoading(); //Detiene la ejecucion del programa hasta que este cargado

		cargaScreen = new CargaScreen(this);
		setScreen(cargaScreen);
	}


	public void finishLoading() {
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		gameOverScreen = new GameOverScreen(this);
		setScreen(menuScreen);
	}


}
