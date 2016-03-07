Graphics 800,600,16
SetBuffer BackBuffer()
SeedRnd MilliSecs()

Global ukko = LoadAnimImage("ik2graphics\walking2.bmp",100,170,0,4)
Global iskuja = LoadAnimImage("ik2graphics\iskuja2.bmp",150,170,0,32)
Global iskuja_ts = LoadAnimImage("ik2graphics\iskuja_ts2.bmp",150,170,0,32)
Global ukko_ts = LoadAnimImage("ik2graphics\walking2_ts.bmp",100,170,0,4)
MaskImage ukko,192,192,192
MaskImage iskuja,192,192,192
MaskImage iskuja_ts,192,192,192
MaskImage ukko_ts,192,192,192

Global nilkka_aani = LoadSound("ankle.wav")
Global mahapotku_aani = LoadSound("side.wav")

Global ukko_frame = 0
Global isku_frame = 0
Global x = 100, y = 337
Global ukko_timer = MilliSecs()
Global hyppy_timer = MilliSecs()
Global liike_timer = MilliSecs()
Global hyppy_alas_timer = MilliSecs()
Global isku = 0
Global ei_mitaan_timer
Global aloitus_timer
Global ottelu_alkaa = 0
Global aani_paalle = 0

Global suunta = 0 ; 0=oikealle, 1=vasemmalle

ei_mitaan_timer = MilliSecs()

Global n_alas = 80
Global n_ylos = 72
Global kavely_vasen = 75
Global kavely_oikea = 77
Global n_vasen = 75 ; 77
Global n_oikea = 77 ; 75
Global n_oala = 79 ; 79
Global n_vala = 81 ; 81
Global n_oyla = 73; 71
Global n_vyla = 71 ; 73
Global n_control = 157

Global lonton = LoadImage("ik2graphics\london_even.bmp")



weapons = LoadAnimImage("ik2graphics\flying_weapon(1).bmp",110,30,0,8)
MaskImage weapons,0,0,255

lento = 0
ilmaan = 2

ukon_esto = MilliSecs()
pelin_hidastus = MilliSecs()
x=350
Include "move_keyb.bb"

While (Not KeyHit(1))
	Cls
	DrawImage lonton,0,0

	If (MilliSecs() > ukon_esto + 100) Then move_keyb()


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
		If (arvo_suunta = 1) Then
			pysx = 830
		Else
			pysx = -20
		EndIf
		If (arvo_korkeus > 2) Then
			pysy = 450
		Else
			pysy = 380
		EndIf
		
		pf_ajastin = MilliSecs()
		pf = 0
	EndIf


	If ImagesCollide(iskuja,x,y,isku_frame,weapons,pysx,pysy,0) Then Text 0,20,"HIT"

	While Not KeyHit(1) ;PELIN HIDASTUSSILMUKKA
		If (MilliSecs() > pelin_hidastus + 20) Then 
			pelin_hidastus = MilliSecs()
			Exit
		EndIf
	Wend



	Flip
Wend



;- ------------------------- -