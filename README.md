<h1>Junk</h1>
This is just a repository where I push all my random, spontaneous ideas into. 

<h2>Breakdown</h2>
Currently, it is an image viewer. How it works:

JunkMain creates the JunkStackPane, which contains default images for a 'slideshow,' and 'plays' through each image using the SequentialTransition. 

JunkStackPane extends StackPane. It stacks the default images, which can be found in /src, from bottom to top. Its playImages() method starts the transition from image to image.

See JunkStackPane class for more detail.
  
