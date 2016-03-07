;-----------


Function hits()
;ei pisteitä demo-modessa
If (cpu_vai_ei <> 10) Then
	Text 400,70,"LEVEL" + level,1,0
	Text 80,25,pisteet1
	Text 300,25,pisteet3
	Text 550,25,pisteet2
EndIf

;valkoinen ukko lyö punaiseen
If (osuma2 = 0) Then
	If (isku_frame = 5) Then p1 = 800
	If (isku_frame = 6) Then p1 = 200
	If (isku_frame = 4) Then p1 = 200
	If (isku_frame = 3) Then p1 = 400
	If (isku_frame = 2) Then p1 = 400
	If (isku_frame = 7) Then p1 = 1000
	If (isku_frame = 15) Then p1 = 800
	If (isku_frame = 0) Then p1 = 400
	If (isku_frame = 9) Then p1 = 800
			
	If ((osuu = 1) And (Not KeyDown(n2_control))) Then
		If ((x < x2) And (suunta = 0) And isku_frame <> 1 And isku_frame < 13 Or isku_frame > 14) Then
			If (((isku2 = 0) And (ImagesCollide (iskuja,x,y,isku_frame,ukko2,x2,y,ukko_frame2))) Or ((isku2 = 1) And (ImagesCollide (iskuja,x,y,isku_frame,iskuja2,x2,y,isku_frame2)))) Then
				If ((x2 - x) < osu_xh) Then
					If (((x2 - x) < osu_xf) And ((x2 - x) > (osu_xf-20))) Then

						Delay 50
						If (valo_paalle = 0) Then lights = lights + 2
						valo_paalle = 1
						osuma2 = 1
						osuma2_timer = MilliSecs() -150
						osuma2_frame = 0
						
						If isku_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf

						stars_frame_timer = MilliSecs()
						stars_frame = 0		
						
						suunnat2 = suunta

						pisteet1 = pisteet1 + p1

					Else 
					If (x2 - x > (osu_xf-40)) Then
						Delay 50
						If (valo_paalle = 0) Then lights = lights + 1
						valo_paalle = 1
						osuma2 = 2
						osuma2_timer = MilliSecs() -150
						osuma2_frame = 0
						
						If isku_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf

						pisteet1 = pisteet1 + p1/2

						suunnat2 = suunta	
					EndIf

					EndIf
				EndIf
			EndIf
		Else If ((x > x2) And (suunta = 1) And isku_frame > 1 And isku_frame < 13 Or isku_frame > 14) Then
			If (((isku2 = 0) And (ImagesCollide (iskuja,x,y,isku_frame,ukko2,x2,y,ukko_frame2))) Or ((isku2 = 1) And (ImagesCollide (iskuja,x,y,isku_frame,iskuja2,x2,y,isku_frame2)))) Then
				If ((x - x2) < osu_xhs) Then
					If (((x - x2) < osu_xfs) And ((x - x2) > (osu_xfs-20))) Then
						Delay 50
						If (valo_paalle = 0) Then lights = lights + 2
						valo_paalle = 1
						osuma2 = 1
						osuma2_timer = MilliSecs()-150
						osuma2_frame = 0
						pisteet1 = pisteet1 + p1

						If isku_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf
					Else			
						Delay 50
						If (valo_paalle = 0) Then lights = lights + 1
						valo_paalle = 1
						osuma2 = 2
						osuma2_timer = MilliSecs()-150
						osuma2_frame = 0

						pisteet1 = pisteet1 + p1/2

						suunnat2 = suunta
						
					EndIf
					
						If isku_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf

					stars_frame_timer = MilliSecs()
					stars_frame = 0

					suunnat2 = suunta
				
				EndIf
			EndIf
		EndIf
	EndIf
EndIf













;--------------------------valkoinen osuu cpu:hun
If (osuma3 = 0) Then
	If (isku_frame = 5) Then p1 = 800
	If (isku_frame = 6) Then p1 = 200
	If (isku_frame = 4) Then p1 = 200
	If (isku_frame = 3) Then p1 = 400
	If (isku_frame = 2) Then p1 = 400
	If (isku_frame = 7) Then p1 = 1000
	If (isku_frame = 15) Then p1 = 800
	If (isku_frame = 0) Then p1 = 400
	If (isku_frame = 9) Then p1 = 800
			
	If ((osuu = 1) );And (Not (act2 = (n_control_cpu)))) Then
		If ((x < x3) And (suunta = 0) And isku_frame <> 1 And isku_frame < 13 Or isku_frame > 14) Then
			If (((isku3 = 0) And (ImagesCollide (iskuja,x,y,isku_frame,ukko3,x3,y,ukko3_frame))) Or ((isku3 = 1) And (ImagesCollide (iskuja,x,y,isku_frame,iskuja3,x3,y,isku3_frame)))) Then
				If ((x3 - x) < osu_xh) Then
					If (((x3 - x) < osu_xf) And ((x3 - x) > (osu_xf-20))) Then
						Delay 50
						If (valo_paalle = 0) Then lights = lights + 2
						valo_paalle = 1
						osuma3 = 1
						osuma3_timer = MilliSecs() -150
						osuma3_frame = 0
						
						If isku_frame < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf

						stars_frame_timer = MilliSecs()
						stars_frame = 0		
						
						suunnat3 = suunta_c

						pisteet1 = pisteet1 + p1

					Else 
					If (x3 - x > (osu_xf-40)) Then
						Delay 50
						If (valo_paalle = 0) Then lights = lights + 1
						valo_paalle = 1
						osuma3 = 2
						osuma3_timer = MilliSecs() -150
						osuma3_frame = 0
						
						If isku_frame < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf

						pisteet1 = pisteet1 + p1/2

						suunnat3 = suunta_c
					EndIf

					EndIf
				EndIf
			EndIf
		Else If ((x > x3) And (suunta = 1) And isku_frame > 1 And isku_frame < 13 Or isku_frame > 14) Then
			If (((isku3 = 0) And (ImagesCollide (iskuja,x,y,isku_frame,ukko3,x3,y,ukko3_frame))) Or ((isku3 = 1) And (ImagesCollide (iskuja,x,y,isku_frame,iskuja3,x3,y,isku3_frame)))) Then
				If ((x - x3) < osu_xhs) Then
					If (((x - x3) < osu_xfs) And ((x - x3) > (osu_xfs-20))) Then
						Delay 50
						If (valo_paalle = 0) Then lights = lights + 2
						valo_paalle = 1
						osuma3 = 1
						osuma3_timer = MilliSecs()-150
						osuma3_frame = 0
						pisteet1 = pisteet1 + p1

						If isku_frame < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf
					Else			
						Delay 50
						If (valo_paalle = 0) Then lights = lights + 1
						valo_paalle = 1
						osuma3 = 2
						osuma3_timer = MilliSecs()-150
						osuma3_frame = 0

						pisteet1 = pisteet1 + p1/2

						suunnat3 = suunta_c
						
					EndIf
					
						If isku_frame < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf

					stars_frame_timer = MilliSecs()
					stars_frame = 0

					suunnat3 = suunta_c
				
				EndIf
			EndIf
		EndIf
	EndIf
EndIf




;--------------------------punainen osuu cpu:hun
If (osuma3 = 0) Then

;osu_xh2 = osu_xh2 - 70
;osu_xf2 = osu_xf2 - 70

	If (isku_frame2 = 5) Then p2 = 800
	If (isku_frame2 = 6) Then p2 = 200
	If (isku_frame2 = 4) Then p2 = 200
	If (isku_frame2 = 3) Then p2 = 400
	If (isku_frame2 = 2) Then p2 = 400
	If (isku_frame2 = 7) Then p2 = 1000
	If (isku_frame2 = 15) Then p2 = 800
	If (isku_frame2 = 0) Then p2 = 400
	If (isku_frame2 = 9) Then p2 = 800
			
	If ((osuu2 = 1) );And (Not (act2 = (n_control_cpu)))) Then
		If ((x2 < x3) And (suunta2 = 1) And isku_frame2 <> 1 And isku_frame2 < 13 Or isku_frame2 > 14) Then
			If (((isku3 = 0) And (ImagesCollide (iskuja2,x2,y,isku_frame2,ukko3,x3,y,ukko3_frame))) Or ((isku3 = 1) And (ImagesCollide (iskuja2,x2,y,isku_frame2,iskuja3,x3,y,isku3_frame)))) Then
				If ((x3 - x2) < osu_xh2) Then
					If (((x3 - x2) < osu_xf2) And ((x3 - x2) > (osu_xf2-20))) Then
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 2
						valo_paalle2 = 1
						osuma3 = 1
						osuma3_timer = MilliSecs() -150
						osuma3_frame = 0
						
						If isku_frame2 < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf

						stars_frame_timer = MilliSecs()
						stars_frame = 0		
						
						suunnat3 = suunta_c

						pisteet2 = pisteet2 + p2

					Else 
					If (x3 - x2 > (osu_xf2-40)) Then
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 1
						valo_paalle2 = 1
						osuma3 = 2
						osuma3_timer = MilliSecs() -150
						osuma3_frame = 0
						
						If isku_frame2 < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf

						pisteet2 = pisteet2 + p2/2

						suunnat3 = suunta_c
					EndIf

					EndIf
				EndIf
			EndIf			
		Else If ((x2 > x3) And (suunta2 = 0) And isku_frame2 <> 1 And isku_frame2 < 13 Or isku_frame2 > 14) Then
			If (((isku3 = 0) And (ImagesCollide (iskuja2,x2,y,isku_frame2,ukko3,x3,y,ukko3_frame))) Or ((isku3 = 1) And (ImagesCollide (iskuja2,x2,y,isku_frame2,iskuja3,x3,y,isku3_frame)))) Then
				If ((x2 - x3) < osu_xhs2) Then
					If (((x2 - x3) < osu_xfs2) And ((x2 - x3) > (osu_xfs2-20))) Then
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 2
						valo_paalle2 = 1
						osuma3 = 1
						osuma3_timer = MilliSecs()-150
						osuma3_frame = 0
						pisteet2 = pisteet2 + p2

						If isku_frame2 < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf
					Else			
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 1
						valo_paalle2 = 1
						osuma3 = 2
						osuma3_timer = MilliSecs()-150
						osuma3_frame = 0

						pisteet2 = pisteet2 + p2/2

						suunnat3 = suunta_c
						
					EndIf
					
						If isku_frame2 < 4 Then
							osuma3_frame = 6
							osuma3_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma3_frame = 0
							osuma3_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma3_frame = 3
							osuma3_aloitus = 3
						EndIf

					stars_frame_timer = MilliSecs()
					stars_frame = 0

					suunnat3 = suunta_c
				
				EndIf
			EndIf
		EndIf
	EndIf
EndIf





;------------------------------------------------------ alkaa
;punainen ukko lyö valkoiseen

If (osuma = 0) Then
	If (isku_frame2 = 5) Then p2 = 800
	If (isku_frame2 = 6) Then p2 = 200
	If (isku_frame2 = 4) Then p2 = 200
	If (isku_frame2 = 3) Then p2 = 400
	If (isku_frame2 = 2) Then p2 = 400
	If (isku_frame2 = 7) Then p2 = 1000
	If (isku_frame2 = 15) Then p2 = 800
	If (isku_frame2 = 0) Then p2 = 400
	If (isku_frame2 = 9) Then p2 = 800

	If ((osuu2 = 1) And (Not KeyDown(n_control))) Then
		If ((x < x2) And (suunta2 = 0) And isku_frame2 <> 1 And isku_frame2< 13 Or isku_frame2 > 14) Then
			If (((isku = 0) And (ImagesCollide (iskuja2,x2,y,isku_frame2,ukko,x,y,ukko_frame))) Or ((isku = 1) And (ImagesCollide (iskuja2,x2,y,isku_frame2,iskuja,x,y,isku_frame)))) Then
				If ((x - x2) < osu_xh2) Then
					If (((x - x2) < osu_xf2) And ((x - x2) > (osu_xf2-20))) Then
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 2
						valo_paalle2 = 1
						osuma = 1
						osuma_timer = MilliSecs() -150
						osuma_frame = 0
						
						If isku_frame2 < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf

						stars_frame_timer = MilliSecs()
						stars_frame = 0		

						pisteet2 = pisteet2 + p2

						
						suunnat = suunta2

					Else 
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 1
						valo_paalle2 = 1
						osuma = 2
						osuma_timer = MilliSecs() -150
						osuma_frame = 0
						
						If isku_frame2 < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf
						
						pisteet2 = pisteet2 + p2/2

						suunnat = suunta2

					EndIf
				EndIf
			EndIf
		Else If ((x > x2) And (suunta2 = 1)) Then
			If (((isku = 0) And (ImagesCollide (iskuja2,x2,y,isku_frame2,ukko,x,y,ukko_frame))) Or ((isku = 1) And (ImagesCollide (iskuja2,x2,y,isku_frame2,iskuja,x,y,isku_frame)))) Then		
				If ((x2 - x) < osu_xhs2) Then
					If (((x2 - x) < osu_xfs2) And ((x2 - x) > (osu_xfs2-20))) Then
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 2
						valo_paalle2 = 1
						osuma = 1
						osuma_timer = MilliSecs()-150
						osuma_frame = 0
						pisteet2 = pisteet2 + p2

						If isku_frame2 < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf
					Else			
						Delay 50
						If (valo_paalle2 = 0) Then lights2 = lights2 + 1
						valo_paalle2 = 1
						osuma = 2
						osuma_timer = MilliSecs()-150
						osuma_frame = 0

						pisteet2 = pisteet2 + p2/2

						suunnat = suunta2
						
					EndIf
					
						If isku_frame2 < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku_frame2 = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku_frame2 > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf

					stars_frame_timer = MilliSecs()
					stars_frame = 0

					suunnat = suunta2
				
				EndIf
			EndIf
		EndIf
	EndIf
EndIf

;End Function


;------------------------------------------------loppuu






;------------------------------------------------------ alkaa
;-----		cpu osuu valkoiseen
If (osuma = 0) Then
	If (isku3_frame = 5) Then p3 = 800
	If (isku3_frame = 6) Then p3 = 200
	If (isku3_frame = 4) Then p3 = 200
	If (isku3_frame = 3) Then p3 = 400
	If (isku3_frame = 2) Then p3 = 400
	If (isku3_frame = 7) Then p3 = 1000
	If (isku3_frame = 15) Then p3 = 800
	If (isku3_frame = 0) Then p3 = 400
	If (isku3_frame = 9) Then p3 = 800

	If ((osuu3 = 1) And (Not KeyDown(n_control))) Then
		If ((x < x3) And (suunta_c = 0) And isku3_frame <> 1 And isku3_frame< 13 Or isku3_frame > 14) Then
			If (((isku = 0) And (ImagesCollide (iskuja3,x3,y,isku3_frame,ukko,x,y,ukko_frame))) Or ((isku = 1) And (ImagesCollide (iskuja3,x3,y,isku3_frame,iskuja,x,y,isku_frame)))) Then
				If ((x - x3) < osu_xh3) Then
					If (((x - x3) < osu_xf3) And ((x - x3) > (osu_xf3-20))) Then
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 2
						valo_paalle3 = 1
						osuma = 1
						osuma_timer = MilliSecs() -150
						osuma_frame = 0
						
						If isku3_frame < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf

						stars_frame_timer = MilliSecs()
						stars_frame = 0		

						pisteet3 = pisteet3 + p3

						
						suunnat3 = suunta_c

					Else 
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 1
						valo_paalle3 = 1
						osuma = 2
						osuma_timer = MilliSecs() -150
						osuma_frame = 0
						
						If isku3_frame < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf
						
						pisteet3 = pisteet3 + p3/2

						suunnat3 = suunta_c

					EndIf
				EndIf
			EndIf
		Else If ((x > x3) And (suunta_c = 1)) Then
			If (((isku = 0) And (ImagesCollide (iskuja3,x3,y,isku3_frame,ukko,x,y,ukko_frame))) Or ((isku = 1) And (ImagesCollide (iskuja3,x3,y,isku3_frame,iskuja,x,y,isku_frame)))) Then		
				If ((x3 - x) < osu_xhs3) Then
					If (((x3 - x) < osu_xfs3) And ((x3 - x) > (osu_xfs3-20))) Then
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 2
						valo_paalle3 = 1
						osuma = 1
						osuma_timer = MilliSecs()-150
						osuma_frame = 0
						pisteet3 = pisteet3 + p3
	
						If isku3_frame < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf
					Else			
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 1
						valo_paalle3 = 1
						osuma = 2
						osuma_timer = MilliSecs()-150
						osuma_frame = 0

						pisteet3 = pisteet3 + p3/2

						suunnat3 = suunta_c
						
					EndIf
					
						If isku3_frame < 4 Then
							osuma_frame = 6
							osuma_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma_frame = 0
							osuma_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma_frame = 3
							osuma_aloitus = 3
						EndIf

					stars_frame_timer = MilliSecs()
					stars_frame = 0

					suunnat3 = suunta_c
				
				EndIf
			EndIf
		EndIf
	EndIf
EndIf



;------------------------------------------------loppuu
;------------------------------------------------------ alkaa
;-----		cpu osuu punaiseen
If (osuma2 = 0) Then
	If (isku3_frame = 5) Then p3 = 800
	If (isku3_frame = 6) Then p3 = 200
	If (isku3_frame = 4) Then p3 = 200
	If (isku3_frame = 3) Then p3 = 400
	If (isku3_frame = 2) Then p3 = 400
	If (isku3_frame = 7) Then p3 = 1000
	If (isku3_frame = 15) Then p3 = 800
	If (isku3_frame = 0) Then p3 = 400
	If (isku3_frame = 9) Then p3 = 800

	If ((osuu3 = 1) And (Not KeyDown(n2_control))) Then
		If ((x2 < x3) And (suunta_c = 0) And isku3_frame <> 1 And isku3_frame< 13 Or isku3_frame > 14) Then	
			If (((isku2 = 0) And (ImagesCollide (iskuja3,x3,y,isku3_frame,ukko2,x2,y,ukko_frame2))) Or ((isku = 1) And (ImagesCollide (iskuja3,x3,y,isku3_frame,iskuja2,x2,y,isku_frame2)))) Then
				If ((x2 - x3) < osu_xh3) Then
					If (((x2 - x3) < osu_xf3) And ((x2 - x3) > (osu_xf3-20))) Then
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 2
						valo_paalle3 = 1
						osuma2 = 1
						osuma2_timer = MilliSecs() -150
						osuma2_frame = 0
						
						If isku3_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf

						stars_frame_timer = MilliSecs()
						stars_frame = 0		

						pisteet3 = pisteet3 + p3

						
						suunnat3 = suunta_c

					Else 
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 1
						valo_paalle3 = 1
						osuma2 = 2
						osuma2_timer = MilliSecs() -150
						osuma2_frame = 0
						
						If isku3_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf
						
						pisteet3 = pisteet3 + p3/2

						suunnat3 = suunta_c

					EndIf
				EndIf
			EndIf
		Else If ((x2 > x3) And (suunta_c = 1)) Then
			If (((isku2 = 0) And (ImagesCollide (iskuja3,x3,y,isku3_frame,ukko2,x2,y,ukko_frame2))) Or ((isku = 1) And (ImagesCollide (iskuja3,x3,y,isku3_frame,iskuja2,x2,y,isku_frame2)))) Then
				If ((x3 - x2) < osu_xhs3) Then
					If (((x3 - x2) < osu_xfs3) And ((x3 - x2) > (osu_xfs3-20))) Then
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 2
						valo_paalle3 = 1
						osuma2 = 1
						osuma2_timer = MilliSecs()-150
						osuma2_frame = 0
						pisteet3 = pisteet3 + p3
	
						If isku3_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf
					Else			
						Delay 50
						If (valo_paalle3 = 0) Then lights3 = lights3 + 1
						valo_paalle3 = 1
						osuma2 = 2
						osuma2_timer = MilliSecs()-150
						osuma2_frame = 0

						pisteet3 = pisteet3 + p3/2

						suunnat3 = suunta_c
						
					EndIf
					
						If isku3_frame < 4 Then
							osuma2_frame = 6
							osuma2_aloitus = 6
						Else If isku3_frame = 4 Then
							osuma2_frame = 0
							osuma2_aloitus = 0
						Else If isku3_frame > 4 Then
							osuma2_frame = 3
							osuma2_aloitus = 3
						EndIf

					stars_frame_timer = MilliSecs()
					stars_frame = 0

					suunnat3 = suunta_c
				
				EndIf
			EndIf
		EndIf
	EndIf
EndIf

siirtymat()

End Function
;------------------------------------------------loppuu



Function valot()
valo_paalle = 0
valo_paalle2 = 0
valo_paalle3 = 0
;VAL---
	valo_x = 115
	i = 0

	While (i < 6)
		valo_x = valo_x + 15
		DrawImage valo_pois,valo_x,27
		i = i + 1
	Wend

	valo_x = 115
	i = 0
	
	If (lights > 6) Then lights = 6

	While (i < lights)
		valo_x = valo_x + 15
		DrawImage valo,valo_x,27
		i = i + 1
	Wend
;------
;PUN---
	valo_x = 615
	i = 0

	While (i < 6)
		valo_x = valo_x + 15
		DrawImage valo_pois,valo_x,27
		i = i + 1
	Wend

	valo_x = 615
	i = 0
	
	If (lights2 > 6) Then lights2 = 6

	While (i < lights2)
		valo_x = valo_x + 15
		DrawImage valo,valo_x,27
		i = i + 1
	Wend
;------	
;CPU---
	valo_x = 355
	i = 0

	While (i < 6)
		valo_x = valo_x + 15
		DrawImage valo_pois,valo_x,27
		i = i + 1
	Wend

	valo_x = 355
	i = 0
	
	If (lights3 > 6) Then lights3 = 6

	While (i < lights3)
		valo_x = valo_x + 15
		DrawImage valo,valo_x,27
		i = i + 1
	Wend
;------	
End Function


Function nollaus()
		Delay 100
		aloitus_timer = MilliSecs()
		sekunnit = 60
		lights = 0 : lights2 = 0 : lights3 = 0
		osuma = 0 : osuma2 = 0 : osuma3 = 0 : siirr = 0 : boonus = 0
		suunta = 0
		
		Select cpu_vai_ei
		Case 0
			x = 100 : x3 = 580
		Case 1
			x = 100 : x2 = 580				
		Case 2,3,4
			x = 100 : x2 = 580 : x3 = 300
		End Select
End Function

Function siirtymat()
	;alun kumarrus
	If (MilliSecs() < aloitus_timer + 1000) Then
		If (boonus = 0) Then
	        If (cpu_vai_ei < 9) Then DrawImage aloitus,x,y,0
	        If (cpu_vai_ei > 0) Then DrawImage aloitus2,x2,y2,0
	        If (cpu_vai_ei > 1) Then DrawImage aloitus3,x3,y2,0
	        If (cpu_vai_ei = 0) Then DrawImage aloitus3b,x3,y2,0
		EndIf
	Else If (MilliSecs() < aloitus_timer + 1500) Then
		If (boonus = 0) Then
	        If (cpu_vai_ei < 9) Then DrawImage aloitus,x,y,1
	        If (cpu_vai_ei > 0) Then DrawImage aloitus2,x2,y2,1
	        If (cpu_vai_ei > 1) Then DrawImage aloitus3,x3,y2,1
	        If (cpu_vai_ei = 0) Then DrawImage aloitus3b,x3,y2,1
		EndIf
	Else If (MilliSecs() < aloitus_timer + 2000) Then
		If (boonus = 0) Then
	        If (cpu_vai_ei < 9) Then DrawImage aloitus,x,y,0
	        If (cpu_vai_ei > 0) Then DrawImage aloitus2,x2,y2,0
	        If (cpu_vai_ei > 1) Then DrawImage aloitus3,x3,y2,0
	        If (cpu_vai_ei = 0) Then DrawImage aloitus3b,x3,y2,0
	        kello = MilliSecs() 
		EndIf
	EndIf


	If ((lights2 > 5 Or lights > 5 Or lights3 > 5) Or sekunnit = 0) Then
		; PELAAJAMÄÄRÄ MUUTTUU JOS JOKU TIPPUU PELISTÄ
		;		cpu_vai_ei = 2  = valkoinen ja (vihree + punainen CPU)	
		;		cpu_vai_ei = 4  = punainen ja (vihree + valkoinen CPU???)
		If (cpu_vai_ei = 2) Then 
			If (lights < lights2 And lights < lights3) Then
				cpu_vai_ei = 10 :nollaus()
				hall_of_fame()
			EndIf
		EndIf
		If (cpu_vai_ei = 4) Then 
			If (lights2 < lights And lights2 < lights3) Then
				cpu_vai_ei = 10 :nollaus()
				hall_of_fame()
			EndIf
		EndIf
	
		If (cpu_vai_ei = 3) Then ;jos kaksi ihmispelaajaa ja CPU			
			If (lights < lights2 And lights < lights3) Then
				cpu_vai_ei = 4
			EndIf
			If (lights2 < lights And lights2 < lights3) Then
				cpu_vai_ei = 2
			EndIf
		EndIf
		
		If (cpu_vai_ei = 0) Then
			If (lights < lights3) Then hall_of_fame : nollaus() : cpu_vai_ei = 10
		EndIf
	
;		If (cpu_vai_ei = 10) Then 
	
			If (siirr = 0) Then 
				siirrys = MilliSecs()			;hidastettu siirtymä seuraavaan leveliin
				siirr = 1
			EndIf
;		EndIf
	EndIf

	If sekunnit < 1 And siirr <> 6 Then
		siirr = 1
	EndIf

	If (siirr = 1 And MilliSecs() > siirrys + 2300) Then
		If (lights2 = 6) Then pisteet2 = pisteet2 + (sekunnit*50)
		If (lights = 6) Then pisteet1 = pisteet1 + (sekunnit*50)
		level = level + 1
		siirr = 0
		nollaus()
		If (level > 3) Then siirr = 6
	EndIf

	If (siirr = 6) Then	
		nollaus()
		siirrys = MilliSecs()			;hidastettu siirtymä seuraavaan leveliin
		siirr = 3
	EndIf
		
	If (siirr = 3 And MilliSecs() > siirrys + 300) Then
		If ((pisteet1 - alkupisteet1) > (pisteet2 - alkupisteet2)) Then   ;kumpi ukko pääsee bonukseen
			bonusmies = 1
		Else
			bonusmies = 2
		EndIf 
		nollaus()
		jump_in_japan_alustus()
		siirr = 4
		boonus = 2
	EndIf
	;EndIf

;	If (siirr = 4) Then
;		While Not KeyHit(1)
;		Cls
;			tiles()
;		Flip
;		Wend
;	EndIf


	If (siirr = 5) Then
		seur = 1
		nollaus()
		level = 1
	EndIf
	
	If KeyDown(47) Then siirr = 3 : Delay 100 :FlushKeys() ;oiko
	
	
End Function
