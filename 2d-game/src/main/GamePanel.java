package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS

    final int originalTileSize = 16; // 16x16
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 16x3 = 48, so our screen will be 48x48 pixels
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    //FPS
    int fps = 60;
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread; // Starts our game 'clock', we need to implement 'Runnable' in order to use the Thread class
    Player player = new Player(this, keyHandler);

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // There are two popular game loops: 'Sleep' & 'Delta/Accumulator'. I'll use Delta because it's more accurate.
        // But I'll write the code for the Sleep method too, for learning reasons and leave it commented

                            // DELTA METHOD - Based on System time

        double drawInterval = (double) 1000000000 /fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // Display FPS
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            timer += (currentTime - lastTime); // Display FPS

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta --;
                drawCount++; // Display FPS
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

                            // SLEEP METHOD - Based on Thread.sleep

//        double drawInterval = (double) 1000000000 /fps; // 0.01666s
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while (gameThread != null) {
//
//            long currentTime = System.nanoTime(); // More accurate than milliseconds
//
//            // Because I'll be running in 60FPS, these two methods will be called 60x/second
//
//            // 1 UPDATE: update info such as character positions
//
//            update();
//
//
//            // 2 DRAW: draw the screen with the updated info
//
//            repaint();
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if (remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void update() {

        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g); // g is our 'paint brush'

        Graphics2D g2 = (Graphics2D)g; // For more functionality

        tileManager.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}