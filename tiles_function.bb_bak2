
;JUMP_IN_JAPAN  ja TILES -funktiot, eli bonuskentät.
;4.3.08 korjattu
;---------------------------------------------------

Function jump_in_japan_alustus()
	Delay 500
	lento = 0
	ilmaan = 2
	ukon_esto = MilliSecs()
	pelin_hidastus = MilliSecs()
	x = 350
	tf = 0
	rf = 0
	napsis = 0
	naputus2 = MilliSecs()
	naputus = MilliSecs()
	nappuli = MilliSecs()
	nappis = 0
	tf2 = 0
	bonusosumat = 0
	lentopisteet = 0
End Function

Function jump_in_japan()
	If (MilliSecs() > ukon_esto + 100) Then 
		If (bonusmies = 1) Then
			move_keyb()
		Else
			move_keyb2()
		EndIf			
	EndIf

	If (lento = 1) Then
		If (arvo_pyssy > 1) Then			
			If (arvo_suunta = 1) Then;vasemmalle
				If (arvo_pyssy = 2) Then pf = 4
				If (arvo_pyssy = 3) Then pf = 6
				DrawImage weapons,pysx,pysy,pf

				pysx = pysx - 5
				If (pysx < -20) Then ilmaan = 2
			Else;oikealla
				If (arvo_pyssy = 2) Then pf = 5
				If (arvo_pyssy = 3) Then pf = 7
				DrawImage weapons,pysx,pysy,pf

				pysx = pysx + 5
				If (pysx > 830) Then ilmaan = 2
			EndIf
		Else
			If (MilliSecs() > pf_ajastin + 100) Then 
				pf = pf + 1
				pf_ajastin = MilliSecs()
				If (pf > 3) Then pf = 0
			EndIf
			
			If (arvo_suunta = 1) Then;vasemmalle
				DrawImage weapons,pysx,pysy,pf
				pysx = pysx - 5
				If (pysx < -20) Then ilmaan = 2
			Else
				DrawImage weapons,pysx,pysy,pf
				pysx = pysx + 5
				If (pysx > 820) Then ilmaan = 2

			EndIf			
		EndIf
		
	EndIf

	If KeyHit(1) Then End
	If (ilmaan = 2) Then
		arvo_pyssy_aika = MilliSecs() + Rand(300,1500)
		ilmaan = 1
		lento = 0
	EndIf

	If (ilmaan = 1) Then 
		If (MilliSecs() > (arvo_pyssy_aika)) Then ilmaan = 0
	EndIf

	If (lento = 0 And ilmaan = 0) Then
		arvo_pyssy = Rand(3)
		arvo_suunta = Rand(2)
		arvo_korkeus = Rand(3)
		lento = 1
		lentopisteet = lentopisteet + 100
		If (arvo_suunta = 1) Then
			pysx = 830
		Else
			pysx = -20
		EndIf
		If (arvo_korkeus > 2) Then
			pysy = 560
		Else
			pysy = 485
		EndIf
		
		pf_ajastin = MilliSecs()
		pf = 0
	EndIf

	;osuma valkoiseen
	If (ImagesCollide(iskuja,x,y,isku_frame,weapons,pysx,pysy,pf) Or ImagesCollide(ukko,x,y,ukko_frame,weapons,pysx,pysy,pf)) Then
		If ((pysy = 485) And (Not(KeyDown(n_alas)))) Then
			If (osuma = 0) Then bonusosumat = bonusosumat + 1
				osuma = 1
				osuma_timer = MilliSecs() -150
				osuma_frame = 0
				osuma_frame = 6
				osuma_aloitus = 6
			If (bonusosumat = 1) Then
				pisteet1 = pisteet1 + lentopisteet
				siirr = 7
				siirrys = MilliSecs()
			EndIf
		Else If ((pysy = 560) And (isku_frame < 22) Or (isku_frame > 32)) Then
			If (osuma = 0) Then bonusosumat = bonusosumat + 1
				osuma = 1
				osuma_timer = MilliSecs() -150
				osuma_frame = 0
				osuma_frame = 6
				osuma_aloitus = 6
			If (bonusosumat = 1) Then
				pisteet1 = pisteet1 + lentopisteet
				siirr = 7
				siirrys = MilliSecs()
			EndIf
		EndIf
	EndIf

	;osuma punaiseen
	If (ImagesCollide(iskuja2,x2,y2,isku_frame2,weapons,pysx,pysy,pf) Or ImagesCollide(ukko2,x2,y2,ukko_frame2,weapons,pysx,pysy,pf)) Then
		If ((pysy = 485) And (Not(KeyDown(n2_alas)))) Or ((pysy = 560) And (isku_frame2 < 22) Or (isku_frame2 > 32)) Then
		If (osuma2 = 0) Then bonusosumat = bonusosumat + 1
		osuma2 = 1
		osuma2_timer = MilliSecs() -150
		osuma2_frame = 0
		osuma2_frame = 6
		osuma2_aloitus = 6
		If (bonusosumat = 1) Then	;kolme osumaa niin bonus loppuu
			pisteet2 = pisteet2 + lentopisteet
			siirr = 7
			siirrys = MilliSecs()
		EndIf
		EndIf
	EndIf

	If (siirr = 7) Then
		If (MilliSecs() > siirrys + 1000) Then siirr = 5
		Text 250,300,"BONUS POINTS "+lentopisteet
	EndIf

Text 100,100,bonusosumat

	While Not KeyHit(1) ;PELIN HIDASTUSSILMUKKA
		If (MilliSecs() > pelin_hidastus + 20) Then 
			pelin_hidastus = MilliSecs()
			Exit
		EndIf
	Wend
End Function



Function tiles()

	If (MilliSecs() > naputus2 + 2500) Then rf = 1
	If (MilliSecs() > naputus2 + 5000) Then rf = 2

	If ((KeyDown(72) Or KeyDown(17)) And (Not(KeyDown(80) Or KeyDown(45))) And nappu = 0) Then
		nappu = 1	
		nappuli = MilliSecs() - naputus
		naputus = MilliSecs()
	EndIf
	
	If ((KeyDown(80) Or KeyDown(45)) And (Not(KeyDown(72) Or KeyDown(17))) And nappu = 1) Then
		nappu = 0
		nappuli = MilliSecs() - naputus
		naputus = MilliSecs()
	EndIf

	If (KeyDown(57)) Then napsis =  napsis+ 1

	If ((nappis = 0)) Then
		If (((nappuli-200) < 50) And ((nappuli-200) > 0) Or ((nappuli-200) < -0) And ((nappuli-200) > -50)) Then napsis = napsis + 1
	EndIf
	
	If (MilliSecs() > naputus2 + 5000) Then
		If (tf < napsis) Then
			If (tf > 11) Then tf = 11
			If (bonusmies = 1) Then
				DrawImage tiles,350,370,tf
			Else
				DrawImage tiles2,350,370,tf
			EndIf
			DrawImage ready,520,260,2
			
			If (MilliSecs() > napunapu + 200) Then
				tf = tf + 1
				If tf = 12 Then napsis = 12
				napunapu = MilliSecs()
			EndIf
		Else
			If (bonusmies = 1) Then
				DrawImage tiles,350,370,tf
			Else
				DrawImage tiles2,350,370,tf
			EndIf
			Text 250,300,"BONUS POINTS "+napsis*100
			DrawImage ready,520,260,rf
		EndIf
	Else
		If (bonusmies = 1) Then
			DrawImage tiles,350,370,tf
		Else
			DrawImage tiles2,350,370,tf
		EndIf
		DrawImage ready,520,260,rf
		Text 250,300,"KEEP HITTING UP & DOWN"
		Text 250,320,"AS QUICKLY AS YOU CAN"
	EndIf
	nappis = 0
	If (MilliSecs() > naputus2 + 11000) Then	;lopetus, pisteiden lasku
		nollaus()
		boonus = 0
		If (bonusmies = 1) Then
			pisteet1 = pisteet1 + napsis*100
		Else
			pisteet2 = pisteet2 + napsis*100
		EndIf			
		siirr = 5
	EndIf
End Function