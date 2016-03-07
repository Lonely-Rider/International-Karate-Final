
;-----------------------------
;3.3.16 muutettu hyppypotkun säätöjä (isku3)
;19.2.08 cpu (vihreä)
;Lisätty nulltimer-muuttuja ja korjattu aani_paalle -muuttuja -> ei vikoja tiedossa.
;-----------------------------



Function move_cpu() 
osuu3 = 0 		;Nollataan osumat.
osu_xf3 = 50	;Osumaetäisyyksien
osu_xh3 = 90	;perus-
osu_xfs3 = 30	;asetuk-
osu_xhs3 = 60	;set.


If (MilliSecs() > aloitus_timer + 2000) Then

;kuka kohteeksi? --------->
If (MilliSecs() > pick + 10000) Then
	pick_the_man = Rnd(4)
	pick = MilliSecs()
EndIf
If (pause = 0) Then
	If (pick_the_man < 2) Then 
		If (x3 => (x + 100)) Then
			act = 3
			suunta_c = 0
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf	
		If (x => (x3 + 100)) Then
			act = 2
			suunta_c = 1
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf
	Else
			If (x3 => (x2 + 100)) Then
			act = 3
			suunta_c = 0
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf	
		If (x2 => (x3 + 100)) Then
			act = 2
			suunta_c = 1
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf
	EndIf
EndIf

If (MilliSecs() > pausetus + 3000) Then pause = 0

;------------------<
If (isku3 = 0) Then
If (actor = 0) Then
	If (act = 12) Then actor = 1;aloittaa liikesarjan
	If (act = 13) Then actor = 6;-""-

	;rajat
	If (x3 < 100) Then 
		act = 2
		pause = 1
		suunta_c = 1
		cpu_timer = MilliSecs()
	EndIf
	If (x3 > 700) Then 
		act = 3
		pause = 1
		suunta_c = 0
		cpu_timer = MilliSecs()
	EndIf

	;jos kävellään, niin pidennetään sitä
	If ((act = 2 Or act = 3) And actwalk = 0) Then
		abcde = abcde + 500
		actwalk = 1
	EndIf

	;liikkeiden arvonta									 ---------------- KYKYJEN SÄÄTÖ
	If (MilliSecs() > cpu_timer + abcde) Then ;500+abcde on alkup.
		actwalk = 0
		act = Rnd(15)
		act3 = 20
		cpu_timer = MilliSecs()
		abcde = Rnd(100,500)
;		abcde = Rnd(200,1000)
	EndIf

	If (MilliSecs() > cpu_timer + 4000) Then 
		act = 0
	EndIf

	If (act = 5) Then 
		If (aaaa = Rnd(2)) <2 Then 
			act3 = 20
			If (actwalk = 0) Then
				abcde = abcde + 3500
				actwalk = 1
			EndIf
		Else
			act3 = 0
		EndIf
	EndIf
	
Else	;liikesarjojen  teko
	If ((actor > 0 And actor < 6)) Then
		If (MilliSecs() > cpu_timer + 500) Then 
			actor = actor + 1
			cpu_timer = MilliSecs()
			PlaySound mahapotku_aani
	
			If (actor = 2) Then act = 9:act3 = 20
			If (actor = 3) Then act = 8:act3 = 0
			If (actor = 4) Then act = 10:act3 = 0
			If (actor = 5) Then act = 0:actor = 0
		EndIf
	EndIf
	If ((actor > 5 And actor < 11)) Then
			If (MilliSecs() > cpu_timer + 500) Then 
			actor = actor + 1
			cpu_timer = MilliSecs()
			PlaySound nilkka_aani
	
			If (actor = 7) Then act = 8:act3 = 20
			If (actor = 8) Then act = 6:act3 = 20
			If (actor = 9) Then act = 11:act3 = 0
			If (actor = 10) Then act = 0:actor = 0
		EndIf
	EndIf
EndIf
EndIf ;---------------------------------iksu3=0



;-------------------------------------------------------------------
If (osuma3 <> 0) Then	;jos on saanut osuman niin kaatuu
    If (suunta_c = 0 And suunnat3 = 0) Then
        DrawImage osumat3,x3,y3+30,osuma3_frame+9        ;		
    Else                                                ;
        DrawImage osumat3,x3,y3+30,osuma3_frame       ;
    EndIf


	If (osuma3 > 0) Then
		If (osuma3_frame < (osuma3_aloitus + 2) And MilliSecs() > osuma3_timer + 150) Then
				osuma3_frame = osuma3_frame + 1
				osuma3_timer = MilliSecs()
		Else If (MilliSecs() > osuma3_timer + 2000) Then 
				osuma3 = 0
		Else If ((MilliSecs() < osuma3_timer + 2000) And (MilliSecs() > osuma3_timer + 200)) Then 
				
			If (suunta_c = 1 Or suunnat3 = 0) Then
				DrawImage stars,x3+100,y3+85,stars_frame
			Else
				DrawImage stars,x3+0,y3+85,stars_frame
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
If (isku3 > 1) Then
        If (isku3 = 18 And (MilliSecs() > hyppy_timer_cpu + 90)) Then ;voltti eteen
                If (isku3_frame = 27) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle3 = 0
                        isku3 = 0
                        liike_timer3 = MilliSecs()
                Else
					isku3_frame = isku3_frame + 1
		
					If (suunta_c = 0) Then
						If (x3 < x_reuna_a) Then x3 = x3 - 30				
					Else
						If (x3 > x_reuna_b) Then x3 = x3 + 30
					EndIf
		
					hyppy_timer_cpu = MilliSecs()				
                EndIf
        EndIf

        If (isku3 = 17 And (MilliSecs() > hyppy_timer_cpu + 90)) Then ;voltti taakse
                If (isku3_frame = 22) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle3 = 0
                        isku3 = 0
                        liike_timer3 = MilliSecs()
                Else
					isku3_frame = isku3_frame + 1

					If (suunta_c = 0) Then
						If (x3 < x_reuna_b) Then x3 = x3 + 30			
					Else
						If (x3 > x_reuna_a) Then x3 = x3 - 30
					EndIf
		
					hyppy_timer_cpu = MilliSecs()				
                EndIf
        EndIf

        If (isku3 = 7 And (MilliSecs() > hyppy_timer_cpu + 170)) Then ;kierrepotku
                If (isku3_frame = 15) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
						aani_paalle3 = 0
                        isku3 = 0
                        liike_timer3 = MilliSecs()
						osuu3 = 1
                Else
					isku3_frame = isku3_frame + 1
					
					hyppy_timer_cpu = MilliSecs()				
                EndIf
        EndIf

        If (isku3 = 4 And (MilliSecs() > hyppy_timer_cpu + 100)) Then ;potku ylös
                If (isku3_frame = 9) Then
						aani_paalle3 = 0
                        isku3 = 0
                        liike_timer3 = MilliSecs()
						osuu3 = 1
                Else
                        isku3_frame = 9
                        hyppy_timer_cpu = MilliSecs()
                EndIf
        EndIf

        If ((isku3 = 3) And (MilliSecs() > ukko_timer3 + 80)) Then ;-----------------------<<<<<<<<<< ;hyppypotku
                If (suunta_c = 1) Then
                         If (x3<x_reuna_a) Then;-------------------------------------------------<<<<<<<<<<
                                x3 = x3 + 24
                                ukko_timer3 = MilliSecs()
                        EndIf
                   Else
                         If (x3>x_reuna_b) Then;--------------------------------------------------<<<<<<<<<<<
                                x3 = x3 - 24
                                ukko_timer3 = MilliSecs()
                        EndIf
                EndIf
        EndIf

        If ((isku3 <> 4) And (MilliSecs() > hyppy_timer_cpu+300)) Then
                isku3 = 0
                hyppy_alas_timer3 = MilliSecs()
                liike_timer3 = MilliSecs()
				osuu3 = 1 ; !

        EndIf
Else
;------------------------------------------ - - ------------ --------- ----------- ---------- -  -    ------------------ -- --- - ----
If (MilliSecs() > aloitus_timer + 2000) Then
        If (MilliSecs() > liike_timer3 + 100) Then
                        isku3 = 0
                        If (act3 = (n_control_cpu)) Then                ;napin kanssa liikkeet alkaa...
                                isku3_frame = 3
                                isku3 = 1
                                ei_mitaan_timer3 = MilliSecs()
                        If (act = (n_vala_cpu)) Then
	                           isku3_frame = 4
    	                       isku3 = 1 

								suunta_c = 0
								osuu3 =1
                      	        If (aani_paalle3 <> 4) Then
                                    ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                	aani_paalle3 = 4
 		                        EndIf
                        Else If (act = (n_oala_cpu)) Then ;nilkkapotku
	                            isku3_frame = 4
  	                            isku3 = 1
  								suunta_c = 1
  
								osu_xh3 = 100
								osu_xf3 = 80
								osuu3 = 1
                            	If (aani_paalle3 <> 4) Then
                                    ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                    aani_paalle3 = 4
 		                        EndIf
                        Else If (act = (n_oikea_cpu)) Then
	         	           			If(suunta_c = 0) Then
									    isku3_frame = 6
        	                            isku3 = 1
										osuu3 = 1
										
										liike_timer3 = MilliSecs()
										
										osu_xh3 = 120
										osu_xf3 = 110
        	   	                        If (aani_paalle3 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle3 = 6
                                        EndIf
									Else
										isku3_frame = 13
										isku3 = 7
										hyppy_timer_cpu = MilliSecs()
										ei_mitaan_timer3 = MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle3 = 6
									EndIf
                        Else If (act = (n_ylos_cpu) And (MilliSecs() > hyppy_alas_timer3+200)) Then ;Hyppypotku.
                                isku3_frame = 7
                                isku3 = 3
                                hyppy_timer_cpu = MilliSecs()


								osu_xh3 = 80
								osu_xf3 = 70
			
                                If (aani_paalle3 <> 6) Then
                                      ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                      aani_paalle3 = 6
                                 EndIf

                        Else If (act = (n_vasen_cpu)) Then		;--- kierrepotkua
	         	           			If(suunta_c = 1) Then
									    isku3_frame = 6
        	                            isku3 = 1
										osuu3 = 1
										
										liike_timer3 = MilliSecs()
            	                        If (aani_paalle3 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle3 = 6
                                        EndIf
									Else
										isku3_frame = 13
										isku3 = 7
										osuu3 = 1 ; !
										hyppy_timer_cpu = MilliSecs()
										ei_mitaan_timer3 = MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle3 = 6
									EndIf
                        Else If (act = (n_oyla_cpu) And voltti = 0) Then		;--- voltti taaksepäin
								If (suunta_c = 0) Then
									isku3_frame = 16
									voltti = 1
									isku3 = 18
								Else
									isku3_frame = 22
									voltti = 1
									isku3 = 17
								EndIf

								hyppy_timer_cpu = MilliSecs()
								ei_mitaan_timer3 = MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle3 = 6

                        Else If (act = (n_vyla_cpu) And voltti = 0) Then		;--- voltti eteenpäin
								If (suunta_c = 0) Then
									isku3_frame = 22
									voltti = 1
									isku3 = 17
								Else
									isku3_frame = 16
									voltti = 1
									isku3 = 18
								EndIf
								hyppy_timer_cpu = MilliSecs()
								ei_mitaan_timer3 = MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle3 = 6




                        Else If (act = (n_alas_cpu) And alas_nollaus = 0) Then				;Maha - kääntö
								alas_nollaus = 1
								If (suunta_c = 0) Then
                                isku3_frame = 0
                                isku3 = 1
								osu_xh3 = 110
								osu_xf3 = 100

                                ei_mitaan_timer3 = MilliSecs()
								osuu3 = 1
								If (aani_paalle3 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle3 = 4
                                EndIf

								suunta_c = 1
								Else
                                isku3_frame = 0
                                isku3 = 1
								osu_xh3 = 110
								osu_xf3 = 100

                                ei_mitaan_timer3 = MilliSecs()
								osuu3 = 1
								If (aani_paalle3 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle3 = 4
                                EndIf
								suunta_c = 0
								EndIf
                        
;						Else If Not act = (n_vala_cpu) Then 
;							alas_nollaus = 0
						EndIf

						
						;Ilman controllia tulevat isku3t alkaa tästä.
                        Else If (act = (n_oyla_cpu)) Then	
                                isku3_frame = 5
                                isku3 = 1
								osuu3 = 1 ; !

								osu_xh3 = 60
								osu_xf3 = 70

                                ei_mitaan_timer3 = MilliSecs()

								suunta_c = 0
                                If (aani_paalle3 <> 4) Then
                                		;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku3 -ääni
                                EndIf
                                 aani_paalle3 = 4
                        Else If (act = (n_alas_cpu)) Then
                                isku3_frame = 2
                                isku3 = 1
								osuu3 = 1 ; !
                                ei_mitaan_timer3 = MilliSecs()

                                If (aani_paalle3 <> 88) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku3 -ääni
                                        aani_paalle3 = 88
                                EndIf


                        Else If (act = (n_ylos_cpu) And (MilliSecs() > hyppy_alas_timer3+200)) Then
                                isku3_frame = 1
                                isku3 = 2
                                hyppy_timer_cpu = MilliSecs()
                                ei_mitaan_timer3 = MilliSecs()

                        Else If (act = (n_vala_cpu)) Then				;Mahaisku3.
								If (suunta_c = 0) Then

                                isku3_frame = 8
                                isku3 = 4
                                hyppy_timer_cpu = MilliSecs()
                                ei_mitaan_timer3 = MilliSecs()
                                If (aani_paalle3 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle3 = 6
                                EndIf
								Else
                                isku3_frame = 0
                                isku3 = 1
								osu_xh3 = 110
								osu_xf3 = 100

                                ei_mitaan_timer3 = MilliSecs()
								osuu3 = 1
								If (aani_paalle3 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku3 -ääni
                                        aani_paalle3 = 4
                                EndIf
								EndIf
                       Else If (act = (n_vyla_cpu)) Then				;isku3 ylös.
                                isku3_frame = 5
                                isku3 = 1
								osuu3 = 1
								suunta_c = 1

								osu_xhs3 = 60
								osu_xfs3 = 40
								
                                ei_mitaan_timer3 = MilliSecs()
                                If (aani_paalle3 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku3 -ääni
                                EndIf
                                aani_paalle3 = 4
                        Else If (act = (n_oala_cpu)) Then				;Potku ylös.
								If (suunta_c = 1) Then

                                isku3_frame = 8
                                isku3 = 4
                                hyppy_timer_cpu = MilliSecs()
                                ei_mitaan_timer3 = MilliSecs()
                                If (aani_paalle3 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle3 = 6
                                EndIf
									Else
                                isku3_frame = 0
                                isku3 = 1
								osu_xh3 = 110
								osu_xf3 = 100

                                ei_mitaan_timer3 = MilliSecs()
								osuu3 = 1
								If (aani_paalle3 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku3 -ääni
                                        aani_paalle3 = 4
                                EndIf

								EndIf
                        EndIf                                                ;...tähän

liike_timer3 = MilliSecs()
EndIf
EndIf ;liikkeiden loppu...
If (MilliSecs() > nulltimer + 500) Then
	isku3 = 0
	nulltimer = MilliSecs()
EndIf
;Kävely alkaa
                        If (act = (kavely_oikea_cpu) And x3<x_reuna_a) Then
;oikealle
								isku3 = 0
                                aani_paalle3 = 0
                                If (MilliSecs() > ukko_timer33+100) Then
                                        ukko_timer33 = MilliSecs()
                                        ukko3_frame = ukko3_frame + 1
                                        If (ukko3_frame = 4) Then ukko3_frame = 0
                                        x3 = x3 + 10
	                                ei_mitaan_timer3 = MilliSecs()
                                EndIf
                        EndIf

                        If (act = (kavely_vasen_cpu) And x3>x_reuna_b) Then  
;vasemmalle
								isku3 = 0
                                aani_paalle3 = 0
                                If (MilliSecs() > ukko_timer33+100) Then
                                        ukko_timer33 = MilliSecs()
                                        ukko3_frame = ukko3_frame - 1
                                        If (ukko3_frame = -1) Then ukko3_frame = 3
                                        x3 = x3 - 10
	                                ei_mitaan_timer3 = MilliSecs()
                                EndIf
                        EndIf
                        ;Kävely loppuu

            ;Kävely loppuu
EndIf

;Color 255,100,200
;Text 100,100,isku3_frame
;höpötys ------------------
If ((MilliSecs() > ei_mitaan_timer3 + 8000) And (MilliSecs() < ei_mitaan_timer3 + 10000)) Then
                If (MilliSecs() > hyppy_timer_cpu + 200) Then
                        If (isku3_frame <> 11) Then
                                isku3_frame = 11
                        Else
                                isku3_frame = 10
                        EndIf
                        hyppy_timer_cpu = MilliSecs()
                EndIf
;pöpötys päättyy ----------
               If (suunta_c = 0) Then                                        ;
                        DrawImage iskuja3,x3,y3,isku3_frame                ;
                Else                                                                        ;
                        DrawImage iskuja_ts3,x3,y3,isku3_frame        ;
                EndIf                                                                        ;
Else
               If (isku3 = 0) Then
                        If (suunta_c= 0) Then                                        ;
                                DrawImage ukko3,x3,y3,ukko3_frame
                        Else
                                DrawImage ukko_ts3,x3,y3,ukko3_frame
                        EndIf
                Else
                        If (suunta_c= 0) Then                                        ;
                                DrawImage iskuja3,x3,y3,isku3_frame                ;
                        Else                                                                        ;
                                DrawImage iskuja_ts3,x3,y3,isku3_frame        ;
                        EndIf                                                                        ;
                EndIf

EndIf

EndIf
EndIf
End Function