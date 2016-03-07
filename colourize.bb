; Colourize function in BlitzBasic by Bas de Reuver
;
; Many games use the same graphic sprites for different players, only with
; different colours. Good examples are Bomberman, IK+, Ironman Offroad,
; the ghosts in Pac-Man, the bricks in Arkanoid, etc.
;
; i used this colourize trick in E-Motion Deluxe to easily create graphics with
; any colour. Thought it might be usefull to others, so i released this demo. :)
;
; The parts that can have different colours must be pure red, green or blue.
; All other colours are ignored and not changed.
;
; For example pure red is #FF0000 or #800000 or #440000 etc.
; Use the eyedropper-tool in Paint Shop Pro or Photoshop to check your sprites colours.

; ---------------
; -- constants --
; ---------------
Const HEX_DIGITS$ = "0123456789ABCDEF"

; ---------------
; -- constants --
; ---------------
Dim Colours#(2, 2) ; array for holding 3 colours, 3 floats per colour

; ------------------------------------------------------------------------------
; -- update sprites                                                           --
; ------------------------------------------------------------------------------

; --------------------------------------
; -- colourize the image currently    --
; -- in the imagebuffer. Change all   --
; -- pixels that are                  --
; -- pure Red   into Colour(1)        --
; -- pure Green into Colour(2)        --
; -- pure Blue  into Colour(3)        --
; --------------------------------------
Function Colourize(PictureHandle, Frames)
; because there is no function to get frames in image
; the number of frames must be passed as paramter Frames

  For iFrame = 0 To (Frames-1)

    SetBuffer ImageBuffer(PictureHandle, iFrame)
    LockBuffer ImageBuffer(PictureHandle, iFrame)

    For y = 0 To ImageHeight(PictureHandle)
      For x = 0 To ImageWidth(PictureHandle)
        ; get current color
        RGB = ReadPixelFast(x, y)
        If (RGB <> 0) Then
;          tmpRed = (RGB Shr 16) ;works in B2d, but not in B3D
          tmpRed = (RGB And $FF0000) Shr 16 ;<-this is better
          tmpGreen = (RGB And $FF00) Shr 8
          tmpBlue = (RGB And $FF)

          tmpIndex = -1
          ; is it a pure red colour? (only red, no green or blue)
          If (tmpRed > 0) And (tmpGreen = 0) And (tmpBlue = 0) Then
            ; then change this red into Color(0)
            tmpColor = tmpRed
            tmpIndex = 0
          ; is it a pure green colour?
          Else If (tmpRed = 0) And (tmpGreen > 0) And (tmpBlue = 0) Then
            ; then change this green into Color(2)
            tmpColor = tmpGreen
            tmpIndex = 1
          ; is it a pure blue colour?
          Else If (tmpRed = 0) And (tmpGreen = 0) And (tmpBlue > 0) Then
            ; then change this blue into Color(3)
            tmpColor = tmpBlue
            tmpIndex = 2
          End If

          If (tmpIndex <> -1) Then
            tmpRed   = tmpColor * Colours#(tmpIndex, 0)
            tmpGreen = tmpColor * Colours#(tmpIndex, 1)
            tmpBlue  = tmpColor * Colours#(tmpIndex, 2)
            ; colour zero (black) used as transparancy, resulting colour must NOT be black
            If (tmpRed < 8) Then tmpRed = 8
            If (tmpBlue < 8) Then tmpBlue = 8
            If (tmpGreen < 8) Then tmpGreen = 8

            RGB = (tmpRed Shl 16) + (tmpGreen Shl 8) + tmpBlue
            WritePixel(x, y, RGB)
            ; WritePixelFast is very buggy, it sometimes skips pixels when x=0 or y=0
            ;WritePixelFast(x, y, RGB)
          End If

        End If
  
      Next ;x
    Next ;y

    UnlockBuffer ImageBuffer(PictureHandle, iFrame)

  Next ;iFrame

End Function

; --------------------------------------
; -- set values for colourize function--
; --------------------------------------
Function SetColourize(Nr, Red#, Green#, Blue#)

  ; Colours# contains floating points, for example
  ; orange is Colours#(Nr, 0) = 1.00
  ;           Colours#(Nr, 1) = 0.75
  ;           Colours#(Nr, 2) = 0.00

  Colours#(Nr, 0) = Red# / 255
  Colours#(Nr, 1) = Green# / 255
  Colours#(Nr, 2) = Blue# / 255

End Function

; ------------------------------------------------------------------------------
; -- extra functions to interpret HTML-like colour codes                      --
; ------------------------------------------------------------------------------

; --------------------------------------
; -- interpret colour code and set    --
; -- colour.                          --
; -- Nr = colour code, 1 2 or 3       --
; -- example Code$="#08F090"          --
; --------------------------------------
Function SetColourizeCode(Nr, Code$)

  ; initialise
  ColourRed# = -1
  ColourGreen# = -1
  ColourBlue# = -1

  If (Left$(Code$, 1) <> "#") Or (Len(Code$) <> 7) Then
    Code$ = "#??????" ;error
  End If

  Code$ = Right$(Code$, Len(Code$)-1)
  Code$ = Upper$(Code$)

  ; separate string parts for each colour
  Red$ = Left$(Code$, 2)
  Green$ = Mid$(Code$, 3, 2)
  Blue$ = Right$(Code$, 2)

  ; convert colour into decimal value
  ColourRed# = StringHexToDecimal(Red$)
  ColourGreen# = StringHexToDecimal(Green$)
  ColourBlue# = StringHexToDecimal(Blue$)

  ; check if colours are valid
  If (ColourRed = -1) Or (ColourGreen = -1) Or (ColourBlue = -1) Then
    ; one or more invalid colourcodes, make it white
    ColourRed# = 255
    ColourGreen# = 255
    ColourBlue# = 255
  End If

  ; set colour in colourize array
  Colours#(Nr, 0) = ColourRed# / 255
  Colours#(Nr, 1) = ColourGreen# / 255
  Colours#(Nr, 2) = ColourBlue# / 255

End Function

; --------------------------------------
; -- return decimal value of hexstring--
; -- example Input$="A3" returns 163  -- 
; --         Input$="FF" returns 255  -- 
; --         Input$="3E7" returns 999 -- 
; -- errors example "xyz" returns -1  --
; --------------------------------------
Function StringHexToDecimal(HexNumber$)
;funny that that blitzbasic DOES have a Hex$ function but no reverse..

  ; Factor holds the power of 16
  ; example  Hex(ABC) A factor=2, B Factor=1, C Factor=0
  ; A = 10 * 16^2, B = 11 * 16^1, C = 12 * 16^0 (= 12 * 1)
  Factor = 0
  tmpResult = 0

  While (HexNumber$ <> "")
    ;get next character
    strChar$ = Right$(HexNumber$, 1)
    ;remove character from input string
    HexNumber$ = Left$(HexNumber$, Len(HexNumber$)-1)
    ;convert into decimal by look-up in const string
    i = Instr(HEX_DIGITS$, strChar$)
    If (i <> 0) Then
      ; multiply number with (16^Factor) and add to result
      i = i - 1
      tmpResult = tmpResult + i * (16^Factor)
      Factor = Factor + 1
    Else
      ;error, invalid character found
      HexNumber$ = ""
      tmpResult = -1
    End If
  Wend

  Return tmpResult
End Function

;-----------------------------------------------------------------------------------------------------