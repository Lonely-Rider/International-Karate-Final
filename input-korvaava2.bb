;BlitzPlussaan input -komennon korvaava koodi, koska Locate -komentoa ei ole
;---------------------------------------------------------------------------

;Graphics 800,600,16,2
;
;Global inimi$
;Global ia,ib,ic, iround
;
;
;iround = 0 : ia = 0 : ib = 0 : ic = 0 : inimi$ =""
;While (Not KeyHit(1))
;	Cls
;	omainput(200,100,"Anna nimesi:",8)
;	If KeyDown(28) Then Exit
;	Flip
;Wend

;Text 10,10,inimi$
;Flip
;WaitKey()



Function omainput(ix, iy, in$, ispace)
		pituus = Len(in$)

		Text ix,iy,in$
		id$ =" "
		
		If (iround > 0) Then 
			key = WaitKey()
	
			If (key = 8 And b > 0) Then ;backspace -osio
				ib = ib - 1
				inimi$ = Mid$(inimi$,1,ib)
			Else		
				ia = ia + 13
				ib = ib + 1
				inimi$ = inimi$ + Chr$(key)
			EndIf
		
			;tässä osassa kirjoitetaan ruutuun nimestä kirjaimet, jotka on jo näppäilty
			For ic = 1 To ib
				id$ = Mid$(inimi$,ic,1)
				If (Asc(id$) <> 32) Then
					Text (Len(in$)*ispace) + ix+ic*13,iy,id$
				;	Text 10,10,key
				Else
					ia = ia + 13
				EndIf
			Next
		Else
			iround = 1
		EndIf
End Function
