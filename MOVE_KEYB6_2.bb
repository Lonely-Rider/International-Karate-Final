;PUNAINEN
;21.2.08 poistettu level-teksti ja siirretty Hits:iin.



Function move_keyb2()
osuu2 = 0 		;Nollataan osumat.
osu_xf2 = 50	;Osumaet‰isyyksien
osu_xh2 = 90	;perus-
osu_xfs2 = 30	;asetuk-  ;20
osu_xhs2 = 60	;set.

If (osuma2 <> 0) Then	;jos valkoinen on osunut punaiseen niin kaatuminen
    If (suunta2 = 0 And suunnat2 = 0) Then
        DrawImage osumat2,x2,y2+30,osuma2_frame         ;
    Else                                                ;
        DrawImage osumat2,x2,y2+30,osuma2_frame+9       ;
    EndIf

	If (osuma2 > 0) Then
		If (osuma2_frame < (osuma2_aloitus + 2) And MilliSecs() > osuma2_timer + 150) Then
				osuma2_frame = osuma2_frame + 1
				osuma2_timer = MilliSecs()
		Else If (MilliSecs() > osuma2_timer + 2000) Then 
				osuma2 = 0
		Else If ((MilliSecs() < osuma2_timer + 2000) And (MilliSecs() > osuma2_timer + 200)) Then 
				
			If (suunta2 = 1 Or suunnat2 = 0) Then
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
If (MilliSecs() < aloitus_timer + 2000) Then
Else
If (isku2 > 1) Then
        If (isku2 = 18 And (MilliSecs() > hyppy_timer2 + 90)) Then ;voltti eteen
                If (isku_frame2 = 27) Then
                        ;PlaySound nilkka_aani
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
                Else
					isku_frame2 = isku_frame2 + 1
		
					If (suunta2 = 1) Then
						If (x2 < x_reuna_a) Then x2 = x2 + 30				
					Else
						If (x2 > x_reuna_b) Then x2 = x2 - 30
					EndIf
		
					hyppy_timer2 = MilliSecs()				
                EndIf
        EndIf

        If (isku2 = 17 And (MilliSecs() > hyppy_timer2 + 90)) Then ;voltti taakse
                If (isku_frame2 = 22) Then
                        ;PlaySound nilkka_aani
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
                Else
					isku_frame2 = isku_frame2 + 1

					If (suunta2 = 1) Then
						If (x2 > x_reuna_b) Then x2 = x2 - 30			
					Else
						If (x2 < x_reuna_a) Then x2 = x2 + 30
					EndIf
		
					hyppy_timer2 = MilliSecs()				
                EndIf
        EndIf

        If (isku2 = 7 And (MilliSecs() > hyppy_timer2 + 170)) Then ;kierrepotku
                If (isku_frame2= 15) Then
                        ;PlaySound nilkka_aani        ;nilkkapotku -‰‰ni
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
						osuu2 = 1
                Else
					isku_frame2= isku_frame2+ 1
					
					hyppy_timer2 = MilliSecs()				
                EndIf
        EndIf

        If (isku2 = 4 And (MilliSecs() > hyppy_timer2 + 250)) Then ;potku ylˆs
                If (isku_frame2= 9) Then
						aani_paalle2 = 0
                        isku2 = 0
                        liike_timer2 = MilliSecs()
						osuu2 = 1
                Else
                        isku_frame2= 9
                        hyppy_timer2 = MilliSecs()
                EndIf
        EndIf

        If ((isku2 = 3) And (MilliSecs() > ukko_timer2 + 40)) Then
                If (suunta2= 1) Then
                         If (x<500) Then
                                x2= x2+ 12
                                ukko_timer2 = MilliSecs()
                        EndIf
                   Else
                         If (x2>150) Then
                                x2= x2- 12
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

If (KeyDown(n2_control) And (Not KeyDown(n2_oala)) And (Not KeyDown(n2_vala))And (Not KeyDown(n2_oyla)) And (Not KeyDown(n2_vyla)) And (Not KeyDown(n2_oikea)) And (Not KeyDown(n2_vasen))) Then aani_paalle2 = 0:valo_paalle2 = 0
If ((Not KeyDown(n2_control)) And (Not KeyDown(n2_oala)) And (Not KeyDown(n2_alas)) And (Not KeyDown(n2_vala)) And (Not KeyDown(n2_oyla)) And (Not KeyDown(n2_vyla)) And (Not KeyDown(n2_oikea)) And (Not KeyDown(n2_vasen))) Then aani_paalle2 = 0:valo_paalle2 = 0




If ((Not KeyDown(n2_oikea)) And (Not KeyDown(n2_vasen)) Or (KeyDown(n2_control))) Then	;t‰st‰ alkaa iskut ja potkut
        If (MilliSecs() > liike_timer2 + 100) Then
                        isku2 = 0
                        If (KeyDown(n2_control)) Then                ;napin kanssa liikkeet alkaa...
                                isku_frame2= 3
                                isku2 = 1
                                ei_mitaan_timer2 = MilliSecs()
                        If (KeyDown(n2_oala)) Then
	                           isku_frame2= 4
    	                       isku2 = 1 

								suunta2= 0
						
                              	If (aani_paalle2 <> 4) Then
                                        PlaySound nilkka_aani        ;nilkkapotku -‰‰ni
                                        aani_paalle2 = 4
 		                        EndIf
                        Else If (KeyDown(n2_vala)) Then
	                            isku_frame2= 4
  	                            isku2 = 1
  								suunta2= 1
  
								osu_xh2 = 100
								osu_xf2 = 80
								
                            	If (aani_paalle2 <> 4) Then
                                        PlaySound nilkka_aani        ;nilkkapotku -‰‰ni
                                        aani_paalle2 = 4
 		                        EndIf
                        Else If (KeyDown(n2_oikea)) Then
	         	           			If(suunta2= 1) Then
									    isku_frame2= 6
        	                            isku2 = 1
										osuu2 = 1
										liike_timer2 = MilliSecs()
										
										osu_xh2 = 120
										osu_xf2 = 110
           	                        If (aani_paalle2 <> 6) Then
                	                           PlaySound mahapotku_aani        ;mahapotku -‰‰ni
                                               aani_paalle2 = 6
                                        EndIf
									Else
										isku_frame2= 13
										isku2 = 7
										hyppy_timer2 = MilliSecs()
										ei_mitaan_timer2 = MilliSecs()
										PlaySound mahapotku_aani        ;mahapotku -‰‰ni
                    	                aani_paalle2 = 6
									EndIf
                        Else If (KeyDown(n2_ylos) And (MilliSecs() > hyppy_alas_timer2+200)) Then ;Hyppypotku.
                                isku_frame2= 7
                                isku2 = 3
                                hyppy_timer2 = MilliSecs()


								osu_xh2 = 80
								osu_xf2 = 70
			
                                If (aani_paalle2 <> 6) Then
                                      PlaySound mahapotku_aani        ;mahapotku -‰‰ni
                                      aani_paalle2 = 6
                                 EndIf

                        Else If (KeyDown(n2_vasen)) Then		;--- kierrepotkua
	         	           			If(suunta2= 0) Then
									    isku_frame2= 6
        	                            isku2 = 1
										osuu2 = 1
										liike_timer2 = MilliSecs()
            	                        If (aani_paalle2 <> 6) Then
                	                           PlaySound mahapotku_aani        ;mahapotku -‰‰ni
                                               aani_paalle2 = 6
                                        EndIf
									Else
										isku_frame2= 13
										isku2 = 7
										osuu2 = 1 ; !
										hyppy_timer2 = MilliSecs()
										ei_mitaan_timer2 = MilliSecs()
										PlaySound mahapotku_aani        ;mahapotku -‰‰ni
                    	                aani_paalle2 = 6
									EndIf
                        Else If (KeyDown(n2_oyla) And voltti2 = 0) Then		;--- voltti taaksep‰in
								If (suunta2= 0) Then
									isku_frame2= 22
									voltti2 = 1
									isku2 = 18
								Else
									isku_frame2= 16
									voltti2 = 1
									isku2 = 17
								EndIf

								hyppy_timer2 = MilliSecs()
								ei_mitaan_timer2 = MilliSecs()
								PlaySound mahapotku_aani
                                aani_paalle2 = 6

                        Else If (KeyDown(n2_vyla) And voltti2 = 0) Then		;--- voltti eteenp‰in
								If (suunta2= 0) Then
									isku_frame2= 16
									voltti2 = 1
									isku2 = 17
								Else
									isku_frame2= 22
									voltti2 = 1
									isku2 = 18
								EndIf
								hyppy_timer2 = MilliSecs()
								ei_mitaan_timer2 = MilliSecs()
								PlaySound mahapotku_aani
                                aani_paalle2 = 6

                        Else If (KeyDown(n2_alas) And alas_nollaus2 = 0) Then				;Maha - k‰‰ntˆ
								alas_nollaus2 = 1
								If (suunta2= 0) Then
                                isku_frame2= 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2 = 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        PlaySound nilkka_aani
                                        aani_paalle2 = 4
                                EndIf

								suunta2= 1
								Else
                                isku_frame2= 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2 = 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        PlaySound nilkka_aani
                                        aani_paalle2 = 4
                                EndIf
								suunta2= 0
								EndIf
                        
						Else If Not KeyDown(n2_alas) Then 
							alas_nollaus2 = 0
						EndIf

						;Ilman controllia tulevat iskut alkaa t‰st‰.
                        Else If (KeyDown(n2_oyla)) Then	
                                isku_frame2= 5
                                isku2 = 1
								osuu2 = 1 ; !

								osu_xh2 = 60
								osu_xf2 = 70

                                ei_mitaan_timer2 = MilliSecs()

								suunta2= 0
                                If (aani_paalle2 <> 4) Then
                                	PlaySound nilkka_aani                 ;kasvoisku2 -‰‰ni
                                EndIf
                                 aani_paalle2 = 4
                        Else If (KeyDown(n2_alas)) Then
                                isku_frame2= 2
                                isku2 = 1
								osuu2 = 1 ; !
                                ei_mitaan_timer2 = MilliSecs()

                                If (aani_paalle2 <> 88) Then
                                        PlaySound nilkka_aani                 ;kasvoisku2 -‰‰ni
                                        aani_paalle2 = 88
                                EndIf

                        Else If (KeyDown(n2_ylos) And (MilliSecs() > hyppy_alas_timer2+200)) Then
                                isku_frame2= 1
                                isku2 = 2
                                hyppy_timer2 = MilliSecs()
                                ei_mitaan_timer2 = MilliSecs()

                        Else If (KeyDown(n2_oala)) Then				;Mahaisku.
								If (suunta2= 0) Then

                                isku_frame2= 8
                                isku2 = 4
                                hyppy_timer2 = MilliSecs()
                                ei_mitaan_timer2 = MilliSecs()
                                If (aani_paalle2 <> 6) Then
                                        PlaySound mahapotku_aani
                                        aani_paalle2 = 6
                                EndIf
								Else
                                isku_frame2= 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2 = 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        PlaySound nilkka_aani                 ;kasvoisku2 -‰‰ni
                                        aani_paalle2 = 4
                                EndIf
								EndIf
                       Else If (KeyDown(n2_vyla)) Then				;isku2 ylˆs.
                                isku_frame2= 5
                                isku2 = 1
								osuu2 = 1
								suunta2= 1

								osu_xhs2 = 60 ;-30
								osu_xfs2 = 40 ;-20
								
                                ei_mitaan_timer2 = MilliSecs()
                                If (aani_paalle2 <> 4) Then
                                        PlaySound nilkka_aani                 ;kasvoisku2 -‰‰ni
                                EndIf
                                aani_paalle2 = 4
                        Else If (KeyDown(n2_oala)) Then				;Potku ylˆs.
								If (suunta2= 1) Then

                                isku_frame2= 8
                                isku2 = 4
                                hyppy_timer2 = MilliSecs()
                                ei_mitaan_timer2 = MilliSecs()
                                If (aani_paalle2 <> 6) Then
                                        PlaySound mahapotku_aani
                                        aani_paalle2 = 6
                                EndIf
									Else
                                isku_frame2= 0
                                isku2 = 1
								osu_xh2 = 110
								osu_xf2 = 100

                                ei_mitaan_timer2 = MilliSecs()
								osuu2 = 1
								If (aani_paalle2 <> 4) Then
                                        PlaySound nilkka_aani                 ;kasvoisku2 -‰‰ni
                                        aani_paalle2 = 4
                                EndIf

								EndIf
                        EndIf                                                ;...t‰h‰n

liike_timer2 = MilliSecs()
EndIf
EndIf ;liikkeiden loppu...

;K‰vely alkaa
                        If ((Not KeyDown(n2_control)) And (JoyDown(2) = 0) And KeyDown(kavely_oikea2) And x2<x_reuna_a) Then
;oikealle
								isku2 = 0
                                aani_paalle2 = 0
                                If (MilliSecs() > ukko_timer2+100) Then
                                        ukko_timer2 = MilliSecs()
                                        ukko_frame2 = ukko_frame2 + 1
                                        If (ukko_frame2 = 4) Then ukko_frame2 = 0
                                        x2= x2+ 10
                                        ei_mitaan_timer2 = MilliSecs()
                                EndIf
                        EndIf

                        If ((Not KeyDown(n2_control)) And (JoyDown(2) = 0) And KeyDown(kavely_vasen2) And x2>x_reuna_b) Then  
;vasemmalle
								isku2 = 0
                                aani_paalle2 = 0
                                If (MilliSecs() > ukko_timer2+100) Then
                                        ukko_timer2 = MilliSecs()
                                        ukko_frame2 = ukko_frame2 - 1
                                        If (ukko_frame2 = -1) Then ukko_frame2 = 3
                                        x2= x2- 10
                                        ei_mitaan_timer2 = MilliSecs()
                                EndIf
                        EndIf
                        ;K‰vely loppuu
EndIf

;Color 255,100,200
;Text 100,100,isku_frame

If ((MilliSecs() > ei_mitaan_timer2 + 8000) And (MilliSecs() < ei_mitaan_timer2 + 10000)) Then
                If (MilliSecs() > hyppy_timer2 + 200) Then
                        If (isku_frame2 <> 11) Then
                                isku_frame2= 11
                        Else
                                isku_frame2= 10
                        EndIf
                        hyppy_timer2 = MilliSecs()
                EndIf
                If (suunta2= 0) Then                                        ;
                        DrawImage iskuja2,x2,y2,isku_frame2               ;
                Else                                                                        ;
                        DrawImage iskuja_ts2,x2,y2,isku_frame2       ;
                EndIf                                                                        ;
Else
                If (isku2 = 0) Then
                        If (suunta2= 0) Then                                        ;
                                DrawImage ukko2,x2,y2,ukko_frame2
                        Else
                                DrawImage ukko_ts2,x2,y2,ukko_frame2
                        EndIf
                Else
                        If (suunta2 = 0) Then                                        ;
                                DrawImage iskuja2,x2,y2,isku_frame2               ;
                        Else                                                                        ;
                                DrawImage iskuja_ts2,x2,y2,isku_frame2       ;
                        EndIf                                                                        ;
                EndIf
EndIf

EndIf


EndIf ;osumien endif

If (MilliSecs() > ei_mitaan_timer2 + 10000) Then ei_mitaan_timer2 = MilliSecs()

End Function