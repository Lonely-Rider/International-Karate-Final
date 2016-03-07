
musa=PlayMusic("karate2.mp3")

While Not KeyHit(1)
	If KeyDown(50) Then ChannelVolume musa,.1
Wend