
;-----------------------------
;18.2.08
;Lisätty nulltimer-muuttuja ja korjattu aani_paalle -muuttuja -> ei vikoja tiedossa.
;-----------------------------



Function move_cpu2()
osuu2 = 0 		;Nollataan osumat.
osu_xf2= 50	;Osumaetäisyyksien
osu_xh2 = 90	;perus-
osu_xfs2 = 30	;asetuk-
osu_xhs2 = 60	;set.


If (MilliSecs() > aloitus_timer + 2000) Then

;kuka kohteeksi? --------->
If (MilliSecs() > pick2 + 10000) Then
	pick_the_man2 = Rnd(4)
	pick2 = MilliSecs()
EndIf
If (pause2 = 0) Then
	If (pick_the_man2 < 2) Then 
		If (x2 => (x + 100)) Then
			act2 = 3
			suunta2= 0
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf	
		If (x => (x2 + 100)) Then
			act2 = 2
			suunta2= 1
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf
	Else
			If (x2 => (x3 + 100)) Then
			act2 = 3
			suunta2= 0
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf	
		If (x3 => (x2 + 100)) Then
			act2 = 2
			suunta2= 1
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf
	EndIf
EndIf

If (MilliSecs() > pausetus2 + 3000) Then pause2 = 0

;------------------<
If (isku2 = 0) Then
If (actor2= 0) Then
	If (act2 = 12) Then actor2= 1;aloittaa liikesarjan
	If (act2 = 13) Then actor2= 6;-""-

	;rajat
	If (x2 < 100) Then 
		act2 = 2
		pause2 = 1
		suunta2= 1
		cpu_timer2 = MilliSecs()
	EndIf
	If (x2 > 700) Then 
		act2 = 3
		pause2 = 1
		suunta2= 0
		cpu_timer2 = MilliSecs()
	EndIf

	;jos kävellään, niin pidennetään sitä
	If ((act2 = 2 Or act2 = 3) And actwalk2 = 0) Then
		abcde2 = abcde2 + 500
		actwalk2 = 1
	EndIf

	;liikkeiden arvonta									 ---------------- KYKYJEN SÄÄTÖ
	If (MilliSecs() > cpu_timer2 + abcde2) Then ;500+abcde2 on alkup.
		actwalk2 = 0
		act2 = Rnd(15)
		act4 = 20
		cpu_timer2 = MilliSecs()
		abcde2 = Rnd(100,500)
;		abcde2 = Rnd(200,1000)
	EndIf

	If (MilliSecs() > cpu_timer2 + 4000) Then 
		act2 = 0
	EndIf

	If (act2 = 5) Then 
		If (aaaa = Rnd(2)) <2 Then 
			act4 = 20
			If (actwalk2 = 0) Then
				abcde2 = abcde2 + 3500
				actwalk2 = 1
			EndIf
		Else
			act4 = 0
		EndIf
	EndIf
	
Else	;liikesarjojen  teko
	If ((actor2> 0 And actor2< 6)) Then
		If (MilliSecs() > cpu_timer2 + 500) Then 
			actor2= actor2+ 1
			cpu_timer2 = MilliSecs()
			PlaySound mahapotku_aani
	
			If (actor2= 2) Then act2 = 9:act4 = 20
			If (actor2= 3) Then act2 = 8:act4 = 0
			If (actor2= 4) Then act2 = 10:act4 = 0
			If (actor2= 5) Then act2 = 0:actor2= 0
		EndIf
	EndIf
	If ((actor2> 5 And actor2< 11)) Then
			If (MilliSecs() > cpu_timer2 + 500) Then 
			actor2= actor2+ 1
			cpu_timer2 = MilliSecs()
			PlaySound nilkka_aani
	
			If (actor2= 7) Then act2 = 8:act4 = 20
			If (actor2= 8) Then act2 = 6:act4 = 20
			If (actor2= 9) Then act2 = 11:act4 = 0
			If (actor2= 10) Then act2 = 0:actor2= 0
		EndIf
	EndIf
EndIf
EndIf ;---------------------------------iksu3=0



;-------------------------------------------------------------------
If (osuma2 <> 0) Then	;jos on saanut osuman niin kaatuu
    If (suunta2= 0 And suunnat2 = 0) Then
        DrawImage osumat2,x2,y2+30,osuma2_frame+9        ;		
    Else                                                ;
        DrawImage osumat2,x2,y2+30,osuma2_frame       ;
    EndIf

	If (osuma2 > 0) Then
		If (osuma2_frame < (osuma2_aloitus + 2) And MilliSecs() > osuma2_timer  + 150) Then
				osuma2_frame = osuma2_frame + 1
				osuma2_timer  = MilliSecs()
		Else If (MilliSecs() > osuma2_timer  + 2000) Then 
				osuma2 = 0
		Else If ((MilliSecs() < osuma2_timer  + 2000) And (MilliSecs() > osuma2_timer  + 200)) Then 
				
			If (suunta2= 1 Or suunnat2 = 0) Then
				DrawImage stars,x2+100,y2+85,stars_frame
			Else
				DrawImage stars,x2+0,y2+85,stars_frame
			EndIf
					
			If (MilliSecs() > stars_frame_timer + 100) Then
				If (stars_frame < 2) Then
					stars_frame = stars_frame + 1
						stars_frame_timer = MilliSecs()
				Else
					stars_frame = 0
				EndIf
			EndIf
	
		EndIf
	EndIf
Else
;-------------------------------------------------------------------tähän asti
If (isku2 > 1) Then
        If (isku2 = 18 And (MilliSecs() > hyppy_timer2 + 90)) Then ;voltti eteen
                If (isku_frame2 = 27) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
                Else
					isku_frame2 = isku_frame2 + 1
		
					If (suunta2= 0) Then
						If (x2 < x_reuna_a) Then x2 = x2 - 30				
					Else
						If (x2 > x_reuna_b) Then x2 = x2 + 30
					EndIf
		
					hyppy_timer2 = MilliSecs()				
                EndIf
        EndIf

        If (isku2 = 17 And (MilliSecs() > hyppy_timer2 + 90)) Then ;voltti taakse
                If (isku_frame2 = 22) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
                Else
					isku_frame2 = isku_frame2 + 1

					If (suunta2= 0) Then
						If (x2 < x_reuna_b) Then x2 = x2 + 30			
					Else
						If (x2 > x_reuna_a) Then x2 = x2 - 30
					EndIf
		
					hyppy_timer2 = MilliSecs()				
                EndIf
        EndIf

        If (isku2 = 7 And (MilliSecs() > hyppy_timer2 + 170)) Then ;kierrepotku
                If (isku_frame2 = 15) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
						osuu2 = 1
                Else
					isku_frame2 = isku_frame2 + 1
					
					hyppy_timer2 = MilliSecs()				
                EndIf
        EndIf

        If (isku2 = 4 And (MilliSecs() > hyppy_timer2 + 100)) Then ;potku ylös
                If (isku_frame2 = 9) Then
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
						osuu2 = 1
                Else
                        isku_frame2 = 9
                        hyppy_timer2 = MilliSecs()
                EndIf
        EndIf

       		; If ((isku2 = 3) And (MilliSecs() > ukko_timer2 + 40)) Then
           ;     If (suunta2= 1) Then
          ;               If (x2<500) Then
         ;                       x2 = x2 + 24
        ;                        ukko_timer2 = MilliSecs()
       ;                 EndIf
      ;             Else
     ;                    If (x2>150) Then
    ;                            x2 = x2 - 24
   ;                             ukko_timer2 = MilliSecs()
  ;                      EndIf
 ;               EndIf
;        EndIf

        If ((isku2 = 3) And (MilliSecs() > ukko_timer2 + 80)) Then ;-----------------------<<<<<<<<<< ;hyppypotku
                If (suunta2 = 1) Then
                         If (x2<600) Then;-------------------------------------------------<<<<<<<<<<
                                x2 = x2 + 24
                                ukko_timer2 = MilliSecs()
                        EndIf
                   Else
                         If (x2>0) Then;--------------------------------------------------<<<<<<<<<<<
                                x2 = x2 - 24
                                ukko_timer2 = MilliSecs()
                        EndIf
                EndIf
        EndIf

        If ((isku2 <> 4) And (MilliSecs() > hyppy_timer2+300)) Then
                isku2 = 0
                hyppy_alas_timer2 = MilliSecs()
                liike_timer2 = MilliSecs()
				osuu2 = 1 ; !

        EndIf
Else
;------------------------------------------ - - ------------ --------- ----------- ---------- -  -    ------------------ -- --- - ----
If (MilliSecs() > aloitus_timer + 2000) Then
        If (MilliSecs() > liike_timer2 + 100) Then
                        isku2 = 0
                        If (act4 = (n_control_cpu)) Then                ;napin kanssa liikkeet alkaa...
                                isku_frame2 = 3
                                isku2 = 1
                                ei_mitaan_timer2 = MilliSecs()
                        If (act2 = (n_vala_cpu)) Then
	                           isku_frame2 = 4
    	                       isku2 = 1 

								suunta2= 0
								osuu2 =1
                      	        	If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                        aani_paalle2 = 4
 		                        EndIf
                        Else If (act2 = (n_oala_cpu)) Then ;nilkkapotku
	                            isku_frame2 = 4
  	                            isku2 = 1
  								suunta2= 1
  
								osu_xh2 = 100
								osu_xf2= 80
								osuu2 = 1
                            	If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                        aani_paalle2 = 4
 		                        EndIf
                        Else If (act2 = (n_oikea_cpu)) Then
	         	           			If(suunta2= 0) Then
									    isku_frame2 = 6
        	                            isku2 = 1
										osuu2 = 1
										
										liike_timer2 = MilliSecs()
										
										osu_xh2 = 120
										osu_xf2= 110
        
	   	                        If (aani_paalle2 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle2 = 6
                                        EndIf
									Else
										isku_frame2 = 13
										isku2 = 7
										hyppy_timer2 = MilliSecs()
										ei_mitaan_timer2 = MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle2 = 6
									EndIf
                        Else If (act2 = (n_ylos_cpu) And (MilliSecs() > hyppy_alas_timer2+200)) Then ;Hyppypotku.
                                isku_frame2 = 7
                                isku2 = 3
                                hyppy_timer2 = MilliSecs()


								osu_xh2 = 80
								osu_xf2= 70
			
                                If (aani_paalle2 <> 6) Then
                                      ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                      aani_paalle2 = 6
                                 EndIf

                        Else If (act2 = (n_vasen_cpu)) Then		;--- kierrepotkua
	         	           			If(suunta2= 1) Then
									    isku_frame2 = 6
        	                            isku2 = 1
										osuu2 = 1
										
										liike_timer2 = MilliSecs()
																				
            	                        If (aani_paalle2 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle2 = 6
                                        EndIf
									Else
										isku_frame2 = 13
										isku2 = 7
										osuu2 = 1 ; !
										hyppy_timer2 = MilliSecs()
										ei_mitaan_timer2 = MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle2 = 6
									EndIf
                        Else If (act2 = (n_oyla_cpu) And voltti = 0) Then		;--- voltti taaksepäin
								If (suunta2= 0) Then
									isku_frame2 = 16
									voltti = 1
									isku2 = 18
								Else
									isku_frame2 = 22
									voltti = 1
									isku2 = 17
								EndIf

								hyppy_timer2 = MilliSecs()
								ei_mitaan_timer2 = MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle2 = 6

                        Else If (act2 = (n_vyla_cpu) And voltti = 0) Then		;--- voltti eteenpäin
								If (suunta2= 0) Then
									isku_frame2 = 22
									voltti = 1
									isku2 = 17
								Else
									isku_frame2 = 16
									voltti = 1
									isku2 = 18
								EndIf
								hyppy_timer2 = MilliSecs()
								ei_mitaan_timer2 = MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle2 = 6




                        Else If (act2 = (n_alas_cpu) And alas_nollaus2 = 0) Then				;Maha - kääntö
								alas_nollaus2 = 1
								If (suunta2= 0) Then
                                isku_frame2 = 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2= 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle2 = 4
                                EndIf

								suunta2= 1
								Else
                                isku_frame2 = 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2= 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle2 = 4
                                EndIf
								suunta2= 0
								EndIf
                        
;						Else If Not act = (n_vala_cpu) Then 
;							alas_nollaus2 = 0
						EndIf

						
						;Ilman controllia tulevat isku2t alkaa tästä.
                        Else If (act2 = (n_oyla_cpu)) Then	
                                isku_frame2 = 5
                                isku2 = 1
								osuu2 = 1 ; !

								osu_xh2 = 60
								osu_xf2= 70

                                ei_mitaan_timer2 = MilliSecs()

								suunta2= 0
                                If (aani_paalle2 <> 4) Then
                                		;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku2 -ääni
                                EndIf
                                 aani_paalle2 = 4
                        Else If (act2 = (n_alas_cpu)) Then
                                isku_frame2 = 2
                                isku2 = 1
								osuu2 = 1 ; !
                                ei_mitaan_timer2 = MilliSecs()

                                If (aani_paalle2 <> 88) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku2 -ääni
                                        aani_paalle2 = 88
                                EndIf


                        Else If (act2 = (n_ylos_cpu) And (MilliSecs() > hyppy_alas_timer2+200)) Then
                                isku_frame2 = 1
                                isku2 = 2
                                hyppy_timer2 = MilliSecs()
                                ei_mitaan_timer2 = MilliSecs()

                        Else If (act2 = (n_vala_cpu)) Then				;Mahaisku2.
								If (suunta2= 0) Then

                                isku_frame2 = 8
                                isku2 = 4
                                hyppy_timer2 = MilliSecs()
                                ei_mitaan_timer2 = MilliSecs()
                                If (aani_paalle2 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle2 = 6
                                EndIf
								Else
                                isku_frame2 = 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2= 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku2 -ääni
                                        aani_paalle2 = 4
                                EndIf
								EndIf
                       Else If (act2 = (n_vyla_cpu)) Then				;isku2 ylös.
                                isku_frame2 = 5
                                isku2 = 1
								osuu2 = 1
								suunta2= 1

								osu_xhs2 = 60
								osu_xfs2 = 40
								
                                ei_mitaan_timer2 = MilliSecs()
                                If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku2 -ääni
                                EndIf
                                aani_paalle2 = 4
                        Else If (act2 = (n_oala_cpu)) Then				;Potku ylös.
								If (suunta2= 1) Then

                                isku_frame2 = 8
                                isku2 = 4
                                hyppy_timer2 = MilliSecs()
                                ei_mitaan_timer2 = MilliSecs()
                                If (aani_paalle2 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle2 = 6
                                EndIf
									Else
                                isku_frame2 = 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2= 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku2 -ääni
                                        aani_paalle2 = 4
                                EndIf

								EndIf
                        EndIf                                                ;...tähän

liike_timer2 = MilliSecs()
EndIf
EndIf ;liikkeiden loppu...
If (MilliSecs() > nulltimer2 + 500) Then
	isku2 = 0
	nulltimer2 = MilliSecs()
EndIf
;Kävely alkaa
                        If (act2 = (kavely_oikea_cpu) And x2<x_reuna_a) Then
;oikealle
								isku2 = 0
                                aani_paalle2 = 0
                                If (MilliSecs() > ukko_timer2+100) Then
                                        ukko_timer2 = MilliSecs()
                                        ukko_frame2 = ukko_frame2 + 1
                                        If (ukko_frame2 = 4) Then ukko_frame2 = 0
                                        x2 = x2 + 10
	                                ei_mitaan_timer2 = MilliSecs()
                                EndIf
                        EndIf

                        If (act2 = (kavely_vasen_cpu) And x2>x_reuna_b) Then  
;vasemmalle
								isku2 = 0
                                aani_paalle2 = 0
                                If (MilliSecs() > ukko_timer2+100) Then
                                        ukko_timer2 = MilliSecs()
                                        ukko_frame2 = ukko_frame2 - 1
                                        If (ukko_frame2 = -1) Then ukko_frame2 = 3
                                        x2 = x2 - 10
	                                ei_mitaan_timer2 = MilliSecs()
                                EndIf
                        EndIf
                        ;Kävely loppuu

            ;Kävely loppuu
EndIf

;Color 255,100,200
;Text 100,100,isku_frame2
;höpötys ------------------
If ((MilliSecs() > ei_mitaan_timer2 + 8000) And (MilliSecs() < ei_mitaan_timer2 + 10000)) Then
                If (MilliSecs() > hyppy_timer2 + 200) Then
                        If (isku_frame2 <> 11) Then
                                isku_frame2 = 11
                        Else
                                isku_frame2 = 10
                        EndIf
                        hyppy_timer2 = MilliSecs()
                EndIf
;pöpötys päättyy ----------
;	If (punainenonvalkoinen = 0) Then
               If (suunta2 = 0) Then                                        ;
                        DrawImage iskuja2,x2,y2,isku_frame2
                Else                                                                        ;
                        DrawImage iskuja_ts2,x2,y2,isku_frame2        ;
                EndIf
;	Else
 ;              If (suunta2 = 0) Then                                        ;
  ;                      DrawImage iskuja4,x2,y2,isku_frame2
   ;             Else                                                                        ;
    ;                    DrawImage iskuja_ts4,x2,y2,isku_frame2        ;
	;			EndIf
;	EndIf
Else
;	If (punainenonvalkoinen = 0) Then
               If (isku2 = 0) Then
                        If (suunta2 = 0) Then                                        ;
                                DrawImage ukko2,x2,y2,ukko_frame2
                        Else
                                DrawImage ukko_ts2,x2,y2,ukko_frame2
                        EndIf
                Else
                        If (suunta2 = 0) Then                                        ;
                                DrawImage iskuja2,x2,y2,isku_frame2
                        Else                                                                        ;
                                DrawImage iskuja_ts2,x2,y2,isku_frame2        ;
                        EndIf                                                                        ;
                EndIf
;	Else
 ;              If (isku2 = 0) Then
  ;                      If (suunta2 = 0) Then                                        ;
   ;                             DrawImage ukko4,x2,y2,ukko_frame2
    ;                    Else
     ;                           DrawImage ukko_ts4,x2,y2,ukko_frame2
      ;                  EndIf
       ;         Else
        ;                If (suunta2 = 0) Then                                        ;
         ;                       DrawImage iskuja4,x2,y2,isku_frame2
          ;              Else                                                                        ;
           ;                     DrawImage iskuja_ts4,x2,y2,isku_frame2        ;
            ;            EndIf                                                                        ;
             ;   EndIf
;	EndIf	
EndIf

EndIf
EndIf
End Function