

;-----------------------------
;19.2.08 Kakkos-cpu
;-----------------------------





Function move_cpu2()
osuu4 = 0 		;Nollataan osumat.
osu_xf4 = 50	;Osumaetäisyyksien
osu_xh4 = 90	;perus-
osu_xfs4 = 30	;asetuk-
osu_xhs4 = 60	;set.


If (MilliSecs() > aloitus_timer + 2000) Then

;kuka kohteeksi? --------->
If (MilliSecs() > pick2+ 10000) Then
	pick_the_man2 = Rnd(4)
	pick2= MilliSecs()
EndIf
If (pause = 0) Then
	If (pick_the_man2 < 2) Then 
		If (x4 => (x + 100)) Then
			act2 = 3
			suunta_c2= 0
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf	
		If (x => (x4 + 100)) Then
			act2 = 2
			suunta_c2= 1
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf
	Else
			If (x4 => (x2 + 100)) Then
			act2 = 3
			suunta_c2= 0
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf	
		If (x2 => (x4 + 100)) Then
			act2 = 2
			suunta_c2= 1
		Else
			pause = 1
			pausetus = MilliSecs()
		EndIf
	EndIf
EndIf

If (MilliSecs() > pausetus + 3000) Then pause = 0

;------------------<
If (isku4= 0) Then
If (actor2= 0) Then
	If (act2 = 12) Then actor2= 1;aloittaa liikesarjan
	If (act2 = 13) Then actor2= 6;-""-

	;rajat
	If (x4 < 100) Then 
		act2 = 2
		pause = 1
		suunta_c2= 1
		cpu_timer2= MilliSecs()
	EndIf
	If (x4 > 700) Then 
		act2 = 3
		pause = 1
		suunta_c2= 0
		cpu_timer2= MilliSecs()
	EndIf

	;jos kävellään, niin pidennetään sitä
	If ((act2 = 2 Or act2 = 3) And actwalk2 = 0) Then
		abcde2= abcde2+ 500
		actwalk2 = 1
	EndIf

	;liikkeiden arvonta									 ---------------- KYKYJEN SÄÄTÖ
	If (MilliSecs() > cpu_timer2+ abcde2) Then ;500+abcde2on alkup.
		actwalk2 = 0
		act2 = Rnd(15)
		act4 = 20
		cpu_timer2= MilliSecs()
		abcde2= Rnd(100,500)
;		abcde2= Rnd(200,1000)
	EndIf

	If (MilliSecs() > cpu_timer2+ 4000) Then 
		act2 = 0
	EndIf

	If (act2 = 5) Then 
		If (aaaa = Rnd(2)) <2 Then 
			act4 = 20
			If (actwalk2 = 0) Then
				abcde2= abcde2+ 3500
				actwalk2 = 1
			EndIf
		Else
			act4 = 0
		EndIf
	EndIf
	
Else	;liikesarjojen  teko
	If ((actor2> 0 And actor2< 6)) Then
		If (MilliSecs() > cpu_timer2+ 500) Then 
			actor2= actor2+ 1
			cpu_timer2= MilliSecs()
			PlaySound mahapotku_aani
	
			If (actor2= 2) Then act2 = 9:act4 = 20
			If (actor2= 3) Then act2 = 8:act4 = 0
			If (actor2= 4) Then act2 = 10:act4 = 0
			If (actor2= 5) Then act2 = 0:actor2= 0
		EndIf
	EndIf
	If ((actor2> 5 And actor2< 11)) Then
			If (MilliSecs() > cpu_timer2+ 500) Then 
			actor2= actor2+ 1
			cpu_timer2= MilliSecs()
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
If (osuma4 <> 0) Then	;jos on saanut osuman niin kaatuu
    If (suunta_c2= 0 And suunnat4 = 0) Then
        DrawImage osumat3,x4,y3+30,osuma3_frame+9        ;		
    Else                                                ;
        DrawImage osumat3,x4,y3+30,osuma4_frame      ;
    EndIf

	If (osuma4 > 0) Then
		If (osuma4_frame< (osuma4_aloitus+ 2) And MilliSecs() > osuma4_timer + 150) Then
				osuma4_frame= osuma4_frame+ 1
				osuma4_timer = MilliSecs()
		Else If (MilliSecs() > osuma4_timer + 2000) Then 
				osuma4 = 0
		Else If ((MilliSecs() < osuma4_timer + 2000) And (MilliSecs() > osuma4_timer + 200)) Then 
				
			If (suunta_c2= 1 Or suunnat4 = 0) Then
				DrawImage stars,x4+100,y3+85,stars_frame
			Else
				DrawImage stars,x4+0,y3+85,stars_frame
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
If (isku4> 1) Then
        If (isku4= 18 And (MilliSecs() > hyppy_timer_cpu2 + 90)) Then ;voltti eteen
                If (isku4_frame = 27) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle4 = 0
                        isku4= 0
                        liike_timer4 = MilliSecs()
                Else
					isku4_frame = isku4_frame + 1
		
					If (suunta_c2= 0) Then
						If (x4 < 680) Then x4 = x4 + 30				
					Else
						If (x4 > 10) Then x4 = x4 - 30
					EndIf
		
					hyppy_timer_cpu2 = MilliSecs()				
                EndIf
        EndIf

        If (isku4= 17 And (MilliSecs() > hyppy_timer_cpu2 + 90)) Then ;voltti taakse
                If (isku4_frame = 22) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
						aani_paalle4 = 0
                        isku4= 0
                        liike_timer4 = MilliSecs()
                Else
					isku4_frame = isku4_frame + 1

					If (suunta_c2= 0) Then
						If (x4 > 10) Then x4 = x4 - 30			
					Else
						If (x4 < 680) Then x4 = x4 + 30
					EndIf
		
					hyppy_timer_cpu2 = MilliSecs()				
                EndIf
        EndIf

        If (isku4= 7 And (MilliSecs() > hyppy_timer_cpu2 + 170)) Then ;kierrepotku
                If (isku4_frame = 15) Then
                        ;;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
						aani_paalle4 = 0
                        isku4= 0
                        liike_timer4 = MilliSecs()
						osuu4 = 1
                Else
					isku4_frame = isku4_frame + 1
					
					hyppy_timer_cpu2 = MilliSecs()				
                EndIf
        EndIf

        If (isku4= 4 And (MilliSecs() > hyppy_timer_cpu2 + 100)) Then ;potku ylös
                If (isku4_frame = 9) Then
						aani_paalle4 = 0
                        isku4= 0
                        liike_timer4 = MilliSecs()
						osuu4 = 1
                Else
                        isku4_frame = 9
                        hyppy_timer_cpu2 = MilliSecs()
                EndIf
        EndIf

        If ((isku4= 3) And (MilliSecs() > ukko_timer3 + 40)) Then
                If (suunta_c2= 1) Then
                         If (x4<500) Then
                                x4 = x4 + 24
                                ukko_timer3 = MilliSecs()
                        EndIf
                   Else
                         If (x4>150) Then
                                x4 = x4 - 24
                                ukko_timer3 = MilliSecs()
                        EndIf
                EndIf
        EndIf

        If ((isku4<> 4) And (MilliSecs() > hyppy_timer_cpu+300)) Then
                isku4= 0
                hyppy_alas_timer4 = MilliSecs()
                liike_timer4 = MilliSecs()
				osuu4 = 1 ; !

        EndIf
Else
;------------------------------------------ - - ------------ --------- ----------- ---------- -  -    ------------------ -- --- - ----
If (MilliSecs() > aloitus_timer + 2000) Then
        If (MilliSecs() > liike_timer4 + 100) Then
                        isku4= 0
                        If (act4 = (n_control_cpu2)) Then                ;napin kanssa liikkeet alkaa...
                                isku4_frame = 3
                                isku4= 1
                                ei_mitaan_timer4= MilliSecs()
                        If (act2 = (n_vala_cpu2)) Then
	                           isku4_frame = 4
    	                       isku4= 1 

								suunta_c2= 0
								osuu4 =1
                      	        	If (aani_paalle4 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                        aani_paalle4 = 4
 		                        EndIf
                        Else If (act2 = (n_oala_cpu2)) Then ;nilkkapotku
	                            isku4_frame = 4
  	                            isku4= 1
  								suunta_c2= 1
  
								osu_xh4 = 100
								osu_xf4 = 80
								osuu4 = 1
                            	If (aani_paalle4 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)        ;nilkkapotku -ääni
                                        aani_paalle4 = 4
 		                        EndIf
                        Else If (act2 = (n_oikea_cpu2)) Then
	         	           			If(suunta_c2= 0) Then
									    isku4_frame = 6
        	                            isku4= 1
										osuu4 = 1
										
										osu_xh4 = 120
										osu_xf4 = 90
        
	   	                        If (aani_paalle4 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle4 = 6
                                        EndIf
									Else
										isku4_frame = 13
										isku4= 7
										hyppy_timer_cpu2 = MilliSecs()
										ei_mitaan_timer4= MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle4 = 6
									EndIf
                        Else If (act2 = (n_ylos_cpu2) And (MilliSecs() > hyppy_alas_timer4+200)) Then ;Hyppypotku.
                                isku4_frame = 7
                                isku4= 3
                                hyppy_timer_cpu2 = MilliSecs()


								osu_xh4 = 80
								osu_xf4 = 70
			
                                If (aani_paalle4 <> 6) Then
                                      ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                      aani_paalle4 = 6
                                 EndIf

                        Else If (act2 = (n_vasen_cpu2)) Then		;--- kierrepotkua
	         	           			If(suunta_c2= 1) Then
									    isku4_frame = 6
        	                            isku4= 1
										osuu4 = 1
            	                        If (aani_paalle4 <> 6) Then
                	                           ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                                               aani_paalle4 = 6
                                        EndIf
									Else
										isku4_frame = 13
										isku4= 7
										osuu4 = 1 ; !
										hyppy_timer_cpu2 = MilliSecs()
										ei_mitaan_timer4= MilliSecs()
										;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)        ;mahapotku -ääni
                    	                aani_paalle4 = 6
									EndIf
                        Else If (act2 = (n_oyla_cpu2) And voltti = 0) Then		;--- voltti taaksepäin
								If (suunta_c2= 0) Then
									isku4_frame = 22
									voltti = 1
									isku4= 18
								Else
									isku4_frame = 16
									voltti = 1
									isku4= 17
								EndIf

								hyppy_timer_cpu2 = MilliSecs()
								ei_mitaan_timer4= MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle4 = 6

                        Else If (act2 = (n_vyla_cpu2) And voltti = 0) Then		;--- voltti eteenpäin
								If (suunta_c2= 0) Then
									isku4_frame = 16
									voltti = 1
									isku4= 17
								Else
									isku4_frame = 22
									voltti = 1
									isku4= 18
								EndIf
								hyppy_timer_cpu2 = MilliSecs()
								ei_mitaan_timer4= MilliSecs()
								;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                aani_paalle4 = 6




                        Else If (act2 = (n_alas_cpu2) And alas_nollaus = 0) Then				;Maha - kääntö
								alas_nollaus = 1
								If (suunta_c2= 0) Then
                                isku4_frame = 0
                                isku4= 1
								osu_xh4 = 110
								osu_xf4 = 100

                                ei_mitaan_timer4= MilliSecs()
								osuu4 = 1
								If (aani_paalle4 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle4 = 4
                                EndIf

								suunta_c2= 1
								Else
                                isku4_frame = 0
                                isku4= 1
								osu_xh4 = 110
								osu_xf4 = 100

                                ei_mitaan_timer4= MilliSecs()
								osuu4 = 1
								If (aani_paalle4 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)
                                        aani_paalle4 = 4
                                EndIf
								suunta_c2= 0
								EndIf
                        
;						Else If Not act2 = (n_vala_cpu2) Then 
;							alas_nollaus = 0
						EndIf

						
						;Ilman controllia tulevat isku3t alkaa tästä.
                        Else If (act2 = (n_oyla_cpu2)) Then	
                                isku4_frame = 5
                                isku4= 1
								osuu4 = 1 ; !

								osu_xh4 = 60
								osu_xf4 = 70

                                ei_mitaan_timer4= MilliSecs()

								suunta_c2= 0
                                If (aani_paalle4 <> 4) Then
                                		;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku4-ääni
                                EndIf
                                 aani_paalle4 = 4
                        Else If (act2 = (n_alas_cpu2)) Then
                                isku4_frame = 2
                                isku4= 1
								osuu4 = 1 ; !
                                ei_mitaan_timer4= MilliSecs()

                                If (aani_paalle4 <> 88) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku4-ääni
                                        aani_paalle4 = 88
                                EndIf


                        Else If (act2 = (n_ylos_cpu2) And (MilliSecs() > hyppy_alas_timer4+200)) Then
                                isku4_frame = 1
                                isku4= 2
                                hyppy_timer_cpu2 = MilliSecs()
                                ei_mitaan_timer4= MilliSecs()

                        Else If (act2 = (n_vala_cpu2)) Then				;Mahaisku3.
								If (suunta_c2= 0) Then

                                isku4_frame = 8
                                isku4= 4
                                hyppy_timer_cpu2 = MilliSecs()
                                ei_mitaan_timer4= MilliSecs()
                                If (aani_paalle4 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle4 = 6
                                EndIf
								Else
                                isku4_frame = 0
                                isku4= 1
								osu_xh4 = 110
								osu_xf4 = 100

                                ei_mitaan_timer4= MilliSecs()
								osuu4 = 1
								If (aani_paalle4 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku4-ääni
                                        aani_paalle4 = 4
                                EndIf
								EndIf
                       Else If (act2 = (n_vyla_cpu2)) Then				;isku4ylös.
                                isku4_frame = 5
                                isku4= 1
								osuu4 = 1
								suunta_c2= 1

								osu_xhs4 = 60
								osu_xfs4 = 40
								
                                ei_mitaan_timer4= MilliSecs()
                                If (aani_paalle4 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku4-ääni
                                EndIf
                                aani_paalle4 = 4
                        Else If (act2 = (n_oala_cpu2)) Then				;Potku ylös.
								If (suunta_c2= 1) Then

                                isku4_frame = 8
                                isku4= 4
                                hyppy_timer_cpu2 = MilliSecs()
                                ei_mitaan_timer4= MilliSecs()
                                If (aani_paalle4 <> 6) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(mahapotku_aani)
                                        aani_paalle4 = 6
                                EndIf
									Else
                                isku4_frame = 0
                                isku4= 1
								osu_xh4 = 110
								osu_xf4 = 100

                                ei_mitaan_timer4= MilliSecs()
								osuu4 = 1
								If (aani_paalle4 <> 4) Then
                                        ;If Not ChannelPlaying(chncpu) Then chncpu=PlaySound(nilkka_aani)                 ;kasvoisku4-ääni
                                        aani_paalle4 = 4
                                EndIf

								EndIf
                        EndIf                                                ;...tähän

liike_timer4 = MilliSecs()
EndIf
EndIf ;liikkeiden loppu...
If (MilliSecs() > nulltimer2 + 500) Then
	isku4= 0
	nulltimer2 = MilliSecs()
EndIf
;Kävely alkaa
                        If (act2 = (kavely_oikea_cpu) And x4<680) Then
;oikealle
								isku4= 0
                                aani_paalle4 = 0
                                If (MilliSecs() > ukko_timer44+100) Then
                                        ukko_timer44 = MilliSecs()
                                        ukko4_frame = ukko4_frame + 1
                                        If (ukko4_frame = 4) Then ukko4_frame = 0
                                        x4 = x4 + 10
	                                ei_mitaan_timer4= MilliSecs()
                                EndIf
                        EndIf

                        If (act2 = (kavely_vasen_cpu) And x4>10) Then  
;vasemmalle
								isku4= 0
                                aani_paalle4 = 0
                                If (MilliSecs() > ukko_timer44+100) Then
                                        ukko_timer44 = MilliSecs()
                                        ukko4_frame = ukko4_frame - 1
                                        If (ukko4_frame = -1) Then ukko4_frame = 3
                                        x4 = x4 - 10
	                                ei_mitaan_timer4= MilliSecs()
                                EndIf
                        EndIf
                        ;Kävely loppuu

            ;Kävely loppuu
EndIf

;Color 255,100,200
;Text 100,100,isku3_frame
;höpötys ------------------
If ((MilliSecs() > ei_mitaan_timer4+ 8000) And (MilliSecs() < ei_mitaan_timer4+ 10000)) Then
                If (MilliSecs() > hyppy_timer_cpu2 + 200) Then
                        If (isku4_frame <> 11) Then
                                isku4_frame = 11
                        Else
                                isku4_frame = 10
                        EndIf
                        hyppy_timer_cpu2 = MilliSecs()
                EndIf
;pöpötys päättyy ----------
               If (suunta_c2= 0) Then                                        ;
                        DrawImage iskuja3,x4,y3,isku4_frame                ;
                Else                                                                        ;
                        DrawImage iskuja_ts3,x4,y3,isku4_frame        ;
                EndIf                                                                        ;
Else
               If (isku4= 0) Then
                        If (suunta_c= 0) Then                                        ;
                                DrawImage ukko3,x4,y3,ukko3_frame
                        Else
                                DrawImage ukko_ts3,x4,y3,ukko3_frame
                        EndIf
                Else
                        If (suunta_c= 0) Then                                        ;
                                DrawImage iskuja3,x4,y3,isku4_frame                ;
                        Else                                                                        ;
                                DrawImage iskuja_ts3,x4,y3,isku4_frame        ;
                        EndIf                                                                        ;
                EndIf

EndIf

EndIf
EndIf
End Function