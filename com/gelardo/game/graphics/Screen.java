package com.gelardo.game.graphics;

import java.util.Random;

public class Screen {

	private int width;
	private int height;
	public int[] pixels;
	
	private static int tileCount = 64;
	
	public int[] tiles = new int[tileCount*tileCount];
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < tileCount*tileCount; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render() {
		for(int y = 0; y < height; y++) {
			if(y >= height || y < 0) break;
			for(int x = 0; x < width; x++) {
				if(x >= width || x < 0) break;
				int tileIndex = (x >> 4) + (y >> 4) * tileCount;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}
}
