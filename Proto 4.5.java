int bgRed;                                //Controlled by colorGen()
int bgGreen;                              //Controlled by colorGen()
int bgBlue;                               //Controlled by colorGen()
int bColorRed = 255;                      //Forces the fill Red value to max. Combined with the other 2, this makes the fill color white.
int bColorGreen = 255;                    //Forces the fill Blue value to max. Combined with the other 2, this makes the fill color white.
int bColorBlue = 255;                     //Forces the fill Green value to max. Combined with the other 2, this makes the fill color white.
int numBreak;                             //Counts how many times our loop has occured. Doubles as a bounce counter.
int loopShow;                             //Holds the external value for our loop method, callLoop().
float ballX;                              //Ball location on the X-Axis.
float ballY;                              //Ball location on the Y-Axis.
float ballSpeed = 1;                      //Ball Speed.
boolean bMotionX;                         //Ball direction, up or down.
boolean bMotionY;                         //Ball direction, left or right.

void setup(){                               //Sets up
  size(900,600);                            //The Screen Size.
  fill(bColorRed,bColorGreen,bColorBlue);   //The ball Color. Intentionally controlled in RGB.
  textSize(24);
  colorGen();                               //Generates a background color to begin with.
  ballSpawn();                              //Generates a location for the ball to spawn at and a direction it will begin to move in.
}

void draw(){                                
  background(bgRed,bgGreen,bgBlue);        //Shows the background color that we have generated.
  text("R:" +bgRed+ " G:" + bgGreen+ " B:" +bgBlue, 10, 20);  //Prints out the current RGB values of the background to the draw window.
  text("Speed:" +ballSpeed, 10, 40);       //Prints out the current ballSpeed value to the draw window.
  text("X:" +ballX, 10, 60);               //Prints out the balls current X position to the draw window.
  text("Y:" +ballY, 10, 80);               //Prints out the balls current Y position to the draw window.
  
  ellipse(ballX,ballY,50,50);              //Draws our ball. Can intentionally go infront of the text to show depth.
  
  if(!bMotionX){                          //Checks the balls X Axis If the balls X motion is false:
    ballX = ballX - ballSpeed;            //It lowers the balls X location (raising it up) by the ballSpeed.
    if(ballX - 25 <= 0){                  //If the ball's X location minus half it's radius is equal or less than 0:
      bMotionX = true;                    //Flips the ball Location to true &
      ballSpeedUp();                      //Increases it's speed,
      colorGen();                         //Generates a new background color
      callLoop();                         //And tells the print loop to occur.
    }
  }else if(bMotionX){                     //If the x motion is not false, then it must be true! And if it's true....
    ballX = ballX + ballSpeed;            //We're increasing the balls X location by our constant ball Speed, thus lowering it's X position.
    if(ballX + 25 >= 900){                //And if it's X position + half it's radius (or rather, it's edge) is equal (or greater) to the bottom of the window....
      bMotionX = false;                   //Flip the ball Location to false &
      ballSpeedUp();                      //Increases the balls speed,
      colorGen();                         //Generates a new background color
      callLoop();                         // And tells the print loop to occur.
    }
  }
    
  if(!bMotionY){                          //If the y motion is false:
    ballY = ballY - ballSpeed;            //It lowers the balls Y location (raising it up) by the ballSpeed.
    if(ballY - 25 <= 0){                  //If the balls Y location - half its radius is equal or less than 0:
      bMotionY = true;                    //Flips the ball Location to true &
      ballSpeedUp();                      //Increases its speed.
      colorGen();                         //Generates a new background color
            callLoop();                   //And tells the print loop to occur.
    }
  }else if(bMotionY){                     //If the Y motion is not false, then it must be true! And if it's true....
    ballY = ballY + ballSpeed;            //We're increasing the balls X location by our constant ball Speed, thus lowering it's Y position.
    if(ballY + 25 >= 600){                //And if it's Y position + half it's radius (or rather, it's edge) is equal (or greater) to the bottom of the window....
      bMotionY =  false;                  //Flip the ball Location to false &
      ballSpeedUp();                      //Increases the balls speed,
      colorGen();                         //Generates a new background color
      callLoop();                         // And tells the print loop to occur.
    }
  }
}

void colorGen(){                          //If this method is called
  int seedHold = 0;                       //it holds a private integer that is set as 0.
  while(seedHold <= 1){                   //and if that integer is 0,
    bgRed = (int) random(0,255);          //If rolls a random number between 0 and 255 for RGB Red...
    bgGreen = (int) random(0,255);        //And RGB Green...
    bgBlue = (int) random(0,255);         //And RGB Blue.
    seedHold++;                           //And increments the integer, which then matches what requirement, so it won't roll anymore, thus stopping the color change.
  }
}

void ballSpawn(){                         //This method is only called once, at setup time.
  int seedHold = 1;                       //Private integer
  int xMotion = 0;                        //A private integer for X motion checking.
  int yMotion = 0;                        //A private integer for Y motion checking.
  
  while(seedHold <= 1){                   //But we enforce that it can only be used once, just incase.
  ballX = (int) random(375,525);          //Sets a random spawning location on the X axis.
  ballY = (int) random(225,375);          //Sets a random spawning location on the Y axis.
                                          //This means that there is a square in the middle of the window that the ball can spawn in, so it's not the same location
                                          //each time the function is called.
  xMotion = (int) random(0,2);            //X motion is assigned a random number of 1 or 2.
  if(xMotion == 1){                       //If it's 1
     bMotionX = true;                     //Then ball Motion will be true, making the ball go up in value, downwards in screen position.
  }
  if(xMotion == 2){                       //But if its 2
    bMotionX = !bMotionX;                 //then the it's false, meaning it raises up.
  }
  yMotion = (int) random(0,2);            //Y motion is assigned a random number of 1 or 2.
  if(yMotion == 1){                       //If it's 1
    bMotionY = true;                      //Then ball motion is be true, making the ball go up in vale, or rightwards in screen position.
  }
  if(yMotion == 2){                       //But if its 2
    bMotionY = !bMotionY;                 //Then the ball motion will be false, making it go leftwards.
  }

  println("Spawn Location was " +ballX+ " and " +ballY+ " and " +bMotionX+ " " +bMotionY); //Debug command. Prints starting position and directions.
  seedHold++;                             //Once all finished up, stops the rolls from occuring again until forcibly called (never happens in this program).
  }
}

void ballSpeedUp(){                      //This method is called when the ball meets the windows edge.
  if(ballSpeed < 5){                     //If the ballSpeed is not exactly 5, then
    ballSpeed = ballSpeed+0.1;           //it increases the float by .1
    if(ballSpeed > 5){                   //unsure why my float is adding unevenly, so added a check and fixer for if the speed goes above 5.
      ballSpeed = 5;                     //And if it had gone above 5, then it forces it back to 5, fixing the bug.
    }
  }
}

void callLoop(){                                    //This method is called each time the ball meets the windows edge.
  for(loopShow = 5; loopShow > 0; loopShow--){      //Decrements the loopShow integer by 1
    println("LoopShow is: "+loopShow);              //And prints the current value.
    for(int nested = 10; nested > 0; nested-=2){    //It then instigates another loop, where a value is decremented by 2.
      println("Nested is: "+nested);                //And prints the current private nested integer value.
    }
  }
  if(loopShow == 0){                                //If loopShow has successfully hit 0 (which can only occur if the nested loop has also worked correctly)
    numBreak++;                                     //it increments the numBreak value by 1
    println("Times triggered: "+numBreak);          //and prints numBreak value. This doubles as to how many times the ball has hit the windows edge.
    }
}