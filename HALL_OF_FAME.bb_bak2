;-----------------------------------

Function hall_of_fame()
;uusi_lista()   ;<-----  t‰st‰ rivist‰ kommentti pois, niin lista tyhjenee
Delay 200:FlushKeys():Delay 200
scoreglobal = scoreglobal + pisteet1
;vyoglobal$ = "yellow belt"	;;N‰m‰ tiedot tulevat oikeasti pelist‰.  <<<<<<<<<<<<<<-----------

x_sj_list = 57
y_sj_list = 0
kierto = 0
lo = 0
iround = 0 : ia = 0 : ib = 0 : ic = 0 : inimi$ =""
;gfxGrab=CreateImage(800,600) 
Delay 500
FlushKeys()

;----------------- p‰‰silmukka --------------
Cls
Text 300,100,"HALL OF FAME!"
Flip
Delay 2000

Local kannet = LoadImage("graphics\lonely rider.jpg")

While (lo < 100)
	SetFont fontti

	lue_lista()
	
	Color 255,255,0
	If (sijoitus_listalla = 60) Then
		x_sj_list = 57+260+260
		y_sj_list = 0
	Else If (sijoitus_listalla = 30) Then
		x_sj_list = 57+260
		y_sj_list = 0
	EndIf
	

	If (pistetaulukko(79) < scoreglobal) Then	;Tarkistetaan onko listan viimeinen parempi kuin
;		Locate x_sj_list,y_sj_list*15+90		;uusi tulos.
		
		;GrabImage gfxGrab,0,0
		
		While (Not KeyHit(1))
			Cls
			;DrawImage gfxgrab,0,0
			DrawImage kannet,50,50
			omainput(x_sj_list-8,paikkanne*15+90-(15),"> ",4)
			If KeyDown(28) Then Exit
			Flip
		Wend
		
		nimiglobal$ = inimi$

		nimiglobal$ = Left$(nimiglobal$,12)	;Lyhennet‰‰n annettu nimi 12:een merkkiin.
	Else
		Exit	
	EndIf

	tarkista_tulos()

	y_sj_list = y_sj_list + 1
	lo = lo + 1
	Cls
;	DrawImage tausta,0,0
	Color 255,255,255
	lue_lista()
	Flip
	While (Not KeyHit(57))
		If KeyHit(1) Then Exit
		If KeyHit(157) Then Exit
	Wend
	Exit
Wend
;--------------------------------------------
End Function


Function tarkista_tulos()
	etsi = 0
	a = 0
	
	While ((etsi <> 1) And (a < 80))
		If (scoreglobal > pistetaulukko(a)) Then		
			etsi = 1
			a = a - 1
		EndIf
		a = a + 1
	Wend
	
	c = 0
	vaihto = 0
	fileout = WriteFile("fame.dat")			;Avataan tiedosto "fame.dat"
	For b = 0 To 79
		If ((b = a) And (vaihto = 0)) Then	;Jos sijoitus on se, joka edell. silmukassa lˆydettiin...
			WriteInt(fileout, scoreglobal)		;pisteet
			WriteString(fileout, nimiglobal$)	;nimi
			WriteString(fileout, vyoglobal$)	;vyˆ
			vaihto = 1
			c = c - 1
		Else
			WriteInt(fileout, pistetaulukko(c))				;pisteet
			WriteString(fileout, nvtaulukko$(c,0));nimi
			WriteString(fileout, nvtaulukko$(c,1));vyˆ
		EndIf
		c = c + 1
	Next
	CloseFile(fileout)				;Suljetaan tiedosto.
End Function


Function lue_lista()
	tekstin_y_sijainti = 90		;TƒSTƒ VOI MUUTTAA MISTƒ KOHTAA Y-SUUNNASSA TEKSTI ALKAA
	sarake = 260				;TƒSTƒ VOI MUUTTAA KUINKA PALJON ON SARAKKEEN VƒLI
	teksti_x = 30				;TƒSTƒ VALITAAN TEKSTIN ALOITUSKOHDAN X-SIJAINTI

	teksti_y = tekstin_y_sijainti
	Text teksti_x+30, teksti_y-20, "Player       Score  Belt Color"

	etsi = 0
	a2 = 0
	a = 0
	nro = 0
	
	filein = ReadFile("fame.dat") 	;Listatiedoston nimi.
	While Not Eof(filein)			;Luetaan tiedostoa kunnes se loppuu.
		pisteet = ReadInt(filein)	;Vuoron per‰‰n luetaan numero,
		nimi$ = ReadString(filein)	;nimi,
		belt$ = ReadString(filein)	;ja vyˆ.

		nvtaulukko(a,0)  = nimi$	;Otetaan tiedostosta nimi ja vyˆn v‰ri nvtaulukkoon
		nvtaulukko(a,1)  = belt$	;ja
		pistetaulukko(a) = pisteet 	;pisteet pistetaulukkoon.


		If ((a2 = 30) Or (a2 = 60)) Then		;Siirryt‰‰n seuraavalle sarakkeelle 30:n v‰lein.
			teksti_x = teksti_x + sarake
			teksti_y = tekstin_y_sijainti
			Text teksti_x+30, teksti_y-20, "Player       Score  Belt Colour"
		EndIf
		
		;t‰ss‰ osiossa ruudulle tulostetaan uusi tulos ja vyˆ, eteen lis‰t‰‰n myˆhemmin nimi - - - -
		If ((kierto = 0) And (etsi = 0) And (scoreglobal > pisteet)) Then
				If (a < 10) Then			;Jos sijoitus on alle 10, lis‰t‰‰n yksi tyhj‰.	
					Text teksti_x, teksti_y, a2+1 +"   ";+nimiglobal$
					Text teksti_x+100,teksti_y, "   "+scoreglobal
					Text teksti_x+150,teksti_y, "   "+vyoglobal$;Kirjoitetaan numero, nimi ja pisteet.
				Else
					Text teksti_x, teksti_y, a2+1 +"  ";+nimiglobal$
					Text teksti_x+100,teksti_y, "   "+scoreglobal
					Text teksti_x+150,teksti_y, "   "+vyoglobal$;Kirjoitetaan numero, nimi ja pisteet.
				EndIf
				etsi = 1
				kierto = 1
				teksti_y = teksti_y + 15		;Lis‰t‰‰n tekstin y-sijaintia.
				sijoitus_listalla = a2
				a2 = a2 + 1

				paikkanne = a2

			If ((a2 = 30) Or (a2 = 60)) Then		;Siirryt‰‰n seuraavalle sarakkeelle 30:n v‰lein.
				teksti_x = teksti_x + sarake
				teksti_y = tekstin_y_sijainti
				Text teksti_x+30, teksti_y-20, "Player       Score  Belt Colour"
			EndIf
		EndIf
		; - - - -

		a2 = a2 + 1					;Lis‰t‰‰n n‰ytett‰v‰‰ sijoitusnumeroa.
		a = a + 1					;Lis‰t‰‰n taulukon sijoitusnumeroa.

	If (a2 < 81) Then
		If (a < 10) Then			;Jos sijoitus on alle 10, lis‰t‰‰n yksi tyhj‰.
			Text teksti_x, teksti_y, a2 +"   "+nimi$
			If (pisteet) Then Text teksti_x+100,teksti_y, "   "+pisteet
			Text teksti_x+150,teksti_y, "   "+belt$;Kirjoitetaan numero, nimi ja pisteet.
		Else
			Text teksti_x, teksti_y, a2 +"  "+nimi$
			If (pisteet) Then Text teksti_x+100,teksti_y, "   "+pisteet
			Text teksti_x+150,teksti_y, "   "+belt$;Kirjoitetaan numero, nimi ja pisteet.
		EndIf
	EndIf

		teksti_y = teksti_y + 15		;Lis‰t‰‰n tekstin y-sijaintia.
	Wend
	CloseFile(filein)				;Suljetaan luettava tiedosto.
	Return
End Function


Function uusi_lista()	;Listan t‰ydellinen nollaus.
	fileout = WriteFile("fame.dat")			;Avataan tiedosto "fame.dat"
	For a = 0 To 79							;Luodaan 80 nime‰ pisteineen.
		b = a + 1
		WriteInt(fileout, 0)				;pisteet
		WriteString(fileout, " ");nimi
		WriteString(fileout, " ")	;vyˆ
	Next
	CloseFile(fileout)				;Suljetaan tiedosto.
End Function