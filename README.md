<h1>Junk</h1>
<b>Because it is junk, please expect some disorganization and LOTS of random changes.</b><br>
This is just a repository where I push all my random, spontaneous ideas into. <br>

<h2>Current Stage</h2>
<center>
<img src = "https://31.media.tumblr.com/29af2368d19f7aee5f7eed465bff2162/tumblr_n1fo9pMkzp1rb2wdco1_500.png"/>
</center>

<h2>The Application: Abridged</h2>

<h3>GUI Layers</h3>
GUI layer order: media player > image viewer<br>
In code: JunkMain > JunkMediaPlayer > JunkStackPane<br>
<br>
Note that this is all written using JavaFX. 

<h3>Application Logic</h3>
Application logic: JunkMediaPlayer > JunkMediaController<br>
where the controller is the logic behind the gui for the player.<br>

<h3>'Helper' Classes</h3>
Extra: JunkImage, JunkInjector<br>
JunkImage: A class to help speed up getting the ImageView node from a given image path.<br>
JunkInjector: An interface used to inject other parts of the code without having the need for the implementing class to "know" how they are implemented.<br>
In code: JunkInjector injects the primary stage and the media player into the controller.
