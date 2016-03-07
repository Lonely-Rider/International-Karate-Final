
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;27.2.2016 Muokattu Fistist� hits_fist.bb
;IK1-2, 26.11.2008
;		30.11. Tehty valkoinen cpu. Vaihdettu tiedostojen nimet move_cpu_green.bb jne, v�rin mukaan.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

AppTitle "INTERNATIONAL KARATE 1-2, HAS ARRIVED AND IT�S HERE TO STAY 4 EVER, 2008!"
Graphics 800,600,32,2

SetBuffer BackBuffer()
SeedRnd MilliSecs()


;tuloslistaan
Global a = 0, vali = 0, uuden_paikka
Global listan_pituus = 20 		; listan pituus
Dim tulokset(listan_pituus+1,1)	; taulukko, johon tulokset
Dim nimet$(listan_pituus+1,2)		; taulukko, johon nimet luetaan
Global tallenna_uusi
Global lista$ = "fame.dat"
Global uusi_tulos
;-----------
Dim credit$(57);lopputekstin pituus
Global x_reuna_a = 700
Global x_reuna_b = 0

Global valo_paalle2 = 0
Global valo_paalle3 = 0
Global nulltimer = MilliSecs()
Global nulltimer2 = MilliSecs()
Global aani_paalle3 = 0
Global cpu_vai_ei = 10
;-
;Global fisu = LoadAnimImage("fish_jumping2.png",160,240,0,8)
Global ukko = LoadAnimImage("graphics\walking2.png",100,170,0,4)
Global iskuja = LoadAnimImage("graphics\iskuja2.png",150,170,0,32)
Global iskuja_ts = LoadAnimImage("graphics\iskuja_ts2.png",150,170,0,32)
Global ukko_ts = LoadAnimImage("graphics\walking2_ts.png",100,170,0,4)
Global ukko2 = LoadAnimImage("graphics\walking22.png",100,170,0,4)
Global iskuja2 = LoadAnimImage("graphics\iskuja22.png",150,170,0,32)
Global iskuja_ts2 = LoadAnimImage("graphics\iskuja_ts22.png",150,170,0,32)
Global ukko_ts2 = LoadAnimImage("graphics\walking_ts22.png",100,170,0,4)
Global aloitus2 = LoadAnimImage("graphics\aloitus2.png",100,170,0,2)
Global aloitus = LoadAnimImage("graphics\aloitus.png",100,170,0,2)
Global aloitus3 = LoadAnimImage("graphics\aloitus3.png",100,170,0,2)
Global aloitus3b = LoadAnimImage("graphics\aloitus3b.png",100,170,0,2)
MaskImage aloitus,192,192,192
MaskImage aloitus2,192,192,192
MaskImage aloitus3,0,0,255
MaskImage aloitus3b,0,0,255
Global ukko3 = LoadAnimImage("graphics\walking33.png",100,170,0,4)
Global iskuja3 = LoadAnimImage("graphics\iskuja33.png",150,170,0,32)
Global iskuja_ts3 = LoadAnimImage("graphics\iskuja_ts33.png",150,170,0,32)
Global ukko_ts3 = LoadAnimImage("graphics\walking_ts33.png",100,170,0,4)
MaskImage ukko3,192,192,192
MaskImage iskuja3,192,192,192
MaskImage iskuja_ts3,192,192,192
MaskImage ukko_ts3,192,192,192
Global osuma2_aloitus = 0
Global osuma_aloitus = 0
Global fontti = LoadFont("Arial",18,True,False,False)
SetFont fontti
Dim nvtaulukko$(80,1) ;nimi&v�ri -taulukko, 0=nimi, 1=v�ri;			HALL OF FAMEEN
Dim pistetaulukko(80) ;pistetaulukko

MaskImage ukko,192,192,192
MaskImage ukko_ts,192,192,192
MaskImage iskuja,192,192,192
MaskImage iskuja_ts,192,192,192
MaskImage ukko2,192,192,192
MaskImage ukko_ts2,192,192,192
MaskImage iskuja2,192,192,192
MaskImage iskuja_ts2,192,192,192
Global nilkka_aani = LoadSound("ankle.mp3")
Global mahapotku_aani = LoadSound("side.mp3")
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
Global n2_alas = 45
Global n2_ylos = 17
Global n2_vasen = 30
Global n2_oikea = 32
Global n2_vala = 46
Global n2_oala = 44
Global n2_oyla = 16
Global n2_vyla = 18
Global n2_control = 29
Global kavely_vasen2 = 30
Global kavely_oikea2 = 32
Global ei_mitaan_timer2 = MilliSecs()
Global suunta2 = 0 ; 0=oikealle, 1=vasemmalle
Global isku2 = 0
Global aani_paalle2 = 0
Global ukko_frame2 = 0
Global isku_frame2 = 0
Global x2 = 500, y2 = 337
Global ukko_timer2 = MilliSecs()
Global hyppy_timer2 = MilliSecs()
Global hyppy_timer3 = MilliSecs()
Global liike_timer2 = MilliSecs()
Global hyppy_alas_timer2 = MilliSecs()
Global hyppy_alas_timer3 = MilliSecs()
Global osuu = 0
Global osuu2 = 0
Global osu_xf = 50, osu_xh = 90
Global osu_xfs = 20, osu_xhs = 60
Global osu_xf2 = 50, osu_xh2 = 90
Global osu_xfs2 = 20, osu_xhs2 = 60
Global lights, lights2, lights3
Global valo = LoadImage("graphics\valo.png")
MaskImage valo,0,0,0
Global valo_pois = LoadImage("graphics\valo_pois.png")
MaskImage valo_pois,0,0,0
Global valo_paalle = 0
Global alas_nollaus = 0
Global alas_nollaus2 = 0
Global osuma2 = 0
Global osuma = 0
Global osuma2_timer = MilliSecs()
Global osuma_timer = MilliSecs()
Global osuma2_frame = 0
Global osuma_frame = 0
Global osumat2 = LoadAnimImage("graphics\kaatuminen_2.png",150,120,0,18)
Global osumat = LoadAnimImage("graphics\kaatuminen_1.png",150,120,0,18)
Global osumat3 = LoadAnimImage("graphics\kaatuminen_3.png",150,120,0,18)
MaskImage osumat2,0,0,255
MaskImage osumat,0,0,255
MaskImage osumat3,0,0,255
Global raja = LoadImage("graphics\raja.png")
Global suunnat2
Global suunnat
Global stars_frame = 0

Global stars_frame_timer = MilliSecs()

Global stars = LoadAnimImage("graphics\stars.png",50,20,0,3)
MaskImage stars, 0,0,255

Global drop_number=50
Type drop
         Field x,y
         Field angle,col
End Type

;hall of fameen
;Global scoreglobal
;Global x_sj_list = 57
;Global y_sj_list = 0
;Global kierto = 0
;Global lo = 0
;Global nimiglobal$
;Global etsi
;Global paikkanne
Const SPRITE_WIDTH = 150;16
Const SPRITE_HEIGHT = 170;28
Const SCREEN_X = 640;320
Const SCREEN_Y = 480;240
Global GFXBombermanOrg ; original sprites
Dim GFXBomberman(10) ; 10 colours, 12 sprites per colour
Global iDirection ;0=up, 1=down, 2=left, 3=right
Global iFrameDelay
Include "colourize.bb"
Include "demo_2.bb"

;Include "move_pad.bb"
Include "move_keyb6.bb"
Include "move_cpu6.bb"
Include "move_cpu6c.bb"
Include "move_cpu_white.bb"
Include "move_keyb6_2.bb"
Include "hits_fist.bb"
;Include "tuloslista.bb"
Include "musa_functions.bb"
Include "tiles_function.bb"
Global scoreglobal
;scoren liitt�minen
Include "hall_of_fame.bb"
Include "input-korvaava2.bb"
Global inimi$
Global ia,ib,ic, iround


Global cpu_timer = MilliSecs()
Global kavely_oikea_cpu = 2
Global kavely_vasen_cpu = 3
Global n_alas_cpu = 4
Global n_ylos_cpu = 5
Global n_vasen_cpu = 6 ; 77
Global n_oikea_cpu = 7 ; 75
Global n_oala_cpu = 8; 79
Global n_vala_cpu = 9 ; 81
Global n_oyla_cpu = 10; 71
Global n_vyla_cpu = 11 ; 73
Global n_control_cpu = 20
Global hyppy_timer_cpu
;---------- CPU 2
Global act2, act4
Global actor2
Global cpu_timer2 = MilliSecs()
Global actwalk2
Global abcde2
Global hyppy_timer_cpu2
Global null_timer2
Global pick_the_man2 = 0, pick2 = MilliSecs(), pause2

Global pisteet1 = 0
Global pisteet2 = 0
Global pisteet3 = 0, p3, p, p2
Global act, act3
Global isku3 = 0
Global isku3_frame = 0
Global ukko3_frame = 0
;---uudet globaalit
Global x3 = 300
Global suunta_c = 0
Global actor = 0
Global abcde, pause, aa, pick_the_man = 0, pick = MilliSecs(), actwalk = 0
Global siirr = 1, siirrys
Global sekunnit, level
Global osuma3 = 0
Global osuma3_timer = MilliSecs()
Global osuma3_frame = 0
Global osuma3_aloitus
Global osuu3 = 0
Global suunnat3
Global alas_nollaus3 = 0
Global osu_xf3 = 50, osu_xh3 = 90
Global osu_xfs3 = 20, osu_xhs3 = 60
Global y3 = 337
Global kello
Global ukko_timer33 = MilliSecs() ;vihre�n ajastus

Global kentan_vaihto
Global inter=LoadImage("graphics\international.png")
;Global inca = LoadImage("graphics\inca_temple.png")
Global pyhatto = LoadImage("graphics\temple.png")
Global timer = MilliSecs()
Global freimi = 0
;Global vuori = LoadAnimImage("graphics\vuori.png",300,40,0,2)
Global freimi2 = 0
Global timer2 = MilliSecs()
Global timer5 = MilliSecs()
Global timer8 = MilliSecs()
Global timer9 = MilliSecs()
Global timer10 = MilliSecs()
Global timer11 = MilliSecs()
Global timer12 = MilliSecs()
Global timer13 = MilliSecs()
Global timer14 = MilliSecs()
Global timer15 = MilliSecs()
Global timer16 = MilliSecs()
Global timer17 = MilliSecs()
Global timer18 = MilliSecs()
Global timer19 = MilliSecs()
Global timer20 = MilliSecs()
Global arvonta
Global arvonta2
Global cloud=LoadAnimImage("graphics\cloud.png",90,46,0,3)
Global cloud2 = LoadImage("graphics\cloud2.png")
Global cloud3 = LoadImage("graphics\cloud3.png")
Global cloud4 = LoadImage("graphics\cloud4.png")
Global cloud5 = LoadImage("graphics\cloud5.png")
Global valot1 = LoadImage("graphics\lights 1.png")
MaskImage valot1,0,0,255
Global valot2 = LoadImage("graphics\lights 2.png")
MaskImage valot2,0,0,255
Global valot3 = LoadImage("graphics\lights 3.png")
MaskImage valot3,0,0,255
Global valot4 = LoadImage("graphics\lights 4.png")
MaskImage valot4,0,0,255
Global valot5 = LoadImage("graphics\lights 5.png")
MaskImage valot5,0,0,255
Global lonton = LoadImage("graphics\london_day.png")
Global lonton2 = LoadImage("graphics\london_even.png")
Global lonton3 = LoadImage("graphics\london_night.png")
Global lonton4 = LoadImage("graphics\london_morning.png")
Global cloud6 = LoadImage("graphics\cloud6.png")
Global cloud7 = LoadImage("graphics\cloud7.png")
Global cloud8 = LoadImage("graphics\cloud8.png")
Global cloud9 = LoadImage("graphics\cloud9.png")
Global cloud10 = LoadImage("graphics\cloud10.png")
Global Bigben = LoadImage("graphics\bigben2.png")
Global smoke = LoadImage("graphics\smokepipe.png")
Global tree = LoadImage("graphics\tree.png")
Global church = LoadImage("graphics\church.png")
Global peek = LoadImage("graphics\peek.png")
Global torni = LoadAnimImage("graphics\torni.png",11,14,0,2)
MaskImage torni,124,112,218
Global cloud11=LoadImage("graphics\cloud11.png")
Global cloud12=LoadImage("graphics\cloud12.png")
Global cloud13=LoadImage("graphics\cloud13.png")
Global cloud14=LoadImage("graphics\cloud14.png")
Global cloud15=LoadImage("graphics\cloud15.png")
Global cloud16=LoadImage("graphics\cloud16.png")
Global cloud17=LoadImage("graphics\cloud17.png")
Global cloud18=LoadImage("graphics\cloud18.png")
Global cloud19=LoadImage("graphics\cloud19.png")
Global cloud20=LoadImage("graphics\cloud20.png")
Global york=LoadImage("graphics\new york_morning.png")
Global york2=LoadImage("graphics\new york_day.png")
Global york3=LoadImage("graphics\new york_even.png")
Global york4=LoadImage("graphics\new york_night.png")
Global pausetus = MilliSecs()
Global pauset = 0
MaskImage peek,0,0,0
MaskImage bigben,0,0,0
MaskImage church,0,0,0
MaskImage tree,0,0,0
Global timer3 = MilliSecs()
Global freimi3 = 3
Global laineet = LoadAnimImage("graphics\laine.png",40,40,0,5)
Delay 500
ei_mitaan_timer = MilliSecs()
ei_mitaan_timer2 = MilliSecs()
ei_mitaan_timer3 = MilliSecs()

Global wall = LoadImage("graphics\chinese wall.png")
;aallot
Global aallot = LoadAnimImage("graphics\aallot.png",30,30,0,6)
MaskImage aallot,0,0,0
;Global lippu_ajastin = MilliSecs()
Global aallot2 = LoadAnimImage("graphics\aallot2.png",30,30,0,6)
MaskImage aallot,0,0,0

Global spider = LoadAnimImage("graphics\spideranim.png",20,37,0,6)
MaskImage spider,255,255,255

Global spider2 = LoadAnimImage("graphics\spider2.png",20,50,0,15)
MaskImage spider2,255,255,255
Global lintu = LoadAnimImage("graphics\lokki.png",26,24,0,3)
MaskImage lintu,0,0,255
Global eagle = LoadAnimImage("graphics\eagle.png",26,24,0,3)
MaskImage eagle,0,0,255
Global kuva_arvo = 0
;-------------------------------------------------------------------------------------IHAN P�� VALIKKO
FlushKeys()
Cls
DrawImage inter,0,0
Flip
While (Not KeyHit (59))
	If (KeyHit(59)) Then Delay 200: FlushKeys() : Goto karate1
	If (KeyHit(60)) Then Delay 200: FlushKeys() : Goto karate2
   If KeyHit(1) Then End
Wend
;-----------------------------------------------------------------------------------------------------

placedrops();sijoitetaan sadepisarat ruutuun
musa=PlayMusic("karate2.mp3")
valo_numero = 0

.karate1
;-----------------------------------------------------------------------------------------------SYDNEY
sydney = LoadImage("graphics\Sydney_l.png")
australia=LoadImage("graphics\sydney_morning.png")
australia2=LoadImage("graphics\sydney_day.png")
australia3=LoadImage("graphics\sydney_even.png")
australia4=LoadImage("graphics\sydney_night.png")
MaskImage australia,100,100,10
slight = LoadImage("graphics\sydney_light1.png")
MaskImage slight,120,112,216
slight2 = LoadImage("graphics\sydney_light2.png")
MaskImage slight2,120,112,216
slight3 = LoadImage("graphics\sydney_light3.png")
MaskImage slight3,120,112,216
startwinter = LoadImage("graphics\sydney_lumi.png")
;chnbackground=PlaySound(oriental)
Cls
Text 380,300,"LOADING...."
Flip
ottelu_alkaa = 0
arvotaan_musa=Rand(1,7)
sydney_valot = 1
kentta1 = 1
ChannelVolume chnbackground,1
arvonta = Rand(0,7)
musan_arvonta()

kohinamusa = PlayMusic("biisi2.xm")

;______________________________________________________________________________________________________
While (lopetus = 0)
		ottelu_alkaa = 0
		sekunnit = 60
		x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437
        ;Sydney
	    sataako = Rand(2)
        vesilumi = Rand(1)
		aloitus_timer = MilliSecs()

        While ((Not KeyHit(1)))
                Cls
			If pictures_opt = 0 Then
                Select arvonta
                Case 1
                        DrawImage australia,0,0
                Case 2
                        DrawImage australia2,0,0
                Case 3
                        DrawImage australia3,0,0
                Case 4
                        DrawImage australia4,0,0
                Default
                     DrawImage australia4,0,0 
				End Select
				
				Select sydney_valot
                Case 1
                        DrawImage slight,0,65
                Case 2
                        DrawImage slight2,0,65
                Case 3
                        DrawImage slight3,0,65
                Default
                        DrawImage slight,0,65
                End Select

	  		    If (MilliSecs() > timer5 + 2000) Then
					sydney_valot = sydney_valot + 1
					If (sydney_valot = 4) Then sydney_valot = 1
					timer5 = MilliSecs()
				EndIf
				
				;If (MilliSecs() < (salama_ajastin2 + 500)) Then
				;	If (vesilumi = 1) Then
				;		If (MilliSecs() > salama_ajastin + 100)
				;			salama_ajastin = MilliSecs()
				;			DrawImage startwinter,0,0		
				;		EndIf
				;	EndIf
				;EndIf
				
				;If (MilliSecs() > (aani_timer + 5000 + aani_tauko)) ;Jos on kulunut tietty 
															   		;aika, niin soitetaan
	                
       			;EndIf
	
				
                Color 255,0,0
		        Text 440,-2,"Sydney",True

        DrawImage lintu, lintu_x, 70,lintu_freimi
        If (MilliSecs() > timer_bird + 31) Then
                lintu_x = lintu_x + 1
                timer_bird = MilliSecs()
                If (lintu_x > 800) Then lintu_x = 0
        EndIf
        If (MilliSecs() > lintu_timer + 300) Then
                lintu_freimi = lintu_freimi + 1
                If (lintu_freimi = 3) Then lintu_freimi = 0
                lintu_timer = MilliSecs()
        EndIf

        If (MilliSecs() > (aani_timer + 5000 + aani_tauko))        ;Jos on kulunut tietty aika, niin soitetaan
                ;chnbackground2 = PlaySound (seagull)                ;��ni. Tauon m��r�� 1500ms + aani_tauko, joka
                aani_timer = MilliSecs()                        ;arvotaan
                aani_tauko = Rand(3000,5000)                        ;t�ss�.
        EndIf
				
		If (MilliSecs() > (aani_timer2 + 7000 + aani_tauko2))        ;Jos on kulunut tietty aika, niin soitetaan
                ;chnbackground28 = PlaySound (lokit)                 ;��ni. Tauon m��r�� 1500ms + aani_tauko, joka
                aani_timer2 = MilliSecs()                       	 ;arvotaan
                aani_tauko2 = Rand(6000,7000)                        ;t�ss�.
        EndIf
	Else
		Cls
		DrawImage wall,0,0
		Color 255,0,0
		Text 365,570,"Chinese Wall",True
	EndIf

		THE_MAIN_LOOP()
		
        If (sataako = 1) Then update()
        
		Flip

        If (KeyHit(1)) Then
			lopputekstit()
			End
		EndIf

		If (MilliSecs() > musan_ajastin) Then 
			musan_arvonta()
			PlaySound(musa2)
		EndIf
			If (seur = 1) Then Exit
        Wend

;---------------------------------------------------------------------------------------------NEW YORK
NewY=LoadImage("graphics\new york.png")
NewY1=LoadImage("graphics\new york_morning.png")
NewY2=LoadImage("graphics\new york_day.png")
NewY3=LoadImage("graphics\new york_even.png")
NewY4=LoadImage("graphics\new york_night.png")
MaskImage newY2,0,80,255
valot6 = LoadImage("graphics\lights_(1).png")
MaskImage valot6,0,0,255
valot7 = LoadImage("graphics\lights_(2).png")
MaskImage valot7,0,0,255
valot8 = LoadImage("graphics\lights_(3).png")
MaskImage valot8,0,0,255
valot9 = LoadImage("graphics\lights_(4).png")
MaskImage valot9,0,0,255
valot10 = LoadImage("graphics\lights_(5).png")
MaskImage valot10,0,0,255

seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
star = LoadImage("graphics\star.png")
tahti_ajastin = MilliSecs()
tahti_aika = 1000
tahti = 0
tahti2_ajastin = MilliSecs()
tahti2_aika = 3000
tahti2 = 0
tahti3_ajastin = MilliSecs()
tahti3_aika = 1500
tahti3 = 0
arvo_salama_ajastin = MilliSecs()
salama_ajastin = MilliSecs()
salama1 = LoadSound ("ik+ koodi\lightning.mp3")
salama2 = LoadSound ("ik+ koodi\lightning2.mp3")
aloitus_timer = MilliSecs()
x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437

        ;New York
        sekunnit = 60
        timer3=MilliSecs()
        timer61=MilliSecs()
        timer5=MilliSecs()
        timer10=MilliSecs()
        timer11=MilliSecs()
        timer12=MilliSecs()
        timer13=MilliSecs()
        timer14=MilliSecs()
        frame = 1
        arvonta = Rand(5)
	    sataako = Rand(2)
        vesilumi = Rand(0,1)
        frame_liekki = 0
        liekki = LoadAnimImage("graphics\liekki.png",30,24,0,3)
        MaskImage liekki,0,0,255
        Local lumi = LoadImage("graphics\lumi2.png")
        MaskImage lumi,4,55,63
		
		aalto_ajastin = MilliSecs()
		freimi_aalto = 0

		While ((Not KeyHit (1)))
		Cls
		
		If (pictures_opt = 0) Then
		        Select arvonta
                Case 1
                        DrawImage NewY1,0,10;new york_morning
                Case 2
                        DrawImage NewY2,0,10;new york_day
                Case 3
                        DrawImage NewY3,0,10;new york_even
                Case 4
		                DrawImage NewY4,0,10;Y�
                Default
                        DrawImage NewY,0,10;new york.png
                End Select

				If (arvonta = 4) Then
					If (tahti = 0) Then
						DrawImage star,49,124
					EndIf
					If (tahti2 = 0) Then
						DrawImage star,350,90
					EndIf
					If (tahti3 = 0) Then
						DrawImage star,650,110
					EndIf
				EndIf

        If (MilliSecs() > tahti_ajastin + tahti_aika) Then
			If (tahti = 0) Then
				tahti = 1
			Else
				tahti = 0
			EndIf
			
			tahti_ajastin = MilliSecs()
			tahti_aika = Rnd(500,5000)			
        EndIf
        If (MilliSecs() > tahti2_ajastin + tahti2_aika) Then
			If (tahti2 = 0) Then
				tahti2 = 1
			Else
				tahti2 = 0
			EndIf
			
			tahti2_ajastin = MilliSecs()
			tahti2_aika = Rnd(500,5000)			
        EndIf
        If (MilliSecs() > tahti3_ajastin + tahti3_aika) Then
			If (tahti3 = 0) Then
				tahti3 = 1
			Else
				tahti3 = 0
			EndIf
			
			tahti3_ajastin = MilliSecs()
			tahti3_aika = Rnd(500,5000)			
        EndIf

        If (MilliSecs() > timer5 + 1000) Then
                If frame = 0  Then
                        frame = 1
                Else
                        frame = 0
                EndIf
                timer5 = MilliSecs()
        EndIf

        DrawImage cloud9,pilvi_x3,90
        DrawImage cloud11,pilvi_x4,80

                If (freimi3 = 0 And (MilliSecs() > timer60 + aika)) Then
                        freimi3 = Rand(1,2)
                        timer60= MilliSecs()
                EndIf

                If (freimi3 <> 0 And (MilliSecs() > timer70 + 100)) Then
                        freimi3 = 0
                        timer70 = MilliSecs()
                        aika = Rand(500,5000)
                EndIf

                If (MilliSecs() > timer60 + 60) Then
                        pilvi_x3 = pilvi_x3 + 1
                        timer60 = MilliSecs()
                        If (pilvi_x3 > 730) Then pilvi_x3 = 0
                EndIf
                If (MilliSecs() > timer70 + 30) Then
                        pilvi_x4 = pilvi_x4 + 1
                        timer70 = MilliSecs()
                        If (pilvi_x4 > 730) Then pilvi_x4 = 0
                EndIf

        ;DrawImage valkolintu, lintu_x, 70,lintu_freimi
        ;If (MilliSecs() > timer_bird + 31) Then
         ;       lintu_x = lintu_x + 1
          ;      timer_bird = MilliSecs()
           ;     If (lintu_x > 800) Then lintu_x = 0
        ;EndIf
        If (MilliSecs() > lintu_timer + 300) Then
                lintu_freimi = lintu_freimi + 1
                If (lintu_freimi = 3) Then lintu_freimi = 0
                lintu_timer = MilliSecs()
        EndIf

		;DrawImage valkolintu, lintu_x, 95, lintu_freimi
		;DrawImage valkolintu, lintu_x+36, 105, lintu_freimi
		
		;If (MilliSecs() > (aani_timer2 + 7000 + aani_tauko2))        ;Jos on kulunut tietty aika, niin soitetaan
                ;chnbackground28 = PlaySound (lokit)                ;��ni. Tauon m��r�� 1500ms + aani_tauko, joka
         ;       aani_timer2 = MilliSecs()                       ;arvotaan
          ;      aani_tauko2 = Rand(6000,7000)                        ;t�ss�.
        ;EndIf

	    If (arvonta = 4) Then		 ;y�ll�
        Select valo_numero
        Case 1
                DrawImage valot6,78,67
        Case 2
                DrawImage valot7,78,67
        Case 3
                DrawImage valot8,78,67
        Case 4
                DrawImage valot9,78,67
        Case 5
                DrawImage valot10,78,67
        End Select
        Else
        Select valo_numero			;p�iv�ll�
                Case 1
                DrawImage valot1,78,67
                Case 2
                DrawImage valot2,78,67
                Case 3
                DrawImage valot3,78,67
                Case 4
                DrawImage valot4,78,67
                Case 5
                DrawImage valot5,78,67
        End Select
                Color 255,0,0
        EndIf

        If (MilliSecs() > (aani_timer + 5000 + aani_tauko))        ;Jos on kulunut tietty aika, niin soitetaan
                ;chnbackground2 = PlaySound (seagull)                ;��ni. Tauon m��r�� 1500ms + 
                aani_timer = MilliSecs()                        ;arvotaan
                aani_tauko = Rand(3000,5000)                        ;t�ss�.
        EndIf

        ;If (MilliSecs() > (aani_timer2 + 15000))        ;Jos on kulunut tietty aika, niin 
         ;       chnbackground6 = PlaySound(liikenne)                ;��ni. Tauon m��r�� 1500ms + 
          ;      aani_timer2 = MilliSecs()                        ;arvotaan
		;EndIf

		Color 255,0,0
        Text 395,-2,"New York Skyline",True	
		
		;If (MilliSecs() > (arvo_salama_ajastin + 500)) Then
		;arvo_salama = Rnd(0,10)
		;If (arvo_salama = 5) Then salama_ajastin2 = MilliSecs():salama_aani = 0
		;arvo_salama_ajastin = MilliSecs()
		;EndIf

		;If (MilliSecs() < (salama_ajastin2 + 500)) Then
		;If (vesilumi = 1) Then
		;If (MilliSecs() > salama_ajastin + 100)
		;	salama_ajastin = MilliSecs()
		;	DrawImage lumi,0,259		
		;	EndIf
	;	EndIf
	;EndIf
	
	;If (salama_aani = 0) Then
	;If (Not ChannelPlaying(salamat)) Then
	;	salamat = PlaySound(salama1)
	;Else
	;	salamat = PlaySound(salama2)
	;EndIf
	;salama_aani = 1
	;EndIf
        If (MilliSecs() > timer3 + 200) Then
                frame_liekki = frame_liekki +1

                If frame_liekki = 3  Then frame_liekki = 0
                timer3 = MilliSecs()
        EndIf

        DrawImage torni,319,75,frame

        DrawImage liekki,115,66,frame_liekki

        If (MilliSecs() > timer4 + 1500) Then
                valo_numero = Rand(5)
                timer4 = MilliSecs()
        EndIf
	
	    If (KeyHit(1)) Then
			lopputekstit()
			End
		EndIf

		If (MilliSecs() > (aalto_ajastin + 150)) Then
			freimi_aalto = freimi_aalto + 1
		If (freimi_aalto = 6) Then freimi_aalto = 0
			aalto_ajastin = MilliSecs()
		EndIf

        If (vesilumi = 0 And sataako = 1) Then DrawImage lumi,0,259
		xa = 0
		ya = 200
		For a = 0 To 25
			DrawImage aallot2,xa,ya,freimi_aalto			;AALLOT
			xa = xa + 55
	
			If ((a = 2)) Then xa = xa + 90
			If ((a = 14)) Then xa = xa + 110
			
			If (a = 12) Then
				xa = 10
				ya = 215
			EndIf
		Next

Else
    DrawImage pyhatto,0,0
	Color 255,0,0
	Text 365,570,"Shrine",True
EndIf

		THE_MAIN_LOOP()
    
		If (sataako = 1) Then update()
	
		If (MilliSecs() > musan_ajastin) Then 
			musan_arvonta()
			PlaySound(musa2)
		EndIf

		If (seur = 1) Then Exit
	    Flip
Wend
;----------------------------------------------------------------------------------------------CHINESE
chinese=LoadImage("graphics\chinese_morning.png")
chinese2=LoadImage("graphics\chinese_day.png")
chinese3=LoadImage("graphics\chinese_even.png")
chinese4=LoadImage("graphics\chinese_night.png")
seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
StopChannel chnbackground6
StopChannel (musa3)
StopChannel kohinamusa
chnbackground15 = PlaySound(kukko)
chinese_lumi2 = LoadImage("graphics\chinese_lumi3b.png")
aloitus_timer = MilliSecs()
x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437

        ;Chinese temple
        sekunnit = 60
        arvonta=Rand(4)
	    sataako = Rand(2)
        vesilumi = Rand(0)
        chinese_lumi = LoadImage("graphics\chinese_lumi3.png")
        MaskImage chinese_lumi,4,55,63

        While ((Not KeyHit (1)))
                Cls

		If (pictures_opt = 0) Then
                Select arvonta
                Case 1
                        DrawImage chinese,0,0
						
                Case 2
                        DrawImage chinese2,0,0
						
                Case 3
                        DrawImage chinese3,0,0
						
                Case 4
                        DrawImage chinese4,0,0
						
                Default
                        DrawImage chinese4,0,0
                End Select

                DrawImage cloud7,pilvi_x3,90
                DrawImage cloud2,pilvi_x4,80
				DrawImage kukkeli,50,240
				If (arvonta = 4) Then
					DrawImage silk2,75,74
				Else
					DrawImage silk,75,74
				EndIf
				If (arvonta = 4) Then
					DrawImage gate2,282,85
				Else
					DrawImage gate1,282,85
				EndIf

                If (freimi3 = 0 And (MilliSecs() > timer2 + aika)) Then
                        freimi3 = Rand(1,2)
                        timer3 = MilliSecs()
                EndIf

                If (freimi3 <> 0 And (MilliSecs() > timer3 + 500)) Then
                        freimi3 = 0
                        timer2 = MilliSecs()
                        aika = Rand(500,5000)
                EndIf

                If (MilliSecs() > timer5 + 60) Then
                        pilvi_x3 = pilvi_x3 + 1
                        timer5 = MilliSecs()
                        If (pilvi_x3 > 730) Then pilvi_x3 = 0
                EndIf
                If (MilliSecs() > timer6 + 30) Then
                        pilvi_x4 = pilvi_x4 + 1
                        timer6 = MilliSecs()
                        If (pilvi_x4 > 730) Then pilvi_x4 = 0
                EndIf


                If (MilliSecs() > (aani_timer4 + 3000 + aani_tauko4))        ;Jos on kulunut 
                ;chnbackground7 = PlaySound (lintu2)                ;��ni. Tauon m��r�� 1500ms + 
                aani_timer4 = MilliSecs()                        ;arvotaan
                aani_tauko4 = Rand(3000,6000)                        ;t�ss�.
		        EndIf

        		Color 255,0,0
		        Text 405,-2,"Chinese Temple",True

			If (vesilumi = 0 And sataako = 1) Then 
				If (arvonta = 4) Then
					DrawImage chinese_lumi,0,214
				Else
					DrawImage chinese_lumi2,0,214
				EndIf
			EndIf
	Else
	    DrawImage inca,0,0
		Color 255,0,0
		Text 365,570,"Inca Temple",True
	EndIf
	
	THE_MAIN_LOOP()	;ajastus3()

	If (sataako = 1) Then update()
    If (MilliSecs() > musan_ajastin) Then 
			musan_arvonta()
			PlaySound(musa2)
	EndIf

	If (seur = 1) Then Exit
	Flip
    If (KeyHit(1)) Then
	lopputekstit()
	End
	EndIf
Wend
;----------------------------------------------------------------------------------------FUJI MOUNTAIN
vedet = LoadAnimImage("graphics\vesi.png",55,35,0,6)
vedet2 = LoadAnimImage("graphics\vesi2.png",55,35,0,6)
vedet3 = LoadAnimImage("graphics\vesi3.png",55,35,0,6)
f_puu = LoadImage("graphics\fuji_tree1.png")
MaskImage f_puu,0,51,255
f_puu2 = LoadImage("graphics\fuji_tree2.png")
huippu = LoadImage("graphics\fuji_top.png")
MaskImage huippu,0,51,255
puu3 = LoadImage("graphics\Fuji_tree3.png")
MaskImage puu3,123,113,222
puu4 = LoadImage("graphics\Fuji_tree4.png")
fuji=LoadImage("graphics\fuji_morning.png")
fuji2=LoadImage("graphics\fuji_day.png")
fuji3=LoadImage("graphics\fuji_even.png")
fuji4=LoadImage("graphics\fuji_night.png")
seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437
    ;Fuji mountain
        sekunnit = 60
        timer = MilliSecs()
        timer2 = MilliSecs()
        timer3 = MilliSecs()
        arvonta=Rand(4)
	    sataako = Rand(0,2)
        vesilumi = Rand(0,1)
		aloitus_timer = MilliSecs()

        Local fuji_lumi = LoadImage("graphics\fuji_lumi4.png")
        MaskImage fuji_lumi,4,55,63

		freimi_aalto = 0
		aalto_ajastin = MilliSecs()

        While ((Not KeyHit (1)))
                Cls

				If (pictures_opt = 0) Then
                Select arvonta
                Case 1
                        DrawImage fuji,0,0
				        If (vesilumi = 0 And sataako = 1) Then DrawImage fuji_lumi,0,225
	                    DrawImage vedet2,520,215,freimi

                Case 2
                        DrawImage fuji2,0,0
				        If (vesilumi = 0 And sataako = 1) Then DrawImage fuji_lumi,0,225
                        DrawImage vedet2,520,215,freimi
                Case 3
                        DrawImage fuji3,0,0
				        If (vesilumi = 0 And sataako = 1) Then DrawImage fuji_lumi,0,225
                        DrawImage vedet,520,215,freimi
                Case 4
                        DrawImage fuji4,0,0
				        If (vesilumi = 0 And sataako = 1) Then DrawImage fuji_lumi,0,225
                        DrawImage vedet3,520,215,freimi
                Default
                        DrawImage fuji4,0,0
				        If (vesilumi = 0 And sataako = 1) Then DrawImage fuji_lumi,0,225
                        DrawImage vedet3,520,215,freimi
                End Select
                DrawImage cloud,pilvi_x3,81
                DrawImage cloud8,pilvi_x4,76

		If (arvonta = 4) Then
		DrawImage f_puu2,74,80
		Else
		DrawImage f_puu,74,80
		EndIf
		If (arvonta = 4) Then
		DrawImage puu4,600,74
		Else
		DrawImage puu3,600,74
		EndIf
		If (freimi3 = 0 And (MilliSecs() > timer2 + aika)) Then
        	freimi3 = Rand(1,2)
            timer3 = MilliSecs()
        EndIf

        If (freimi3 <> 0 And (MilliSecs() > timer3 + 500)) Then
	        freimi3 = 0
            timer2 = MilliSecs()
            aika = Rand(500,5000)
        EndIf

        If (MilliSecs() > timer5 + 60) Then
    	    pilvi_x3 = pilvi_x3 + 1
        	timer5 = MilliSecs()
            If (pilvi_x3 > 730) Then pilvi_x3 = 0
            EndIf
        If (MilliSecs() > timer6 + 30) Then
            pilvi_x4 = pilvi_x4 + 1
            timer6 = MilliSecs()
            If (pilvi_x4 > 730) Then pilvi_x4 = 0
        EndIf

        DrawImage huippu,295,93
        DrawImage duck,200,215

	    ;DrawImage valkolintu, lintu_x, 90,lintu_freimi
	    If (MilliSecs() > lx_timer + 30) Then
                lintu_x = lintu_x + 1
                lx_timer = MilliSecs()
                If (lintu_x > 800) Then lintu_x = 0
        EndIf
        If (MilliSecs() > lintu_timer + 300) Then
                lintu_freimi = lintu_freimi + 1
                If (lintu_freimi = 3) Then lintu_freimi = 0
                lintu_timer = MilliSecs()
        EndIf

        If (MilliSecs() > (aani_timer + 1500 + aani_tauko))        ;Jos on kulunut tietty 
         ;       chnbackground2 = PlaySound (seagull)                ;��ni. Tauon m��r�� 1500ms + 
                aani_timer = MilliSecs()                        ;arvotaan
                aani_tauko = Rand(1000,10000)                        ;t�ss�.
        EndIf

        ;If (MilliSecs() > (aani_timer2 + 1500 + aani_tauko2))        ;Sama kuin edell�, mutta toiselle ��nelle.
         ;       chnbackground9 = PlaySound (other_b)
          ;      aani_timer2 = MilliSecs()
           ;     aani_tauko2 = Rand(1000,10000)
            ;    If (MilliSecs() > (aani_timer3 + 1500 + aani_tauko3))        ;Sama kuin edell�, 
             ;   chnbackground10 = PlaySound (ankka)
              ;  aani_timer3 = MilliSecs()
               ; aani_tauko3 = Rand(1000,10000)
        ;EndIf
		;EndIf
        	    Color 255,0,0
		        Text 400,-2,"Fuji Mountain",True

				xa = 0
				ya = 200
				
				For a = 0 To 12
					DrawImage aallot,xa,ya,freimi_aalto			;AALLOT
					xa = xa + 90
					If (a = 1) Then ya = 230
					If (a = 2) Then ya = 220
					If (a = 3) Then ya = 240
					If (a = 5) Then ya = 220
					If (a = 7) Then ya = 200
					If (a = 8) Then ya = 180
					If (a = 10) Then xa = 550:ya = 190
					If (a = 11) Then xa = 620:ya = 195			
				Next

				If (MilliSecs() > (aalto_ajastin + 150)) Then
					freimi_aalto = freimi_aalto + 1
					If (freimi_aalto = 6) Then freimi_aalto = 0
					aalto_ajastin = MilliSecs()
				EndIf	

        If (MilliSecs() > timer3 + 1400) Then
                freimi3 = freimi3 + 1
                If (freimi3 = 5) Then freimi3 = 0
                timer3 = MilliSecs()
        EndIf

        If (MilliSecs() > timer2 + 1400) Then
                freimi2 = freimi2  + 1
                If (freimi2 = 2) Then freimi2 = 0
                timer2 = MilliSecs()
        EndIf

        If (MilliSecs() > timer + 150) Then
                freimi = freimi + 1
                If (freimi = 6) Then freimi = 0
                timer = MilliSecs()
        EndIf

	Else
       	DrawImage white,0,0
		Color 255,0,0
		Text 365,570,"The White House",True
	EndIf

		THE_MAIN_LOOP()

       If (sataako = 1) Then update()
	   If (MilliSecs() > musan_ajastin) Then 
			musan_arvonta()
			PlaySound(musa2)
		EndIf
        Flip
        If (KeyHit(1)) Then
			loputeksit = 1:lopputekstit()
			End
		EndIf
		
		If (seur = 1) Then
			hall_of_fame():loputeksit = 1:lopputekstit()
			Exit
		EndIf
Wend

seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
FlushKeys()
StopChannel kohinamusa
hall_of_fame():loputeksit = 1:lopputekstit()

Wend
End
;End of International karate 1 !!!
;________________________________________________________________________________________________________________________________________

;karate2
.karate2
If (full_contact_on = 0) Then placedrops()
StopChannel musa
musa=PlayMusic("karate2.mp3")
Cls
Text 380,300,"LOADING...."
Flip
Delay 1000
;------------------------------------------------------------------------------------------------EGYPT
seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
lopetus = 0
pyramidi=LoadImage("graphics\pyramidi.png")
palmut=LoadAnimImage("graphics\palmtrees.png",260,130,0,3)
egypt=LoadImage("graphics\\Egypt_morning.png")
egypt2=LoadImage("graphics\\Egypt_day.png")
egypt3=LoadImage("graphics\\Egypt_even.png")
egypt4=LoadImage("graphics\egypt_night.png")
temppeli=LoadImage("graphics\temple.png")
laatta=LoadImage("graphics\laatta.png")
puu=LoadAnimImage("graphics\puu.png",40,100,0,3)
MaskImage palmut,62,49,162
MaskImage pyramidi,62,49,162
MaskImage temppeli,0,0,255
MaskImage puu,1,1,255
x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437
ottelu_alkaa = 0
spider2_x = 120
spider2_y = 220
If (full_contact_on = 0) Then
	arvotaan_musa = Rand(1,7)
	musan_arvonta()
	chnBackground=PlaySound(musa2)
EndIf
;kohinamusa = PlayMusic("biisi2.xm")
sataako = Rand(2)
spider_out = MilliSecs() + Rand(3000,10000)
vesilumi = Rand(1)

While (lopetus = 0)
sekunnit = 60
aloitus_timer = MilliSecs()
        ;Egypt
        timer2 = MilliSecs()
        timer3 = MilliSecs()
        timer5 = MilliSecs()
        timer6 = MilliSecs()
        freimi3 = 0
        aika = Rand(500,5000)
        ukko_timer = MilliSecs() : ukko_timer2 = MilliSecs() : ukko_timer3 = MilliSecs()

        arvonta=Rand(4)

        While ((Not KeyHit (1)))
                Cls
                Select arvonta
                Case 1
		        DrawImage egypt,0,10
                Case 2
                DrawImage egypt2,0,10
                Case 3
	            DrawImage egypt3,0,10
                Case 4
			    DrawImage egypt4,0,10
                Default
				DrawImage egypt4,0,10
                End Select
                Color 255,0,0
                Text 365,530,"Egypt, The Valley Of The Kings",True
				Text 0,200,ChannelPlaying(chnBackground)
				
If (MilliSecs() > (spider_out)) Then spider_on = 1

If (spider_on) Then
	If (arvo_spi = 0) Then	;arvotaan mik� h�mis tulee
		arvo_spider = Rand(0,1)
		arvo_spi = 1
		
		spider_kohta = Rand(0,3)
		
		Select spider_kohta
			Case 0
				spider2_x = 120
				spider2_y = 220
			Case 1
				spider2_x = 210
				spider2_y = 230
			Case 2
				spider2_x = 308
				spider2_y = 230
		End Select
	EndIf

	DrawImage spider2,spider2_x,spider2_y, spiderframe

	If (MilliSecs() > (spidertimer + 100)) Then
		If (spider_dir = 0) Then
            spiderframe = spiderframe + 1
            spidertimer = MilliSecs()
			
			If (arvo_spider = 0) Then
	            If (spiderframe = 5) Then spider_dir = 1:spideraika = Rand(1000,10000)
			Else
	            If (spiderframe = 14) Then spider_dir = 1:spideraika = Rand(1000,10000)
			EndIf

		Else If(spider_dir = 2) Then
            spiderframe = spiderframe - 1
            spidertimer = MilliSecs()
            If (spiderframe < 0) Then 
				spider_dir = 0
				spider_on = 0
				spider_out = MilliSecs() + Rand(3000,10000)
				spiderframe = 0
				arvo_spi = 0
			EndIf
		Else
			If (MilliSecs() > (spidertimer + spideraika)) Then spider_dir = 2
        EndIf
	EndIf
EndIf
	For ad = 0 To 6
		DrawImage aallot,xa,ya,freimi_aalto			;AALLOT
		If (ad = 1) Then xa = 51:ya = 241
		If (ad = 2) Then xa = 88:ya = 246
		If (ad = 3) Then xa = 56:ya = 257
		If (ad = 4) Then xa = 158:ya = 265
		If (ad = 5) Then xa = 194:ya = 261
		If (ad = 6) Then xa = 230:ya = 266
	Next

	If (MilliSecs() > (aalto_ajastin + 150)) Then
		freimi_aalto = freimi_aalto + 1
		If (freimi_aalto = 6) Then freimi_aalto = 0
		aalto_ajastin = MilliSecs()
	EndIf

	THE_MAIN_LOOP()

                DrawImage cloud7,pilvi_x3,130
                DrawImage cloud3,pilvi_x4,155
                DrawImage palmut,80,105,freimi3
                DrawImage pyramidi,461,111

                If (freimi3 = 0 And (MilliSecs() > timer2 + aika)) Then
                        freimi3 = Rand(1,2)
                        timer3 = MilliSecs()
                EndIf

                If (freimi3 <> 0 And (MilliSecs() > timer3 + 500)) Then
                        freimi3 = 0
                        timer2 = MilliSecs()
                        aika = Rand(500,5000)
                EndIf

                If (MilliSecs() > timer5 + 60) Then
                        pilvi_x3 = pilvi_x3 + 1
                        timer5 = MilliSecs()
                        If (pilvi_x3 > 730) Then pilvi_x3 = 0
                EndIf
                If (MilliSecs() > timer6 + 30) Then
                        pilvi_x4 = pilvi_x4 + 1
                        timer6 = MilliSecs()
                        If (pilvi_x4 > 730) Then pilvi_x4 = 0
                EndIf
				DrawImage eagle, kotka_x, 70,kotka_freimi
        		If (MilliSecs() > timer_bird + 31) Then
                kotka_x = kotka_x + 1
                timer_bird = MilliSecs()
                If (kotka_x > 800) Then kotka_x = 0
        EndIf
        		If (MilliSecs() > lintu_timer + 300) Then
                kotka_freimi = kotka_freimi + 1
                If (kotka_freimi = 3) Then kotka_freimi = 0
                lintu_timer = MilliSecs()
        EndIf

        If (sataako = 1) Then update()
		If (seur = 1) Then Exit
		      If (MilliSecs() > musan_ajastin) Then 
			musan_arvonta()
			PlaySound(musa2)
		EndIf
        Flip
        If (KeyHit(1)) Then
			loputeksit = 2
			lopputekstit()
		End
		EndIf
Wend
;---------------------------------------------------------------------------------------RIO DE JANEIRO
statue = LoadImage("graphics\christ_statue_rio.png")
MaskImage statue,0,51,255
rio=LoadImage("graphics\Rio_night.png")
rio1=LoadImage("graphics\Rio_morning.png")
rio2=LoadImage("graphics\Rio_even.png")
rio3=LoadImage("graphics\Rio_day.png")
seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
StopChannel chnbackground1
kohinamusa = PlayMusic("biisi2.xm")
aloitus_timer = MilliSecs()
x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437

        ;Rio De Janeiro
        timer8 = MilliSecs()
        timer9 = MilliSecs()
        timer10 = MilliSecs()
        timer11 = MilliSecs()
        timer12 = MilliSecs()
        timer13 = MilliSecs()
        timer14 = MilliSecs()
        timer15 = MilliSecs()
        timer16 = MilliSecs()
        timer17 = MilliSecs()
        timer18 = MilliSecs()
        sekunnit = 60
        arvonta=Rand(4)
        sataako = Rand(2)
        vesilumi = Rand(1)
        While ((Not KeyHit (1)))
                Cls
                Select arvonta
                Case 1
                        DrawImage rio,0,0
                Case 2
                        DrawImage rio1,0,0
                Case 3
                        DrawImage rio2,0,0
                Case 4
                        DrawImage rio3,0,0
                Default
                        DrawImage rio3,0,0
                End Select

				DrawImage statue, statue_x,88

                Color 255,0,0
                Text 365,530,"Rio De Janeiro",True

                THE_MAIN_LOOP();ajastus_i()

                If (KeyHit(1)) Then End

                DrawImage cloud11,pilvi_x,79
                DrawImage cloud12,pilvi_x12,100
                DrawImage cloud13,pilvi_x13,91
                DrawImage cloud14,pilvi_x14,104
                DrawImage cloud15,pilvi_x15,61
;                DrawImage cloud16,pilvi_x16,131
                DrawImage cloud17,pilvi_x17,86
                DrawImage cloud18,pilvi_x18,110
 
                If (MilliSecs() > timer9 + 44) Then
                        pilvi_x12 = pilvi_x12 + 1
                        timer9 = MilliSecs()
                        If (pilvi_x12 > 730) Then pilvi_x12 = 0
                EndIf
                If (MilliSecs() > timer10 + 27) Then
                        pilvi_x13 = pilvi_x13 + 1
                        timer10 = MilliSecs()
                        If (pilvi_x13 > 730) Then pilvi_x13 = 0
                EndIf
                If (MilliSecs() > timer11 + 88) Then
                        pilvi_x14 = pilvi_x14 + 1
                        timer11 = MilliSecs()
                        If (pilvi_x14 > 730) Then pilvi_x14 = 0
                EndIf
                If (MilliSecs() > timer12 + 16) Then
                        pilvi_x15 = pilvi_x15 + 1
                        timer12 = MilliSecs()
                        If (pilvi_x15 > 730) Then pilvi_x15 = 0
                EndIf
                If (MilliSecs() > timer14 + 61) Then
                        pilvi_x17 = pilvi_x17 + 1
                        timer14 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x17 = 0
                EndIf
                If (MilliSecs() > timer15 + 76) Then
                        pilvi_x18 = pilvi_x18 + 1
                        timer15 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x18 = 0
                EndIf
                If (MilliSecs() > timer16 + 31) Then
                        pilvi_x19 = pilvi_x19 + 1
                        timer16 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x19 = 0
                EndIf
                If (MilliSecs() > timer17 + 64) Then
                        pilvi_x20 = pilvi_x20 + 1
                        timer17 = MilliSecs()
                        If (pilvi_x20 > 730) Then pilvi_x20 = 0
                EndIf
                If (MilliSecs() > timer18 + 100) Then
                        pilvi_x = pilvi_x + 1
                        timer18 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x = 0
                EndIf

		        If (MilliSecs() > timer_bird + 30) Then
                lintu_x = lintu_x + 1
                timer_bird = MilliSecs()
                If (lintu_x > 800) Then lintu_x = 0
        EndIf
        If (MilliSecs() > lintu_timer + 300) Then
                lintu_freimi = lintu_freimi + 1
                If (lintu_freimi = 3) Then lintu_freimi = 0
                lintu_timer = MilliSecs()
        EndIf

        If (MilliSecs() > (aani_timer + 5000 + aani_tauko))        ;Jos on kulunut tietty 
                ;chnbackground2 = PlaySound (seagull)                ;��ni. Tauon m��r�� 1500ms + 
                aani_timer = MilliSecs()                        ;arvotaan
                aani_tauko = Rand(3000,5000)                        ;t�ss�.
        EndIf

        If (sataako = 1) Then update()           ;2222222222222
		If (seur = 1) Then Exit				
        If (MilliSecs() > musan_ajastin) Then 
			musan_arvonta()
			PlaySound(musa2)
		EndIf
		If (KeyHit(1)) Then
			loputeksit = 2
			lopputekstit()
		End
		EndIf
        Flip
Wend
;----------------------------------------------------------------------------------------------BIG BEN
seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
StopChannel (musa3)
StopChannel kohinamusa

kohinamusa = PlayMusic("biisi2.xm")
aloitus_timer = MilliSecs()
x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437

       ;London
        pilvi_x = 0
        pilvi_x2 = 60
        pilvi_x3 = 450
        pilvi_x4 = 200
        pilvi_x5 = 400

        sekunnit = 60
 		sataako = Rand(0,2)
        vesilumi = Rand(0,1)

        Local london_lumi = LoadImage("graphics\London_lumi2.png")
        MaskImage london_lumi,4,55,63

                Select arvonta
                Case 1
                        bigkello = Rand(1,5)
                Case 2
                        bigkello = Rand(6,9)
                Case 3
                        bigkello = Rand(10,05)
                Case 4
                        bigkello = Rand(5,11)
                Default
                        bigkello = Rand(5,11)
                End Select
				kellot = 0
                kellosoi = 0

                kello_ajastus = MilliSecs()
				
			While ((Not KeyHit (1)))
           
                Cls
                If (CurrentTime$() > "23:00:00") Then
						bigkello = 11
                Else If (CurrentTime$() > "22:00:00") Then
						bigkello = 10
                Else If (CurrentTime$() > "21:00:00") Then
						bigkello = 9
                Else If (CurrentTime$() > "20:00:00") Then
						bigkello = 8
                Else If (CurrentTime$() > "19:00:00") Then
						bigkello = 7
                Else If (CurrentTime$() > "18:00:00") Then
						bigkello = 6
                Else If (CurrentTime$() > "17:00:00") Then
						bigkello = 5
                Else If (CurrentTime$() > "16:00:00") Then
						bigkello = 4
                Else If (CurrentTime$() > "15:00:00") Then
						bigkello = 3
                Else If (CurrentTime$() > "14:00:00") Then
						bigkello = 2
                Else If (CurrentTime$() > "13:00:00") Then
						bigkello = 1
                Else If (CurrentTime$() > "12:00:00") Then
						bigkello = 0
                Else If (CurrentTime$() > "11:00:00") Then
						bigkello = 11
                Else If (CurrentTime$() > "10:00:00") Then
						bigkello = 10
                Else If (CurrentTime$() > "09:00:00") Then
						bigkello = 9
                Else If (CurrentTime$() > "08:00:00") Then
						bigkello = 8
                Else If (CurrentTime$() > "07:00:00") Then
						bigkello = 7
                Else If (CurrentTime$() > "06:00:00") Then
						bigkello = 6
                Else If (CurrentTime$() > "05:00:00") Then
						bigkello = 5
                Else If (CurrentTime$() > "04:00:00") Then
						bigkello = 4
                Else If (CurrentTime$() > "03:00:00") Then
						bigkello = 3
                Else If (CurrentTime$() > "02:00:00") Then
						bigkello = 2
                Else If (CurrentTime$() > "01:00:00") Then
						bigkello = 1
                Else 
						bigkello = 0
				EndIf

                If (CurrentTime$() > "21:00:00") Then
                        DrawImage lonton3,0,0;night
                Else If (CurrentTime$() > "17:00:00") Then
                        DrawImage lonton2,0,0;even
                Else If (CurrentTime$() > "11:00:00") Then
          	            DrawImage lonton4,0,0;morning
	            Else If (CurrentTime$() > "05:00:00") Then
 	                    DrawImage lonton,0,0;day
				Else
				        DrawImage lonton3,0,0;night
				EndIf
            
				If ((vesilumi = 0) And (sataako = 1)) Then DrawImage London_lumi,0,328
				Color 255,0,0
                Text 365,530,"London, Westminster Abby",True

				THE_MAIN_LOOP();ajastus7()

                DrawImage cloud6,pilvi_x,144
                DrawImage cloud7,pilvi_x2,130
                DrawImage cloud8,pilvi_x3,140
                DrawImage cloud9,pilvi_x4,131
                DrawImage cloud10,pilvi_x5,139
                ;DrawImage laatta,-20,100
                ;DrawImage laatta,721,100

                DrawImage smoke,194,135
                ;DrawImage peek,257,175
                DrawImage bigben,441,145
                DrawImage tree,480,165
                DrawImage church,639,144

                DrawImage bkello,456,171,bigkello
		
                If (MilliSecs() > timer3 + 70) Then
                        pilvi_x = pilvi_x + 1
                        timer3 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x = 0
                EndIf
                If (MilliSecs() > timer4 + 50) Then
                        pilvi_x2 = pilvi_x2 + 1
                        timer4 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x2 = 0
                EndIf
                If (MilliSecs() > timer5 + 60) Then
                        pilvi_x3 = pilvi_x3 + 1
                        timer5 = MilliSecs()
                        If (pilvi_x3 > 730) Then pilvi_x3 = 0
                EndIf
                If (MilliSecs() > timer6 + 30) Then
                        pilvi_x4 = pilvi_x4 + 1
                        timer6 = MilliSecs()
                        If (pilvi_x4 > 730) Then pilvi_x4 = 0
                EndIf
                If (MilliSecs() > timer7 + 80) Then
                        pilvi_x5 = pilvi_x5 + 1
                        timer7 = MilliSecs()
                        If (pilvi_x5 > 730) Then pilvi_x5 = 0
                EndIf

				If (seur = 1) Then Exit
                If (sataako = 1) Then update()
	
  	        If (MilliSecs() > musan_ajastin) Then 
			musan_arvonta()
			PlaySound(musa2)
			EndIf

            Flip
            If (KeyHit(1)) Then
				loputeksit = 2
				lopputekstit()
			End
			EndIf
Wend
;-----------------------------------------------------------------------------------------------GREECE
crece=LoadImage("graphics\creece_day.png")
crece1=LoadImage("graphics\creece_even.png")
crece2=LoadImage("graphics\creece_night.png")
seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
arvonta7 = 0
x = 100 : x3 = 300: x2 = 580: y = 440 : y2 = 440 : y3 = 437

StopChannel chnbackground13
;arvonta = Rand(0,7)
;musan_arvonta()
;chnBackground=PlaySound(musa2)
kohinamusa = PlayMusic("biisi2.xm")
aloitus_timer = MilliSecs()
        ;Crecian temple
        sekunnit = 60
        arvonta=Rand(4)
        timer3 = MilliSecs()
        timer4 = MilliSecs()
        timer5 = MilliSecs()
        timer6 = MilliSecs()
        timer7 = MilliSecs()
        timer8 = MilliSecs()
		StopChannel kanava2
        pilvi_x = 0
        pilvi_x2 = 60
        pilvi_x3 = 450
        pilvi_x4 = 200
        pilvi_x5 = 400
        puu_frame = 0
        sataako = Rand(2)
        vesilumi = Rand(1)
        While ((Not KeyHit (1)))
                Cls
                Select arvonta
                Case 1
                        DrawImage crece,0,0
                Case 2
                        DrawImage crece1,0,0
                Case 3
                        DrawImage crece2,0,0
                Default
                        DrawImage crece2,0,0
                End Select
                Color 255,0,0
                Text 365,530,"Crecian temple",True

				THE_MAIN_LOOP()

                DrawImage cloud,pilvi_x,78
                DrawImage cloud2,pilvi_x2,85
                DrawImage cloud3,pilvi_x3,69
                DrawImage cloud4,pilvi_x4,90
                DrawImage cloud5,pilvi_x5,99

                DrawImage puu,669,160,puu_frame
				DrawImage afro,151,69

                DrawImage lintu, lintu_x, 70,lintu_freimi
                If (MilliSecs() > timer_bird + 30) Then
                lintu_x = lintu_x + 1
                timer_bird = MilliSecs()
                If (lintu_x > 800) Then lintu_x = 0
        EndIf
		If (MilliSecs() > lintu_timer + 300) Then
                lintu_freimi = lintu_freimi + 1
                If (lintu_freimi = 3) Then lintu_freimi = 0
                lintu_timer = MilliSecs()
        EndIf
                If (MilliSecs() > (aani_timer + 5000 + aani_tauko))        ;Jos on kulunut tietty aika, niin soitetaan
                ;chnbackground2 = PlaySound (seagull)                ;��ni. Tauon m��r�� 1500ms + aani_tauko, joka
                aani_timer = MilliSecs()                        ;arvotaan
                aani_tauko = Rand(3000,5000)                        ;t�ss�.
        EndIf
                If (MilliSecs() > timer3 + 70) Then
                        pilvi_x = pilvi_x + 1
                        timer3 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x = 0
                EndIf
                If (MilliSecs() > timer4 + 50) Then
                        pilvi_x2 = pilvi_x2 + 1
                        timer4 = MilliSecs()
                        If (pilvi_x > 730) Then pilvi_x2 = 0
                EndIf
                If (MilliSecs() > timer5 + 60) Then
                        pilvi_x3 = pilvi_x3 + 1
                        timer5 = MilliSecs()
                        If (pilvi_x3 > 730) Then pilvi_x3 = 0
                EndIf
                If (MilliSecs() > timer6 + 30) Then
                        pilvi_x4 = pilvi_x4 + 1
                        timer6 = MilliSecs()
                        If (pilvi_x4 > 730) Then pilvi_x4 = 0
                EndIf
                If (MilliSecs() > timer7 + 80) Then
                        pilvi_x5 = pilvi_x5 + 1
                        timer7 = MilliSecs()
                        If (pilvi_x5 > 730) Then pilvi_x5 = 0
                EndIf
                If (MilliSecs() > timer8 + 450) Then
                        puu_frame = puu_frame + 1
                        timer8 = MilliSecs()
                        If (puu_frame = 3) Then puu_frame = 0
                EndIf
   												
 				If (sataako = 1) Then update();22222222222

				Color 255,255,255

			If (seur = 1) Then Exit
			If (MilliSecs() > musan_ajastin) Then 
				musan_arvonta()
				PlaySound(musa2)
			EndIf
			Flip
            If (KeyHit(1)) Then
				loputeksit = 2
				hall_of_fame()
				lopputekstit()
			End
			EndIf
Wend


seur = 0 : alkupisteet1 = pisteet1 : alkupisteet2 = pisteet2
FlushKeys()
StopChannel musa
hall_of_fame() : loputeksit = 1:lopputekstit()

Wend

End
;_______________________________________________________________________________________________________________________________________


Function ajastus()
        If (ottelu_alkaa = 0) Then
        	aloitus_timer = MilliSecs()
            ottelu_alkaa = 1
        EndIf
        Color 255,0,0
        Text 385,10,sekunnit
        If (MilliSecs() > aloitus_timer + 2000) Then
        	If (MilliSecs() > kello + 1000) Then
            	kello = MilliSecs()
                sekunnit = sekunnit - 1
            EndIf
        EndIf
End Function

Function lopputekstit()
		Local white_head_eagle = LoadImage("graphics\eagle.png")

		Local creditlen = 55
		Local y = 600
		Color 255,255,255
		;               01234567890123456789012345678901
		Select loputeksit
		Case 0
		credit$(0)   =  "     International Karate 1   "
		Case 2
		credit$(0)   =  "     International Karate 2   "
		End Select
		credit$(1)   =  "                              "
		credit$(2)   =  "    Originally presented by   "
		credit$(3)   =  "    System 3 Software ltd.    "
		credit$(4)   =  "    as International Karate:  "
		credit$(5)   =  "                              "
		credit$(6)   =  "          PROGRAMMING         "
		credit$(7)   =  "          -----------         "
		credit$(8)   =  "      System 3 Software ltd.  "
		credit$(9)   =  "                              "
		credit$(10)  =  "           GRAPHICS           "
		credit$(11)  =  "           --------           "
		credit$(12)  =  "         Archer Maclean       "
		credit$(13)  =  "                              "
		credit$(14)  =  "             MUSIC            "
		credit$(15)  =  "            -------           "
		credit$(16)  =  "          Rob Hubbard         "
		credit$(17)  =  "                              "
		credit$(18)  =  "            SOUND             "
		credit$(19)  =  "           -------            "
		credit$(20)  =  "     System 3 Software ltd.   "
		credit$(21)  =  "                              "
		credit$(22)  =  "        Productive Bits       "
		credit$(23)  =  "        ---------------       "
		credit$(24)  =  "           Mark Cale          "
		credit$(25)  =  " (C)1986 System 3 software ltd"
		credit$(26)  =  "______________________________"
		credit$(27)  =  "  WHITE HEAD EAGLE SOFTWARE:  "
		credit$(28)  =  "                              "
		credit$(29)  =  "        Jarno Puikkonen       "
		credit$(30)  =  "        Vesa Vertainen        "
		credit$(31)  =  "                              "
		credit$(32)  =  "        Soundfix Changes      "
		credit$(33)  =  "        ----------------      "
		credit$(34)  =  "        Jarno Puikkonen       "
		credit$(35)  =  "        Vesa Vertainen        "
		credit$(36)  =  "                              "
		credit$(37)  =  "          New musics          "
		credit$(38)  =  "          ----------          "
		credit$(39)  =  "        Jarno Puikkonen       "
		credit$(40)  =  "        Vesa Vertainen        "
		credit$(41)  =  "                              "
		credit$(42)  =  "          Tournament          "
		credit$(43)  =  "          ----------          "
		credit$(44)  =  "        Jarno Puikkonen       "
		credit$(45)  =  "        Vesa Vertainen        "
		credit$(46)  =  "                              "    
		credit$(47)  =  "We want to express our respect"
		credit$(48)  =  "           Towards            "
		credit$(49)  =  "          Mark Cale           "
		credit$(50)  =  "            and               "
		credit$(51)  =  "        the whole team        "
		credit$(52)  =  "           Called             "            
		credit$(53)  =  "	  System 3 Software ltd. !!"
		credit$(54)  =  "   White Head Eagle Software  "
		credit$(55)  =  "            2008              "            
		
		Color 0,255,0
		loparit = LoadFont("Commodore-64-v6.3.TTF", 24, True, False, False)
SetFont loparit
		Local lisays = 0, alku = 0, creditlen2 = 2, more = 0, more2 = 0, vah = 0, timera = MilliSecs()
		i = 0
		FlushKeys()
		While ((alku <> creditlen) And (Not KeyHit(1)))
		
			If (MilliSecs() > timera + 10) Then
			Cls	
					;DrawImage kannet,0,0
					While ((i<creditlen2) And (Not KeyHit(1)))
										
					Text 400,y+lisays,credit$(i),True		;! tekstin keskitys !
					lisays = lisays + 30
					i = i + 1
				Wend
		
				If ((y+15) < -10) Then vah = 1;aloitetaan yl�osasta v�hent�m��n tekstej�
				y = y - 1 ;siirret��n teksti� yl�s
				lisays = 0
				more = more + 1
				more2 = more2 + 1
				
				If (more2 => 30) Then
					If (vah = 1) Then 
						alku = alku + 1
						y = y + 30
						more2 = 0
					EndIf
				EndIf
				If (more = 15) Then
					creditlen2 = creditlen2 + 1
					If (creditlen2>57) Then creditlen2 = 55
					more = 0
				EndIf
				i = alku
				timera = MilliSecs()
				Flip
			EndIf	
		Wend

Delay 100
timera = MilliSecs()
i = 0
alku = 0
While (i > -1)
Cls
	If (MilliSecs() > (timera + 100)) Then
		If (alku = 0) Then 
			i = i + 1
		Else
			i = i - 1
		EndIf

		If (i = 3) Then 
			i = 2
			Delay 800
			alku = 1
		EndIf
	
		timera = MilliSecs()
	EndIf
Flip
Wend
Cls
Flip
Delay 500
nollaus()
cpu_vai_ei = 9
End Function


;____________________________________________________________________________________________PRACTICE?

;----------------------------------------------------------------------------------------LUMI/VESISADE
Function placedrops()
For n=0 To drop_number
  drip.drop = New drop
  al=Rnd(2048)
  drip\x=al-704
  drip\y=Rnd(380)
  drip\angle=0     ;straight down (This is modified by wind)
  drip\col=Rnd(4)
Next
End Function

Function update()
;adjust the 12 at the end of the Sin and Cos lines for faster rain
For drip.drop = Each drop
  xx=Sin((2*(drip\angle+wind))*Pi/360)*2
  yy=Cos((2*(drip\angle+wind))*Pi/360)*2
;  If drip\col=0 Then Color 200,200,200 Else
;  If drip\col=1 Then Color 150,150,150 Else
;  If drip\col=2 Then Color 100,100,100 Else
;  If drip\col=3 Then Color 50,50,50
If (vesilumi = 0) Then
	Color 255,255,255
Else
	Color 0,0,102
EndIf
  Line drip\x,drip\y,drip\x+(xx/2),drip\y+(yy/2)
  drip\x=drip\x+xx
  drip\y=drip\y+yy
  If drip\y>580
   percent=Rnd(100)
   If percent<50 Or drip\y>475
    al=Rnd(2048)
    drip\x=al-704
    drip\y=Rnd(100)
    drip\angle=0     ;straight down (This is modified by wind)
   EndIf
  EndIf
Next
End Function

;----------------------------------------------------------------------------------------THE_MAIN_LOOP
;----------------------------------------------------------------------------------------THE_MAIN_LOOP
;----------------------------------------------------------------------------------------THE_MAIN_LOOP

Function THE_MAIN_LOOP() 	;pelin varsinainen p��silmukka
If (pauset = 1) Then  ;PAUSE-NAPPI eli space
	pisteettalteen = pisteet2
	xtalteen = x
	x2talteen = x2
	x3talteen = x3
	pauset = 2
Else If (pauset = 2) Then
;	DisplaySprites()
	Text 360,400,"P A U S E D"
	move_cpu()
	move_cpu2()
	move_cpu3()
	hits()
	pisteet2 = 0
	If (KeyDown(57)) Then  
		Delay 500
		FlushKeys()
		pauset = 0
		pisteet2 = pisteettalteen
		x = xtalteen 
		x2 = x2talteen
		x3 = x3talteen
	EndIf
Else
	If (KeyDown(57)) Then ;Pause p��lle
		Delay 500
		FlushKeys()
		pauset = 1
	EndIf

	If (boonus = 0) Then

		If (cpu_vai_ei < 9) Then ;demomode	
			ajastus()			   ;pelin ajastus
			valot()	 			;valot syttyy osumasta, sijaitsee my�s hits...bb:ss�
		Else
		Text 100,200,cpu_vai_ei
			If (cpu_vai_ei = 10) Then Text 100,400,"F1 one player, F2 two players, F3 one player - two cpus, F4 two players - one cpu"
			ajastus()			   ;pelin ajastus

		EndIf

		If (cpu_vai_ei = 9) Then cpu_vai_ei = 10 : aloitus_timer = MilliSecs()
	
		; PELAAJIEN VALINTA
		If (cpu_vai_ei) = 0 Then;F1 = valkoinen ja vihree
			move_cpu()
			move_keyb()
		EndIf
		If (cpu_vai_ei) = 1 Then;F2 = valkoinen ja punainen
			move_keyb2()
			move_keyb()
		EndIf
		If ((cpu_vai_ei) = 2 Or (cpu_vai_ei = 10)) Then;F3 = valkoinen ja (vihre� CPU + pun CPU)
			If (cpu_vai_ei = 2) Then move_keyb()
			move_cpu()
			punainenonvalkoinen = 0
			move_cpu2()
			If cpu_vai_ei = 10 Then move_cpu3()

			score_global = pisteet1
			vyoglobal$ = vyo1$
		EndIf

		If ((cpu_vai_ei) = 3) Then;F4 vain vihre� on cpu
			move_keyb()
			move_cpu()
			move_keyb2()
		EndIf

		If ((cpu_vai_ei) = 4) Then;Punainen pelaaja + valkoinen CPU ja vihre� CPU
			move_keyb2()
			move_cpu()
			
			score_global = pisteet2
			vyoglobal$ = vyo2$
			move_cpu3()
		EndIf

		belts()

		hits();osumat
	Else
		If (boonus = 1) Then jump_in_japan()
		If (boonus = 2) Then tiles()
	EndIf

;	If (KeyDown(48)) Then siirr = 3:lastbonus = 1

		hits();osumat

	; X-ARVOJEN SIJOITTELU, JOS VAIHTUU PELAAJA/CPU
	If (KeyHit(59)) Then
		cpu_vai_ei = 0
		nollaus()
		scoreglobal = 0
		pisteet1 = 0 : pisteet2 = 0 : pisteet3 = 0 : scoreglobal = 0 : level = 1
	EndIf
	If (KeyHit(60)) Then 
		cpu_vai_ei = 1
		nollaus()
		scoreglobal = 0
		pisteet1 = 0 : pisteet2 = 0 : pisteet3 = 0 : scoreglobal = 0 : level = 1
	EndIf
	If (KeyHit(61)) Then
		cpu_vai_ei = 2
		nollaus()
		scoreglobal = 0
		pisteet1 = 0 : pisteet2 = 0 : pisteet3 = 0 : scoreglobal = 0 : level = 1
	EndIf
	If (KeyHit(62)) Then
		cpu_vai_ei = 3
		nollaus()
		scoreglobal = 0
		pisteet1 = 0 : pisteet2 = 0 : pisteet3 = 0 : scoreglobal = 0 : level = 1
	EndIf
EndIf
End Function

Function belts()
	If (pisteet1 > 5999) Then
		Color 255,255,0 : vyo1$ = "yellow belt"
		Else
		Color 255,255,255 : vyo1$ = "white belt"
	EndIf
	If (pisteet1 > 11999) Then Color 0,255,0 : vyo1$ = "green belt"
	If (pisteet1 > 17999) Then Color 255,0,255 : vyo1$ = "purple belt"
	If (pisteet1 > 25999) Then Color 150,150,50 : vyo1$ = "brown belt"
	If (pisteet1 > 39999) Then Color 255,255,255 : vyo1$ = "black belt"

	Text 80,40,vyo1$

	If (pisteet2 > 5999) Then
		Color 255,255,0 : vyo2$ = "yellow belt"
		Else
		Color 255,255,255 : vyo2$ = "white belt"
	EndIf
	If (pisteet2 > 11999) Then Color 0,255,0 : vyo2$ = "green belt"
	If (pisteet2 > 17999) Then Color 255,0,255 : vyo2$ = "purple belt"
	If (pisteet2 > 25999) Then Color 150,150,50 : vyo2$ = "brown belt"
	If (pisteet2 > 39999) Then Color 255,255,255 : vyo2$ = "black belt"
	
	Text 550,40,vyo2$
	
	
	If (pisteet3 > 5999) Then
		Color 255,255,0 : vyo3$ = "yellow belt"
		Else
		Color 255,255,255 : vyo3$ = "white belt"
	EndIf
	If (pisteet3 > 11999) Then Color 0,255,0 : vyo3$ = "green belt"
	If (pisteet3 > 17999) Then Color 255,0,255 : vyo3$ = "purple belt"
	If (pisteet3 > 25999) Then Color 150,150,50 : vyo3$ = "brown belt"
	If (pisteet3 > 39999) Then Color 255,255,255 : vyo3$ = "black belt"
	
	Text 360,40,vyo3$
	
	Color 255,255,255
End Function