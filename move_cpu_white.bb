
;-----------------------------
;30.11.08 cpu3 (valkoinen)
;-----------------------------



Function move_cpu3()
osuu = 0 		;Nollataan osumat.
osu_xf= 50	;Osumaetäisyyksien
osu_xh = 90	;perus-
osu_xfs = 30	;asetuk-
osu_xhs = 60	;set.


If (MilliSecs() > aloitus_timer + 2000) Then

;kuka kohteeksi? --------->
If (MilliSecs() > pick2 + 10000) Then
	pick_the_man2 = Rnd(4)
	pick2 = MilliSecs()
EndIf
If (pause2 = 0) Then
	If (pick_the_man2 < 2) Then 
		If (x => (x2 + 100)) Then
			act2 = 3
			suunta= 0
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf	
		If (x2 => (x + 100)) Then
			act2 = 2
			suunta= 1
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf
	Else
			If (x3 => (x + 100)) Then
			act2 = 3
			suunta= 0
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf	
		If (x => (x3 + 100)) Then
			act2 = 2
			suunta= 1
		Else
			pause2 = 1
			pausetus2 = MilliSecs()
		EndIf
	EndIf
EndIf

If (MilliSecs() > pausetus2 + 3000) Then pause2 = 0

;------------------<
If (isku = 0) Then
If (actor2= 0) Then
	If (act2 = 12) Then actor2= 1;aloittaa liikesarjan
	If (act2 = 13) Then actor2= 6;-""-

	;rajat
	If (x2 < 100) Then 
		act2 = 2
		pause2 = 1
		suunta= 1
		cpu_timer2 = MilliSecs()
	EndIf
	If (x2 > 700) Then 
		act2 = 3
		pause2 = 1
		suunta= 0
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
If (osuma <> 0) Then	;jos on saanut osuman niin kaatuu
    If (suunta = 0 And suunnat2 = 0) Then
        DrawImage osumat,x,y+30,osuma_frame+9        ;		
    Else                                                ;
        DrawImage osumat,x,y+30,osuma_frame       ;
    EndIf

	If (osuma > 0) Then
		If (osuma_frame < (osuma_aloitus + 2) And MilliSecs() > osuma_timer  + 150) Then
				osuma_frame = osuma_frame + 1
				osuma_timer  = MilliSecs()
		Else If (MilliSecs() > osuma_timer  + 2000) Then 
				osuma = 0
		Else If ((MilliSecs() < osuma_timer  + 2000) And (MilliSecs() > osuma_timer  + 200)) Then 
				
			If (suunta= 1 Or suunnat2 = 0) Then
				DrawImage stars,x+100,y+85,stars_frame
			Else
				DrawImage stars,x+0,y+85,stars_frame
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
If (isku > 1) Then
        If (isku = 18 And (MilliSecs() > hyppy_timer + 90)) Then ;voltti eteen
                If (isku_frame = 27) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle2 = 0
                        isku = 0
                        liike_timer = MilliSecs()
                Else
					isku_frame = isku_frame + 1
		
					If (suunta= 0) Then
						If (x < 680) Then x = x + 30				
					Else
						If (x > 10) Then x = x - 30
					EndIf
		
					hyppy_timer = MilliSecs()				
                EndIf
        EndIf

        If (isku = 17 And (MilliSecs() > hyppy_timer + 90)) Then ;voltti taakse
                If (isku_frame = 22) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle2 = 0
                        isku = 0
                        liike_timer = MilliSecs()
                Else
					isku_frame = isku_frame + 1

					If (suunta= 0) Then
						If (x > 10) Then x = x - 30			
					Else
						If (x < 680) Then x = x + 30
					EndIf
		
					hyppy_timer = MilliSecs()				
                EndIf
        EndIf

        If (isku = 7 And (MilliSecs() > hyppy_timer + 170)) Then ;kierrepotku
                If (isku_frame = 15) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
						aani_paalle2 = 0
                        isku = 0
                        liike_timer = MilliSecs()
						osuu = 1
                Else
					isku_frame = isku_frame + 1
					
					hyppy_timer = MilliSecs()				
                EndIf
        EndIf

        If (isku = 4 And (MilliSecs() > hyppy_timer + 100)) Then ;potku ylös
                If (isku_frame = 9) Then
						aani_paalle2 = 0
                        isku = 0
                        liike_timer = MilliSecs()
						osuu = 1
                Else
                        isku_frame = 9
                        hyppy_timer = MilliSecs()
                EndIf
        EndIf

        If ((isku = 3) And (MilliSecs() > ukko_timer + 40)) Then
                If (suunta= 1) Then
                         If (x<500) Then
                                x = x + 24
                                ukko_timer = MilliSecs()
                        EndIf
                   Else
                         If (x>150) Then
                                x = x - 24
                                ukko_timer = MilliSecs()
                        EndIf
                EndIf
        EndIf

        If ((isku <> 4) And (MilliSecs() > hyppy_timer+300)) Then
                isku = 0
                hyppy_alas_timer2 = MilliSecs()
                liike_timer = MilliSecs()
				osuu = 1 ; !

        EndIf
Else
;------------------------------------------ - - ------------ --------- ----------- ---------- -  -    ------------------ -- --- - ----
If (MilliSecs() > aloitus_timer + 2000) Then
        If (MilliSecs() > liike_timer + 100) Then
                        isku = 0
                        If (act4 = (n_control_cpu)) Then                ;napin kanssa liikkeet alkaa...
                                isku_frame = 3
                                isku = 1
                                ei_mitaan_timer = MilliSecs()
                        If (act2 = (n_vala_cpu)) Then
	                           isku_frame = 4
    	                       isku = 1 

								suunta= 0
								osuu =1
                      	        	If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                        aani_paalle2 = 4
 		                        EndIf
                        Else If (act2 = (n_oala_cpu)) Then ;nilkkapotku
	                            isku_frame = 4
  	                            isku = 1
  								suunta= 1
  
								osu_xh = 100
								osu_xf= 80
								osuu = 1
                            	If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                        aani_paalle2 = 4
 		                        EndIf
                        Else If (act2 = (n_oikea_cpu)) Then
	         	           			If(suunta= 0) Then
									    isku_frame = 6
        	                            isku = 1
										osuu = 1
										
										liike_timer = MilliSecs()
										
										osu_xh = 120
										osu_xf= 110
        
	   	                        If (aani_paalle2 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle2 = 6
                                        EndIf
									Else
										isku_frame = 13
										isku = 7
										hyppy_timer = MilliSecs()
										ei_mitaan_timer = MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle2 = 6
									EndIf
                        Else If (act2 = (n_ylos_cpu) And (MilliSecs() > hyppy_alas_timer2+200)) Then ;Hyppypotku.
                                isku_frame = 7
                                isku = 3
                                hyppy_timer = MilliSecs()


								osu_xh = 80
								osu_xf= 70
			
                                If (aani_paalle2 <> 6) Then
                                      ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                      aani_paalle2 = 6
                                 EndIf

                        Else If (act2 = (n_vasen_cpu)) Then		;--- kierrepotkua
	         	           			If(suunta= 1) Then
									    isku_frame = 6
        	                            isku = 1
										osuu = 1
										
										liike_timer = MilliSecs()
																				
            	                        If (aani_paalle2 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle2 = 6
                                        EndIf
									Else
										isku_frame = 13
										isku = 7
										osuu = 1 ; !
										hyppy_timer = MilliSecs()
										ei_mitaan_timer = MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle2 = 6
									EndIf
                        Else If (act2 = (n_oyla_cpu) And voltti = 0) Then		;--- voltti taaksepäin
								If (suunta= 0) Then
									isku_frame = 22
									voltti = 1
									isku = 18
								Else
									isku_frame = 16
									voltti = 1
									isku = 17
								EndIf

								hyppy_timer = MilliSecs()
								ei_mitaan_timer = MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle2 = 6

                        Else If (act2 = (n_vyla_cpu) And voltti = 0) Then		;--- voltti eteenpäin
								If (suunta= 0) Then
									isku_frame = 16
									voltti = 1
									isku = 17
								Else
									isku_frame = 22
									voltti = 1
									isku = 18
								EndIf
								hyppy_timer = MilliSecs()
								ei_mitaan_timer = MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle2 = 6




                        Else If (act2 = (n_alas_cpu) And alas_nollaus2 = 0) Then				;Maha - kääntö
								alas_nollaus2 = 1
								If (suunta= 0) Then
                                isku_frame = 0
                                isku = 1
								osu_xh = 110
								osu_xf= 100

                                ei_mitaan_timer = MilliSecs()
								osuu = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle2 = 4
                                EndIf

								suunta= 1
								Else
                                isku_frame = 0
                                isku = 1
								osu_xh = 110
								osu_xf= 100

                                ei_mitaan_timer = MilliSecs()
								osuu = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle2 = 4
                                EndIf
								suunta= 0
								EndIf
                        
;						Else If Not act = (n_vala_cpu) Then 
;							alas_nollaus2 = 0
						EndIf

						
						;Ilman controllia tulevat iskut alkaa tästä.
                        Else If (act2 = (n_oyla_cpu)) Then	
                                isku_frame = 5
                                isku = 1
								osuu = 1 ; !

								osu_xh = 60
								osu_xf= 70

                                ei_mitaan_timer = MilliSecs()

								suunta= 0
                                If (aani_paalle2 <> 4) Then
                                		;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku -ääni
                                EndIf
                                 aani_paalle2 = 4
                        Else If (act2 = (n_alas_cpu)) Then
                                isku_frame = 2
                                isku = 1
								osuu = 1 ; !
                                ei_mitaan_timer = MilliSecs()

                                If (aani_paalle2 <> 88) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku -ääni
                                        aani_paalle2 = 88
                                EndIf


                        Else If (act2 = (n_ylos_cpu) And (MilliSecs() > hyppy_alas_timer2+200)) Then
                                isku_frame = 1
                                isku = 2
                                hyppy_timer = MilliSecs()
                                ei_mitaan_timer = MilliSecs()

                        Else If (act2 = (n_vala_cpu)) Then				;Mahaisku.
								If (suunta= 0) Then

                                isku_frame = 8
                                isku = 4
                                hyppy_timer = MilliSecs()
                                ei_mitaan_timer = MilliSecs()
                                If (aani_paalle2 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle2 = 6
                                EndIf
								Else
                                isku_frame = 0
                                isku = 1
								osu_xh = 110
								osu_xf= 100

                                ei_mitaan_timer = MilliSecs()
								osuu = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku -ääni
                                        aani_paalle2 = 4
                                EndIf
								EndIf
                       Else If (act2 = (n_vyla_cpu)) Then				;isku ylös.
                                isku_frame = 5
                                isku = 1
								osuu = 1
								suunta= 1

								osu_xhs = 60
								osu_xfs = 40
								
                                ei_mitaan_timer = MilliSecs()
                                If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku -ääni
                                EndIf
                                aani_paalle2 = 4
                        Else If (act2 = (n_oala_cpu)) Then				;Potku ylös.
								If (suunta= 1) Then

                                isku_frame = 8
                                isku = 4
                                hyppy_timer = MilliSecs()
                                ei_mitaan_timer = MilliSecs()
                                If (aani_paalle2 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle2 = 6
                                EndIf
									Else
                                isku_frame = 0
                                isku = 1
								osu_xh = 110
								osu_xf= 100

                                ei_mitaan_timer = MilliSecs()
								osuu = 1
								If (aani_paalle2 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku -ääni
                                        aani_paalle2 = 4
                                EndIf

								EndIf
                        EndIf                                                ;...tähän

liike_timer = MilliSecs()
EndIf
EndIf ;liikkeiden loppu...
If (MilliSecs() > nulltimer2 + 500) Then
	isku = 0
	nulltimer2 = MilliSecs()
EndIf
;Kävely alkaa
                        If (act2 = (kavely_oikea_cpu) And x<680) Then
;oikealle
								isku = 0
                                aani_paalle2 = 0
                                If (MilliSecs() > ukko_timer+100) Then
                                        ukko_timer = MilliSecs()
                                        ukko_frame = ukko_frame + 1
                                        If (ukko_frame = 4) Then ukko_frame = 0
                                        x = x + 10
	                                ei_mitaan_timer = MilliSecs()
                                EndIf
                        EndIf

                        If (act2 = (kavely_vasen_cpu) And x>10) Then  
;vasemmalle
								isku = 0
                                aani_paalle2 = 0
                                If (MilliSecs() > ukko_timer+100) Then
                                        ukko_timer = MilliSecs()
                                        ukko_frame = ukko_frame - 1
                                        If (ukko_frame = -1) Then ukko_frame = 3
                                        x = x - 10
	                                ei_mitaan_timer = MilliSecs()
                                EndIf
                        EndIf
                        ;Kävely loppuu

            ;Kävely loppuu
EndIf

;Color 255,100,200
;Text 100,100,isku_frame
;höpötys ------------------
If ((MilliSecs() > ei_mitaan_timer + 8000) And (MilliSecs() < ei_mitaan_timer + 10000)) Then
                If (MilliSecs() > hyppy_timer + 200) Then
                        If (isku_frame <> 11) Then
                                isku_frame = 11
                        Else
                                isku_frame = 10
                        EndIf
                        hyppy_timer = MilliSecs()
                EndIf
;pöpötys päättyy ----------
;	If (punainenonvalkoinen = 0) Then
               If (suunta = 0) Then                                        ;
                        DrawImage iskuja_ts,x,y,isku_frame
                Else                                                                        ;
                        DrawImage iskuja,x,y,isku_frame        ;
                EndIf
;	Else
 ;              If (suunta = 0) Then                                        ;
  ;                      DrawImage iskuja4,x,y2,isku_frame
   ;             Else                                                                        ;
    ;                    DrawImage iskuja_ts4,x,y2,isku_frame        ;
	;			EndIf
;	EndIf
Else
;	If (punainenonvalkoinen = 0) Then
               If (isku = 0) Then
                        If (suunta = 0) Then                                        ;
                                DrawImage ukko_ts,x,y,ukko_frame
                        Else
                                DrawImage ukko, x,y,ukko_frame
                        EndIf
                Else
                        If (suunta = 0) Then                                        ;
                                DrawImage iskuja_ts,x,y,isku_frame
                        Else                                                                        ;
                                DrawImage iskuja,x,y,isku_frame       ;
                        EndIf                                                                        ;
                EndIf
;	Else
 ;              If (isku = 0) Then
  ;                      If (suunta = 0) Then                                        ;
   ;                             DrawImage ukko4,x,y2,ukko_frame
    ;                    Else
     ;                           DrawImage ukko_ts4,x,y2,ukko_frame
      ;                  EndIf
       ;         Else
        ;                If (suunta = 0) Then                                        ;
         ;                       DrawImage iskuja4,x,y2,isku_frame
          ;              Else                                                                        ;
           ;                     DrawImage iskuja_ts4,x,y2,isku_frame        ;
            ;            EndIf                                                                        ;
             ;   EndIf
;	EndIf	
EndIf

EndIf
EndIf
End Function