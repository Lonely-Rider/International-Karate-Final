;Last update
;19.2.08

Function move_keyb()
osuu = 0 		;Nollataan osumat.
osu_xf = 50		;Osumaet�isyyksien
osu_xh = 90		;perus-
osu_xfs = 30	;asetuk-
osu_xhs = 60	;set.


;alun kumarrus
If (MilliSecs() < aloitus_timer + 2000) Then
Else
;-------------------------------------------------------------------t�st� muutettava alasp�in
If (osuma <> 0) Then	;jos valkoinen on osunut punaiseen niin kaatuminen
    If (suunta = 0 And suunnat = 0) Then
        DrawImage osumat,x,y+30,osuma_frame+9
    Else                                             
        DrawImage osumat,x,y+30,osuma_frame
    EndIf

	If (osuma > 0) Then
		If (osuma_frame < (osuma_aloitus + 2) And MilliSecs() > osuma_timer + 150) Then
				osuma_frame = osuma_frame + 1
				osuma_timer = MilliSecs()
		Else If (MilliSecs() > osuma_timer + 2000) Then 
				osuma = 0
		Else If ((MilliSecs() < osuma_timer + 2000) And (MilliSecs() > osuma_timer + 200)) Then 
				
			If (suunta = 1) Then ; Or suunnat = 0) Then
				DrawImage stars,x+100,y+85,stars_frame;85
			Else
				DrawImage stars,x+0,y+85,stars_frame;85
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
;-------------------------------------------------------------------t�h�n asti
If (isku > 1) Then
        If (isku = 18 And (MilliSecs() > hyppy_timer + 90)) Then ;voltti eteen
                If (isku_frame = 27) Then
                        ;PlaySound nilkka_aani
						aani_paalle = 0
                        isku = 0
                        liike_timer = MilliSecs()
                Else
					isku_frame = isku_frame + 1
		
					If (suunta = 0) Then
						If (x < x_reuna_a) Then x = x + 30				
					Else
						If (x > x_reuna_b) Then x = x - 30
					EndIf
		
					hyppy_timer = MilliSecs()				
                EndIf
        EndIf

        If (isku = 17 And (MilliSecs() > hyppy_timer + 90)) Then ;voltti taakse
                If (isku_frame = 22) Then
                        ;PlaySound nilkka_aani
						aani_paalle = 0
                        isku = 0
                        liike_timer = MilliSecs()
                Else
					isku_frame = isku_frame + 1

					If (suunta = 0) Then
						If (x > x_reuna_b) Then x = x - 30			
					Else
						If (x < x_reuna_a) Then x = x + 30
					EndIf
		
					hyppy_timer = MilliSecs()				
                EndIf
        EndIf

        If (isku = 7 And (MilliSecs() > hyppy_timer + 170)) Then ;kierrepotku
                If (isku_frame = 15) Then
                        ;PlaySound nilkka_aani        ;nilkkapotku -��ni
						aani_paalle = 0
                        isku = 0
                        liike_timer = MilliSecs()
						osuu = 1
                Else
					isku_frame = isku_frame + 1
					
					hyppy_timer = MilliSecs()				
                EndIf
        EndIf

        If (isku = 4 And (MilliSecs() > hyppy_timer + 100)) Then ;potku yl�s
                If (isku_frame = 9) Then
						aani_paalle = 0
                        isku = 0
                        liike_timer = MilliSecs()
						osuu = 1
                Else
                        isku_frame = 9
                        hyppy_timer = MilliSecs()
                EndIf
        EndIf

        If ((isku = 3) And (MilliSecs() > ukko_timer + 40)) Then
                If (suunta = 0) Then
                         If (x<500) Then
                                x = x + 12
                                ukko_timer = MilliSecs()
                        EndIf
                   Else
                         If (x>150) Then
                                x = x - 12
                                ukko_timer = MilliSecs()
                        EndIf
                EndIf
        EndIf

        If ((isku <> 4) And (MilliSecs() > hyppy_timer+300)) Then
                isku = 0
                hyppy_alas_timer = MilliSecs()
                liike_timer = MilliSecs()
				osuu = 1 ; !

        EndIf
Else

If (KeyDown(n_control) And (Not KeyDown(n_oala)) And (Not KeyDown(n_vala))And (Not KeyDown(n_oyla)) And (Not KeyDown(n_vyla)) And (Not KeyDown(n_oikea)) And (Not KeyDown(n_vasen))) Then aani_paalle = 0:valo_paalle = 0
If ((Not KeyDown(n_control)) And (Not KeyDown(n_oala)) And (Not KeyDown(n_alas)) And (Not KeyDown(n_vala)) And (Not KeyDown(n_oyla)) And (Not KeyDown(n_vyla)) And (Not KeyDown(n_oikea)) And (Not KeyDown(n_vasen))) Then aani_paalle = 0:valo_paalle = 0

If ((Not KeyDown(kavely_oikea)) And (Not KeyDown(kavely_vasen)) Or (KeyDown(n_control))) Then	;t�st� alkaa iskut ja potkut
        If (MilliSecs() > liike_timer + 100) Then
                        isku = 0
                        If (KeyDown(n_control)) Then                ;napin kanssa liikkeet alkaa...
                                isku_frame = 3
                                isku = 1
                                ei_mitaan_timer = MilliSecs()
                        If (KeyDown(n_vala)) Then
	                           isku_frame = 4
    	                       isku = 1 

								suunta = 0
								osuu =1
                              	If (aani_paalle <> 4) Then
                                        PlaySound nilkka_aani        ;nilkkapotku -��ni
                                        aani_paalle = 4
 		                        EndIf
                        Else If (KeyDown(n_oala)) Then ;nilkkapotku
	                            isku_frame = 4
  	                            isku = 1
  								suunta = 1
  
								osu_xh = 100
								osu_xf = 80
								osuu = 1
                            	If (aani_paalle <> 4) Then
                                        PlaySound nilkka_aani        ;nilkkapotku -��ni
                                        aani_paalle = 4
 		                        EndIf
                        Else If (KeyDown(n_oikea)) Then
	         	           			If(suunta = 0) Then
									    isku_frame = 6									;SIVULLE POTKU  isku = 6
        	                            isku = 1
										osuu = 1

										osu_xh = 120
										osu_xf = 110
										liike_timer = MilliSecs()
										ei_mitaan_timer = MilliSecs()
										
	   	                       			If (aani_paalle <> 6) Then
                	                		PlaySound mahapotku_aani        ;mahapotku -��ni
                                     	    aani_paalle = 6
                                        EndIf
									Else
										isku_frame = 13
										isku = 7
										hyppy_timer = MilliSecs()
										ei_mitaan_timer = MilliSecs()
										PlaySound mahapotku_aani        ;mahapotku -��ni
                    	                aani_paalle = 6
									EndIf
                        Else If (KeyDown(n_ylos) And (MilliSecs() > hyppy_alas_timer+200)) Then ;Hyppypotku.
                                isku_frame = 7
                                isku = 3
                                hyppy_timer = MilliSecs()

								osu_xh = 80
								osu_xf = 70
			
                                If (aani_paalle <> 6) Then
                                      PlaySound mahapotku_aani        ;mahapotku -��ni
                                      aani_paalle = 6
                                EndIf
                        Else If (KeyDown(n_vasen)) Then		;--- kierrepotkua
	         	           			If(suunta = 1) Then
									    isku_frame = 6
        	                            isku = 1
										osuu = 1
										liike_timer = MilliSecs()
										ei_mitaan_timer = MilliSecs()

            	                        If (aani_paalle <> 6) Then
                	                    	PlaySound mahapotku_aani        ;mahapotku -��ni
                                            aani_paalle = 6
                                        EndIf
									Else
										isku_frame = 13
										isku = 7
										osuu = 1 ; !
										hyppy_timer = MilliSecs()
										ei_mitaan_timer = MilliSecs()
										PlaySound mahapotku_aani        ;mahapotku -��ni
                    	                aani_paalle = 6
									EndIf
                        Else If (KeyDown(n_oyla) And voltti = 0) Then		;--- voltti taaksep�in
								If (suunta = 0) Then
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
								PlaySound mahapotku_aani
                                aani_paalle = 6

                        Else If (KeyDown(n_vyla) And voltti = 0) Then		;--- voltti eteenp�in
								If (suunta = 0) Then
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
								PlaySound mahapotku_aani
                                aani_paalle = 6




                        Else If (KeyDown(n_alas) And alas_nollaus = 0) Then				;Maha - k��nt�
								alas_nollaus = 1
								If (suunta = 0) Then									;muutettu
	                                isku_frame = 0
									osuu = 1
	                                isku = 1
									osu_xh = 110
									osu_xf = 90
	
	                                ei_mitaan_timer = MilliSecs()
									If (aani_paalle <> 4) Then
                                        PlaySound nilkka_aani
                                        aani_paalle = 4
	                                EndIf
									suunta = 1
								Else
	                                isku_frame = 0
	                                isku = 1
									osuu = 1
									osu_xh = 110
									osu_xf = 90										;muutettu.
	
	                                ei_mitaan_timer = MilliSecs()
									If (aani_paalle <> 4) Then
                                        PlaySound nilkka_aani
                                        aani_paalle = 4
	                                EndIf
									suunta = 0
								EndIf
                        
						Else If Not KeyDown(n_alas) Then 
							alas_nollaus = 0
						EndIf

						
						;Ilman controllia tulevat iskut alkaa t�st�.
                        Else If (KeyDown(n_oyla)) Then	
                                isku_frame = 5
                                isku = 1
								osuu = 1 ; !

								osu_xh = 60
								osu_xf = 70

                                ei_mitaan_timer = MilliSecs()

								suunta = 0
                                If (aani_paalle <> 4) Then
                                		PlaySound nilkka_aani                 ;kasvoisku -��ni
                                EndIf
                                 aani_paalle = 4
                        Else If (KeyDown(n_alas)) Then
                                isku_frame = 2
                                isku = 1
								osuu = 1 ; !
                                ei_mitaan_timer = MilliSecs()

                                If (aani_paalle <> 88) Then
                                        PlaySound nilkka_aani                 ;kasvoisku -��ni
                                        aani_paalle = 88
                                EndIf


                        Else If (KeyDown(n_ylos) And (MilliSecs() > hyppy_alas_timer+200)) Then
                                isku_frame = 1
                                isku = 2
                                hyppy_timer = MilliSecs()
                                ei_mitaan_timer = MilliSecs()

                        Else If (KeyDown(n_vala)) Then				;Mahaisku.
								If (suunta = 0) Then

                                isku_frame = 8
                                isku = 4
                                hyppy_timer = MilliSecs()
                                ei_mitaan_timer = MilliSecs()
                                If (aani_paalle <> 6) Then
                                        PlaySound mahapotku_aani
                                        aani_paalle = 6
                                EndIf
								Else
                                isku_frame = 0
                                isku = 1
								osu_xh = 110
								osu_xf = 100

                                ei_mitaan_timer = MilliSecs()
								osuu = 1
								If (aani_paalle <> 4) Then
                                        PlaySound nilkka_aani                 ;kasvoisku -��ni
                                        aani_paalle = 4
                                EndIf
								EndIf
                       Else If (KeyDown(n_vyla)) Then				;Isku yl�s.
                                isku_frame = 5
                                isku = 1
								osuu = 1
								suunta = 1

								osu_xhs = 60
								osu_xfs = 40
								
                                ei_mitaan_timer = MilliSecs()
                                If (aani_paalle <> 4) Then
                                        PlaySound nilkka_aani                 ;kasvoisku -��ni
                                EndIf
                                aani_paalle = 4
                        Else If (KeyDown(n_oala)) Then				;Potku yl�s.
								If (suunta = 1) Then

                                isku_frame = 8
                                isku = 4
                                hyppy_timer = MilliSecs()
                                ei_mitaan_timer = MilliSecs()
                                If (aani_paalle <> 6) Then
                                        PlaySound mahapotku_aani
                                        aani_paalle = 6
                                EndIf
									Else
                                isku_frame = 0
                                isku = 1
								osu_xh = 110
								osu_xf = 100

                                ei_mitaan_timer = MilliSecs()
								osuu = 1
								If (aani_paalle <> 4) Then
                                        PlaySound nilkka_aani                 ;kasvoisku -��ni
                                        aani_paalle = 4
                                EndIf

								EndIf
                        EndIf                                                ;...t�h�n

liike_timer = MilliSecs()
EndIf
EndIf ;liikkeiden loppu...

;K�vely alkaa
                        If ((Not KeyDown(n_control)) And (JoyDown(2) = 0) And (KeyDown(kavely_oikea) Or (JoyXDir()=1)) And x<x_reuna_a) Then
;oikealle
								isku = 0
                                aani_paalle = 0
                                If (MilliSecs() > ukko_timer+100) Then
                                        ukko_timer = MilliSecs()
                                        ukko_frame = ukko_frame + 1
                                        If (ukko_frame = 4) Then ukko_frame = 0
                                        x = x + 10
                                        ei_mitaan_timer = MilliSecs()
                                EndIf
                        EndIf

                        If ((Not KeyDown(n_control)) And (JoyDown(2) = 0) And (KeyDown(kavely_vasen) Or (JoyXDir()=-1)) And x>x_reuna_b) Then  
;vasemmalle
								isku = 0
                                aani_paalle = 0
                                If (MilliSecs() > ukko_timer+100) Then
                                        ukko_timer = MilliSecs()
                                        ukko_frame = ukko_frame - 1
                                        If (ukko_frame = -1) Then ukko_frame = 3
                                        x = x - 10
                                        ei_mitaan_timer = MilliSecs()
                                EndIf
                        EndIf
                        ;K�vely loppuu
EndIf

;Color 255,100,200
;Text 100,100,isku_frame

If ((MilliSecs() > ei_mitaan_timer + 8000) And (MilliSecs() < ei_mitaan_timer + 10000)) Then
                If (MilliSecs() > hyppy_timer + 200) Then
                        If (isku_frame <> 11) Then
                                isku_frame = 11
                        Else
                                isku_frame = 10
                        EndIf
                        hyppy_timer = MilliSecs()
                EndIf
               If (suunta = 0) Then                                        ;
                        DrawImage iskuja,x,y,isku_frame                ;
                Else                                                                        ;
                        DrawImage iskuja_ts,x,y,isku_frame        ;
                EndIf                                                                        ;
Else
                If (isku = 0) Then
                        If (suunta = 0) Then                                        ;
                                DrawImage ukko,x,y,ukko_frame
                        Else
                                DrawImage ukko_ts,x,y,ukko_frame
                        EndIf
                Else
                        If (suunta = 0) Then                                        ;
                                DrawImage iskuja,x,y,isku_frame                ;
                        Else                                                                        ;
                                DrawImage iskuja_ts,x,y,isku_frame        ;
                        EndIf                                                                        ;
                EndIf
EndIf

EndIf
If (MilliSecs() > ei_mitaan_timer + 10000) Then ei_mitaan_timer = MilliSecs()
EndIf
End Function