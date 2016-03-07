Function InitialiseGraphics()

  ; load original sprites
  GFXBombermanOrg = LoadAnimImage("iskuja_kok.bmp", SPRITE_WIDTH, SPRITE_HEIGHT, 0, 12)
  MaskImage GFXBombermanOrg,192,192,192

  ; copy original sprites to 10 new sprites-sets
  For i = 0 To 9
    GFXBomberman(i) = CopyImage(GFXBombermanOrg)
  Next

  ; bomberman 1
  SetColourize(0, 228, 228, 228) ; helmet (0) is white
  SetColourize(1,   0, 112, 250) ; body   (1) is blue
  SetColourize(2, 228,  64, 140) ; feet   (2) is purple

  Colourize(GFXBomberman(0), 12)

  ; bomberman 2
  SetColourize(0,  48,  48,  48) ; helmet (0) is dark grey
  SetColourize(1,  48,  48,  48) ; body   (1) is dark grey
  SetColourize(2, 228,  64, 140) ; feet   (2) is purple

  Colourize(GFXBomberman(1), 12)

  ; bomberman 3
  SetColourize(0, 250,  64,   0) ; helmet (0) is red
  SetColourize(1, 250,  64,   0) ; body   (1) is red
  SetColourize(2,  48, 138,  48) ; feet   (2) is green

  Colourize(GFXBomberman(2), 12)

  ; bomberman 4
  SetColourize(0,   0,  80, 250) ; helmet (0) is blue
  SetColourize(1,   0,  80, 250) ; body   (1) is blue
  SetColourize(2, 228,  64, 140) ; feet   (2) is purple

  Colourize(GFXBomberman(3), 12)

  ; bomberman 5
  SetColourize(0,   0, 250,  80) ; helmet (0) is green
  SetColourize(1,   0, 250,  80) ; body   (1) is green
  SetColourize(2, 228,  64, 140) ; feet   (2) is purple

  Colourize(GFXBomberman(4), 12)

  ; custom bomberman colours, test 1
  SetColourize(0, 240, 192,   0) ; helmet (0) is orange
  SetColourize(1, 240, 240,   0) ; body   (1) is yellow
  SetColourize(2, 228,   0,   0) ; feet   (2) is red

  Colourize(GFXBomberman(5), 12)

  ; custom bomberman colours, test 2
  SetColourize(0, 240,  48, 240) ; helmet (0) is purple
  SetColourize(1, 240,   0,   0) ; body   (1) is red
  SetColourize(2, 228,  64, 140) ; feet   (2) is purple

  Colourize(GFXBomberman(6), 12)

  ; custom bomberman colours, test 3
  SetColourize(0,   0, 240, 240) ; helmet (0) is cyan
  SetColourize(1, 240, 240, 240) ; body   (1) is white
  SetColourize(2,  48, 138,  48) ; feet   (2) is green

  Colourize(GFXBomberman(7), 12)

  ; custom bomberman colours, test 4
  SetColourize(0, 250, 250,   0) ; helmet (0) is yellow
  SetColourize(1, 250, 250, 192) ; body   (1) is light yellow
  SetColourize(2, 228,  64, 140) ; feet   (2) is purple

  Colourize(GFXBomberman(8), 12)

  ; custom bomberman colours, test 5
  SetColourize(0,   0, 192, 250) ; helmet (0) is light blue
  SetColourize(1, 250, 192, 250) ; body   (1) is light purple
  SetColourize(2, 228,  64, 140) ; feet   (2) is purple

  Colourize(GFXBomberman(9), 12)


End Function

Function DisplaySprites()

  iFrameDelay = iFrameDelay + 1

  ; after some time change direction
  If (iFrameDelay > 200) Then
    ; reset iFrameDelay
    iFrameDelay = 0
    ; next direction
    iDirection = iDirection + 1
    If (iDirection > 3) Then iDirection = 0
  End If

  ; 'translate' iFrameDelay to iFrame = 0, 1, 2 or 3
  iFrame = (iFrameDelay / 10) Mod 4

  ; walking animation is 0,1,0,2 etc.
  If (iFrame = 2) Then iFrame = 0
  If (iFrame = 3) Then iFrame = 2

  iFrame = (iDirection * 3) + iFrame

  ; display all 'standard colour' bombermen
  For i = 0 To 4
;    DrawImage GFXBomberman(i), 88+(i*32), 100, iFrame
    DrawImage GFXBomberman(i), 188+(i*64), 200, iFrame
  Next

  ; display all 'custom colour test' bombermen
  For i = 0 To 4
;    DrawImage GFXBomberman(5+i), 88+(i*32), 150, iFrame
    DrawImage GFXBomberman(5+i), 188+(i*64), 250, iFrame
  Next

End Function