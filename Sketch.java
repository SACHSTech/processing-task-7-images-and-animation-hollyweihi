import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage imgMeteor;
  PImage imgMissile;
  PImage imgBackground;

  float fltMeteorX = -100;
  float fltMeteorY = 0;

  float fltMissileX = 200;
  float fltMissileY = 400 - 50;

  float fltCirX = 100;
  float fltCirY;

  float fltCirSpeedX = 2;
  float fltCirSpeedY = 1;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    imgMeteor = loadImage("Wind.png");
    imgMeteor.resize(imgMeteor.width / 4, imgMeteor.height / 4);

    imgMissile = loadImage("rain-png-transparent-9.png");

    imgBackground = loadImage("Rain Window.jpg");
    imgBackground.resize(width, height);

    fltCirY = height / 10;
  }

  public void draw() {
    background(128);
    image(imgBackground, 0, 0);

    // Draw Meteor and move
    image(imgMeteor, fltMeteorX, fltMeteorY);
    fltMeteorX += 1;

    // Draw circle and move
    ellipse(fltCirX, fltCirY, 20, 20);
    fltCirX += fltCirSpeedX;
    fltCirY += fltCirSpeedY;

    if (fltCirX < 0 + 10 || fltCirX > width - 10) {
      fltCirSpeedX *= -1;
    }

    if (fltCirY < 0 + 10 || fltCirY > height - 10) {
      fltCirSpeedY *= -1;
    }

    // Draw missile and move
    image(imgMissile, fltMissileX, fltMissileY);
    fltMissileY -= 0.5;
  }

  public static void main(String[] args) {
    PApplet.main("Sketch");
  }
}
