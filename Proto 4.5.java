int bgRed;
int bgGreen;
int bgBlue;
int bColorRed = 255;
int bColorGreen = 255;
int bColorBlue = 255;
float ballX;
float ballY;
float ballSpeed = 1;
int pPaddleX;
int pPaddleY;
int bSpawnCount;
float pScore;
boolean bMotionX;
boolean bMotionY;

void setup(){ 
  size(900,600);
  fill(bColorRed,bColorGreen,bColorBlue);
  colorGen();
  ballSpawn();
}

void draw(){
  background(bgRed,bgGreen,bgBlue);
  ellipse(ballX,ballY,50,50);
  println("R:" +bgRed+ " G:" + bgGreen+ " B:" +bgBlue+ " S:"+ballSpeed+ " X:" +ballX+ " Y:" +ballY);  //Debug cmd
  
  if(!bMotionX){
    ballX = ballX - ballSpeed;
    if(ballX - 25 <= 0){
      bMotionX = true;
      ballSpeedUp();
      colorGen();
    }
  }else if(bMotionX){
    ballX = ballX + ballSpeed;
    if(ballX + 25 >= 900){
      bMotionX = false;
      ballSpeedUp();
      colorGen();
    }
  }
    
  if(!bMotionY){
    ballY = ballY - ballSpeed;
    if(ballY - 25 <= 0){
      bMotionY = true;
      ballSpeedUp();
      colorGen();
    }
  }else if(bMotionY){
    ballY = ballY + ballSpeed;
    if(ballY + 25 >= 600){
      bMotionY =  false;
      ballSpeedUp();
      colorGen();
    }
  }
}

void colorGen(){
  int seedHold = 0;
  while(seedHold <= 1){
    bgRed = (int) random(0,255);
    bgGreen = (int) random(0,255);
    bgBlue = (int) random(0,255);
    seedHold++;
  }
}

void ballSpawn(){
  int seedHold = 1;
  int xMotion = 0;
  int yMotion = 0;
  
  while(seedHold <= 1){
  ballX = (int) random(375,525);
  ballY = (int) random(225,375);

  xMotion = (int) random(0,2);
  if(xMotion == 1){
     bMotionX = true;
  }
  if(xMotion == 2){
    bMotionX = !bMotionX;
  }
  yMotion = (int) random(0,2);
  if(yMotion == 1){
    bMotionY = true;
  }
  if(yMotion == 2){
    bMotionY = !bMotionY;
  }

  println("Spawn Location was " +ballX+ " and " +ballY+ " and " +bMotionX+ " " +bMotionY);
  seedHold++;
  }
}

void ballSpeedUp(){
  if(ballSpeed < 5){
    ballSpeed = ballSpeed+0.1;
    if(ballSpeed > 5){ //unsure why my float is adding unevenly, so added a check and fixer for if the speed goes above 5.
      ballSpeed = 5; 
    }
  }
}

void pPaddle(){
  rect(mouseX, 10,100,20);

}