/*
Name: Thomas Farrell
Student Number: 20083540
Group: W2/P2
Program Name: Bounce '98

Description:
This little program was designed with the intent of having a feel of looking like the old Windows 98 ball bouncing ScreenSaver.
A ball is spawned in the middle of the window (with some offset, which is produced randomly) and set off in a direction (also random) on a X and Y Axis.
Once the balls edge hits the window edge, 3 things occur:

1) The direction of the ball is reversed, depending on which of the screen edges has been detected. Left and Right reverse X Axis, Top and Bottom reverse Y Axis.

2) The background color of the window is randomly generated. R, G & B roll numbers, minimum of 0 and Max of 255. Each of these combine (obviously) to create a new
  background color.
  
3) A function is called, which begins a looping text process with 3 Layers.
    A)Integer loopShow counts down 1.
    B)For each -1 of loopShow, Integer nested counts down 2.
    C)If loopShow has hit zero, the loop is exited, and prints a line, which is counting the number of times the loops have occured in total. This also doubles in 
    function as showing how many times the screens edge has been hit by the ball.

Bugs:
There's 2 bugs that I'm aware of and have been unable to rectify:

1) If I set the ball/window edge detection to go by width/heigth, the ball sticks to whichever edge it has touched, and triggers all functions constantly while never
   moving away. Worse still, is that it travels along whichever edge it has hit, until it connects with the paralel screen edge, where functions are triggered 
   even faster, and have a chance of completely crashing Processing. (This crashing may be due to lower end hardware, as once I tried to trigger this crash again on 
   my new computer, I was unable to). Because of this issue, I hardcoded the windows edges for my edge detection/bounce triggering.

2) In the method ballSpeedUp() I had to put in a hardcoded limition of 5. Because I wanted to increment the speed by 0.1 each bounce, I had to use a float. After 4/5
   bounces, it would start to increment itself by .11 or .13 etc etc, and NOT our intended .1 . This meant that once it hit, what I had as a limitation of 5, it 
   would always SKIP over 5 and stop incrementing at, for example, 5.1, 5.2, etc etc.
   
   I wanted 5 to be a nice round simple number, so I forced it, so that in the exact moment that it incremented OVER 5, it would see that the number has gone above
   that, and FORCE it back down to 5. My incrementing loop only triggers below 5, and thus never continues anymore achieving our target.
   
External Sources:
  Only 1 external source is used, and that's the random() function. This function can make alot of things extremely fun, and that's a reason why I wanted to implement
  it. Randomization has always been a little interest of mine, so when I thought of the idea of changing the background color for each bounce, I researched it straight
  away. I, ofcourse, asked my tutor if there was a way to do so with Processing, as I'm to understand that Processing has certain limitations. I was pointed to the
  official page for the function. After a little research and some playing around with it, I was able to use it fairly easily.

  Source: https://processing.org/reference/random_.html
*/