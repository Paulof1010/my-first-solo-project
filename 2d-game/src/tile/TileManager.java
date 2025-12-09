package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        tiles = new Tile[10];

        getTileImages();
    }

    public void getTileImages() {

        try {
            tiles[0] = new Tile();
            tiles[0].image =
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass.png")));
            tiles[1] = new Tile();
            tiles[1].image =
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wall.png")));
            tiles[2] = new Tile();
            tiles[2].image =
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/water.png")));
            tiles[3] = new Tile();
            tiles[3].image =
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/sand.png")));
            tiles[4] = new Tile();
            tiles[4].image =
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/earth.png")));


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        g2.drawImage(tiles[1].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[1].image, 48, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[1].image, 96, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[1].image, 144, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[1].image, 192, 0, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tiles[1].image, 0, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 48, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 96, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 144, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[1].image, 192, 48, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tiles[1].image, 0, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 48, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 96, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 144, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 192, 96, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tiles[1].image, 0, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 48, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 96, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[0].image, 144, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[1].image, 192, 144, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tiles[1].image, 0, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[2].image, 48, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[2].image, 96, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[2].image, 144, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tiles[1].image, 192, 192, gamePanel.tileSize, gamePanel.tileSize, null);

    }
}
