# ColorReplacer
Allows a user to replace colors images based on an approximation. For example, if the user wants to replace green with blue, all shades of green specific to the image (not the green channel) will be replaced with blue. The program differentiates between the green channel and the green in the image using k-means clustering, and assigns new color values using k-nearest neighbor


#Use
The program works by converting one color in an image to another.
You can set the color identity for a pixel by assigning the pixel to a 
color cluster. You cannot manually assign pixels to clusters - you
assign by telling the program how many colors there are in the image. 

#API
public void colorizeImage(int numColors, boolean needsReplacing, Color color1, Color color2);


#

numCLusters is the userprovided number of colors in the image (you can 
create more detailed color differences with a higher numColors, but cannot 
exceed the number of unique colors present in the original image)

#

boolean needsReplacing tells the program that you would like to replace a color.
input of false would just find numCluseters clusters of colors. 

#
Color color1 is the color you want to replace, Color color2 is the color
that needs replacing. Reference the Java api for usage of awt.Color

####Note:
the surrounding code defines input and output files. They can be the same.